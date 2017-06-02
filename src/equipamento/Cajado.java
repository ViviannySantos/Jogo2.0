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
public class Cajado extends EquipamentoPontos implements Equipamento {

	TipoEquipamento tipoEquipamento = TipoEquipamento.ARMA;
	ModeloEquipamento modeloEquipamento = ModeloEquipamento.CAJADO;

	public Cajado() {
		this.defesa = 5;
		this.ataque = 15;
	}

	@Override
	public void exibirInfo() {
		System.out.println(
				"\n Modelo: Cachado \n Tipo: Arma" + "\n Ataque:" + getPontoAtaque() + "\n Defesa:" + getPontoDefesa());
	}

	@Override
	public void dados() {

		tipoEquipamento.setCodigo(1);
		modeloEquipamento.setCodigo(2);

		System.out.println("\n Modelo:" + modeloEquipamento.getTipo() + "\n Tipo:" + tipoEquipamento.getTipo()
				+ "\n Ataque:" + getPontoAtaque() + "\n Defesa:" + getPontoDefesa());

	}

	public String modeloEquipamento() {
		return modeloEquipamento.getTipo();
	}

}
