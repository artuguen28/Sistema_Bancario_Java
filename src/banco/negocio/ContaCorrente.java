package banco.negocio;
import java.util.ArrayList;

import banco.persistencia.Persistencia;

public class ContaCorrente {
   
    private float saldo;
    private int numConta;
    private int numAgencia;
    private ArrayList<Transacao> transacoes;
    private Persistencia persist;
    private Cliente cliente;

    // Método construtor da classe ContaCorrente
    
    public ContaCorrente(int numConta, int numAgencia, Cliente cliente) {

        /*
         * A cada objeto da classe ContaCorrente criado, um objeto da classe
         * Persistencia e um array de objetos da classe Transacao são instanciados
         */

    	persist = new Persistencia();
    	transacoes =  new ArrayList<Transacao>();
        
    	/* Na linha 29, observa-se o relacionamento de agregação entre a classe ContaCorrente e a Cliente, 
        já que um objeto tem existência independente em relação ao outro */
    	this.cliente = cliente;
        this.numConta = numConta;
        this.numAgencia = numAgencia;

        saldo = 0.0f;
    }

    /*
     * Método responsável pelo registro das transações: 
     * - salva no ArrayList Transacao
     * - salva no obejto da classe Persistencia
     */ 
    
    private void registrarTransacao(Transacao transac){
    	
        /* Através da execução do método add para que o objeto da classe Transacao chamado no parâmetro
         * seja armazenado no Array transacoes, faz-se possível observar o relacionamento entre a classe ContaCorrente e a Transacao,
         * o qual é uma composição, já que os objetos desta estarão armazenados em um atributo de um objeto daquela, e o fim deste acarreta
         * o fim daqueles. Logo, percebe-se uma dependência.
         */
        transacoes.add(transac);
        persist.salvar(this);
    }


    /* Método responsável por acrescentar o valor depositado ao saldo e criar 
    uma nova transação, resgistrando-a logo em seguida */

    public void depositar(float v){

        saldo += v;
        Transacao t = new Transacao(getSaldo(), v, "Depósito");
        registrarTransacao(t);
    }

    /* Método responsável por sacar o dinheiro decrementando-o do saldo e registrar a transação.
    * - O método só é executado se a subtração não resultar em saldo negativo.
    */

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

    // Método responsável por retornar o extrato, isto é, retornar o ArrayList com as transações efetuadas

    public ArrayList<Transacao> getExtrato(){
        return transacoes;
    }
    
    
    // Implementação dos getters e setters do atributo cliente, e dos getters de numConta e numAgencia
    public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
    
    public int getNumeroConta() {
        return this.numConta;
    }
    
    public int getNumeroAgencia() {
        return this.numAgencia;
    }
    

    // O método setSaldo não foi implementado de modo a não contrariar o funcionamento dos métodos de saques e depósitos

    public float getSaldo() {
        return saldo;
        
    }
    

}
