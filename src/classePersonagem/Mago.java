package classePersonagem;

import Enum.ModeloEquipamento;
import Enum.TipoClassePersonagem;
import Enum.TipoPersonagem;
import Interfaces.Personagem;
import criar.DadoPersonagem;
import equipamento.Cajado;
import equipamento.Escudo;
import equipamento.Espada;
import equipamento.Machado;

public class Mago implements Personagem {

	TipoPersonagem tipoPersonagem = TipoPersonagem.NAO_JOGAVEL;
	TipoClassePersonagem tipoClassePersonagem = TipoClassePersonagem.MAGO;
	DadoPersonagem dados = new DadoPersonagem();
	
	int totalDefesa;
	int totalAtaque;

	@Override
	public void exibirInfo() {
		System.out.println("\n Personagem:" + tipoPersonagem.getTipo() + "\n Classe:" + tipoClassePersonagem.getTipo());
	}

	@Override
	public void dados() {

		tipoPersonagem.setCodigo(2);
		tipoClassePersonagem.setCodigo(3);
		dados.setVida(200);
		dados.setAtaquePersonagem(20);
		dados.setDefesaPersonagem(20);

		System.out.println("\n Personagem:" + tipoPersonagem.getTipo() + "\n Classe:" + tipoClassePersonagem.getTipo());
		System.out.println("\n Vida(s):" + dados.getVida());
		System.out.println("\n Ataque:" + dados.getAtaquePersonagem());
		System.out.println("\n Defesa:" + dados.getDefesaPersonagem());

	}

	@Override
	public String personagem() {
		return tipoClassePersonagem.getTipo();
	}

	@Override
	public void calcularBonusAtaque(String armaAtaque, String armaDefesa, String personagem) {
		
		int bonusAtaqueArma = 0;
		int bonusAtaqueEscudo = 0;
		
		if(personagem.equals(TipoClassePersonagem.MAGO.getTipo())){
			
			System.out.println("-------B�nus de ataque do mago-------");
			if(armaAtaque.equals(ModeloEquipamento.MACHADO.getTipo())){
					
				bonusAtaqueArma = 0;
				System.out.println("B�nus de ataque: " + bonusAtaqueArma);
				
			} else if(armaAtaque.equals(ModeloEquipamento.ESPADA.getTipo())){
				
				bonusAtaqueArma = 5;
				System.out.println("B�nus de ataque: " + bonusAtaqueArma);

			} else if(armaAtaque.equals(ModeloEquipamento.CAJADO.getTipo())){
				bonusAtaqueArma = 45;
				System.out.println("B�nus de ataque: " + bonusAtaqueArma);
				
			}
			
			if (armaDefesa.equals(ModeloEquipamento.ESCUDO.getTipo())) {

				bonusAtaqueEscudo = 5;
				System.out.println("B�nus de ataque: " + bonusAtaqueEscudo);

			}
			
			poderAtaque(armaAtaque, armaDefesa, bonusAtaqueArma, bonusAtaqueEscudo);
		}
		
	}

	@Override
	public void calcularBonusDefesa(String armaAtaque, String armaDefesa, String personagem) {
		
		int bonusDefesaArma = 0;
		int bonusDefesaEscudo = 0;
		
		if(personagem.equals(TipoClassePersonagem.MAGO.getTipo())){
			
			System.out.println("-------B�nus de defesa do mago-------");
			if(armaAtaque.equals(ModeloEquipamento.MACHADO.getTipo())){

				bonusDefesaArma = 0;
				System.out.println("B�nus de defesa: " + bonusDefesaArma);
				
			} else if(armaAtaque.equals(ModeloEquipamento.ESPADA.getTipo())){
				
				bonusDefesaArma = 5;
				System.out.println("B�nus de defesa: " + bonusDefesaArma);

			} else {
				
				bonusDefesaArma = 25;
				System.out.println("B�nus de defesa: " + bonusDefesaArma);
				
			}
			
			if (armaDefesa.equals(ModeloEquipamento.ESCUDO.getTipo())) {

				bonusDefesaEscudo = 10;
				System.out.println("B�nus de defesa: " + bonusDefesaEscudo);

			}
			
			poderDefesa(armaAtaque, armaDefesa, bonusDefesaArma, bonusDefesaEscudo);
		}
		
	}
		
	@Override
	public int poderAtaque(String armaAtaque, String armaDefesa, int bonusAtaqueArma, int bonusAtaqueEscudo){
		  
		  int ataqueArma = 0;
		  int ataqueEscudo = 0;
		 		      
		  System.out.println("---------------------------------------------");
		  
		  if(armaAtaque.equals(ModeloEquipamento.MACHADO.getTipo())){
		    
		    Machado arma = new Machado();
		          
		    if(dados.getAtaquePersonagem() != 0){
		      ataqueArma = (arma.getPontoAtaque() + bonusAtaqueArma);
		      System.out.println("Total de ataque da machado:" + ataqueArma);
		    }
		  } else if(armaAtaque.equals(ModeloEquipamento.ESPADA.getTipo())){
		    
		    Espada arma = new Espada();
		    
		    if(dados.getAtaquePersonagem() != 0){
		      ataqueArma = (arma.getPontoAtaque() + bonusAtaqueArma);
		      System.out.println("Total de ataque da espada:" + ataqueArma);
		    }
		  } else {
		    
		    Cajado arma = new Cajado();
		    
		    if(dados.getAtaquePersonagem() != 0){
		      ataqueArma = (arma.getPontoAtaque() + bonusAtaqueArma);
		      System.out.println("Total de ataque do cajado:" + ataqueArma);
		    }
		  }
		  
		  if (armaDefesa.equals(ModeloEquipamento.ESCUDO.getTipo())) {
		    
		    Escudo arma = new Escudo();
		            
		    if(dados.getAtaquePersonagem() != 0){
		      ataqueEscudo = (arma.getPontoAtaque() + bonusAtaqueEscudo);
		      System.out.println("Total de ataque da escudo:" + ataqueEscudo);
		      
		    }
		  }

		  totalAtaque = ataqueArma + ataqueEscudo + dados.getAtaquePersonagem();
		  
		  System.out.println("------------Poder total de ataque---------------");
		  System.out.println("Ataque total:" + totalAtaque);
		  
		  return totalAtaque;

	}
	
	@Override
	public int poderDefesa(String armaAtaque, String armaDefesa, int bonusDefesaArma, int bonusDefesaEscudo){

		int defesaArma = 0;
		int defesaEscudo = 0;
						
		System.out.println("---------------------------------------------");
		
		if(armaAtaque.equals(ModeloEquipamento.MACHADO.getTipo())){
			
			Machado arma = new Machado();

			if(dados.getDefesaPersonagem() != 0){
				defesaArma = (arma.getPontoDefesa() + bonusDefesaArma);
				System.out.println("Totoal de defesa da machado:" + defesaArma + "\n");
			}
		} else if(armaAtaque.equals(ModeloEquipamento.ESPADA.getTipo())){
			
			Espada arma = new Espada();

			if(dados.getDefesaPersonagem() != 0){
				defesaArma = (arma.getPontoDefesa() + bonusDefesaArma);
				System.out.println("Totoal de defesa da espada:" + defesaArma + "\n");
			}
		} else {
			
			Cajado arma = new Cajado();

			if(dados.getDefesaPersonagem() != 0){
				defesaArma = (arma.getPontoDefesa() + bonusDefesaArma);
				System.out.println("Totoal de defesa do cajado:" + defesaArma + "\n");
			}
		}
		
		if (armaDefesa.equals(ModeloEquipamento.ESCUDO.getTipo())) {
			
			Escudo arma = new Escudo();
			
			if(dados.getDefesaPersonagem() != 0){
				defesaEscudo = (arma.getPontoDefesa() + bonusDefesaEscudo);
				System.out.println("Total de defesa da escudo:" + defesaEscudo + "\n");
				
			}
		}
	
		totalDefesa = defesaArma + defesaEscudo + dados.getDefesaPersonagem();
		
		System.out.println("------------Poder total de defesa---------------");
		System.out.print("Defesa total:" + totalDefesa + "\n");
		
		return totalDefesa;

	}
	
	@Override
	public float vida() {

		return dados.getVida();		

	}

	@Override
	public int ataque() {
		
		return totalDefesa;
	}

	@Override
	public int defesa() {
		
		return totalDefesa;
	}

	@Override
	public void tiraVida(float vida, int defesaJ, int ataqueNJ) {
		
		float atacado = (vida + defesaJ) - ataqueNJ;
		
		System.out.println("Vida depois do ataque:" + atacado); 
		
	}
	
	@Override
	public void regeneraVida(float vidaJ, float vidaNj) {
		
		float regenerado = (float) (vidaJ + (vidaNj*0.30)); 
		
		System.out.println("Vida regenerada:" + regenerado);
		
	}

}
