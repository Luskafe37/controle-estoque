package controeEstoqueTeste;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

    class Produto {

        String nomeProduto;
        double valorProduto;
        int quantidadeProduto;

        Produto(String nomeProduto, double valorProduto, int quantidadeProduto){
            this.nomeProduto = nomeProduto;
            this.valorProduto = valorProduto;
            this.quantidadeProduto = quantidadeProduto;
        }
        @Override
        public String toString(){
            return "Nome: " + nomeProduto + " | R$" + valorProduto + " | Quantia no estoque: " + quantidadeProduto;
        }


    }



public class programaPrincipal {

    public static void main(String[] args){



        Scanner sc = new Scanner(System.in);
        int i = 0;


        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Banana", 3.00, 5));
        produtos.add(new Produto("Uva", 5.00, 15));
        produtos.add(new Produto("Sorvete", 15.00, 6));



        int continuar;

        do{

            System.out.println("-- BEM VINDO AO PROGRAMA DE ESTOQUE 1.0 --");
            System.out.println("-- SELECIONE UMA OPÇÃO PARA COMEÇAR --");
            System.out.println("-- 1 - ADICIONAR UM NOVO PRODUTO --");
            System.out.println("-- 2 - VISUALIZAR LISTA DE PRODUTOS --");
            System.out.println("-- 0 - SAIR --");
            //System.out.println("-- 3 - EDITAR PRODUTO --");
           // System.out.println("-- - ADICIONAR QUANTIDADE DE PRODUTO --");

            continuar = sc.nextInt();
            sc.nextLine();

            switch (continuar){


                case 1:

                    System.out.println("-- ADICIONE UM NOVO PRODUTO --");



                    //for (int i = 0; i < 2; i++){
                    String addProduto = "";

                   do {

                        System.out.println("NOME DO PRODUTO: ");
                        String nomeProduto = sc.nextLine();
                        System.out.println("PREÇO DO PRODUTO: ");
                        double valorProduto = sc.nextDouble();
                        System.out.println("QUANTIDADE DO PRODUTO: ");
                        int quantidadeProduto = sc.nextInt();

                        Produto novoProduto = new Produto(nomeProduto, valorProduto, quantidadeProduto);
                        produtos.add(novoProduto);

                        System.out.println("PRODUTO ADICIONADO AO ESTOQUE COM SUCESSO");

                        System.out.println("Deseja continuar? sim/nao");
                        addProduto = sc.next();

                    }while (!addProduto.equalsIgnoreCase("nao"));

                    //NOME | VALOR | QUANTIDA | ID
                    //ID TEM Q SER GERADO AUTOMATICAMENTE



                    break;

                case 2:
                    System.out.println("-- LISTA DE PRODUTOS --");

                        for(Produto produto:produtos){
                            System.out.println(produto);
                        }
                    break;

                case 0:
                    System.out.println("-- OBRIGADO POR UTILIZAR NOSSO SISTEMA --");
                    break;

                default:
                    System.out.println("-- ERRO, OPÇÃO NÃO ENCONTRADA --");
                    System.out.println("-- DIGITE OUTRA OPÇÃO -- ");

            }
        }while(continuar != 0);



    }

}
// https://g.co/gemini/share/8a40e4c22c85