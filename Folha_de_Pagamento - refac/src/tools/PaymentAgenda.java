/**!
 * @className tools.PaymentAgenda.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-07-24
 *
 * @copyright Copyright (c) IC 2019
 *
 */
package tools;

public class PaymentAgenda {
    private int[] dayWeekly = new int[5];// Agenda semanal - guarda o dia da semana
    private int[] dayBiweekly = new int[5];// Agenda bissemanal - guarda o dia da semana
    private int[] dayMonthly = new int[28];// Agenda mensal

    // Setando o dia da semana quando a agenda é semanal
    public void setDayWeekly(int[] dayWeekly) {
        this.dayWeekly = dayWeekly;
    }

    // Pegando o dia da semana quando a agenda é semanal
    public int[] getDayWeekly() {
        return dayWeekly;
    }

    // Configurando o dia da semana quando a agenda é bissemanal
    public void setDayBiweekly(int[] dayBiweekly) {
        this.dayBiweekly = dayBiweekly;
    }

    // Retornando o dia da semana quanod a agenda é bissemanal
    public int[] getDayBiweekly() {
        return dayBiweekly;
    }

    // Configurando o dia da semana quando a agenda é mensal
    public void setDayMonthly(int[] dayMonthly) {
        this.dayMonthly = dayMonthly;
    }

    // Retornando o dia da semana quando a agenda é mensal
    public int[] getDayMonthly() {
        return dayMonthly;
    }
}
