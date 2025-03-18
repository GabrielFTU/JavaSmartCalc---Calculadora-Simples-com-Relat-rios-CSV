package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SalvarCalculos {

	public static void salvarEmArquivo(String expressao, double resultado) {

		String caminhoArquivo = "calculos.txt";

		try (PrintWriter writer = new PrintWriter(new FileWriter(caminhoArquivo, true))) {

			writer.printf("Expressão: %s | Resultado: %.2f%n", expressao, resultado);

			System.out.println("Cálculo salvo com sucesso em: " + caminhoArquivo);
		} catch (IOException e) {
			System.out.println("Erro ao salvar o cálculo: " + e.getMessage());
		}
	}
}
