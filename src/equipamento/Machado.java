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
public class Machado extends EquipamentoPontos implements Equipamento {

	TipoEquipamento tipoEquipamento = TipoEquipamento.ARMA;
	ModeloEquipamento modeloEquipamento = ModeloEquipamento.MACHADO;

	public Machado() {
		this.defesa = 10;
		this.ataque = 20;
	}

	@Override
	public void exibirInfo() {
		System.out.println("\nModelo: Machado \n Tipo: Arma \n" + getPontoAtaque() + "\n Defesa:" + getPontoDefesa());
	}

	@Override
	public void dados() {

		tipoEquipamento.setCodigo(1);
		modeloEquipamento.setCodigo(3);

		System.out.println("\n Modelo:" + modeloEquipamento.getTipo() + "\n Tipo:" + tipoEquipamento.getTipo()
				+ "\n Ataque:" + getPontoAtaque() + "\n Defesa:" + getPontoDefesa());

	}

	@Override
	public String modeloEquipamento() {
		return modeloEquipamento.getTipo();
	}

}
