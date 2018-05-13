package aula;

import xml.Cidade;
import xml.Previsao;

import java.sql.SQLException;
import java.text.Normalizer;
import java.util.Scanner;

public class Manager {
    private Scanner scanner = new Scanner(System.in);
    private String id = "";
    CidadeReal newcr = new CidadeReal();
    URLCidade c = new URLCidade();
    URLPrevisao p = new URLPrevisao();

    public Manager() throws Exception {
        Banco b = new Banco();
        b.conectar();
        intro(b);
    }

    public void intro(Banco b) throws Exception {
        System.out.println("Entre com a cidade: ");
        String city = scanner.nextLine();
        String r = c.getXMLCidade(city);

        // System.out.println(r);
        Cidade[] lista = c.xmlToObjectCidade(r);
        System.out.println(lista.length);
        int escolhido = 0;
        id = lista[0].getId();

        if (lista.length > 1) {
            for (int i = 0; i < lista.length; i++) {
                System.out.println("<" + i + "> --- " + lista[i].getNome() + " - " + lista[i].getUf());
            }
            System.out.println("Escolha uma das cidades:");
            escolhido = scanner.nextInt();
        }
        newcr.cidadeReal(lista[escolhido]);
        //id = lista[escolhido].getId();
        id = newcr.getId();

        city = lista[escolhido].getNome();
        String s = p.getXMLPrevisao(id);

        b.insertCidade(newcr);
        Previsao[] listaprev = p.xmlToObjectPrevisao(s);

        System.out.println("\nPrevisão da cidade de " + newcr.getNome() + " - " + newcr.getUf() + "\n");
        for (Previsao previsao : listaprev) {
            System.out.println(previsao);
        }
    }
}

