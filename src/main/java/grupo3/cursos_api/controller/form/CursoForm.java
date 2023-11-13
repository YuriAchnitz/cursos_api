package grupo3.cursos_api.controller.form;

import grupo3.cursos_api.modelo.Curso;
import grupo3.cursos_api.repository.CursoRepository;

public class CursoForm {
	private String nome;
	private int preco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public Curso converter(CursoRepository cursoRepository) {
		return new Curso(nome, preco);
	}

}
