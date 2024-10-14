package com.cibertec.dao;

import java.util.List;

import com.cibertec.model.Muebles;

public interface MuebleDao {

	public String insertarMueble(Muebles mueble);
	
	public List<Muebles> listaMuebles();
	
	public Muebles listarMueblesPorId(int id);
	
	public String actualizarMuebles(Muebles muebles);
	
	public String eliminarMuebles(int id);
	
	
	
	
}
