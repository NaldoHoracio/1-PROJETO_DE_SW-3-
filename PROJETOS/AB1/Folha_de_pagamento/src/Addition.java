
import java.util.Scanner;

public class Addition
{
//    Método principal - inicia a execução do aplicativo Java
    public static void main(String[] args)
    {
//        Cria um Scanner para obter a entrada da janela de comando
        Scanner input = new Scanner(System.in);

        int num1, num2, sum;// Declaração de variáveis

        System.out.print("Enter first interger:\n");// Mensagem para digitar o primeiro inteiro
        num1 = input.nextInt();// Lendo o primeiro inteiro

        System.out.print("Enter second interger:\n");// Mensagem para digitar o segundo inteiro
        num2 = input.nextInt();// Lendo o segundo inteiro

        sum = num1 + num2;

        System.out.printf("A soma de %d + %d eh %d.\n", num1, num2, sum);
    }// Fim do método main
}// Fim da classe Addition
