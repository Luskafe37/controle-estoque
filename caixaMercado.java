package controeEstoqueTeste;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class caixaMercado {

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);
        String continuar = "sim";
        int idFinder;
        double carrinho = 0;

        List<Carrinho> carrinhos = new ArrayList<>();

        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto(1, "Banana", 3.00, 5));
        produtos.add(new Produto(2, "Uva", 5.00, 15));
        produtos.add(new Produto(3, "Sorvete", 15.00, 6));


        System.out.println("-- BEM VINDO AO SISTEMA DE CAIXA --");

        do {
            System.out.println("-- DIGITE O ID DO PRODUTO PARA ADICIONAR AO CARRINHO--");

            idFinder = sc.nextInt();
            for (int i = 0; i < produtos.size(); i++){
                if(produtos.get(i).getidProduto() == idFinder)
                {
                    System.out.println(produtos.get(i).getNome() + " | R$" + produtos.get(i).getPreco());

                    // REMOVER A QUANTIA EM ESTOQUE
                    carrinho = carrinho + produtos.get(i).getPreco();

                    String nomeCarrinho = produtos.get(i).getNome();
                    double valorCarrinho = produtos.get(i).getPreco();

                    Carrinho novoCarrinhos = new Carrinho(nomeCarrinho, valorCarrinho);
                    carrinhos.add(novoCarrinhos);

                }



            }

            // ARRAY QUE VAI ADICIONANDO OS IDS DOS PRODUTOS DO CARRINHO
            System.out.println("-- CARRINHO --");
            for(Carrinho carrinho1:carrinhos){
                System.out.println(carrinho1);
            }
            System.out.println();
            System.out.println("VALOR DO CARRINHO = R$" + carrinho);
            System.out.println();
            System.out.println("-- ADICIONAR MAIS COMPRAS AO CARRINHO? --");
            continuar = sc.next();
        }while (!continuar.equalsIgnoreCase("nao"));
            System.out.println("TOTAL DOS PRODUTOS = R$" + carrinho);

    }

}
    class Carrinho {

        String nomeCarrinho;
        double valorCarrinho   ;
        //int quantidadeCarrinho;

        Carrinho (String nomeCarrinho, double valorCarrinho) {
            this.nomeCarrinho = nomeCarrinho;
            this.valorCarrinho = valorCarrinho;
            //this.quantidadeCarrinho = quantidadeCarrinho;
        }

        public String toString(){
            return "PRODUTO: " + nomeCarrinho + " | VALOR: " + valorCarrinho;
        }



    }
