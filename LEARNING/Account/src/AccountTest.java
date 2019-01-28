import java.util.Scanner; // Important classe Scanner

public class AccountTest
{
    public static void main(String[] args)
    {
        Account account1 = new Account(50.00);// Cria um obj e atribui a account1
        Account account2 = new Account(-7.53);// Cria um obj e atribui a account2

        // Exibe o saldo de cada objeto criado
        System.out.printf("Account1 balance %.2f.\n", account1.getBalance());
        System.out.printf("Account2 balance %.2f.\n", account2.getBalance());

        // Cria um Scanner para obter entrada a partir da janela de comando
        Scanner input = new Scanner(System.in);
        double depositAmount;// Valor de depósito lido a partir do usuário

        // Depósito em account1
        System.out.print("Enter deposit amount for account1:\n");
        depositAmount = input.nextDouble();// Entrada do usuário
        System.out.printf("Adding %.2f to account1 balance.\n", depositAmount);
        account1.credit(depositAmount);// Adiciona o saldo de account1 através do método credit

        // Exibindo os saldos
        System.out.printf("Account1 balance: %.2f.\n", account1.getBalance());
        System.out.printf("Account2 balance: %.2f.\n", account2.getBalance());

        // Depósito em account2
        System.out.print("Enter deposit amount for account2: ");
        depositAmount = input.nextDouble();// Entrada de account 2 feita pelo usuário
        System.out.printf("Adding %.2f to account2 balance.\n", depositAmount);
        account2.credit(depositAmount);// Adicionado ao saldo de account2 através do método credit

        // Exibindo os saldos
        System.out.printf("Account1 balance: %.2f.\n", account1.getBalance());
        System.out.printf("Account2 balance: %.2f.\n", account2.getBalance());
    }// Fim de main
}// Fim da classe AccountTest
