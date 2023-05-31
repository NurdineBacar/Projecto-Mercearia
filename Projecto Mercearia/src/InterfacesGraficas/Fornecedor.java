package InterfacesGraficas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BD.Bd;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeFornecedor;
	private JTextField txtNumeroFornecedor;
	private JTextField txtEnderecoFornecedor;
	private JTextField txtNomeFornecedorEditar;
	private JTextField txtNumeroFornecedorEditar;
	private JTextField txtEnderecoFornecedorEditar;
	private JTable tabelaEditar;
	private int linhaTabela;
	private JButton btnEditar;
	private JTable tabelaRemover;
	private JLabel lblEnderecoFornecedorRemover,lblNomeFornecedorRemover, lblNumeroFornecedorRemover;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fornecedor frame = new Fornecedor();
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
	public Fornecedor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 593, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 577, 407);
		contentPane.add(tabbedPane);
		
		JPanel regsito = new JPanel();
		regsito.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Registo do Fornecedor", null, regsito, null);
		regsito.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 69, 0));
		panel_1.setBounds(0, 0, 229, 379);
		regsito.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Edma\\eclipse-workspace\\Projecto Mercearia\\user.png"));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Gill Sans MT", Font.BOLD, 29));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(60, 24, 100, 111);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nome:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 146, 46, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Numero:");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_5.setBounds(10, 194, 62, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Endereco: ");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_6.setBounds(10, 251, 62, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNomeFornecedor = new JLabel("...........................");
		lblNomeFornecedor.setForeground(new Color(255, 255, 255));
		lblNomeFornecedor.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNomeFornecedor.setBounds(72, 146, 139, 14);
		panel_1.add(lblNomeFornecedor);
		
		JLabel lblNumeroFornecedor = new JLabel("...........................");
		lblNumeroFornecedor.setForeground(new Color(255, 255, 255));
		lblNumeroFornecedor.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNumeroFornecedor.setBounds(72, 194, 139, 14);
		panel_1.add(lblNumeroFornecedor);
		
		JLabel lblEnderecoFornecedor = new JLabel("...........................");
		lblEnderecoFornecedor.setForeground(new Color(255, 255, 255));
		lblEnderecoFornecedor.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblEnderecoFornecedor.setBounds(72, 251, 139, 14);
		panel_1.add(lblEnderecoFornecedor);
		
		JLabel lblNewLabel = new JLabel("Nome do Fornecedor");
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel.setBounds(256, 53, 180, 14);
		regsito.add(lblNewLabel);
		
		txtNomeFornecedor = new JTextField();
		txtNomeFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblNomeFornecedor.setText(txtNomeFornecedor.getText());
			}
		});
		txtNomeFornecedor.setBounds(256, 78, 295, 24);
		regsito.add(txtNomeFornecedor);
		txtNomeFornecedor.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Numero do Fornecedor\t");
		lblNewLabel_1.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_1.setBounds(256, 117, 180, 14);
		regsito.add(lblNewLabel_1);
		
		txtNumeroFornecedor = new JTextField();
		txtNumeroFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblNumeroFornecedor.setText(txtNumeroFornecedor.getText());
			}
		});
		txtNumeroFornecedor.setColumns(10);
		txtNumeroFornecedor.setBounds(256, 135, 295, 24);
		regsito.add(txtNumeroFornecedor);
		
		JLabel lblNewLabel_2 = new JLabel("Endereco Do Fornecedor");
		lblNewLabel_2.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_2.setBounds(256, 174, 180, 14);
		regsito.add(lblNewLabel_2);
		
		txtEnderecoFornecedor = new JTextField();
		txtEnderecoFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblEnderecoFornecedor.setText(txtEnderecoFornecedor.getText());
			}
		});
		txtEnderecoFornecedor.setColumns(10);
		txtEnderecoFornecedor.setBounds(256, 199, 295, 24);
		regsito.add(txtEnderecoFornecedor);
		
		JButton btnRegistar = new JButton("REGISTAR");
		btnRegistar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnRegistar.setBackground(new Color(255, 255, 255));
		btnRegistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClasseDeObjecto.Fornecedor.registoFornecedor(txtNomeFornecedor.getText(), txtNumeroFornecedor.getText(), txtEnderecoFornecedor.getText());
				
				try {
					tabelaEditar.setModel(new DefaultTableModel(
							Bd.tabelaFornecedores(),new String[] {
									"#CODIGO", "NOME DO FORNECEDOR", "N\u00BA DE TELEFONE", "ENDERECO"
							}
							));
					tabelaRemover.setModel(new DefaultTableModel(
							Bd.tabelaFornecedores(),
							new String[] {
								"#CODIGO", "NOME DO FORNECEDOR", "N\u00BA DO FORNECEDOR", "ENDERECO"
							}
							));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtEnderecoFornecedor.setText("");
				txtNomeFornecedor.setText("");
				txtNumeroFornecedor.setText("");
				lblEnderecoFornecedor.setText("........................");
				lblNomeFornecedor.setText("........................");
				lblNumeroFornecedor.setText("........................");
			}
		});
		btnRegistar.setBounds(448, 264, 103, 30);
		regsito.add(btnRegistar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEnderecoFornecedor.setText("");
				txtNomeFornecedor.setText("");
				txtNumeroFornecedor.setText("");
				lblEnderecoFornecedor.setText("........................");
				lblNomeFornecedor.setText("........................");
				lblNumeroFornecedor.setText("........................");
			}
		});
		btnCancelar.setBounds(333, 264, 103, 30);
		regsito.add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Editar Fornecedor", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Nome do Fornecedor");
		lblNewLabel_7.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_7.setBounds(30, 23, 180, 14);
		panel.add(lblNewLabel_7);
		
		txtNomeFornecedorEditar = new JTextField();
		txtNomeFornecedorEditar.setColumns(10);
		txtNomeFornecedorEditar.setBounds(183, 18, 347, 24);
		panel.add(txtNomeFornecedorEditar);
		
		JLabel lblNewLabel_1_1 = new JLabel("Numero do Fornecedor\t");
		lblNewLabel_1_1.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(30, 59, 180, 14);
		panel.add(lblNewLabel_1_1);
		
		txtNumeroFornecedorEditar = new JTextField();
		txtNumeroFornecedorEditar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtNumeroFornecedorEditar.getText().contains(" ") || txtNumeroFornecedorEditar.getText().length()>9) {
					txtNumeroFornecedorEditar.setForeground(Color.RED);
					btnEditar.setEnabled(false);
				}else {
					txtNumeroFornecedorEditar.setForeground(Color.black);
					btnEditar.setEnabled(true);
				}
			}
		});
		txtNumeroFornecedorEditar.setColumns(10);
		txtNumeroFornecedorEditar.setBounds(183, 54, 347, 24);
		panel.add(txtNumeroFornecedorEditar);
		
		JLabel lblNewLabel_2_1 = new JLabel("Endereco Do Fornecedor");
		lblNewLabel_2_1.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(30, 96, 180, 14);
		panel.add(lblNewLabel_2_1);
		
		txtEnderecoFornecedorEditar = new JTextField();
		txtEnderecoFornecedorEditar.setColumns(10);
		txtEnderecoFornecedorEditar.setBounds(183, 91, 347, 24);
		panel.add(txtEnderecoFornecedorEditar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				linhaTabela=  tabelaEditar.getSelectedRow();
				String codigo = tabelaEditar.getValueAt(linhaTabela, 0)+"";
				ClasseDeObjecto.Fornecedor.editarFornecedor(codigo, txtNomeFornecedorEditar.getText(), txtNumeroFornecedorEditar.getText(), txtEnderecoFornecedorEditar.getText());
				try {
					tabelaEditar.setModel(new DefaultTableModel(
							Bd.tabelaFornecedores(),new String[] {
									"#CODIGO", "NOME DO FORNECEDOR", "N\u00BA DE TELEFONE", "ENDERECO"
							}
							));
					tabelaRemover.setModel(new DefaultTableModel(
							Bd.tabelaFornecedores(),
							new String[] {
								"#CODIGO", "NOME DO FORNECEDOR", "N\u00BA DO FORNECEDOR", "ENDERECO"
							}
							));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				txtEnderecoFornecedorEditar.setText("");
				txtNomeFornecedorEditar.setText("");
				txtNumeroFornecedorEditar.setText("");
			}
		});
		btnEditar.setBackground(new Color(255, 255, 255));
		btnEditar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEditar.setBounds(431, 126, 101, 23);
		panel.add(btnEditar);
		
		JButton btnCancelarEditar = new JButton("CANCELAR");
		btnCancelarEditar.setBackground(new Color(255, 255, 255));
		btnCancelarEditar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnCancelarEditar.setBounds(305, 126, 110, 23);
		panel.add(btnCancelarEditar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 167, 572, 212);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
		
		tabelaEditar = new JTable();
		tabelaEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				linhaTabela=  tabelaEditar.getSelectedRow();
				//String codigo = tabelaEditar.getValueAt(linhaTabela, 0)+"";
			//	ClasseDeObjecto.Fornecedor.editarFornecedor(codigo, txtNomeFornecedorEditar.getText(), txtNomeFornecedorEditar.getText(), txtEnderecoFornecedorEditar.getText());
				
				txtEnderecoFornecedorEditar.setText(tabelaEditar.getValueAt(linhaTabela, 3)+"");
				txtNomeFornecedorEditar.setText(tabelaEditar.getValueAt(linhaTabela, 1)+"");
				txtNumeroFornecedorEditar.setText(tabelaEditar.getValueAt(linhaTabela, 2)+"");
					
			}
		});
		scrollPane.setViewportView(tabelaEditar);
		try {
			tabelaEditar.setModel(new DefaultTableModel(
				Bd.tabelaFornecedores(),
				new String[] {
					"#CODIGO", "NOME DO FORNECEDOR", "N\u00BA DE TELEFONE", "ENDERECO"
				}
			));
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(255, 69, 0));
			tabbedPane.addTab("Remover Fornecedor", null, panel_3, null);
			panel_3.setLayout(null);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBounds(0, 153, 572, 226);
			panel_3.add(panel_4);
			panel_4.setLayout(new GridLayout(1, 0, 0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			panel_4.add(scrollPane_1);
			
			tabelaRemover = new JTable();
			tabelaRemover.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					linhaTabela = tabelaRemover.getSelectedRow();
					lblNomeFornecedorRemover.setText(tabelaRemover.getValueAt(linhaTabela, 1)+"");
					lblNumeroFornecedorRemover.setText(tabelaRemover.getValueAt(linhaTabela, 2)+"");
					lblEnderecoFornecedorRemover.setText(tabelaRemover.getValueAt(linhaTabela, 3)+"");
					
				}
			});
			scrollPane_1.setViewportView(tabelaRemover);
			tabelaRemover.setModel(new DefaultTableModel(
					Bd.tabelaFornecedores(),
				new String[] {
					"#CODIGO", "NOME DO FORNECEDOR", "N\u00BA DO FORNECEDOR", "ENDERECO"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			tabelaRemover.getColumnModel().getColumn(1).setPreferredWidth(186);
			tabelaRemover.getColumnModel().getColumn(2).setPreferredWidth(173);
			tabelaRemover.getColumnModel().getColumn(3).setPreferredWidth(195);
			
			JLabel lblNewLabel_8 = new JLabel("New label");
			lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Edma\\eclipse-workspace\\Projecto Mercearia\\user.png"));
			lblNewLabel_8.setBounds(41, 11, 102, 100);
			panel_3.add(lblNewLabel_8);
			
			lblNomeFornecedorRemover = new JLabel("Nome do Forncedor");
			lblNomeFornecedorRemover.setForeground(new Color(255, 255, 255));
			lblNomeFornecedorRemover.setBackground(new Color(255, 255, 255));
			lblNomeFornecedorRemover.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			lblNomeFornecedorRemover.setHorizontalAlignment(SwingConstants.CENTER);
			lblNomeFornecedorRemover.setBounds(10, 122, 168, 14);
			panel_3.add(lblNomeFornecedorRemover);
			
			JLabel lblNewLabel_5_1 = new JLabel("Numero:");
			lblNewLabel_5_1.setForeground(Color.WHITE);
			lblNewLabel_5_1.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
			lblNewLabel_5_1.setBounds(157, 39, 62, 14);
			panel_3.add(lblNewLabel_5_1);
			
			lblNumeroFornecedorRemover = new JLabel("...........................");
			lblNumeroFornecedorRemover.setForeground(Color.WHITE);
			lblNumeroFornecedorRemover.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
			lblNumeroFornecedorRemover.setBounds(219, 39, 139, 14);
			panel_3.add(lblNumeroFornecedorRemover);
			
			JLabel lblNewLabel_6_1 = new JLabel("Endereco: ");
			lblNewLabel_6_1.setForeground(Color.WHITE);
			lblNewLabel_6_1.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
			lblNewLabel_6_1.setBounds(157, 68, 62, 14);
			panel_3.add(lblNewLabel_6_1);
			
			lblEnderecoFornecedorRemover = new JLabel("...........................");
			lblEnderecoFornecedorRemover.setForeground(Color.WHITE);
			lblEnderecoFornecedorRemover.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
			lblEnderecoFornecedorRemover.setBounds(219, 68, 139, 14);
			panel_3.add(lblEnderecoFornecedorRemover);
			
			JButton btnNewButton = new JButton("REMOVER");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						linhaTabela= tabelaRemover.getSelectedRow();
						String codigo= tabelaRemover.getValueAt(linhaTabela, 0)+"";
						ClasseDeObjecto.Fornecedor.removerFornecedor(codigo);
						tabelaEditar.setModel(new DefaultTableModel(
								Bd.tabelaFornecedores(),new String[] {
										"#CODIGO", "NOME DO FORNECEDOR", "N\u00BA DE TELEFONE", "ENDERECO"
								}
								));
						tabelaRemover.setModel(new DefaultTableModel(
								Bd.tabelaFornecedores(),
								new String[] {
									"#CODIGO", "NOME DO FORNECEDOR", "N\u00BA DO FORNECEDOR", "ENDERECO"
								}
								));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			btnNewButton.setBounds(420, 54, 102, 41);
			panel_3.add(btnNewButton);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tabelaEditar.getColumnModel().getColumn(1).setPreferredWidth(206);
		tabelaEditar.getColumnModel().getColumn(2).setPreferredWidth(187);
		tabelaEditar.getColumnModel().getColumn(3).setPreferredWidth(181);
	}
}
