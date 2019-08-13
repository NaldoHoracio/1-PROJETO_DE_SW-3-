/**!
 * @className tools.Salaried.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-07-24
 *
 * @copyright Copyright (c) IC 2019
 *
 */

package tools;

import employees.CommissionEmployee;
import employees.Employee;
import employees.HourlyEmployee;
import employees.SalariedEmployee;

import java.util.Scanner;
import java.util.ArrayList;

public class Functions {

    private ArrayList<Employee> employeeList;
    private int idEmployee = 0;

    public ArrayList<Employee> getEmployeeList()
    {
        return this.employeeList;
    }

    public Functions(boolean activate)
    {
        employeeList = new ArrayList<Employee>();
    }

    public int searchIdEmployee(ArrayList<Employee> emp, int idEmp)
    {
        int index = -1;
        if(emp == null)
        {
            index = -1;
        }else{
            for(int i = 0; i < emp.size(); ++i)
            {
                if(emp.get(i).getIdEmployee() == idEmp)
                {
                    index = i;
                }
            }
        }

        return index;
    }

    public void printListEmployee()
    {
        for (int i = 0; i < employeeList.size(); ++i)
        {
            System.out.println(employeeList.get(i).toString());
        }
    }

    public void addEmployee()
    {
        Scanner input = new Scanner(System.in);
        Employee empAux = null;
        int typeEmp;

        System.out.println("Digite o tipo de empregado: 1 - ASSALARIADO | 2 - COMISSIONADO | 3 - HORISTA");
        typeEmp = input.nextInt();

        if(typeEmp == 1)
        {
            idEmployee++;
            empAux = new SalariedEmployee(idEmployee);
            employeeList.add(empAux);
            System.out.println("Empregado do tipo ASSALARIADO adicionado com sucesso!");
        }
        else if(typeEmp == 2)
        {
            idEmployee++;
            empAux = new CommissionEmployee(idEmployee);
            employeeList.add(empAux);
            System.out.println("Empregado do tipo COMISSIONADO adicionado com sucesso!");
        }
        else if(typeEmp == 3)
        {
            idEmployee++;
            empAux = new HourlyEmployee(idEmployee);
            employeeList.add(empAux);
            System.out.println("Empregado do tipo HORISTA adicionado com sucesso!");
        }else{
            System.out.println("Este tipo de empregado não existe!");
        }
        System.out.printf("\n");
    }

    public void removeEmployee()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o ID do empregado que deseja remover:");
        printListEmployee();
        int idEmp = input.nextInt();
        int index = -1;
        index = searchIdEmployee(employeeList, idEmp);

        if(index != -1)
        {
            employeeList.remove(index);
            System.out.println("Empregado com ID " + idEmp + " removido com sucesso!");
        }else{
            System.out.println("O empregado com ID " + idEmp + " não existe!");
        }
    }

    public void launchCardPoint()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o ID do empregado que deseja lançar o cartão de ponto:");
        printListEmployee();
        int idEmp = input.nextInt();
        int index = -1;
        index = searchIdEmployee(employeeList, idEmp);

        if(index != -1)
        {
            if(employeeList.get(index).getTypeEmployee().equals("HORISTA"))
            {
                CardPoint.setCardPoint((HourlyEmployee) employeeList.get(index));
            }else{
                System.out.println("O empregado com ID " + idEmp + " não é HORISTA!");
            }
        }else{
            System.out.println("O empregado com ID " + idEmp + " não existe!");
        }
    }

    public void addSalesResult()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o ID do empregado que deseja lançar o resultado das vendas:");
        printListEmployee();
        int idEmp = input.nextInt();
        int index = -1;
        index = searchIdEmployee(employeeList, idEmp);

        if(index != -1)
        {
            if(employeeList.get(index).getTypeEmployee().equals("COMISSIONADO"))
            {
                ((CommissionEmployee )employeeList.get(index)).setSalesResult();
            }else{
                System.out.println("O empregado com ID " + idEmp + " não é COMISSIONADO!");
            }
        }else{
            System.out.println("O empregado com ID " + idEmp + " não existe!");
        }
    }

    public void addServiceFee()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o ID do empregado que deseja lançar uma taxa de serviço:");
        printListEmployee();
        int idEmp = input.nextInt();
        int index = -1;
        index = searchIdEmployee(employeeList, idEmp);

        if(index != -1)
        {
            if(employeeList.get(index).getIsSyndicalist() == true)
            {
                employeeList.get(index).setOthersFee();
            }else{
                System.out.println("O empregado com ID " + idEmp + " NÃO faz parte do SINDICATO!");
            }
        }else{
            System.out.println("O empregado com ID " + idEmp + " não existe!");
        }
    }

    public void changeEmployeeData()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Escolha o ID do empregado cujos dados deseja alterar:");
        printListEmployee();
        int idEmp = input.nextInt();
        int index = -1;
        index = searchIdEmployee(employeeList, idEmp);

        if(index != -1)
        {
            System.out.println("O que deseja mudar: " +
                    "1 - Nome\n" +
                    "2 - Endereço\n" +
                    "3 - Tipo\n" +
                    "4 - Método de pagamento\n" +
                    "5 - Situação sindical\n" +
                    "6 - Identificação no sindicato\n" +
                    "7 - Taxa no sindicato ?\n");

            int opChange = input.nextInt();

            if(opChange == 1)// NOME
            {
                employeeList.get(index).setName();
                System.out.println("NOME alterado com sucesso!");
            }
            else if(opChange == 2)// ENDEREÇO
            {
                employeeList.get(index).setAddress();
                System.out.println("ENDEREÇO alterado com sucesso!");
            }
            else if(opChange == 3)// TIPO DE EMPREGADO
            {
                System.out.println("Este funcionário é do tipo " + employeeList.get(index).getTypeEmployee());
                int typeEmp;
                if(employeeList.get(index).equals("ASSALARIADO"))
                {
                    System.out.println("Escolha o novo tipo de empregado: 2 - COMISSIONADO | 3 - HORISTA");
                    typeEmp = input.nextInt();
                    if(typeEmp == 2)
                    {
                        employeeList.get(index).setTypeEmployee("COMISSIONADO");
                    }
                    else if(typeEmp == 3)
                    {
                        employeeList.get(index).setTypeEmployee("HORISTA");
                    }else{
                        System.out.println("Este tipo de emepregado não existe!");
                    }
                }
                else if(employeeList.get(index).equals("COMISSIONADO"))
                {
                    System.out.println("Escolha o novo tipo de empregado: 1 - ASSALARIADO | 3 - HORISTA");
                    typeEmp = input.nextInt();
                    if(typeEmp == 1)
                    {
                        employeeList.get(index).setTypeEmployee("ASSALARIADO");
                    }
                    else if(typeEmp == 3)
                    {
                        employeeList.get(index).setTypeEmployee("HORISTA");
                    }else{
                        System.out.println("Este tipo de emepregado não existe!");
                    }
                }
                else if(employeeList.get(index).equals("HORISTA"))
                {
                    System.out.println("Escolha o novo tipo de empregado: 1 - ASSALARIADO | 2 - COMISSIONADO");
                    typeEmp = input.nextInt();
                    if(typeEmp == 1)
                    {
                        employeeList.get(index).setTypeEmployee("ASSALARIADO");
                    }
                    else if(typeEmp == 3)
                    {
                        employeeList.get(index).setTypeEmployee("COMISSIONADO");
                    }else{
                        System.out.println("Este tipo de emepregado não existe!");
                    }
                }
            }
            else if(opChange == 4)//MÉTODO DE PAGAMENTO
            {
                System.out.println("Este funcionário recebe en/por/pelo " + employeeList.get(index).getTypeOfPayment());
                int typePagto;
                if(employeeList.get(index).equals("DEPOSITO"))
                {
                    System.out.println("Escolha o novo tipo de pagamento: 2 - EM MAOS | 3 - CORREIOS");
                    typePagto = input.nextInt();
                    if(typePagto == 2)
                    {
                        employeeList.get(index).setTypeOfPayment("EM MAOS");
                    }
                    else if(typePagto == 3)
                    {
                        employeeList.get(index).setTypeOfPayment("CORREIOS");
                    }
                    else if(typePagto == 1)
                    {
                        System.out.println("Tipo de pagamento não alterado!");
                    }
                    else{
                        System.out.println("Este tipo de pagamento não existe!");
                    }
                }
                else if(employeeList.get(index).equals("EM MAOS"))
                {
                    System.out.println("Escolha o novo tipo de pagamento: 1 - DEPOSITO | 3 - CORREIOS");
                    typePagto = input.nextInt();
                    if(typePagto == 1)
                    {
                        employeeList.get(index).setTypeOfPayment("DEPOSITO");
                    }
                    else if(typePagto == 3)
                    {
                        employeeList.get(index).setTypeEmployee("CORREIOS");
                    }
                    else if(typePagto == 2)
                    {
                        System.out.println("Tipo de pagamento não alterado!");
                    }
                    else{
                        System.out.println("Este tipo de empregado não existe!");
                    }
                }
                else if(employeeList.get(index).equals("CORREIOS"))
                {
                    System.out.println("Escolha o novo tipo de empregado: 1 - DEPOSITO | 2 - EM MAOS");
                    typePagto = input.nextInt();
                    if(typePagto == 1)
                    {
                        employeeList.get(index).setTypeEmployee("DEPOSITO");
                    }
                    else if(typePagto == 2)
                    {
                        employeeList.get(index).setTypeEmployee("EM MAOS");
                    }
                    else if(typePagto == 3)
                    {
                        System.out.println("Tipo de pagamento não alterado!");
                    } else{
                        System.out.println("Este tipo de emepregado não existe!");
                    }
                }
            }
            else if(opChange == 5)// SITUAÇÃO SINDICAL
            {
                employeeList.get(index).setMembershipEmployee(employeeList.get(index).getIdEmployee());
                System.out.println("Situação SINDICAL alterada com sucesso!");
            }
            else if(opChange == 6)// IDENTIFICAÇÃO DO SINDICATO
            {
                if(employeeList.get(index).getIsSyndicalist() == true)
                {
                    employeeList.get(index).setIdSyndicalist();
                    System.out.println("IDENTIFICAÇÃO SINDICAL alterada com sucesso!");
                }else{
                    System.out.println("O empregado com ID " + employeeList.get(index).getIdEmployee() + " NÃO faz parte do SINDICATO!");
                }
            }
            else if(opChange == 7)// TAXA DO SINDICADO
            {

                if(employeeList.get(index).getIsSyndicalist() == true)
                {
                    employeeList.get(index).setUnionFee(employeeList.get(index).getIdEmployee());
                    System.out.println("TAXA SINDICAL alterada com sucesso!");
                }else{
                    System.out.println("O empregado com ID " + employeeList.get(index).getIdEmployee() + " NÃO faz parte do SINDICATO!");
                }
            }
        }else{
            System.out.println("O empregado com ID " + idEmp + " não existe!");
        }
    }
}
