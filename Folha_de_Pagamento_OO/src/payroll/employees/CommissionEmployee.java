/**!
 * @className payroll.employees.CommissionEmployee.java
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

public class CommissionEmployee extends SalariedEmployee {
    private double salesResult;// Resultado das vendas
    private double commissionSale;// Comissão de vendas
    private double salaryTotal;// Salário total do empregado


    Scanner input = new Scanner(System.in);

    // Configurando o resultado das vendas em um período
    public void setSalesResult(double salesResultEmp)
    {
        System.out.println("Enter to sale result:");
        salesResultEmp = input.nextDouble();
        if(salesResultEmp < 0)
        {
            System.out.println("Sales result less than 0.");
        }else{
            this.salesResult = salesResultEmp;
        }
    }

    // Retorna o resultado das vendas
    public double getSalesResult()
    {
        return salesResult;
    }

    // Configura o percentual de comissão
    public void setCommissionSale(double commissionSaleEmp)
    {
        System.out.println("Enter to commission employee (Ex.: 20 is 20%):");
        commissionSaleEmp = input.nextDouble();
        if(commissionSaleEmp < 0)
        {
            System.out.println("Commission less than 0.");
        }else{
            this.commissionSale = commissionSaleEmp;
        }
    }

    // Retorna a comissão
    public double getCommissionSale()
    {
        return commissionSale;
    }

    // Salário do Empregado comissionado
    @Override
    public double salariedEmployee()
    {
        if(isSyndicalistEmployee() == 1)
        {
            salaryTotal = (getSalaryMonthly()/2 + getSalesResult()*getCommissionSale() - getUnionFee()/2 + getOthersFee()/2);
        }else{
            salaryTotal= (getSalaryMonthly()/2 + getSalesResult()*getCommissionSale());
        }
        return salaryTotal;
    }

}
