package banco.negocio;
public class Transacao {
    
    public String operacao;
    public float valor;
    public String dataHora;
    
    public Transacao(float valor, String operacao) {
        this.valor = valor;
        this.operacao = operacao;
        //this.dataHora = dataHora;
    }

    
}
