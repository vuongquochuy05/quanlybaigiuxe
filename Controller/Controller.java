package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import View.ViewMain;

public class Controller implements ActionListener {
	private ViewMain view;

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
