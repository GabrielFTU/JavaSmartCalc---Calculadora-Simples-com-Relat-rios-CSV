package main;

import util.SalvarCalculos;
import util.SalvarRelatorioCSV;

import java.util.Scanner;
import java.util.Stack;

public class Calculadora {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println(
					"Digite a expressão matemática (exemplo: 5 + 7 * 32 - 59 * 1000 / 2) ou \n'sair' para encerrar:");
			String expressao = scanner.nextLine();

			if (expressao.equalsIgnoreCase("sair")) {
				System.out.println("Encerrando a calculadora...");
				break;
			}

			double resultado = avaliarExpressao(expressao);

			if (Double.isNaN(resultado)) {
				System.out.println("Erro na expressão fornecida!");
			} else {
				System.out.println("O resultado da operação é: " + resultado);
			}

			System.out.println("Deseja salvar o cálculo? (S/N)");
			String salvar = scanner.nextLine();

			if (salvar.equalsIgnoreCase("S")) {

				SalvarCalculos.salvarEmArquivo(expressao, resultado);

				SalvarRelatorioCSV.salvarEmCSV(expressao, resultado);
			}
		}

		scanner.close();
	}

	public static double avaliarExpressao(String expressao) {
		Stack<Double> numeros = new Stack<>();
		Stack<Character> operadores = new Stack<>();

		expressao = expressao.replaceAll(" ", "");

		for (int i = 0; i < expressao.length(); i++) {
			char c = expressao.charAt(i);

			if (Character.isDigit(c)) {
				StringBuilder numero = new StringBuilder();
				while (i < expressao.length()
						&& (Character.isDigit(expressao.charAt(i)) || expressao.charAt(i) == '.')) {
					numero.append(expressao.charAt(i));
					i++;
				}
				i--;
				numeros.push(Double.parseDouble(numero.toString()));
			} else if (c == '+' || c == '-' || c == '*' || c == '/') {
				while (!operadores.isEmpty() && temPrecedencia(c, operadores.peek())) {
					numeros.push(realizarOperacao(operadores.pop(), numeros.pop(), numeros.pop()));
				}
				operadores.push(c);
			}
		}

		while (!operadores.isEmpty()) {
			numeros.push(realizarOperacao(operadores.pop(), numeros.pop(), numeros.pop()));
		}

		return numeros.pop();
	}

	public static boolean temPrecedencia(char op1, char op2) {
		if (op2 == '+' || op2 == '-') {
			return false;
		}
		if ((op1 == '*' || op1 == '/') && (op2 == '*' || op2 == '/')) {
			return true;
		}
		return op1 != '+' && op1 != '-';
	}

	public static double realizarOperacao(char operador, double b, double a) {
		switch (operador) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0) {
				System.out.println("Erro: Divisão por zero");
				return Double.NaN;
			}
			return a / b;
		default:
			return 0;
		}
	}
}
