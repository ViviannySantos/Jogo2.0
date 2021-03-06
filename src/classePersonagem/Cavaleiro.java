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

public class Cavaleiro implements Personagem {

	TipoPersonagem tipoPersonagem = TipoPersonagem.JOGAVEL;
	TipoClassePersonagem tipoClassePersonagem = TipoClassePersonagem.CAVALEIRO;
	DadoPersonagem dados = new DadoPersonagem();
	
	int defesaTotal;
	int ataqueTotal;

	@Override
	public void exibirInfo() {
		System.out.println("\n Personagem:" + tipoPersonagem.getTipo() + "\n Classe:" + tipoClassePersonagem.getTipo());
	}

	@Override
	public void dados() {

		tipoPersonagem.setCodigo(1);
		tipoClassePersonagem.setCodigo(2);
		dados.setVida(200);
		dados.setAtaquePersonagem(15);
		dados.setDefesaPersonagem(10);
	
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
		
		if(personagem.equals(TipoClassePersonagem.CAVALEIRO.getTipo())){
			
			System.out.println("-------B�nus de ataque do cavaleiro-------");
			if(armaAtaque.equals(ModeloEquipamento.MACHADO.getTipo())){
					
				bonusAtaqueArma = 25;
				System.out.println("B�nus de ataque: " + bonusAtaqueArma);
				
			} else if(armaAtaque.equals(ModeloEquipamento.ESPADA.getTipo())){
				
				bonusAtaqueArma = 55;
				System.out.println("B�nus de ataque: " + bonusAtaqueArma);

			} else if(armaAtaque.equals(ModeloEquipamento.CAJADO.getTipo())){
				bonusAtaqueArma = 0;
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
		
		if(personagem.equals(TipoClassePersonagem.CAVALEIRO.getTipo())){
			
			System.out.println("-------B�nus de defesa do cavaleiro-------");
			if(armaAtaque.equals(ModeloEquipamento.MACHADO.getTipo())){

				bonusDefesaArma = 10;
				System.out.println("B�nus de defesa: " + bonusDefesaArma);
				
			} else if(armaAtaque.equals(ModeloEquipamento.ESPADA.getTipo())){
				
				bonusDefesaArma = 25;
				System.out.println("B�nus de defesa: " + bonusDefesaArma);

			} else {
				
				bonusDefesaArma = 0;
				System.out.println("B�nus de defesa: " + bonusDefesaArma);
				
			}
			
			if (armaDefesa.equals(ModeloEquipamento.ESCUDO.getTipo())) {

				bonusDefesaEscudo = 15;
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

		  ataqueTotal = ataqueArma + ataqueEscudo + dados.getAtaquePersonagem();
		  
		  dados.setTotalAtaque(ataqueTotal);
		  
		  System.out.println("------------Poder total de ataque---------------");
		  System.out.println("Ataque total:" + dados.getTotalAtaque());
		  
		  return dados.getTotalAtaque();

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
	
		defesaTotal = defesaArma + defesaEscudo + dados.getDefesaPersonagem();
		
		dados.setTotalDefesa(defesaTotal);
		
		System.out.println("------------Poder total de defesa---------------");
		System.out.print("Defesa total:" + dados.getTotalDefesa() + "\n");
		
		return dados.getTotalDefesa();

	}

	@Override
	public float vida(){
		
		System.out.println("Vida atual:" + dados.getVida());
		
		return dados.getVida();
	}
	
	@Override
	public int ataque(){
		
		return dados.getTotalAtaque();
	}
	
	@Override
	public int defesa(){
		
		return dados.getTotalDefesa();
	}
	
	@Override
	public void tiraVida(float vida, int defesaJ, int ataqueNJ){
		
		float atacado = (vida + defesaJ) - ataqueNJ;
		
		System.out.println("Vida depois do ataque:" + atacado); 
		
	}
		
	public void regeneraVida(float vidaJ, float vidaNj){
		
		float regenerado = (float) (vidaJ + (vidaNj*0.30)); 
		
		System.out.println("Vida regenerada:" + regenerado);
		
	}

}
