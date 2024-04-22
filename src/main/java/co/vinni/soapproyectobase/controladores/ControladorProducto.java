package co.vinni.soapproyectobase.controladores;


import co.vinni.soapproyectobase.dto.ProductoDto;
import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.entidades.Producto;
import co.vinni.soapproyectobase.servicios.ServicioCliente;
import co.vinni.soapproyectobase.servicios.ServicioProducto;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class ControladorProducto {

    private static final Logger logger = LogManager.getLogger(ControladorProducto.class);
    @Autowired
    private ServicioProducto servicioProducto;


    @GetMapping("/productos/nuevo")
    public String mostrarFormulario(Model model) {
        ProductoDto productoDto = new ProductoDto();
        model.addAttribute("producto", productoDto);
        return "Crear_producto";
    }

    @GetMapping({"/productos"})
    public String listarProductos(Model model){
        logger.info("verificados");
        model.addAttribute("productos",servicioProducto.obtenerEquipos());
        return "Lista_Productos";
    }


    @PostMapping("/productos")
    public String registrarProducto(@ModelAttribute("producto") ProductoDto producto) {
        servicioProducto.registrar(producto);
        return "redirect:/productos";
    }

}
