package br.com.fiap.Uber.Veiculo.model;

import br.com.fiap.Uber.Pessoa.model.Motorista;

public class Veiculo {

	private String placa;
	private String modelo;
	private String montadora;
	private int ano;
	private Motorista motorista;

	public Veiculo() {

	}

	public String getPlaca() {
		return placa;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMontadora() {
		return montadora;
	}

	public int getAno() {
		return ano;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void gerarVeiculo() {
		DadosCarro carro = new DadosCarro();
		this.placa = carro.placaAleatoria();
		this.modelo = carro.modeloAleatorio();
		this.montadora = carro.montadorasAleatorio();
		this.ano = carro.anoFabricacaoAleatorio();
		// Adicionando um motorista a um veículo;
		motorista = new Motorista();
		motorista.gerandoMotorista();
	}

	@Override
	public String toString() {
		return String.format(
				"\n\tModelo......: %s\n\tPlaca......: %s\n\tMontadora......: %s\n\tAno Fabricação......: %d\n\n>>>>>>> MOTORISTA <<<<<<<<%s",
				getModelo(), getPlaca(), getMontadora(), getAno(), getMotorista());
	}
}
