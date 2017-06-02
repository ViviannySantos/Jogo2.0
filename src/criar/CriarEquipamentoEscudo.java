package criar;

import Enum.ModeloEquipamento;
import Enum.TipoEquipamento;
import Interfaces.Equipamento;
import Interfaces.FabricaDeEquipamento;
import equipamento.Escudo;

public class CriarEquipamentoEscudo implements FabricaDeEquipamento {

	@Override
	public Equipamento criarEquipamento(Integer codEquipamento) {

		try {
			if (TipoEquipamento.ESCUDO != null) {
				if (codEquipamento == ModeloEquipamento.ESCUDO.getCodigo()) {
					return new Escudo();
				}
			}
		} catch (NullPointerException e) {
			throw new NullPointerException("Não existe essa opção!");
		}

		return null;

	}
}
