package com.soaint.apirestclientes.services;

import com.soaint.apirestclientes.models.Cliente;

import java.util.List;

public interface IClientesService {

    List<Cliente> obtenerTodos();

    void eliminarPorId(Long id);

    List<Cliente> buscarPorQuery(String query);

}
