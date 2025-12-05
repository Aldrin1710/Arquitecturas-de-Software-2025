package com.example.crud_arquitectura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud_arquitectura.entidad.Producto;

/**
 * Interfaz Repositorio que gestiona las operaciones de persistencia para la entidad {@link Producto}.
 * 
 * Extiende de {@link JpaRepository}, lo que le permite heredar automáticamente métodos estándar
 * para operaciones CRUD sin necesidad de implementar código SQL manualmente.
 * 
 * * 
 * @see JpaRepository
 * @see Producto
 * @version 1.0
 */
@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long>{
	
}
