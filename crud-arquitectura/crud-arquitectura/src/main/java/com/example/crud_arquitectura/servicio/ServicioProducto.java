package com.example.crud_arquitectura.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud_arquitectura.entidad.Producto;
import com.example.crud_arquitectura.repositorio.RepositorioProducto;

/**
 * Servicio que encapsula la lógica de negocio de la aplicación.
 * Se comunica directamente con el Repositorio para realizar operaciones CRUD.
 * * @version 1.0
 */
@Service
public class ServicioProducto {
	
	
	@Autowired 
	RepositorioProducto repositorioProducto; 
	
	/**
	 * Recupera todos los registros de la tabla producto.
	 * @return Lista completa de productos.
	 */
	public List<Producto> getProductos(){
		return repositorioProducto.findAll();
	}
	
	/**
	 * Busca un registro por su llave primaria.
	 * @param id ID del producto.
	 * @return Optional con el producto encontrado o vacío.
	 */
	public Optional<Producto> getProducto(Long id){
		return repositorioProducto.findById(id);
	}
	
	/**
	 * Persiste un objeto producto en la base de datos (Crear o Actualizar).
	 * @param producto Objeto a guardar.
	 * @return El objeto guardado.
	 */
	 public Producto guardarProducto(Producto producto) {
	        return repositorioProducto.save(producto);
	 }
	 
	 /**
	  * Elimina físicamente un registro de la base de datos.
	  * @param id ID del producto a borrar.
	  */
	 public void EliminarProducto(Long id) {
		 repositorioProducto.deleteById(id);
	 }
		
}
