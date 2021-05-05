package br.com.zupacademy.romeu.casadocodigo.livro;

import br.com.zupacademy.romeu.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.romeu.casadocodigo.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

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

  @GetMapping
  public ResponseEntity<Page<LivroResponse>> listaTodosOsLivros() {
    PageRequest pageRequest = PageRequest.of(0, 10, Sort.Direction.ASC, "id");
    Page<Livro> livros = livroRepository.findAll(pageRequest);
    Page<LivroResponse> listLivroResponse = livros.map(LivroResponse::new);
    return ResponseEntity.ok().body(listLivroResponse);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> buscaLivroPorId(@PathVariable("id") @Valid Long id) {
    Optional<Livro> optLivro = livroRepository.findById(id);

    if (optLivro.isEmpty()) {
      return ResponseEntity.notFound().build();
    } else {
      LivroDetalheResponse livroDetalheResponse = new LivroDetalheResponse(optLivro.get());
      return ResponseEntity.ok().body(livroDetalheResponse);
    }
  }

}
