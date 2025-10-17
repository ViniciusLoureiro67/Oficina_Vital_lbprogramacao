package oficina.modelo;


public class OrdemServico {


   private int id;

   private Veiculo veiculo;

   private String descricao;

   private double valor;

   private boolean finalizada;


  

   public OrdemServico(int id, Veiculo veiculo, String descricao, double valor)
   {

       if (veiculo == null) throw new IllegalArgumentException("Veículo é obrigatório para Ordem de Serviço.");

       this.id = id;

       this.veiculo = veiculo;

       this.descricao = descricao;

       this.valor = valor;

       this.finalizada = false;

   }


   public int getId() {

       return id;

   }


   public void setId(int id) {

       this.id = id;

   } 

   

   public Veiculo getVeiculo() {

       return veiculo;

   }

   

   public void setVeiculo(Veiculo veiculo) {

       this.veiculo = veiculo;

   }


   public String getDescricao() {

       return descricao;

   }


   public void setDescricao(String descricao) {

       this.descricao = descricao;

   }

   

   public double getValor() {

       return valor;

   }

   

   public void setValor(double valor) {

       if (valor < 0) throw new IllegalArgumentException("Valor não pode ser negativo.");

       this.valor = valor;

   }


   public boolean isFinalizada() {

       return finalizada;

   }


   public void finalizar() {

       this.finalizada = true;

       System.out.println("LOG: Ordem de Serviço #" + id + " FINALIZADA.");

   }


   @Override

   public String toString() {

      

       return "OS #" + id + " | " + veiculo.exibirInfo() + 

              " | Descrição: " + descricao + 

              " | Valor: R$ " + String.format("%.2f", valor) + 

              " | Status: " + (finalizada ? "Finalizada" : "Em Aberto");

   }
}