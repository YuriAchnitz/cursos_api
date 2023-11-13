package grupo3.cursos_api.controller.form;

import grupo3.cursos_api.modelo.Professor;
import grupo3.cursos_api.repository.ProfessorRepository;

public class ProfessorForm {
	private String nome;
	private String matricula;

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

	public Professor converter(ProfessorRepository professorRepository) {
		return new Professor(nome, matricula);
	}
}
