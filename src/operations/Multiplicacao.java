package operations;

import model.OperacaoMatematica;

public class Multiplicacao implements OperacaoMatematica {
	@Override
	public double calcular(double... valores) {
		double resultado = 1;
		for(double valor : valores) {
			resultado *= valor;
		}
		return resultado;
	}

}
