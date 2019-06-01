/**!
 * @className Main.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-05-07
 *
 * @copyright Copyright (c) IC 2018
 *
 */

import java.io.*;
import java.util.*;

class Employee
{
    public String name, address;// Nome e endereço do empregado
    public String typeEmployee;// Tipo do empregado - HOURLY, SALARIED, COMISSIONED
    public int idEmployee;// Número de identificação do empregado

    public double wageSalary;// Salário horário
    public double monthlySalary;// Salário mensal
    public double commissioned;// Comissão
    public double salaryEmployee;// Salário total do empregado

    public int isSyndicalist;// Valida se o empregado faz parte do sindicato
    public int getIdEmployeeSyndicalist;// Número de identificação do empregado no sindicato
    public double unionFee;// Taxa do sindicato
    public double outherFees;// Outras taxas de quem pertence ao sindicato


    public String typeOfPayment;// {CORREIOS, MAOS, DEPOSITO} Tipo de pagamento: C - cheque pelos correios; M - cheque em mãos; B - depósito na conta
    public String typeAgend;// {WEEKLY, BIWEEKLY, MONTHLY} Tipo de agenda: S - semanalmente; B - bi-mensalmente; M - Mensalmente
    public int weeklyDay;// Dia da semana de pagamento (1 - SEG | 2 - TER | 3 - QUA | 4 - QUI | 5 - SEX
    public int dataDay;// Dia do pagamento do mês

}

public class Main
{


    public static void main(String[] args)
    {
        System.out.printf("Hello world!\n");
    }

    // MENU DO SYSTEMA
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
    }

    public static boolean isSindycalistEmployee(int is)
    {
        return (is == 1) ? true:false;
    }

    // ADICIONANDO EMPREGADO
    public static void(Employee[] employee, Scanner input)
    {
        int currentIndex = 0;
        private final int numberEmployee = 100;
        // Soma 1 ao indice de empregado caso ele seja diferente de null
        while(employee[currentIndex] != null) currentIndex++;

        employee[currentIndex] = new Employee();
        employee[numberEmployee] = null;

        System.out.printf("Please, enter to employee name:\n");
        employee[currentIndex].name = input.nextLine();

        System.out.printf("Please, enter to employee address:\n");
        employee[currentIndex].address = input.nextLine();

        System.out.printf("Number of employee id (primary key):\n");
        employee[currentIndex].idEmployee = currentIndex;

        System.out.printf("Please, choose the salary according to the type of employee - HOURLY | SALARIED | COMISSIONED:\n");
        employee[currentIndex].typeEmployee = input.nextLine();
        employee[currentIndex].typeEmployee = employee[currentIndex].typeEmployee.toUpperCase();

        if(employee[currentIndex].typeEmployee == "HOURLY")
        {
            System.out.printf("Enter to salary for Hourly employee (example: 10.85):\n");
            employee[currentIndex].wageSalary = input.nextDouble();
            employee[currentIndex].monthlySalary = 0.0;// Salário mensal
            employee[currentIndex].commissioned = 0.0;// Comissão
            employee[currentIndex].salaryEmployee = 0.0;// Salário total

            System.out.printf("Type of default payment agend is Weekly.\n");
            employee[currentIndex].typeAgend = "WEEKLY";// Pagos semanalmente

            employee[currentIndex].weeklyDay = 5;// Por default, são pagos toda a sexta

            employee[currentIndex].dataDay = 0;// Dia do mês que é pago
        }

        else if(employee[currentIndex].typeEmployee == "SALARIED")
        {
            employee[currentIndex].wageSalary = 0.0;// Salário por hora
            System.out.printf("Enter to salary for mouthly salary:\n");
            employee[currentIndex].monthlySalary = input.nextDouble();// Salário mensal
            employee[currentIndex].commissioned = 0.0;// Comissão
            employee[currentIndex].salaryEmployee = 0.0;// Salário total

            System.out.printf("Type of default payment agend is Monthly.\n");
            employee[currentIndex].typeAgend = "MONTHLY";// Pagos mensalmente

            employee[currentIndex].weeklyDay = 0;// Pagamento semanal

            employee[currentIndex].dataDay = 27;// Dia do mês que é pago (último dia do mês)
        }

        else if(employee[currentIndex].typeEmployee == "COMISSIONED")
        {

            employee[currentIndex].wageSalary = 0.0;// Salário por hora
            System.out.printf("Enter to salary for mouthly salary:\n");
            employee[currentIndex].monthlySalary = input.nextDouble();// Salário mensal
            System.out.printf("Enter to percentage of sales commissions (ex. 20 (present 0.2 or 20 percent of comissioned):\n");
            employee[currentIndex].commissioned = input.nextDouble();// Comissão em %
            employee[currentIndex].salaryEmployee = 0.0;// Salário total

            System.out.printf("Type of default payment agend is BiWeekly.\n");
            employee[currentIndex].typeAgend = "BIWEEKLY";// Pagos bi-semanalmente

            employee[currentIndex].weeklyDay = 5;// Pagamento semanal toda sexta

            employee[currentIndex].dataDay = 0;// Dia do mês que é pago
        }

        System.out.printf("Is employee sindycalist? (1 - Yes | 0 - No)");
        employee[currentIndex].isSyndicalist = input.nextBoolean();
        if(isSindycalistEmployee(employee[currentIndex].isSyndicalist) == true)
        {
            System.out.printf("Enter to number of syndicate - 3 digits:\n");
            employee[currentIndex].getIdEmployeeSyndicalist = input.nextInt();

            System.out.printf("Enter to fee syndicate:\n");
            employee[currentIndex].unionFee = input.nextDouble();

            System.out.printf("Enter to ohter fees syndicate:\n");
            employee[currentIndex].outherFees = input.nextDouble();
        }else{
            System.out.printf("Employee is not syndicalist!\n");
        }

        System.out.printf("Enter to type of payment (CORREIOS, MAOS, DEPOSITO):\n");
        employee[currentIndex].typeOfPayment = input.nextLine();
        employee[currentIndex].typeOfPayment = employee[currentIndex].typeOfPayment.toUpperCase();
    }


}
