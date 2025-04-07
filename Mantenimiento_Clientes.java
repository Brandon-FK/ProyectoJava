package com.idat.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import com.idat.dao.IClienteDao;
import com.idat.dao.daolmpl.ClienteDaolmpl;
import com.idat.entidades.Cliente;
import java.util.List;

public class Mantenimiento_Clientes extends JInternalFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField textID;
    private JTextField textNombre;
    private JTextField textApellidos;
    private JTextField textDireccion;
    private JTextField textTelefono;
    private JTextField textDNI;
    private JTable table;
    private DefaultTableModel model;
    private JButton btnRegistrar, btnModificar, btnConsultar, btnEliminar, btnListar;
    private IClienteDao clienteDao;

    public Mantenimiento_Clientes() {
        // Configuración de la ventana interna
        super("Mantenimiento de Clientes", true, true, true, true);
        setSize(750, 500); 
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

        clienteDao = new ClienteDaolmpl();
        
        // Creación del panel principal
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Etiqueta para el título del sistema
        JLabel lblTitulo = new JLabel("Sistema de Control de Clientes");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);
        lblTitulo.setBounds(10, 10, 714, 30);
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(new Color(0, 102, 204));
        lblTitulo.setForeground(Color.WHITE);
        contentPane.add(lblTitulo);

        // Panel izquierdo para los campos de texto
        JPanel panelCampos = new JPanel();
        panelCampos.setBorder(new LineBorder(new Color(0, 102, 204), 2));
        panelCampos.setBounds(10, 50, 489, 212);
        panelCampos.setLayout(null);
        contentPane.add(panelCampos);

        // Etiquetas y campos de texto dentro del panel izquierdo
        JLabel lblID = new JLabel("ID Cliente:");
        lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblID.setBounds(10, 10, 80, 20);
        panelCampos.add(lblID);

        textID = new JTextField();
        textID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textID.setBounds(100, 10, 379, 25);
        panelCampos.add(textID);
        textID.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNombre.setBounds(10, 41, 80, 20);
        panelCampos.add(lblNombre);

        textNombre = new JTextField();
        textNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textNombre.setBounds(100, 41, 379, 25);
        panelCampos.add(textNombre);
        textNombre.setColumns(10);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblApellidos.setBounds(10, 72, 80, 20);
        panelCampos.add(lblApellidos);

        textApellidos = new JTextField();
        textApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textApellidos.setBounds(100, 72, 379, 25);
        panelCampos.add(textApellidos);
        textApellidos.setColumns(10);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDireccion.setBounds(10, 103, 80, 20);
        panelCampos.add(lblDireccion);

        textDireccion = new JTextField();
        textDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textDireccion.setBounds(100, 103, 379, 25);
        panelCampos.add(textDireccion);
        textDireccion.setColumns(10);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTelefono.setBounds(10, 139, 80, 20);
        panelCampos.add(lblTelefono);

        textTelefono = new JTextField();
        textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textTelefono.setBounds(100, 139, 379, 25);
        panelCampos.add(textTelefono);
        textTelefono.setColumns(10);

        JLabel lblDNI = new JLabel("DNI:");
        lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDNI.setBounds(10, 170, 80, 20);
        panelCampos.add(lblDNI);

        textDNI = new JTextField();
        textDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textDNI.setBounds(99, 168, 380, 25);
        panelCampos.add(textDNI);
        textDNI.setColumns(10);

        // Panel derecho para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setBorder(new LineBorder(new Color(0, 102, 204), 2));
        panelBotones.setBounds(509, 51, 200, 211);
        panelBotones.setLayout(null);
        contentPane.add(panelBotones);

        // Botones de acciones dentro del panel derecho
        btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnModificar.setBounds(70, 11, 120, 30);
        btnModificar.addActionListener(this);
        panelBotones.add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnEliminar.setBounds(70, 52, 120, 30);
        btnEliminar.addActionListener(this);
        panelBotones.add(btnEliminar);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRegistrar.setBounds(70, 93, 120, 30);
        btnRegistrar.addActionListener(this);
        panelBotones.add(btnRegistrar);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnConsultar.setBounds(70, 134, 120, 30);
        btnConsultar.addActionListener(this);
        panelBotones.add(btnConsultar);

        btnListar = new JButton("Listar");
        btnListar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnListar.setBounds(70, 175, 120, 30);
        btnListar.addActionListener(this);
        panelBotones.add(btnListar);

        // Tabla para mostrar datos
        JPanel panelTabla = new JPanel();
        panelTabla.setBorder(new LineBorder(new Color(0, 102, 204), 2));
        panelTabla.setBounds(10, 267, 714, 193);
        panelTabla.setLayout(new BorderLayout());
        contentPane.add(panelTabla);

        model = new DefaultTableModel(
            new String[]{"ID", "Nombres", "Apellidos", "Dirección", "Teléfono", "DNI"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        table = new JTable(model);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(table);
        panelTabla.add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnListar) {
            listarClientes();
        } else if (e.getSource() == btnRegistrar) {
            registrarCliente();
        } else if (e.getSource() == btnConsultar) {
            consultarClientes();
        } else if (e.getSource() == btnModificar) {
            modificarCliente();
        } else if (e.getSource() == btnEliminar) {
            eliminarCliente();
        }
    }

    private void listarClientes() {
        limpiarTabla();
        List<Cliente> clientes = clienteDao.OperacionesLectura("consultar", new Cliente());
        clientes.forEach(c -> model.addRow(new Object[]{
            c.getCodigoCliente(),
            c.getNombres(),
            c.getApellidos(),
            c.getDireccion(),
            c.getTelefono(),
            c.getDNI()
        }));
    }

    private void registrarCliente() {
        Cliente nuevo = new Cliente(
            0,
            textNombre.getText(),
            textApellidos.getText(),
            textDireccion.getText(),
            textTelefono.getText(),
            textDNI.getText()
        );
        
        if (clienteDao.OperacionesEscritura("INSERTAR", nuevo) > 0) {
            JOptionPane.showMessageDialog(this, "Registro exitoso");
            limpiarCampos();
            listarClientes();
        }
    }

    private void consultarClientes() {
        limpiarTabla();
        Cliente filtro = new Cliente();
        if (!textID.getText().isEmpty()) filtro.setCodigoCliente(Integer.parseInt(textID.getText()));
        if (!textNombre.getText().isEmpty()) filtro.setNombres(textNombre.getText());
        if (!textDNI.getText().isEmpty()) filtro.setDni(textDNI.getText());
        
        clienteDao.OperacionesLectura("consultar", filtro).forEach(c -> 
            model.addRow(new Object[]{
                c.getCodigoCliente(),
                c.getNombres(),
                c.getApellidos(),
                c.getDireccion(),
                c.getTelefono(),
                c.getDNI()
            })
        );
    }

    private void modificarCliente() {
        if (textID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente");
            return;
        }
        
        Cliente actualizado = new Cliente(
            Integer.parseInt(textID.getText()),
            textNombre.getText(),
            textApellidos.getText(),
            textDireccion.getText(),
            textTelefono.getText(),
            textDNI.getText()
        );
        
        if (clienteDao.OperacionesEscritura("ACTUALIZAR", actualizado) > 0) {
            JOptionPane.showMessageDialog(this, "Actualización exitosa");
            listarClientes();
        }
    }

    private void eliminarCliente() {
        if (textID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente");
            return;
        }
        
        Cliente eliminar = new Cliente();
        eliminar.setCodigoCliente(Integer.parseInt(textID.getText()));
        
        if (clienteDao.OperacionesEscritura("ELIMINAR", eliminar) > 0) {
            JOptionPane.showMessageDialog(this, "Eliminación exitosa");
            limpiarCampos();
            listarClientes();
        }
    }

    private void limpiarTabla() {
        model.setRowCount(0);
    }

    private void limpiarCampos() {
        textID.setText("");
        textNombre.setText("");
        textApellidos.setText("");
        textDireccion.setText("");
        textTelefono.setText("");
        textDNI.setText("");
    }
}