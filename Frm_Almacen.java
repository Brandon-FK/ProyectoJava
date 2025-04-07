package com.idat.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Frm_Almacen extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Almacen frame = new Frm_Almacen();
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
	public Frm_Almacen() {
		setBounds(100, 100, 450, 300);

	}

}
