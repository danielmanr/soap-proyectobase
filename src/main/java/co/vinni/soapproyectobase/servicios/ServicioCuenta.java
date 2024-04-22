package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.dto.ClienteDto;
import co.vinni.soapproyectobase.dto.CuentaDto;
import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.entidades.Producto;
import co.vinni.soapproyectobase.repositorios.RepositorioCliente;
import co.vinni.soapproyectobase.repositorios.RepositorioCuenta;
import co.vinni.soapproyectobase.utilidades.UtilidadArchivos;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Service
public class ServicioCuenta implements Serializable {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private final RepositorioCliente repoCliente;
    @Autowired
    private final RepositorioCuenta repoCuenta;

    @Transactional
    public Cuenta guardarCuentaCliente(Cliente cliente, Cuenta cuenta){
        repoCliente.save(cliente);
        cuenta.setCliente(cliente);
        return repoCuenta.save(cuenta);
    }


    public String generarNumeroCuenta(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int numeroAleatorio = rand.nextInt(10);
            sb.append(numeroAleatorio);
        }
        return sb.toString();

    }




}
