package br.edu.ifpb.padroes.atv2;

public class Main {
    public static void main(String[] args){
        ComponenteCardapio hamburguer = new Produto("Hambúrguer", 20);
        ComponenteCardapio batata = new Produto("Batata Frita", 8);
        ComponenteCardapio refrigerante = new Produto("Refrigerante", 6);
        ComponenteCardapio sobremesa = new Produto("Sobremesa", 10);

        Combo comboBasico  = new Combo("Pacote Básico", 0.1);
        comboBasico.adicionar(hamburguer);
        comboBasico.adicionar(batata);
        comboBasico.adicionar(refrigerante);

        Combo comboCompleto = new Combo("Pacote Completo", 0.15);
        comboCompleto.adicionar(comboBasico);
        comboCompleto.adicionar(sobremesa);

        comboCompleto.mostrar("");
    }
}
