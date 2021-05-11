package com.soaint.apirestclientes.services;
import com.soaint.apirestclientes.models.Cliente;
import com.soaint.apirestclientes.models.Cuenta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IClientesService {

    List<Cliente> obtenerTodos();

    Page<Cliente> obtenerClientesPaginados(Pageable pageable);

    Page<Cliente> buscarPorQueryPaginados(Pageable pageable, String query);

    void eliminarPorId(Long id);

    Cliente obtenerPorId(Long id);

    Cliente crearCliente(Cliente cliente);

    Cliente actualizarCliente(Cliente cliente);

    List<Cliente> buscarPorQuery(String query);

    List<Cliente> buscarPorNombreApellidos(String nombre, String apellido);

    Cliente actualizarCuentas (Long id, List<Cuenta> cuentas);

    Cliente eliminarCuentas (Long id, List<Cuenta> cuentas);



}
