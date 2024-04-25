package br.com.fiap.Uber.FuncoesAux.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import br.com.fiap.Uber.Viagem.model.Viagem;

public class FuncaoGravar {

public void gravandoViagens(String caminho, Viagem viagemRealizada) {
		
		try {
			File arquivo = new File(caminho);
			FileOutputStream output = new FileOutputStream(arquivo, true);
			OutputStreamWriter writer = new OutputStreamWriter(output);
			writer.write(viagemRealizada.toString());
			writer.write("\n");
			writer.write("--------------------------");
			writer.write("--------------------------");
			writer.write("\n");
			writer.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
