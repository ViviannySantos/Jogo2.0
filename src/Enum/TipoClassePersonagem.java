package Enum;

public enum TipoClassePersonagem {

	GLADIADOR(1, "Gladiador"), CAVALEIRO(2, "Cavaleiro"), MAGO(3, "Mago"), VAMPIRO(4, "Vampiro"), DRAGAO(5,
			"Dragão"), LOBISOMEM(6, "Lobisomem");

	private Integer codigo;
	private String tipo;

	/**
	 * Construtor.
	 *
	 * @param codigo
	 * @param tipo
	 */
	private TipoClassePersonagem(Integer codigo, String tipo) {
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
