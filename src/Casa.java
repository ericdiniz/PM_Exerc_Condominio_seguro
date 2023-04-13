import java.util.List;

public class Casa extends Imovel {
    // constantes
    private static final float DEPRECIACAO = 0.12F;
    // atributos
    private double valorAnualSeguro;

    // construtor
    public Casa(double valorVenda,
            String endereco,
            int anoConstrucao,
            double valorAnualSeguro,
            List<Acrescimos> acrescimos) {
        super(valorVenda, endereco, anoConstrucao, acrescimos);
        this.valorAnualSeguro = valorAnualSeguro;
    }

}
