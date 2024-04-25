package br.com.fiap.Uber.Veiculo.model;

import br.com.fiap.Uber.FuncoesAux.model.FuncoesSorteio;

public class DadosCarro {

	public DadosCarro() {

	}

	FuncoesSorteio funcao = new FuncoesSorteio();

	public String placaAleatoria() {
		String[] placas = { "ABC 4567", "XYZ 1234", "QWE 7890", "JKZ 2468", "LMN 1357", "PQR 9012", "FGH 3456",
				"RST 6789", "NOP 2345", "UVW 7890", "AAA 1111", "BBB 2222", "CCC 3333", "DDD 4444", "EEE 5555",
				"MMM 7777", "NNN 8888", "OOO 9999", "PPP 0000", "QQQ 1234", "BBB 6543", "CCC 0987", "DDD 3210",
				"EEE 7654", "FFF 4321", "ABC-1234", "DEF-5678", "GHI-9012", "JKL-3456", "MNO-7890", "PQR-2345",
				"STU-6789", "VWX-0123", "YZA-4567", "BCD-8901", "EFG-2345", "HIJ-6789", "KLM-0123", "NOP-4567",
				"QRS-8901", "TUV-2345", "WXY-6789", "ZAB-0123", "CDE-4567", "FGH-8901" };
		return funcao.fazerSorteio(placas);

	}

	public String modeloAleatorio() {
		String[] modelos = { "Eclipse", "Mustang", "Camaro", "Challenger", "GTO", "Ferrari", "Lamborghini", "Bugatti",
				"McLaren", "Pagani", "Corvette", "Viper", "GT-R", "NSX", "Supra", "Civic", "Impreza", "Lancer", "RSX",
				"Celica", "Polo", "Golf", "Passat", "Scirocco", "Jetta", "Aurora", "Firebird", "Monte Carlo",
				"Chevelle", "Impala", "Cheetah", "Pantera", "Veyron", "Zonda", "Agera", "Integra", "Silvia",
				"Civic Type R", "BRZ", "Supra", "Opala", "Maverick", "Galaxie", "F-100", "Fusion", "Nimbus", "Meteor",
				"Comet", "Cosmic", "Galaxy" };
		return funcao.fazerSorteio(modelos);

	}

	public String montadorasAleatorio() {
		String[] montadoras = { "Chevrolet", "Ford", "Fiat", "Honda", "Volkswagen", "Toyota", "Nissan", "Hyundai",
				"Kia", "Jeep", "Dodge", "Ram", "GMC", "Buick", "Cadillac", "Chrysler", "Acura", "Mitsubishi", "Subaru",
				"Mazda", "Mercedes-Benz", "BMW", "Audi", "Volvo", "Porsche", "Renault", "Peugeot", "Citroën", "Ferrari",
				"Lamborghini", "Alfa Romeo", "Maserati", "Jaguar", "Land Rover", "Mini", "Suzuki", "Mitsubishi",
				"Lexus", "Infiniti", "Acura", "Hyundai", "Kia", "Genesis", "Bentley", "Rolls-Royce", "Tesla", "Fisker",
				"Lucid", "Rivian", "Faraday Future", };
		return funcao.fazerSorteio(montadoras);
	}

	public int anoFabricacaoAleatorio() {
		int[] anos = { 1985, 1992, 1998, 2004, 2011, 2016, 2022, 1989, 2000, 2008, 2015, 2019, 2026, 1995, 2001, 2010,
				2018, 2023, 1995, 1986, 1993, 2005, 2012, 2017, 2024, 1967, 1990, 1999, 2009, 2014, 2020, 2003, 1987,
				1996, 2002, 2013, 2021, 1977, 1988, 1994, 2006, 2016, 2025, 1979 };
		return funcao.fazerSorteio(anos);
	}

}
