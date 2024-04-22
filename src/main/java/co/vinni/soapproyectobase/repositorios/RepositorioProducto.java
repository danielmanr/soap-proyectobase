package co.vinni.soapproyectobase.repositorios;

import co.vinni.soapproyectobase.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long> {
}
