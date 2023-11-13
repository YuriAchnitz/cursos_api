package grupo3.cursos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import grupo3.cursos_api.modelo.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
}
