package appagenda;
import java.util.Scanner;

public class AppAgenda {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int nu, setup, j = 0; String n, e;
        
        
        
        
        System.out.print("1 - Agenda\n2 - Adicionar contato\nEscolha um serviço: ");
        setup = ler.nextInt();
        
        
            
        Pessoa[] contatos = new Pessoa[j+1];
            for(int i=0; i<contatos.length; i++){
                contatos[i] = new Pessoa();
                
        while(setup != 0){
            
            
            
            if (setup == 2){
                j = j + 1;
                
                
                System.out.print("\nDiga-me seu nome: ");
                ler.nextLine();
                n = ler.nextLine();
                contatos[i].setNome(n);
        
                System.out.print("\nDiga-me seu telefone: ");
                nu = ler.nextInt();
                contatos[i].setNumero(nu);
        
                System.out.print("\nDiga-me seu e-mail: ");
                e = ler.next();
                contatos[i].setEmail(e);
            
                System.out.print("\n\tCONTATO SALVO COM SUCESSO\n");
                
                        
               } 
            if(setup == 1){ 
                for (Pessoa contato : contatos) {
                    System.out.println(contato.getNome());
                }
                System.out.print("\nEscolha um contato: ");
                int escolha;
                escolha = ler.nextInt();
                for(int k=0; k<contatos.length; k++){
                    if(escolha == k){
                        contatos[k].status();}}
                }
            
            System.out.print("\n0 - sair\n1 - Agenda\n2 - Novo Contato\nEscolher serviço: ");
            setup = ler.nextInt();  
      }       
    }  
  }
}
