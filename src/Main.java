import java.util.List;
import java.util.Calendar;

public class Main {

    // atributos
    private List<Imovel> listImoveis;
    private Calendar anoAtual;

    // metodos
    /**
     * Metodo para buscar e imprimir por ano de construção
     *
     * @param anoDaBusca
     * @return Imovel
     */
    public void adicionarNaListaImoveis(Imovel i) {
        listImoveis.add(i);
    }

    public Imovel buscar_e_imprimirPorAno(int anoDaBusca) {
        if (anoDaBusca >= 1950 && anoDaBusca <= anoAtual.getWeekYear()) {
            for (Imovel cadaImovel : listImoveis) {
                if (anoDaBusca == cadaImovel.getAnoConstrucao()) {
                    return cadaImovel;
                }
            }
        }
        return null;
    }

    /**
     * Metodo para mostrar ganho total com todos os imoveis
     */
    public double mostrarGanhoComTodosImoveis() {
        double soma = 0;
        return soma;
    }

    public static void main(String[] args) {

    }
}
