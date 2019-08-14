package br.com.zup.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.zup.exceptions.ReceitaException;
import br.com.zup.models.Receita;
import br.com.zup.repositories.ReceitaRepository;

@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository receitaRepository;

	// CREATE
	public void criarReceita(Receita receita) {
		receitaRepository.save(receita);
	}

	// VIZUALIZAR RECEITAS
	public Iterable<Receita> mostrarReceita() {
		return receitaRepository.findAll();
	}

	// VISUALIZAR RECEITAS PELO ID
	public Receita pegarPeloId(int id) {
		return receitaRepository.findById(id).get();
	}

	// ATUALIZAR RECEITA
	public void atualizarReceita(int id, Receita receita) {
		Optional<Receita> optionalReceita = receitaRepository.findById(id);
		if (!optionalReceita.isPresent()) {
			throw new ReceitaException("Não há mensagens com o id...");
		}

		receitaRepository.findById(id);
		receitaRepository.save(receita);

	}

	// DELETAR PELO ID
	public void deletarPeloId(int id) {
		try {
			receitaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ReceitaException("Não há mensagnes com o id...");
		}
	}

	
	public long quantidadeDeReceitas() {
		return receitaRepository.count();
	
				
    }
}