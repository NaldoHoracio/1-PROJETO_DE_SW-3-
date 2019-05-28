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
    public enum typeEmployee{HOURLY, SALARIED, COMISSIONED};// Tipo do empregado - Horista, Assalariado e Comissionado
    public int idEmployee;// Número de identificação do empregado

    public double wageSalary;// Salário horário
    public double monthlySalary;// Salário mensal
    public double commissioned;// Comissão
    public double salaryEmployee;// Salário total do empregado

    public boolean isSyndicalist;// Valida se o empregado faz parte do sindicato
    public int getIdEmployeeSyndicalist;// Número de identificação do empregado no sindicato
    public double unionFee;// Taxa do sindicato
    public double outherFees;// Outras taxas de quem pertence ao sindicato

    public enum typeOfPayment{CORREIOS, MAOS, DEPOSITO};// Tipo de pagamento: C - cheque pelos correios; M - cheque em mãos; B - depósito na conta
    public enum typeAgend{WEEKLY, BIWEEKLY, MONTHLY};// Tipo de agenda: S - semanalmente; B - bi-mensalmente; M - Mensalmente

}

public class Main
{
    public static void main(String[] args)
    {
        System.out.printf("Hello world!\n");
    }
}
