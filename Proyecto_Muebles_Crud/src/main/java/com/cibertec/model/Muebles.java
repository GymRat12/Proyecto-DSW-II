package com.cibertec.model;

public class Muebles {

	private int id;
	private String nombre;
	private int precio;
	private String fecha_registro;
	
	
	
	public Muebles() {
		super();
	}
	
	
	public Muebles(int id, String nombre, int precio, String fecha_registro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.fecha_registro = fecha_registro;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	@Override
	public String toString() {
		return "Muebles [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", fecha_registro=" + fecha_registro
				+ "]";
	}
	
	
	
	
	

	
	
}
