package br.com.fiap.Uber.Main.app;

/**
 * @author Eduardo Henriques Bertelli --------  RM:92966
 * @author Fabiano Luiz Santos de Sanatana ---- RM:96044
 * @author Fernando Igino Machado ------------- RM:94712
 * @author Gustavo Crosera Lobo --------------- RM:93202
 * @author Lucas Aguido Mazzeto --------------- RM:93303
 */

import java.util.Scanner;
//import br.com.fiap.Uber.FuncoesAux.model.FuncaoGravar;
import br.com.fiap.Uber.Pessoa.model.DadosPessoa;
import br.com.fiap.Uber.Pessoa.model.Pessoa;
import br.com.fiap.Uber.Veiculo.model.Veiculo;
import br.com.fiap.Uber.Viagem.model.Viagem;

public class AplicacaoUber {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int i;
		int opcao;
		String cpf;
		Pessoa[] pessoa = new Pessoa[7];
		Veiculo[] veiculo = new Veiculo[7];
		Viagem viagem = null;
		boolean validar[] = new boolean[7];

		// login feito por cpf;
		// ........... 7 cpfs cadastrados:................
		// 001.345.677-99, 002.445.678-89, 003.555.679-79, 004.665.680-69,
		// 005.775.681-59, 006.885.682-49, 007.995.683-39;
		do {
			System.out.println("\nDIGITE:" + "\n\t<0>: PARA FAZER LOGIN;" + "\n\t<1>: PARA ENCERRAR");
			opcao = teclado.nextInt();

			switch (opcao) {
			case 0:

				teclado.nextLine();
				System.out.println("\nInforme seu CPF:");
				cpf = teclado.nextLine();
				DadosPessoa cp = new DadosPessoa();

				for (i = 0; i < pessoa.length; i++) {
					pessoa[i] = new Pessoa(cp.nomeAleatorio()[i], cp.cpfAleatorio()[i], cp.telefoneAleatorio()[i]);
					String[] vetPassageiro = pessoa[i].FazerVetPessoa();
					validar[i] = pessoa[i].separandoItensVetPassageiro(vetPassageiro, cpf);
				}
				for (i = 0; i < pessoa.length; i++) {
					if (validar[i]) {
						int in = i;
						pessoa[i].apresentarUser(in, pessoa);
						String origem, destino;
						do {
							System.out.println("\nDIGITE:" + "\n\t<2>: PARA SOLICITAR VIAGEM;"
									+ "\n\t<3>: PARA VOLTAR PARA MENU INICIAL");
							opcao = teclado.nextInt();

							switch (opcao) {
							case 2:

								teclado.nextLine();
								System.out.println("\nInforme seu local de partida: ");
								origem = teclado.nextLine();
								System.out.println("\nInforme seu destino:");
								destino = teclado.nextLine();

								for (i = 0; i < veiculo.length; i++) {
									veiculo[i] = new Veiculo();
									veiculo[i].gerarVeiculo();
									Pessoa pessoaLogin = pessoa[in];
									viagem = new Viagem(origem, destino, pessoaLogin, veiculo[i]);
								}
								System.out.println(viagem.toString());
//								FuncaoGravar gravando = new FuncaoGravar();
//								String caminho = ""
//								gravando.gravandoViagens(caminho, viagem);
								break;
							case 3:
								System.out.println("\n\tVOLTANDO PARA TELA INICIAL");
								break;
							default:
								System.out.println("\nOPÇÃOO INVÁLIDA!");
								break;

							}

						} while (opcao != 2 && opcao != 3);

					}
				}
				for (i = 0; i < 1; i++) {
					if (!validar[i] && opcao == 0)

						System.out.println("\nUSUÁRIO NÃO ENCONTRADO");
				}
				break;
			case 1:
				System.out.println("FIM DA EXECUÇÃO!");
				break;
			default:
				System.out.println("\nOPÇÃO INVÁLIDA");
				break;
			}
		} while (opcao != 1);

		teclado.close();
	}
}
