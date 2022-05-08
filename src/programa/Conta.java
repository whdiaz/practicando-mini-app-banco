package programa;

import utilitarios.Utils;

public class Conta {
    private static int contadorDeconta = 1;

    private int numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorDeconta;
        this.pessoa = pessoa;
        contadorDeconta += 1;


    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String toString(){
        return "\n nome: " + this.pessoa.getNome() +
                " \ncpf: " + this.pessoa.getCpf()+
                "\nsaldo: " + this.getSaldo() +
                "\nemail: " + this.pessoa.getEmail() +
                "\n";

    }

    public  void depositar(Double valor){
        if(valor >= 0){
            setSaldo(getSaldo() + valor);
            System.out.println(" operaçao realizada com sucesso!");
            System.out.println("o teu novo saldo é: " + saldo );
       }else {
            System.out.println("insira uma quantidade razoavel ");

        }
    }

    public void sacar(Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println(" operaçao realizada com sucesso!");

        }else{
            System.out.println(" insira uma quantidade razoavel");
        }
    }

    public void transferir(Conta conta2, Double valor){
        if(valor > 0 && this.getSaldo() >+ valor){
            setSaldo(getSaldo() - valor);

            conta2.saldo = conta2.getSaldo() + valor;
            System.out.println("operaçao realizada com sucesso! ");
        }else{
            System.out.println("insira uma quantidade razoavel");
        }
    }
}