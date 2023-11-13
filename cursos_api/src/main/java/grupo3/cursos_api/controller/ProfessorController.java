package grupo3.cursos_api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import grupo3.cursos_api.controller.dto.ProfessorDto;
import grupo3.cursos_api.controller.form.ProfessorForm;
import grupo3.cursos_api.modelo.Professor;
import grupo3.cursos_api.repository.ProfessorRepository;

@RestController
@CrossOrigin
@RequestMapping("/professores")
public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;
	
	@GetMapping
	public List<ProfessorDto> lista() {
		List<Professor> professores = professorRepository.findAll();
		return ProfessorDto.converter(professores);
	}
	
	@PostMapping
	public ResponseEntity<ProfessorDto> cadastrar(@RequestBody ProfessorForm form, UriComponentsBuilder uriBuilder) {
		Professor professor = form.converter(professorRepository);
		professorRepository.save(professor);
		
		URI uri = uriBuilder.path("/professores/{id}").buildAndExpand(professor.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProfessorDto(professor));
	}
}
