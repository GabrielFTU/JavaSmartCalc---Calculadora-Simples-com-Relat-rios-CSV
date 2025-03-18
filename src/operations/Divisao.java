package operations;

import model.OperacaoMatematica;

public class Divisao implements OperacaoMatematica {
	@Override
	public double calcular(double... valores) {
		double resultado = valores[0];

		for (int i = 1; i < valores.length; i++) {
			if (valores[i] == 0) {
				throw new ArithmeticException("Não é possível divitir por zero!");
			}
			resultado /= valores[i];
		}
		return resultado;
	}

}
