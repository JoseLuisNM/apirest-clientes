package com.soaint.apirestclientes.services;

import com.soaint.apirestclientes.models.Cliente;

import java.util.List;

public interface IClientesService {

    List<Cliente> obtenerTodos();

    void eliminarPorId(Long id);

    Cliente obtenerPorId(Long id);

    Cliente crearCliente(Cliente cliente);

    List<Cliente> buscarPorQuery(String query);

}
