package br.com.fatec;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mercado {
    Estoque estoque = new Estoque();
    Usuario novoUser;
    Administrador administrador = new Administrador();


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
        System.out.println("*********** VOCE É? ***********");
        System.out.println("**   1 - ADM   2 - CLIENTE   **");
        System.out.println("*********** ESCOLHA ***********");
        option = lernum.nextInt();

        if (option == 1) {
            int codigo;
            do {
                System.out.print("Digite o código de ADMs: ");
                codigo = lernum.nextInt();
                if (codigo != administrador.getCodigo()) {
                    System.out.println(vermelho + "Este não é o codigo de ADMs!\n" + limpo);
                }
            } while (codigo != administrador.getCodigo());
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

        intro();

    }

/////////////////////////////////////////////// MÉTODO DE LOGIN \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void login() throws Exception {
        Usuario o;
        int option;
        boolean valid;
        System.out.println("*********** VOCE É? ***********");
        System.out.println("**   1 - ADM   2 - CLIENTE   **");
        System.out.println("*********** ESCOLHA ***********");
        option = lernum.nextInt();

        System.out.print("Digite o nome de usuário: ");
        String nome = lerstr.nextLine().toLowerCase();

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
                gravarArq.println(administrador.getUser().toLowerCase() + " " + administrador.getSenha());
            }
            gravarArq.close();
        } else if (o instanceof Cliente) {
            FileWriter arq = new FileWriter("d:\\Clientes.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            for (Usuario cliente : clientes) {
                gravarArq.println(cliente.getUser().toLowerCase() + " " + cliente.getSenha());
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
                        estoque.addProduto();
                        break;
                    case 2:
                        listarProdutos(o);
                        break;

                    case 3:
                        intro();
                        break;

                }
            } while (option != 3);
        } else {
            listarProdutos(o);
        }
    }
///////////////////////////////////////// MÉTODO PARA COMPRAR PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void comprarProduto() {

        boolean disp;

        System.out.print("Digite o ID do produto: ");
        lernum.next();
        int idprod = lernum.nextInt();

        for (int i = 0; i < estoque.getProdutos().size(); i++) {

            if (idprod == estoque.getProdutos().get(i).getId()) {
                System.out.print("Quantidade de " + estoque.getProdutos().get(i).getNome() + ": ");
                int quant = lernum.nextInt();
                disp = estoque.verificarQuantidade(idprod, quant);
                if (!disp) {
                    System.out.println(vermelho + "Desculpe, não temos essa quantidade em estoque!" + limpo + "temos apenas: " + estoque.getProdutos().get(i).getQuantidade());
                } else {
                    System.out.println(verde + "Você realmente deseja comprar" + limpo + " " + quant + " " + estoque.getProdutos().get(i).getNome() + verde + "?" + limpo);
                    System.out.println("\t1 - SIM   2 - NÃO");
                    int option = lernum.nextInt();


                    if (option == 1) {
                        double tpreco = estoque.getProdutos().get(i).getPreco() * quant;
                        System.out.println(verdim + "Obrigado pela compra, você gastou: R$ " + tpreco + limpo + "\n");
                        estoque.getProdutos().get(i).setQuantidade(estoque.getProdutos().get(i).getQuantidade() - quant);
                    } else {
                        System.out.println(verdim + "Tudo bem, você pode fazer isso depois!" + limpo);
                    }
                }
            } else {
                System.out.println(vermelho + "Desculpa mas esse produto não existe!" + limpo);
            }
        }
    }

///////////////////////////////////////////// MÉTODOS DE OPÇÕES DE PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void opcoesDeProd(Usuario o) throws Exception {


        if (o instanceof Cliente) {
            int option;


            System.out.println("******************** OPÇÕES DE PRODUTO PARA CLIENTE *******************");
            System.out.println("**   1 - COMPRAR   2 - COMENTAR   3 - VER COMENTÁRIOS   4 - VOLTAR   **");
            System.out.println("***********************************************************************");
            option = lernum.nextInt();

            switch (option) {
                case 1:
                    comprarProduto();
                    break;

                case 2:
                    commentProd(o);
                    break;

                case 3:
                    listarCommment();
                    break;

                case 4:
                    telaPrincipal(o);
                    break;
            }

        }

        if (o instanceof Administrador) {
            int option;


            System.out.println("********************* OPÇÕES DE PRODUTO PARA ADM *********************");
            System.out.println("**   1 - EDITAR   2 - COMENTAR   3 - VER COMENTÁRIOS   4 - VOLTAR   **");
            System.out.println("**********************************************************************");
            option = lernum.nextInt();

            switch (option) {
                case 1:
                    //METODO PARA EDITAR PRODUTO
                    break;
                case 2:
                    commentProd(o);
                    break;
                case 3:
                    listarCommment();
                    break;

                case 4:
                    telaPrincipal(o);
                    break;
            }

        }
    }

///////////////////////////////////////////// MÉTODOS PARA LISTAR PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void listarProdutos(Usuario o) throws Exception {
        estoque.varrerProduto();

        if (estoque.getProdutos().isEmpty()) {
            System.out.println(verde + "Ainda não há nenhum produto\n" + limpo);
        } else {
            System.out.println(amarelo + "\t   PRODUTOS\n" + limpo);
            for (Produto produto : estoque.getProdutos()) {
                System.out.println(produto.dadosFormatados());
            }
            opcoesDeProd(o);
        }
    }

///////////////////////////////////////////// MÉTODO PARA COMENTAR PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void commentProd(Usuario o) {

        int idProd;
        String comment;

        System.out.print("Digite o ID do produto: ");
        idProd = lernum.nextInt();
        for (Produto produto : estoque.getProdutos()) {
            if (idProd == produto.getId()) {
                System.out.print("Digite seu nome: ");
                String nome = lerstr.nextLine();
                System.out.print("Digite seu comentário sobre " + produto.getNome() + ": ");
                comment = lerstr.nextLine();
                comment = nome + ": " + comment;
                produto.getComents().add(comment);
                System.out.println(verdim + "Comentário adicionado!\n" + limpo);
            }
        }
    }

    /////////////////////////////////////////// MÉTODOS PARA LISTAR COMENTÁRIOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void listarCommment() {
        int idProd;
        System.out.println("Digite o ID do produto: ");
        idProd = lernum.nextInt();

        for (Produto produto : estoque.getProdutos()) {
            if (idProd == produto.getId()) {
                if (estoque.novo.getComents().isEmpty()) {
                    System.out.println(vermelho + "Ainda não há nenhumm comentário!" + limpo);
                } else {
                    System.out.println(amarelo + "COMENTÁRIOS SOBRE " + limpo + estoque.novo.getNome().toUpperCase() + ":");
                    for (String comment : estoque.novo.getComents()) {
                        System.out.println(comment);
                    }
                }
            }
        }

    }
}




