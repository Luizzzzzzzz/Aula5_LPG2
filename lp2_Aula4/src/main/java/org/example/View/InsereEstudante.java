package org.example.View;

import org.example.Controller.EstudanteController;

import java.util.Scanner;

public class InsereEstudante {
    static Scanner scanner = new Scanner(System.in);

    public static void exibeInterface() {
        String nome;
        Character sexo;
        Boolean PCD;

        System.out.println("\n Inserção de Estudante: ");
        System.out.println("Nome: ");
        nome = scanner.nextLine();
        System.out.println("Sexo (F ou M): ");
        sexo = scanner.nextLine().charAt(0);
        System.out.println("Possui necessidade especial? (sim ou não): ");
        PCD = scanner.nextLine().equalsIgnoreCase("sim");

        new EstudanteController().InsereEstudante(nome, sexo, PCD);
        System.out.println("Estudante cadastrado com sucesso");

    }
}
