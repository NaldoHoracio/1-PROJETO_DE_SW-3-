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
            op = input.nextInt();

            if(op == 0)
            {
                System.out.println("Thank you for using Horacio's Payroll System!");
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
        System.out.println("Wellcome to Horacio's Payroll System!");
        System.out.println("Please choose your preferred option:");
        System.out.println("1 - Add employee.");
        System.out.println("2 - Remove employee.");
        System.out.println("3 - Launch card point.");
        System.out.println("4 - Launch sale result.");
        System.out.println("5 - Launch service charge.");
        System.out.println("6 - Alter info employee.");
        System.out.println("7 - Run Paylroll today.");
        System.out.println("8 - Undo/Redo function.");
        System.out.println("9 - Payment agenda run.");
        System.out.println("10 - Create news payment agendas.");
        System.out.println("0 - Exit to Payroll System.");
    }
}
