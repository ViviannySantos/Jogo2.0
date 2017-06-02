/**
 * 
 */
package Enum;

/**
 * @author ViviannySantos
 *
 */
public enum TipoPersonagem {

	JOGAVEL(1, "Jogavel"), NAO_JOGAVEL(2, "Não jogavel");

	private Integer codigo;
	private String tipo;

	/**
	 * Construtor.
	 *
	 * @param codigo
	 * @param descricao
	 */
	private TipoPersonagem(Integer codigo, String tipo) {
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
