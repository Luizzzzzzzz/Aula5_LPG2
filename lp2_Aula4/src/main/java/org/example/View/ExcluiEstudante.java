package org.example.View;

import org.example.Controller.EstudanteController;

import java.util.Scanner;

public class ExcluiEstudante {
    static Scanner scanner = new Scanner(System.in);

    public static void exibeInterface(){
        Long id;

        System.out.println("Exclusão de Estudante");
        System.out.print("Informe o id do livro a ser excluido: ");
        id = Long.parseLong(scanner.nextLine());

        new EstudanteController().excluiEstudante(id);
        System.out.println("Estudante excluido com sucesso!\n");
    }
}
