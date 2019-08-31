package tools;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        int option = -1;
        Scanner input = new Scanner(System.in);

        do {
            managementMenu();
            try{
                option = input.nextInt();
                input.nextLine();
            }catch (InputMismatchException e){
                System.err.println("ERRO! Entrada não é um inteiro! Por favor, entre com um número inteiro.");
                input.nextLine();
            }
            switch (option)
            {
                case 0:
                    System.out.println("Saindo do Sistema! Obrigado por utilizar o Sistema de Gerenciamento de Produtividade Acadêmica EH!");
                    break;
                case 1:
                    System.out.println("Cadastrar novo colaborador!");
                    break;
                case 2:
                    System.out.println("Adicionar novo projeto de pesquisa!");
                    break;
                case 3:
                    System.out.println("Alterar status de um projeto de pesquisa!");
                    break;
                case 4:
                    System.out.println("Incluir informações sobre a produção acadêmica (publicações e/ou orientações)!");
                    break;
                case 5:
                    System.out.println("Consultar colaborador!");
                    break;
                case 6:
                    System.out.println("Consultar projeto de pesquisa!");
                    break;
                case 7:
                    System.out.println("Relatório da produção acadêmcia (publicações e/ou orientações)!");
                    break;
                case 8:
                    System.out.println("Alocar participante em um projeto de pesquisa!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente digitanto um inteiro correspondente a uma opção válida! [0-8]");
                    break;
            }
        }while (option != 0);
        input.close();
    }

    public static void managementMenu()
    {
        System.out.println("\nBem-vindo ao Sistema de Gerenciamento de Produtividade Acadêmcia EH!\n");
        System.out.println("Escolha uma opção para usar o sistema [0-8]:\n");
        System.out.println("0 - Sair do Sistema!");
        System.out.println("1 - Cadastrar novo colaborador!");
        System.out.println("2 - Adicionar novo projeto de pesquisa!");
        System.out.println("3 - Alterar status de um projeto de pesquisa!");
        System.out.println("4 - Incluir informações sobre a produção acadêmica (publicações e/ou orientações)!");
        System.out.println("5 - Consultar colaborador!");
        System.out.println("6 - Consultar projeto de pesquisa!");
        System.out.println("7 - Relatório da produção acadêmcia (publicações e/ou orientações)!");
        System.out.println("8 - Alocar participante em um projeto de pesquisa!");
    }
}
