import java.util.Calendar;
import java.util.List;

public class Casa extends Imovel {
    // constantes
    private static final float DEPRECIACAO = 0.10F;
    // atributos
    private double valorAnualSeguro;
    protected Calendar anoAtual;

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
    private double descontarValor() {
        double resultado = 0;
        float tempo = 0.0F;
        // logica
        /*
         * a partir de 5 anos
         * a cada 5 anos cai 0,1
         * maximo 0,3
         */
        int i = this.anoAtual.getWeekYear() - 5;
        int j = this.anoAtual.getWeekYear() - this.getAnoConstrucao();
        while (i >= this.getAnoConstrucao() || tempo <= MAX_DESCONTO) {
            if (j < 5) {
                resultado = 0;
                return resultado;
            }
            tempo += 0.1;
            i -= 5;
        }
        resultado = tempo;
        return resultado;
    }

    /**
     * METODO PARA CALCULAR VALOR INICIAL DO ALUGUEL.
     *
     * @return valorInicialAluguel
     */
    public double calcularValorInicial() {
        double resultado = 0;
        resultado = 0.05 * getValorVenda();
        return resultado;
    }

    /**
     * METODO PARA CALCULAR VALOR DO ALUGUEL
     *
     * @return valorFinalAlguel
     */
    public double calcularValorAluguel() {
        double resultado = 0;
        double soma = 0;
        for (Acrescimos cadaAc : listAcrescimos) {
            soma += cadaAc.calcularValorAcrescimos();
        }
        double valorQuaseFinal = (this.dividirValorAnualSeguro() + this.calcularValorInicial() + soma);
        resultado = (valorQuaseFinal - (descontarValor() * valorQuaseFinal));
        return resultado;
    }

    private double dividirValorAnualSeguro() {
        return this.valorAnualSeguro / 12;
    }

    // METODOS ABSTRATOS
    @Override
    public double calcularComissaoPorAluguel() {
        double soma = 0;
        return soma;
    }

    @Override
    public double mostrarValorBrutoComCadaPropriedade() {
        double soma = 0;
        return soma;
    }

    @Override
    public double mostrarValorLiquidoComCadaPropriedade() {
        double soma = 0;
        return soma;
    }
}
