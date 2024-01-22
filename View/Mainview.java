package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import DBConnection.DBConnection;

public class Mainview extends JFrame implements ActionListener {
	public Mainview() {
		this.init();
		this.setTitle("Quản Lý Bãi Giữ Xe");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1200, 685);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void init() {

		// MAIN PANEL
		final JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new CardLayout());

		// SET ICON NOTEPAD
		URL urlIcon = Mainview.class.getResource("icons8-parking-lot-96.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
		this.setIconImage(img);

		// MENU
		JPanel jpmenu = new JPanel();
		jpmenu.setLayout(new FlowLayout(0));
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		menu.setBackground(Color.LIGHT_GRAY);
		JMenu menuHome = new JMenu("Trang chủ");
		menuHome.setIcon(new ImageIcon(Mainview.class.getResource("/Icon/icons8-home-20.png")));
		JMenuItem menuTrangchu = new JMenuItem("Trang chủ");
		menuTrangchu.setIcon(new ImageIcon(Mainview.class.getResource("/Icon/icons8-home-20.png")));
		JMenuItem menuExit = new JMenuItem("Thoát");
		menuExit.setIcon(new ImageIcon(Mainview.class.getResource("/Icon/icons8-exit-20.png")));
		JMenu menuEdit = new JMenu("Chức năng");
		menuEdit.setIcon(new ImageIcon(Mainview.class.getResource("/Icon/icons8-feature-20.png")));
		JMenuItem menuManage = new JMenuItem("Quản lý");
		menuManage.setIcon(new ImageIcon(Mainview.class.getResource("/Icon/icons8-find-user-male-20.png")));
		JMenuItem menuRegister = new JMenuItem("Đăng kí vé tháng");
		menuRegister.setIcon(new ImageIcon(Mainview.class.getResource("/Icon/icons8-register-20.png")));
		menuHome.add(menuTrangchu);
		menuHome.add(menuExit);
		menuEdit.add(menuManage);
		menuEdit.add(menuRegister);
		menu.add(menuHome);
		menu.add(menuEdit);
		this.setLayout(new BorderLayout());
		this.add(jpmenu, BorderLayout.NORTH);
		this.add(pnCenter, BorderLayout.CENTER);

		// CARD 1
		final JPanel pnCard1 = new JPanel();
		pnCard1.setLayout(new BorderLayout());
		JPanel pnback = new JPanel();
		JLabel jlback = new JLabel();
		jlback.setIcon(new ImageIcon(Mainview.class.getResource("/Icon/BackHome.png")));
		pnback.add(jlback);
		pnCard1.add(pnback);

		// CARD 2
		final JPanel pnCard2 = new JPanel();
		pnCard2.setLayout(new BorderLayout());
		// PANEL
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		JPanel jpSearch = new JPanel();
		jpSearch.setLayout(new GridLayout(2, 2));
		JPanel jpInf = new JPanel();
		jpInf.setLayout(new BorderLayout());
		JPanel jpTable = new JPanel();
		jpTable.setLayout(new BorderLayout());
		JPanel jp1 = new JPanel();
		jp1.setLayout(new BorderLayout());

		// LINE TIM KIEM
		Border border1 = BorderFactory.createEtchedBorder(Color.black, Color.black);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Tìm kiếm");
		jpSearch.setBorder(borderTitle1);

		// LINE THONG TIN
		Border border2 = BorderFactory.createEtchedBorder(Color.black, Color.black);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Thông tin");
		jpInf.setBorder(borderTitle2);

		// HOP TIM KIEM
		JLabel jlma = new JLabel("Mã thẻ        ");
		JTextField jtma = new JTextField(15);
		JButton btSearch = new JButton("Tìm kiếm");
		btSearch.setIcon(new ImageIcon(Mainview.class.getResource("/Icon/icons8-find-20.png")));
		btSearch.setFont(new java.awt.Font("Arial", Font.BOLD + Font.ITALIC, 14));

		// HOP THONG TIN
		JLabel jlBs = new JLabel("          Biển số xe");
		JLabel jlmathe = new JLabel("    Mã thẻ");
		JLabel jlloaixe = new JLabel("    Loại xe");
		JLabel jlgia = new JLabel("          Giá vé");
		JLabel jlmau = new JLabel("    Màu xe");
		JTextField jtBS = new JTextField(20);
		JTextField jtmathe = new JTextField(20);
		JTextField jtmau = new JTextField(18);
		JButton jbthem = new JButton("Thêm");
		Timestamp date1 = new Timestamp(System.currentTimeMillis());
		jbthem.setIcon(new ImageIcon(Mainview.class.getResource("/Icon/icons8-add-20.png")));
		jbthem.setFont(new java.awt.Font("Arial", Font.BOLD + Font.ITALIC, 14));
		JButton jbsua = new JButton("Sửa");
		jbsua.setIcon(new ImageIcon(Mainview.class.getResource("/Icon/icons8-update-20.png")));
		jbsua.setFont(new java.awt.Font("Arial", Font.BOLD + Font.ITALIC, 14));
		JButton jbxoa = new JButton("Xóa");
		jbxoa.setIcon(new ImageIcon(Mainview.class.getResource("/Icon/icons8-cancel-20.png")));
		jbxoa.setFont(new java.awt.Font("Arial", Font.BOLD + Font.ITALIC, 14));

		// JCOMBOBOX LOAI XE
		JComboBox<String> cbloaixe = new JComboBox<String>();
		cbloaixe.addItem("Xe ô tô");
		cbloaixe.addItem("Xe máy");
		cbloaixe.addItem("Xe điện");
		cbloaixe.addItem("Xe đạp");

		// JCOMBOBOX GIA VE
		JComboBox<String> cbgia1 = new JComboBox<String>();
		cbgia1.addItem("30.000");
		cbgia1.addItem("5.000");
		cbgia1.addItem("3.000");
		cbgia1.addItem("2.000");

		// ADD HOP TIM KIEM
		JPanel jpMa2 = new JPanel();
		jpMa2.setLayout(new FlowLayout());
		jpMa2.add(jlma);
		jpMa2.add(jtma);
		jpMa2.add(btSearch);

		// ADD HOP THONG TIN
		JPanel jpthongtin = new JPanel();
		jpthongtin.setLayout(new GridLayout(3, 4, 0, 5));
		jpthongtin.add(jlmathe);
		jpthongtin.add(jtmathe);
		jpthongtin.add(jlBs);
		jpthongtin.add(jtBS);
		jpthongtin.add(jlloaixe);
		jpthongtin.add(cbloaixe);
		jpthongtin.add(jlgia);
		jpthongtin.add(cbgia1);
		jpthongtin.add(jlmau);
		jpthongtin.add(jtmau);

		// ADD NUT NHAN THONG TIN
		JPanel jpchange = new JPanel();
		jpchange.setLayout(new FlowLayout());
		jpchange.add(jbthem);
		jpchange.add(jbsua);
		jpchange.add(jbxoa);

		// ADD PANEL TIM KIEM
		jpSearch.add(jpMa2, BorderLayout.CENTER);

		// ADD PANEL THONG TIN
		jpInf.add(jpthongtin, BorderLayout.NORTH);
		jpInf.add(jpchange, BorderLayout.SOUTH);

		// LINE TABLE
		Border border = BorderFactory.createEtchedBorder(Color.black, Color.black);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		jpTable.setBorder(borderTitle);

		// TABLE
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã thẻ");
		dm.addColumn("Biển số xe");
		dm.addColumn("Loại xe");
		dm.addColumn("Màu xe");
		dm.addColumn("Giá vé");
		dm.addColumn("Thời gian vào");

		try {
			Connection c = DBConnection.getConnection();
			Statement statement = c.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Quanly");

			while (resultSet.next()) {
				Object[] row = new Object[6];
				row[0] = resultSet.getObject(1);
				row[1] = resultSet.getObject(2);
				row[2] = resultSet.getObject(3);
				row[3] = resultSet.getObject(4);
				row[4] = resultSet.getObject(5);
				row[5] = resultSet.getObject(6);

				dm.addRow(row);
			}

			resultSet.close();
			statement.close();
			c.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		final JTable tbl = new JTable(dm);
		TableRowSorter<DefaultTableModel> row1 = new TableRowSorter<>(dm);
		tbl.setRowSorter(row1);
		JScrollPane sc = new JScrollPane(tbl);
		jpTable.add(sc);

		// ADD JPANEL
		jp.add(jpInf, BorderLayout.CENTER);
		jp.add(jpSearch, BorderLayout.EAST);
		jp1.add(jp, BorderLayout.NORTH);
		jp1.add(jpTable, BorderLayout.CENTER);
		pnCard2.add(jp1);

		// ADD BUTTON THEM
		jbthem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mathe = jtmathe.getText();
				String bienso = jtBS.getText();
				String loaixe = (String) cbloaixe.getSelectedItem();
				String mauxe = jtmau.getText();
				String giave = (String) cbgia1.getSelectedItem();
				String sql = "INSERT INTO Quanly ([Mã thẻ],[Biển số xe],[Loại xe],[Màu xe],[Giá vé],[Thời gian vào]) VALUES (?,?,?,?,?,?)";

				try {
					Connection c = DBConnection.getConnection();
					PreparedStatement preparedStatement = c.prepareStatement(sql);
					preparedStatement.setString(1, mathe);
					preparedStatement.setString(2, bienso);
					preparedStatement.setString(3, loaixe);
					preparedStatement.setString(4, mauxe);
					preparedStatement.setString(5, giave);
					preparedStatement.setTimestamp(6, date1);
					preparedStatement.executeUpdate();
					dm.addRow(new Object[] { mathe, bienso, loaixe, mauxe, giave, date1 });

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(Mainview.this,
							"Thêm thông tin không thành công! Vui lòng kiểm tra lại thông tin.");
				}

				jtmathe.setText("");
				jtBS.setText("");
				cbloaixe.setSelectedItem(cbloaixe);
				jtmau.setText("");
				cbgia1.setSelectedItem(cbgia1);

			}
		});

		// ADD BUTTON SUA
		jbsua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String mathe = jtmathe.getText();
				String bienso = jtBS.getText();
				String loaixe = (String) cbloaixe.getSelectedItem();
				String mauxe = jtmau.getText();
				String giave = (String) cbgia1.getSelectedItem();
				String sql = "UPDATE Quanly SET [Biển số xe] = ?, [Loại xe] = ?, [Màu xe] = ?, [Giá vé] = ?  WHERE [Mã thẻ] = ?";

				try {
					Connection c = DBConnection.getConnection();
					PreparedStatement preparedStatement = c.prepareStatement(sql);
					preparedStatement.setString(1, bienso);
					preparedStatement.setString(2, loaixe);
					preparedStatement.setString(3, mauxe);
					preparedStatement.setString(4, giave);
					preparedStatement.setString(5, mathe);
					preparedStatement.executeUpdate();
					int rowupdate = tbl.getSelectedRow();
					if (rowupdate != -1) {
						dm.setValueAt(Integer.parseInt(mathe), rowupdate, 0);
						dm.setValueAt(bienso, rowupdate, 1);
						dm.setValueAt(loaixe, rowupdate, 2);
						dm.setValueAt(mauxe, rowupdate, 3);
						dm.setValueAt(giave, rowupdate, 4);

					}
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

			}
		});

		// ADD BUTTON XOA
		jbxoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mathe = jtmathe.getText();
				String sql = "DELETE FROM Quanly WHERE [Mã thẻ] = ?";

				try {
					Connection c = DBConnection.getConnection();
					PreparedStatement preparedStatement = c.prepareStatement(sql);
					preparedStatement.setString(1, mathe);
					preparedStatement.executeUpdate();
					int selectedRow = tbl.getSelectedRow();
					dm.removeRow(selectedRow);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		});

		// NHAN HIEN THONG TIN TABLE
		tbl.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int iroww = tbl.getSelectedRow();
				if (iroww != -1) {
					String mathe = tbl.getValueAt(iroww, 0).toString();
					String bienso = tbl.getValueAt(iroww, 1).toString();
					String loaixe = (String) tbl.getValueAt(iroww, 2).toString();
					String mauxe = tbl.getValueAt(iroww, 3).toString();
					String giave = tbl.getValueAt(iroww, 4).toString();

					jtmathe.setText(mathe);
					jtBS.setText(bienso);
					cbloaixe.setSelectedItem(loaixe);
					jtmau.setText(mauxe);
					cbgia1.setSelectedItem(giave);
				}
			}
		});

		// ADD BUTTON TIM KIEM
		btSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mathe = jtma.getText();
				if (mathe.trim().length() == 0) {
					row1.setRowFilter(null);
				} else {
					row1.setRowFilter(RowFilter.regexFilter(mathe));
				}
			}
		});

		// CARD 3
		final JPanel pnCard3 = new JPanel();
		pnCard3.setLayout(new BorderLayout());

		// PANEL
		JPanel pnTT = new JPanel();
		pnTT.setLayout(new BorderLayout());
		JPanel pnDangki = new JPanel();
		pnDangki.setLayout(new BorderLayout());
		JPanel pnTableDangki = new JPanel();
		pnTableDangki.setLayout(new BorderLayout());
		JPanel pnDangki1 = new JPanel();
		pnDangki1.setLayout(new GridLayout(4, 4, 0, 5));
		JPanel pnDangki2 = new JPanel();
		pnDangki2.setLayout(new FlowLayout());

		// LINE DANG KI
		Border border5 = BorderFactory.createEtchedBorder(Color.black, Color.black);
		TitledBorder borderTitle5 = BorderFactory.createTitledBorder(border5, "Thông Tin Vé Tháng");
		pnDangki.setBorder(borderTitle5);

		// HOP THONG TIN
		JLabel jlMave = new JLabel("    Mã Vé");
		JLabel jlTenKH = new JLabel("    Tên Khách Hàng");
		JLabel jlBSX = new JLabel("    Biển Số Xe");
		JLabel jlSdt = new JLabel("    Số Điện Thoại");
		JLabel jlLoaixeThang = new JLabel("          Loại Xe");
		JLabel jlMauxeThang = new JLabel("          Màu Xe");
		JLabel jlGiaveThang = new JLabel("          Giá Vé");
		JTextField jtMave = new JTextField(20);
		JTextField jtTenKH = new JTextField(20);
		JTextField jtBSX = new JTextField(20);
		JTextField jtSdt = new JTextField(20);
		Timestamp date2 = new Timestamp(System.currentTimeMillis());

		// JCONBOBOX LOAI XE
		JComboBox<String> cbloaixe1 = new JComboBox<String>();
		cbloaixe1.addItem("Xe ô tô");
		cbloaixe1.addItem("Xe máy");
		cbloaixe1.addItem("Xe điện");
		cbloaixe1.addItem("Xe đạp");
		JTextField jtMauxeThang = new JTextField(20);

		// JCOMBOBOX GIA VE
		JComboBox<String> cbgia2 = new JComboBox<String>();
		cbgia2.addItem("100.000");
		cbgia2.addItem("50.000");
		cbgia2.addItem("30.000");
		cbgia2.addItem("20.000");

		JButton btThem = new JButton("Thêm");
		btThem.setIcon(new ImageIcon(Mainview.class.getResource("/Icon/icons8-add-20.png")));
		btThem.setFont(new java.awt.Font("Arial", Font.BOLD + Font.ITALIC, 14));
		JButton btSua = new JButton("Sửa");
		btSua.setIcon(new ImageIcon(Mainview.class.getResource("/Icon/icons8-update-20.png")));
		btSua.setFont(new java.awt.Font("Arial", Font.BOLD + Font.ITALIC, 14));
		JButton btXoa = new JButton("Xóa");
		btXoa.setIcon(new ImageIcon(Mainview.class.getResource("/Icon/icons8-cancel-20.png")));
		btXoa.setFont(new java.awt.Font("Arial", Font.BOLD + Font.ITALIC, 14));

		// ADD THONG TIN
		pnDangki1.add(jlMave);
		pnDangki1.add(jtMave);
		pnDangki1.add(jlLoaixeThang);
		pnDangki1.add(cbloaixe1);
		pnDangki1.add(jlTenKH);
		pnDangki1.add(jtTenKH);
		pnDangki1.add(jlMauxeThang);
		pnDangki1.add(jtMauxeThang);
		pnDangki1.add(jlBSX);
		pnDangki1.add(jtBSX);
		pnDangki1.add(jlGiaveThang);
		pnDangki1.add(cbgia2);
		pnDangki1.add(jlSdt);
		pnDangki1.add(jtSdt);

		pnDangki2.add(btThem);
		pnDangki2.add(btSua);
		pnDangki2.add(btXoa);

		pnDangki.add(pnDangki1, BorderLayout.CENTER);
		pnDangki.add(pnDangki2, BorderLayout.SOUTH);

		// LINE TIM KIEM
		JPanel jpSearch2 = new JPanel();
		Border border8 = BorderFactory.createEtchedBorder(Color.black, Color.black);
		TitledBorder borderTitle8 = BorderFactory.createTitledBorder(border8, "Tìm kiếm");
		jpSearch2.setBorder(borderTitle8);

		// HOP TIM KIEM
		JLabel jlmave = new JLabel("Mã thẻ        ");
		JTextField jtmave = new JTextField(15);
		JButton btSearch2 = new JButton("Tìm kiếm");
		btSearch2.setIcon(new ImageIcon(Mainview.class.getResource("/Icon/icons8-find-20.png")));
		btSearch2.setFont(new java.awt.Font("Arial", Font.BOLD + Font.ITALIC, 14));

		// ADD HOP TIM KIEM
		JPanel jpMa3 = new JPanel();
		jpMa3.setLayout(new FlowLayout());
		jpMa3.add(jlmave);
		jpMa3.add(jtmave);
		jpMa3.add(btSearch2);

		// ADD PANEL TIM KIEM
		jpSearch2.add(jpMa3, BorderLayout.CENTER);
		pnTT.add(pnDangki, BorderLayout.CENTER);
		pnTT.add(jpSearch2, BorderLayout.EAST);

		// LINE TABLE
		Border border6 = BorderFactory.createEtchedBorder(Color.black, Color.black);
		TitledBorder borderTitle6 = BorderFactory.createTitledBorder(border6, "Danh sách");
		pnTableDangki.setBorder(borderTitle6);

		// TABLE
		DefaultTableModel dm1 = new DefaultTableModel();
		dm1.addColumn("Mã Vé");
		dm1.addColumn("Tên Khách Hàng");
		dm1.addColumn("Biển Số Xe");
		dm1.addColumn("Số Điện Thoại");
		dm1.addColumn("Loại xe");
		dm1.addColumn("Màu Xe");
		dm1.addColumn("Giá Vé");
		dm1.addColumn("Ngày đăng kí");
		try {
			Connection c = DBConnection.getConnection();
			Statement statement = c.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Dangki");

			while (resultSet.next()) {
				Object[] row = new Object[8];
				row[0] = resultSet.getObject(1);
				row[1] = resultSet.getObject(2);
				row[2] = resultSet.getObject(3);
				row[3] = resultSet.getObject(4);
				row[4] = resultSet.getObject(5);
				row[5] = resultSet.getObject(6);
				row[6] = resultSet.getObject(7);
				row[7] = resultSet.getObject(8);

				dm1.addRow(row);
			}

			resultSet.close();
			statement.close();
			c.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		final JTable tbl1 = new JTable(dm1);
		TableRowSorter<DefaultTableModel> roww = new TableRowSorter<>(dm1);
		tbl1.setRowSorter(roww);
		// ADD BUTTON THEM
		btThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mave = jtMave.getText();
				String tenkh = jtTenKH.getText();
				String biensoxe = jtBSX.getText();
				String sdt = jtSdt.getText();
				String loaixethang = (String) cbloaixe1.getSelectedItem();
				String mauxethang = jtMauxeThang.getText();
				String giavethang = (String) cbgia2.getSelectedItem();
				String sql = "INSERT INTO Dangki ([Mã thẻ],[Tên khách hàng],[Biển số xe],[Số điện thoại],[Loại xe],[Màu xe],[Giá vé],[Ngày đăng kí]) VALUES (?,?,?,?,?,?,?,?)";
				try {
					Connection c = DBConnection.getConnection();
					PreparedStatement preparedStatement = c.prepareStatement(sql);
					preparedStatement.setString(1, mave);
					preparedStatement.setString(2, tenkh);
					preparedStatement.setString(3, biensoxe);
					preparedStatement.setString(4, sdt);
					preparedStatement.setString(5, loaixethang);
					preparedStatement.setString(6, mauxethang);
					preparedStatement.setString(7, giavethang);
					preparedStatement.setTimestamp(8, date2);
					preparedStatement.executeUpdate();
					dm1.addRow(new Object[] { mave, tenkh, biensoxe, sdt, loaixethang, mauxethang, giavethang, date2 });

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(Mainview.this,
							"Thêm thông tin không thành công! Vui lòng kiểm tra lại thông tin.");
				}

				jtMave.setText("");
				jtTenKH.setText("");
				jtBSX.setText("");
				jtSdt.setText("");
				cbloaixe1.setSelectedItem(cbloaixe1);
				jtMauxeThang.setText("");
				cbgia2.setSelectedItem(cbgia2);
			}
		});

		// ADD BUTTON SUA
		btSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String mave = jtMave.getText();
				String tenkh = jtTenKH.getText();
				String biensoxe = jtBSX.getText();
				String sdt = jtSdt.getText();
				String loaixethang = (String) cbloaixe1.getSelectedItem();
				String mauxethang = jtMauxeThang.getText();
				String giavethang = (String) cbgia2.getSelectedItem();
				String sql = "UPDATE Dangki SET [Tên khách hàng] = ?, [Biển số xe] = ?, [Số điện thoại] = ?, [Loại xe] = ?, [Màu xe] = ?, [Giá vé] = ?  WHERE [Mã thẻ] = ?";

				try {
					Connection c = DBConnection.getConnection();
					PreparedStatement preparedStatement = c.prepareStatement(sql);
					preparedStatement.setString(1, tenkh);
					preparedStatement.setString(2, biensoxe);
					preparedStatement.setString(3, sdt);
					preparedStatement.setString(4, loaixethang);
					preparedStatement.setString(5, mauxethang);
					preparedStatement.setString(6, giavethang);
					preparedStatement.setString(7, mave);
					preparedStatement.executeUpdate();
					int rowupdate1 = tbl1.getSelectedRow();
					if (rowupdate1 != -1) {
						dm1.setValueAt(Integer.parseInt(mave), rowupdate1, 0);
						dm1.setValueAt(tenkh, rowupdate1, 1);
						dm1.setValueAt(biensoxe, rowupdate1, 2);
						dm1.setValueAt(sdt, rowupdate1, 3);
						dm1.setValueAt(loaixethang, rowupdate1, 4);
						dm1.setValueAt(mauxethang, rowupdate1, 5);
						dm1.setValueAt(giavethang, rowupdate1, 6);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		// ADD BUTTON XOA
		btXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mave = jtMave.getText();
				String sql = "DELETE FROM Dangki WHERE [Mã thẻ] = ?";
				try {
					Connection c = DBConnection.getConnection();
					PreparedStatement preparedStatement = c.prepareStatement(sql);
					preparedStatement.setString(1, mave);
					preparedStatement.executeUpdate();
					int selectedRow = tbl1.getSelectedRow();
					dm1.removeRow(selectedRow);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		});

		// ADD BUTTON TIM KIEM
		btSearch2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mave = jtmave.getText();
				if (mave.trim().length() == 0) {
					roww.setRowFilter(null);
				} else {
					roww.setRowFilter(RowFilter.regexFilter(mave));
				}
			}
		});

		// NHAN HIEN THONG TIN TABLE
		tbl1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int irow = tbl1.getSelectedRow();
				if (irow != -1) {
					String mave = tbl1.getValueAt(irow, 0).toString();
					String tenkh = tbl1.getValueAt(irow, 1).toString();
					String biensoxe = tbl1.getValueAt(irow, 2).toString();
					String sdt = tbl1.getValueAt(irow, 3).toString();
					String loaixethang = (String) tbl1.getValueAt(irow, 4).toString();
					String mauxethang = tbl1.getValueAt(irow, 5).toString();
					String giavethang = (String) tbl1.getValueAt(irow, 6).toString();

					jtMave.setText(mave);
					jtTenKH.setText(tenkh);
					jtBSX.setText(biensoxe);
					jtSdt.setText(sdt);
					cbloaixe1.setSelectedItem(loaixethang);
					jtMauxeThang.setText(mauxethang);
					cbgia2.setSelectedItem(giavethang);
				}
			}
		});

		JScrollPane sc1 = new JScrollPane(tbl1);
		pnTableDangki.add(sc1);
		JPanel jp2 = new JPanel();
		jp2.setLayout(new BorderLayout());
		jp2.add(pnTT, BorderLayout.CENTER);
		jp2.add(pnTableDangki, BorderLayout.SOUTH);
		pnCard3.add(jp2);

		// ADD pnCenter

		pnCenter.add(pnCard1, "Trangchu");
		pnCenter.add(pnCard2, "Quanly");
		pnCenter.add(pnCard3, "Dangki");

		this.setLayout(new BorderLayout());
		this.add(pnCenter);

		// ADD LISTENER

		menuTrangchu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) pnCenter.getLayout();
				cl.show(pnCenter, "Trangchu");
			}
		});
		menuManage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) pnCenter.getLayout();
				cl.show(pnCenter, "Quanly");
			}
		});
		menuRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) pnCenter.getLayout();
				cl.show(pnCenter, "Dangki");
			}
		});
		menuExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

	}

	public static void main(String[] args) {
		new Mainview();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
