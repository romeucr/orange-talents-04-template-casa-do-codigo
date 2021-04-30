package br.com.zupacademy.romeu.casadocodigo.categoria;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
  public Optional<Categoria> findByNome(String nome);
}
