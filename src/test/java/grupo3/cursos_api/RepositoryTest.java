package grupo3.cursos_api;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import grupo3.cursos_api.modelo.Aluno;
import grupo3.cursos_api.modelo.Curso;
import grupo3.cursos_api.modelo.Professor;
import grupo3.cursos_api.repository.AlunoRepository;
import grupo3.cursos_api.repository.CursoRepository;
import grupo3.cursos_api.repository.ProfessorRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class RepositoryTest {
	@Autowired
	private TestEntityManager em;

	@Test
	public void testeORM() {

	}

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
