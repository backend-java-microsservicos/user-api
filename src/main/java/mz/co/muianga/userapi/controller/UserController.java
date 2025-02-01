package mz.co.muianga.userapi.controller;

import jakarta.annotation.PostConstruct;
import mz.co.muianga.userapi.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    public static List<UserDTO> usuarios = new ArrayList<>();

    @GetMapping
    public List<UserDTO> getUsers() {
        return usuarios;
    }

    @GetMapping("/{cpf}")
    public UserDTO getUsersFiltro(@PathVariable("cpf") String cpf) {
        for (UserDTO userFilter : usuarios) {
            if (userFilter.getCpf().equals(cpf)) {
                return userFilter;
            }
        }
        return null;
    }

    @PostMapping("/newUser")
    UserDTO inserir(@RequestBody UserDTO userDTO) {
        userDTO.setDataCadastro(new Date());
        usuarios.add(userDTO);
        return userDTO;
    }

    @DeleteMapping("/{cpf}")
    public boolean remover(@PathVariable String cpf) {
        for(UserDTO user : usuarios) {
            if(user.getCpf().equals(cpf)) {
                usuarios.remove(user);
                return true;
            }
        }
        return false;
    }

    @PostConstruct
    public void initiateList() {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Eduardo");
        userDTO.setCpf("123");
        userDTO.setEndereco("Rua a");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setTelefone("1234-3454");
        userDTO.setDataCadastro(new Date());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setNome("Luiz");
        userDTO2.setCpf("456");
        userDTO2.setEndereco("Rua b");

        userDTO2.setEmail("luiz@email.com");
        userDTO2.setTelefone("1234-3454");
        userDTO2.setDataCadastro(new Date());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setNome("Bruna");
        userDTO3.setCpf("678");
        userDTO3.setEndereco("Rua c");
        userDTO3.setEmail("bruna@email.com");
        userDTO3.setTelefone("1234-3454");
        userDTO3.setDataCadastro(new Date());
        usuarios.add(userDTO);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);
    }
}
