package github.com.GustavoAraujoPires.libraryapi.repository;


import github.com.GustavoAraujoPires.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
