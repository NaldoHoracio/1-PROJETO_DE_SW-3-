/* @project iFace
 * @autor Nome Sobrenome (email)
 * @creation date DD/MM/AAAA
 * @hour creation hh:mm
 */

package iFace;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		ArrayList<iFace.Register> accounts = new ArrayList<iFace.Register>();
		ArrayList<iFace.Register> backups = new ArrayList<iFace.Register>();
		boolean active = true; int choise;
		while(active)
		{
			System.out.printf("Bem-vindo ao iFace!\n");
			System.out.printf("[1] Login\n[2] Cadastre-se\n[3] Sair\n=> ");
			
			choise = input.nextInt(); input.nextLine();
			
			switch(choise)
			{
				case 1:
					iFace.Login new_login = new iFace.Login();
					int index = new_login.checkLogin(accounts);
					if(index>-1)
						new_login.menuLogin(accounts, index, backups);
					break;
				
				case 2:
					iFace.Register new_register = new iFace.Register();
					new_register.setRegister(accounts, new_register);
					break;
				
				default:
					active = false;
					break;
			}
		}
		System.out.printf("\nUsuario(s) cadastrado(s): [%s]\n", accounts.size());
		for(int i = 0; i < accounts.size(); i++)
			System.out.println(accounts.get(i).username);
		input.close();
	}

}
