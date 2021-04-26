package com.soaint.apirestclientes.repositories;

import com.soaint.apirestclientes.models.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IClientesRepository extends CrudRepository<Cliente, Long> {

    @Query("select c from Cliente c where LOWER(c.nombre) like %:query% or LOWER(c.apellido) like %:query%")
    List<Cliente> obtenerPorQueryString(String query);

}
