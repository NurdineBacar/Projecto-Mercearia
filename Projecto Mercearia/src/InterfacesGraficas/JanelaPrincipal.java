package InterfacesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblHoras;
	public JanelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 453);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 0, 0));
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Ficheiros");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem itemUsuario = new JMenuItem("Gestao Usuario");
		itemUsuario.setForeground(new Color(255, 255, 255));
		itemUsuario.setBackground(new Color(0, 0, 0));
		itemUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Usuario_Cadastro_UI().setVisible(true);
				//close();
			}
		});
		itemUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(itemUsuario);
		
		JMenuItem itemProduto = new JMenuItem("Gestao Produto");
		itemProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Produto_UI().setVisible(true);
			}
		});
		itemProduto.setForeground(new Color(255, 255, 255));
		itemProduto.setBackground(new Color(0, 0, 0));
		itemProduto.setFont(new Font("Segoe UI", Font.BOLD, 14));
		itemProduto.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(itemProduto);
		
		JMenuItem itemFornecedor = new JMenuItem("Gestao Fornecedor");
		itemFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fornecedor().setVisible(true);
			}
		});
		itemFornecedor.setForeground(new Color(255, 255, 255));
		itemFornecedor.setBackground(new Color(0, 0, 0));
		itemFornecedor.setFont(new Font("Segoe UI", Font.BOLD, 14));
		itemFornecedor.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(itemFornecedor);
		
		JMenuItem itemVenda = new JMenuItem("Venda");
		itemVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Venda_UI venda= new Venda_UI();
				venda.setVisible(true);
				venda.setLocationRelativeTo(null);
			}
		});
		itemVenda.setForeground(new Color(255, 255, 255));
		itemVenda.setBackground(new Color(0, 0, 0));
		itemVenda.setHorizontalAlignment(SwingConstants.LEFT);
		itemVenda.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(itemVenda);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblHoras = new JLabel("New label");
		lblHoras.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblHoras, BorderLayout.NORTH);
		
		Date data= new Date();
		Locale lang= new Locale("pt","BR");
		SimpleDateFormat  newData= new SimpleDateFormat("dd 'de' MMMM 'de' YYYY",lang);
		
		
			SimpleDateFormat horas= new SimpleDateFormat("hh:mm:ss a");
			Timer timer= new Timer();
			String hour=horas.format(data);
			TimerTask tarefa= new TimerTask() {
				public void run() {
//					System.out.println(horas.format(new Date()));
					lblHoras.setText(horas.format(new Date()));
				}
			};
			final long segundo=1000;
			timer.scheduleAtFixedRate(tarefa, 0,segundo);;
		
		
		JLabel lblNewLabel = new JLabel(newData.format(data).toUpperCase());
		lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		SimpleDateFormat dia= new SimpleDateFormat("EEEE",lang);
		JLabel lblNewLabel_1 = new JLabel(dia.format(data).toUpperCase());
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 45));
		contentPane.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		
		
		
	
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}
	
	public void close() {
		this.setEnabled(false);
		this.setVisible(false);
	}
	
	public static void main(String[] args) {
		new JanelaPrincipal();
	}
}
