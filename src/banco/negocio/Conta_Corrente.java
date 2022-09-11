package banco.negocio;
import java.util.ArrayList;

import banco.persistencia.Persistência;

public class Conta_Corrente {
   
    private float saldo;
    private int numeroConta;
    private int numeroAgencia;
    private ArrayList<Transacao> transacoes;
    private Persistência persist;
    private Cliente cliente;
    
    public Conta_Corrente(int numConta, int numAgencia, Cliente cliente) {
    	this.cliente = cliente;
    	persist = new Persistência();
    	transacoes =  new ArrayList<Transacao>();
        numeroConta = numConta;
        numeroAgencia = numAgencia;
        saldo = 0.0f;
    }
    
    
    public Cliente getCliente() {
		
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public ArrayList<Transacao> getExtrato(){
        return transacoes;
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

    private void registrarTransacao(Transacao transac){
        transacoes.add(transac);
        
        persist.salvar(this);
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
