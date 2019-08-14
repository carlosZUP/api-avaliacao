package br.com.zup.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.models.Receita;
import br.com.zup.services.ReceitaService;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

	@Autowired
	private ReceitaService receitaService;

	@GetMapping
	public ResponseEntity pegarReceita() {
		if (receitaService.quantidadeDeReceitas() > 0) {
			return ResponseEntity.ok(receitaService.mostrarReceita());
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> pegarReceita(@PathVariable int id) {
		try {
			Receita receita = receitaService.pegarPeloId(id);
			return ResponseEntity.ok(receita);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@PostMapping
	public ResponseEntity<?> criarReceita(@Valid @RequestBody Receita receita) {
		try {
			receitaService.criarReceita(receita);
			return ResponseEntity.status(HttpStatus.CREATED).body(receita);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarMensagem(@PathVariable int id, @Valid @RequestBody Receita receita) {
		receitaService.atualizarReceita(id, receita);
		return ResponseEntity.ok(receita);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> apagarMensagem(@PathVariable int id) {
		receitaService.deletarPeloId(id);
		return ResponseEntity.ok().build();
	}
	
}

