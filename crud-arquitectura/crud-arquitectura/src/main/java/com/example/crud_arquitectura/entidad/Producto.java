package com.example.crud_arquitectura.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase Entidad que representa la tabla 'producto' en la base de datos.
 * Utiliza anotaciones JPA para el mapeo objeto-relacional (ORM).
 */
@Entity
@Table(name = "producto")
public class Producto {
	
	/** Identificador único autoincrementable  */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
    private Double precio;
    private Integer  stock;
    
    public Producto() {
    	
    }
    
    /**
     * Constructor para instanciar productos nuevos.
     * @param nombre Nombre del producto.
     * @param precio Precio unitario.
     * @param stock Existencias.
     */
    public Producto(String nombre, Double precio, Integer stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
   /** Getters y setters **/
    
    public Long getId() { 
    	return id; 
    }
    
    public void setId(Long id) { 
    	this.id = id; 
    }
    
    public String getNombre() {
    	return nombre;
    }
    
    public Double getPrecio() {
    	return precio;
    }
    
    public Integer getStock() {
    	return stock;
    }
    
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    public void setPrecio(Double precio) {
    	this.precio = precio;
    }
    
    public void setStock(Integer stock) {
    	this.stock = stock;
    }
}
