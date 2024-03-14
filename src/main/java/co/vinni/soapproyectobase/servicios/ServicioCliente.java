package co.vinni.soapproyectobase.servicios;


import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.repositorios.RepositorioCliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;


@Service
public class ServicioCliente implements Serializable {

    private ModelMapper modelMapper;


    @Autowired
    RepositorioCliente repocliente;


    public void registrarCliente(Cliente cliente) {
        repocliente.save(modelMapper.map(cliente,Cliente.class));
    }
}
