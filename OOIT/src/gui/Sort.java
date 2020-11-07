package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
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
import javax.swing.border.EmptyBorder;

import geometry.Rectangle;
import geometry.Point;

public class Sort extends JFrame {

	private JPanel contentPane;
	DefaultListModel dlm = new DefaultListModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sort frame = new Sort();
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
	public Sort() {
		setTitle("Sort Neskovic Bojana IT2/2017");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setMinimumSize(new Dimension(600, 100));
		JPanel pnlJug = new JPanel();
		contentPane.add(pnlJug, BorderLayout.SOUTH);
		
		
		
		
		JPanel pnlCenar = new JPanel();
		contentPane.add(pnlCenar, BorderLayout.CENTER);
		pnlCenar.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlCenar.add(scrollPane, "name");
		
		JList lstPravougaonici = new JList();
		scrollPane.setViewportView(lstPravougaonici);
		lstPravougaonici.setModel(dlm);
		
		JButton btnDodajPravougaonik = new JButton("Dodaj pravougaonik");
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
					Rectangle noviPravougaonik=new Rectangle(new Point((int)unesiX.getValue(),(int)unesiY.getValue()), (int)unesiSirinu.getValue(), (int)unesiVisinu.getValue(), (String)cmbBojeIvice.getSelectedItem(), (String)cmbBojeUnutrasnjosti.getSelectedItem());
					
					if(dlm.isEmpty())
						dlm.addElement(noviPravougaonik);
					else{
						int indeks = 0;
						for(Object obj : dlm.toArray()){
							if (noviPravougaonik.compareTo((Rectangle)obj) < 0)
								break;
							indeks++;
						}
						dlm.add(indeks, noviPravougaonik);
						
					}
				
				}	
		
			}

		});
		pnlJug.add(btnDodajPravougaonik);
	}
}