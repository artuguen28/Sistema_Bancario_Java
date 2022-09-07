package banco.negocio;
import java.util.ArrayList;



public class Conta_Corrente {
    
    private float saldo;
    private int numeroConta;
    private int numeroAgencia;
    private ArrayList<Transacao> transacoes;
    
    public Conta_Corrente(int numConta, int numAgencia) {
    	transacoes =  new ArrayList<Transacao>();
        numeroConta = numConta;
        numeroAgencia = numAgencia;
        saldo = 0.0f;
    }
    
    public void getExtrato(){
        
        System.out.println("Extrato bancário:");
        
        for(int i = 0; i < transacoes.size(); i++){
            System.out.println(String.format("Operação: %s", transacoes.get(i).operacao));
            System.out.println(String.format(": %s", transacoes.get(i).operacao));
            
        }
    }
    
    public float getSaldo() {
        return saldo;
    }
    
    public int getNumeroConta() {
        return numeroConta;
    }
    
    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void registrarTransacao(Transacao transac){

        transacoes.add(transac);
    }

    public void depositar(float v){

        saldo += v;
        Transacao t = new Transacao(getSaldo(), v, "Depósito");
        registrarTransacao(t);
    }

    public Boolean sacar(float v){

        if(saldo - v > 0.0f){
        	
            saldo -= v;
            Transacao t = new Transacao(getSaldo(), v, "Saque");
            registrarTransacao(t);

            return true;

        } else {
            return false;
        }
        
    }
    

}
