package operations;

import model.OperacaoMatematica;

public class Subtracao implements OperacaoMatematica {
	@Override
	public double calcular(double... valores) {
		double resultado = valores[0];
		for (int i = 1; i < valores.length; i++) {
			resultado -= valores[i];
		}
		return resultado;
	}

}
