/**
 * 
 */
package criar;

import Enum.TipoClassePersonagem;
import Enum.TipoPersonagem;
import Interfaces.FabricaDePersonagem;
import Interfaces.Personagem;
import classePersonagem.Dragao;
import classePersonagem.Lobisomem;
import classePersonagem.Vampiro;

/**
 * @author ViviannySantos
 *
 */
public class CriarPersonagemNaoJogavel implements FabricaDePersonagem {

	@Override
	public Personagem criarPersonagem(Integer codClassePersonagem) {

		if (TipoPersonagem.NAO_JOGAVEL != null) {
			if (codClassePersonagem == TipoClassePersonagem.VAMPIRO.getCodigo()) {
				return new Vampiro();
			}
			if (codClassePersonagem == TipoClassePersonagem.DRAGAO.getCodigo()) {
				return new Dragao();
			}
			if (codClassePersonagem == TipoClassePersonagem.LOBISOMEM.getCodigo()) {
				return new Lobisomem();
			} else {
				throw new NullPointerException("Não existe essa opção!");
			}
		}

		return null;
	}

}
