package com.formacionbdi.springboot.app.usuarios.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.formacionbdi.springboot.app.usuarios.commons.models.entity.Usuario;

@Repository
/**
 * Con esta anotación te evitas el trabajo de hacer un controlador, en
 * automatico se configura un controlador con base en los métodos que se hayan
 * definido aqui. Funcionan con los verbos HTTP para realizar operaciones sobre
 * ellos.
 * 
 * Por defecto los metodos que se crean se pueden llamar con
 * /usuarios/search/findByUsername?username=andres
 * /{nombre_base}/search/{nombre_del_metodo}?{parametros del método} esto es
 * posible sobreescribirlo usando la anotación @RestResource y dándole valor a
 * path.
 * 
 * Este utiliza un estandar llamado HATEOAS que, además de mandar la información
 * solicitada, envia una serie de parametros que permiten la intreaccion con el
 * api. Te crea un CRUD completo sin necesidad de crearlo tú, sólo con usar los
 * verbos HTTP y los valores necesarios.
 *
 */
@RepositoryRestResource(path = "usuarios")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long> {

	@RestResource(path = "buscar-username")
	public Usuario findByUsername(@Param("username") String username);

	@Query("SELECT u FROM Usuario u WHERE u.username = ?1")
	public Usuario obtenerPorUsername(String username);

}
