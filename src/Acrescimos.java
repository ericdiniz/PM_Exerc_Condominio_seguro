public class Acrescimos {
    // atributos
    private String descricao;
    private int quantidade;
    private double valorAcrescimo;

    // construtor
    public Acrescimos(String descricao, int quantidade, double valorAcrescimo) {
        if (descricao.length() > 0) {
            this.descricao = descricao;
        }
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        }
        if (valorAcrescimo > 0) {
            this.valorAcrescimo = valorAcrescimo;
        }
    }
}