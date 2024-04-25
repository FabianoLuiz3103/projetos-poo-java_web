package br.com.fiap.Uber.FuncoesAux.model;

import java.util.Random;

public class FuncoesSorteio {

	Random r = new Random();
	private String sorteada = null;
	private int aleatorio;
	private int sorteadaInt;

	public String fazerSorteio(String[] vet) {
		for (int i = 0; i < vet.length; i++) {
			this.aleatorio = r.nextInt(10);
			this.sorteada = vet[aleatorio];
		}
		return this.sorteada;
	}

	public String fazerSorteio(String[] vet, int ind) {
		for (int i = 0; i < vet.length; i++) {
			this.aleatorio = r.nextInt(ind, vet.length);
			this.sorteada = vet[aleatorio];
		}
		return this.sorteada;
	}

	public int fazerSorteio(int[] vet) {
		for (int i = 0; i < vet.length; i++) {
			this.aleatorio = r.nextInt(10);
			this.sorteadaInt = vet[aleatorio];
		}
		return this.sorteadaInt;
	}

}
