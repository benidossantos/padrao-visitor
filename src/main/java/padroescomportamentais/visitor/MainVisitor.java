package padroescomportamentais.visitor;

public class MainVisitor {

    public static void main(String[] args) {
        Pessoa aluno = new Aluno(1, "Ana", new Curso("Sistemas de Informação"));
        Pessoa professor = new Professor(1, "Maria", "Doutorado");
        Pessoa funcionario = new Funcionario(1, "Pedro", 5000.0f);

        PessoaVisitor visitor = new PessoaVisitor();
        PessoaJsonVisitor jsonVisitor = new PessoaJsonVisitor();

        System.out.println("Exibição tradicional:");
        System.out.println(visitor.exibir(aluno));
        System.out.println(visitor.exibir(professor));
        System.out.println(visitor.exibir(funcionario));

        System.out.println();
        System.out.println("Exibição em JSON:");
        System.out.println(jsonVisitor.exibir(aluno));
        System.out.println(jsonVisitor.exibir(professor));
        System.out.println(jsonVisitor.exibir(funcionario));
    }
}
