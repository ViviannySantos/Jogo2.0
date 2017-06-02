/**
 * 
 */
package criar;

import Enum.ModeloEquipamento;
import Enum.TipoEquipamento;
import Interfaces.Equipamento;
import Interfaces.FabricaDeEquipamento;
import equipamento.Cajado;
import equipamento.Espada;
import equipamento.Machado;

/**
 * @author ViviannySantos
 *
 */
public class CriarEquipamentoArma implements FabricaDeEquipamento {

	@Override
	public Equipamento criarEquipamento(Integer codEquipamento) {

		try {
			if (TipoEquipamento.ARMA != null) {
				if (codEquipamento == ModeloEquipamento.ESPADA.getCodigo()) {
					return new Espada();
				}
				if (codEquipamento == ModeloEquipamento.MACHADO.getCodigo()) {
					return new Machado();
				}
				if (codEquipamento == ModeloEquipamento.CAJADO.getCodigo()) {
					return new Cajado();
				}
			}
		} catch (NullPointerException e) {
			throw new NullPointerException("Não existe essa opção!");
		}

		return null;

	}

}
