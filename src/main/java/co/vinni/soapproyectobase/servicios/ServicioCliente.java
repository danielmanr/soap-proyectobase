package co.vinni.soapproyectobase.servicios;


import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.repositorios.RepositorioCliente;
import co.vinni.soapproyectobase.repositorios.RepositorioCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioCliente {


    @Autowired
    RepositorioCliente repocliente;


    public boolean registrarCliente(Cliente cliente){

        if(repocliente.save(cliente) != null){
            return true;
        }

        return false;
    }

}
