package com.cibertec.service.impl;

import java.sql.Date;
import java.util.List;

import com.cibertec.dao.MuebleDao;
import com.cibertec.dao.impl.MuebleDaoImpl;
import com.cibertec.model.Muebles;
import com.cibertec.service.MuebleService;

public class MuebleServiceImpl implements MuebleService {

	MuebleDao dao = new MuebleDaoImpl();
	
	@Override
	public String insertarMueble(Muebles mueble) {
		return dao.insertarMueble(mueble);
	}

	@Override
	public List<Muebles> listarMuebles() {
		return dao.listaMuebles();
	}

	@Override
	public Muebles listarMueblesPorId(int id) {
		return dao.listarMueblesPorId(id);
	}

	@Override
	public String actualizarMuebles(int id, String nombre,int precio, String fecha_registro) {
		
		Muebles muebles = new Muebles(id,nombre,precio,fecha_registro);
		
		return dao.actualizarMuebles(muebles);
	}

	@Override
	public String eliminarMueble(int id) {
		// TODO Auto-generated method stub
		return dao.eliminarMuebles(id);
	}

}
