import java.util.List;

public class Ape extends Imovel {
    // constantes
    private static final float DEPRECIACAO = 0.05F;
    // atributos
    private double taxaMensalCondominio;

    // construtor
    public Ape(double valorVenda,
            String endereco,
            int anoConstrucao,
            double taxaMensalCondominio,
            List<Acrescimos> acrescimos) {
        super(valorVenda, endereco, anoConstrucao);
        this.taxaMensalCondominio = taxaMensalCondominio;
    }

}
