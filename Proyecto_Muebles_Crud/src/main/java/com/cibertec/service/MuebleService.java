package com.cibertec.service;

import java.sql.Date;
import java.util.List;

import com.cibertec.model.Muebles;

public interface MuebleService {
	
	public String insertarMueble(Muebles muebles);
	public List<Muebles> listarMuebles();
	public Muebles listarMueblesPorId(int id);
	public String actualizarMuebles(int id, String nombre,int precio);
	public String eliminarMueble(int id);

}
