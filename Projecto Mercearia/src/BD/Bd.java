package BD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import ClasseDeObjecto.Fornecedor;
import ClasseDeObjecto.Produto;
import ClasseDeObjecto.Usuario;
import ClasseDeObjecto.Venda;

public class Bd {
		
	public static ArrayList<Usuario> lerUsuarios() throws IOException{
		ArrayList<Usuario> listaUsuario= new ArrayList<>();
		try {
			FileReader open= new FileReader("usuarios.txt");
			BufferedReader read= new BufferedReader(open);
			
			
			String [] elemento;
			String linha=  read.readLine();
			
			while(linha != null) {
				elemento= linha.split(";");
				
				int codigo= Integer.parseInt(elemento[0]);
				String primeiroNome= elemento[1];
				String apelido = elemento[2];
				String genero= elemento[3];
				String tipoDeUsuario= elemento[4];
				String username= elemento[5];
				String password= elemento[6];
				String numero= elemento[7];
				
				listaUsuario.add(new Usuario(codigo, primeiroNome, apelido, genero, tipoDeUsuario, username, password, numero));
				linha= read.readLine();
			}
			read.close();
			open.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return listaUsuario;
	}
	


public static ArrayList<Fornecedor> listarFornecedores1() {
	
	ArrayList<Fornecedor> listaFornecedor= new ArrayList();
	
	try {
		FileReader file= new FileReader("fornecedores.txt");
		BufferedReader read= new BufferedReader(file);
		
		String linha= read.readLine();
		StringTokenizer elemento;
		while(linha != null) {
			elemento= new StringTokenizer(linha,";");
			
			int codigo= Integer.parseInt(elemento.nextToken());
			 String nomeFornecedor= elemento.nextToken();
			 String numeroTelefone= elemento.nextToken();
			 String endereco=elemento.nextToken();
			
			// listaFornecedor.add(new Usuario(nome, apelido, genero, tipoDeusuario, senha, numero));
			 
			 listaFornecedor.add(new Fornecedor(codigo, nomeFornecedor, numeroTelefone, endereco));
			 linha=read.readLine();
		}
	} catch (FileNotFoundException e) {
		// TODO: handle exception
	}catch(Exception e) {
		
	}
	return listaFornecedor;
}

public static ArrayList<Fornecedor> listarFornecedores2() {
	ArrayList<Fornecedor> listaFornecedor= new ArrayList();
	
	try {
		FileReader file= new FileReader("fornecedores.txt");
		BufferedReader read= new BufferedReader(file);
		
		String linha= read.readLine();
		StringTokenizer elemento;
		while(linha != null) {
			elemento= new StringTokenizer(linha,"-");
			
			int codigo= Integer.parseInt(elemento.nextToken());
			 String nomeFornecedor= elemento.nextToken();
			 String numeroTelefone= elemento.nextToken();
			 String endereco=elemento.nextToken();
			
			// listaFornecedor.add(new Usuario(nome, apelido, genero, tipoDeusuario, senha, numero));
			 
			 listaFornecedor.add(new Fornecedor(nomeFornecedor, nomeFornecedor, endereco));
			 linha=read.readLine();
		}
	} catch (FileNotFoundException e) {
		// TODO: handle exception
	}catch(Exception e) {
		
	}
	
	return listaFornecedor;
}

public static ArrayList<Produto> listarProdutos(){
	ArrayList<Produto> listaProduto=new ArrayList<>();
	try {
		FileReader file= new FileReader("produtos.txt");
		BufferedReader read= new BufferedReader(file);
		
		String linha= read.readLine();
		StringTokenizer elemento;
		
		while(linha!=null) {
			elemento= new StringTokenizer(linha,";");
			int codigo=Integer.parseInt(elemento.nextToken());
			String nomeProduto=elemento.nextToken();
			String categoria=elemento.nextToken();
			double precoA=Double.parseDouble(elemento.nextToken());
			double precoV=Double.parseDouble(elemento.nextToken());
			String dataFabrico=elemento.nextToken();
			String dataExpira=elemento.nextToken();
			String lote=elemento.nextToken();
			String fornecedor=elemento.nextToken();
			int quantidade=Integer.parseInt(elemento.nextToken());
			
			listaProduto.add(new Produto(codigo, nomeProduto, categoria, precoA, precoV, dataFabrico, dataExpira, lote, fornecedor, quantidade));
			linha=read.readLine();
		}
	} catch (FileNotFoundException e) {
		// TODO: handle exception
	}catch (Exception e) {
		// TODO: handle exception
	}
	
	return listaProduto;
}

public static ArrayList<Venda> listarVenda() {
	ArrayList<Venda> listaVenda= new ArrayList();
	
	try {
		FileReader file= new FileReader("venda.txt");
		BufferedReader read= new BufferedReader(file);
		
		String linha= read.readLine();
		StringTokenizer elemento;
		int i=0;
		while(linha != null) {
			elemento= new StringTokenizer(linha,";");
			
			int codigo= Integer.parseInt(elemento.nextToken());
			String nomeProduto=elemento.nextToken();
			String categoria=elemento.nextToken();
			String lote=elemento.nextToken();
			int quantidade=Integer.parseInt(elemento.nextToken());
			double valorApagar=Double.parseDouble(elemento.nextToken());
			
			
			 Produto produto= new Produto(nomeProduto, categoria, lote);
			 listaVenda.add( new Venda(codigo, produto, quantidade, valorApagar));
			 linha=read.readLine();
		}
	} catch (FileNotFoundException e) {
		// TODO: handle exception
	}catch(Exception e) {
		
	}
	
	return listaVenda;
}

public static ArrayList<Venda> lerRelatorioVenda() {
	ArrayList<Venda> listaVenda= new ArrayList();
	
	try {
		FileReader file= new FileReader("relatorioVenda.txt");
		BufferedReader read= new BufferedReader(file);
		
		String linha= read.readLine();
		StringTokenizer elemento;
		int i=0;
		while(linha != null) {
			elemento= new StringTokenizer(linha,";");
			
			int codigo= Integer.parseInt(elemento.nextToken());
			String nomeProduto=elemento.nextToken();
			String categoria=elemento.nextToken();
			String lote=elemento.nextToken();
			int quantidade=Integer.parseInt(elemento.nextToken());
			double valorApagar=Double.parseDouble(elemento.nextToken());
			String data=elemento.nextToken();
			
			
			 Produto produto= new Produto(nomeProduto, categoria, lote);
			 listaVenda.add( new Venda(produto, quantidade, valorApagar, data));
			 linha=read.readLine();
		}
	} catch (FileNotFoundException e) {
		// TODO: handle exception
	}catch(Exception e) {
		
	}
	
	return listaVenda;
}
public static String[][]tabelaUsuarios()throws IOException{
	ArrayList<Usuario> usuarios= lerUsuarios();
	
	String [][]dadosTabela= new String[usuarios.size()][8];
	for(int i=0;i<usuarios.size();i++) {
		String codigo=usuarios.get(i).getCodigo()+"";
		
		dadosTabela[i][0]=codigo;
		dadosTabela[i][1]=usuarios.get(i).getpNome();
		dadosTabela[i][2]=usuarios.get(i).getApelido();
		dadosTabela[i][3]=usuarios.get(i).getGenero();
		dadosTabela[i][4]=usuarios.get(i).getTipoUsuario();
		dadosTabela[i][5]=usuarios.get(i).getUsername();
		dadosTabela[i][6]=usuarios.get(i).getSenha();
		dadosTabela[i][7]=usuarios.get(i).getNumeroTelefone();
	}
	
	return dadosTabela;
}

public static String[][]tabelaFornecedores()throws IOException{
	
	
	ArrayList<Fornecedor> fornecedores= listarFornecedores1();
	String [][]dadosTabela = new String[fornecedores.size()][4];;
		
		for(int i=0;i<fornecedores.size();i++) {
			String codigo=fornecedores.get(i).getCodigo()+"";
			
			dadosTabela[i][0]=codigo;
			dadosTabela[i][1]=fornecedores.get(i).getNomeDoFornecedor();
			dadosTabela[i][2]=fornecedores.get(i).getNumeroDofornecedor();
			dadosTabela[i][3]=fornecedores.get(i).getEndereco();
		}
	return dadosTabela;
	
}

public static Fornecedor[] comboFornecedor() {
	Fornecedor [] fornecedores= new Fornecedor[listarFornecedores1().size()];
	ArrayList<Fornecedor> listaFornecedor= listarFornecedores1();
	for(int i=0;i<listaFornecedor.size();i++) {
		fornecedores[i]= new Fornecedor(listaFornecedor.get(i).getCodigo(), listaFornecedor.get(i).getNomeDoFornecedor(), listaFornecedor.get(i).getNumeroDofornecedor(), listaFornecedor.get(i).getEndereco());
	}
	
	return fornecedores;
}

public static String[] comboFornecedor2() {
	String [] fornecedores= new String[listarFornecedores1().size()];
	ArrayList<Fornecedor> listaFornecedor= listarFornecedores1();
	for(int i=0;i<listaFornecedor.size();i++) {
		fornecedores[i]= listaFornecedor.get(i).toString1();
	}
	
	return fornecedores;
}

public static String[][] tabelaProduto() {
	ArrayList<Produto> listaProdutos= listarProdutos();
	
	String [][] listaProduto= new String[listaProdutos.size()][10];
	for(int i=0;i<listaProdutos.size();i++) {
		String produtoTetxo=listaProdutos.get(i).toString2();
		StringTokenizer split= new StringTokenizer(produtoTetxo,";");
		listaProduto[i][0]=split.nextToken();
		listaProduto[i][1]=split.nextToken();
		listaProduto[i][2]=split.nextToken();
		listaProduto[i][3]=split.nextToken();
		listaProduto[i][4]=split.nextToken();
		listaProduto[i][5]=split.nextToken();
		listaProduto[i][6]=split.nextToken();
		listaProduto[i][7]=split.nextToken();
		listaProduto[i][8]=split.nextToken();
		listaProduto[i][9]=split.nextToken();
	}
	return listaProduto;
}

public static String[][] tabelaProdutoVenda() {
	ArrayList<Produto> listaProdutos= listarProdutos();
	
	String [][] listaProduto= new String[listaProdutos.size()][4];
	for(int i=0;i<listaProdutos.size();i++) {
		listaProduto[i][0]=listaProdutos.get(i).getCodigo()+"";
		listaProduto[i][1]=listaProdutos.get(i).getNomeDoProduto();
		listaProduto[i][2]=listaProdutos.get(i).getPrecoVenda()+"";
		listaProduto[i][3]=listaProdutos.get(i).getQuantidade()+"";
		
	}
	return listaProduto;
}

public static String[][] tabelaProdutoVendaFiltro(String categoria) {
	ArrayList<Produto> listaProdutos= listarProdutos();
	
	String [][] listaProduto= new String[listaProdutos.size()][4];
//	for(int i=0;i<listaProdutos.size();i++) {
//		if(listaProdutos.get(i).getCategoria().equalsIgnoreCase(categoria)) {
//			listaProduto[i][0]=listaProdutos.get(i).getCodigo()+"";
//			listaProduto[i][1]=listaProdutos.get(i).getNomeDoProduto();
//			listaProduto[i][2]=listaProdutos.get(i).getPrecoVenda()+"";
//			listaProduto[i][3]=listaProdutos.get(i).getQuantidade()+"";
//		}
	int a=0,i=0;
	while(a<listaProduto.length) {
		
		if(listaProdutos.get(a).getCategoria().equals(categoria)) {
			listaProduto[i][0]=listaProdutos.get(i).getCodigo()+"";
			listaProduto[i][1]=listaProdutos.get(i).getNomeDoProduto();
			listaProduto[i][2]=listaProdutos.get(i).getPrecoVenda()+"";
			listaProduto[i][3]=listaProdutos.get(i).getQuantidade()+"";
			i++;
		}
		a++;
	}
	return listaProduto;
}

public static String[][] tabelaProdutoVendaAdicionado() {
	String [][] listarVenda= new String[listarProdutos().size()][5];
	
	for(int i=0;i<listarProdutos().size();i++) {
		
		
	}
	return listarVenda;
}
public static String[][] tabelaVenda() {
	ArrayList<Venda> listaVenda= listarVenda();
	String [][] listaVendas= new String[listaVenda.size()][5];
	String cod="",nomeP="",cat="",lote="",qtd="",valor="";
	StringTokenizer split;
	int i=0;
	for(Venda venda: listarVenda()) {
		split= new StringTokenizer(venda.toString1(), ";");
		cod=split.nextToken();
		nomeP=split.nextToken();
		cat=split.nextToken();
		lote=split.nextToken();
		qtd=split.nextToken();
		valor=split.nextToken();
		
		listaVendas[i][0]=cod;
		listaVendas[i][1]=nomeP;
		listaVendas[i][2]=cat;
		listaVendas[i][3]=qtd;
		listaVendas[i][4]= valor;
		i++;
	}
	return listaVendas;
}

public static Produto [] cancelarVenda(ArrayList<Produto> produto) {
	Produto [] arrayProduto= new Produto[produto.size()];
	for(int i=0;i<produto.size();i++) {
		arrayProduto[i]=produto.get(i);
	}
	return arrayProduto;
}
}


