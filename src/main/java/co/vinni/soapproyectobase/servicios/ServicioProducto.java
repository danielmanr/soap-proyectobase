package co.vinni.soapproyectobase.servicios;


import co.vinni.soapproyectobase.dto.ClienteDto;
import co.vinni.soapproyectobase.dto.ProductoDto;
import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Producto;
import co.vinni.soapproyectobase.exception.ResourceNotFoundException;
import co.vinni.soapproyectobase.repositorios.RepositorioCliente;
import co.vinni.soapproyectobase.repositorios.RepositorioProducto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ServicioProducto {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final RepositorioProducto repoProducto;

    public ProductoDto registrar(ProductoDto productoDto){
        Producto elProducto = repoProducto.save(modelMapper.map(productoDto, Producto.class));
        return modelMapper.map(elProducto, ProductoDto .class);
    }


    public List<ProductoDto> obtenerProductos() {
        TypeToken<List<ProductoDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(repoProducto.findAll(), typeToken.getType());
    }

    public Producto obtenerProductoById(Long id) {
        return repoProducto.getReferenceById(id);
    }


    public ProductoDto actualizar(ProductoDto productoDto) {
        repoProducto.save(modelMapper.map(productoDto, Producto.class));
        return productoDto;
    }


    public void eliminar(long id) {
        repoProducto.deleteById(id);
    }



}
