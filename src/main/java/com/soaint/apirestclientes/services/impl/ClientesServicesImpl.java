package com.soaint.apirestclientes.services.impl;
import com.soaint.apirestclientes.models.Cliente;
import com.soaint.apirestclientes.models.Cuenta;
import com.soaint.apirestclientes.repositories.IClientesRepository;
import com.soaint.apirestclientes.services.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesServicesImpl  implements IClientesService {

    @Autowired
    private IClientesRepository repository;

    @Override
    public List<Cliente> obtenerTodos() {
        return (List<Cliente>) repository.findAll();
    }

    @Override
    public Page<Cliente> obtenerClientesPaginados(Pageable pageable){
        return repository.findAll(pageable);
    }

    @Override
    public void eliminarPorId(Long id){
        repository.deleteById(id);
    }

    @Override
    public Cliente obtenerPorId(Long id) {
        return repository.findById(id).orElse(new Cliente());
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente){
        return repository.save(cliente);
    }


    @Override
    public List<Cliente> buscarPorQuery(String query) {
        return repository.obtenerPorQueryString(query.toLowerCase());
    }

    @Override
    public List<Cliente> buscarPorNombreApellidos(String nombre, String apellido) {
        return repository.findByNombreOrApellido(nombre, apellido);
    }

    @Override
    public Page<Cliente> buscarPorQueryPaginados(Pageable pageable, String query) {
        return repository.obtenerPorQueryStringPaginados(pageable, query);
    }

    @Override
    public Cliente actualizarCuentas (Long id, List<Cuenta> cuentas){
        Cliente c = repository.getOne(id);
        c.eliminarCuenta(cuentas);
        return repository.save(c);
    }

    @Override
    public Cliente eliminarCuentas (Long id, List<Cuenta> cuentas) {
        Optional<Cliente> result = repository.findById(id);
        if (result.isPresent()) {
            Cliente c = result.get();
            c.eliminarCuenta(cuentas);
            return repository.save(c);
        }
        return null;
    }
}
