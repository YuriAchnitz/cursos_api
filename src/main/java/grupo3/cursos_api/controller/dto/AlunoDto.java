package grupo3.cursos_api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import grupo3.cursos_api.modelo.Aluno;

public class AlunoDto {
	private Long id;
	private String nome;
	private int moedas;

	public AlunoDto(Aluno aluno) {
		super();
		this.id = aluno.getId();
		this.nome = aluno.getNome();
		this.moedas = aluno.getMoedas();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getMoedas() {
		return moedas;
	}

	public static List<AlunoDto> converter(List<Aluno> alunos) {
		return alunos.stream().map(AlunoDto::new).collect(Collectors.toList());
	}
	
}
