public class Casa extends Imovel {
    // constantes
    private static final double DEPRECIACAO = 0.1;
    // atributos
    private double valorAnualSeguro;

    // construtor
    public Casa(double valorVenda, String endereco, int anoConstrucao) {
        super(valorVenda, endereco, anoConstrucao);
        // TODO Auto-generated constructor stub
    }

    public Casa(double valorVenda, String endereco, int anoConstrucao, double valorAnualSeguro) {
        super(valorVenda, endereco, anoConstrucao);
        this.valorAnualSeguro = valorAnualSeguro;
    }

}
