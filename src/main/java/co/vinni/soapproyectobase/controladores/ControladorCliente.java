package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.dto.ClienteDto;
import co.vinni.soapproyectobase.dto.CuentaDto;
import co.vinni.soapproyectobase.dto.ProductoDto;
import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.entidades.Producto;
import co.vinni.soapproyectobase.servicios.ServicioCliente;
import co.vinni.soapproyectobase.servicios.ServicioCuenta;
import co.vinni.soapproyectobase.servicios.ServicioProducto;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Controller
public class ControladorCliente {

    private static final Logger logger = LogManager.getLogger(ControladorCliente.class);

    @Autowired
    private ServicioCliente servicioCliente;
    @Autowired
    private ServicioCuenta servicioCuenta;
    @Autowired
    private ServicioProducto servicioProducto;


    @GetMapping({"/clientes"})
    public String listarClientes(Model model){
        logger.info("verificados");
        model.addAttribute("clientes",servicioCliente.obtenerClientes());
        return "clientes";
    }


    @GetMapping("/clientes/nuevo")
    public String mostrarFormulario(Model model){
        ClienteDto clienteDto = new ClienteDto();
        List<ProductoDto> listaProductos = servicioProducto.obtenerProductos();
        model.addAttribute("cliente",clienteDto);
        model.addAttribute("listaProductos",listaProductos);
        return "Crear_cliente";
    }


    @PostMapping("/clientes")
    public String registrarCliente(@ModelAttribute("cliente") Cliente cliente, @RequestParam("idProducto") List<Long> idProductos) {
        ControladorCuenta controlCuenta = new ControladorCuenta();
        Cuenta cuenta = controlCuenta.asignacionCuenta();

        // Verificar si la lista de productos de la cuenta es nula
        if (cuenta.getProductos() == null) {
            cuenta.setProductos(new ArrayList<>());
        }

        // Obtener el producto seleccionado
        for (Long idProducto : idProductos) {
            // Obtener el producto correspondiente al identificador
            Producto productoSeleccionado = servicioProducto.obtenerProductoById(idProducto);

            // Asociar el producto a la cuenta
            productoSeleccionado.setCuenta(cuenta);

            // Agregar el producto a la lista de productos de la cuenta
            cuenta.getProductos().add(productoSeleccionado);
        }


        // Asignar la cuenta al cliente
        cliente.setCuenta(cuenta);

        // Guardar la cuenta y el cliente
        servicioCuenta.guardarCuentaCliente(cliente, cuenta);




        return "redirect:/clientes";
    }


    @GetMapping("/clientes/{idCliente}")
    public String eliminarClient(@PathVariable int idCliente){
        servicioCliente.eliminar(idCliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/modificar/{idCliente}")
    public String mostrarFormularioEditar(@PathVariable int idCliente, Model model){
//        ClienteDto clienteDto = new ClienteDto();
        model.addAttribute("cliente", servicioCliente.obtenerEquipo(idCliente));
        return "editar_cliente";
    }


    @PostMapping("/clientes/{idCliente}")
    public String modificarCliente(@PathVariable int idCliente,@ModelAttribute( "cliente") ClienteDto clienteDto, Model model){
        model.addAttribute("cliente", servicioCliente.actualizar(clienteDto));
        return "redirect:/clientes";
    }



}
