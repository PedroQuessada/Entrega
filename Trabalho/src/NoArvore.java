
public class NoArvore {

	private Character elemento;
	private NoArvore direita;
	private NoArvore esquerda;
	
	public NoArvore () {
		elemento = null;
		direita = null;
		esquerda = null;
	}
	
	public NoArvore (Character elemento, NoArvore direita, NoArvore esquerda) {
		this.elemento = elemento;
		this.direita = direita;
		this.esquerda = esquerda;
	}

	public Character getElemento() {
		return elemento;
	}

	public void setElemento(Character elemento) {
		this.elemento = elemento;
	}

	public NoArvore getDireita() {
		return direita;
	}

	public void setDireita(NoArvore direita) {
		this.direita = direita;
	}

	public NoArvore getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NoArvore esquerda) {
		this.esquerda = esquerda;
	}
	
}
