package com.example.crud_arquitectura.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_arquitectura.entidad.Producto;
import com.example.crud_arquitectura.excepcion.RecursoNoEncontradoException;
import com.example.crud_arquitectura.servicio.ServicioProducto;


/**
 * Controlador REST que expone los endpoints (puntos de acceso) para la gestión de productos.
 * Actúa como intermediario entre la vista (Frontend) y la capa de servicio.
 * * @author Aldrin
 * @version 1.0
 */
@RestController
@RequestMapping("/api/productos")
public class ControladorProducto {
	
	@Autowired
	private  ServicioProducto servicioProducto;
	
	/**
	 * Obtiene el listado completo de productos almacenados.
	 * @return Lista de objetos Producto.
	 */
	@GetMapping
	public List<Producto> obtenerTodos(){
		return servicioProducto.getProductos();
	}
	
	/**
	 * Busca un producto específico por su identificador único.
	 * @param id Identificador del producto.
	 * @return Un Optional que contiene el producto si existe.
	 */
	
	@GetMapping("/{id}")
	public Optional<Producto> buscarProducto(@PathVariable Long id){
		return servicioProducto.getProducto(id);
	}
	
	/**
	 * Guarda un nuevo producto en la base de datos.
	 * @param producto Objeto con los datos a persistir.
	 * @return El producto guardado con su ID generado.
	 */
	@PostMapping
	public Producto guardarProducto(@RequestBody Producto producto) {
		return servicioProducto.guardarProducto(producto);
	}
	
	/**
	 * Elimina un producto del sistema dado su ID.
	 * @param id Identificador del producto a eliminar.
	 */
	@DeleteMapping("/{id}")
	public void eliminarProducto(@PathVariable Long id) {
		servicioProducto.EliminarProducto(id);
	}
	
	/**
	 * Actualiza la información de un producto existente.
	 * Lanza una excepción personalizada si el ID no existe.
	 * * @param id Identificador del producto a editar.
	 * @param detallesProducto Objeto con la nueva información.
	 * @return El producto actualizado.
	 * @throws RecursoNoEncontradoException Si el ID no existe en la BD.
	 */
	@PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto detallesProducto) {
		Producto productoExistente = servicioProducto.getProducto(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró el producto con id: " + id));


        productoExistente.setNombre(detallesProducto.getNombre());
        productoExistente.setPrecio(detallesProducto.getPrecio());
        productoExistente.setStock(detallesProducto.getStock());


        return servicioProducto.guardarProducto(productoExistente);
    }
	
}
