package grupo3.cursos_api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import grupo3.cursos_api.modelo.Professor;

public class ProfessorDto {
	private Long id;
	private String nome;
	private String matricula;
	
	public ProfessorDto(Professor professor) {
		super();
		this.nome = professor.getNome();
		this.matricula = professor.getMatricula();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public static List<ProfessorDto> converter(List<Professor> professores) {
		return professores.stream().map(ProfessorDto::new).collect(Collectors.toList());
	}
}
