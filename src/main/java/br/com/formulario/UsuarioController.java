package br.com.formulario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.formulario.model.Usuario;
import br.com.formulario.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired 
	private UsuarioService service;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("formulario")
	public String formulario() {
		return "formulario"; 
	}
		
	@RequestMapping(value="salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email, 
            @RequestParam("senha") String senha, Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		service.salvar(usuario);
		
		return "formulario"; 
	}
	
	@RequestMapping("listausuarios")
	public String listaUsuarios(Model model) {
		Iterable<Usuario> usuarios = service.obterTodos();
		model.addAttribute("usuarios", usuarios);
		
		return "listausuarios";
	}
}
