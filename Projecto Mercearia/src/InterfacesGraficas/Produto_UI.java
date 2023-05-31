package InterfacesGraficas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BD.Bd;
import ClasseDeObjecto.Fornecedor;
import ClasseDeObjecto.Produto;

import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class Produto_UI extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeProduto;
	private JTextField txtPrecoAquisicao;
	private JTextField txtPrecoVenda;
	private JTextField txtQuantidade;
	private JTextField txtDataFabrico;
	private JTextField txtDataExpira;
	private JTextField txtNomeProdutoEditar;
	private JTextField txtPrecoAquisicaoEditar;
	private JTextField txtPrecoVendaEditar;
	private JTextField txtDataFabricoEditar;
	private JTextField txtDaExpiraEditar;
	private JTextField txtQuantidadeEditar;
	private JTable tabelaRemover;
	private JLabel lblQuantidade,lblDataExpira ,lblDataFabrico,lblPrecoVenda,
	lblPrecoAquisicao,lblCategoria,lblNomeProduto,index;
	private String categoria="Nao defenido",categotiaEditar="nao definido";
	private int indexFornecedor,linhaTabela,indexFornecedorEditar;
	private JButton btnRegistar;
	private JTable tabelaEditar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produto_UI frame = new Produto_UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Produto_UI() {
		setResizable(false);
		setTitle("REGISTO PRODUTO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 851, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 835, 459);
		contentPane.add(tabbedPane);
		
		JPanel registarProduto = new JPanel();
		tabbedPane.addTab("Registar Produto", null, registarProduto, null);
		registarProduto.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(null);
		panel_1.setLayout(null);
		panel_1.setBounds(252, 0, 578, 431);
		registarProduto.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Nome do Produto");
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		lblNewLabel.setBounds(81, 55, 98, 14);
		panel_1.add(lblNewLabel);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//lblNomeProduto.setText("");
				lblNomeProduto.setText(txtNomeProduto.getText());
			}
		});
		txtNomeProduto.setColumns(10);
		txtNomeProduto.setBounds(202, 52, 261, 20);
		panel_1.add(txtNomeProduto);
		
		JLabel lblNewLabel_1 = new JLabel("Categoria");
		lblNewLabel_1.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		lblNewLabel_1.setBounds(81, 82, 76, 14);
		panel_1.add(lblNewLabel_1);
		
		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setMaximumRowCount(10);
		cbCategoria.setBackground(new Color(255, 255, 255));
		cbCategoria.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				categoria=(cbCategoria.getSelectedIndex()!=0)? cbCategoria.getSelectedItem()+"":"Nao definido";
				lblCategoria.setText(categoria);
			}
		});
		cbCategoria.setModel(new DefaultComboBoxModel(new String[] {"                              ---Selecione---", "Fruta", "Vegetal", "Carne", "Marisco", "Sabao", "Farinhas", "Refrigerante", "Chocolate", "Iogurte", "Cereal", "Bolacha", "Caneta", "Caderno", "Chips"}));
		cbCategoria.setBounds(202, 78, 261, 22);
		panel_1.add(cbCategoria);
		
		JLabel lblNewLabel_3 = new JLabel("Preço de Aquisição");
		lblNewLabel_3.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		lblNewLabel_3.setBounds(81, 139, 111, 17);
		panel_1.add(lblNewLabel_3);
		
		txtPrecoAquisicao = new JTextField();
		txtPrecoAquisicao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblPrecoAquisicao.setText(txtPrecoAquisicao.getText());
			}
		});
		txtPrecoAquisicao.setColumns(10);
		txtPrecoAquisicao.setBounds(202, 137, 86, 20);
		panel_1.add(txtPrecoAquisicao);
		
		JLabel lblNewLabel_4 = new JLabel("Preco de Venda");
		lblNewLabel_4.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		lblNewLabel_4.setBounds(81, 167, 98, 14);
		panel_1.add(lblNewLabel_4);
		
		txtPrecoVenda = new JTextField();
		txtPrecoVenda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblPrecoVenda.setText(txtPrecoVenda.getText());
			}
		});
		txtPrecoVenda.setColumns(10);
		txtPrecoVenda.setBounds(202, 164, 86, 20);
		panel_1.add(txtPrecoVenda);
		
		JLabel lblNewLabel_5 = new JLabel("Quantidade");
		lblNewLabel_5.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		lblNewLabel_5.setBounds(81, 224, 68, 14);
		panel_1.add(lblNewLabel_5);
		
		txtQuantidade = new JTextField();
		txtQuantidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblQuantidade.setText(txtQuantidade.getText());
			}
		});
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(202, 222, 86, 20);
		panel_1.add(txtQuantidade);
		
		JLabel lblNewLabel_6 = new JLabel("Fornecedor");
		lblNewLabel_6.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		lblNewLabel_6.setBounds(81, 111, 76, 14);
		panel_1.add(lblNewLabel_6);
		
		JComboBox cbFornecedor = new JComboBox();
		cbFornecedor.setBackground(new Color(255, 255, 255));
		cbFornecedor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				indexFornecedor=cbFornecedor.getSelectedIndex();
				
				if(indexFornecedor >=0 || indexFornecedor==0) {
					btnRegistar.setEnabled(true);
				}else{
					btnRegistar.setEnabled(false);
				}
			}
		});
		cbFornecedor.setModel(new DefaultComboBoxModel(Bd.comboFornecedor2()));
		cbFornecedor.setBounds(202, 107, 261, 22);
		panel_1.add(cbFornecedor);
		
		JLabel lblNewLabel_7 = new JLabel("Validade");
		lblNewLabel_7.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		lblNewLabel_7.setBounds(81, 194, 76, 14);
		panel_1.add(lblNewLabel_7);
		
		txtDataFabrico = new JTextField();
		txtDataFabrico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblDataFabrico.setText(txtDataFabrico.getText());
				
				if(txtDataFabrico.getText().length()==2) {
					txtDataFabrico.setText(txtDataFabrico.getText()+"/");
				}else if(txtDataFabrico.getText().length()==5){
					txtDataFabrico.setText(txtDataFabrico.getText()+"/");
				}else if(txtDataFabrico.getText().length()>10) {
					btnRegistar.setEnabled(false);
					txtDataFabrico.setForeground(Color.red);
				}else if(txtDataFabrico.getText().length()==10) {
					btnRegistar.setEnabled(true);
					txtDataFabrico.setForeground(Color.black);
				}
			}
		});
		txtDataFabrico.setToolTipText("Data de Emissao");
		txtDataFabrico.setColumns(10);
		txtDataFabrico.setBounds(202, 191, 128, 20);
		panel_1.add(txtDataFabrico);
		
		txtDataExpira = new JTextField();
		txtDataExpira.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblDataExpira.setText(txtDataExpira.getText());
				
				if(txtDataExpira.getText().length()==2) {
					txtDataExpira.setText(txtDataExpira.getText()+"/");
				}else if(txtDataExpira.getText().length()==5){
					txtDataExpira.setText(txtDataExpira.getText()+"/");
				}else if(txtDataExpira.getText().length()>10) {
					btnRegistar.setEnabled(false);
					txtDataExpira.setForeground(Color.red);
				}else if(txtDataExpira.getText().length()==10) {
					btnRegistar.setEnabled(true);
					txtDataExpira.setForeground(Color.black);
				}
			}
		});
		txtDataExpira.setToolTipText("Data que Expira");
		txtDataExpira.setColumns(10);
		txtDataExpira.setBounds(340, 191, 123, 20);
		panel_1.add(txtDataExpira);
		
		JButton btnLimpar = new JButton("CANCELAR");
		btnLimpar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpar.setBackground(new Color(255, 255, 255));
		btnLimpar.setBounds(202, 285, 128, 34);
		panel_1.add(btnLimpar);
		
		btnRegistar = new JButton("REGISTAR");
		btnRegistar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnRegistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					double precoA= Double.parseDouble(txtPrecoAquisicao.getText());
					double precoV= Double.parseDouble(txtPrecoVenda.getText());
					int quantidade= Integer.parseInt(txtQuantidade.getText());
					
					ArrayList<Fornecedor> fornecedores=Bd.listarFornecedores1();
					
					Fornecedor fornecedorObject= new Fornecedor(fornecedores.get(indexFornecedor).getCodigo(), fornecedores.get(indexFornecedor).getNomeDoFornecedor(), fornecedores.get(indexFornecedor).getNumeroDofornecedor(),fornecedores.get(indexFornecedor).getEndereco());
					
					Produto.registoProduto(txtNomeProduto.getText(), categoria, precoA, precoV, txtDataFabrico.getText(), txtDataExpira.getText(), fornecedorObject, quantidade);
				
					tabelaEditar.setModel(new DefaultTableModel(
							Bd.tabelaProduto(),
							new String[] {
								"#CODIGO", "NOME DO PRODUTO", "CATEGORIA", "PRECO DE AQUISICAO", "PRECO DE VENDA", "DATA DE FABRICO", "DATA EXPIRA", "LOTE", "FORNECEDOR", "QUANTIDADE"
							}
						));
					tabelaRemover.setModel(new DefaultTableModel(
							Bd.tabelaProduto(),
							new String[] {
								"#CODIGO", "NOME DO PRODUTO", "CATEGORIA", "PRECO DE AQUISICAO", "PRECO DE VENDA", "DATA DE FABRICO", "DATA EXPIRA", "LOTE", "FORNECEDOR", "QUANTIDADE"
							}
						));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("Erro");
					e1.printStackTrace();
				}catch (Exception e2) {
					// TODO: handle exception
					System.out.println("Erro Erro");
				}
				
				txtDataExpira.setText("");
				txtDataFabrico.setText("");
				txtNomeProduto.setText("");
				txtPrecoAquisicao.setText("");
				txtPrecoVenda.setText("");
				txtQuantidade.setText("");
			}
		});
		btnRegistar.setBackground(new Color(255, 255, 255));
		btnRegistar.setBounds(340, 285, 128, 34);
		btnRegistar.setEnabled(false);
		panel_1.add(btnRegistar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 69, 0));
		panel_2.setBounds(0, 0, 830, 431);
		registarProduto.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Nome do Produto:");
		lblNewLabel_8.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBackground(new Color(255, 255, 255));
		lblNewLabel_8.setBounds(10, 131, 101, 14);
		panel_2.add(lblNewLabel_8);
		
		lblNomeProduto = new JLabel("..............................");
		lblNomeProduto.setForeground(Color.WHITE);
		lblNomeProduto.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNomeProduto.setBackground(Color.WHITE);
		lblNomeProduto.setBounds(117, 131, 107, 14);
		panel_2.add(lblNomeProduto);
		
		JLabel lblNewLabel_8_2 = new JLabel("Categoria");
		lblNewLabel_8_2.setForeground(Color.WHITE);
		lblNewLabel_8_2.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_8_2.setBackground(Color.WHITE);
		lblNewLabel_8_2.setBounds(10, 156, 101, 14);
		panel_2.add(lblNewLabel_8_2);
		
		lblCategoria = new JLabel("..............................");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblCategoria.setBackground(Color.WHITE);
		lblCategoria.setBounds(117, 156, 107, 14);
		panel_2.add(lblCategoria);
		
		JLabel lblNewLabel_8_4 = new JLabel("Preço de Aquisição");
		lblNewLabel_8_4.setForeground(Color.WHITE);
		lblNewLabel_8_4.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_8_4.setBackground(Color.WHITE);
		lblNewLabel_8_4.setBounds(10, 181, 101, 14);
		panel_2.add(lblNewLabel_8_4);
		
		lblPrecoAquisicao = new JLabel("..............................");
		lblPrecoAquisicao.setForeground(Color.WHITE);
		lblPrecoAquisicao.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblPrecoAquisicao.setBackground(Color.WHITE);
		lblPrecoAquisicao.setBounds(117, 181, 107, 14);
		panel_2.add(lblPrecoAquisicao);
		
		JLabel lblNewLabel_8_5 = new JLabel("Preço de Venda:");
		lblNewLabel_8_5.setForeground(Color.WHITE);
		lblNewLabel_8_5.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_8_5.setBackground(Color.WHITE);
		lblNewLabel_8_5.setBounds(10, 206, 101, 14);
		panel_2.add(lblNewLabel_8_5);
		
		lblPrecoVenda = new JLabel("..............................");
		lblPrecoVenda.setForeground(Color.WHITE);
		lblPrecoVenda.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblPrecoVenda.setBackground(Color.WHITE);
		lblPrecoVenda.setBounds(117, 206, 107, 14);
		panel_2.add(lblPrecoVenda);
		
		JLabel lblNewLabel_8_6 = new JLabel("Data de Fabrico:");
		lblNewLabel_8_6.setForeground(Color.WHITE);
		lblNewLabel_8_6.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_8_6.setBackground(Color.WHITE);
		lblNewLabel_8_6.setBounds(10, 233, 101, 14);
		panel_2.add(lblNewLabel_8_6);
		
		lblDataFabrico = new JLabel("..............................");
		lblDataFabrico.setForeground(Color.WHITE);
		lblDataFabrico.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblDataFabrico.setBackground(Color.WHITE);
		lblDataFabrico.setBounds(117, 233, 107, 14);
		panel_2.add(lblDataFabrico);
		
		JLabel lblNewLabel_8_7 = new JLabel("Data que Expira:");
		lblNewLabel_8_7.setForeground(Color.WHITE);
		lblNewLabel_8_7.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_8_7.setBackground(Color.WHITE);
		lblNewLabel_8_7.setBounds(10, 259, 101, 14);
		panel_2.add(lblNewLabel_8_7);
		
		lblDataExpira = new JLabel("..............................");
		lblDataExpira.setForeground(Color.WHITE);
		lblDataExpira.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblDataExpira.setBackground(Color.WHITE);
		lblDataExpira.setBounds(117, 259, 107, 14);
		panel_2.add(lblDataExpira);
		
		JLabel lblNewLabel_8_8 = new JLabel("Quantidade:");
		lblNewLabel_8_8.setForeground(Color.WHITE);
		lblNewLabel_8_8.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_8_8.setBackground(Color.WHITE);
		lblNewLabel_8_8.setBounds(10, 287, 101, 14);
		panel_2.add(lblNewLabel_8_8);
		
		lblQuantidade = new JLabel("..............................");
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblQuantidade.setBackground(Color.WHITE);
		lblQuantidade.setBounds(117, 287, 107, 14);
		panel_2.add(lblQuantidade);
		
		JLabel lblNewLabel_2 = new JLabel("PRODUTO");
		lblNewLabel_2.setFont(new Font("Gill Sans MT", Font.BOLD, 25));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(38, 40, 148, 47);
		panel_2.add(lblNewLabel_2);
		
		JPanel editarProduto = new JPanel();
		tabbedPane.addTab("Editar Produto", null, editarProduto, null);
		editarProduto.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 830, 153);
		editarProduto.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3_4 = new JLabel("Nome do Produto");
		lblNewLabel_3_4.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		lblNewLabel_3_4.setBounds(20, 11, 107, 14);
		panel.add(lblNewLabel_3_4);
		
		txtNomeProdutoEditar = new JTextField();
		txtNomeProdutoEditar.setColumns(10);
		txtNomeProdutoEditar.setBounds(136, 7, 289, 22);
		panel.add(txtNomeProdutoEditar);
		
		txtPrecoAquisicaoEditar = new JTextField();
		txtPrecoAquisicaoEditar.setColumns(10);
		txtPrecoAquisicaoEditar.setBounds(137, 36, 107, 22);
		panel.add(txtPrecoAquisicaoEditar);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Preco de Aquisicao");
		lblNewLabel_3_1_1.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		lblNewLabel_3_1_1.setBounds(20, 40, 107, 14);
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_5_1 = new JLabel("Preco de Venda");
		lblNewLabel_3_5_1.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		lblNewLabel_3_5_1.setBounds(20, 69, 111, 14);
		panel.add(lblNewLabel_3_5_1);
		
		txtPrecoVendaEditar = new JTextField();
		txtPrecoVendaEditar.setColumns(10);
		txtPrecoVendaEditar.setBounds(137, 65, 107, 22);
		panel.add(txtPrecoVendaEditar);
		
		txtDataFabricoEditar = new JTextField();
		txtDataFabricoEditar.setColumns(10);
		txtDataFabricoEditar.setBounds(137, 93, 107, 22);
		panel.add(txtDataFabricoEditar);
		
		JLabel lblNewLabel_3_5_1_1 = new JLabel("Validade");
		lblNewLabel_3_5_1_1.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		lblNewLabel_3_5_1_1.setBounds(20, 97, 111, 14);
		panel.add(lblNewLabel_3_5_1_1);
		
		txtDaExpiraEditar = new JTextField();
		txtDaExpiraEditar.setColumns(10);
		txtDaExpiraEditar.setBounds(254, 93, 107, 22);
		panel.add(txtDaExpiraEditar);
		
		JLabel lblNewLabel_3_5_1_2 = new JLabel("Categoria");
		lblNewLabel_3_5_1_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_3_5_1_2.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		lblNewLabel_3_5_1_2.setBounds(459, 11, 111, 14);
		panel.add(lblNewLabel_3_5_1_2);
		
		JComboBox cbCategoriaEditar = new JComboBox();
		cbCategoriaEditar.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				categotiaEditar=(cbCategoriaEditar.getSelectedIndex()>0)? cbCategoriaEditar.getSelectedItem()+"" :"Nao definido";
			}
		});
		cbCategoriaEditar.setModel(new DefaultComboBoxModel(new String[] {"                              ---Selecione---", "Fruta", "Vegetal", "Carne", "Marisco", "Sabao", "Farinhas", "Refrigerante", "Chocolate", "Iogurte", "Cereal", "Bolacha", "Caneta", "Caderno", "Chips"}));
		cbCategoriaEditar.setBackground(new Color(255, 255, 255));
		cbCategoriaEditar.setBounds(534, 7, 255, 22);
		panel.add(cbCategoriaEditar);
		
		JComboBox cbFornecedorEditar = new JComboBox();
		cbFornecedorEditar.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				indexFornecedorEditar=cbFornecedorEditar.getSelectedIndex();
			}
		});
		cbFornecedorEditar.setBackground(new Color(255, 255, 255));
		cbFornecedorEditar.setModel(new DefaultComboBoxModel(Bd.comboFornecedor2()));
		cbFornecedorEditar.setBounds(534, 36, 255, 22);
		panel.add(cbFornecedorEditar);
		
		JLabel lblNewLabel_3_5_1_2_1 = new JLabel("Fornecedor");
		lblNewLabel_3_5_1_2_1.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		lblNewLabel_3_5_1_2_1.setBounds(459, 40, 111, 18);
		panel.add(lblNewLabel_3_5_1_2_1);
		
		txtQuantidadeEditar = new JTextField();
		txtQuantidadeEditar.setColumns(10);
		txtQuantidadeEditar.setBounds(137, 120, 107, 22);
		panel.add(txtQuantidadeEditar);
		
		JLabel lblNewLabel_3_5_1_1_1 = new JLabel("Quantidade");
		lblNewLabel_3_5_1_1_1.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		lblNewLabel_3_5_1_1_1.setBounds(20, 124, 111, 14);
		panel.add(lblNewLabel_3_5_1_1_1);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEditar.setBackground(new Color(255, 255, 255));
		btnEditar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				linhaTabela= tabelaEditar.getSelectedRow();
				String codigo=tabelaEditar.getValueAt(linhaTabela, 0)+"";
				double precoA= Double.parseDouble(txtPrecoAquisicaoEditar.getText());
				double precoV= Double.parseDouble(txtPrecoVendaEditar.getText());
				ArrayList<Fornecedor> listaFornecedor=Bd.listarFornecedores1();
				int quantidade= Integer.parseInt(txtQuantidadeEditar.getText());
				Fornecedor fornecedor= new Fornecedor(listaFornecedor.get(indexFornecedorEditar).getCodigo(),listaFornecedor.get(indexFornecedorEditar).getNomeDoFornecedor(), listaFornecedor.get(indexFornecedorEditar).getNumeroDofornecedor(),listaFornecedor.get(indexFornecedorEditar).getEndereco());
				Produto.edicarProduto(codigo, txtNomeProdutoEditar.getText(), categotiaEditar, precoA,precoV, txtDataFabricoEditar.getText(), txtDaExpiraEditar.getText(), fornecedor.toString1(), quantidade);
				
				tabelaEditar.setModel(new DefaultTableModel(
						Bd.tabelaProduto(),
						new String[] {
							"#CODIGO", "NOME DO PRODUTO", "CATEGORIA", "PRECO DE AQUISICAO", "PRECO DE VENDA", "DATA DE FABRICO", "DATA EXPIRA", "LOTE", "FORNECEDOR", "QUANTIDADE"
						}
					));
				tabelaRemover.setModel(new DefaultTableModel(
						Bd.tabelaProduto(),
						new String[] {
							"#CODIGO", "NOME DO PRODUTO", "CATEGORIA", "PRECO DE AQUISICAO", "PRECO DE VENDA", "DATA DE FABRICO", "DATA EXPIRA", "LOTE", "FORNECEDOR", "QUANTIDADE"
						}
					));
			}
		});
		btnEditar.setBounds(634, 108, 109, 34);
		panel.add(btnEditar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setBounds(515, 108, 109, 34);
		panel.add(btnCancelar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 166, 830, 265);
		editarProduto.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane);
		
		tabelaEditar = new JTable();
		tabelaEditar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				linhaTabela=tabelaEditar.getSelectedRow();
				
				txtNomeProdutoEditar.setText(tabelaEditar.getValueAt(linhaTabela, 1)+"");
				txtPrecoAquisicaoEditar.setText(tabelaEditar.getValueAt(linhaTabela, 3)+"");
				txtPrecoVendaEditar.setText(tabelaEditar.getValueAt(linhaTabela, 4)+"");
				txtDataFabricoEditar.setText(tabelaEditar.getValueAt(linhaTabela, 5)+"");
				txtDaExpiraEditar.setText(tabelaEditar.getValueAt(linhaTabela, 6)+"");
				txtQuantidadeEditar.setText(tabelaEditar.getValueAt(linhaTabela, 9)+"");
				
			}
		});
		scrollPane.setViewportView(tabelaEditar);
		tabelaEditar.setModel(new DefaultTableModel(
			Bd.tabelaProduto(),
			new String[] {
				"#CODIGO", "NOME DO PRODUTO", "CATEGORIA", "PRECO DE AQUISICAO", "PRECO DE VENDA", "DATA DE FABRICO", "DATA EXPIRA", "LOTE", "FORNECEDOR", "QUANTIDADE"
			}
		));
		tabelaEditar.getColumnModel().getColumn(3).setPreferredWidth(107);
		tabelaEditar.getColumnModel().getColumn(4).setPreferredWidth(103);
		
		JPanel removerProduto = new JPanel();
		tabbedPane.addTab("Remover Produto", null, removerProduto, null);
		removerProduto.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(255, 69, 0));
		panel_2_1.setBounds(0, 0, 830, 165);
		removerProduto.add(panel_2_1);
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				linhaTabela= tabelaRemover.getSelectedRow();
				String codigo= tabelaRemover.getValueAt(linhaTabela, 0)+"";
				Produto.removerProduto(codigo);
				tabelaEditar.setModel(new DefaultTableModel(
						Bd.tabelaProduto(),
						new String[] {
							"#CODIGO", "NOME DO PRODUTO", "CATEGORIA", "PRECO DE AQUISICAO", "PRECO DE VENDA", "DATA DE FABRICO", "DATA EXPIRA", "LOTE", "FORNECEDOR", "QUANTIDADE"
						}
					));
				tabelaRemover.setModel(new DefaultTableModel(
						Bd.tabelaProduto(),
						new String[] {
							"#CODIGO", "NOME DO PRODUTO", "CATEGORIA", "PRECO DE AQUISICAO", "PRECO DE VENDA", "DATA DE FABRICO", "DATA EXPIRA", "LOTE", "FORNECEDOR", "QUANTIDADE"
						}
					));
			}
		});
		btnRemover.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnRemover.setBackground(Color.WHITE);
		btnRemover.setBounds(520, 65, 118, 34);
		panel_2_1.add(btnRemover);
		
		JLabel lblNomeProdutoRemove = new JLabel("Nome do Produto:");
		lblNomeProdutoRemove.setForeground(Color.WHITE);
		lblNomeProdutoRemove.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNomeProdutoRemove.setBackground(Color.WHITE);
		lblNomeProdutoRemove.setBounds(32, 101, 101, 14);
		panel_2_1.add(lblNomeProdutoRemove);
		
		JLabel lblNewLabel_8_2_1 = new JLabel("Categoria");
		lblNewLabel_8_2_1.setForeground(Color.WHITE);
		lblNewLabel_8_2_1.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_8_2_1.setBackground(Color.WHITE);
		lblNewLabel_8_2_1.setBounds(185, 5, 101, 14);
		panel_2_1.add(lblNewLabel_8_2_1);
		
		JLabel lblCategoritaRemove = new JLabel("..............................");
		lblCategoritaRemove.setForeground(Color.WHITE);
		lblCategoritaRemove.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblCategoritaRemove.setBackground(Color.WHITE);
		lblCategoritaRemove.setBounds(297, 5, 172, 14);
		panel_2_1.add(lblCategoritaRemove);
		
		JLabel lblNewLabel_8_4_1 = new JLabel("Preço de Aquisição");
		lblNewLabel_8_4_1.setForeground(Color.WHITE);
		lblNewLabel_8_4_1.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_8_4_1.setBackground(Color.WHITE);
		lblNewLabel_8_4_1.setBounds(185, 22, 101, 14);
		panel_2_1.add(lblNewLabel_8_4_1);
		
		JLabel lblPrecoAquisicaoRemove = new JLabel("..............................");
		lblPrecoAquisicaoRemove.setForeground(Color.WHITE);
		lblPrecoAquisicaoRemove.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblPrecoAquisicaoRemove.setBackground(Color.WHITE);
		lblPrecoAquisicaoRemove.setBounds(297, 22, 172, 14);
		panel_2_1.add(lblPrecoAquisicaoRemove);
		
		JLabel lblNewLabel_8_5_1 = new JLabel("Preço de Venda:");
		lblNewLabel_8_5_1.setForeground(Color.WHITE);
		lblNewLabel_8_5_1.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_8_5_1.setBackground(Color.WHITE);
		lblNewLabel_8_5_1.setBounds(185, 43, 101, 14);
		panel_2_1.add(lblNewLabel_8_5_1);
		
		JLabel lblPrecoVendaremove = new JLabel("..............................");
		lblPrecoVendaremove.setForeground(Color.WHITE);
		lblPrecoVendaremove.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblPrecoVendaremove.setBackground(Color.WHITE);
		lblPrecoVendaremove.setBounds(297, 43, 172, 14);
		panel_2_1.add(lblPrecoVendaremove);
		
		JLabel lblNewLabel_8_6_1 = new JLabel("Data de Fabrico:");
		lblNewLabel_8_6_1.setForeground(Color.WHITE);
		lblNewLabel_8_6_1.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_8_6_1.setBackground(Color.WHITE);
		lblNewLabel_8_6_1.setBounds(185, 66, 101, 14);
		panel_2_1.add(lblNewLabel_8_6_1);
		
		JLabel lblDataFabricoremove = new JLabel("..............................");
		lblDataFabricoremove.setForeground(Color.WHITE);
		lblDataFabricoremove.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblDataFabricoremove.setBackground(Color.WHITE);
		lblDataFabricoremove.setBounds(297, 66, 172, 14);
		panel_2_1.add(lblDataFabricoremove);
		
		JLabel lblNewLabel_8_7_1 = new JLabel("Data que Expira:");
		lblNewLabel_8_7_1.setForeground(Color.WHITE);
		lblNewLabel_8_7_1.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_8_7_1.setBackground(Color.WHITE);
		lblNewLabel_8_7_1.setBounds(185, 89, 101, 14);
		panel_2_1.add(lblNewLabel_8_7_1);
		
		JLabel lblDtaExpiraRemove = new JLabel("..............................");
		lblDtaExpiraRemove.setForeground(Color.WHITE);
		lblDtaExpiraRemove.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblDtaExpiraRemove.setBackground(Color.WHITE);
		lblDtaExpiraRemove.setBounds(297, 89, 172, 14);
		panel_2_1.add(lblDtaExpiraRemove);
		
		JLabel lblNewLabel_8_8_1 = new JLabel("Quantidade:");
		lblNewLabel_8_8_1.setForeground(Color.WHITE);
		lblNewLabel_8_8_1.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_8_8_1.setBackground(Color.WHITE);
		lblNewLabel_8_8_1.setBounds(185, 143, 101, 14);
		panel_2_1.add(lblNewLabel_8_8_1);
		
		JLabel lblQuantidadeRemove = new JLabel("..............................");
		lblQuantidadeRemove.setForeground(Color.WHITE);
		lblQuantidadeRemove.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblQuantidadeRemove.setBackground(Color.WHITE);
		lblQuantidadeRemove.setBounds(297, 143, 172, 14);
		panel_2_1.add(lblQuantidadeRemove);
		
		JLabel lblNewLabel_2_1 = new JLabel("PRODUTO");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Gill Sans MT", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(10, 30, 148, 47);
		panel_2_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_8_8_1_1 = new JLabel("Lote:");
		lblNewLabel_8_8_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_8_1_1.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_8_8_1_1.setBackground(Color.WHITE);
		lblNewLabel_8_8_1_1.setBounds(185, 108, 101, 14);
		panel_2_1.add(lblNewLabel_8_8_1_1);
		
		JLabel lblLoteRemove = new JLabel("..............................");
		lblLoteRemove.setForeground(Color.WHITE);
		lblLoteRemove.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblLoteRemove.setBackground(Color.WHITE);
		lblLoteRemove.setBounds(297, 108, 172, 14);
		panel_2_1.add(lblLoteRemove);
		
		JLabel lblNewLabel_8_8_1_2 = new JLabel("Fornecedor:");
		lblNewLabel_8_8_1_2.setForeground(Color.WHITE);
		lblNewLabel_8_8_1_2.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_8_8_1_2.setBackground(Color.WHITE);
		lblNewLabel_8_8_1_2.setBounds(185, 125, 101, 14);
		panel_2_1.add(lblNewLabel_8_8_1_2);
		
		JLabel lblFornecedorRemove = new JLabel("..............................");
		lblFornecedorRemove.setForeground(Color.WHITE);
		lblFornecedorRemove.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblFornecedorRemove.setBackground(Color.WHITE);
		lblFornecedorRemove.setBounds(297, 125, 172, 14);
		panel_2_1.add(lblFornecedorRemove);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(0, 166, 830, 265);
		removerProduto.add(panel_1_1);
		panel_1_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1_1.add(scrollPane_1);
		
		tabelaRemover = new JTable();
		tabelaRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				linhaTabela= tabelaRemover.getSelectedRow();
				lblNomeProdutoRemove.setText(tabelaRemover.getValueAt(linhaTabela, 1)+"");
				lblCategoritaRemove.setText(tabelaRemover.getValueAt(linhaTabela, 2)+"");
				lblPrecoAquisicaoRemove.setText(tabelaRemover.getValueAt(linhaTabela, 3)+"");
				lblPrecoVendaremove.setText(tabelaRemover.getValueAt(linhaTabela, 4)+"");
				lblDataFabricoremove.setText(tabelaRemover.getValueAt(linhaTabela, 5)+"");
				lblDtaExpiraRemove.setText(tabelaRemover.getValueAt(linhaTabela, 6)+"");
				lblLoteRemove.setText(tabelaRemover.getValueAt(linhaTabela, 7)+"");
				lblFornecedorRemove.setText(tabelaRemover.getValueAt(linhaTabela, 8)+"");
				lblQuantidadeRemove.setText(tabelaRemover.getValueAt(linhaTabela, 9)+"");
			}
		});
		tabelaRemover.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(tabelaRemover);
		tabelaRemover.setModel(new DefaultTableModel(
				Bd.tabelaProduto(),
				new String[] {
					"#CODIGO", "NOME DO PRODUTO", "CATEGORIA", "PRECO DE AQUISICAO", "PRECO DE VENDA", "DATA DE FABRICO", "DATA EXPIRA", "LOTE", "FORNECEDOR", "QUANTIDADE"
				}
			));
	}
}
