package org.example.View;

import org.example.Controller.EstudanteController;

import java.math.BigDecimal;
import java.util.Scanner;

public class AlteraEstudante {
    static Scanner scanner = new Scanner(System.in);

    public static void exibeInterface (){
        Long id;
        String nome;
        Character sexo;
        BigDecimal IRA = null;
        Boolean PCD;

        System.out.println("Alteração de Estudante");
        System.out.print("Informe o ID do aluno a ser alterado: ");
        id = Long.parseLong(scanner.nextLine());
        System.out.print("Nome: ");
        nome = scanner.nextLine();
        System.out.print("Sexo (F ou M): ");
        sexo = scanner.nextLine().charAt(0);
        System.out.print("Possui necessidade especial? (sim ou não): ");
        PCD = scanner.nextLine().equalsIgnoreCase("sim");
        System.out.print("IRA: ");
        IRA = new BigDecimal(scanner.nextLine());

        new EstudanteController().alteraEstudante(id, nome, sexo, PCD, IRA);
        System.out.println("Estudante alterado com sucesso!");

    }
}
