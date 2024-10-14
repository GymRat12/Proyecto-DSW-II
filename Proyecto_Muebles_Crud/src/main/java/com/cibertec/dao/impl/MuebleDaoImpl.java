package com.cibertec.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.config.Conectar;
import com.cibertec.dao.MuebleDao;
import com.cibertec.model.Muebles;

public class MuebleDaoImpl implements MuebleDao {
	
	private Conectar conectar;
	
	public MuebleDaoImpl() {
		conectar = new Conectar();
	}

	@Override
	public String insertarMueble(Muebles mueble) {

		String resultado = null;
		Connection cn = conectar.getConnection();
		
		try {
			CallableStatement cs = cn.prepareCall("{call insertar_muebles(?,?,?)}");
			cs.setString(1, mueble.getNombre());
			cs.setInt(2, mueble.getPrecio());
			cs.setString(3, mueble.getFecha_registro());
			
			
			int res= cs.executeUpdate();
			resultado = res == 0? "No hubo registro." : "Se registro el mueble.";
			cs.close();
		} catch (Exception e) {
			e.printStackTrace();
			resultado = e.getMessage();	
		}finally {
			try {
				cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return resultado;
	}

	@Override
	public List<Muebles> listaMuebles() {

		List<Muebles> lista = new ArrayList<Muebles>();
		Connection cn = conectar.getConnection();
		
		try {
			CallableStatement cs = cn.prepareCall("{call listar_muebles()}");
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				Muebles mueble = new Muebles();
				mueble.setId(rs.getInt(1));
				mueble.setNombre(rs.getString(2));
				mueble.setPrecio(rs.getInt(3));
				mueble.setFecha_registro(rs.getString(4));
				
				lista.add(mueble);
				
			}
			rs.close();
			cs.close();
			cn.close();
		} catch (Exception e) {
			System.out.println("Error al listar los muebles:" + e.getMessage());
		}
		
		return lista;
	}

	@Override
	public Muebles listarMueblesPorId(int id) {
		Connection cn = conectar.getConnection();
		Muebles muebles = null;
		
		try {
			CallableStatement cs = cn.prepareCall("{call listar_cliente_id(?)}");
			cs.setInt(1, id);
			ResultSet rs = cs.executeQuery();
			if(rs.next()) {
				Muebles mueble = new Muebles();
				mueble.setId(rs.getInt(1));
				mueble.setNombre(rs.getString(2));
				mueble.setPrecio(rs.getInt(3));
				mueble.setFecha_registro(rs.getString(4));
				
			}
		     rs.close();
		     cs.close();
		     cn.close();
		} catch (Exception e) {
		     e.printStackTrace();	
		}
		return muebles;
	}

	@Override
	public String actualizarMuebles(Muebles muebles) {
	
		Connection cn = conectar.getConnection();
		String resulado = null;
		
		try {
			CallableStatement cs = cn.prepareCall("{call actualizar_muebles(?,?,?,?)}");
			cs.setInt(1, muebles.getId());
			cs.setString(2, muebles.getNombre());
			cs.setInt(3, muebles.getPrecio());
			cs.setString(4, muebles.getFecha_registro());
		    
		    
		    int res = cs.executeUpdate();
		    
		    resulado = res == 0? "no se actualizo el mueble" : "Se actualizo el mueble";
		    cs.close();
		} catch (Exception e) {
			resulado = e.getMessage();
		}finally {
			try {
				cn.close();
			} catch (Exception e2) {
				resulado = e2.getMessage();
			}
		}
		
	
		
		return resulado;
	}

	@Override
	public String eliminarMuebles(int id) {

		Connection cn = conectar.getConnection();
		String resultado = null;
	
		try {
			CallableStatement cs = cn.prepareCall("{call eliminar_mueble(?)}");
			cs.setInt(1, id);
			
			int res = cs.executeUpdate();
			
			resultado = res == 0? "no se elimino el mueble" : "se elimino el mueble";
		} catch (Exception e) {
			resultado = e.getMessage();
		}finally {
			try {
				cn.close();
			} catch (SQLException e) {
				resultado = e.getMessage();
			}
		}
		
		return resultado;
	}

}
