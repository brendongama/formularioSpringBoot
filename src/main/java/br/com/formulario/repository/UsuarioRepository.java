package br.com.formulario.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.formulario.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
