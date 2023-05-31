package ClasseDeObjecto;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import BD.Bd;

public class Produto {
	private int codigo;
	private String nomeDoProduto,categoria;
	private double precoAquisicao, precoVenda;
	private String dataFabrico,expiraValidade;
	private String lote,fornecedor2;
	private Fornecedor fornecedor1;
	private int quantidade;
	
	public Produto(String nomeDoProduto,String categoria, double precoAquisicao, double precoVenda,String dataFabrico, String expiraValidade, Fornecedor fornecedor, int quantidade) {
		this.codigo = this.setCodigo();
		this.nomeDoProduto=nomeDoProduto;
		this.categoria = categoria;
		this.precoAquisicao = precoAquisicao;
		this.precoVenda = precoVenda;
		this.dataFabrico=dataFabrico;
		this.expiraValidade = expiraValidade;
		this.lote = this.setLote();
		this.fornecedor1 = fornecedor;
		this.quantidade = quantidade;
	}
	
	public Produto(int codigo,String nomeDoProduto,String categoria, double precoAquisicao, double precoVenda, String dataFabrico, String expiraValidade,
			 String lote, String fornecedor, int quantidade) {
		this.codigo = codigo;
		this.nomeDoProduto=nomeDoProduto;
		this.categoria = categoria;
		this.precoAquisicao = precoAquisicao;
		this.precoVenda = precoVenda;
		this.dataFabrico=dataFabrico;
		this.expiraValidade = expiraValidade;
		this.lote = lote;
		this.fornecedor2 = fornecedor;
		this.quantidade = quantidade;
	}
	
	public Produto(String nomeDoProduto,String categoria,String lote) {
		this.nomeDoProduto=nomeDoProduto;
		this.categoria=categoria;
		this.lote=lote;
	}
	public int getCodigo() {
		return codigo;
	}
	
	public String getDataFabrico() {
		return dataFabrico;
	}

	public void setDataFabrico(String dataFabrico) {
		this.dataFabrico = dataFabrico;
	}

	public int setCodigo() {
		int codigo=0;
		try {
			ArrayList<Produto> listaProduto= Bd.listarProdutos();
			
			for(int i=0;i<listaProduto.size();i++) {
				if(listaProduto.get(i).getCodigo()==codigo) {
					codigo++;
				}
			}
		} catch (Exception e) {
			
		}
		return this.codigo=codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo=codigo;
	}

	
	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrecoAquisicao() {
		return precoAquisicao;
	}

	public void setPrecoAquisicao(double precoAquisicao) {
		this.precoAquisicao = precoAquisicao;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public String getExpiraValidade() {
		return expiraValidade;
	}

	public void setExpiraValidade(String expiraValidade) {
		this.expiraValidade = expiraValidade;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}
	public String setLote() {
		int indexLote=1;
		String categoria=null;
		try {
			ArrayList<Produto> listaProduto= Bd.listarProdutos();
			for(Produto produto: listaProduto ) {
				categoria=produto.getCategoria();
				if(categoria.equalsIgnoreCase(this.getCategoria())) {
					if(produto.getLote().contains(indexLote+"")) {
						indexLote++;
					}
				}
				
			}
		}catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return this.lote="Lote"+this.getCategoria()+indexLote;
	}

	public Fornecedor getFornecedor() {
		return fornecedor1;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor1 = fornecedor;
	}
	
	public String getFornecedor2() {
		return fornecedor2;
	}

	public void setFornecedor2(String fornecedor2) {
		this.fornecedor2 = fornecedor2;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Fornecedor getFornecedor1() {
		return fornecedor1;
	}

	public void setFornecedor1(Fornecedor fornecedor1) {
		this.fornecedor1 = fornecedor1;
	}
	
	public String toString1() {
		return codigo+";"+ nomeDoProduto+";"+ categoria+";"+ precoAquisicao+";"+ precoVenda+";"+dataFabrico+";"+ expiraValidade+";"+ lote+";"+fornecedor1.toString1()+";"+ quantidade;
	}
	public String toString2() {
		return codigo+";"+ nomeDoProduto+";"+ categoria+";"+ precoAquisicao+";"+ precoVenda+";"+dataFabrico+";"+ expiraValidade+";"+ lote+";"+fornecedor2+";"+ quantidade;
	}
	public String toString3() {
		return nomeDoProduto+";"+categoria+";"+lote;
	}

	public static void registoProduto(String nomeDoProduto,String categoria, double precoAquisicao, double precoVenda, String dataFabrico,String expiraValidade,
			  Fornecedor fornecedor, int quantidade) throws IOException{
		
		FileWriter open= new FileWriter("produtos.txt",true);
		BufferedWriter write= new BufferedWriter(open);
		
		Produto produto= new Produto(nomeDoProduto, categoria, precoAquisicao, precoVenda, dataFabrico,expiraValidade,fornecedor, quantidade);
		write.write(produto.toString1());
		write.newLine();
		write.close();
	 }
	 
	 public static void edicarProduto(String codigo,String nomeDoProduto,String categoria, double precoAquisicao, double precoVenda, String dataFabrico, String expiraValidade,
			  String fornecedor, int quantidade) {
		 try {
			 ArrayList<Produto> listaProduto= Bd.listarProdutos();
			 int codigoConvert =Integer.parseInt(codigo);
			  for(int i=0;i<listaProduto.size();i++) {
				  if(codigoConvert==listaProduto.get(i).getCodigo()) {
					  listaProduto.get(i).setCodigo(codigoConvert);
					  listaProduto.get(i).setCategoria(categoria);
					  listaProduto.get(i).setDataFabrico(dataFabrico);
					  listaProduto.get(i).setExpiraValidade(expiraValidade);
					  listaProduto.get(i).setFornecedor2(fornecedor);
					  listaProduto.get(i).setQuantidade(quantidade);
					  listaProduto.get(i).setNomeDoProduto(nomeDoProduto);
					  listaProduto.get(i).setPrecoVenda(precoVenda);
					  listaProduto.get(i).setPrecoAquisicao(precoAquisicao);  
				  }
			  }
			  
			  FileWriter file= new FileWriter("produtos.txt");
			  BufferedWriter write= new BufferedWriter(file);
			  
			  for(Produto produto: listaProduto) {
				  write.write(produto.toString2());
				  write.newLine();
			  }
			  write.close();
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}catch (FileNotFoundException e) {
			// TODO: handle exception
		}catch (Exception e) {
			// TODO: handle exception
		}
	 }
	 
	 public static void removerProduto(String codigo) {
		 try {
			 ArrayList<Produto> listaProduto= Bd.listarProdutos();
			 int codigoConvert =Integer.parseInt(codigo);
			  for(int i=0;i<listaProduto.size();i++) {
				  if(codigoConvert==listaProduto.get(i).getCodigo()) {
					  listaProduto.remove(i);
				  }
			  }
			  
			  FileWriter file= new FileWriter("produtos.txt");
			  BufferedWriter write= new BufferedWriter(file);
			  
			  for(Produto produto: listaProduto) {
				  write.write(produto.toString2());
				  write.newLine();
			  }
			  write.close();
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}catch (FileNotFoundException e) {
			// TODO: handle exception
		}catch (Exception e) {
			// TODO: handle exception
		}
	 }

	
	 
}
