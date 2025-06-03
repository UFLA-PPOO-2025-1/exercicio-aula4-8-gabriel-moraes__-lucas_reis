import java.util.List;

public class Cacador extends SerVivo{
    private static final int NUMERO_TIROS = 3;

    public Cacador(Campo campo, Localizacao localizacao){
        super(campo,localizacao);
    }

    @Override
    public void agir(List<Ator> lista){
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
