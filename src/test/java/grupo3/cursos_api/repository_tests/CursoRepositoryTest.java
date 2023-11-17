package grupo3.cursos_api.repository_tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import grupo3.cursos_api.modelo.Curso;
import grupo3.cursos_api.repository.CursoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")

public class CursoRepositoryTest {
	@Autowired
	private TestEntityManager em;

	@Autowired
	private CursoRepository curso_repository;

	@Test
	public void encontrarCursoPeloNome() {
		String nomeCurso = "Mecânica 1";

		Curso curso_mecanica = new Curso();
		curso_mecanica.setNome(nomeCurso);
		curso_mecanica.setPreco(40);
		em.persist(curso_mecanica);

		Curso curso = curso_repository.findByNome(nomeCurso);
		Assertions.assertNotNull(curso);
		Assertions.assertEquals(nomeCurso, curso.getNome());
	}

	@Test
	public void naoeEcontrarCursoPeloNome() {
		String nomeCurso2 = "Culinária";
		Curso curso_culinaria = curso_repository.findByNome(nomeCurso2);
		Assertions.assertNull(curso_culinaria);
	}
}
