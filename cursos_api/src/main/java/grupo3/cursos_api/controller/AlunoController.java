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

import grupo3.cursos_api.controller.dto.AlunoDto;
import grupo3.cursos_api.controller.form.AlunoForm;
import grupo3.cursos_api.modelo.Aluno;
import grupo3.cursos_api.repository.AlunoRepository;

@RestController
@CrossOrigin
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public List<AlunoDto> lista() {
		List<Aluno> alunos = alunoRepository.findAll();
		return AlunoDto.converter(alunos);
	}
	
	@PostMapping
	public ResponseEntity<AlunoDto> cadastrar(@RequestBody AlunoForm form, UriComponentsBuilder uriBuilder) {
		Aluno aluno = form.converter(alunoRepository);
		alunoRepository.save(aluno);
		
		URI uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
		return ResponseEntity.created(uri).body(new AlunoDto(aluno));
	}
}