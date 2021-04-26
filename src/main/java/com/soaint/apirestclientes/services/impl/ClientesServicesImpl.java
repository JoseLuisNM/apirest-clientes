package com.soaint.apirestclientes.services.impl;

import com.soaint.apirestclientes.models.Cliente;
import com.soaint.apirestclientes.repositories.IClientesRepository;
import com.soaint.apirestclientes.services.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServicesImpl  implements IClientesService {

    @Autowired
    private IClientesRepository repository;

    @Override
    public List<Cliente> obtenerTodos() {
        return (List<Cliente>) repository.findAll();
    }

    @Override
    public void eliminarPorId(Long id){
        repository.deleteById(id);
    }

    @Override
    public List<Cliente> buscarPorQuery(String query) {
        return repository.obtenerPorQueryString(query.toLowerCase());
    }
}
