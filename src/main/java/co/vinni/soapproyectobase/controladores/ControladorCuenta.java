package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.dto.ClienteDto;
import co.vinni.soapproyectobase.dto.CuentaDto;
import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.servicios.ServicioCliente;
import co.vinni.soapproyectobase.servicios.ServicioCuenta;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class ControladorCuenta {

    @Autowired
    private ServicioCliente servicioCliente;

    @Autowired
    private ServicioCuenta servicioCuenta;

    @GetMapping("/cuenta/nuevo")
    public String mostrarFormulario(Model model){
        CuentaDto cuentaDto = new CuentaDto();
        model.addAttribute("cliente", servicioCliente.obtenerUtimoCliente());
        System.out.println("aca trae al cliente");
        System.out.println(model.addAttribute("cliente", servicioCliente.obtenerUtimoCliente()));
        model.addAttribute("cuenta",cuentaDto);
        return "crear_cuenta";
    }





}