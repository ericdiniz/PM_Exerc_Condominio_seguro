import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class Imovel {
    // constantes
    protected static final float MAX_DESCONTO = 0.3F;
    protected static final float COMISSAO = 0.12F;
    Calendar c = Calendar.getInstance();

    // atributos
    private static int proximo_id = 1;
    private int id;
    protected double valorVenda;
    protected String endereco;
    protected int anoConstrucao;
    List<Acrescimos> listAcrescimos = new ArrayList<>();

    // construtor
    public Imovel(double valorVenda, String endereco, int anoConstrucao) {
        if (valorVenda > 0) {
            this.valorVenda = valorVenda;
        }

        if (endereco.length() > 0) {
            this.endereco = endereco;
        }

        if (anoConstrucao >= 1950 && anoConstrucao <= c.get(Calendar.YEAR)) {
            this.anoConstrucao = anoConstrucao;
        }
        this.id = proximo_id;
        proximo_id++;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setAnoConstrucao(int anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }

    public int getAnoConstrucao() {
        return this.anoConstrucao;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public int getId() {
        return this.id;
    }

    // metodos

    /**
     * Metodo para adicionar o acréscimo na lista de acréscimos
     *
     * @param Objeto Acrescimos
     */
    public void adicionarAcrescimoNaLista(Acrescimos novoAcrescimo) {
        this.listAcrescimos.add(novoAcrescimo);
    }

    /**
     * Metodo para MOSTRAR todos os acrescimos da propriedade
     */
    public void mostrarTodosAcrescimos() {
        for (Acrescimos acrescimos : listAcrescimos) {
            System.out.println(acrescimos.mostrarAcrescimos());
        }

    }

    /**
     *
     * Metodo para mostrar o valor do imovel
     */
    public double mostrarValorImovel() {
        return this.valorVenda;
    }

    /**
     * Metodo ABSTRACT para calcular comissao por aluguel
     */
    public abstract double calcularComissaoPorAluguel();

    /**
     * Metodo ABSTRACT para mostrar valor bruto com cada propriedade
     */
    public abstract double mostrarValorBrutoComCadaPropriedade();

    /**
     * Metodo ABSTRACT para mostrar valor liquido com cada propriedade
     */
    public abstract double mostrarValorLiquidoComCadaPropriedade();

}