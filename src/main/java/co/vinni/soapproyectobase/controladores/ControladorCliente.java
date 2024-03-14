package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.servicios.ServicioCliente;

public class ControladorCliente {

    ServicioCliente servicio = new ServicioCliente();


    public void guardarCliente(Cliente cliente){
        servicio.registrarCliente(cliente);
    }

}
