
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Metodos {

	private NoArvore noRaiz;
	private int tamanho;
	private String mensagem, titulo;
	private ArrayList<Integer> vetor = new ArrayList<Integer>();
	
	public Metodos() {
		noRaiz = null;
		tamanho = 0;
	}
	
	public void create() {
		
		Character elemento;
		mensagem = "Digite o caracter que você deseja inserir";
		titulo = "Arvore Binária";
		
		elemento = JOptionPane.showInputDialog(null, mensagem, titulo ,JOptionPane.QUESTION_MESSAGE).charAt(0);
		
		NoArvore novoNo = new NoArvore(elemento, null, null);
		if(isEmpty()) noRaiz = novoNo;
		else inserirFolha(noRaiz, novoNo);
		tamanho++;
	}
	
	public void inserirFolha(NoArvore noAnterior, NoArvore novoNo) {
		
		NoArvore noAux;
		
		if(novoNo.getElemento() <= noAnterior.getElemento()) {
			noAux = noAnterior.getEsquerda();
			if(noAux != null) inserirFolha(noAux, novoNo);
			else noAnterior.setEsquerda(novoNo);
		}
		else {
			noAux = noAnterior.getDireita();
			if(noAux != null) inserirFolha(noAux, novoNo);
			else noAnterior.setDireita(novoNo);
		}
	}
	
	public boolean buscarElemento(Character elemento, NoArvore no) {
		if(no != null) {
			if(elemento == no.getElemento()) return true;
			else {
				if(elemento < no.getElemento()) {
					if(buscarElemento(elemento, no.getEsquerda())) return true;
				}
				else {
					if(buscarElemento(elemento, no.getDireita())) return true;
				}
			}
		}
		return false;
	}
	
	public NoArvore deleteNo(Character elemento, NoArvore no) {
		NoArvore noAux;
		
		if(no != null) {
			if(no.getElemento() == elemento) {
				if(no.getEsquerda() == no.getDireita()) return null;
				else {
					if(no.getEsquerda() == null) return no.getDireita();
					else {
						if(no.getDireita() == null) return no.getEsquerda();
						else {
							noAux = no.getDireita();
							while(noAux.getEsquerda() != null) noAux = noAux.getEsquerda();
							noAux.setEsquerda(no.getEsquerda());
							return no.getDireita();
						}
					}
				}
			}
			if(no.getElemento() < elemento) no.setDireita(deleteNo(elemento, no.getDireita()));
			else no.setEsquerda(deleteNo(elemento, no.getEsquerda()));
		}
		return no;
	}
	
	public void delete() {
		
		titulo = "Apagar elemento";
		
		if(isEmpty()) mensagem = "Arvore Vazia";
		else {
			mensagem = "Digite o elemento a ser apagado";
			Character elemento = JOptionPane.showInputDialog(null, mensagem, titulo ,JOptionPane.QUESTION_MESSAGE).charAt(0);
			mensagem = "O elemento" + elemento;
			if(!buscarElemento(elemento, noRaiz)) mensagem += " não se encontra na ";
			else {
				noRaiz = deleteNo(elemento, noRaiz);
				mensagem = " foi elimindado da ";
				tamanho--;
			}
			mensagem = " Arvore binária";
		}
		JOptionPane.showMessageDialog(null, mensagem, titulo,JOptionPane.PLAIN_MESSAGE);
		
	}
	
	public void alterar() {
		delete();
		create();
	}
	
	public void apresentarArvore() {
		
		mensagem = "";
		titulo = "Arvore Binaria";
		
		if(isEmpty()) mensagem += "Arvore Binaria Vazia";
		else apresentarNivel(0, noRaiz);
		JOptionPane.showMessageDialog(null, mensagem, titulo,JOptionPane.PLAIN_MESSAGE);
	
	}
	
	public void apresentarNivel(int nivel, NoArvore no) {
		
		int i;
		if(no != null) {
			apresentarNivel(nivel+1, no.getDireita());
			for(i = 0; i < nivel; i++) mensagem +="               ";
			mensagem += no.getElemento() + "\n";
			apresentarNivel(nivel+1, no.getEsquerda());
			
		}		
	}
	
	public void apresentarPercurso(char opcao, NoArvore no) {
		
		if(no != null) {
			if(opcao=='p')	mensagem+=no.getElemento()+" ";
			apresentarPercurso(opcao, no.getEsquerda());
			
			if(opcao=='o')	mensagem+=no.getElemento()+" ";
			apresentarPercurso(opcao, no.getDireita());
			
			if(opcao=='P')	mensagem+=no.getElemento()+" ";
		}
	}
	
	public void apresentarPreOrdem() {
		
		mensagem = "";
		titulo = "Percuso Pre-Ordenado";
		
		if(isEmpty()) mensagem += "Arvore Binaria Vazia";
		else apresentarPercurso('p', noRaiz);
		JOptionPane.showMessageDialog(null, mensagem, titulo,JOptionPane.PLAIN_MESSAGE);
	}
	
	
	public void apresentarOrdem() {
		
		mensagem = "";
		titulo = "Percuso Ordenado";
		
		if(isEmpty()) mensagem += "Arvore Binaria Vazia";
		else apresentarPercurso('o', noRaiz);
		JOptionPane.showMessageDialog(null, mensagem, titulo,JOptionPane.PLAIN_MESSAGE);
	}
	
	public void apresentarPosOrdem() {
		
		mensagem = "";
		titulo = "Percuso Pos-Ordenado";
		
		if(isEmpty()) mensagem += "Arvore Binaria Vazia";
		else apresentarPercurso('P', noRaiz);
		JOptionPane.showMessageDialog(null, mensagem, titulo,JOptionPane.PLAIN_MESSAGE);
	}
	
	public boolean isEmpty() {
		if(tamanho == 0) return true;
		else return false;
	}
	
    public void altura() {
    	mensagem = "";
		titulo = "Altura da arvore";
		
	    if(isEmpty()) mensagem += "Arvore Binaria Vazia";
	    else {
	    	int resp = calcularAltura(noRaiz);  
	    	mensagem = "A altura é de: " + resp;
	    }
	    JOptionPane.showMessageDialog(null, mensagem, titulo,JOptionPane.PLAIN_MESSAGE);
     }

    public int calcularAltura(NoArvore no) {
    	if(no == null) return -1;
    	else {
    		int alturaEsquerda = calcularAltura(no.getEsquerda());
    		int alturaDireita = calcularAltura(no.getDireita());
    		if(alturaEsquerda < alturaDireita) return alturaDireita + 1;
    		else return alturaEsquerda + 1;
    	}
    }
    
    public void estritamenteBinaria() {
    	mensagem = "";
		titulo = "Verificacao estritamente binaria";
		
	    if(isEmpty()) mensagem += "Arvore Binaria Vazia";
	    else {
	    	int resp = verificarEstritamenteBinaria(noRaiz, 0, 0);  
	    	if(resp == 0) {
	    		mensagem = "A arvore binaria é estritamente binaria";
	    	}
	    	else if(resp == 1) {
	    		mensagem = "A arvore binaria não é estritamente binaria";
	    	}
	    	else {
	    		mensagem = "erro";
	    	}
	    	
	    }
	    JOptionPane.showMessageDialog(null, mensagem, titulo,JOptionPane.PLAIN_MESSAGE);
     }
	
	public int verificarEstritamenteBinaria(NoArvore no, int contDireito, int contEsquerdo) {	
		
		if(no.getEsquerda() != null) {
			return verificarEstritamenteBinaria(no.getEsquerda(), contDireito, contEsquerdo + 1);
		}
		if(no.getDireita() != null) {
			return verificarEstritamenteBinaria(no.getDireita(), contDireito + 1, contEsquerdo);
		}
		
		if((contEsquerdo - contDireito) < -1 || 
		   (contEsquerdo - contDireito) > 1  || 
		   (contDireito - contEsquerdo) < -1 || 
		   (contDireito - contEsquerdo) > 1) return 1;
		return 0;
	}
	
}
