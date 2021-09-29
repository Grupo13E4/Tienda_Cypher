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
import co.edu.unbosque.ciclo3backGrupo13.dao.ProductosDAO;
import co.edu.unbosque.ciclo3backGrupo13.model.Productos;


@RestController // Es la que representa el objeto tipo Rest
@RequestMapping("Productos") // 
public class ProductosAPI {
	
	@Autowired // Inyecta la dependencia de todos los métodos del JPA a la variable usuarioDAO
	private ProductosDAO productosDao;
	
	@PostMapping("/guardar")
	public void guardar (@RequestBody Productos productos) {
		productosDao.save(productos);		
	}
	
	@GetMapping("/listar")
	public List <Productos> listar(){
		return productosDao.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		productosDao.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Productos productos ) {
		productosDao.save(productos);
	}
}
