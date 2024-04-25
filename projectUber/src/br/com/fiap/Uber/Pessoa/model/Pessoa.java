package br.com.fiap.Uber.Pessoa.model;

public class Pessoa {

	private String nome;
	private String cpf;
	private String celular;

	public Pessoa() {
		
	}

	public Pessoa(String nome, String cpf, String celular) {
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getCelular() {
		return celular;
	}

	//concatenando os atributos e deixando eles como uma string única em uma posição do 
	//vetor Pessoa para não repetir cpf e ser possível fazer um login mexendo só com o atributo cpf;
	public String[] FazerVetPessoa() {
		StringBuffer sbf = new StringBuffer();
		sbf.append(this.nome);
		sbf.append(',');
		sbf.append(this.cpf);
		sbf.append(',');
		sbf.append(this.celular);
		String[] vetPassageiros = new String[7];
		for (int i = 0; i < vetPassageiros.length; i++) {
			vetPassageiros[i] = sbf.toString();
		}
		return vetPassageiros;
	}

	//separando a string(atributos) que já¡ estão associados a uma posição do vetor Pessoa
	public boolean separandoItensVetPassageiro(String[] ps, String cpfInformado) {
		String[] quebrado = null;
		for (int i = 0; i < 7; i++) {
			quebrado = ps[i].split(",");
		}

		if (cpfInformado.equals(quebrado[1])) {
			return true;
		} else {
			return false;
		}
	}

	public void apresentarUser(int vd, Pessoa[] qb) {
		System.out.println(String.format("\n\tOlá %s!", qb[vd].getNome()));
	}

	@Override
	public String toString() {
		return String.format(
				"\n\tNome......: %s\n\tCPF......: %s\n\tCelular......: %s", getNome(),
				getCpf(), getCelular());
	}
}
