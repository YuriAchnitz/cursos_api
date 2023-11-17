package grupo3.cursos_api.repository_tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import grupo3.cursos_api.modelo.Professor;
import grupo3.cursos_api.repository.ProfessorRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")

public class ProfessorRepositoryTest {
	@Autowired
	private TestEntityManager em;

	@Autowired
	private ProfessorRepository professor_repository;

	@Test
	public void encontrarProfessorPeloNomeOuMatricula() {
		String nomeProfessor = "Ednaldo Pereira";
		String matriculaProfessor = "EP2000";

		Professor professor_ednaldo = new Professor();
		professor_ednaldo.setNome(nomeProfessor);
		professor_ednaldo.setMatricula(matriculaProfessor);
		em.persist(professor_ednaldo);

		Professor professor = professor_repository.findByNome(nomeProfessor);
		Assertions.assertNotNull(professor);
		Assertions.assertEquals(nomeProfessor, professor.getNome());

		Professor professor2 = professor_repository.findByMatricula(matriculaProfessor);
		Assertions.assertNotNull(professor2);
		Assertions.assertEquals(matriculaProfessor, professor2.getMatricula());
	}

	@Test
	public void naoeEcontrarProfessorPeloNomeOuMatricula() {
		String nomeProfessor = "Jô Soares";
		String matriculaProfessor = "JS2000";

		Professor professor3 = professor_repository.findByNome(nomeProfessor);
		Assertions.assertNull(professor3);

		Professor professor4 = professor_repository.findByNome(matriculaProfessor);
		Assertions.assertNull(professor4);
	}
}
