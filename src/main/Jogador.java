package main;

import java.util.Scanner; 

import Enum.ModeloEquipamento;
import Interfaces.Equipamento;
import Interfaces.FabricaDeEquipamento;
import Interfaces.FabricaDePersonagem;
import Interfaces.Personagem;
import criar.DadoPersonagem;
import criar.CriarEquipamentoArma;
import criar.CriarEquipamentoEscudo;
import criar.CriarPersonagemJogavel;
import criar.CriarPersonagemNaoJogavel;

public class Jogador {

	private static Scanner entrada = new Scanner(System.in);

	public static void iniciar() {
		int opcao;
		menu();
		opcao = entrada.nextInt();
		switch (opcao) {
		case 1:
			montarPersonagemJ();
			break;
		case 2:
			montarPersonagemNJ();
			break;
		default:
			System.out.println("Opcao invalida! \n");
			iniciar();
		}
	}

	public static void menu() {

		System.out.println("Bem vindo ao RPG!");
		System.out.println("Menu");
		System.out.println("Criar personagem jogavel - 1");
		System.out.println("Criar personagem não jogavel - 2");

	}

	public static String dadoPersonagem() {
		System.out.println("Nome do personagem");

		String nomePersonagem;
		nomePersonagem = entrada.next();
		DadoPersonagem dado = new DadoPersonagem();
		dado.setNome(nomePersonagem);

		return nomePersonagem;
	}

	/**
	 * Personagem jogavel
	 */
	public static void montarPersonagemJ() {

		dadoPersonagem();

		System.out.println("Escolha uma classe de personagem jogavel");
		System.out.println("Gladiador - 1");
		System.out.println("Cavaleiro - 2");
		System.out.println("Mago - 3");
		
		Integer codClassePersonagem;
		codClassePersonagem = entrada.nextInt();

		FabricaDePersonagem fabricaDePersonagem = new CriarPersonagemJogavel();
		Personagem personagem = fabricaDePersonagem.criarPersonagem(codClassePersonagem);

		try {
			
			personagem.dados();
			System.out.println();
			
			String armaAtaque = escolhaArmaParaPersonagem(personagem.personagem());
			String armaDefesa = escolhaEscudoParaPersonagem(personagem.personagem());
			
			personagem.calcularBonusAtaque(armaAtaque, armaDefesa, personagem.personagem());
			personagem.calcularBonusDefesa(armaAtaque, armaDefesa, personagem.personagem());
		
		} catch (Exception e) {
			System.out.println("Opção invalida!!");
			System.out.println("---------------------------------------------");
			montarPersonagemJ();
		}

		System.out.println("---------------------------------------------");
				
		System.err.println("Click 1 para jogar");
		int play = entrada.nextInt();
		
		if(play == 1){
			
			pre_inicializar(personagem);
			
		} else {
			System.out.println("Tchau");
		}
	}

	/**
	 * Personagem não jogavel
	 */
	public static void montarPersonagemNJ() {

		dadoPersonagem();

		System.out.println("Escolha uma classe de personagem jogavel");
		System.out.println("Vampiro - 4");
		System.out.println("Dragão - 5");
		System.out.println("Lobisomem - 6");

		try {

			Integer codClassePersonagem;
			codClassePersonagem = entrada.nextInt();

			FabricaDePersonagem fabricaDePersonagem = new CriarPersonagemNaoJogavel();
			Personagem personagem = fabricaDePersonagem.criarPersonagem(codClassePersonagem);
			personagem.dados();
			System.out.println();
			
			String armaAtaque = escolhaArmaParaPersonagem(personagem.personagem());
			String armaDefesa = escolhaEscudoParaPersonagem(personagem.personagem());
			
			personagem.calcularBonusAtaque(armaAtaque, armaDefesa, personagem.personagem());
			personagem.calcularBonusAtaque(armaAtaque, armaDefesa, personagem.personagem());


		} catch (Exception e) {
			System.out.println("Opção invalida!!");
			System.out.println("---------------------------------------------");
			montarPersonagemNJ();
		}
		
	}
	
	/**
	 * Escoler tipo de arma para o personagem.
	 * 
	 * @param jogador
	 */
	public static String escolhaArmaParaPersonagem(String jogador) {

		System.out.println("Escolha um arma para o personagem");
		System.out.println("Espada - 1");
		System.out.println("Machado - 2");
		System.out.println("Cajado - 3");

		try {

			Integer codEquipamento;
			codEquipamento = entrada.nextInt();

			FabricaDeEquipamento fabricaDeEquipamento = new CriarEquipamentoArma();
			Equipamento equipamento = fabricaDeEquipamento.criarEquipamento(codEquipamento);
			equipamento.dados();
			System.out.println();
			
			String elemento = equipamento.modeloEquipamento();
			
			return elemento;

			
		} catch (Exception e) {
			System.out.println("Opção invalida!!");
			System.out.println("---------------------------------------------");
			escolhaArmaParaPersonagem(jogador);
		}

		System.out.println("---------------------------------------------");
		
		return null;
		
	}

	/**
	 * Escoler um escudo para o personagem.
	 * 
	 * @param jogador
	 * @return 
	 */
	public static String escolhaEscudoParaPersonagem(String jogador) {

		System.out.println("Escolha um escudo para o personagem");
		System.out.println("Escudo - 4");

		try {

			Integer codEquipamento;
			codEquipamento = entrada.nextInt();

			FabricaDeEquipamento fabricaDeEquipamento = new CriarEquipamentoEscudo();
			Equipamento equipamento = fabricaDeEquipamento.criarEquipamento(codEquipamento);
			equipamento.dados();
			System.out.println();

			String elemento = equipamento.modeloEquipamento();
			
			return elemento;

		} catch (Exception e) {
			System.out.println("Opção invalida!!");
			System.out.println("---------------------------------------------");
			escolhaEscudoParaPersonagem(jogador);
		}

		System.out.println("---------------------------------------------");
		
		return null;
	}

	/**
	 * Antes de inicializar o jogo, criar uma lista de PNJ
	 */
	public static void pre_inicializar(Personagem personagem) {

		FabricaDePersonagem fabricaDePersonagem = new CriarPersonagemNaoJogavel();
		Personagem personagemNJ = null;
		
		for (int i = 1; i <= 2; i++) {

			personagemNJ = fabricaDePersonagem.criarPersonagem(5);
			personagemNJ.exibirInfo();
			System.out.println();
			
			personagemNJ.calcularBonusAtaque(ModeloEquipamento.ESPADA.getTipo(), ModeloEquipamento.ESCUDO.getTipo(), personagemNJ.personagem());			
			personagemNJ.calcularBonusDefesa(ModeloEquipamento.ESPADA.getTipo(), ModeloEquipamento.ESCUDO.getTipo(), personagemNJ.personagem());

		}	

		for (int i = 1; i <= 5; i++) {
			personagemNJ = fabricaDePersonagem.criarPersonagem(4);
			personagemNJ.exibirInfo();
			System.out.println();
			
			personagemNJ.calcularBonusAtaque(ModeloEquipamento.MACHADO.getTipo(), ModeloEquipamento.ESCUDO.getTipo(), personagemNJ.personagem());			
			personagemNJ.calcularBonusDefesa(ModeloEquipamento.MACHADO.getTipo(), ModeloEquipamento.ESCUDO.getTipo(), personagemNJ.personagem());
			
		}

		for (int i = 1; i <= 5; i++) {
			personagemNJ = fabricaDePersonagem.criarPersonagem(4);
			personagemNJ.exibirInfo();
			System.out.println();
			
			personagemNJ.calcularBonusAtaque(ModeloEquipamento.CAJADO.getTipo(), ModeloEquipamento.ESCUDO.getTipo(), personagemNJ.personagem());			
			personagemNJ.calcularBonusDefesa(ModeloEquipamento.CAJADO.getTipo(), ModeloEquipamento.ESCUDO.getTipo(), personagemNJ.personagem());
			
		}
			
		for (int i = 1; i <= 5; i++) {
			personagemNJ = fabricaDePersonagem.criarPersonagem(6);
			personagemNJ.exibirInfo();
			System.out.println();
			
			personagemNJ.calcularBonusAtaque(ModeloEquipamento.MACHADO.getTipo(), ModeloEquipamento.ESCUDO.getTipo(), personagemNJ.personagem());			
			personagemNJ.calcularBonusDefesa(ModeloEquipamento.MACHADO.getTipo(), ModeloEquipamento.ESCUDO.getTipo(), personagemNJ.personagem());
		}

		for (int i = 1; i <= 5; i++) {
			personagemNJ = fabricaDePersonagem.criarPersonagem(6);
			personagemNJ.exibirInfo();
			System.out.println();
		
			personagemNJ.calcularBonusAtaque(ModeloEquipamento.ESPADA.getTipo(), ModeloEquipamento.ESCUDO.getTipo(), personagemNJ.personagem());			
			personagemNJ.calcularBonusDefesa(ModeloEquipamento.ESPADA.getTipo(), ModeloEquipamento.ESCUDO.getTipo(), personagemNJ.personagem());
		}
		
		for (int i = 1; i <= 5; i++) {
			personagemNJ = fabricaDePersonagem.criarPersonagem(6);
			personagemNJ.exibirInfo();
			System.out.println();
		
			personagemNJ.calcularBonusAtaque(ModeloEquipamento.CAJADO.getTipo(), ModeloEquipamento.ESCUDO.getTipo(), personagemNJ.personagem());			
			personagemNJ.calcularBonusDefesa(ModeloEquipamento.CAJADO.getTipo(), ModeloEquipamento.ESCUDO.getTipo(), personagemNJ.personagem());
		}
		
		for (int i = 1; i <= 2; i++) {
			personagemNJ = fabricaDePersonagem.criarPersonagem(4);
			personagemNJ.dados();
			System.out.println();
			
			personagemNJ.calcularBonusAtaque(ModeloEquipamento.ESPADA.getTipo(), ModeloEquipamento.ESCUDO.getTipo(), personagemNJ.personagem());
			personagemNJ.calcularBonusDefesa(ModeloEquipamento.ESPADA.getTipo(), ModeloEquipamento.ESCUDO.getTipo(), personagemNJ.personagem());
			
		}
		
		
	}
	
	public static void combate(Personagem personagemJ, Personagem personagemNJ){
		
		System.err.println("\n" + "---------------------------------------------");
		
		personagemJ.tiraVida(personagemJ.vida(), personagemJ.defesa(), personagemNJ.ataque());	
	}

}
