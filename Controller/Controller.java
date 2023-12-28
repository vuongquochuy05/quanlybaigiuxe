package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import DBConnection.DBConnection;
import View.View;

public class Controller implements ActionListener {
	private View view;

	public Controller() {
		this.view = view;
	}

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
