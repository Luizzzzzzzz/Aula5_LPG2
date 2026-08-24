package org.example.View;

import org.example.Controller.EstudanteController;
import org.example.Model.Estudante;

import java.util.Scanner;

public class ConsultaEstudantePorId {
    static Scanner scanner = new Scanner(System.in);

    public static void exibeInterface() {
        Long id;
        String formato = " \"%1$-2s %2$-25s %3$-15s %4$-12s %5-10S$%n";

        System.out.println("\nConsulta de Estudantes Por ID: ");
        System.out.println("Informe o ID do Estudante: ");
        id = Long.parseLong(scanner.nextLine());

        Estudante estudante = new EstudanteController().consultaEstudantePorId(id);

        System.out.printf(formato, "ID", " | Nome", " | Sexo", " | PCD", " | IRA");
        System.out.printf(formato, estudante.getId(),
                            " | "+estudante.getNome(),
                            " | "+estudante.getSexo(),
                            " | "+(estudante.isPCD() ? "Sim" : "Não"),
                            " | "+estudante.getIRA()+"\n");
    }
}
