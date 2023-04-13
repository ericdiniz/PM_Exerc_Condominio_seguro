import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AcrescimosTest {

    Acrescimos acrescimo = null;

    @BeforeEach
    public void init() {
        acrescimo = new Acrescimos("Descricao básica", 2, 100);
    }

    /**
     * Aqui contem um teste para verificar se o cálculo está correto do acréscimo
     */
    @Test
    public void testarCalcularValorAcrescimo() {
        double soma = acrescimo.calcularValorAcrescimos();
        assertEquals(200, soma);
    }

    /**
     * Aqui contem um teste para verificar o metodo toString
     */
    @Test
    public void testarMostrarAcrescimos() {
        assertEquals("Descrição: Descricao básica, Quantidade: 2, Valor do Acréscimo: 100.0",
                acrescimo.mostrarAcrescimos());
    }

}
