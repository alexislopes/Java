package appagenda;

public class Pessoa {
    private String nome;
    private long numero;
    private String email;
    
    public Pessoa(){ // CONTRUCTOR.
        this.nome = "Informar Nome";
        this.numero = 99999999;
        this.email = "informar@email";
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String setNome(String n){
        return this.nome = n;
    }
    
    public long getNumero(){
        return this.numero;
    }
    
    public long setNumero(long nu){
        return this.numero = nu;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String setEmail(String e){
        return this.email = e;
    }
    
    public void status(){
        System.out.println("\nCONTATO:");
        System.out.println("Nome: " + this.nome);
        System.out.println("Número: " + this.numero);
        System.out.println("E-mail: " + this.email);
    }
}
