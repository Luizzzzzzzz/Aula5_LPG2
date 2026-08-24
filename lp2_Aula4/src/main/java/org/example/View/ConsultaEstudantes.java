package org.example.View;

import org.example.Controller.EstudanteController;
import org.example.Model.Estudante;

import java.util.Scanner;

public class ConsultaEstudantes {
    static Scanner scanner = new Scanner(System.in);

    public static void exibeInterface(){
        String formato = "%1$-2s %2$-25s %3$-15s %4$-12s %5$-10s%n";

        System.out.println("\nConsulta de Estudantes: ");
        System.out.printf(formato, "ID", " | Nome", " | Sexo", " | PCD", " | IRA");

        for (Estudante estudante : new EstudanteController().consultaEstudantes()) {
            System.out.printf(formato, estudante.getId(),
                                " | " + estudante.getNome(),
                                " | " + estudante.getSexo(),
                                " | " + (estudante.isPCD() ? "Sim" : "Não"),
                                " | " + estudante.getIRA());
        }
        System.out.println();
        exibeAlterarExcluir();
    }

    public static void exibeAlterarExcluir() {
        int opcao = 0;

        do {
            System.out.println("Alteração / Exclusão de Aluno:");
            System.out.println("1) Alterar");
            System.out.println("2) Excluir");
            System.out.println("0) Voltar");
            System.out.println("Digite uma opção. ");

            opcao = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    AlteraEstudante.exibeInterface();
                    break;
                case 2:
                    ExcluiEstudante.exibeInterface();
                    break;
                default:
                    if (opcao != 1 && opcao != 2)
                        System.out.println("Digite uma Opção Válida. ");
            }

        } while (opcao != 0 && opcao != 1 && opcao != 2);
    }
}
