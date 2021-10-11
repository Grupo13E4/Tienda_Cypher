package co.edu.unbosque.ciclo3backGrupo13.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import co.edu.unbosque.ciclo3backGrupo13.dao.VentasDAO;
import co.edu.unbosque.ciclo3backGrupo13.model.Ventas;

@RestController
@RequestMapping("ventas")
public class VentasAPI {
	
	@Autowired
	private VentasDAO ventasDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Ventas ventas) {
		ventasDAO.save(ventas);
	}
	
	@GetMapping("/listar")
    public List<Ventas> listar(){
    return ventasDAO.findAll();
    }
}
