package mz.co.muianga.userapi.controller;

import mz.co.muianga.shoppingclient.dto.UserDTO;
import mz.co.muianga.userapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/{cpf}")
    public UserDTO findByCpf(@PathVariable("cpf") String cpf) {
        return userService.findByCpf(cpf);
    }

    @PostMapping
    public UserDTO inserir(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @DeleteMapping("/{id}")
    public UserDTO remover(@PathVariable("id") long id) {
        return userService.delete(id);
    }

    @GetMapping("/search")
    public List<UserDTO> queryByName(@RequestParam(name = "nome", required = true) String nome) {
        return userService.queryByName(nome);
    }

}
