package iFace;

import java.util.ArrayList;
import java.util.Scanner;

public class Community
{
    String name, theme, admin;
    ArrayList<iFace.InputBox> messages = new ArrayList<iFace.InputBox>();
    ArrayList<iFace.Friends> members = new ArrayList<iFace.Friends>();
    ArrayList<iFace.Invite> invites = new ArrayList<iFace.Invite>();
    Scanner input = new Scanner(System.in);

    public void setCommunity(String username)
    {
        System.out.printf("Digite um nome para sua nova comunidade:\n=> ");
        name = input.nextLine();
        System.out.printf("Digite o tema da sua nova comunidade:\n=> ");
        theme = input.nextLine();
        admin = username;
    }
}