package co.vinni.soapproyectobase.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "Producto")
@Table(name = "Productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(name = "Tipo", nullable = false)
    private String tipo;

    @Column(name = "Capacidad", nullable = false)
    private double capacidad;

    @Column(name = "Franquicia", nullable = true)
    private String franquicia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;


}
