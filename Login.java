package com.idat.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import com.idat.dao.ITrabajadoresDao;
import com.idat.dao.daolmpl.TrabajadoresDaolmpl;
import com.idat.entidades.Trabajadores;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField txtUsuario;  
    private JPasswordField txtContrasena;

    public Login() {
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/imagen-Iogo_Empresa.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 425, 529);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Componentes visuales (conservando tus posiciones y estilos exactos)
        JLabel lblTitulo = new JLabel("Inicio de Sesión");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitulo.setBounds(59, 79, 296, 37);
        contentPane.add(lblTitulo);

        JLabel lblUsuario = new JLabel("Usuario");  // Cambiado de lblCorreo a lblUsuario
        lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblUsuario.setBounds(42, 187, 98, 37);
        contentPane.add(lblUsuario);

        JLabel lblContrasena = new JLabel("Contraseña");
        lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblContrasena.setBounds(42, 254, 98, 28);
        contentPane.add(lblContrasena);

        txtUsuario = new JTextField();  // Cambiado de txtCorreo a txtUsuario
        txtUsuario.setBounds(150, 194, 205, 27);
        contentPane.add(txtUsuario);
        txtUsuario.setColumns(10);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(150, 252, 205, 28);
        contentPane.add(txtContrasena);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnIngresar.setBounds(142, 356, 132, 45);
        
        // Lógica de validación (nueva funcionalidad)
        btnIngresar.addActionListener(this::validarCredenciales);
        contentPane.add(btnIngresar);
    }

    private void validarCredenciales(ActionEvent e) {
        String usuario = txtUsuario.getText();
        String contrasena = new String(txtContrasena.getPassword());

        ITrabajadoresDao dao = new TrabajadoresDaolmpl();
        Trabajadores filtro = new Trabajadores();
        filtro.setUsuario(usuario);

        try {
            List<Trabajadores> resultados = dao.operacionesLectura("CONSULTAR", filtro);
            
            if (!resultados.isEmpty() && resultados.get(0).getContraseña().equals(contrasena)) {
                Menu_Principal menu = new Menu_Principal();
                menu.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error de conexión: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Login frame = new Login();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}