/**!
 * @className payroll.employees.SalariedEmployee.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-06-19
 *
 * @copyright Copyright (c) IC 2019
 *
 */
package payroll.employees;

import java.util.Scanner;

public class SalariedEmployee extends Employee {
    private double salaryTotal;// Salário total do empregado

    // Construtor
    public SalariedEmployee(int idEmployeeEmp)
    {
        super.setName();
        super.setAddress();
        super.setIdEmployee(idEmployeeEmp);
        super.setTypeEmployee("SALARIED");
        super.setTypeOfPayment("DEPOSIT");
        super.setTypeOfAgenda("MONTHLY");
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
