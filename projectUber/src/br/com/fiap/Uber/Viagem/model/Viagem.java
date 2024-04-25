package br.com.fiap.Uber.Viagem.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import br.com.fiap.Uber.Pessoa.model.Pessoa;
import br.com.fiap.Uber.Veiculo.model.Veiculo;

public class Viagem {

	private String data;
	private double valor;
	private String origem;
	private String destino;
	private Pessoa passageiro;
	private Veiculo carro;

	public Viagem() {

	}

	public Viagem(String origem, String destino, Pessoa passageiro, Veiculo carro) {
		this.data = setandoData();
		this.origem = origem;
		this.destino = destino;
		this.passageiro = passageiro;
		this.carro = carro;
		this.valor = calculaPreco();
	}

	public String getData() {
		return data;
	}

	public double getValor() {
		return valor;
	}

	public String getOrigem() {
		return origem;
	}

	public String getDestino() {
		return destino;
	}

	public Pessoa getPassageiro() {
		return passageiro;
	}

	public Veiculo getCarro() {
		return carro;
	}

	public double calculaPreco() {
		Random r = new Random();
		double tarifa = r.nextDouble(15.0, 100.0) + 1.0;
		return tarifa;
	}

	public String setandoData() {
		LocalDate dataAtual = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dataAtual.format(formato);
	}
	

	@Override
	public String toString() {
		return String.format(
				"\n>>>>>>> PASSAGEIRO <<<<<<<<\n %s \n\n>>>>>>> VIAGEM <<<<<<<<\n \n\tOrigem:......: %s\n\tDestino......: %s\n\tPreço......: R$%f\n\tData:......:%s \n\n>>>>>>> VEÍCULO <<<<<<<<\n\t%s",
				getPassageiro(), getOrigem(), getDestino(), getValor(), setandoData(), getCarro());
	}

}
