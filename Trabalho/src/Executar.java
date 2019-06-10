
import	javax.swing.*;	

public class Executar {

	public static Metodos arvore = new Metodos();
	public	static	String	mensagem, titulo;
	public	static	String[] confirmacao ={"Sim","Não"};
	public	static	int sair;
	public	static	String[] acoesIniciais={"Inserir Nó", "Excluir No", "Alterar No", "Apresentar Árvore", "Mostrar Pre-Ordem", "Mostrar Ordem", "Mostrar Pos-Ordem", "Altura", "Estritamente Binaria?", "Sair"};
	public	static	String[] acoesOrdem={"Pre Ordem", "Ordem", "Pos-Ordem", "Sair"};
	public	static	int	opcao;
	
	public static void main(String[] args) {
		
		titulo = "Trabalho D3";
		mensagem = "Arvore Binarias - CRUD completo, apresentacao da Arvore e Pré/Pós ordem ";
		JOptionPane.showMessageDialog(null, mensagem, titulo,JOptionPane.PLAIN_MESSAGE);
		
		do {
			mensagem ="Selecione o botão da opção desejada:";
			opcao = JOptionPane.showOptionDialog(null, mensagem, titulo,1,JOptionPane.QUESTION_MESSAGE,null, acoesIniciais,null);
			switch(opcao)
			{
				case	0:	arvore.create();
							break;
							
				case	1:	arvore.delete();
							break;
							
				case	2:	arvore.alterar();
							break;
							
				case	3:	arvore.apresentarArvore();
							break;
							
				case	4:	arvore.apresentarPreOrdem();
							break;
							
				case	5:	arvore.apresentarOrdem();
							break;
							
				case	6:	arvore.apresentarPosOrdem();
							break;	
				
				case	7:	arvore.altura();
							break;				
				
				case	8:	arvore.estritamenteBinaria();
							break;	
				
				case	9:	mensagem = "Deseja realmente sair?";
							sair = JOptionPane.showOptionDialog(null,mensagem, titulo,1,JOptionPane.QUESTION_MESSAGE,null, confirmacao,null);
							if(sair ==1) opcao = -1;
							break;
			}
			
		} while(opcao != 9);
		
		System.exit(0);		
	}
	
}
