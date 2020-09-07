package br.com.projeto.priscilamatoshpotter;

//CLASSE ABSTRATA, PARA QUE AS HERDEIRAS TENHAM OS MESMOS MÉTODOS E ATRIBUTOS
public abstract class Jogador {

    //ATRIBUTOS
    private String nome;
    private Integer idade;
    private String posicao;
    private String casa;
    private Integer pontuacao;

    //CONSTRUTOR
    public Jogador(String nome, Integer idade, String posicao, String casa, Integer pontuacao) {
        this.nome = nome;
        this.idade = idade;
        this.posicao = posicao;
        this.casa = casa;
        this.pontuacao = pontuacao;
    }

    //CRIANDO METODOS ABSTRATOS
    public abstract Integer calculaPontuacao ();

    public abstract Integer PontuacaoPomo ();


    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getCasa() {
        return casa;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }


    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", posicao='" + posicao + '\'' +
                ", casa='" + casa + '\'' +
                ", pontuacao=" + pontuacao +
                '}';
    }
}
