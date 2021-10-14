package co.edu.unbosque.ciclo3backGrupo13.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.unbosque.ciclo3backGrupo13.DTO.serieFactura;
import co.edu.unbosque.ciclo3backGrupo13.model.Ventas;
import java.util.Optional;

public interface VentasDAO extends JpaRepository<Ventas, Long>{
	
	@Query("select new co.edu.unbosque.ciclo3backGrupo13.DTO.serieFactura(ifnull(max(v.codigo_venta),0)+1) from Ventas v")
	Optional<serieFactura> obtenerConsecutivo();
	
	//@Query(nativeQuery = true, value = "SELECT max(codigo_venta+1)as maximo FROM ventas;")
	//long getMaxCodigoVenta();
	
}
