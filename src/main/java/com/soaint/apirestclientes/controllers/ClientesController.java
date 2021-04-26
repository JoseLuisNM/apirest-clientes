package com.soaint.apirestclientes.controllers;

import com.soaint.apirestclientes.models.Cliente;
import com.soaint.apirestclientes.services.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api/clientes")
public class ClientesController {

    private IClientesService service;

    public ClientesController(IClientesService service){
        this.service = service;
    }

    @GetMapping("")
    public List<Cliente> index(){
        return service.obtenerTodos();
    }

    @GetMapping("/search")
    public List<Cliente> search(@RequestParam("query") String query){
        return service.buscarPorQuery(query);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        service.eliminarPorId(id);

    }

}
