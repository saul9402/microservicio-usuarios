package com.formacionbdi.springboot.app.usuarios.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.formacionbdi.springboot.app.usuarios.model.entity.Usuario;

@Repository
/**
 * Con esta anotación te evitas el trabajo de hacer un controladror, en
 * automatico se configura un controlador con base en los métodos que se hayan
 * definido aqui. Funcionan con los verbos HTTP para realizar operaciones sobre
 * ellos.
 * 
 * Por defecto los metodos que se crean se pueden llamar con
 * /usuarios/search/findByUsername?username=andres
 * /{nombre_base}/search/{nombre_del_metodo}?{parametros del método} esto es
 * posible sobreescribirlo usando la anotación @RestResource y dándole varlo a
 * path
 *
 */
@RepositoryRestResource(path = "usuarios")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long> {

	@RestResource(path = "buscar-username")
	public Usuario findByUsername(@Param("username")String username);

	@Query("SELECT u FROM Usuario u WHERE u.username = ?1")
	public Usuario obtenerPorUsername(String username);

}
