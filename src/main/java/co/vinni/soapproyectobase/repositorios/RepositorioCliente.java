package co.vinni.soapproyectobase.repositorios;

import co.vinni.soapproyectobase.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCliente extends JpaRepository<Cliente, Integer>{
}




