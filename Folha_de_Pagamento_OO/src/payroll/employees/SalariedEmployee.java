/**!
 * @className payroll.employees.SalariedEmployee.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-06-19
 *
 * @copyright Copyright (c) IC 2018
 *
 */
package payroll.employees;

import java.util.Scanner;

public class SalariedEmployee extends Employee {
    private double salaryMonthly;// Salário mensal
    private double salaryTotal;// Salário total do empregado

    Scanner input = new Scanner(System.in);

    // Configura o salário mensal
    public void setSalaryMonthly(double salaryMonthlyEmp)
    {
        System.out.println("Enter to monthly salary:");
        salaryMonthlyEmp = input.nextDouble();

        if(salaryMonthlyEmp < 0)
        {
            System.out.println("Error! Less value than 0!");
        }else{
            this.salaryMonthly = salaryMonthlyEmp;
        }
    }

    // Retorna o salário mensal
    public double getSalaryMonthly()
    {
        return salaryMonthly;
    }

    // Método para o salário do empregado
    @Override
    public double salariedEmployee() {
        if(isSyndicalistEmployee() == 1)
        {
            salaryTotal = getSalaryMonthly() - getUnionFee() - getOthersFee();
        }else{
            salaryTotal= getSalaryMonthly();
        }
        return salaryTotal;
    }
}
