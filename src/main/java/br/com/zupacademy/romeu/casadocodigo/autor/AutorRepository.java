package br.com.zupacademy.romeu.casadocodigo.autor;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutorRepository extends CrudRepository<Autor, Long> {

  public Optional<Autor> findByEmail(String email);
}
