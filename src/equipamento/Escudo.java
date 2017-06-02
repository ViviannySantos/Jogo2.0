/**
 * 
 */
package equipamento;

import Enum.ModeloEquipamento;
import Enum.TipoEquipamento;
import Interfaces.Equipamento;

/**
 * @author ViviannySantos
 *
 */
public class Escudo extends EquipamentoPontos implements Equipamento {

	TipoEquipamento tipoEquipamento = TipoEquipamento.ESCUDO;
	ModeloEquipamento modeloEquipamento = ModeloEquipamento.ESCUDO;

	public Escudo() {
		this.defesa = 15;
		this.ataque = 5;
	}

	@Override
	public void exibirInfo() {
		System.out.println("\n Modelo: Escudo \n Tipo: Escudo" + "\n Ataque:" + getPontoAtaque() + "\n Defesa:"
				+ getPontoDefesa());
	}

	@Override
	public void dados() {

		tipoEquipamento.setCodigo(2);
		modeloEquipamento.setCodigo(4);

		System.out.println("\n Modelo:" + modeloEquipamento.getTipo() + "\n Tipo:" + tipoEquipamento.getTipo()
				+ "\n Ataque:" + getPontoAtaque() + "\n Defesa:" + getPontoDefesa());

	}

	@Override
	public String modeloEquipamento() {
		return modeloEquipamento.getTipo();
	}

}
