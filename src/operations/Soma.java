package operations;

import model.OperacaoMatematica;

public class Soma implements OperacaoMatematica {
	@Override
	public double calcular(double... valores) {
		double resultado = 0;
		for (double valor : valores) {
			resultado += valor;
		}
		return resultado;
	}
}
