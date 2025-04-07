package com.idat.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Mantenimiento_Productos extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mantenimiento_Productos frame = new Mantenimiento_Productos();
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
	public Mantenimiento_Productos() {
		setBounds(100, 100, 450, 300);

	}

}
