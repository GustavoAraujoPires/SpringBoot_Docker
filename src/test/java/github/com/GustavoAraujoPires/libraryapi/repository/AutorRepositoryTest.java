package github.com.GustavoAraujoPires.libraryapi.repository;

import github.com.GustavoAraujoPires.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@SpringBootTest //  anotação para indentificar que é uma classe de teste
public class AutorRepositoryTest {

      @Autowired
      AutorRepository repository;

      //@Test // Com essa anotação consigo rodar o teste
         public void salvarTest(){
             Autor autor = new Autor();
             autor.setNome("Gustavo");
             autor.setNacionalidade("Brasileiro");
             autor.setDataNascimento(LocalDate.of(1951, 1 , 31));

             var autorSalvo = repository.save(autor);
             System.out.println("Autor Salvo: " + autorSalvo);

    }

   // @Test
    public void atualizarTest(){
          var id = UUID.fromString("f417dbb3-1068-43bf-b843-ef8fb87f8a0a");// o fromString serve para converter uma String em um objeto

        Optional<Autor> possivelAutor = repository.findById(id);

        if(possivelAutor.isPresent()){
            Autor autorEncontrado = possivelAutor.get();

            System.out.println("Dados do Autor: ");
            System.out.println(autorEncontrado);

            autorEncontrado.setDataNascimento(LocalDate.of(2008, 3, 16));

            repository.save(autorEncontrado);
        }
    }

  // @Test
    public void listarTest(){
        List<Autor> listarTodos = repository.findAll();
        listarTodos.forEach(System.out::println);
    }

   // @Test
    public void countTest(){
        System.out.println("Contagem de autores: " + repository.count());
    }

    //@Test
    public void deletarPorIdTest(){
        var id = UUID.fromString("8f2f02d0-44b7-4dd7-b063-4ce0624eaf0f");
        repository.deleteById(id);
    }

    //@Test
    public void deletarTest(){
        var id = UUID.fromString("d6e77eed-b171-4958-8f52-fe83ea04ec9f");
        var gustavo = repository.findById(id).get();
        repository.delete(gustavo);
    }


}
