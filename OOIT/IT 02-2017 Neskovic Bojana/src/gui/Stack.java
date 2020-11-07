package gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import geometry.Rectangle;
import geometry.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stack extends JFrame {

	private JPanel contentPane;
	DefaultListModel dlm = new DefaultListModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
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
	public Stack() {
		setTitle("Stack Neskovic Bojana IT2/2017");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setMinimumSize(new Dimension(600, 100));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{438, 0};
		gbl_contentPane.rowHeights = new int[]{235, 35, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel pnlCentar = new JPanel();
		GridBagConstraints gbc_pnlCentar = new GridBagConstraints();
		gbc_pnlCentar.insets = new Insets(0, 0, 5, 0);
		gbc_pnlCentar.fill = GridBagConstraints.BOTH;
		gbc_pnlCentar.gridx = 0;
		gbc_pnlCentar.gridy = 0;
		contentPane.add(pnlCentar, gbc_pnlCentar);
		pnlCentar.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlCentar.add(scrollPane, "name");
		
		JList lstPravougaonici = new JList();
		lstPravougaonici.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lstPravougaonici);
		lstPravougaonici.setModel(dlm);
		
		
		JPanel pnlJug = new JPanel();
		GridBagConstraints gbc_pnlJug = new GridBagConstraints();
		gbc_pnlJug.anchor = GridBagConstraints.NORTH;
		gbc_pnlJug.fill = GridBagConstraints.HORIZONTAL;
		gbc_pnlJug.gridx = 0;
		gbc_pnlJug.gridy = 1;
		contentPane.add(pnlJug, gbc_pnlJug);
		
		JButton btnDodajPravougaonik = new JButton("Dodaj pravougaonik");
		btnDodajPravougaonik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDodajPravougaonik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				JSpinner unesiX = new JSpinner();
				JSpinner unesiY = new JSpinner();
				JSpinner unesiSirinu = new JSpinner();
				JSpinner unesiVisinu = new JSpinner();
				
				JComboBox cmbBojeIvice = new JComboBox();
				cmbBojeIvice.addItem("Crna");
				cmbBojeIvice.addItem("Bela");
				cmbBojeIvice.addItem("Plava");
				cmbBojeIvice.addItem("Crvena");
				cmbBojeIvice.addItem("Zelena");
				cmbBojeIvice.addItem("Zuta");
				cmbBojeIvice.addItem("Pink");
				
				JComboBox cmbBojeUnutrasnjosti = new JComboBox();
				cmbBojeUnutrasnjosti.addItem("Crna");
				cmbBojeUnutrasnjosti.addItem("Bela");
				cmbBojeUnutrasnjosti.addItem("Plava");
				cmbBojeUnutrasnjosti.addItem("Crvena");
				cmbBojeUnutrasnjosti.addItem("Zelena");
				cmbBojeUnutrasnjosti.addItem("Zuta");
				cmbBojeUnutrasnjosti.addItem("Pink");
				
				Object[] opcije = {"Dodaj", "Obustavi"};
				final JComponent[] unosi = new JComponent[]{
						new JLabel("Unesite X koordinatu kvadrata:"),
						unesiX,
						new JLabel("Unesite Y koordinatu kvadrata:"),
						unesiY,
						new JLabel("Unesite sirinu stranice:"),
						unesiSirinu,
						new JLabel("Unesite visinu stranice:"),
						unesiVisinu,
						new JLabel("Unesite boju ivice: "),
						cmbBojeIvice,
						new JLabel("Unesite boju unutrasnjosti: "),
						cmbBojeUnutrasnjosti

				};
				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				for (JComponent c : unosi){
					panel.add(c);
				}
				int rezultat = JOptionPane.showOptionDialog(
						null,
						panel,
						"Dodavanje novog pravougaonika",
						JOptionPane.INFORMATION_MESSAGE,
						JOptionPane.PLAIN_MESSAGE,
						null,
						opcije,
						null
						);
				if (rezultat == JOptionPane.OK_OPTION) {
					
					dlm.addElement(new Rectangle(new Point((int)unesiX.getValue(),(int)unesiY.getValue()), (int)unesiSirinu.getValue(), (int)unesiVisinu.getValue(), (String)cmbBojeIvice.getSelectedItem(), (String)cmbBojeUnutrasnjosti.getSelectedItem()));
				}
			}
		});
		pnlJug.add(btnDodajPravougaonik);
		
		JButton btnIzbrisiPravougaonik = new JButton("Izbrisi pravougaonik");
		btnIzbrisiPravougaonik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] opcije = new String[]{"Da", "Ne"};
				if (dlm.size() > 0){
					Rectangle r = (Rectangle)dlm.lastElement();
					JSpinner unesiX = new JSpinner();
					JSpinner unesiY = new JSpinner();
					JSpinner unesiSirinu = new JSpinner();
					JSpinner unesiVisinu = new JSpinner();
					unesiX.setValue(r.getUpperLeftPoint().getX());
					unesiY.setValue(r.getUpperLeftPoint().getY());
					unesiX.setEnabled(false);
					unesiY.setEnabled(false);
					
					unesiSirinu.setValue(r.getWidth());
					unesiSirinu.setEnabled(false);
					
					unesiVisinu.setValue(r.getHeight());
					unesiVisinu.setEnabled(false);
					
					JComboBox cmbBojeIvice = new JComboBox();
					cmbBojeIvice.addItem("Crna");
					cmbBojeIvice.addItem("Bela");
					cmbBojeIvice.addItem("Plava");
					cmbBojeIvice.addItem("Crvena");
					cmbBojeIvice.addItem("Zelena");
					cmbBojeIvice.addItem("Zuta");
					cmbBojeIvice.addItem("Pink");
					
					cmbBojeIvice.setSelectedItem(r.getColor());
					cmbBojeIvice.setEnabled(false);
					
					JComboBox cmbBojeUnutrasnjosti = new JComboBox();
					cmbBojeUnutrasnjosti.addItem("Crna");
					cmbBojeUnutrasnjosti.addItem("Bela");
					cmbBojeUnutrasnjosti.addItem("Plava");
					cmbBojeUnutrasnjosti.addItem("Crvena");
					cmbBojeUnutrasnjosti.addItem("Zelena");
					cmbBojeUnutrasnjosti.addItem("Zuta");
					cmbBojeUnutrasnjosti.addItem("Pink");
					
					cmbBojeUnutrasnjosti.setSelectedItem(r.getColorInside());
					cmbBojeUnutrasnjosti.setEnabled(false);
					
					final JComponent[] unosi = new JComponent[]{
							new JLabel("Pravougaonik je za brisanje\n"),
							new JLabel("X koordinata: "),
							unesiX,
							new JLabel("Y koordinata"),
							unesiY,
							new JLabel("Sirina stranice: "),
							unesiSirinu,
							new JLabel("Visina stranice: "),
							unesiVisinu,
							new JLabel("Boja ivice: "),
							cmbBojeIvice,
							new JLabel("Boja unutrasnjosti: "),
							cmbBojeUnutrasnjosti,
							new JLabel("Da li ste sigurni da zelite da obrisete?")

					};
					JPanel panel = new JPanel();
					panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
					for (JComponent c : unosi){
						panel.add(c);
					}
					int rezultat = JOptionPane.showOptionDialog(
							null,
							panel,
							"Brisanje pravougaonika",
							JOptionPane.INFORMATION_MESSAGE,
							JOptionPane.PLAIN_MESSAGE,
							null,
							opcije,
							null
							);
					
					
					if(rezultat == JOptionPane.OK_OPTION)
					{
						if(dlm.size()>0)
							dlm.removeElement(dlm.lastElement());
						
					}
				} else {
					JOptionPane.showMessageDialog(null,
						    "Stek je prazan.",
						    "Prazan stek",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		pnlJug.add(btnIzbrisiPravougaonik);
	}


}