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

    //@Test
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

    //@Test
    void salvarAutorELivroTest(){
        Livro livro = new Livro();
        livro.setIsbn("5648-5558");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("Terceiro livro");
        livro.setDatapublicacao(LocalDate.of(1980, 1 , 2));

        Autor autor = new Autor();
        autor.setNome("José");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(1965, 7 , 31));
        autorRepository.save(autor);

        livro.setAutor(autor);

        repository.save(livro);

    }


   // @Test
    void salvarCascadeTest(){
        Livro livro = new Livro();
        livro.setIsbn("5648-5558");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("Outro livro");
        livro.setDatapublicacao(LocalDate.of(1980, 1 , 2));

        Autor autor = new Autor();
        autor.setNome("João");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(2008, 1 , 31));

        livro.setAutor(autor);

        repository.save(livro);

    }

    @Test
    void atualizarAutor(){
        UUID id = UUID.fromString("d337f895-6554-4b85-9ab7-4bc409b699b9");
        var livroParaAtualizar = repository.findById(id).orElse(null);

        UUID idAutor = UUID.fromString("d8962d0e-c44a-4b7f-914e-14100659d579");
        var jose = autorRepository.findById(idAutor).orElse(null);

        livroParaAtualizar.setAutor(jose);

        repository.save(livroParaAtualizar);


    }
}