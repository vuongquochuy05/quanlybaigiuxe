package Model;

public class Modeldangky {
	private int mave;
	private String tenkh;
	private String biensoxe;
	private int sdt;
	private String loaixedangki;
	private String mauxedangki;
	private int giavedangki;

	public Modeldangky() {
	}

	public Modeldangky(int mave, String tenkh, String biensoxe, int sdt, String loaixedangki, String mauxedangki,
			int giavedangki) {
		this.mave = mave;
		this.tenkh = tenkh;
		this.biensoxe = biensoxe;
		this.sdt = sdt;
		this.loaixedangki = loaixedangki;
		this.mauxedangki = mauxedangki;
		this.giavedangki = giavedangki;
	}

	public int getMave() {
		return mave;
	}

	public void setMave(int mave) {
		this.mave = mave;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getBiensoxe() {
		return biensoxe;
	}

	public void setBiensoxe(String biensoxe) {
		this.biensoxe = biensoxe;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public String getLoaixedangki() {
		return loaixedangki;
	}

	public void setLoaixedangki(String loaixedangki) {
		this.loaixedangki = loaixedangki;
	}

	public String getMauxedangki() {
		return mauxedangki;
	}

	public void setMauxedangki(String mauxedangki) {
		this.mauxedangki = mauxedangki;
	}

	public int getGiavedangki() {
		return giavedangki;
	}

	public void setGiavedangki(int giavedangki) {
		this.giavedangki = giavedangki;
	}

}
