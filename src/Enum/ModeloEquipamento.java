/**
 * 
 */
package Enum;

/**
 * @author ViviannySantos
 *
 */
public enum ModeloEquipamento {

	ESPADA(1, "Espada"), MACHADO(2, "Machado"), CAJADO(3, "Cajado"), ESCUDO(4, "Escudo");

	private Integer codigo;
	private String tipo;

	/**
	 * Construtor.
	 *
	 * @param codigo
	 * @param tipo
	 */
	private ModeloEquipamento(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}

	/* Gets and Sets */
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
