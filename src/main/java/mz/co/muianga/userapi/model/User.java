package mz.co.muianga.userapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mz.co.muianga.userapi.dto.UserDTO;

import java.util.Date;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;

    @Column(name = "data_cadastro")
    private Date dataCadastro;

}
