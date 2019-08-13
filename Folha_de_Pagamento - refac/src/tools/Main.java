/**!
 * @className Main.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-07-24
 *
 * @copyright Copyright (c) IC 2019
 *
 */
import tools.ManagementFunctions;

import java.util.Scanner;

public class Main {

    private static ManagementFunctions payroll = new ManagementFunctions();

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
                continueVar = true;
            }
            else if(op == 1)
            {
                System.out.println("Função de adicionar um empregado:\n");
                payroll.addEmployee();
                continueVar = true;
            }
            else if(op == 2)
            {
                System.out.println("removeEmployee(employees,input);");
                continueVar = true;
            }
            else if(op == 3)
            {
                System.out.println("launchTodayCardPoint(employees,input);");
                continueVar = true;
            }
            else if(op == 4)
            {
                System.out.println("saleResult(employees,input);");
                continueVar = true;
            }
            else if(op == 5)
            {
                System.out.println("othersFeeEmployee(employees,input);");
                continueVar = true;
            }
            else if(op == 6)
            {
                System.out.println("changeDataEmployee(employees,input);");
                continueVar = true;
            }
            else if(op == 7)
            {
                System.out.println("runPayrollToday(employees,input);");
                continueVar = true;
            }
            else if(op == 8)
            {
                System.out.println("undoRedo(employees,currentAction, currentLastAction, input);");
                continueVar = true;
            }
            else if(op == 9)
            {
                System.out.println("alterAgendaPayroll(employees,agenda,input);");
                continueVar = true;
            }
            else if(op == 10)
            {
                System.out.println("Option in the implementation phase!");
                continueVar = true;
            }
            else if(op == 11)
            {
                System.out.println("Lista dos empregados cadastrados:\n");
                payroll.printListEmployee();
                continueVar = true;
            }
            else{
                continueVar = false;
            }
        }
    }

    public static void menuPayroll()
    {
        System.out.println("Bem-vindo ao Sistema de Folha de Pagamento EH!");
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
        System.out.println("Por favor, escolha a operação desejada (0 - 11):");
    }
}
