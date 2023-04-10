public class Imovel {
    // constantes
    private static final double MAX_DESCONTO = 0.3;
    private static final double COMISSAO = 0.12;

    // atributos
    private double valorVenda;
    private String endereco;
    private int anoConstrucao;

    public Imovel(double valorVenda, String endereco, int anoConstrucao) {
        this.valorVenda = valorVenda;
        this.endereco = endereco;
        this.anoConstrucao = anoConstrucao;
    }

}