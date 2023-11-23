package grupo3.cursos_api.modelo_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import grupo3.cursos_api.modelo.Aluno;
import grupo3.cursos_api.modelo.Curso;

public class AlunoUnitTest {
	
	@Test
	public void deveAdicionarMoedas() {
		Aluno aluno = new Aluno("Pedro", 15);
		assertEquals(15, aluno.getMoedas());
		
		aluno.addMoedas(20);
		
		assertEquals(35, aluno.getMoedas());
	}
	
	@Test
	public void deveSubtrairMoedas() {
		Aluno aluno = new Aluno("Pedro", 20);
		assertEquals(20, aluno.getMoedas());
		
		aluno.subMoedas(15);
		
		assertEquals(5, aluno.getMoedas());
	}
	
	@Test
	public void testAlunoEquals() {
		Aluno aluno = new Aluno("Roberto", 14);
		Aluno aluno_copia = aluno;
		
		Aluno aluno2 = new Aluno("Robson", 12);
		aluno2.setId((long)999);
		
		Curso curso = new Curso();
		
		//É o mesmo objeto
		assertTrue(aluno.equals(aluno_copia));
		
		//Não é null
		assertFalse(aluno.equals(null));
		
		//Não é outra classe de objeto
		assertFalse(aluno.equals(curso));
		
		//Id de aluno é null e de aluno2 não
		assertFalse(aluno.equals(aluno2));
		
		//Os ids são diferentes
		aluno.setId((long)555);
		assertFalse(aluno.equals(aluno2));
		
		//Os ids são iguais
		aluno2.setId((long)555);
		assertTrue(aluno.equals(aluno2));
		
		//Os ids são iguais e null
		aluno.setId(null);
		aluno2.setId(null);
		assertTrue(aluno.equals(aluno2));
	}
	
	@Test
	public void testAlunoHash() {
		Aluno aluno = new Aluno();
		
		//Valor de id null
		assertEquals(31, aluno.hashCode());
		
		//Valor esperado de id 999
		aluno.setId((long)999);
		assertEquals(1030, aluno.hashCode());
	}
}
