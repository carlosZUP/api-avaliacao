package br.com.zup.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.models.Receita;

@Repository
public interface ReceitaRepository extends CrudRepository<Receita, Integer>{

}
