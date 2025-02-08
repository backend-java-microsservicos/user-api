package mz.co.muianga.userapi.service;

import mz.co.muianga.shoppingclient.dto.UserDTO;
import mz.co.muianga.shoppingclient.exception.UserNotFoundException;
import mz.co.muianga.userapi.converter.DTOConverter;
import mz.co.muianga.userapi.model.User;
import mz.co.muianga.userapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAll() {
        List<User> usuarios = userRepository.findAll();
        return usuarios.stream()
                .map(DTOConverter::convert)
                .toList();

    }

    public UserDTO findById(Long id) {
        Optional<User> usuario = userRepository.findById(id);
        return usuario.map(DTOConverter::convert).orElse(null);

    }

    public UserDTO save(UserDTO userDTO) {
        userDTO.setKey(UUID.randomUUID().toString());
        userDTO.setDataCadastro(new Date());
        return DTOConverter.convert(userRepository.save(DTOConverter.convert(userDTO)));
    }

    public UserDTO delete(long id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);

        return null;
    }

    public UserDTO findByCpf(String cpf, String key) {
        var user = userRepository.findByCpfAndKey(cpf, key);
        if (user != null) {
            return DTOConverter.convert(user);
        }
        throw new UserNotFoundException();
    }

    public List<UserDTO> queryByName(String name) {
        List<User> usuarios = userRepository.queryByNomeLike(name);
        return usuarios.stream()
                .map(DTOConverter::convert)
                .toList();
    }
}
