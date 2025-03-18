package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SalvarRelatorioCSV {

	public static void salvarEmCSV(String expressao, double resultado) {

		String caminhoArquivo = "relatorio_calculos.csv";

		try (PrintWriter writer = new PrintWriter(new FileWriter(caminhoArquivo, true))) {

			boolean arquivoVazio = new java.io.File(caminhoArquivo).length() == 0;
			if (arquivoVazio) {
				writer.println("Expressão, Resultado");
			}

			writer.printf("\"%s\", %.2f%n", expressao, resultado);

			System.out.println("Relatório gerado com sucesso: " + caminhoArquivo);
		} catch (IOException e) {
			System.out.println("Erro ao salvar o relatório: " + e.getMessage());
		}
	}
}
