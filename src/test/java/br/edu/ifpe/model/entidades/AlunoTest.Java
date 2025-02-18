package test.java.br.edu.ifpe.model.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.model.entidades.Aluno;

class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    void setUp() {
        aluno = new Aluno("1", "Gustavo");
    }

    @Test
    void MatricularEmDisciplinaMaximo() {
        aluno.matricularEmDisciplina("Disciplina1");
        aluno.matricularEmDisciplina("Disciplina2");
        aluno.matricularEmDisciplina("Disciplina3");
        aluno.matricularEmDisciplina("Disciplina4");
        aluno.matricularEmDisciplina("Disciplina5");

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            aluno.matricularEmDisciplina("Disciplina6");
        });

        assertEquals("O aluno já está matriculado no máximo de 5 disciplinas.", exception.getMessage());
    }
    
    @Test
    void MatricularEmDisciplinaSucesso() {
        aluno.matricularEmDisciplina("Sistemas Operacionais");
        aluno.matricularEmDisciplina("Software Corporativo");
        aluno.matricularEmDisciplina("Desenvolvimento Web 3");

        assertEquals(3, aluno.getDisciplinas().size());
        assertTrue(aluno.getDisciplinas().contains("Softare Corporativo"));
    }
}