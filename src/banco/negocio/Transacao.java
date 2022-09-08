package banco.negocio;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Transacao {

    public float valorSaldo;
    public String operacao;
    public float valor;
    public String dataHora;
    

    public Transacao(float valorSaldo, float valor, String operacao) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();    
        this.dataHora = dtf.format(now);
        this.valorSaldo = valorSaldo;
        this.valor = valor;
        this.operacao = operacao;

    }

    
}
