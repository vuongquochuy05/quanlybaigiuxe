package DAO;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import DBConnection.DBConnection;
import Model.Modelquanly;

public class QuanlyDAO implements DAOInterface<Modelquanly> {

	@Override
	public int insert(Modelquanly t) {
		try {
			Connection c = DBConnection.getConnection();
			Statement st = c.createStatement();
			String sql = "INSERT INTO Quanly (Mã thẻ, Biển số xe, Loại xe ,Màu xe, Giá vé, Thời gian vào, Thời gian ra)"
					+ "VALUES (" + t.getMathe() + " , '" + t.getBienso() + "' , '" + t.getLoaixe() + "' , '" + t.getMauxe()
					+ "' , " + t.getGiave() + " , '" + t.getThoigianvao() + "' , '" + t.getThoigianvao() + "')";
			
			
			
			
			c.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int update(Modelquanly t) {
		// TODO Auto-generated method stub
		try {
			Connection c = DBConnection.getConnection();
			Statement st = c.createStatement();
			String sql = "UPDATE Quanly (Mã thẻ, Biển số xe, Loại xe ,Màu xe, Giá vé, Thời gian vào, Thời gian ra)"
					+ "SET (" + t.getMathe() + " , '" + t.getBienso() + "' , '" + t.getLoaixe() + "' , '" + t.getMauxe()
					+ "' , " + t.getGiave() + " , '" + t.getThoigianvao() + "' , '" + t.getThoigianvao() + "')";
			
			c.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Modelquanly t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Modelquanly> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Modelquanly selectByMa(Modelquanly t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Modelquanly> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
