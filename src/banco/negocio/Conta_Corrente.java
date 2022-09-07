package banco.negocio;
import java.util.ArrayList;


public class Conta_Corrente {

    private float saldo;
    private int numeroConta;
    private int numeroAgencia;
    ArrayList<Transacao> transacoes = new ArrayList<Transacao>();

    public Conta_Corrente(int numConta, int numAgencia) {

        numeroConta = numConta;
        numeroAgencia = numAgencia;
        saldo = 0.0f;
    }

    public void registrarTransacao(Transacao transac){

        transacoes.add(transac);
    }

    public void depositar(float v){

        saldo += v;
        Transacao t = new Transacao(v, "Depósito");
        registrarTransacao(t);
    }

    public Boolean sacar(float v){

        if(saldo - v > 0.0f){

            Transacao t = new Transacao(v, "Depósito");
            registrarTransacao(t);

            return true;
        } else {

            return false;
        }
        
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


}
