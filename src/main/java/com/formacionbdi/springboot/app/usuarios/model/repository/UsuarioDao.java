package com.formacionbdi.springboot.app.usuarios.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.formacionbdi.springboot.app.usuarios.model.entity.Usuario;

@Repository
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long> {

	public Usuario findByUsername(String username);

	@Query("SELECT u FROM Usuario u WHERE u.username = ?1")
	public Usuario obtenerPorUsername(String username);

}
