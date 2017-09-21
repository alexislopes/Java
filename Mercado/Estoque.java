package Trab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {
	Scanner in= new Scanner(System.in);
	private List<Produto> produto=new ArrayList<>();
	
	public void  criarProduto() {
		boolean c=true;
		List<String> teg=new ArrayList<>() ;
		System.out.println("Digite o nome do Produto");
		String nome=in.next();
		while(c) {
			System.out.println("Digite as teg's a serem vinculadas");
			teg.add(in.next());
			System.out.println("Deseja vincular outra teg? 1-sim/qualquer outro numero-nao");
			int resp=in.nextInt();
			if(resp!=1)
				c=false;
		}
		System.out.println("Digite a quantidade");
		int quantidade = in.nextInt();
		System.out.println("Digite o preco");
		float preco=in.nextFloat();
		Produto prod= new Produto(nome,teg,quantidade,preco);
	}
}
