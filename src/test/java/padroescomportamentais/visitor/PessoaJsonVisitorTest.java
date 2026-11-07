package padroescomportamentais.visitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaJsonVisitorTest {

    @Test
    void deveExibirAlunoEmJson() {
        Aluno aluno = new Aluno(1, "Ana", new Curso("Sistemas de Informação"));
        PessoaJsonVisitor visitor = new PessoaJsonVisitor();

        assertEquals("{\"tipo\":\"Aluno\",\"matricula\":1,\"nome\":\"Ana\",\"curso\":\"Sistemas de Informação\"}",
                visitor.exibir(aluno));
    }

    @Test
    void deveExibirProfessorEmJson() {
        Professor professor = new Professor(1, "Maria", "Doutorado");
        PessoaJsonVisitor visitor = new PessoaJsonVisitor();

        assertEquals("{\"tipo\":\"Professor\",\"matricula\":1,\"nome\":\"Maria\",\"titulacao\":\"Doutorado\"}",
                visitor.exibir(professor));
    }

    @Test
    void deveExibirFuncionarioEmJson() {
        Funcionario funcionario = new Funcionario(1, "Pedro", 5000.0f);
        PessoaJsonVisitor visitor = new PessoaJsonVisitor();

        assertEquals("{\"tipo\":\"Funcionario\",\"codigo\":1,\"nome\":\"Pedro\",\"salario\":5000.0}",
                visitor.exibir(funcionario));
    }

    @Test
    void deveEscaparCaracteresEspeciaisNoJson() {
        Aluno aluno = new Aluno(1, "Ana \"Bia\"\n", new Curso("Sistemas"));
        PessoaJsonVisitor visitor = new PessoaJsonVisitor();

        assertEquals("{\"tipo\":\"Aluno\",\"matricula\":1,\"nome\":\"Ana \\\"Bia\\\"\\n\",\"curso\":\"Sistemas\"}",
                visitor.exibir(aluno));
    }
}
