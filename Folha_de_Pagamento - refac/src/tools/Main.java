/**!
 * @className tools.Main.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-07-24
 *
 * @copyright Copyright (c) IC 2019
 *
 */
package tools;

import java.util.Scanner;

public class Main {

    private static Functions payrollSystem = new Functions(true);

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int op;// Opções
        boolean continueVar = true;

        while (continueVar){
            menuPayroll();
            op = input.nextInt();

            if(op == 0)
            {
                System.out.println("Obrigado por usar Sistema de Folha de Pagamento EH!");
                continueVar = false;
            }
            else if(op == 1)
            {
                System.out.println("Função de ADICIONAR um empregado:");
                payrollSystem.addEmployee();
                continueVar = true;
            }
            else if(op == 2)
            {
                System.out.println("Função de REMOVER um empregado:");
                payrollSystem.removeEmployee();
                continueVar = true;
            }
            else if(op == 3)
            {
                System.out.println("Função de LANÇAR UM CARTÃO DE PONTO de um empregado:");
                payrollSystem.launchCardPoint();
                continueVar = true;
            }
            else if(op == 4)
            {
                System.out.println("Função de LANÇAR RESULTADO DE VENDAS de um empregado:");
                payrollSystem.addSalesResult();
                continueVar = true;
            }
            else if(op == 5)
            {
                System.out.println("Função de LANÇAR UMA OUTRA TAXA DE SERVIÇO (além da taxa SINDICAL) de um empregado:");
                payrollSystem.addServiceFee();
                continueVar = true;
            }
            else if(op == 6)
            {
                System.out.println("Função ALTERAR DADOS de um empregado:");
                payrollSystem.changeEmployeeData();
                continueVar = true;
            }
            else if(op == 7)
            {
                System.out.println("Função RODAR PAYROLL HOJE:");
                payrollSystem.runPayrollToday();
                continueVar = true;
            }
            else if(op == 8)
            {
                System.out.println("Função UNDO/REDO:");
                payrollSystem.undoRedo();
                continueVar = true;
            }
            else if(op == 9)
            {
                System.out.println("Função ALTERAR agenda de pagamento:");
                payrollSystem.changePaymentAgenda();
                continueVar = true;
            }
            else if(op == 10)
            {
                System.out.println("Função CRIAR NOVAS AGENDAS DE PAGAMENTO!");
                payrollSystem.createNewPaymentAgenda();
                continueVar = true;
            }
            else if(op == 11)
            {
                System.out.println("Lista dos empregados cadastrados:\n");
                payrollSystem.printListEmployee();
                continueVar = true;
            }
            else if(op == 12)
            {
                System.out.println("Lista de NOVAS AGENDAS:\n");
                payrollSystem.printListNewAgendas();
                continueVar = true;
            }
            else{
                continueVar = false;
            }
        }
    }

    public static void menuPayroll()
    {
        System.out.println("\nBem-vindo ao Sistema de Folha de Pagamento EH!\n");
        System.out.println("0 - Sair do Sistema de Folha de Pagamento.");
        System.out.println("1 - Adicionar empregado.");
        System.out.println("2 - Remover empregado.");
        System.out.println("3 - Lançar cartão de ponto.");
        System.out.println("4 - Lançar resultado da venda.");
        System.out.println("5 - Lançar uma taxa de serviço.");
        System.out.println("6 - Alterar informações do empregado.");
        System.out.println("7 - Executar a Folha de Pagamento para hoje.");
        System.out.println("8 - Função Undo/Redo.");
        System.out.println("9 - Executar Agenda de Pagamento.");
        System.out.println("10 - Criar novas Agendas de Pagamento.");
        System.out.println("11 - Imprimir empregados cadastrados.");
        System.out.println("12 - Imprimir novas agendas cadastradas.");
        System.out.println("Por favor, escolha a operação desejada (0 - 12):");
    }
}
