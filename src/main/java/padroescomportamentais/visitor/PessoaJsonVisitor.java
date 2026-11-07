package padroescomportamentais.visitor;

public class PessoaJsonVisitor implements Visitor {

    public String exibir(Pessoa pessoa) {
        return pessoa.aceitar(this);
    }

    @Override
    public String exibirAluno(Aluno aluno) {
        return "{"
                + "\"tipo\":\"Aluno\","
                + "\"matricula\":" + aluno.getMatricula() + ","
                + "\"nome\":\"" + escapar(aluno.getNome()) + "\","
                + "\"curso\":\"" + escapar(aluno.getNomeCurso()) + "\""
                + "}";
    }

    @Override
    public String exibirProfessor(Professor professor) {
        return "{"
                + "\"tipo\":\"Professor\","
                + "\"matricula\":" + professor.getMatricula() + ","
                + "\"nome\":\"" + escapar(professor.getNome()) + "\","
                + "\"titulacao\":\"" + escapar(professor.getTitulacao()) + "\""
                + "}";
    }

    @Override
    public String exibirFuncionario(Funcionario funcionario) {
        return "{"
                + "\"tipo\":\"Funcionario\","
                + "\"codigo\":" + funcionario.getCodigo() + ","
                + "\"nome\":\"" + escapar(funcionario.getNome()) + "\","
                + "\"salario\":" + funcionario.getSalario()
                + "}";
    }

    private String escapar(String valor) {
        return valor
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}
