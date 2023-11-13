package grupo3.cursos_api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import grupo3.cursos_api.modelo.Curso;

public class CursoDto {
	private Long id;
	private String nome;
	private int preco;
	
	public CursoDto(Curso curso) {
		super();
		this.id = curso.getId();
		this.nome = curso.getNome();
		this.preco = curso.getPreco();
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

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public static List<CursoDto> converter(List<Curso> cursos) {
		return cursos.stream().map(CursoDto::new).collect(Collectors.toList());
	}

}
