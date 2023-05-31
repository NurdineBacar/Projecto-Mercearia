package ClasseDeObjecto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import BD.Bd;

public class Usuario {
	private int codigo;
	private String pNome, apelido, genero, tipoUsuario, username,senha, numeroTelefone;
	
	
	public Usuario(String pNome, String apelido, String genero, String tipoUsuario,
			String senha, String numeroTelefone) {
		this.codigo = this.setCodigo();
		this.pNome = pNome;
		this.apelido = apelido;
		this.genero = genero;
		this.tipoUsuario = tipoUsuario;
		this.username = this.pNome+"."+this.apelido;
		this.senha = senha;
		this.numeroTelefone = numeroTelefone;
	}
	

	public Usuario(int codigo, String pNome, String apelido, String genero, String tipoUsuario, String username,
			String senha, String numeroTelefone) {
		this.codigo = codigo;
		this.pNome = pNome;
		this.apelido = apelido;
		this.genero = genero;
		this.tipoUsuario = tipoUsuario;
		this.username = this.pNome+"."+this.apelido;
		this.senha = senha;
		this.numeroTelefone = numeroTelefone;
	}
	
	public Usuario() {	}
	
	public int getCodigo() {
		return codigo;
	}
	public int setCodigo() {
		int codigo=0;
		try {
			ArrayList<Usuario> listaUsuario= Bd.lerUsuarios();
			
			for(int i=0;i<listaUsuario.size();i++) {
				if(listaUsuario.get(i).getCodigo()==codigo) {
					codigo++;
				}else {
					break;
				}
			}
		} catch (Exception e) {
			
		}
		return this.codigo=codigo;
	}
	public String getpNome() {
		return pNome;
	}
	public void setpNome(String pNome) {
		this.pNome = pNome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNumeroTelefone() {
		return numeroTelefone;
	}
	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
	
	public String toString() {
		return codigo+";"+pNome+";"+apelido+";"+genero+";"+tipoUsuario+";"+username+";"+senha+";"+numeroTelefone;
	}
	
	public static void registo(String nome, String apelido, String genero, String tipoUsuario, String senha, String numeroTelefone) throws Exception{
		FileWriter open= new FileWriter("usuarios.txt",true);
		BufferedWriter write= new BufferedWriter(open);
		
		Usuario user = new Usuario(nome, apelido, genero, tipoUsuario, senha, numeroTelefone);
		
		write.write(user.toString());
		write.newLine();
		write.close();
	}
	
	
	public static void editarUsuario(String codigo,String nome, String apelido, String genero, String tipoUsuario, String senha, String numeroTelefone) {
		
		
		try {
		
			ArrayList<Usuario> listaUsuario= Bd.lerUsuarios();
			int codigoConvertido= Integer.parseInt(codigo);
			for(int i=0;i<listaUsuario.size();i++) {
				if(listaUsuario.get(i).getCodigo()==codigoConvertido) {
					listaUsuario.get(i).codigo=codigoConvertido;
					listaUsuario.get(i).setpNome(nome.toUpperCase());
					listaUsuario.get(i).setApelido(apelido.toUpperCase());
					listaUsuario.get(i).setGenero(genero);
					listaUsuario.get(i).setTipoUsuario(tipoUsuario);
					listaUsuario.get(i).setUsername(nome.toLowerCase()+"."+apelido.toLowerCase());
					listaUsuario.get(i).setSenha(senha);
					listaUsuario.get(i).setNumeroTelefone(numeroTelefone);
				}
			}
			
			FileWriter open= new FileWriter("usuarios.txt");
			BufferedWriter write= new BufferedWriter(open);
			
			for(int i=0;i<listaUsuario.size();i++) {
				write.write(listaUsuario.get(i).toString());
				write.newLine();
			}
			
			write.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void removerUsuario(String codigo)  {
		
		try {
			ArrayList<Usuario> listaUsuario= Bd.lerUsuarios();
			
			int codigoConvertido= Integer.parseInt(codigo);
			
			for(int i=0;i<listaUsuario.size();i++) {
				if(codigoConvertido==listaUsuario.get(i).getCodigo()) {
					listaUsuario.remove(i);
					break;
				}
			}
			
			FileWriter open= new FileWriter("usuarios.txt");
			BufferedWriter write= new BufferedWriter(open);
			
			for(Usuario usuario: listaUsuario) {
				write.write(usuario.toString());
				write.newLine();
			}
			write.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}catch(IOException e) {
			
		}
		
		
	}
	
}
