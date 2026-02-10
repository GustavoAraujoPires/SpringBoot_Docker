package github.com.GustavoAraujoPires.libraryapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "livro")
@Data

public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "isbn", length = 20, nullable = false)
    private String isbn;

    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "data_publicacao", nullable = false)
    private LocalDate datapublicacao;

    @Enumerated(EnumType.STRING) // serve para dizer ao JPA/Hibernate como um enum será salvo no banco de dados.
    @Column(name = "genero", length = 30, nullable = false)
    private GeneroLivro genero;

    @Column(name = "preco",precision = 18, scale = 2)
    private BigDecimal preco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_autor")
    private Autor autor;
}
