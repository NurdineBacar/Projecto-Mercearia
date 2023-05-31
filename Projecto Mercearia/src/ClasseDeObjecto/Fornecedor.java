package ClasseDeObjecto;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;

import BD.Bd;

public class Fornecedor {
	 private int codigo;
	 private String nomeDoFornecedor, numeroDofornecedor, endereco ;
	
	 public Fornecedor(int codigo, String nomeDoFornecedor, String numeroDofornecedor, String endereco) {
		this.codigo = codigo;
		this.nomeDoFornecedor = nomeDoFornecedor;
		this.numeroDofornecedor = numeroDofornecedor;
		this.endereco = endereco;
	}

	public Fornecedor(String nomeDoFornecedor, String numeroDofornecedor, String endereco) {
		this.codigo = this.setCondigo();
		this.nomeDoFornecedor = nomeDoFornecedor;
		this.numeroDofornecedor = numeroDofornecedor;
		this.endereco = endereco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int setCondigo() {
		int codigo=0;
		try {
			ArrayList<Fornecedor> listaForncedor= Bd.listarFornecedores1();
			
			for(int i=0;i<listaForncedor.size();i++) {
				if(listaForncedor.get(i).getCodigo()==codigo) {
					codigo++;
				}
			}
		}catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
		return this.codigo=codigo;
	}

	public String getNomeDoFornecedor() {
		return nomeDoFornecedor;
	}

	public void setNomeDoFornecedor(String nomeDoFornecedor) {
		this.nomeDoFornecedor = nomeDoFornecedor;
	}

	public String getNumeroDofornecedor() {
		return numeroDofornecedor;
	}

	public void setNumeroDofornecedor(String numeroDofornecedor) {
		this.numeroDofornecedor = numeroDofornecedor;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	 
	 public String toString1() {
		 return nomeDoFornecedor+"-"+numeroDofornecedor+"-"+endereco;
	 }
	 
	 public String toString2() {
		 return codigo+";"+nomeDoFornecedor+";"+numeroDofornecedor+";"+endereco;
	 }
		 
	 public static void registoFornecedor(String nome,String numero,String endereco) {
		 
		 try {
			FileWriter file= new FileWriter("fornecedores.txt",true);
			BufferedWriter write= new BufferedWriter(file);
			
			Fornecedor fonecedor= new Fornecedor(nome, numero, endereco);
			write.write(fonecedor.toString2());
			write.newLine();
			write.close();
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}catch(Exception e) {
			
		}
	 }
	 
	 public static void editarFornecedor(String codigo,String nome,String numero,String endereco) {
		
		 try {
			 ArrayList<Fornecedor> listaFornecedor= Bd.listarFornecedores1();
			 int codigoConvert =Integer.parseInt(codigo);
			  for(int i=0;i<listaFornecedor.size();i++) {
				  if(codigoConvert==listaFornecedor.get(i).getCodigo()) {
					  listaFornecedor.get(i).setCodigo(codigoConvert);
					  listaFornecedor.get(i).setNomeDoFornecedor(nome);
					  listaFornecedor.get(i).setNumeroDofornecedor(numero);
					  listaFornecedor.get(i).setEndereco(endereco);
				  }
			  }
			  
			  FileWriter file= new FileWriter("fornecedores.txt");
			  BufferedWriter write= new BufferedWriter(file);
			  
			  for(Fornecedor fornecedor: listaFornecedor) {
				  write.write(fornecedor.toString2());
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
	 
	 public static void removerFornecedor(String codigo) {
		 try {
			 ArrayList<Fornecedor> listaFornecedor= Bd.listarFornecedores1();
			 int codigoConvert =Integer.parseInt(codigo);
			  for(int i=0;i<listaFornecedor.size();i++) {
				  if(codigoConvert==listaFornecedor.get(i).getCodigo()) {
					 listaFornecedor.remove(i);
				  }
			  }
			  
			  FileWriter file= new FileWriter("fornecedores.txt");
			  BufferedWriter write= new BufferedWriter(file);
			  
			  for(Fornecedor fornecedor: listaFornecedor) {
				  write.write(fornecedor.toString2());
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
