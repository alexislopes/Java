package Trab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {
	Scanner in= new Scanner(System.in);
	private List<Produto> produtos=new ArrayList<>();
	
	public boolean verifNome(String nome) {
		for(int c=0;c<produtos.size();c++)
			if(produtos.get(c).equals(nome))
				return false;
		return true;
	}
	
	public void  criarProduto() {
		boolean c=true;
		String nome="";
		List<String> teg;
		while(c) {
			System.out.println("Digite o nome do Produto");
			nome=in.next();
			if(verifNome(nome)) {
				System.out.println("Ja existe este produto!");
				break;
			}
		}
		teg=criarTeg();
		System.out.println("Digite a quantidade");
		int quantidade = in.nextInt();
		System.out.println("Digite o preco");
		float preco=in.nextFloat();
		Produto prod= new Produto(nome,teg,quantidade,preco);
		produtos.add(prod);
	}
	
	public void excluirProduto(String nome) {
		for(int c=0;c<produtos.size();c++)
			if(produtos.get(c).equals(nome))
				produtos.remove(c);
	}
	
	public List<String> criarTeg() {
		boolean c=true;
		List<String> teg=new ArrayList<>() ;
		while(c) {
			System.out.println("Digite as teg's a serem vinculadas");
			teg.add(in.next());
			System.out.println("Deseja vincular outra teg? 1-sim/qualquer outro numero-nao");
			int resp=in.nextInt();
			if(resp!=1)
				c=false;
		}
		return teg;
	}
}
