package controeEstoqueTeste;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class programaPrincipal {

    public static void main(String[] args){



        Scanner sc = new Scanner(System.in);
        int i = 0;


        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto(1, "Banana", 3.00, 5));
        produtos.add(new Produto(2, "Uva", 5.00, 15));
        produtos.add(new Produto(3, "Sorvete", 15.00, 6));



        int continuar;

        do{

            System.out.println("-- BEM VINDO AO PROGRAMA DE ESTOQUE 1.0 --");
            System.out.println("-- SELECIONE UMA OPÇÃO PARA COMEÇAR --");
            System.out.println("-- 1 - ADICIONAR UM NOVO PRODUTO --");
            System.out.println("-- 2 - VISUALIZAR LISTA DE PRODUTOS --");
            System.out.println("-- 3 - ADICIONAR AO ESTOQUE --");
            System.out.println("-- 4 - REMOVER DO ESTOQUE --");
            System.out.println("-- 5 - EDITAR PRODUTO --");
            System.out.println("-- 0 - SAIR --");


            continuar = sc.nextInt();
            sc.nextLine();

            switch (continuar){


                case 1:

                    System.out.println("-- ADICIONE UM NOVO PRODUTO --");




                    String addProduto = "";

                   do {

                        System.out.println("NOME DO PRODUTO: ");
                        String nomeProduto = sc.nextLine();
                        System.out.println("PREÇO DO PRODUTO: ");
                        double valorProduto = sc.nextDouble();
                        System.out.println("QUANTIDADE DO PRODUTO: ");
                        int quantidadeProduto = sc.nextInt();
                        int idProduto = produtos.size() + 1;

                        Produto novoProduto = new Produto(idProduto, nomeProduto, valorProduto, quantidadeProduto);
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

                case 3:
                    boolean encontrado = false;
                    System.out.println("-- DIGITE O ID DO PRODUTO --");

                    int idProduto = sc.nextInt();

                    for(int j = 0; j < produtos.size(); j++){
                        if (produtos.get(j).getidProduto() == idProduto){
                            System.out.println("PRODUTO ENCONTRADO: ");
                            System.out.println(produtos.get(j));
                            sc.nextLine();


                            System.out.println("DIGITE A QUANTIDADE A SER ADICIONADA AO ESTOQUE");

                            int qnt = sc.nextInt();


                            if(qnt != 0 ){
                                try{
                                    //int novaQnt = Integer.parseInt(qnt);
                                    int novaQnt = qnt;
                                    produtos.get(j).setQntSoma(novaQnt);
                                }
                                catch (NumberFormatException e){
                                    System.out.println("FORMATO NÃO RECONHECIDO, TENTE NOVAMENTE. ");

                                }
                            }
                            System.out.println("-- PRODUTO ATUALIZADO --");
                            encontrado = true;
                            break;
                        }

                    }
                    if (!encontrado){
                        System.out.println("PRODUTO NÃO ENCONTRADO, TENTE NOVAMENTE");
                    }
                    break;

                case 4:
                    encontrado = false;
                    System.out.println("-- DIGITE O ID DO PRODUTO --");

                    idProduto = sc.nextInt();

                    for(int k = 0; k < produtos.size(); k++){
                        if (produtos.get(k).getidProduto() == idProduto){
                            System.out.println("PRODUTO ENCONTRADO: ");
                            System.out.println(produtos.get(k));
                            sc.nextLine();

                            if (produtos.get(k).getQnt() == 0) {
                                System.out.println("ESTOQUE ZERADO");
                                encontrado = true;
                                break;
                            }

                            System.out.println("DIGITE A QUANTIDADE A SER REMOVIDA DO ESTOQUE");

                            int qnt = sc.nextInt();


                            if(qnt != 0 ){
                                try{
                                    int novaQnt = qnt;

                                    if (produtos.get(k).getQnt() >= qnt){
                                    produtos.get(k).setQntSub(novaQnt);
                                    }
                                    /* else if (produtos.get(k).getQnt() == 0) {
                                        System.out.println("ESTOQUE ZERADO");
                                        encontrado = true;
                                        break;
                                    }
                                     */
                                    else {
                                        System.out.println("VALOR ACIMA DO ESTOQUE DISPONÍVEL");
                                        encontrado = true;
                                        break;
                                    }
                                }
                                catch (NumberFormatException e){
                                    System.out.println("FORMATO NÃO RECONHECIDO, TENTE NOVAMENTE. ");

                                }
                            }
                            System.out.println("-- PRODUTO ATUALIZADO --");
                            System.out.println("ESTOQUE ATUAL: " + produtos.get(k).getQnt() );
                            encontrado = true;
                            break;
                        }

                    }
                    if (!encontrado){
                        System.out.println("PRODUTO NÃO ENCONTRADO, TENTE NOVAMENTE");
                    }
                    break;

                case 5:
                    encontrado = false;
                    System.out.println("-- EDITAR PRODUTO --");
                    System.out.println("DIGITE O ID DO PRODUTO QUE DESEJA EDITAR: ");

                    idProduto = sc.nextInt();
                    sc.nextLine();

                    for (i = 0; i < produtos.size(); i++) {
                        if (produtos.get(i).getidProduto() == idProduto){
                            System.out.println("PRODUTO ENCONTRADO: ");
                            System.out.println(produtos.get(i));

                            System.out.println("EDITAR NOME: ");
                            String novoNome = sc.nextLine();
                            System.out.println("EDITAR PREÇO: ");
                            String precoString = sc.nextLine();

                            if (!novoNome.isEmpty()) {
                                produtos.get(i).setNome(novoNome);
                            }
                            if (!precoString.isEmpty())
                                try {
                                    double novoPreco = Double.parseDouble(precoString);
                                    produtos.get(i).setPreco(novoPreco);
                                }
                                catch (NumberFormatException e){
                                    System.out.println("FORMATO NÃO IDENTIFICADO, VALOR NÃO ALTERADO");
                                }
                            System.out.println("-- PRODUTO ATUALIZADO --");
                            encontrado = true;
                            break;
                        }

                    }
                    if (!encontrado){
                        System.out.println("PRODUTO NÃO ENCONTRADO, TENTE NOVAMENTE");
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
