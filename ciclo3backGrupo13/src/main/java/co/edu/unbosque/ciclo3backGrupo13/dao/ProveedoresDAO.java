package co.edu.unbosque.ciclo3backGrupo13.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.ciclo3backGrupo13.model.Clientes;
import co.edu.unbosque.ciclo3backGrupo13.model.Proveedores;

public interface ProveedoresDAO extends JpaRepository <Proveedores, Long> {

}
