package DAO;

import java.util.ArrayList;

import Model.Modeldangky;

public class DangkiDAO implements DAOInterface<Modeldangky> {

	public static DangkiDAO getInstance() {
		return new DangkiDAO();
	}
	
	@Override
	public int insert(Modeldangky t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Modeldangky t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Modeldangky t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Modeldangky> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Modeldangky selectByMa(Modeldangky t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Modeldangky> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
