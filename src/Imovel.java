import java.util.List;

public class Imovel {
    // constantes
    private static final float MAX_DESCONTO = 0.3F;
    private static final float COMISSAO = 0.12F;

    // atributos
    private double valorVenda;
    private String endereco;
    private int anoConstrucao;
    private List<Acrescimos> acrescimos;

    public Imovel(double valorVenda, String endereco, int anoConstrucao, List<Acrescimos> acrescimos) {
        this.valorVenda = valorVenda;
        this.endereco = endereco;
        this.anoConstrucao = anoConstrucao;
        this.acrescimos = acrescimos;
    }

}