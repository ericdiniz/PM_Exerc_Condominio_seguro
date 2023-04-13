import java.util.Calendar;
import java.util.List;

public class Imovel {
    // constantes
    private static final float MAX_DESCONTO = 0.3F;
    private static final float COMISSAO = 0.12F;

    // atributos
    private double valorVenda;
    private String endereco;
    private int anoConstrucao;
    private List<Acrescimos> listAcrescimos;

    public double getValorVenda() {
        return valorVenda;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getAnoConstrucao() {
        return anoConstrucao;
    }

    private Calendar anoAtual;

    // construtor
    public Imovel(double valorVenda, String endereco, int anoConstrucao) {
        if (valorVenda > 0) {
            this.valorVenda = valorVenda;
        }

        if (endereco.length() > 0) {
            this.endereco = endereco;
        }

        if (anoConstrucao >= 1950 && anoConstrucao <= anoAtual.getWeekYear()) {
            this.anoConstrucao = anoConstrucao;
        }
    }

    // metodos

    /**
     * Metodo para adicionar o acréscimo na lista de acréscimos
     *
     * @param descricao
     * @param quantidade
     * @param valorAcrescimo
     */
    public void adicionarAcrescimoNaLista(String descricao, int quantidade, double valorAcrescimo) {
        Acrescimos a = new Acrescimos(descricao, quantidade, valorAcrescimo);
        this.listAcrescimos.add(a);
    }

    /**
     * Metodo para mostrar o valor do imovel
     */
    public double mostrarValorImovel() {
        return this.valorVenda;
    }
}