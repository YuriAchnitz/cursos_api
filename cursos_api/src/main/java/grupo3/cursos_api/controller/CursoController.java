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

import grupo3.cursos_api.controller.dto.CursoDto;
import grupo3.cursos_api.controller.form.CursoForm;
import grupo3.cursos_api.modelo.Curso;
import grupo3.cursos_api.repository.CursoRepository;

@RestController
@CrossOrigin
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<CursoDto> lista() {
		List<Curso> cursos = cursoRepository.findAll();
		return CursoDto.converter(cursos);
	}
	
	@PostMapping
	public ResponseEntity<CursoDto> cadastrar(@RequestBody CursoForm form, UriComponentsBuilder uriBuilder) {
		Curso curso = form.converter(cursoRepository);
		cursoRepository.save(curso);
		
		URI uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
		return ResponseEntity.created(uri).body(new CursoDto(curso));
	}
}