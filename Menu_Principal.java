package com.idat.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JDesktopPane Escritorio;
    private JMenuItem mntmMantenimiento_Clientes;
    private JMenuItem mntmMantenimiento_Productos;
    private JMenuItem mntmVentas;
    private JMenuItem mntmAlmacen;
    private JMenuItem mntmReportes;
    private JMenuItem mntmSalir;

    public Menu_Principal() {
        // Configuración básica del JFrame
        setTitle("Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1056, 645);
        setLocationRelativeTo(null);

        // Configuración de la barra de menú
        JMenuBar menuBar = new JMenuBar();
        menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        setJMenuBar(menuBar);

        // Menú Mantenimiento
        JMenu mnMantenimiento = new JMenu("Mantenimiento");
        mnMantenimiento.setFont(new Font("Segoe UI", Font.BOLD, 14));
        menuBar.add(mnMantenimiento);

        mntmMantenimiento_Clientes = new JMenuItem("Clientes");
        mntmMantenimiento_Clientes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        mnMantenimiento.add(mntmMantenimiento_Clientes);

        mntmMantenimiento_Productos = new JMenuItem("Productos");
        mntmMantenimiento_Productos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        mnMantenimiento.add(mntmMantenimiento_Productos);

        // Menú Ventas
        JMenu mnVentas = new JMenu("Ventas");
        mnVentas.setFont(new Font("Segoe UI", Font.BOLD, 14));
        menuBar.add(mnVentas);

        mntmVentas = new JMenuItem("Ventas");
        mntmVentas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        mnVentas.add(mntmVentas);

        // Menú Almacén
        JMenu mnAlmacen = new JMenu("Almacen");
        mnAlmacen.setFont(new Font("Segoe UI", Font.BOLD, 14));
        menuBar.add(mnAlmacen);

        mntmAlmacen = new JMenuItem("Almacen");
        mntmAlmacen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        mnAlmacen.add(mntmAlmacen);

        // Menú Reportes
        JMenu mnReportes = new JMenu("Reportes");
        mnReportes.setFont(new Font("Segoe UI", Font.BOLD, 14));
        menuBar.add(mnReportes);

        mntmReportes = new JMenuItem("Reportes");
        mntmReportes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        mnReportes.add(mntmReportes);

        // Menú Salir
        JMenu mnSalir = new JMenu("Salir");
        mnSalir.setFont(new Font("Segoe UI", Font.BOLD, 14));
        menuBar.add(mnSalir);

        mntmSalir = new JMenuItem("Salir");
        mntmSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        mnSalir.add(mntmSalir);

        // Panel principal y escritorio
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Escritorio = new JDesktopPane();
        Escritorio.setBounds(0, 0, 1040, 580);
        contentPane.add(Escritorio);

        // Asignar listeners
        mntmMantenimiento_Clientes.addActionListener(this);
        mntmMantenimiento_Productos.addActionListener(this);
        mntmVentas.addActionListener(this);
        mntmAlmacen.addActionListener(this);
        mntmReportes.addActionListener(this);
        mntmSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mntmMantenimiento_Clientes) {
            mostrarInternalFrame(new Mantenimiento_Clientes());
        } 
        else if (e.getSource() == mntmMantenimiento_Productos) {
            mostrarInternalFrame(new Mantenimiento_Productos());
        }
        else if (e.getSource() == mntmVentas) {
            mostrarInternalFrame(new Frm_Ventas());
        }
        else if (e.getSource() == mntmAlmacen) {
            mostrarInternalFrame(new Frm_Almacen());
        }
        else if (e.getSource() == mntmReportes) {
            mostrarInternalFrame(new Frm_Reportes());
        }
        else if (e.getSource() == mntmSalir) {
            salirAlLogin();
        }
    }

    private void mostrarInternalFrame(JInternalFrame frame) {
        // Centrar el frame en el escritorio
        frame.setLocation(
            (Escritorio.getWidth() - frame.getWidth()) / 2,
            (Escritorio.getHeight() - frame.getHeight()) / 2
        );
        Escritorio.add(frame);
        frame.setVisible(true);
    }

    private void salirAlLogin() {
        this.dispose(); // Cierra la ventana actual
        new Login().setVisible(true); // Abre el login
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Menu_Principal frame = new Menu_Principal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}