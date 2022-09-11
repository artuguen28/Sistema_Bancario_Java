package banco.interUsuario;
import banco.negocio.*;
import java.util.ArrayList;

public class CaixaEletronico {
    public static void main(String[] args) throws Exception {
    	
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Conta_Corrente> contas = new ArrayList<Conta_Corrente>();
    	
    	Cliente cliente_1 = new Cliente("Carlos", "338627017", "Rua dos Barés");
    	Conta_Corrente conta_1 = new Conta_Corrente(706929, 9688, cliente_1);
    	
    	
    	conta_1.depositar(525);
    	conta_1.sacar(300);
    	
    	clientes.add(cliente_1);
    	contas.add(conta_1);
    	
    	Cliente cliente_2 = new Cliente("Maria", "438133018", "Avenida Ephigênio Salles");
    	Conta_Corrente conta_2 = new Conta_Corrente(12677361, 2221, cliente_2);
    	
    	
    	conta_2.depositar(300);
    	conta_2.sacar(150);
    	
    	clientes.add(cliente_2);
    	contas.add(conta_2);
    	
    	Cliente cliente_3 = new Cliente("Rodolfo", "338627017", "Avenida Autaz Mirim");
    	Conta_Corrente conta_3 = new Conta_Corrente(138617642, 1603, cliente_3);
    	
    	
    	conta_3.depositar(700);
    	conta_3.sacar(415);
    	
    	clientes.add(cliente_3);
    	contas.add(conta_3);
    	
    	System.out.print("############### Database do caixa eletrônico ############### \n\n");
        for (int i = 0; i < contas.size(); i++)
        {
        	System.out.print("===============================\n");
        	System.out.print("Cliente: " + contas.get(i).getCliente().getNome() + "\n");
        	System.out.print("Número da conta: " + contas.get(i).getNumeroConta() + "\n");
        	System.out.print("Agência: " + contas.get(i).getNumeroAgencia() + "\n");
        	System.out.print("Saldo atual: " + contas.get(i).getSaldo() + "\n");
        	System.out.print("Extrato da conta-corrente: \n");
        	
        	for (int e = 0; e < contas.get(i).getExtrato().size(); e++)
        	{
        		System.out.print("---------------------------\n");
        		System.out.print("Data da operação: " + contas.get(i).getExtrato().get(e).getDataHora() + "\n");
        		System.out.print("Tipo de operação: " + contas.get(i).getExtrato().get(e).getOperacao() + "\n");
        		System.out.print("Valor da operação: " + contas.get(i).getExtrato().get(e).getValor() + "\n");
        		System.out.print("Saldo: " +  contas.get(i).getExtrato().get(e).getValorSaldo() + "\n");
        		System.out.print("---------------------------\n\n");
        	}
        	System.out.print("===============================\n\n");
        }
    	

    }
}
