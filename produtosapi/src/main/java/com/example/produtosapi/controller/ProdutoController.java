package com.example.produtosapi.controller;

import com.example.produtosapi.model.Produto;
import com.example.produtosapi.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public void salvar(@RequestBody Produto produto) {

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        System.out.println("Produto recebido = " + produto);
        produtoRepository.save(produto);
    }


    @GetMapping("/{id}")
    public Produto obterProdutoPorId(@PathVariable("id") String id) {
        return produtoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping()
    public List<Produto> obterProdutoPorParametro(@RequestParam("nome") String nome) {
        return produtoRepository.findByNome(nome);
    }

    @PutMapping("{id}")
    public void atualizarProdutoPorId(@PathVariable("id") String id, @RequestBody Produto produto) {
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @DeleteMapping("/{id}")
    public void excluirProdutoPorId(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }

}
