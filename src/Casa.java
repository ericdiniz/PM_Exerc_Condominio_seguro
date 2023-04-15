import java.util.Calendar;

public class Casa extends Imovel {
    // constantes
    private static final float DEPRECIACAO = 0.10F;
    // atributos
    private double valorAnualSeguro;
    Calendar c = Calendar.getInstance();

    // construtor
    public Casa(double valorVenda,
            String endereco,
            int anoConstrucao,
            double valorAnualSeguro) {
        super(valorVenda, endereco, anoConstrucao);
        this.valorAnualSeguro = valorAnualSeguro;
    }

    // METODOS
    /**
     * METODO PARA CALCULAR VALOR A DESCONTAR (DEPRECIACAO)
     */
    private double descontarValor(double valorInicial) {
        int ciclos = (c.get(Calendar.YEAR) - this.anoConstrucao) / 5; // 2023 - 2018 = 5
        if (ciclos > 3) {
            return valorInicial * MAX_DESCONTO;
        } else {
            return valorInicial * (DEPRECIACAO * ciclos);
        }
    }

    /**
     * METODO PARA CALCULAR VALOR INICIAL DO ALUGUEL.
     *
     * @return valorInicialAluguel
     */
    public double calcularValorInicial() {
        double resultado = 0;
        resultado = 0.05 * this.valorVenda;
        double x = descontarValor(resultado);
        return resultado - x;
    }

    /**
     * METODO PARA CALCULAR VALOR DO ALUGUEL
     *
     * @return valorFinalAlguel
     */
    public double calcularValorAluguel() {
        double somaAc = 0;
        for (Acrescimos cadaAc : listAcrescimos) {
            somaAc += cadaAc.calcularValorAcrescimos();
        }
        return (this.calcularValorInicial() + somaAc + this.dividirValorAnualSeguro());
    }

    /**
     * METODO PARA CALCULAR O VALOR MENSAL DO SEGURO ANUAL
     */
    private double dividirValorAnualSeguro() {
        return this.valorAnualSeguro / 12;
    }

    @Override
    public String toString() {
        StringBuilder descricao = new StringBuilder();
        descricao
                .append("Descrição do imovel: ")
                .append("id: " + getId())
                .append(", ")
                .append("valor aluguel: " + calcularValorAluguel())
                .append(", ")
                .append("endereço: " + getEndereco())
                .append(", ")
                .append("ano construção: " + getAnoConstrucao());
        return descricao.toString();
    }

    // METODOS ABSTRATOS
    @Override
    public double calcularComissaoPorAluguel() {
        return COMISSAO * this.calcularValorInicial();
    }

    @Override
    public double mostrarValorBrutoComCadaPropriedade() {
        return this.calcularValorInicial();
    }

    @Override
    public double mostrarValorLiquidoComCadaPropriedade() {
        return this.calcularValorAluguel() - this.calcularComissaoPorAluguel() - this.dividirValorAnualSeguro();
    }
}
