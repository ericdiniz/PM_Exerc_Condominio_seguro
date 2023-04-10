public class Ape extends Imovel {
    // constantes
    private static final double DEPRECIACAO = 0.05;
    // atributos
    private double taxaMensalCondominio;

    // construtor
    public Ape(double valorVenda, String endereco, int anoConstrucao) {
        super(valorVenda, endereco, anoConstrucao);
        // TODO Auto-generated constructor stub
    }

    public Ape(double valorVenda, String endereco, int anoConstrucao, double taxaMensalCondominio) {
        super(valorVenda, endereco, anoConstrucao);
        this.taxaMensalCondominio = taxaMensalCondominio;
    }

}
