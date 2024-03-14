package co.vinni.soapproyectobase.repositorios;

import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RepositorioCuenta extends JpaRepository<Cuenta, Long>, JpaSpecificationExecutor<Cuenta> {
   // public boolean registrarCuenta(Cuenta cuenta);
}
