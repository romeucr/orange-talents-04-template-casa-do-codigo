package br.com.zupacademy.romeu.casadocodigo.estado;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EstadoRepository extends CrudRepository<Estado, Long> {
  public Optional<Estado> findByNomeAndPaisId(String nome, Long paisId);
  public  List<Optional<Estado>> findByPaisId(Long paisId);
}
