package programa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;


    public static void main(String[] args) {
        contasBancarias = new ArrayList<>();
        operacoes();

    }

    public static void operacoes() {
        System.out.println("-------------------------------------------------");
        System.out.println("----------Bem vindos ao banco teste-----------");
        System.out.println("-------------------------------------------------");
        System.out.println("*******Selecione a operaçao desejada******");
        System.out.println(" __________________________________________________");
        System.out.println("{              opçao 1 - Criar conta         }");
        System.out.println("{              opçao 2 - Depoitar              }");
        System.out.println("{              opçao 3 - Sacar                    }");
        System.out.println("{              opçao 4 - Transferir          }");
        System.out.println("{              opçao 5 - listar                   }");
        System.out.println("{              opçao 6 - Sair                       }");

        int operacao = sc.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println(" obrigado por nós visitar, volte! sempre");
                System.exit(0);
                break;

            default:
                System.out.println("escolha uma opçao correta!");
                operacoes();
                break;


        }

    }

    public static void criarConta() {
        System.out.println("\nNome: ");
        String nome = sc.next();

        System.out.println("\nCPF: ");
        String cpf = sc.next();

        System.out.println("\nEmail: ");
        String email = sc.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);
        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println("a sua conta foi criada com sucesso! ");
        operacoes();
    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("digite o numero de conta ");
        int numeroConta = sc.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("digite o valor a depositar ");
            Double valorDeposito = sc.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println(" operaçao realizada com sucesso! ");
        } else {
            System.out.println("conta nao encontrada! ");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("numero de conta");
        int numeroConta = sc.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("digite o valor desejado");
            Double valorSaque = sc.nextDouble();
            conta.sacar(valorSaque);
        } else {
            System.out.println("conta nao encontrada ");

        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("digite o numero da conta a trasferir");
        int numeroContaRemetente = sc.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            System.out.println("numero de conta do destinatario: ");
            int numeroContaDestinatario = sc.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
            if (contaDestinatario != null) {
                System.out.println("digite o valor da transferencia");
                Double valor = sc.nextDouble();
                contaRemetente.transferir(contaDestinatario, valor);
            } else {
                System.out.println("a conta digitada nao foi encontrada");
            }
        }
            operacoes();
        }

        public static void listarContas() {
            if (contasBancarias.size() > 0) {
                for (Conta conta : contasBancarias) {
                    System.out.println(conta);
                }
            } else {
                System.out.println("nao tem contas cadastradas");
            }
            operacoes();
        }
    }


