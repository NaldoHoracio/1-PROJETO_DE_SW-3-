/**!
 * @className payroll.tools.Main.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-06-11
 *
 * @copyright Copyright (c) IC 2019
 *
 */

package payroll.tools;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        int op;// Opções

        Scanner input = new Scanner(System.in);
        do {
            menuPayroll();
            System.out.println("Digite qual operação deseja fazer (0 - 10):");
            op = input.nextInt();

            if(op == 0)
            {
                System.out.println("Obrigado por usar Sistema de Folha de Pagamento EH!");
            }
            else if(op == 1)
            {
                System.out.println("currentAction = addEmployee(employees,input);");
            }
            else if(op == 2)
            {
                System.out.println("removeEmployee(employees,input);");
            }
            else if(op == 3)
            {
                System.out.println("launchTodayCardPoint(employees,input);");
            }
            else if(op == 4)
            {
                System.out.println("saleResult(employees,input);");
            }
            else if(op == 5)
            {
                System.out.println("othersFeeEmployee(employees,input);");
            }
            else if(op == 6)
            {
                System.out.println("changeDataEmployee(employees,input);");
            }
            else if(op == 7)
            {
                System.out.println("runPayrollToday(employees,input);");
            }
            else if(op == 8)
            {
                System.out.println("undoRedo(employees,currentAction, currentLastAction, input);");
            }
            else if(op == 9)
            {
                System.out.println("alterAgendaPayroll(employees,agenda,input);");
            }
            else if(op == 10)
            {
                System.out.println("Option in the implementation phase!");
            }
            System.out.printf("\n\n");
        }while(op != 0);
    }

    public static void menuPayroll()
    {
        System.out.println("Bem-vindo ao Sistema de Folha de Pagamento EH!");
        System.out.println("Por favor, escolha a operação desejada:");
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
        System.out.println("0 - Sair do Sistema de Folha de Pagamento.");
        System.out.println("");
    }
}
