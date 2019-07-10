/**!
 * @className payroll.tools.EmployeeManager.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-06-26
 *
 * @copyright Copyright (c) IC 2019
 *
 */

package payroll.tools;

import payroll.employees.Employee;
import payroll.employees.HourlyEmployee;
import payroll.employees.SalariedEmployee;
import payroll.employees.CommissionEmployee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    Scanner input = new Scanner(System.in);
    private ArrayList<Employee> employees;
    private int typeEmp;
    private int numberOfEmployee = 0;

    public static void printEmployee(ArrayList<Employee> employees)
    {
        if(employees.isEmpty())
        {
            System.out.println("Não há funcionários cadastrados!");
        }else{
            System.out.println("Empregados cadastrados (Nome e ID):");
            for(int i = 0; i < employees.size(); ++i)
            {
                System.out.println("" +employees.toString());
            }
        }
    }

    public void addEmployee()
    {
        System.out.println("Digite o tipo de empregado que deseja adicionar:\n" +
                "1 - Horista\n" +
                "2 - Assalariados\n" +
                "3 - Comissionados\n");
        typeEmp = input.nextInt();

        Employee employeeAux = null;


        switch (typeEmp){
            case 1:
                numberOfEmployee++;
                employeeAux = new HourlyEmployee(numberOfEmployee);

                employees.add(employeeAux);
                System.out.println("Empregado Horista cadastrado com sucesso!");
                break;
            case 2:
                numberOfEmployee++;
                employeeAux = new SalariedEmployee(numberOfEmployee);

                employees.add(employeeAux);
                System.out.println("Empregado Assalariado cadastrado com sucesso!");
                break;
            case 3:
                numberOfEmployee++;
                employeeAux = new CommissionEmployee(numberOfEmployee);

                employees.add(employeeAux);
                System.out.println("Empregado Comissionado cadastrado com sucesso!");
                break;
             default:
                 System.out.println("Este tipo de empregado não existe!");
        }
    }

    public void removeEployee()
    {
        printEmployee(employees);
        System.out.println("Digite o ID do empregado que você vai remover:");
        int idEmp = input.nextInt();

        for (int i = 0; i < employees.size(); ++i)
        {
            if(employees.get(i).getIdEmployee() == idEmp)
            {
                employees.remove(i);
            }
        }
    }
}
