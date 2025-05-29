import java.util.List;

public interface Ator {
    void agir(List<Ator> lista);
    boolean estaAtivo();
}