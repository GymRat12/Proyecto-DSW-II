package com.cibertec.service;

import java.sql.Date;
import java.util.List;

import com.cibertec.model.Muebles;

public interface MuebleService {
	
	public String insertarMueble(String nombre, double precio);
	public List<Muebles> listarMuebles();
	public Muebles listarMueblesPorId(int id);
	public String actualizarMuebles(int id, String nombre,double precio);
	public String eliminarMueble(int id);

}
