package criar;

import Enum.TipoClassePersonagem; 
import Enum.TipoPersonagem;
import Interfaces.FabricaDePersonagem;
import Interfaces.Personagem;
import classePersonagem.Cavaleiro;
import classePersonagem.Gladiador;
import classePersonagem.Mago;

/**
 * @author ViviannySantos
 *
 */
public class CriarPersonagemJogavel implements FabricaDePersonagem {

	@Override
	public Personagem criarPersonagem(Integer codClassePersonagem) {

		if (TipoPersonagem.JOGAVEL != null) {
			if (codClassePersonagem == TipoClassePersonagem.GLADIADOR.getCodigo()) {
				return new Gladiador();
			}
			if (codClassePersonagem == TipoClassePersonagem.CAVALEIRO.getCodigo()) {
				return new Cavaleiro();
			}
			if (codClassePersonagem == TipoClassePersonagem.MAGO.getCodigo()) {
				return new Mago();
			} else {
				throw new NullPointerException("Não existe essa opção!");
			}
		}

		return null;
	}

}
