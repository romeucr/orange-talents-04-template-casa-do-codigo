package br.com.zupacademy.romeu.casadocodigo.livro;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends PagingAndSortingRepository<Livro, Long> {
}
