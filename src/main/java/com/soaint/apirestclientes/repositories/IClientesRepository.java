package com.soaint.apirestclientes.repositories;
import com.soaint.apirestclientes.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClientesRepository extends JpaRepository<Cliente, Long> {

    @Query("select c from Cliente c where LOWER(c.nombre) like %:query% or LOWER(c.apellido) like %:query%")
    List<Cliente> obtenerPorQueryString(String query);

    @Query("select c from Cliente c where LOWER(c.nombre) like %:query% or LOWER(c.apellido) like %:query%")
    Page<Cliente> obtenerPorQueryStringPaginados(Pageable pageable, String query);

    List<Cliente> findByNombreOrApellido(String nombre, String apellido);

}
