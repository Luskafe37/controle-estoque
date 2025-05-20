package controeEstoqueTeste;

public class Produto {

    String nomeProduto;
    double valorProduto;
    int quantidadeProduto;
    int idProduto;

    Produto( int idProduto, String nomeProduto, double valorProduto, int quantidadeProduto){
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.idProduto = idProduto;
    }

    public int getidProduto() {
        return idProduto;
    }

    public String getNome(){
        return nomeProduto;
    }

    public String setNome(String nomeProduto){
        return this.nomeProduto = nomeProduto;
    }

    public double getPreco(){
        return valorProduto;
    }

    public double setPreco(double valorProduto){
        return this.valorProduto = valorProduto;
    }

    public int getQnt(){
        return quantidadeProduto;
    }

    public int setQntSoma (int novaQntSoma){
        return this.quantidadeProduto = quantidadeProduto + novaQntSoma;
    }

    public int setQntSub (int novaQntSub){
        return this.quantidadeProduto = quantidadeProduto - novaQntSub;
    }

    @Override
    public String toString(){
        return "ID : " + idProduto + " | Nome: " + nomeProduto + " | R$" + valorProduto + " | Quantia no estoque: " + quantidadeProduto;
    }

}
