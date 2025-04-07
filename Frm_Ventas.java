package com.idat.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Frm_Ventas extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Ventas frame = new Frm_Ventas();
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
	public Frm_Ventas() {
		setBounds(100, 100, 450, 300);

	}

}
