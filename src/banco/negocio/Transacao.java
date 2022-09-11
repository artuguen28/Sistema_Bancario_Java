package banco.negocio;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Transacao {

    private float valorSaldo;
    private String operacao;
    private float valor;
    private String dataHora;
    

    public Transacao(float valorSaldo, float valor, String operacao) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();    
        this.dataHora = dtf.format(now);
        this.valorSaldo = valorSaldo;
        this.valor = valor;
        this.operacao = operacao;

    }

    
	public float getValorSaldo() {
		return valorSaldo;
	}


	public void setValorSaldo(float valorSaldo) {
		this.valorSaldo = valorSaldo;
	}


	public String getOperacao() {
		return operacao;
	}


	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}


	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}


	public String getDataHora() {
		return dataHora;
	}


	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
    
    
}
