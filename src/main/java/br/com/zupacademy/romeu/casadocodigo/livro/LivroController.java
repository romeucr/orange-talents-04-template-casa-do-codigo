package br.com.zupacademy.romeu.casadocodigo.livro;

import br.com.zupacademy.romeu.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.romeu.casadocodigo.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

  @Autowired
  private LivroRepository livroRepository;

  @Autowired
  private CategoriaRepository categoriaRepository;

  @Autowired
  private AutorRepository autorRepository;

  @PostMapping
  @Transactional
  public ResponseEntity<?> cadastraLivro(@RequestBody @Valid NovoLivroRequest novoLivroRequest) {
    Livro livro = novoLivroRequest.toModel(categoriaRepository, autorRepository);
    livroRepository.save(livro);
    return ResponseEntity.ok().build();
  }
}
