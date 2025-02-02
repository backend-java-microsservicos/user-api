package mz.co.muianga.userapi.dto;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import mz.co.muianga.userapi.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserDTO {

    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private Date dataCadastro;

    public static UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome(user.getNome());
        userDTO.setEndereco(user.getEndereco());
        userDTO.setCpf(user.getCpf());
        userDTO.setEmail(user.getEmail());
        userDTO.setTelefone(user.getTelefone());
        userDTO.setDataCadastro(user.getDataCadastro());
        return userDTO;
    }
}
