import java.util.List;
import java.util.Random;

public abstract class Animal extends SerVivo{

    // Características compartilhadas por todos os coelhos (atributos estáticos, da classe).

    // Um gerador de números aleatórios compartilhado para controlar a reprodução.
    private static final Random rand = Randomizador.obterRandom();

    // Características individuais (atributos comuns, de instância).
    
    // A idade do animal.

    public Animal(boolean idadeAleatoria, Campo campo, Localizacao localizacao)
    {
        super(campo,localizacao);
        int idade = 0;
        if(idadeAleatoria) {
            idade = rand.nextInt(obterIdadeMaxima());
        }
        setIdade(idade);
    }
    
    /**
     * Aumenta a idade.
     * Isso pode resultar na morte do coelho.
     */

    /**
     * Gera um número representando o número de nascimentos,
     * se puder procriar.
     * @return O número de nascimentos (pode ser zero).
     */
    protected int procriar()
    {
        int nascimentos = 0;
        if(podeProcriar() && rand.nextDouble() <= obterProbabilidadeReproducao()) {
            nascimentos = rand.nextInt(obterTamanhoMaximoNinhada()) + 1;
        }
        return nascimentos;
    }
 
    /**
     * Verifica se este animal deve dar à luz neste passo.
     * Novos nascimentos serão feitos em locais vizinhos livres.
     * @param novosAnimais Uma lista para retornar os animais recém-nascidos.
     */
    protected void reproduzir(List<Ator> novosAnimais)
    {
        // Novos animais nascem em locais vizinhos.
        // Obtém uma lista de locais vizinhos livres.
        List<Localizacao> locaisLivres = obterCampo().localizacoesVizinhasLivres(obterLocalizacao());
        int nascimentos = procriar();
        for(int n = 0; n < nascimentos && locaisLivres.size() > 0; n++) {
            Localizacao local = locaisLivres.remove(0);
            Animal filhote = criarNovoFilhote(false, obterCampo(), local);
            novosAnimais.add(filhote);
        }
    }


    /**
     * Uma raposa pode procriar se tiver atingido a idade de reprodução.
     */
    private boolean podeProcriar()
    {
        return obterIdade() >= obterIdadeReproducao();
    }

    protected abstract int obterIdadeMaxima();
    
    protected abstract Animal criarNovoFilhote(boolean idadeAleatoria, Campo campo, Localizacao localizacao);
    
    protected abstract int obterIdadeReproducao();
    
    protected abstract double obterProbabilidadeReproducao();
    
    protected abstract int obterTamanhoMaximoNinhada();
}
