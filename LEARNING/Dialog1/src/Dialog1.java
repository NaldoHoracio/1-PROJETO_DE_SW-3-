import javax.swing.JOptionPane;// Importa a classe JOpitionPane

public class Dialog1
{
    public static void main(String[] args)
    {
        // Caixa de diálogo para fazer o usuário digitar o nome
        String name = JOptionPane.showInputDialog("What is your name?\n");

        // Criando mensagem
        String message = String.format("Chovendo muito %s?\n", name);

        // Exibe uma caixa de diálogo com uma mensagem
        JOptionPane.showMessageDialog(null, message);
    }// Fim do método main
}// Fim da classe Dialog1
