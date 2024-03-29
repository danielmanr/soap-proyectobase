package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.dto.ClienteDto;
import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.servicios.ServicioCliente;
import co.vinni.soapproyectobase.servicios.ServicioCuenta;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
public class ControladorCliente {

    private static final Logger logger = LogManager.getLogger(ControladorCliente.class);

    @Autowired
    private ServicioCliente servicioCliente;


    @GetMapping({"/clientes"})
    public String listarClientes(Model model){
        logger.info("verificados");
        model.addAttribute("clientes",servicioCliente.obtenerClientes());
        System.out.println("Cositas de los clientes");
        System.out.println(servicioCliente.obtenerClientes());
        return "clientes";
    }


    @GetMapping("/clientes/nuevo")
    public String mostrarFormulario(Model model){
        ClienteDto clienteDto = new ClienteDto();
        model.addAttribute("cliente",clienteDto);
        return "Crear_cliente";
    }


    @PostMapping("/clientes")
    public String registrarCliente(@ModelAttribute("cliente") ClienteDto clienteDto) {
        System.out.println("si esta llegando");
        servicioCliente.registrar(clienteDto);
        return "redirect:/clientes";
    }




}
