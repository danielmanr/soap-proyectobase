package co.vinni.soapproyectobase.servicios;


import co.vinni.soapproyectobase.dto.ClienteDto;
import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.exception.ResourceNotFoundException;
import co.vinni.soapproyectobase.repositorios.RepositorioCliente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@AllArgsConstructor
@Service
public class ServicioCliente implements Serializable {

    private ModelMapper modelMapper;

    private final RepositorioCliente repoCliente;

    public List<ClienteDto> obtenerClientes() {
        TypeToken<List<ClienteDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repoCliente.findAll(), typeToken.getType());

    }
    public ClienteDto obtenerEquipo(int id) {
        Cliente cliente = repoCliente.findById(id).orElseThrow(
                ResourceNotFoundException::new);

        return modelMapper.map(cliente, ClienteDto.class);
    }

    public ClienteDto actualizar(ClienteDto clienteDto) {
        repoCliente.save(modelMapper.map(clienteDto, Cliente.class));
        return clienteDto;

    }
    public void eliminar(int id) {
        repoCliente.deleteById(id);
    }


    public Optional<Cliente> obtenerUtimoCliente(){
        return repoCliente.findTopByOrderByIdClienteDesc();
    }

}
