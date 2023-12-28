package Model;

import java.sql.Date;

public class Modelquanly {
	private int mathe;
	private String bienso;
	private String loaixe;
	private String mauxe;
	private int giave;
	private Date thoigianvao;
	private Date thoigianra;

	public Modelquanly() {
	}

	public Modelquanly(int mathe, String bienso, String loaixe, String mauxe, int giave, Date thoigianvao,
			Date thoigianra) {
		this.mathe = mathe;
		this.bienso = bienso;
		this.loaixe = loaixe;
		this.mauxe = mauxe;
		this.giave = giave;
		this.thoigianvao = thoigianvao;
		this.thoigianra = thoigianra;
	}

	public int getMathe() {
		return mathe;
	}

	public void setMathe(int mathe) {
		this.mathe = mathe;
	}

	public String getBienso() {
		return bienso;
	}

	public void setBienso(String bienso) {
		this.bienso = bienso;
	}

	public String getLoaixe() {
		return loaixe;
	}

	public void setLoaixe(String loaixe) {
		this.loaixe = loaixe;
	}

	public String getMauxe() {
		return mauxe;
	}

	public void setMauxe(String mauxe) {
		this.mauxe = mauxe;
	}

	public int getGiave() {
		return giave;
	}

	public void setGiave(int giave) {
		this.giave = giave;
	}

	public Date getThoigianvao() {
		return thoigianvao;
	}

	public void setThoigianvao(Date thoigianvao) {
		this.thoigianvao = thoigianvao;
	}

	public Date getThoigianra() {
		return thoigianra;
	}

	public void setThoigianra(Date thoigianra) {
		this.thoigianra = thoigianra;
	}

}
