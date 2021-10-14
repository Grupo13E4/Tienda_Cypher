package co.edu.unbosque.ciclo3backGrupo13.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import co.edu.unbosque.ciclo3backGrupo13.dao.UsuariosDAO;
import co.edu.unbosque.ciclo3backGrupo13.model.Usuarios;


@RestController // Es la que representa el objeto tipo Rest
@RequestMapping("usuarios") // 
public class UsuariosAPI {
	
	@Autowired // Inyecta la dependencia de todos los métodos del JPA a la variable usuarioDAO
	private UsuariosDAO usuariosDao;
	
	@PostMapping("/guardar")
	public void guardar (@RequestBody Usuarios usuarios) {
		usuariosDao.save(usuarios);		
	}
	
	@GetMapping("/listar")
	public List <Usuarios> listar(){
		return usuariosDao.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		usuariosDao.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Usuarios usuarios ) {
		usuariosDao.save(usuarios);
	}
	


}
