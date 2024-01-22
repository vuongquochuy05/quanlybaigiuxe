package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewDangNhap extends JFrame {
	public ViewDangNhap() {
		this.init();
		this.setVisible(true);

	}

	private String user;
	private String pass;

	public void init() {
		this.setTitle("Đăng Nhập Hệ Thống");
		this.setSize(380, 420);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);

		// Set icon notepad
		URL urlIcon = Mainview.class.getResource("icons8-user-shield-96.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
		this.setIconImage(img);

		JLabel lbe = new JLabel("Username: ");
		JLabel lbp = new JLabel("Password: ");
		JTextField jte = new JTextField(50);
		JTextField jtp = new JTextField(50);
		JButton bt = new JButton("Login");

		// Add hop dang nhap
		JPanel pn1 = new JPanel();
		pn1.setLayout(new GridLayout(4, 1, 0, 5));
		pn1.add(lbe);
		pn1.add(jte);
		pn1.add(lbp);
		pn1.add(jtp);

		// Add nut dang nhap
		JPanel pn2 = new JPanel();
		pn2.setLayout(new FlowLayout());
		pn2.add(bt);

		// Add picture
		JPanel pnpic = new JPanel();
		pnpic.setLayout(new FlowLayout());
		JLabel jllog = new JLabel();
		jllog.setIcon(new ImageIcon(Mainview.class.getResource("/Icon/log.png")));
		pnpic.add(jllog, BorderLayout.CENTER);

		// Add panel rong
		JPanel pnrong1 = new JPanel();
		pnrong1.setLayout(new BorderLayout());
		pnrong1.add(new JLabel("                  "));
		JPanel pnrong2 = new JPanel();
		pnrong2.setLayout(new BorderLayout());
		pnrong2.add(new JLabel("                  "));

		// Add panel
		JPanel pn3 = new JPanel();
		pn3.setLayout(new BorderLayout());
		pn3.add(pn1, BorderLayout.NORTH);
		pn3.add(pn2, BorderLayout.CENTER);

		this.setLayout(new BorderLayout());
		this.add(pnpic, BorderLayout.NORTH);
		this.add(pn3, BorderLayout.CENTER);
		this.add(pnrong1, BorderLayout.EAST);
		this.add(pnrong2, BorderLayout.WEST);

		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				user = jte.getText();
				pass = jtp.getText();

				if (isValidLogin(user, pass)) {
					View();
					dispose();
				} else {
					JOptionPane.showMessageDialog(ViewDangNhap.this,
							"Đăng nhập thất bại. Vui lòng kiểm tra lại thông tin đăng nhập!");
				}
			}
		});
	}

	private boolean isValidLogin(String user, String pass) {

		String url = "jdbc:sqlserver://DESKTOP-12J6D6C\\SQLEXPRESS;databaseName=Quanlybaigiuxe;"
				+ "portNumber=1433;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
		String username = "sa";
		String password = "123";

		try {
			Connection connection = DriverManager.getConnection(url, username, password);

			String query = "SELECT * FROM Dangnhap WHERE username = ? AND pasword = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);

			ResultSet resultSet = preparedStatement.executeQuery();

			return resultSet.next();
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	private void View() {
		Mainview view = new Mainview();
		view.setVisible(true);
	}

	public static void main(String[] args) {
		new ViewDangNhap();

	}
}
