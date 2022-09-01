package gui;


import java.awt.Dimension;
import java.awt.Image;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField txtFieldLU;
	private JTextField txtFieldApellido;
	private JTextField txtFieldNombre;
	private JTextField txtFieldEmail;
	private JTextField txtFieldGithub;
	private JLabel lblLU, lblApellido, lblNombre, lblEmail, lblGithub;
	private JLabel lblFoto, lblGeneracion;
	private ImageIcon icon, foto;
	private Icon iconoFoto;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2022 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		icon = new ImageIcon(getClass().getResource("/images/tdp.png"));
		setIconImage(icon.getImage());
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 184);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		txtFieldLU = new JTextField();
		txtFieldLU.setEditable(false);
		txtFieldLU.setColumns(10);
		
		txtFieldApellido = new JTextField();
		txtFieldApellido.setEditable(false);
		txtFieldApellido.setColumns(10);
		
		txtFieldNombre = new JTextField();
		txtFieldNombre.setEditable(false);
		txtFieldNombre.setColumns(10);
		
		txtFieldEmail = new JTextField();
		txtFieldEmail.setEditable(false);
		txtFieldEmail.setColumns(10);
		
		txtFieldGithub = new JTextField();
		txtFieldGithub.setEditable(false);
		txtFieldGithub.setColumns(10);
		
		lblLU = new JLabel("LU");
		lblApellido = new JLabel("Apellido");
		lblNombre = new JLabel("Nombre");
		lblEmail = new JLabel("E-mail");
		lblGithub = new JLabel("Github URL");
		
		
		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLU)
						.addComponent(lblApellido)
						.addComponent(lblNombre)
						.addComponent(lblEmail)
						.addComponent(lblGithub))
					.addGap(9)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(txtFieldGithub, Alignment.LEADING)
						.addComponent(txtFieldEmail, Alignment.LEADING)
						.addComponent(txtFieldNombre, Alignment.LEADING)
						.addComponent(txtFieldApellido, Alignment.LEADING)
						.addComponent(txtFieldLU, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFieldLU)
						.addComponent(lblLU))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFieldApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellido))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFieldGithub, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGithub))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		tabInformation.setLayout(gl_tabInformation);
		contentPane.add(tabbedPane);
		
		txtFieldLU.setText(""+ studentData.getId());
		txtFieldApellido.setText(studentData.getLastName());
		txtFieldNombre.setText(studentData.getFirstName());
		txtFieldEmail.setText(studentData.getMail());
		txtFieldGithub.setText(studentData.getGithubURL());
		
		lblFoto = new JLabel();
		lblFoto.setBounds(445, 38, 144, 140);
		foto = new ImageIcon(getClass().getResource(studentData.getPathPhoto()));
		iconoFoto = new ImageIcon(foto.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));
		lblFoto.setIcon(iconoFoto);
		contentPane.add(lblFoto);
		
		lblGeneracion = new JLabel();
		lblGeneracion.setBounds(5, 191, 430, 20);
		contentPane.add(lblGeneracion);
		
		setearHoraGeneracion();
	}
	
	private void setearHoraGeneracion() {
		Calendar fechaHora = new GregorianCalendar();
		
		int anio = fechaHora.get(Calendar.YEAR);
		int mes = fechaHora.get(Calendar.MONTH) + 1;
		int dia = fechaHora.get(Calendar.DATE);
		int hora = fechaHora.get(Calendar.HOUR_OF_DAY);
		int minuto = fechaHora.get(Calendar.MINUTE);
		int segundo = fechaHora.get(Calendar.SECOND);
		
		lblGeneracion.setText("Esta ventana fue generada el "+dia+"/"+mes+"/"+anio+" a las "+hora+":"+minuto+":"+segundo);
	}
}
