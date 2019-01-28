public class Account
{
    private double balance;// Variável de instância que guarda o saldo

    // Construtor
    public Account(double initialBalance)
    {
        if(initialBalance > 0)
        {
            balance = initialBalance;
        }
    }// Fim do construtor

    // Adiciona uma quantia a conta
    public void credit(double amont)
    {
        balance += amont;
    }

    // Retorna o saldo da conta
    public double getBalance()
    {
        return balance;// Devolve o valor de saldo ao método que o chama
    }// Fim do método getBalance
}// Fim da classe Account
