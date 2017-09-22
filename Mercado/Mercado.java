package Trab;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mercado {
    Estoque e = new Estoque();
    Administrador adm = new Administrador();
    Scanner lernum = new Scanner(System.in);
    Scanner lerstr = new Scanner(System.in);

    private List<Usuario> admins = new ArrayList<>();
    private List<Usuario> clientes = new ArrayList<>();

    String vermelho = "\033[31m";
    String verde = "\033[32m";
    String amarelo = "\033[33m";
    String azul = "\033[34m";
    String roxo = "\033[35m";
    String verdim = "\033[36m";
    String cinza = "\033[37m";
    String limpo = "\033[m";

/////////////////////////////////////////////// MÉTODO DE INICIO \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    public void intro() throws Exception {
        int option;
        System.out.println("************************* LOJA ***********************");
        System.out.println("**   1 - ENTRAR   2 - CADASTRAR-SE   3 - ENCERRAR   **");
        System.out.println("******************************************************");
        option = lernum.nextInt();


        switch (option) {
            case 1:
                login();
                break;

            case 2:
                cadUser();
                break;
            case 3:
                System.out.println("Volte sempre!");
                break;

        }

    }

////////////////////////////////////////// MÉTODO DE CADASTRO DE USUARIO \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void cadUser() throws Exception {
        int option;
        System.out.println("********* VOCE É? *********");
        System.out.println("   1 - ADM   2 - CLIENTE   ");
        System.out.println("********* ESCOLHA *********");
        option = lernum.nextInt();

        if (option == 1) {
            int codigo;
            do {
                System.out.print("Digite o código de ADMs: ");
                codigo = lernum.nextInt();
                if (codigo != adm.getCodigo()) {
                    System.out.println(vermelho + "Este não é o codigo de ADMs!\n" + limpo);
                }
            } while (codigo != adm.getCodigo());
        }


        boolean valid = false;
        String nome;

        System.out.print("Digite seu nome de usuário: ");
        nome = lerstr.nextLine();

        String senha, senha2;
        do {
            System.out.print("Digite sua senha: ");
            senha = lerstr.nextLine();

            System.out.print("Digite novamente sua senha: ");
            senha2 = lerstr.nextLine();
            if (senha.equals(senha2)) {
                System.out.println(verdim + "\nCadastro efetuado com sucesso!" + limpo);
            } else {
                System.out.println(vermelho + "As senhas não coincidem!\n" + limpo);
            }
        } while (!senha.equals(senha2));

        Usuario novoUser;

        switch (option) {
            case 1:
                novoUser = new Administrador();
                novoUser.setUser(nome);
                novoUser.setSenha(senha);
                admins.add(novoUser);
                storeInfo(novoUser);
                break;
            case 2:
                novoUser = new Cliente();
                novoUser.setUser(nome);
                novoUser.setSenha(senha);
                clientes.add(novoUser);
                storeInfo(novoUser);
                break;
        }


    }

/////////////////////////////////////////////// MÉTODO DE LOGIN \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void login() throws Exception {
        Usuario o;
        int option;
        boolean valid;
        System.out.println("********* VOCE É? *********");
        System.out.println("   1 - ADM   2 - CLIENTE   ");
        System.out.println("********* ESCOLHA *********");
        option = lernum.nextInt();

        System.out.print("Digite o nome de usuário: ");
        String nome = lerstr.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = lerstr.nextLine();

        if (option == 1) {
            o = new Administrador();
            valid = validarUser(nome, senha, o);
        } else {
            o = new Cliente();
            valid = validarUser(nome, senha, o);
        }

        if (!valid) {
            System.out.println(vermelho + "Não estamos reconhecendo esses dados\n" + limpo);
            intro();
        } else {
            telaPrincipal(o);
        }

    }

////////////////////////////////////////// MÉTODO PARA VALIDAR USUÁRIO \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public boolean validarUser(String user1, String senha1, Usuario o) throws IOException {
        FileReader arquivo;
        BufferedReader caminho;

        if (o instanceof Administrador) {
            arquivo = new FileReader("d:\\Administradores.txt");
            caminho = new BufferedReader(arquivo);

        } else {
            arquivo = new FileReader("d:\\Clientes.txt");
            caminho = new BufferedReader(arquivo);

        }

        String linha = "";
        boolean controle = true;

        while (controle) {
            while (!linha.contains(user1)) {
                linha = caminho.readLine();
                if (linha == null) {
                    return false;
                }
            }
            controle = false;
        }
        arquivo.close();
        if (linha.contains(user1) && linha.contains(senha1)) {
            System.out.println(verdim + "Validado!" + limpo + "\n");
            return true;
        } else {
            return false;
        }

    }

/////////////////////////////////// MÉTODO PARA GUARDAR INFORMAÇÕES DO USUÁRIO \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    public void storeInfo(Usuario o) throws IOException {

        if (o instanceof Administrador) {
            FileWriter arq = new FileWriter("d:\\Administradores.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            for (Usuario administrador : admins) {
                gravarArq.println(administrador.getUser() + " " + administrador.getSenha());
            }
            gravarArq.close();
        } else if (o instanceof Cliente) {
            FileWriter arq = new FileWriter("d:\\Cliente.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            for (Usuario cliente : clientes) {
                gravarArq.println(cliente.getUser() + " " + cliente.getSenha());
            }
            gravarArq.close();
        }

        System.out.println(verdim + "Dados salvos na base de dados" + limpo);

    }

/////////////////////////////////////////// MÉTODO DE TELA PRINCIPAL \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void telaPrincipal(Usuario o) throws Exception {
        if (o instanceof Administrador) {
            int option;
            do {
                System.out.println("********************** OPÇÕES DE ADM *********************");
                System.out.println("**   1 - ADD PRODUTO   2 - LISTAR PRODUTOS   3 - SAIR   **");
                System.out.println("**********************************************************");
                option = lernum.nextInt();

                switch (option) {
                    case 1:
                        e.addProduto();
                        break;
                    case 2:
                        e.listarProdutos();
                        break;

                    case 3:
                        intro();
                        break;

                }
            } while (option != 3);
        }

    }

/////////////////////////////////////////// MÉTODO PARA ADD PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

   /* public void addProduto() {
        ArrayList<String> tags = new ArrayList<>();
        System.out.print("Digite um nome para o produto: ");
        String nome = lerstr.nextLine();
        System.out.print("Digite a quantidade do produto: ");
        int quantidade = lernum.nextInt();
        System.out.print("Digite  o preço do produto: ");
        double preco = lernum.nextDouble();
        int option;
        System.out.println("Deseja adidcionar algumas tags? ");
        System.out.print("\t1 - SIM    2 - NÃO");
        option = lernum.nextInt();
        if (option == 1) {
            String tag;
            int qtdade;
            System.out.print("Quantas? ");
            qtdade = lernum.nextInt();
            for (int i = 0; i < qtdade; i++) {
                System.out.print("Digite a tag: ");
                tag = lerstr.nextLine();
                tags.add(tag);
            }
        } else {
            System.out.println(verde + "Tudo bem, você pode adicionar mais tarde!" + limpo);
        }
        Produto novo = new Produto(nome, tags, quantidade, preco);
        produtos.add(novo);
        System.out.println(verdim + "\nProduto cadastrado com sucesso!" + limpo);
    }*/

////////////////////////////////////////// MÉTODO PARA LISTAR PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

   /* public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println(verde + "Ainda não há nenhum produto\n" + limpo);
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto.dadosFormatados());
            }
        }
    }*/


}
