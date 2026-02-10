package github.com.GustavoAraujoPires.libraryapi.repository;

import github.com.GustavoAraujoPires.libraryapi.model.Autor;
import github.com.GustavoAraujoPires.libraryapi.model.GeneroLivro;
import github.com.GustavoAraujoPires.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarTest(){
        Livro livro = new Livro();
        livro.setIsbn("5648-5558");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("UFO");
        livro.setDatapublicacao(LocalDate.of(1980, 1 , 2));

        Autor autor = autorRepository
                .findById(UUID.fromString("bde89528-a780-4828-9a8f-072601e9054e"))
                .orElse(null);

        livro.setAutor(autor);

        repository.save(livro);

    }
}