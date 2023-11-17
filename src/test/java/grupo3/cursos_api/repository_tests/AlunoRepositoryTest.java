package grupo3.cursos_api.repository_tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import grupo3.cursos_api.modelo.Aluno;
import grupo3.cursos_api.repository.AlunoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")

public class AlunoRepositoryTest {
	@Autowired
	private TestEntityManager em;
	
	@Autowired
	private AlunoRepository aluno_repository;
	
	@Test
	public void encontrarAlunoPeloNome() {
		String nomeAluno = "Ronaldo Fenômeno";

		Aluno aluno_ronaldo = new Aluno();
		aluno_ronaldo.setNome(nomeAluno);
		aluno_ronaldo.setMoedas(9);
		em.persist(aluno_ronaldo);

		Aluno aluno = aluno_repository.findByNome(nomeAluno);
		Assertions.assertNotNull(aluno);
		Assertions.assertEquals(nomeAluno, aluno.getNome());
	}

	@Test
	public void naoeEcontrarAlunoPeloNome() {
		String nomeAluno2 = "Ricardo";
		Aluno aluno = aluno_repository.findByNome(nomeAluno2);
		Assertions.assertNull(aluno);
	}
}
