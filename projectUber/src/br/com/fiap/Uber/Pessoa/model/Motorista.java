package br.com.fiap.Uber.Pessoa.model;

import br.com.fiap.Uber.FuncoesAux.model.FuncoesSorteio;

public class Motorista {

	private Pessoa motorista;
	private String habilitacao;
	private String categoria;

	public Motorista() {

	}

	public Pessoa getMotorista() {
		return motorista;
	}

	public String getHabilitacao() {
		return habilitacao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void gerandoMotorista() {
		DadosPessoa cp = new DadosPessoa();
		FuncoesSorteio funcao = new FuncoesSorteio();
		//motorista é uma pessoa
		this.motorista = new Pessoa(funcao.fazerSorteio(cp.nomeAleatorio(), 30), funcao.fazerSorteio(cp.cpfAleatorio(), 30),
				funcao.fazerSorteio(cp.telefoneAleatorio(), 30));
		this.habilitacao = funcao.fazerSorteio(cnhAleatoria());
		this.categoria = "B";
	}

	@Override
	public String toString() {
		return String.format("\n\t %s\n\tCNH......: %s\n\tCategoria......: %s", getMotorista(), getHabilitacao(),
				getCategoria());
	}

	private String[] cnhAleatoria() {
		String[] cnhs = { "87405996050", "28567266616", "54107324858", "11499664470", "77347826651", "15539806396",
				"28858721100", "94772678320", "19941525970", "02598337822", "62753293144", "35217432859", "01628762420",
				"49026700110", "58217240411", "63412210122", "52649281095", "35042246809", "36837618394", "31042950230",
				"1234567890", "2345678901", "3456789012", "4567890123", "5678901234", "6789012345", "7890123456",
				"8901234567", "9012345678", "0123456789", "9876543210", "8765432109", "7654321098", "6543210987",
				"5432109876", "4321098765", "3210987654", "2109876543", "1098765432", "0987654321" };
		return cnhs;
	}

}
