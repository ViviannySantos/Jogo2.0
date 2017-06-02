/**
 * 
 */
package Interfaces;

/**
 * @author ViviannySantos
 *
 */
public interface Personagem {

	void dados();
	float vida();
	int ataque();
	int defesa();
	void exibirInfo();
	String personagem();
	void tiraVida(float vida, int defesaJ, int ataqueNJ);
	void regeneraVida(float vidaJ, float vidaNj);
	void calcularBonusDefesa(String armaAtaque, String armaDefesa,String personagem);
	void calcularBonusAtaque(String armaAtaque, String armaDefesa,String personagem);
	int poderAtaque(String armaAtaque,String armaDefesa, int bonusAtaqueArma, int bonusAtaqueEscudo);
	int poderDefesa(String armaAtaque,String armaDefesa, int bonusDefesaArma, int bonusDefesaEscudo);
}
