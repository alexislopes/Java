package br.com.fatec;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Agenda {
    Scanner lernum;
    Scanner lerstr;
    private ArrayList<Aluno> alunos;
    private ArrayList<Professor> professores;

    public Agenda() {
        lernum = new Scanner(System.in);
        lerstr = new Scanner(System.in);
        alunos = new ArrayList<>();
        professores = new ArrayList<>();

    }

    public void addAluno() {
        Aluno novo = new Aluno();


        System.out.print("Nome: ");
        String nome = lerstr.nextLine();
        novo.setNome(nome);

        System.out.print("Telefone: ");
        long telefone = lernum.nextLong();
        novo.setTelefone(telefone);

        System.out.print("Email: ");
        String email = lerstr.nextLine();
        novo.setEmail(email);

        System.out.print("Matricula: ");
        long matricula = lernum.nextLong();
        novo.setNumeroMatricula(matricula);

        alunos.add(novo);
    }


    public void addProfessor() {
        Professor novo = new Professor();

        System.out.print("Nome: ");
        String nome = lerstr.nextLine();
        novo.setNome(nome);

        System.out.print("Telefone: ");
        long telefone = lernum.nextLong();
        novo.setTelefone(telefone);

        System.out.print("Email: ");
        String email = lerstr.nextLine();
        novo.setEmail(email);

        System.out.print("Nº de Registro: ");
        long registro = lernum.nextLong();
        novo.setNumeroRegistro(registro);

        System.out.print("Horas aula: ");
        int horaAula = lernum.nextInt();
        novo.setQuantidadeHoraAula(horaAula);


        professores.add(novo);
    }

    public void listarTodos() throws IOException {

        System.out.println("\n LISTA DE ALUNOS *********************");
        if (alunos.isEmpty()) {
            System.out.println("\t\t\t\t   Ainda sem contatos!");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println(aluno.dadosFormatados());
            }
        }

        System.out.println("\nLISTA DE PROFESSORES ****************");
        if (professores.isEmpty()) {
            System.out.println("\t\t\t\t   Ainda sem contatos!");
        } else {
            for (Professor professor : professores) {
                System.out.println(professor.dadosFormatados());
            }
        }

        opcoesDeContato();
    }

    public void opcoesDeContato() throws IOException {
        int escolha;
        System.out.println();
        System.out.println("\t************************* OPCÇÕES DE CONTATO ************************");
        System.out.println("\t** 1  - Excluir      2 - editar       3 - voltar       4 - salvar  **");
        System.out.println("\t*********************************************************************");
        System.out.print("Escolha uma das opçôes: ");
        escolha = lernum.nextInt();

        switch (escolha) {

            case 1:
                int choice;
                System.out.println();
                System.out.println("\t**************** VOCÊ DESEJA EXCLUIR  ****************");
                System.out.println("\t** 1  - Aluno       2 - Professor       3 - voltar  **");
                System.out.println("\t******************************************************");
                System.out.println("Escolha uma das opcçôes: ");
                choice = lernum.nextInt();
                if (choice == 1) { // ESCOLHEU ALUNO.
                    long matr;
                    System.out.print("Digite o numero da matricula: ");
                    matr = lernum.nextLong();

                    for (int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getNumeroMatricula() == matr) {
                            int opc;
                            System.out.print("\nVocê realmente deseja excluir " + alunos.get(i).getNome() + "?");
                            System.out.print("\n\t1 - sim    2 - não ");
                            opc = lernum.nextInt();
                            if (opc == 1) {
                                alunos.remove(i);
                                System.out.println("aluno removido com sucesso!");
                            }
                        }
                    }
                } else { // ESCOLHEU PROFESSOR
                    long reg;
                    System.out.print("Digite o numero de registro: ");
                    reg = lernum.nextLong();

                    for (int i = 0; i < professores.size(); i++) {
                        if (professores.get(i).getNumeroRegistro() == reg) {
                            int opc1;
                            System.out.print("\nVocê realmente deseja excluir " + professores.get(i).getNome() + "?");
                            System.out.print("\n\t1 - sim    2 - não ");
                            opc1 = lernum.nextInt();
                            if (opc1 == 1) {
                                professores.remove(i);
                                System.out.println("professor removido com sucesso!");
                            }
                        }
                    }
                }
                break;

            case 2:
                editar();

            case 3:
                break;
            case 4:
                escreveTodos();
                break;
        }
    }

    public void editar() {
        int escolha;
        System.out.println("\t*************** VOCÊ DESEJA EDIITAR  ***************");
        System.out.println("\t** 1  - Aluno      2 - Professor       3 - voltar **");
        System.out.println("\t****************************************************");
        escolha = lernum.nextInt();
        if (escolha == 1) { // ESCOLHEU ALUNO.
            opcoes();
            int atributo = lernum.nextInt();

            switch (atributo) {
                case 1:
                    editarNomeAluno();
                    break;
                case 2:
                    editarTelefoneAluno();
                    break;
                case 3:
                    editarEmailAluno();
                    break;
                case 4:
                    break;
            }
        } else if (escolha == 2) { //ESCOLHEU PROFESSOR
            opcoes();
            int atributo = lernum.nextInt();

            switch (atributo) {
                case 1:
                    editarNomeProfessor();
                    break;
                case 2:
                    editarTelefoneProfessor();
                    break;
                case 3:
                    editarEmailProfessor();
                    break;
                case 4:
                    break;
            }
        }
    }

    public void intro() {
        System.out.println("************************** AGENDA ELETÔNICA  **************************");
        System.out.println("** 1  - Listar     2 - Adicionar      3 - Sair      4  - Ler arquivo **");
        System.out.println("***********************************************************************");
    }

    public void setup() {
        System.out.println("\n\t****** VOCÊ DESEJA ADICIONAR  *****");
        System.out.println("\t** 1  - Aluno      2 - Professor **");
        System.out.println("\t***********************************");
    }

    public void opcoes() {
        System.out.println("\t************************** QUAL ATRIBUTO  *************************");
        System.out.println("\t** 1  - Nome      2 - Telefone       3 - Email       4 - VOLTAR  **");
        System.out.println("\t*******************************************************************");
    }

    public void editarNomeAluno() {
        System.out.print("\nDigite o número de matrícula: ");
        long matr = lernum.nextLong();

        for (int i = 0; i < alunos.size(); i++) {
            if (matr == alunos.get(i).getNumeroMatricula()) {
                System.out.print("\nNovo nome para " + alunos.get(i).getNome() + ":");
                String nome = lerstr.nextLine();
                alunos.get(i).setNome(nome);
                System.out.print("Nome alterado para: " + alunos.get(i).getNome() + "!");
            }
        }
    }

    public void editarTelefoneAluno() {
        System.out.print("\nDigite o número de matrícula: ");
        long matr = lernum.nextLong();

        for (int i = 0; i < alunos.size(); i++) {
            if (matr == alunos.get(i).getNumeroMatricula()) {
                System.out.print("\nNovo número de telefone para " + alunos.get(i).getNome() + ":");
                long numero = lernum.nextLong();
                alunos.get(i).setTelefone(numero);
                System.out.print("Telefone alterado para: " + alunos.get(i).getTelefone() + "!");
            }
        }
    }

    public void editarEmailAluno() {
        System.out.print("\nDigite o número de matrícula: ");
        long matr = lernum.nextLong();

        for (int i = 0; i < alunos.size(); i++) {
            if (matr == alunos.get(i).getNumeroMatricula()) {
                System.out.print("\nNovo email para " + alunos.get(i).getNome());
                String email = lerstr.nextLine();
                alunos.get(i).setEmail(email);
                System.out.print("Email alterado para: " + alunos.get(i).getEmail() + "!");
            }
        }
    }

    public void editarNomeProfessor() {
        System.out.print("\nDigite o número de registro: ");
        long reg = lernum.nextLong();

        for (int i = 0; i < professores.size(); i++) {
            if (reg == professores.get(i).getNumeroRegistro()) {
                System.out.print("\nNovo nome para" + professores.get(i).getNome() + ":");
                String nome = lerstr.nextLine();
                professores.get(i).setNome(nome);
                System.out.println("Nome alterado para: " + professores.get(i).getNome() + "!");
            }
        }
    }

    public void editarTelefoneProfessor() {
        System.out.print("\nDigite o número de registro: ");
        long reg = lernum.nextLong();

        for (int i = 0; i < professores.size(); i++) {
            if (reg == professores.get(i).getNumeroRegistro()) {
                System.out.print("\nNovo número para" + professores.get(i).getNome() + ":");
                long telefone = lernum.nextLong();
                professores.get(i).setTelefone(telefone);
                System.out.println("Telefone alterado para: " + professores.get(i).getTelefone() + "!");
            }
        }
    }

    public void editarEmailProfessor() {
        System.out.print("\nDigite o número de registro: ");
        long reg = lernum.nextLong();

        for (int i = 0; i < professores.size(); i++) {
            if (reg == professores.get(i).getNumeroRegistro()) {
                System.out.print("\nNovo email para" + professores.get(i).getNome() + ":");
                String email = lerstr.nextLine();
                professores.get(i).setEmail(email);
                System.out.println("Email alterado para: " + professores.get(i).getEmail() + "!");
            }
        }
    }


    Date data = new Date();

    public void escreveTodos() throws IOException {
        System.out.print("Digite o nome do arquivo: ");
        String nome = lerstr.nextLine();

        FileWriter arq = new FileWriter("d:\\" + nome + ".txt");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf("LISTA DOS ALUNOS %n");
        for (Aluno aluno : alunos) {
            if (alunos.isEmpty()) {
                gravarArq.print("Ainda sem contatos!");
            } else {
                gravarArq.println(aluno.dadosFormatados());
            }
        }

        gravarArq.printf("%nLISTA DOS PROFESSORES%n");
        for (Professor professor : professores) {
            if (professores.isEmpty()) {
                gravarArq.print("Ainda sem contatos!");
            } else {
                gravarArq.println(professor.dadosFormatados());
            }
        }

        gravarArq.printf("%n+------------------------------------------------+%n");
        gravarArq.printf("|Ultima atualização: " + data + "|%n");
        gravarArq.printf("+------------------------------------------------+%n");

        arq.close();
        System.out.println("\nAgenda salva com sucesso em d:\\" + nome + ".\n");
    }

    public void leTodos() throws IOException {

        System.out.print("Digite o nome do arquivo a ser lido: ");
        String nome = lerstr.nextLine();

        BufferedReader buffRead = new BufferedReader(new FileReader("d:\\" + nome + ".txt"));
        String linha = "";

        while (true) {
            if (linha != null) {
                System.out.println(linha);
            } else {
                break;
            }
            linha = buffRead.readLine();
        }
        buffRead.close();
    }


    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }
}
