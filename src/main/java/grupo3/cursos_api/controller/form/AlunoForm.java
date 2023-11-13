package grupo3.cursos_api.controller.form;

import grupo3.cursos_api.modelo.Aluno;
import grupo3.cursos_api.repository.AlunoRepository;

public class AlunoForm {
	private String nome;
	private int moedas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMoedas() {
		return moedas;
	}

	public void setMoedas(int moedas) {
		this.moedas = moedas;
	}

	public Aluno converter(AlunoRepository alunoRepository) {
		return new Aluno(nome, moedas);
	}
}
