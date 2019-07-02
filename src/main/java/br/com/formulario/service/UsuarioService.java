package br.com.formulario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.formulario.model.Usuario;
import br.com.formulario.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public void salvar(Usuario usuario) {
		repository.save(usuario);
	}
	
	public Iterable<Usuario> obterTodos(){
		Iterable<Usuario> usuarios = repository.findAll();
		return usuarios;
	}

}
