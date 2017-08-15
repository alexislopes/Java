package br.com.fatec;
import java.util.Scanner;


public class BrComFatec {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int setup;
        
        System.out.println("1 - Operações\n2 - Soma, Média e Crescente\n3 - Maior e Menor\n");
        System.out.print("Escolha um exercicio: ");
        setup = ler.nextInt();
        
        if(setup == 1){
            System.out.println("\n\t 1 - Operações\n");
                   
            int a, b;
            int soma, sub, div, pro;
        
        
            System.out.print("Digite um inteiro: ");
            a = ler.nextInt();
        
            System.out.print("Digite mais um: ");
            b = ler.nextInt();
        
            soma = a+b; sub = a-b; div = a/b; pro=a*b;
              
    
        
            System.out.printf("\nSOMA: %d\nSUBTRAÇÃO: %d\nDIVISÃO: %d\nPRODUTO: %d\n", soma, sub, div, pro);}
        
        if(setup == 2){
            System.out.println("\n\t 2 - Soma, media e crescente\n");
            
            int a, b;
            int soma;
            float media;
            
            System.out.print("Primeiro Número: ");
            a = ler.nextInt();
            System.out.print("Segundo Número: ");
            b = ler.nextInt();
            
            soma = a+b; media=soma/2;
            
            System.out.printf("SOMA: %d\nMÉDIA: %.1f\n", soma, media);
            if(a<b){
                System.out.printf("CRESCENTE: %d %d\n", a,b);
            } else{System.out.printf("CRESCENTE: %d %d\n", b, a);}}
        
        if(setup == 3){
            System.out.println("\n\t 3 - Maior e Menor\n");
            
            int v[] = new int[5];
            int maior = 0, menor = 0;
            
            for(int i = 0; i < v.length; i++){
                System.out.printf("Digite o %dº numero: ", i+1);
                v[i] = ler.nextInt();
                if(v[i] > maior){
                    maior = v[i];} else menor = v[i];
            }
            for (int j = 0; j < v.length; j++){
                if(v[j] < menor){
                    menor = v[j]; 
                }
            }
            System.out.printf("Maior: %d\nMenor: %d\n", maior, menor);
            
        }
       
                
        
        
    }
    
}
