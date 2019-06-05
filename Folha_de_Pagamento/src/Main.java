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
        int op;
        Scanner input = new Scanner(System.in);
        Employee[] employees = new Employee[101];
        employees[100] = new Employee();

        AgendaPayroll agenda = new AgendaPayroll();

        int currentAction = 0, currentLastAction = -1;

        for(int i = 0; i < 27; ++i)
        {
            agenda.monthlyPayment[i] = 0;
            if(i < 5)
            {
                agenda.weeklyPayment[i] = 0;
                agenda.biWeeklyPayment[i] = 0;
            }
        }

        agenda.monthlyPayment[26] = 1;
        agenda.weeklyPayment[4] = 1;
        agenda.biWeeklyPayment[4] = 1;

        do {
            menuPayroll();
            op = input.nextInt();

            if(op == 0)
            {
                System.out.println("Thank you for using Horacio's Payroll System!");
            }
            else if(op == 1)
            {
                currentAction = addEmployee(employees,input);
            }
            else if(op == 2)
            {
                removeEmployee(employees,input);
            }
            else if(op == 3)
            {
                launchTodayCardPoint(employees,input);
            }
            else if(op == 4)
            {
                saleResult(employees,input);
            }
            else if(op == 5)
            {
                othersFeeEmployee(employees,input);
            }
            else if(op == 6)
            {
                changeDataEmployee(employees,input);
            }
            else if(op == 7)
            {
                runPayrollToday(employees,input);
            }
            else if(op == 8)
            {
                undoRedo(employees,currentAction, currentLastAction, input);
            }
            else if(op == 9)
            {
                alterAgendaPayroll(employees,agenda,input);
            }
            else if(op == 10)
            {
                System.out.println("Option in the implementation phase!");
            }
        }while(op != 0);
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
        System.out.println("0 - Exit to Payroll System.");
    }

    public static int isSindycalistEmployee(int is)
    {
        return (is == 1) ? 1:0;
    }

    // ADICIONANDO EMPREGADO
    public static int addEmployee(Employee[] employee, Scanner input)
    {
        int currentIndex = 0;
        NumberEmployee number = new NumberEmployee(100);
        // Soma 1 ao indice de empregado caso ele seja diferente de null
        while(employee[currentIndex] != null) currentIndex++;

        employee[currentIndex] = new Employee();
        employee[number.numberEmployee] = null;

        System.out.printf("Please, enter to employee name:\n");
        employee[currentIndex].name = input.nextLine();
        input.nextLine();

        System.out.printf("Please, enter to employee address:\n");
        employee[currentIndex].address = input.nextLine();

        System.out.printf("Number of employee ID (primary key) is currentIndex.\n");
        employee[currentIndex].idEmployee = currentIndex;

        System.out.printf("Please, choose the salary according to the type of employee - HOURLY | SALARIED | COMISSIONED:\n");
        employee[currentIndex].typeEmployee = input.nextLine();
        employee[currentIndex].typeEmployee = employee[currentIndex].typeEmployee.toUpperCase();

        //if(employee[currentIndex].typeEmployee == "HOURLY")
        if(employee[currentIndex].typeEmployee.equals("HOURLY"))
        {
            System.out.println("Enter to salary for Hourly employee (example: 10.85):");
            employee[currentIndex].wageSalary = input.nextDouble();
            employee[currentIndex].monthlySalary = 0.0;// Salário mensal
            employee[currentIndex].commissioned = 0.0;// Comissão
            employee[currentIndex].salaryEmployee = 0.0;// Salário total

            System.out.println("Type of default payment agend is Weekly.");
            employee[currentIndex].typeAgend = "WEEKLY";// Pagos semanalmente

            employee[currentIndex].weeklyDay = 5;// Por default, são pagos toda a sexta

            employee[currentIndex].dataDay = 0;// Dia do mês que é pago
        }

        //else if(employee[currentIndex].typeEmployee == "SALARIED")
        else if(employee[currentIndex].typeEmployee.equals("SALARIED"))
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

        //else if(employee[currentIndex].typeEmployee. == "COMISSIONED")
        else if(employee[currentIndex].typeEmployee.equals("COMISSIONED"))
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

        input.nextLine();
        System.out.printf("Is employee sindycalist? (1 - Yes | 0 - No):\n");
        employee[currentIndex].isSyndicalist = input.nextInt();
        if(isSindycalistEmployee(employee[currentIndex].isSyndicalist) == 1)
        {
            System.out.printf("Enter to number of syndicate - 3 digits:\n");
            employee[currentIndex].getIdEmployeeSyndicalist = input.nextInt();
            input.nextLine();

            System.out.printf("Enter to fee syndicate:\n");
            employee[currentIndex].unionFee = input.nextDouble();

            System.out.printf("Enter to ohter fees syndicate:\n");
            employee[currentIndex].outherFees = input.nextDouble();
        }else{
            System.out.printf("Employee is not syndicalist!\n");
        }

        input.nextLine();
        System.out.printf("Enter to type of payment (CORREIOS, MAOS, DEPOSITO):\n");
        employee[currentIndex].typeOfPayment = input.nextLine();
        employee[currentIndex].typeOfPayment = employee[currentIndex].typeOfPayment.toUpperCase();

        return currentIndex;
    }

    // GUARDANDO DADOS POR SEGURANÇA PARA UNDO E REDO
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
                System.out.printf("ID employee: %d", employees[i].idEmployee, "\nName employee: %s\n", employees[i].name);
        }
    }

    // REMOVENDO EMPREGADO
    public static void removeEmployee(Employee[] employee, Scanner input)
    {
        printEmployee(employee);
        int lastEmployeeId = employee.length;
        System.out.printf("Please enter the employee ID you wish to remove [0 - %d]:\n", lastEmployeeId);
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

            //if(type == "HOURLY")
            if(type.equals("HOURLY"))
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
                    System.out.printf("Day time card ok!\nYou worked until 8 hours!\nThank you!\n");
                }else{
                    double extraHours = workedHours - 8;
                    employees[idInput].salaryEmployee += ((8 * employees[idInput].wageSalary) +
                            (extraHours * employees[idInput].wageSalary * 1.5));
                    System.out.printf("Day time card ok!\nYou worked more than 8 hours!\nThank you!\n");
                }
            }
        }
    }

    // RESULTADO DA VENDA
    public static void saleResult(Employee[] employees, Scanner input)
    {
        printEmployee(employees);
        int lastEmployeeId = employees.length;
        System.out.printf("Enter to ID employee for add UNION FEE:[0 - %d]\n", lastEmployeeId);
        int idInput = input.nextInt() - 1;

        if(employees[idInput] == null)
        {
            System.out.println("Employee is not exists!");
        }else{
            //if(employees[idInput].typeEmployee == "COMISSIONED")
            if(employees[idInput].typeEmployee.equals("COMISSIONED"))
            {
                System.out.println("Enter to sale result:");
                double sale = input.nextDouble();
                employees[100] = new Employee();
                safetyData(employees[idInput], employees[100]);

                employees[idInput].salaryEmployee += sale * (employees[idInput].commissioned/100);

                System.out.printf("Registered of the SALE RESULT of the employee %s is ok!", employees[idInput].name);
            }else{
                System.out.println("Employee %s" + employees[idInput].name + "is not COMISSIONED!");
            }
        }
    }

    // LANÇANDO TAXAS ADICIONAIS DE SERVIÇO
    public static void othersFeeEmployee(Employee[] employees, Scanner input)
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

    // ALTERAR DADOS DE UM EMPREGADO
    public static void changeDataEmployee(Employee[] employees, Scanner input)
    {
        printEmployee(employees);
        int lastEmployeeId = employees.length;
        System.out.printf("Enter to ID employee for change data:[0 - %d]\n", lastEmployeeId);
        int idInput = input.nextInt() - 1;

        if(employees[idInput] == null)
        {
            System.out.println("Employee is not exists!");
        }else{
            employees[100] = new Employee();
            safetyData(employees[idInput], employees[100]);

            System.out.println("Change NAME employee with name " + employees[idInput].name
            + "(Yes | No)?");
            String answer = input.nextLine();
            answer = answer.toUpperCase();

            //if(answer == "YES")
            if(answer.equals("YES"))
            {
                System.out.println("Enter to new NAME employee:");
                employees[idInput].name = input.nextLine();
            }else{
                System.out.println("Unchanged NAME!");
            }

            System.out.println("Change ADDRESS employee " + employees[idInput].address
                    + "(Yes | No)?");
            answer = input.nextLine();
            answer = answer.toUpperCase();

            //if(answer == "YES")
            if(answer.equals("YES"))
            {
                System.out.println("Enter to new ADDRESS employee:");
                employees[idInput].address = input.nextLine();
            }else {
                System.out.println("Unchanged ADDRESS!");
            }

            System.out.println("Change TYPE employee " + employees[idInput].typeEmployee
                    + "(Yes | No)?");
            answer = input.nextLine();
            answer = answer.toUpperCase();

            //if(answer == "NO")
            if(answer.equals("NO"))
            {
                System.out.println("Unchanged TYPE!");
            }else {
                System.out.println("Enter to new TYPE employee:");
                System.out.println("HOURLY\nSALARIED\nCOMISSIONED:");
                String type = input.nextLine();
                type = type.toUpperCase();
                employees[idInput].typeEmployee = type;

                //if(employees[idInput].typeEmployee == "HOURLY")
                if(employees[idInput].typeEmployee.equals("HOURLY"))
                {
                    System.out.println("Enter to salary for Hourly employee (example: 10.85):\n");
                    employees[idInput].wageSalary = input.nextDouble();
                    employees[idInput].monthlySalary = 0.0;// Salário mensal
                    employees[idInput].commissioned = 0.0;// Comissão
                    employees[idInput].salaryEmployee = 0.0;// Salário total

                    System.out.println("Type of default payment agend is Weekly.\n");
                    employees[idInput].typeAgend = "WEEKLY";// Pagos semanalmente

                    employees[idInput].weeklyDay = 5;// Por default, são pagos toda a sexta

                    employees[idInput].dataDay = 0;// Dia do mês que é pago
                }
                //else if(employees[idInput].typeEmployee == "SALARIED")
                else if(employees[idInput].typeEmployee.equals("SALARIED"))
                {
                    employees[idInput].wageSalary = 0.0;// Salário por hora
                    System.out.println("Enter to salary for mouthly salary:\n");
                    employees[idInput].monthlySalary = input.nextDouble();// Salário mensal
                    employees[idInput].commissioned = 0.0;// Comissão
                    employees[idInput].salaryEmployee = 0.0;// Salário total
                }

                //else if(employees[idInput].typeEmployee == "COMISSIONED")
                else if(employees[idInput].typeEmployee.equals("COMISSIONED"))
                {

                    employees[idInput].wageSalary = 0.0;// Salário por hora
                    System.out.println("Enter to salary for mouthly salary:\n");
                    employees[idInput].monthlySalary = input.nextDouble();// Salário mensal
                    System.out.println("Enter to percentage of sales commissions (ex. 20 (present 0.2 or 20 percent of comissioned):\n");
                    employees[idInput].commissioned = input.nextDouble();// Comissão em %
                    employees[idInput].salaryEmployee = 0.0;// Salário total

                }else{
                    System.out.println("TYPE employee " + type + " is not exists!");
                }

                System.out.println("Change PAYMENT TYPE?");
                answer = input.nextLine();
                answer = answer.toUpperCase();

                //if(answer == "NO")
                if(answer.equals("NO"))
                {
                    System.out.println("Unchanged PAYMENT TYPE!");
                }else{
                    String typePayment = input.nextLine();
                    typePayment = typePayment.toUpperCase();

                    //if(typePayment == "WEEKLY")
                    if(typePayment.equals("WEEKLY"))
                    {
                        System.out.printf("Type of default payment agend is Weekly.\n");
                        employees[idInput].typeAgend = "WEEKLY";// Pagos semanalmente

                        employees[idInput].weeklyDay = 5;// Por default, são pagos toda a sexta

                        employees[idInput].dataDay = 0;// Dia do mês que é pago
                    }
                    //else if(typePayment == "MONTHLY")
                    else if(typePayment.equals("MONTHLY"))
                    {
                        System.out.println("Type of default payment agend is Monthly.\n");
                        employees[idInput].typeAgend = "MONTHLY";// Pagos mensalmente

                        employees[idInput].weeklyDay = 0;// Pagamento semanal

                        employees[idInput].dataDay = 27;// Dia do mês que é pago (último dia do mês)
                    }
                    //else if(typePayment == "BIWEEKLY")
                    else if(typePayment.equals("BIWEEKLY"))
                    {
                        System.out.println("Type of default payment agend is BiWeekly.\n");
                        employees[idInput].typeAgend = "BIWEEKLY";// Pagos bi-semanalmente

                        employees[idInput].weeklyDay = 5;// Pagamento semanal toda sexta

                        employees[idInput].dataDay = 0;// Dia do mês que é pago
                    }

                }

                System.out.println("Change employee participation in Syndicate?");
                answer = input.nextLine();
                answer = answer.toUpperCase();

                //if(answer == "NO")
                if(answer.equals("NO"))
                {
                    System.out.println("Unchanged participation in SYNDICATE!");
                }else{
                    System.out.println("The employee is part of the SYNDICATE?");
                    if(isSindycalistEmployee(employees[idInput].isSyndicalist) == 1)
                    {
                        System.out.println("Canceled SYNDICATE membership!");

                        System.out.println("Canceled number SYNDICATE!");
                        employees[idInput].getIdEmployeeSyndicalist = -1;

                        System.out.printf("Canceled FEE syndicate!\n");
                        employees[idInput].unionFee = 0.0;

                        System.out.printf("Canceled other fees syndicate!\n");
                        employees[idInput].outherFees = 0.0;

                    }else{
                        System.out.println("Enter to number of syndicate - 3 digits:");
                        employees[idInput].getIdEmployeeSyndicalist = input.nextInt();

                        System.out.println("Enter to fee syndicate:");
                        employees[idInput].unionFee = input.nextDouble();

                        System.out.println("Enter to other fees syndicate:");
                        employees[idInput].outherFees = input.nextDouble();
                    }
                }
            }
        }
    }

    // RODAR FOLHA DE PAGAMENTO

    // FUNÇÃO AUXILIAR
    public static int lastDayMonth(int day, int month, int year)
    {
        if(day == 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12))
        {
            return 1;
        }
        else if(day == 30 && (month == 4 || month == 6 || month == 9 || month == 11))
        {
            return 1;
        }
        else if(day == 29 && (month == 2 && year % 4 == 0))// ANO BISSEXTO
        {
            return 1;
        }
        else if(day == 28 && (month == 2 && year % 4 != 0))// ANO NÃO BISSEXTO
        {
            return 1;
        }else{
            return 0;
        }
    }
    // PAGAMENTO SEMANAL
    public static void weeklyPayment(Employee[] employees, int dataToday)
    {
        for (int i = 0; i < 100; ++i)
        {
            if(employees[i] != null)
            {
                //if(employees[i].typeAgend == "WEEKLY" && employees[i].weeklyDay == dataToday)
                if(employees[i].typeAgend.equals("WEEKLY") && employees[i].weeklyDay == dataToday)
                {
                    employees[i].salaryEmployee += (employees[i].monthlySalary/4) - ((employees[i].unionFee + employees[i].outherFees)/4);
                    System.out.printf("Salary of the employee %s", employees[i].name, " is %.2f\n", employees[i].salaryEmployee);
                    employees[i].salaryEmployee = 0.0;
                    //employees[i].outherFees = 0.0;
                }
            }else{
                System.out.printf("Employee %d is not exists!\n", i);
            }
        }
    }

    // PAGAMENTO MENSAL
    public static void monthlyPayment(Employee[] employees, int dataToday)
    {
        for (int i = 0; i < 100; ++i)
        {
            if(employees[i] != null)
            {
                //if(employees[i].typeAgend == "MONTHLY" && employees[i].dataDay == dataToday)
                if(employees[i].typeAgend.equals("MONTHLY") && employees[i].dataDay == dataToday)
                {
                    employees[i].salaryEmployee += employees[i].monthlySalary - (employees[i].unionFee + employees[i].outherFees);
                    System.out.printf("Salary of the employee %s", employees[i].name," is %.2f\n", employees[i].salaryEmployee);
                    employees[i].salaryEmployee = 0.0;
                    //employees[i].outherFees = 0.0;
                }
            }else{
                System.out.printf("Employee %d is not exists!\n", i);
            }
        }
    }
    // PAGAMENTO BISSEMANAL
    public static void biweeklyPayment(Employee[] employees, int dataToday)
    {
        for (int i = 0; i < 100; ++i)
        {
            if(employees[i] != null)
            {
                //if(employees[i].typeAgend == "BIWEEKLY" && employees[i].dataDay == dataToday)
                if(employees[i].typeAgend.equals("BIWEEKLY") && employees[i].dataDay == dataToday)
                {
                    employees[i].salaryEmployee += (employees[i].monthlySalary/2) - ((employees[i].unionFee + employees[i].outherFees)/2);
                    System.out.printf("Salary of the employee %s", employees[i].name, " is %.2f", employees[i].salaryEmployee);
                    employees[i].salaryEmployee = 0.0;
                    //employees[i].outherFees = 0.0;
                }
            }else{
                System.out.printf("Employee %d is not exists!\n", i);
            }
        }
    }
    // SUPONDO CADA MÊS COMEÇANDO NO DOMINGO (PARA FACILITAR)
    public static void runPayrollToday(Employee[] employees, Scanner input)
    {
        int paymentDay;
        System.out.println("Please, enter to current day:");
        int day = input.nextInt();
        System.out.println("Please, enter to current month:");
        int month = input.nextInt();
        System.out.println("Please, enter to current year:");
        int year = input.nextInt();
        System.out.println("Please, enter to current weekly day:");
        System.out.println("1 - Monday | 2 - Tuesday | 3 - Wednesday | 4 - Thursday | 5 - Friday:");
        int weekday = input.nextInt();

        if(weekday < 1 || weekday > 5)
        {
            System.out.println("Weekday incorrect! Enter to new number representing weekday [1 to 5]");
            weekday = input.nextInt();
        }

        int auxDay = lastDayMonth(day,month,year);

        if(auxDay == 1)
        {
            paymentDay = 27;
        }else{
            paymentDay = day;
        }
        monthlyPayment(employees, paymentDay);
        weeklyPayment(employees,5);
        // Quando é bissemanal, o dia fica entre 7 ^ 15 ou 21 ^ 28
        if((day >= 8 && day <= 14) || (day >= 22 && day <= 28))
        {
            biweeklyPayment(employees, weekday);
        }else
        {
            System.out.println("Invalid day!");
        }
    }

    // UNDO ^ REDO
    public static void undoRedo(Employee[] employees, int currentAction, int currentLastAction, Scanner input)
    {
        System.out.println("UNDO or REDO?");
        String action = input.nextLine();
        action = action.toUpperCase();

        //if(action == "UNDO")
        if(action.equals("UNDO"))
        {
            switch (currentAction)
            {
                case 0:
                    System.out.println("Anywhere operation in Payroll System!");
                    break;
                case 1:
                    employees[100] = new Employee();
                    safetyData(employees[currentLastAction], employees[100]);
                    employees[currentAction] = null;
                    System.out.println("UNDO successfully!");
                    break;
                case 2:
                    int index = employees[100].idEmployee - 1;
                    employees[index] = new Employee();
                    safetyData(employees[100], employees[index]);
                    System.out.println("UNDO successfully!");
                    break;
                default:
                    index = employees[100].idEmployee - 1;
                    Employee auxEmployee = new Employee();
                    // Swap
                    safetyData(employees[index], auxEmployee);
                    safetyData(employees[100], employees[index]);
                    safetyData(auxEmployee, employees[100]);
                    System.out.println("UNDO successfully!");
                    break;
            }
        }
        //else if(action == "REDO")
        else if(action.equals("REDO"))
        {
            int index = employees[100].idEmployee - 1;
            switch (currentAction)
            {
                case 1:
                    employees[index] = new Employee();
                    safetyData(employees[100], employees[index]);
                    break;
                case 2:
                    employees[index] = null;
                    break;
                 default:
                     Employee auxEmployee = new Employee();
                     safetyData(employees[index], auxEmployee);
                     safetyData(employees[100], employees[index]);
                     System.out.println("REDO successfully!");
            }
        }
    }

    // ALTERANDO AGENDA DE PAGAMENTO
    public static void alterAgendaPayroll(Employee[] employees, AgendaPayroll agenda, Scanner input)
    {
        printEmployee(employees);
        int lastEmployeeId = employees.length;
        System.out.printf("Enter to ID employee for change data:[0 - %d]\n", lastEmployeeId);
        int idInput = input.nextInt() - 1;

        if(employees[idInput] == null)
        {
            System.out.printf("Employee is not exists!\n");
        }else{
            int chooseDay;
            System.out.println("Choose the type of payment agenda:");
            System.out.println("WEEKLY | MONTHLY | BIWEEKLY");
            String typeAgenda = input.nextLine();
            typeAgenda = typeAgenda.toUpperCase();

            //if(typeAgenda == "WEEKLY")
            if(typeAgenda.equals("WEEKLY"))
            {
                System.out.println("Choose the day of the payment employee:");
                System.out.println("1 - Monday | 2 - Tuesday | 3 - Wednesday | 4 - Thursday | 5 - Friday:");
                chooseDay = input.nextInt();

                if (agenda.weeklyPayment[chooseDay] == 1)
                {
                    employees[idInput].weeklyDay = chooseDay;
                    employees[idInput].typeAgend = "WEEKLY";
                    employees[idInput].dataDay = 0;
                    System.out.println("Changed AGENDA successfully!");
                }else{
                    System.out.println("Not available AGENDA!");
                }
            }
            //else if(typeAgenda == "MONTHLY")
            else if(typeAgenda.equals("MONTHLY"))
            {
                System.out.println("Employee payday in the month:");
                chooseDay = input.nextInt();

                if(agenda.monthlyPayment[chooseDay] == 1)
                {
                    employees[idInput].weeklyDay = chooseDay;
                    employees[idInput].typeAgend = "MONTHLY";
                    employees[idInput].dataDay = -1;
                    System.out.println("Changed AGENDA successfully!");
                }else{
                    System.out.println("Not available AGENDA!");
                }
            }
            //else if(typeAgenda == "BIWEEKLY")
            else if(typeAgenda.equals("BIWEEKLY"))
            {
                System.out.printf("Choose the day of the payment employee:\n");
                System.out.printf("1 - Monday | 2 - Tuesday | 3 - Wednesday | 4 - Thursday | 5 - Friday:\n");
                chooseDay = input.nextInt();

                if (agenda.weeklyPayment[chooseDay] == 1)
                {
                    employees[idInput].weeklyDay = chooseDay;
                    employees[idInput].typeAgend = "BIWEEKLY";
                    employees[idInput].dataDay = 0;
                    System.out.println("Changed AGENDA successfully!");
                }else{
                    System.out.println("Not available AGENDA!");
                }
            }
        }
    }
}
