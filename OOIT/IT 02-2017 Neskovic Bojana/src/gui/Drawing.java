package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import geometry.PnlDrawing;
import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Shape;
import geometry.Rectangle;
import geometry.Point;
import gui.ColorChooserButton.ColorChangedListener;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.awt.CardLayout;
import java.awt.Checkbox;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Drawing extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup shapes = new ButtonGroup();
	private int x;
	private int y;
	private Color colorEdges = Color.BLACK;
	private Color colorInside = Color.WHITE;
	private Shape currentShape;
	
	Point lineFirstPoint;
	int i = 0;
	private Shape selectedShape;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drawing frame = new Drawing();
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
	public Drawing() {
		
		setTitle("Drawing Neskovic Bojana IT2/2017");
		currentShape = new Point();
		setMinimumSize(new Dimension(850, 700));
		setBackground(UIManager.getColor("Button.shadow"));
		setFont(new Font("Monospaced", Font.BOLD, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

		
		
		currentShape = null;
		Panel pnlZapad = new Panel();
		pnlZapad.setBackground(new Color(240, 255, 240));
		contentPane.add(pnlZapad, BorderLayout.WEST);
		GridBagLayout gbl_pnlZapad = new GridBagLayout();
		gbl_pnlZapad.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlZapad.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlZapad.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlZapad.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlZapad.setLayout(gbl_pnlZapad);
		
		
		JLabel lblHint = new JLabel("Odaberite oblik za crtanje");
		lblHint.setForeground(new Color(30, 144, 255));
		
		JToggleButton tglbtnTacka = new JToggleButton();
		tglbtnTacka.setPreferredSize(new Dimension(200, 40));
		tglbtnTacka.setText("Tacka");
		tglbtnTacka.setFocusPainted(false);
		tglbtnTacka.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currentShape = new Point();
				lblHint.setText("Klikom odaberite poziciju tacke.");
			}
		});
		GridBagConstraints gbc_tglbtnTacka = new GridBagConstraints();
		gbc_tglbtnTacka.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnTacka.gridx = 0;
		gbc_tglbtnTacka.gridy = 0;
		pnlZapad.add(tglbtnTacka, gbc_tglbtnTacka);
		shapes.add(tglbtnTacka);
		

		JToggleButton tglbtnLinija = new JToggleButton();
		tglbtnLinija.setPreferredSize(new Dimension(200, 40));
		tglbtnLinija.setText("Linija");
		tglbtnLinija.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currentShape = new Line();
				lblHint.setText("Klikom odaberite pocetnu tacku linije.");
			}
		});
		
		tglbtnLinija.setFocusPainted(false);
		
		
		GridBagConstraints gbc_tglbtnLinija = new GridBagConstraints();
		gbc_tglbtnLinija.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnLinija.gridx = 0;
		gbc_tglbtnLinija.gridy = 1;
		pnlZapad.add(tglbtnLinija, gbc_tglbtnLinija);
		shapes.add(tglbtnLinija);
		
		
		JToggleButton tglbtnPravougaonik = new JToggleButton();
		tglbtnPravougaonik.setPreferredSize(new Dimension(200, 40));
		tglbtnPravougaonik.setText("Pravougaonik");
		tglbtnPravougaonik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currentShape = new Rectangle();
				lblHint.setText("Klikom odaberite gornju levu tacku pravougaonika.");
			}
		});
		tglbtnPravougaonik.setFocusPainted(false);
		GridBagConstraints gbc_tglbtnPravougaonik = new GridBagConstraints();
		gbc_tglbtnPravougaonik.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPravougaonik.gridx = 0;
		gbc_tglbtnPravougaonik.gridy = 2;
		pnlZapad.add(tglbtnPravougaonik, gbc_tglbtnPravougaonik);
		shapes.add(tglbtnPravougaonik);
		

		JToggleButton tglbtnKrug = new JToggleButton();
		tglbtnKrug.setPreferredSize(new Dimension(200, 40));
		tglbtnKrug.setText("Krug");
		tglbtnKrug.setFocusPainted(false);
		tglbtnKrug.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currentShape = new Circle();
				lblHint.setText("Klikom odaberite centar kruga.");

			}
		});

		GridBagConstraints gbc_tglbtnKrug = new GridBagConstraints();
		gbc_tglbtnKrug.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnKrug.gridx = 0;
		gbc_tglbtnKrug.gridy = 3;
		pnlZapad.add(tglbtnKrug, gbc_tglbtnKrug);
		shapes.add(tglbtnKrug);
		
		JToggleButton tglbtnKrugSaRupom = new JToggleButton();
		tglbtnKrugSaRupom.setPreferredSize(new Dimension(200, 40));
		tglbtnKrugSaRupom.setText("Krug sa rupom");
		tglbtnKrugSaRupom.setFocusPainted(false);
		tglbtnKrugSaRupom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currentShape = new Donut();
				lblHint.setText("Klikom odaberite centar kruga sa rupom.");

			}
		});

		GridBagConstraints gbc_tglbtnKrugSaRupom = new GridBagConstraints();
		gbc_tglbtnKrugSaRupom.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnKrugSaRupom.gridx = 0;
		gbc_tglbtnKrugSaRupom.gridy = 4;
		pnlZapad.add(tglbtnKrugSaRupom, gbc_tglbtnKrugSaRupom);
		shapes.add(tglbtnKrugSaRupom);
		
		
		ColorChooserButton btnBojaIvice = new ColorChooserButton(Color.BLACK, "Odaberite boju ivice: ");
		btnBojaIvice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBojaIvice.setPreferredSize(new Dimension(200,40));
		btnBojaIvice.setText("Ivica");
		btnBojaIvice.addColorChangedListener(new ColorChangedListener() {
		    @Override
		    public void colorChanged(Color newColor) {
		            colorEdges = newColor;
		    }
		});
		
		GridBagConstraints gbc_btnBojaIvice = new GridBagConstraints();
		gbc_btnBojaIvice.insets = new Insets(0, 0, 5, 5);
		gbc_btnBojaIvice.gridx = 0;
		gbc_btnBojaIvice.gridy = 5;
		pnlZapad.add(btnBojaIvice, gbc_btnBojaIvice);
		
		ColorChooserButton btnBojaUnutrasnjosti = new ColorChooserButton(Color.WHITE, "Odaberite boju unutrasnjosti");
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBojaUnutrasnjosti.addColorChangedListener(new ColorChangedListener() {
		    @Override
		    public void colorChanged(Color newColor) {
		            colorInside = newColor;
		      
		    }
		});
		btnBojaUnutrasnjosti.setText("Unutrasnjost");
		btnBojaUnutrasnjosti.setPreferredSize(new Dimension(200, 40));
		btnBojaUnutrasnjosti.setEnabled(false);
		
		GridBagConstraints gbc_btnBojaUnutrasnjosti = new GridBagConstraints();
		gbc_btnBojaUnutrasnjosti.insets = new Insets(0, 0, 5, 5);
		gbc_btnBojaUnutrasnjosti.gridx = 0;
		gbc_btnBojaUnutrasnjosti.gridy = 6;
		pnlZapad.add(btnBojaUnutrasnjosti, gbc_btnBojaUnutrasnjosti);
				
				
				JCheckBox chckbxPopuniUnutrasnjost = new JCheckBox("Popuni unutrasnjost");
				chckbxPopuniUnutrasnjost.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent arg0) {
						btnBojaUnutrasnjosti.setEnabled(chckbxPopuniUnutrasnjost.isSelected());
					}
				});
				GridBagConstraints gbc_chckbxPopuniUnutrasnjost = new GridBagConstraints();
				gbc_chckbxPopuniUnutrasnjost.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxPopuniUnutrasnjost.gridx = 0;
				gbc_chckbxPopuniUnutrasnjost.gridy = 7;
				pnlZapad.add(chckbxPopuniUnutrasnjost, gbc_chckbxPopuniUnutrasnjost);
		
		
	
		btnBojaIvice.addColorChangedListener(new ColorChangedListener() {
		    @Override
		    public void colorChanged(Color newColor) {
		    		colorInside = newColor;			
		    }
		});
		
				
				JToggleButton tglbtnSelektuj = new JToggleButton("Selektuj");
				tglbtnSelektuj.setFocusPainted(false);
				tglbtnSelektuj.setPreferredSize(new Dimension(200, 40));
				shapes.add(tglbtnSelektuj);
				tglbtnSelektuj.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						currentShape = null;
						lblHint.setText("Klikom selektujte neki od nacrtanih oblika.");

					}
				});
				GridBagConstraints gbc_tglbtnSelektujte = new GridBagConstraints();
				gbc_tglbtnSelektujte.insets = new Insets(0, 0, 5, 5);
				gbc_tglbtnSelektujte.gridx = 0;
				gbc_tglbtnSelektujte.gridy = 8;
				pnlZapad.add(tglbtnSelektuj, gbc_tglbtnSelektujte);
				
				tglbtnSelektuj.setBackground(new Color(111,147,247));
				tglbtnSelektuj.setForeground(Color.WHITE);
				tglbtnSelektuj.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnIzbrisi = new JButton("Izbrisi");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnIzbrisi.setPreferredSize(new Dimension(200, 40));
		GridBagConstraints gbc_btnIzbrisi = new GridBagConstraints();
		gbc_btnIzbrisi.insets = new Insets(0, 0, 5, 5);
		gbc_btnIzbrisi.gridx = 0;
		gbc_btnIzbrisi.gridy = 9;
		pnlZapad.add(btnIzbrisi, gbc_btnIzbrisi);
		btnIzbrisi.setEnabled(false);
	
		JButton btnModifikuj = new JButton("Modifikuj");
		btnModifikuj.setPreferredSize(new Dimension(200, 40));
		btnModifikuj.setFocusPainted(false);
		btnModifikuj.setEnabled(false);
		
		GridBagConstraints gbc_btnModifikuj = new GridBagConstraints();
		gbc_btnModifikuj.insets = new Insets(0, 0, 0, 5);
		gbc_btnModifikuj.gridx = 0;
		gbc_btnModifikuj.gridy = 10;
		pnlZapad.add(btnModifikuj, gbc_btnModifikuj);
		
		PnlDrawing pnlCentar = new PnlDrawing();
		
		pnlCentar.setBackground(Color.WHITE);
		pnlCentar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				x = arg0.getX();
				y = arg0.getY();
				//System.out.println(x + " " + y);
				
				
				if (currentShape instanceof Point)
				{
					pnlCentar.addShape(new Point(x,y, colorEdges));
					lblHint.setText("Odaberite novu komandu.");
				}
				if (currentShape instanceof Line)
				{
					if (i % 2 == 0){
						lineFirstPoint = new Point(x, y);
						lblHint.setText("Klikom odaberite krajnju tacku linije.");

					}
					else{
						pnlCentar.addShape(new Line(lineFirstPoint, new Point(x, y), colorEdges));
						lblHint.setText("Odaberite novu komandu.");
					}
					i++;
					
				}
				
				if (currentShape instanceof Rectangle)
				{
					JSpinner unesiSirinu = new JSpinner();
					JSpinner unesiVisinu = new JSpinner();
					
					final JComponent[] unosi = new JComponent[]{
							new JLabel("Unesite sirinu novog pravougaonika: "),
							unesiSirinu,
							new JLabel("Unesite visinu novog pravougaonika: "),
							unesiVisinu
					};
					JPanel panel = new JPanel();
					panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
					for (JComponent c : unosi){
						panel.add(c);
					}
					Object[] opcije = {"Crtaj", "Otkazi"};
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
						if(chckbxPopuniUnutrasnjost.isSelected()){
							pnlCentar.addShape(new Rectangle(new Point(x, y), (int)unesiSirinu.getValue(),(int)unesiVisinu.getValue(), colorEdges, colorInside));
							
						}
						else {
							pnlCentar.addShape(new Rectangle(new Point(x, y), (int)unesiSirinu.getValue(),(int)unesiVisinu.getValue(), colorEdges));
						}
						
					}
					lblHint.setText("Odaberite novu komandu.");
				}
				if ((currentShape instanceof Circle)&& !(currentShape instanceof Donut))
				{
					
					JSpinner unesiPoluprecnik = new JSpinner();
					final JComponent[] unosi = new JComponent[]{
							new JLabel("Unesite poluprecnik kruga: "),
							unesiPoluprecnik};
					JPanel panel = new JPanel();
					panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
					for (JComponent c : unosi){
						panel.add(c);
					}
					Object[] opcije = {"Crtaj", "Otkazi"};
					int rezultat = JOptionPane.showOptionDialog(
							null,
							panel,
							"Dodavanje novog kruga",
							JOptionPane.INFORMATION_MESSAGE,
							JOptionPane.PLAIN_MESSAGE,
							null, 
							opcije, 
							null
							);
					if (rezultat == JOptionPane.OK_OPTION) {
						if(chckbxPopuniUnutrasnjost.isSelected())
							pnlCentar.addShape(new Circle(new Point(x, y), (int)unesiPoluprecnik.getValue(), colorEdges,colorInside));
						else
							pnlCentar.addShape(new Circle(new Point(x, y), (int)unesiPoluprecnik.getValue(), colorEdges));
					}
					lblHint.setText("Odaberite novu komandu.");
				}
				if (currentShape instanceof Donut)
				{
					
					JSpinner unesiPoluprecnik1 = new JSpinner();
					JSpinner unesiPoluprecnik2 = new JSpinner();
					final JComponent[] unosi = new JComponent[]{
							new JLabel("Unesite spoljasnji poluprecnik kruga: "),
							unesiPoluprecnik1,
							new JLabel("Unesite unutrasnji poluprecnik kruga: "),
							unesiPoluprecnik2};
					JPanel panel = new JPanel();
					panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
					for (JComponent c : unosi){
						panel.add(c);
					}
					Object[] opcije = {"Crtaj", "Otkazi"};
					int rezultat = JOptionPane.showOptionDialog(
							null,
							panel,
							"Dodavanje novog kruga sa rupom",
							JOptionPane.INFORMATION_MESSAGE,
							JOptionPane.PLAIN_MESSAGE,
							null, 
							opcije, 
							null
							);
					if (rezultat == JOptionPane.OK_OPTION) {
						if(chckbxPopuniUnutrasnjost.isSelected())
							pnlCentar.addShape(new Donut(new Point(x, y), (int)unesiPoluprecnik1.getValue(), (int)unesiPoluprecnik2.getValue(), colorEdges, colorInside));
						else
							pnlCentar.addShape(new Donut(new Point(x, y), (int)unesiPoluprecnik1.getValue(), (int)unesiPoluprecnik2.getValue(), colorEdges));
					}
					lblHint.setText("Odaberite novu komandu.");
				}
				
				
				if (currentShape == null){
					selectedShape = pnlCentar.Select(x, y);
					if(selectedShape != null){
						btnIzbrisi.setEnabled(true);
						btnModifikuj.setEnabled(true);
					}
						
					else{
						btnIzbrisi.setEnabled(false);
						btnModifikuj.setEnabled(false);
					}
						
				}
				if(!((currentShape instanceof Line) && i % 2 == 1)){
					currentShape = null;
					shapes.clearSelection();
				}
				pnlCentar.revalidate();
				
				

			}
		});

		btnIzbrisi.setFocusPainted(false);
		btnIzbrisi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (btnIzbrisi.isEnabled()){
					Object[] opcije =  {"Da", "Ne"};
					
					int rezultat = JOptionPane.showOptionDialog(
							null,
							new JLabel("Da li ste sigurni?"),
							"Brisanje elementa",
							JOptionPane.WARNING_MESSAGE,
							JOptionPane.PLAIN_MESSAGE,
							null, 
							opcije, 
							null
							);
					if (rezultat == JOptionPane.OK_OPTION){
						pnlCentar.deleteShape(selectedShape);
						selectedShape = null;
						btnIzbrisi.setEnabled(false);
						btnModifikuj.setEnabled(true);
					}
				}
				
			}
		});
		
		btnModifikuj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if (selectedShape instanceof Point){
					Object[] opcije = {"Modifikuj", "Otkazi"};
					JSpinner unesiX = new JSpinner();
					JSpinner unesiY = new JSpinner();
					unesiX.setValue(((Point) selectedShape).getX());
					unesiY.setValue(((Point) selectedShape).getY());
					ColorChooserButton btnBojaTacke = new ColorChooserButton(Color.WHITE, "Odaberite boju tacke");
					btnBojaTacke.setText("Boja tacke");
					btnBojaTacke.setCurrentColor(selectedShape.getColorEdges(), true);
					btnBojaTacke.addColorChangedListener(new ColorChangedListener() {
					    @Override
					    public void colorChanged(Color newColor) {
					            selectedShape.setColorEdges(newColor);
					            
					    }
					});
					
					
					btnBojaUnutrasnjosti.setText("Boja tacke");
					final JComponent[] unosi = new JComponent[]{
							new JLabel("X koordinata tacke: "),
							unesiX,
							new JLabel("Y koordinata tacke: "),
							unesiY,
							btnBojaTacke
							
					};
							
					JPanel panel = new JPanel();
					panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
					for (JComponent c : unosi){
						panel.add(c);
					}
					
					int rezultat = JOptionPane.showOptionDialog(
							null,
							panel,
							"Modifikacija tacke",
							JOptionPane.INFORMATION_MESSAGE,
							JOptionPane.PLAIN_MESSAGE,
							null, 
							opcije, 
							null
							);
					if (rezultat == JOptionPane.OK_OPTION){
						((Point) selectedShape).setX((int)unesiX.getValue());
						((Point) selectedShape).setY((int)unesiY.getValue());
						selectedShape.setSelected(false);
			           
						pnlCentar.repaint();
					}
						
					
				}
				else if (selectedShape instanceof Line){
					Object[] opcije = {"Modifikuj", "Otkazi"};
					JSpinner unesiXPocetna = new JSpinner();
					JSpinner unesiYPocetna = new JSpinner();
					unesiXPocetna.setValue(((Line) selectedShape).getStartPoint().getX());
					unesiYPocetna.setValue(((Line) selectedShape).getStartPoint().getY());
					
					JSpinner unesiXKrajnja = new JSpinner();
					JSpinner unesiYKrajnja = new JSpinner();
					unesiXKrajnja.setValue(((Line) selectedShape).getEndPoint().getX());
					unesiYKrajnja.setValue(((Line) selectedShape).getEndPoint().getY());
					Color color = selectedShape.getColorEdges();
					ColorChooserButton btnBojaLinije = new ColorChooserButton(Color.WHITE, "Odaberite boju tacke");
					btnBojaLinije.setText("Boja linije");
					btnBojaLinije.setCurrentColor(selectedShape.getColorEdges(), true);
					btnBojaLinije.addColorChangedListener(new ColorChangedListener() {
					    @Override
					    public void colorChanged(Color newColor) {
					    	selectedShape.setColorEdges(newColor);
					            
					    }
					});
					
					
					btnBojaLinije.setText("Boja linije");
					final JComponent[] unosi = new JComponent[]{
							new JLabel("X koordinata pocetne tacke: "),
							unesiXPocetna,
							new JLabel("Y koordinata pocetne tacke: "),
							unesiYPocetna,
							new JLabel("X koordinata krajnje tacke: "),
							unesiXKrajnja,
							new JLabel("Y koordinata krajnje tacke: "),
							unesiYKrajnja,
							btnBojaLinije
							
					};
							
					JPanel panel = new JPanel();
					panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
					for (JComponent c : unosi){
						panel.add(c);
					}
					
					int rezultat = JOptionPane.showOptionDialog(
							null,
							panel,
							"Modifikacija linije",
							JOptionPane.INFORMATION_MESSAGE,
							JOptionPane.PLAIN_MESSAGE,
							null, 
							opcije, 
							null
							);
					if (rezultat == JOptionPane.OK_OPTION){
						((Line) selectedShape).getStartPoint().setX((int)unesiXPocetna.getValue());
						((Line) selectedShape).getStartPoint().setY((int)unesiYPocetna.getValue());
						
						((Line) selectedShape).getEndPoint().setX((int)unesiXKrajnja.getValue());
						((Line) selectedShape).getEndPoint().setY((int)unesiYKrajnja.getValue());
						selectedShape.setSelected(false);
						
						pnlCentar.repaint();
					}
					else {
						selectedShape.setColorEdges(color);
					}
					
				}
				
				else if (selectedShape instanceof Rectangle){
					Rectangle r = (Rectangle)selectedShape;
					Object[] opcije = {"Crtaj", "Otkazi"};
					JSpinner unesiXGoreLevo = new JSpinner();
					unesiXGoreLevo.setValue(r.getUpperLeftPoint().getX());
					
					JSpinner unesiYGoreLevo = new JSpinner();
					unesiYGoreLevo.setValue(r.getUpperLeftPoint().getY());
					
					JSpinner unesiSirinuPravougaonika = new JSpinner();
					unesiSirinuPravougaonika.setValue(r.getWidth());
					
					JSpinner unesiVisinuPravougaonika = new JSpinner();
					unesiVisinuPravougaonika.setValue(r.getHeight());
					
					Color ivica = r.getColorEdges();
					Color unutra = r.getInsideColor();
					
					ColorChooserButton btnBojaIvice = new ColorChooserButton(Color.WHITE, "Odaberite boju ivice pravougaonika");
					btnBojaIvice.setText("Boja ivice");
					btnBojaIvice.setCurrentColor(r.getColorEdges(), true);
					btnBojaIvice.addColorChangedListener(new ColorChangedListener() {
					    @Override
					    public void colorChanged(Color newColor) {
					    	r.setColorEdges(newColor);
					            
					    }
					});
					ColorChooserButton btnBojaUnutrasnjosti = new ColorChooserButton(Color.WHITE, "Odaberite boju unutrasnjosti pravougaonika");
					btnBojaUnutrasnjosti.setText("Boja unutrasnjosti");
					btnBojaUnutrasnjosti.setCurrentColor(r.getInsideColor(), true);
					btnBojaUnutrasnjosti.addColorChangedListener(new ColorChangedListener() {
					    @Override
					    public void colorChanged(Color newColor) {
					    	r.setColorInside(newColor);
					            
					    }
					});
					JCheckBox chckbxPopuni = new JCheckBox("Popuni unutrasnjost");
					chckbxPopuni.addChangeListener(new ChangeListener() {
						public void stateChanged(ChangeEvent arg0) {
							btnBojaUnutrasnjosti.setEnabled(chckbxPopuni.isSelected());
						}
					});
					chckbxPopuni.setSelected(r.isFilled());
					btnBojaUnutrasnjosti.setEnabled(chckbxPopuni.isSelected());
					chckbxPopuni.setText("Popuni unutrasnjost");
					final JComponent[] unosi = new JComponent[]{
							new JLabel("X koordinata tacke gore levo: "),
							unesiXGoreLevo,
							new JLabel("Y koordinata tacke gore levo:"),
							unesiYGoreLevo,
							new JLabel("Duzina stranice: "),
							unesiSirinuPravougaonika,
							new JLabel("Visina stranice:"),
							unesiVisinuPravougaonika,
							btnBojaIvice,
							btnBojaUnutrasnjosti,
							chckbxPopuni};
					JPanel panel = new JPanel();
					panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
					for (JComponent c : unosi){
						panel.add(c);
					}
					
					int rezultat = JOptionPane.showOptionDialog(
							null,
							panel,
							"Modifikacija pravougaonika",
							JOptionPane.INFORMATION_MESSAGE,
							JOptionPane.PLAIN_MESSAGE,
							null, 
							opcije, 
							null
							);
					if (rezultat == JOptionPane.OK_OPTION) {
						r.getUpperLeftPoint().setX((int)unesiXGoreLevo.getValue());
						r.getUpperLeftPoint().setY((int)unesiYGoreLevo.getValue());
						try {
							r.setWidth((int)unesiSirinuPravougaonika.getValue());
						} catch (Exception e) {
							e.printStackTrace();
						}
						try {
							r.setHeight((int)unesiVisinuPravougaonika.getValue());
						} catch (Exception e) {
							e.printStackTrace();
						}
						r.setFilled(chckbxPopuni.isSelected());
						selectedShape.setSelected(false);
						pnlCentar.repaint();
					}
					else {
						r.setColorEdges(ivica);
						r.setColorEdges(unutra);
						selectedShape.setSelected(false);
						pnlCentar.repaint();
					}
				}
				else if((selectedShape instanceof Circle) && !(selectedShape instanceof Donut)){
					Circle k = (Circle)selectedShape;
					Object[] opcije = {"Crtaj", "Otkazi"};
					JSpinner unesiXCentra = new JSpinner();
					unesiXCentra.setValue(k.getCenter().getX());
					
					JSpinner unesiYCentra = new JSpinner();
					unesiYCentra.setValue(k.getCenter().getY());
					
					JSpinner unesiR = new JSpinner();
					unesiR.setValue(k.getRadius());
					
					Color ivica = k.getColorEdges();
					Color unutra = k.getInsideColor();
					
					ColorChooserButton btnBojaIvice = new ColorChooserButton(Color.WHITE, "Odaberite boju ivice kruga");
					btnBojaIvice.setText("Boja ivice");
					btnBojaIvice.setCurrentColor(k.getColorEdges());
					btnBojaIvice.addColorChangedListener(new ColorChangedListener() {
					    @Override
					    public void colorChanged(Color newColor) {
					    	k.setColorEdges(newColor);   
					    }
					});
					ColorChooserButton btnBojaUnutrasnjosti = new ColorChooserButton(Color.WHITE, "Odaberite boju unutrasnjosti kruga");
					btnBojaUnutrasnjosti.setText("Boja unutrasnjosti");
					btnBojaUnutrasnjosti.setCurrentColor(k.getInsideColor());
					btnBojaUnutrasnjosti.addColorChangedListener(new ColorChangedListener() {
					    @Override
					    public void colorChanged(Color newColor) {
					    	k.setColorInside(newColor);
					            
					    }
					});
					
					JCheckBox chckbxPopuni = new JCheckBox("Popuni unutrasnjost");
					chckbxPopuni.addChangeListener(new ChangeListener() {
						public void stateChanged(ChangeEvent arg0) {
							btnBojaUnutrasnjosti.setEnabled(chckbxPopuni.isSelected());
						}
					});
					
					chckbxPopuni.setSelected(k.isFilled());
					btnBojaUnutrasnjosti.setEnabled(chckbxPopuni.isSelected());
					chckbxPopuni.setText("Popuni unutrasnjost");
					
					final JComponent[] unosi = new JComponent[]{
							new JLabel("X koordinata centra: "),
							unesiXCentra,
							new JLabel("Y koordinata centra:"),
							unesiYCentra,
							new JLabel("Poluprecnik: "),
							unesiR,
							btnBojaIvice,
							btnBojaUnutrasnjosti,
							chckbxPopuni
					};
					JPanel panel = new JPanel();
					panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
					for (JComponent c : unosi){
						panel.add(c);
					}
					
					int rezultat = JOptionPane.showOptionDialog(
							null,
							panel,
							"Modifikacija kruga",
							JOptionPane.INFORMATION_MESSAGE,
							JOptionPane.PLAIN_MESSAGE,
							null, 
							opcije, 
							null
							);
					if (rezultat == JOptionPane.OK_OPTION) {
						k.getCenter().setX((int)unesiXCentra.getValue());
						k.getCenter().setY((int)unesiYCentra.getValue());
						try {
							k.setRadius((int)unesiR.getValue());
						} catch (Exception e) {
							
							e.printStackTrace();
						}
						k.setFilled(chckbxPopuni.isSelected());
						selectedShape.setSelected(false);
						pnlCentar.repaint();
					}
					else {
						k.setColorEdges(ivica);
						k.setColorEdges(unutra);
						selectedShape.setSelected(false);
						pnlCentar.repaint();
					}
				}
				else if(selectedShape instanceof Donut){
					Donut d = (Donut)selectedShape;
					Object[] opcije = {"Crtaj", "Otkazi"};
					
					JSpinner unesiXCentra = new JSpinner();
					unesiXCentra.setValue(d.getCenter().getX());
					JSpinner unesiYCentra = new JSpinner();
					unesiYCentra.setValue(d.getCenter().getY());
					
					
					JSpinner unesiR1 = new JSpinner();
					unesiR1.setValue(d.getRadius());
					
					JSpinner unesiR2 = new JSpinner();
					unesiR2.setValue(d.getInnerRadius());
					
					Color ivica = d.getColorEdges();
					Color unutra = d.getInsideColor();
					
					ColorChooserButton btnBojaIvice = new ColorChooserButton(Color.WHITE, "Odaberite boju ivice kruga");
					btnBojaIvice.setText("Boja ivice");
					btnBojaIvice.setCurrentColor(d.getColorEdges());
					btnBojaIvice.addColorChangedListener(new ColorChangedListener() {
					    @Override
					    public void colorChanged(Color newColor) {
					    	d.setColorEdges(newColor);   
					    }
					});
					ColorChooserButton btnBojaUnutrasnjosti = new ColorChooserButton(Color.WHITE, "Odaberite boju unutrasnjosti kruga");
					btnBojaUnutrasnjosti.setText("Boja unutrasnjosti");
					btnBojaUnutrasnjosti.setCurrentColor(d.getInsideColor());
					btnBojaUnutrasnjosti.addColorChangedListener(new ColorChangedListener() {
					    @Override
					    public void colorChanged(Color newColor) {
					    	d.setColorInside(newColor);
					            
					    }
					});
					
					JCheckBox chckbxPopuni = new JCheckBox("Popuni unutrasnjost");
					chckbxPopuni.addChangeListener(new ChangeListener() {
						public void stateChanged(ChangeEvent arg0) {
							btnBojaUnutrasnjosti.setEnabled(chckbxPopuni.isSelected());
						}
					});
					
					chckbxPopuni.setSelected(d.isFilled());
					btnBojaUnutrasnjosti.setEnabled(chckbxPopuni.isSelected());
					chckbxPopuni.setText("Popuni unutrasnjost");
					
					final JComponent[] unosi = new JComponent[]{
							new JLabel("X koordinata centra: "),
							unesiXCentra,
							new JLabel("Y koordinata centra:"),
							unesiYCentra,
							new JLabel("Spoljasnji poluprecnik: "),
							unesiR1,
							new JLabel("Unutrasnji poluprecnik: "),
							unesiR2,
							btnBojaIvice,
							btnBojaUnutrasnjosti,
							chckbxPopuni
					};
					JPanel panel = new JPanel();
					panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
					for (JComponent c : unosi){
						panel.add(c);
					}
					
					int rezultat = JOptionPane.showOptionDialog(
							null,
							panel,
							"Modifikacija kruga sa rupom",
							JOptionPane.INFORMATION_MESSAGE,
							JOptionPane.PLAIN_MESSAGE,
							null, 
							opcije, 
							null
							);
					if (rezultat == JOptionPane.OK_OPTION) {
						d.getCenter().setX((int)unesiXCentra.getValue());
						d.getCenter().setY((int)unesiYCentra.getValue());
						try {
							d.setRadius((int)unesiR1.getValue());
						} catch (Exception e) {
							e.printStackTrace();
						}
						try {
							d.setInnerRadius((int)unesiR2.getValue());
						} catch (Exception e) {
							e.printStackTrace();
						}
						d.setFilled(chckbxPopuni.isSelected());
						selectedShape.setSelected(false);
						pnlCentar.repaint();
					}
					else {
						d.setColorEdges(ivica);
						d.setColorEdges(unutra);
						selectedShape.setSelected(false);
						pnlCentar.repaint();
					}
				}
				
				btnIzbrisi.setEnabled(false);
				btnModifikuj.setEnabled(false);
			}
		
		});
		
		//Stil dugmica
		
		chckbxPopuniUnutrasnjost.setForeground(new Color(50,37,199));;
		chckbxPopuniUnutrasnjost.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxPopuniUnutrasnjost.setBackground(new Color(240, 255, 240));
		
		tglbtnTacka.setForeground(new Color(50,37,199));
		tglbtnTacka.setFocusPainted(false);
		tglbtnTacka.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		tglbtnLinija.setForeground(new Color(50,37,199));
		tglbtnLinija.setFocusPainted(false);
		tglbtnLinija.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		tglbtnPravougaonik.setForeground(new Color(50,37,199));
		tglbtnPravougaonik.setFocusPainted(false);
		tglbtnPravougaonik.setFont(new Font("Tahoma", Font.BOLD, 12));

		tglbtnKrug.setForeground(new Color(50,37,199));
		tglbtnKrug.setFocusPainted(false);
		tglbtnKrug.setFont(new Font("Tahoma", Font.BOLD, 12));

		tglbtnKrugSaRupom.setForeground(new Color(50,37,199));
		tglbtnKrugSaRupom.setFocusPainted(false);
		tglbtnKrugSaRupom.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnBojaIvice.setForeground(new Color(50,37,199));
		btnBojaIvice.setFocusPainted(false);
		btnBojaIvice.setFont(new Font("Tahoma", Font.BOLD, 12));

		
		
		btnBojaUnutrasnjosti.setForeground(new Color(50,37,199));
		btnBojaUnutrasnjosti.setFocusPainted(false);
		btnBojaUnutrasnjosti.setFont(new Font("Tahoma", Font.BOLD, 12));

		
		
				
		btnIzbrisi.setBackground(new Color(111,147,247));
		btnIzbrisi.setForeground(Color.WHITE);
		btnIzbrisi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIzbrisi.setToolTipText("Izbrisite selektovani element");
		
		
		btnModifikuj.setBackground(new Color(111,147,247));
		btnModifikuj.setForeground(Color.WHITE);
		btnModifikuj.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		pnlCentar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		
		JPanel pnlJug = new JPanel();
		pnlJug.setBackground(new Color(240, 255, 240));
		contentPane.add(pnlJug, BorderLayout.SOUTH);
		
		
		
		JLabel lblXY = new JLabel("x: 0   y=0");
		pnlJug.setLayout(new GridLayout(0, 2, 0, 0));
		pnlJug.add(lblHint);
		pnlJug.add(lblXY);
		
		pnlCentar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				lblXY.setText("x: " + arg0.getX() + "  " + "y: " + arg0.getY());
			}
		});
	}

}