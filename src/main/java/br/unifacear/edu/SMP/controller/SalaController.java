package br.unifacear.edu.SMP.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.unifacear.edu.SMP.entity.Sala;
import br.unifacear.edu.SMP.repository.SalaRepository;

@CrossOrigin(origins = "*")
@RestController
public class SalaController {

	@Autowired
	SalaRepository salaRepository;
	
	@GetMapping("/salas")
	public List<Sala> listaSalas(){
		return salaRepository.findAll();
	}
	
	@GetMapping("/sala/{id}")
	public Sala listarSalaUnico(@PathVariable(value="id") long  id) {
		return salaRepository.findById(id);
	}
	
	@PostMapping("/sala")
	public Sala salvarSala(@RequestBody @Valid Sala sala) {
		return salaRepository.save(sala);
	}
	
	@DeleteMapping("/sala")
	public void excluirSala(@RequestBody @Valid Sala sala) {
		salaRepository.delete(sala);
	}
	
	@PutMapping("/sala")
	public Sala atualizarSala(@RequestBody @Valid Sala sala) {
		return salaRepository.save(sala);
	}
}
