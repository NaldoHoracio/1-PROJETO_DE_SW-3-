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

    public int isSyndicalist;// Valida se o empregado faz parte do sindicato ( 1 - Sim | 0 - Não)
    public int getIdEmployeeSyndicalist;// Número de identificação do empregado no sindicato
    public double unionFee;// Taxa do sindicato
    public double outherFees;// Outras taxas de quem pertence ao sindicato


    public String typeOfPayment;// {CORREIOS, MAOS, DEPOSITO} Tipo de pagamento: C - cheque pelos correios; M - cheque em mãos; B - depósito na conta
    public String typeAgend;// {WEEKLY, BIWEEKLY, MONTHLY} Tipo de agenda: S - semanalmente; B - bi-mensalmente; M - Mensalmente
    public int weeklyDay;// Dia da semana de pagamento (1 - SEG | 2 - TER | 3 - QUA | 4 - QUI | 5 - SEX
    public int dataDay;// Dia do pagamento do mês

}

class AgendaPayroll
{
    public int[] weeklyPayment = new int[5];// Agenda semanal
    public int[] biWeeklyPayment = new int[5];// Agenda bi-semanal
    public int[] monthlyPayment = new int[27];// Agenda mensal
}

class NumberEmployee
{
    final int numberEmployee;
    NumberEmployee(int number)
    {
        this.numberEmployee = number;
    }
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

    public static int isSindycalistEmployee(int is)
    {
        return (is == 1) ? 1:0;
    }

    // ADICIONANDO EMPREGADO
    public static void addEmployee(Employee[] employee, Scanner input)
    {
        int currentIndex = 0;
        NumberEmployee number = new NumberEmployee(100);
        // Soma 1 ao indice de empregado caso ele seja diferente de null
        while(employee[currentIndex] != null) currentIndex++;

        employee[currentIndex] = new Employee();
        employee[number.numberEmployee] = null;

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
        employee[currentIndex].isSyndicalist = input.nextInt();
        if(isSindycalistEmployee(employee[currentIndex].isSyndicalist) == 1)
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

    // GUARDANDO DADOS POR SEGURANÇA
    public static void safetyData(Employee currentEmployee, Employee safetyEmployee)
    {
        safetyEmployee.name = currentEmployee.name;
        safetyEmployee.address = currentEmployee.address;
        safetyEmployee.typeEmployee = currentEmployee.typeEmployee;
        safetyEmployee.idEmployee = currentEmployee.idEmployee;
        safetyEmployee.wageSalary = currentEmployee.wageSalary;
        safetyEmployee.monthlySalary = currentEmployee.monthlySalary;
        safetyEmployee.commissioned = currentEmployee.commissioned;
        safetyEmployee.salaryEmployee = currentEmployee.salaryEmployee;
        safetyEmployee.isSyndicalist = currentEmployee.isSyndicalist;
        safetyEmployee.getIdEmployeeSyndicalist = currentEmployee.getIdEmployeeSyndicalist;
        safetyEmployee.unionFee = currentEmployee.unionFee;
        safetyEmployee.outherFees = currentEmployee.outherFees;
        safetyEmployee.typeOfPayment = currentEmployee.typeOfPayment;
        safetyEmployee.typeAgend = currentEmployee.typeAgend;
        safetyEmployee.weeklyDay = currentEmployee.weeklyDay;
        safetyEmployee.dataDay = currentEmployee.dataDay;
    }

    public static void printEmployee(Employee[] employees)
    {
        for(int i = 0; i < 100; ++i)
        {
            if(employees[i] != null)
                System.out.println("ID employee:", + employees[i].idEmployee + "\nName employee:", + employees[i].name);
        }
    }

    // REMOVENDO EMPREGADO
    public static void removeEmployee(Employee[] employee, Scanner input)
    {
        printEmployee(employee);
        int lastEmployeeId = employee.length;
        System.out.printf("Please enter the employee ID you wish to remove [0 - %d]:");
        int idInput = input.nextInt() - 1;

        printEmployee(employee);
        int idInput = input.nextInt() - 1;

        if(employee[idInput] != null)
        {
            System.out.println("Confirm employee removal " + employee[idInput].name + "(Yes | No):");
            String answer = input.nextLine();
            answer = answer.toUpperCase();

            if(answer == "YES")
            {
                employee[100] = new Employee();
                safetyData(employee[idInput], employee[100]);
                employee[idInput] = null;
                System.out.println("Employee " + employee[idInput].name + "removal successfully!");
            }else{
                System.out.printf("Canceled employee removal!\n");
            }

        } else{
            System.out.printf("Employee %d is not exists!\n", idInput);
        }
    }

    // LANÇANDO O CARTÃO DE PONTO DO EMPREGADO HORISTA
    public static void launchTodayCardPoint(Employee[] employees, Scanner input)
    {
        printEmployee(employees);
        int lastEmployeeId = employees.length;
        System.out.printf("Enter to ID employee [0 - %d]\n", lastEmployeeId);
        int idInput = input.nextInt() - 1;

        if(employees[idInput] == null)
        {
            System.out.println("Employee is not exists!");
        }else{
            String type = employees[idInput].typeEmployee;
            type = type.toUpperCase();

            if(type == "HOURLY")
            {
                System.out.printf("Enter the number of hours worked today:\n");
                double workedHours = input.nextDouble();
                safetyData(employees[idInput], employees[100]);

                if(workedHours < 0 || workedHours > 24)
                {
                    System.out.printf("Hours invalid!\nEnter to new value:");
                    workedHours = input.nextDouble();
                }else if(workedHours > 0 && workedHours <= 8)
                {
                    employees[idInput].salaryEmployee += (workedHours * employees[idInput].wageSalary);
                    System.out.printf("Day time card ok!\nYou worked until 8 hours!\nThank you!");
                }else{
                    double extraHours = workedHours - 8;
                    employees[idInput].salaryEmployee += ((8 * employees[idInput].wageSalary) +
                            (extraHours * employees[idInput].wageSalary * 1.5));
                    System.out.printf("Day time card ok!\nYou worked more than 8 hours!\nThank you!\n");
                }
            }
        }
    }

    // LANÇANDO TAXAS ADICIONAIS DE SERVIÇO
    public static void unioFeeEmployee(Employee[] employees, Scanner input)
    {
        printEmployee(employees);
        int lastEmployeeId = employees.length;
        System.out.printf("Enter to ID employee for add UNION FEE:[0 - %d]\n", lastEmployeeId);
        int idInput = input.nextInt() - 1;

        if(employees[idInput] == null)
        {
            System.out.println("Employee is not exists!");
        }else{
            if(isSindycalistEmployee(employees[idInput].isSyndicalist) == 1)
            {
                employees[100] = new Employee();
                safetyData(employees[idInput], employees[100]);
                System.out.println("Enter to the FEE:");
                double outhersFee = input.nextDouble();
                employees[idInput].outherFees = outhersFee;
                System.out.println("FEE registered ok!");
            }else{
                System.out.printf("Employee is not syndicalist!\n");
            }
        }
    }

}
