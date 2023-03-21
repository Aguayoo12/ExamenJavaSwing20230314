package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CentroEducativoController;
import controller.MateriaController;
import controller.NivelController;
import model.CentroEducativo;
import model.Materia;
import model.Nivel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.List;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class PrincipalView extends JFrame {

	private JPanel contentPane;
	private JComboBox<CentroEducativo> jcbCentro;
	private JComboBox<Nivel> jcbNivel;
	private JComboBox<Materia> jcbMateria;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfCodigo;
	private JTextField jtfUrl;
	private JTextField jtfFecha;
	private JCheckBox chkMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalView frame = new PrincipalView();
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
	public PrincipalView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0};
//		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0};
//		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0};
//		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0};
//		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel_2 = new JLabel("Gestión de Materias");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 3;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Centro: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		jcbCentro = new JComboBox();
		jcbCentro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarJcbNivel();
			}
		});
		jcbCentro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jcbCentro = new GridBagConstraints();
		gbc_jcbCentro.gridwidth = 2;
		gbc_jcbCentro.weightx = 1.0;
		gbc_jcbCentro.insets = new Insets(0, 0, 5, 15);
		gbc_jcbCentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCentro.gridx = 1;
		gbc_jcbCentro.gridy = 1;
		contentPane.add(jcbCentro, gbc_jcbCentro);
		
		JLabel lblNewLabel_1 = new JLabel("Nivel: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbNivel = new JComboBox();
		jcbNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarJcbMateria();
			}
		});
		jcbNivel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jcbNivel = new GridBagConstraints();
		gbc_jcbNivel.gridwidth = 2;
		gbc_jcbNivel.insets = new Insets(0, 0, 5, 15);
		gbc_jcbNivel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNivel.gridx = 1;
		gbc_jcbNivel.gridy = 2;
		contentPane.add(jcbNivel, gbc_jcbNivel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Materia: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 3;
		contentPane.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		jcbMateria = new JComboBox();
		jcbMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ponerEnPantalla();
			}
		});
		jcbMateria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.gridwidth = 2;
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 15);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 3;
		contentPane.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblNewLabel_3 = new JLabel("Datos de la materia");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridwidth = 3;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Id: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		jtfId.setEditable(false);
		jtfId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 5;
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Nombre: ");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_4_1 = new GridBagConstraints();
		gbc_lblNewLabel_4_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4_1.gridx = 0;
		gbc_lblNewLabel_4_1.gridy = 6;
		contentPane.add(lblNewLabel_4_1, gbc_lblNewLabel_4_1);
		
		jtfNombre = new JTextField();
		jtfNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfNombre.setColumns(10);
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.gridwidth = 2;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 6;
		contentPane.add(jtfNombre, gbc_jtfNombre);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Código: ");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_4_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_4_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4_1_1.gridx = 0;
		gbc_lblNewLabel_4_1_1.gridy = 7;
		contentPane.add(lblNewLabel_4_1_1, gbc_lblNewLabel_4_1_1);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfCodigo.setColumns(10);
		GridBagConstraints gbc_jtfCodigo = new GridBagConstraints();
		gbc_jtfCodigo.gridwidth = 2;
		gbc_jtfCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCodigo.gridx = 1;
		gbc_jtfCodigo.gridy = 7;
		contentPane.add(jtfCodigo, gbc_jtfCodigo);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("URL Classroom: ");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_4_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_4_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4_1_1_1.gridx = 0;
		gbc_lblNewLabel_4_1_1_1.gridy = 8;
		contentPane.add(lblNewLabel_4_1_1_1, gbc_lblNewLabel_4_1_1_1);
		
		jtfUrl = new JTextField();
		jtfUrl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfUrl.setColumns(10);
		GridBagConstraints gbc_jtfUrl = new GridBagConstraints();
		gbc_jtfUrl.gridwidth = 2;
		gbc_jtfUrl.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUrl.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUrl.gridx = 1;
		gbc_jtfUrl.gridy = 8;
		contentPane.add(jtfUrl, gbc_jtfUrl);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Fecha Inicio: ");
		lblNewLabel_4_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_4_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_4_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_4_1_1_1_1.gridy = 9;
		contentPane.add(lblNewLabel_4_1_1_1_1, gbc_lblNewLabel_4_1_1_1_1);
		
		jtfFecha = new JTextField();
		jtfFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfFecha.setColumns(10);
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.gridwidth = 2;
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 9;
		contentPane.add(jtfFecha, gbc_jtfFecha);
		
		chkMatricula = new JCheckBox("");
		GridBagConstraints gbc_chkMatricula = new GridBagConstraints();
		gbc_chkMatricula.anchor = GridBagConstraints.EAST;
		gbc_chkMatricula.insets = new Insets(0, 0, 5, 5);
		gbc_chkMatricula.gridx = 0;
		gbc_chkMatricula.gridy = 10;
		contentPane.add(chkMatricula, gbc_chkMatricula);
		
		JLabel lblNewLabel_5 = new JLabel("Admite matrícula");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 10;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(esCodigo(jtfCodigo.getText())) {
						if(esUrl(jtfUrl.getText())) {
							save();
						}
						else {
							JOptionPane.showMessageDialog(null, "La URL de Classroom introducida no es válida");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "El código introducido no es válido");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error no se ha podido guardar");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 11;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 12;
		contentPane.add(panel, gbc_panel);
		
		llenarJcbCentro();
	}
	
	private void llenarJcbCentro() {
		List<CentroEducativo> lce = CentroEducativoController.findAll();
		for (CentroEducativo centroEducativo : lce) {
			jcbCentro.addItem(centroEducativo);
		}
	}
	
	private void llenarJcbNivel() {
		jcbNivel.removeAllItems();
		CentroEducativo ce = (CentroEducativo)jcbCentro.getSelectedItem();
		List<Nivel> ln = NivelController.findInCenter(ce.getId());
		for (Nivel nivel : ln) {
			jcbNivel.addItem(nivel);
		}
	}
	
	private void llenarJcbMateria() {
		jcbMateria.removeAllItems();
		Nivel n = (Nivel)jcbNivel.getSelectedItem();
		if(n != null) {
			List<Materia> lm = MateriaController.findInNivel(n.getId());
			for (Materia materia : lm) {
				jcbMateria.addItem(materia);
			}
		}
	}
	
	private void ponerEnPantalla() {
		Materia m = (Materia)jcbMateria.getSelectedItem();
		if(m != null) {
			jtfId.setText(""+m.getId());
			jtfNombre.setText(m.getNombre());
			jtfCodigo.setText(m.getCodigo());
			jtfUrl.setText(m.getUrlClassroom());
			jtfFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(m.getFechaInicio()));
			chkMatricula.setSelected(m.isAdmiteMatricula());
			
		}
		else {
			jtfId.setText("");
			jtfNombre.setText("");
			jtfCodigo.setText("");
			jtfUrl.setText("");
			jtfFecha.setText("DD/MM/YYYY");
			chkMatricula.setSelected(false);
		}
	}
	
	private void save() {
		Materia m = new Materia();
		m.setId(Integer.parseInt(jtfId.getText()));
		m.setNombre(jtfNombre.getText());
		m.setCodigo(jtfCodigo.getText());
		m.setUrlClassroom(jtfUrl.getText());
		m.setAdmiteMatricula(chkMatricula.isSelected());
		java.util.Date fecha = null;
		try {
			fecha =  new SimpleDateFormat("dd/MM/yyyy").parse(jtfFecha.getText());
		} catch (ParseException e) {
		}
		Date fecha1 = new Date(fecha.getTime());
		m.setFechaInicio(fecha1);
		MateriaController.save(m);
	}

	private boolean esCodigo(String str) {
		int contLetras = 0;
		for (int i = 0; i < str.length(); i++) {
			if(Character.isLetter(str.charAt(i))) {
				contLetras++;
			}
		}
		if(contLetras >= 3)
			return true;
		else
			return false;
	}
	
	private boolean esUrl(String str) {
		if(str.startsWith("http://") || str.startsWith("https://")) 
			return true;
		else
			return false;
	}
}
