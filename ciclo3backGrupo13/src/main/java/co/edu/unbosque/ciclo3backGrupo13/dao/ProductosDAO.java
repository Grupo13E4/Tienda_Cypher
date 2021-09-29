package co.edu.unbosque.ciclo3backGrupo13.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.ciclo3backGrupo13.model.Productos;

public interface ProductosDAO extends JpaRepository <Productos, Long> {

}
