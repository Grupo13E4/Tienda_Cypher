package co.edu.unbosque.ciclo3backGrupo13.DTO;

import java.io.Serializable;

public class serieFactura implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;

	public serieFactura(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
