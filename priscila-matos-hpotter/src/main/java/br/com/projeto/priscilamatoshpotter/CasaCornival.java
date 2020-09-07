package br.com.projeto.priscilamatoshpotter;

//HERDEIRA DE JOGADOR
public class CasaCornival extends Jogador{

    //CONSTRUTOR
    public CasaCornival(String nome, Integer idade, String posicao, String casa, Integer pontuacao) {
        super(nome, idade, posicao, casa, pontuacao);
    }


    //IMPLEMENTANDO OS MÉTODOS DA CLASSE ABSTRATA
    //ELABORADOS DE ACORDO COM AS NECESSIDADES DA CLASSE

    @Override
    public Integer calculaPontuacao() {
        return getPontuacao() + 10;
    }

    @Override
    public Integer PontuacaoPomo() {
        return getPontuacao() + (getPontuacao() * 15);
    }
}
