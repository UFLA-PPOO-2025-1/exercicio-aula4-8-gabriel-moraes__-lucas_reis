import java.awt.Color;

public class VisaoDeTexto implements VisaoSimulador{

    private EstatisticasCampo campoTeste = new EstatisticasCampo();

    @Override
    public void definirCor(Class<?> classeAnimal, Color cor) {
    }

    @Override
    public boolean ehViavel(Campo campo) {
        throw new UnsupportedOperationException("Unimplemented method 'ehViavel'");
    }

    @Override
    public void mostrarStatus(int passo, Campo campo) {
        System.out.println("Passo " + (passo + 1) + " - "+ campoTeste.obterDetalhesPopulacao(campo));
        reiniciar();
        
    }

    @Override
    public void reiniciar() {
        campoTeste.reiniciar();
    }

    @Override
    public void reabilitarOpcoes() {
    }
}