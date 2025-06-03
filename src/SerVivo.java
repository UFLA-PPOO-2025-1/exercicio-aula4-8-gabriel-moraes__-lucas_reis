import java.util.List;

public class SerVivo implements Ator{
    private boolean vivo;
    private Localizacao localizacao;
    private Campo campo;
    
    private int idade;

    public SerVivo(Campo campo, Localizacao localizacao){
        vivo = true;
        this.campo = campo;
        definirLocalizacao(localizacao);
        idade = 0;
    }

    public Localizacao obterLocalizacao()
    {
        return localizacao;
    }

    protected void definirLocalizacao(Localizacao novaLocalizacao){
        if(localizacao != null) {
            campo.limpar(localizacao);
        }
        localizacao = novaLocalizacao;
        campo.colocar(this, novaLocalizacao);
    }

    public Campo obterCampo() {
        return campo;
    }

    public boolean estaAtivo(){
        return vivo;
    }

    public void agir(List<Ator> lista){

    }

    protected void morrer()
    {
        vivo = false;
        if(localizacao != null) {
            campo.limpar(localizacao);
            localizacao = null;
            campo = null;
        }
    }

    public int obterIdade() {
        return idade;
    }

    public void incrementarIdade() {
        idade++;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }
}
