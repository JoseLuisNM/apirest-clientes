package com.soaint.apirestclientes.controllers;

import com.soaint.apirestclientes.models.Cliente;
import com.soaint.apirestclientes.models.Cuenta;
import com.soaint.apirestclientes.services.IClientesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("page/{pageNumber}")
    public Page<Cliente> getByPage(@PathVariable Integer pageNumber){
        return service.obtenerClientesPaginados(
                PageRequest.of(pageNumber, 10)
        );
    }

    @GetMapping("/{id}")
        public Cliente getById(@PathVariable Long id){
        return service.obtenerPorId(id);
    }

    @GetMapping("/search/{pageNumber}")
    public Page<Cliente> search(@PathVariable Integer pageNumber, @RequestParam("query") String query){
        return service.buscarPorQueryPaginados(PageRequest.of(pageNumber, 10), query);
    }

    @PostMapping("")
    public Cliente create(@RequestBody Cliente cliente){
        return service.crearCliente(cliente);
    }

    @PutMapping("")
    public Cliente update(@RequestBody Cliente cliente){
        return service.actualizarCliente(cliente);
    }

    @PutMapping("/{id}/cuentas")
    public Cliente updateAccounts(@PathVariable Long id, @RequestBody List<Cuenta> cuentas){
       return service.actualizarCuentas(id, cuentas);
        // Metodo para actualizar en el servicio. (IClienteService)
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        service.eliminarPorId(id);
    }

    @GetMapping("/search2")
    public List<Cliente> search(@RequestParam (name = "nombre") String nombre,
                                @RequestParam(name = "apellido", required = false, defaultValue = "") String apellido){
        return service.buscarPorNombreApellidos(nombre, apellido);
    }

    @DeleteMapping("/{id}/cuentas")
    public Cliente deleteAccounts(@PathVariable Long id, @RequestBody List<Cuenta> cuentas){
        System.out.println("Entra");
        return service.eliminarCuentas(id, cuentas);
        // Metodo para actualizar en el servicio. (IClienteService)
    }

}
