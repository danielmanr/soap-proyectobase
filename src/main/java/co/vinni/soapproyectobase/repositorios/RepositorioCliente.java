package co.vinni.soapproyectobase.repositorios;

import co.vinni.soapproyectobase.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioCliente extends JpaRepository<Cliente, Integer>{
    Optional<Cliente> findTopByOrderByIdClienteDesc();
}




