import java.util.List;
import java.util.Random;

public class Cacador extends SerVivo{
    private static final int NUMERO_TIROS = 3;
    private static final int IDADE_MINIMA = 18;
    private static final int IDADE_MAXIMA = 70;

    private static final Random rand = new Random();

    public Cacador(Campo campo, Localizacao localizacao){
        super(campo,localizacao);
        int idadeInicial = IDADE_MINIMA + rand.nextInt(IDADE_MAXIMA - IDADE_MINIMA + 1);
        setIdade(idadeInicial);
    }

    @Override
    public void agir(List<Ator> lista){
        incrementarIdade();
        if (obterIdade() > IDADE_MAXIMA) {
            morrer();
            return;
        }
        if(estaAtivo()) {        
            // Tenta se mover para uma localização livre.
            Localizacao novaLocalizacao = obterCampo().localizacaoLivreAleatoria();
            if(novaLocalizacao != null) {
                definirLocalizacao(novaLocalizacao);
            }
            
            int i = 0;

            while(i < NUMERO_TIROS){
                Localizacao localizacaoAlvo = obterCampo().localizacaoOcupadaAleatoria();
                Object objeto = obterCampo().obterObjetoEm(localizacaoAlvo);
                if (objeto instanceof Animal){
                    Animal alvo = (Animal) objeto;
                    alvo.morrer();
                    i++;
                }
            }
        }
    }
}
