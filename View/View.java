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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import javax.swing.table.DefaultTableModel;

import DBConnection.DBConnection;


public class View extends JFrame implements ActionListener {
	public View() {
		this.init();
		this.setTitle("Quản Lý Bãi Giữ Xe");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1200, 685);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void init() {

		final JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new CardLayout());

		// SET ICON NOTEPAD
		URL urlIcon = View.class.getResource("icons8-parking-lot-96.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
		this.setIconImage(img);

		// MENU
		JPanel jpmenu = new JPanel();
		jpmenu.setLayout(new FlowLayout(0));
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		menu.setBackground(Color.LIGHT_GRAY);
		JButton menuHome = new JButton("Trang chủ");
		menuHome.setBackground(Color.LIGHT_GRAY);
		menuHome.setIcon(new ImageIcon(View.class.getResource("/Icon/icons8-home-20.png")));
		JMenu menuEdit = new JMenu("Chức năng");
		menuEdit.setIcon(new ImageIcon(View.class.getResource("/Icon/icons8-feature-20.png")));
		JMenuItem menuManage = new JMenuItem("Quản lý");
		menuManage.setIcon(new ImageIcon(View.class.getResource("/Icon/icons8-find-user-male-20.png")));
		JMenuItem menuRegister = new JMenuItem("Đăng kí vé tháng");
		menuRegister.setIcon(new ImageIcon(View.class.getResource("/Icon/icons8-register-20.png")));
		JMenuItem menuThongke = new JMenuItem("Thống kê");
		menuThongke.setIcon(new ImageIcon(View.class.getResource("/Icon/icons8-circle-chart-20.png")));
		menuEdit.add(menuManage);
		menuEdit.add(menuRegister);
		menuEdit.add(menuThongke);
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
		jlback.setIcon(new ImageIcon(View.class.getResource("/Icon/BackHome.png")));
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

		// LINE TIM KIEM
		Border border1 = BorderFactory.createEtchedBorder(Color.black, Color.black);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Tìm kiếm");
		jpSearch.setBorder(borderTitle1);

		// HOP TIM KIEM
		JLabel jlma = new JLabel("Mã thẻ        ");
		JTextField jtma = new JTextField(15);
		JButton btSearch = new JButton("Tìm kiếm");
		btSearch.setIcon(new ImageIcon(View.class.getResource("/Icon/icons8-find-20.png")));
		btSearch.setFont(new java.awt.Font("Arial", Font.BOLD + Font.ITALIC, 14));

		// ADD HOP TIM KIEM
		JPanel jpMa2 = new JPanel();
		jpMa2.setLayout(new FlowLayout());
		jpMa2.add(jlma);
		jpMa2.add(jtma);
		jpMa2.add(btSearch);

		// ADD PANEL TIM KIEM
		jpSearch.add(jpMa2, BorderLayout.CENTER);

		// LINE THONG TIN
		Border border2 = BorderFactory.createEtchedBorder(Color.black, Color.black);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Thông tin");
		jpInf.setBorder(borderTitle2);

		// HOP THONG TIN
		JLabel jlBs = new JLabel("    Biển số xe");
		JLabel jlmathe = new JLabel("          Mã thẻ");
		JLabel jlloaixe = new JLabel("    Loại xe");
		JLabel jlgia = new JLabel("          Giá vé");
		JLabel jlmau = new JLabel("    Màu xe");
		JTextField jtBS = new JTextField(20);
		JTextField jtmathe = new JTextField(20);
		JTextField jtgia = new JTextField(18);
		JTextField jtmau = new JTextField(18);
		JButton jbthem = new JButton("Thêm");
		jbthem.setIcon(new ImageIcon(View.class.getResource("/Icon/icons8-add-20.png")));
		jbthem.setFont(new java.awt.Font("Arial", Font.BOLD + Font.ITALIC, 14));
		JButton jbsua = new JButton("Sửa");
		jbsua.setIcon(new ImageIcon(View.class.getResource("/Icon/icons8-update-20.png")));
		jbsua.setFont(new java.awt.Font("Arial", Font.BOLD + Font.ITALIC, 14));
		JButton jbxoa = new JButton("Xóa");
		jbxoa.setIcon(new ImageIcon(View.class.getResource("/Icon/icons8-cancel-20.png")));
		jbxoa.setFont(new java.awt.Font("Arial", Font.BOLD + Font.ITALIC, 14));

		// JCOMBOBOX LOAI XE
		JComboBox<String> cbloaixe = new JComboBox<String>();
		cbloaixe.addItem("Xe ô tô");
		cbloaixe.addItem("Xe máy");
		cbloaixe.addItem("Xe điện");
		cbloaixe.addItem("Xe đạp");

		// ADD HOP THONG TIN
		JPanel jpthongtin = new JPanel();
		jpthongtin.setLayout(new GridLayout(3, 4, 0, 5));
		jpthongtin.add(jlBs);
		jpthongtin.add(jtBS);
		jpthongtin.add(jlmathe);
		jpthongtin.add(jtmathe);
		jpthongtin.add(jlloaixe);
		jpthongtin.add(cbloaixe);
		jpthongtin.add(jlgia);
		jpthongtin.add(jtgia);
		jpthongtin.add(jlmau);
		jpthongtin.add(jtmau);

		// ADD NUT NHAN THONG TIN
		JPanel jpchange = new JPanel();
		jpchange.setLayout(new FlowLayout());
		jpchange.add(jbthem);
		jpchange.add(jbsua);
		jpchange.add(jbxoa);

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
		dm.addColumn("Thời gian ra");

		try {
			String url = "jdbc:sqlserver://DESKTOP-12J6D6C\\SQLEXPRESS;databaseName=Quanlybaigiuxe;"
					+ "portNumber=1433;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
			String username = "sa";
			String password = "123";
			Connection c = DriverManager.getConnection(url, username, password);
			Statement statement = c.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Quanly");

			while (resultSet.next()) {
				Object[] row = new Object[7];
				row[0] = resultSet.getObject(1);
				row[1] = resultSet.getObject(2);
				row[2] = resultSet.getObject(3);
				row[3] = resultSet.getObject(4);
				row[4] = resultSet.getObject(5);
				row[5] = resultSet.getObject(6);
				row[6] = resultSet.getObject(7);

				dm.addRow(row);
			}

			resultSet.close();
			statement.close();
			c.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		final JTable tbl = new JTable(dm);
		JScrollPane sc = new JScrollPane(tbl);
		jpTable.add(sc);
		jp.add(jpInf, BorderLayout.CENTER);
		jp.add(jpSearch, BorderLayout.EAST);
		JPanel jp1 = new JPanel();
		jp1.setLayout(new BorderLayout());
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
				String giave = jtgia.getText();
				try {
					String url = "jdbc:sqlserver://DESKTOP-12J6D6C\\SQLEXPRESS;databaseName=Quanlybaigiuxe;"
							+ "portNumber=1433;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
					String username = "sa";
					String password = "123";
					Connection c = DriverManager.getConnection(url, username, password);
					String sql = "INSERT INTO Quanly (Mã thẻ, Biển số xe, Loại xe ,Màu xe, Giá vé, Thời gian vào, Thời gian ra)"
							+ "VALUES (" + mathe + " , '" + bienso + "' , '" + loaixe + "' , '" + mauxe
							+ "' , " + giave +  "')";
		            try (Statement statement = c.prepareStatement(sql)) {
		                ((PreparedStatement) statement).setString(1, mathe);
		                ((PreparedStatement) statement).setString(2, bienso);
		                ((PreparedStatement) statement).setString(3, loaixe);
		                ((PreparedStatement) statement).setString(4, mauxe);
		                ((PreparedStatement) statement).setString(5, giave);
		                statement.executeUpdate(sql);
//		                JOptionPane.showMessageDialog(this, "Data added successfully.");
		            	jtmathe.setText("");
						jtBS.setText("");
						cbloaixe.setSelectedItem(cbloaixe);
						jtmau.setText("");
						jtgia.setText("");
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
//		            JOptionPane.showMessageDialog(this, "Failed to add data.");
		        }
//				Date thoigianvao = rs.getDate("Thời gian vào");
//				Date thoigianra = rs.getDate("Thời gian ra");
//				dm.addRow(new Object[] { mathe, bienso, loaixe, mauxe, giave });
//
//				jtmathe.setText("");
//				jtBS.setText("");
//				cbloaixe.setSelectedItem(cbloaixe);
//				jtmau.setText("");
//				jtgia.setText("");

			}
		});

		// ADD BUTTON XOA
		jbxoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tbl.getSelectedRow();
				dm.removeRow(selectedRow);
			}

		});
		

//		// NHAN HIEN THONG TIN TABLE
//		tbl.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				// TODO Auto-generated method stub
//				int iroww = tbl.getSelectedRow();
//				String mathe = tbl.getValueAt(iroww, 0).toString();
//				String bienso = tbl.getValueAt(iroww, 1).toString();
//				String loaixe = (String) tbl.getValueAt(iroww, 2).toString();
//				String mauxe = tbl.getValueAt(iroww, 3).toString();
//				String giave = tbl.getValueAt(iroww, 4).toString();
//
//				jtmathe.setText(mathe);
//				jtBS.setText(bienso);
//				cbloaixe.setSelectedItem(loaixe);
//				jtmau.setText(mauxe);
//				jtgia.setText(giave);
//			}
//		});
		
		
		// ADD BUTTON TIM KIEM
		 btSearch.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	              String mathe = jtma.getText();
	        try {
	        	String url = "jdbc:sqlserver://DESKTOP-12J6D6C\\SQLEXPRESS;databaseName=Quanlybaigiuxe;"
						+ "portNumber=1433;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
				String username = "sa";
				String password = "123";
				Connection c = DriverManager.getConnection(url, username, password);
	            String sql = "SELECT * FROM Quanly WHERE Mã thẻ LIKE ?";
	            PreparedStatement statement = c.prepareStatement(sql);
	            statement.setString(1, "%" + mathe + "%");
	            ResultSet resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {
	            	Object[] row = new Object[7];
					row[0] = resultSet.getObject(1);
					row[1] = resultSet.getObject(2);
					row[2] = resultSet.getObject(3);
					row[3] = resultSet.getObject(4);
					row[4] = resultSet.getObject(5);
					row[5] = resultSet.getObject(6);
					row[6] = resultSet.getObject(7);
					resultSet.close();
					statement.close();
					c.close();
	            }

	        } catch (SQLException ex) {
	            ex.printStackTrace();
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
		// JCONBOBOX LOAI XE
		JComboBox<String> cbloaixe1 = new JComboBox<String>();
		cbloaixe1.addItem("Xe ô tô");
		cbloaixe1.addItem("Xe máy");
		cbloaixe1.addItem("Xe điện");
		cbloaixe1.addItem("Xe đạp");
		JTextField jtMauxeThang = new JTextField(20);
		JTextField jtGiaveThang = new JTextField(20);
		JButton btThem = new JButton("Thêm");
		btThem.setIcon(new ImageIcon(View.class.getResource("/Icon/icons8-add-20.png")));
		btThem.setFont(new java.awt.Font("Arial", Font.BOLD + Font.ITALIC, 14));
		JButton btSua = new JButton("Sửa");
		btSua.setIcon(new ImageIcon(View.class.getResource("/Icon/icons8-update-20.png")));
		btSua.setFont(new java.awt.Font("Arial", Font.BOLD + Font.ITALIC, 14));
		JButton btXoa = new JButton("Xóa");
		btXoa.setIcon(new ImageIcon(View.class.getResource("/Icon/icons8-cancel-20.png")));
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
		pnDangki1.add(jtGiaveThang);
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
		btSearch2.setIcon(new ImageIcon(View.class.getResource("/Icon/icons8-find-20.png")));
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
		try {
			String url = "jdbc:sqlserver://DESKTOP-12J6D6C\\SQLEXPRESS;databaseName=Quanlybaigiuxe;"
					+ "portNumber=1433;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
			String username = "sa";
			String password = "123";
			Connection c = DriverManager.getConnection(url, username, password);
			Statement statement = c.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Dangki");

			while (resultSet.next()) {
				Object[] row = new Object[7];
				row[0] = resultSet.getObject(1);
				row[1] = resultSet.getObject(2);
				row[2] = resultSet.getObject(3);
				row[3] = resultSet.getObject(4);
				row[4] = resultSet.getObject(5);
				row[5] = resultSet.getObject(6);
				row[6] = resultSet.getObject(7);

				dm1.addRow(row);
			}

			resultSet.close();
			statement.close();
			c.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		final JTable tbl1 = new JTable(dm1);
		// ADD BUTTON THEM
		btThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mathe = jtMave.getText();
				String tenkh = jtTenKH.getText();
				String biensoxe = jtBSX.getText();
				String sdt = jtSdt.getText();
				String loaixethang = (String) cbloaixe1.getSelectedItem();
				String mauxethang = jtMauxeThang.getText();
				String giavethang = jtGiaveThang.getText();
				dm1.addRow(new Object[] { mathe, tenkh, biensoxe, sdt, loaixethang, mauxethang, giavethang });

				jtMave.setText("");
				jtTenKH.setText("");
				jtBSX.setText("");
				jtSdt.setText("");
				cbloaixe1.setSelectedItem(cbloaixe1);
				jtMauxeThang.setText("");
				jtGiaveThang.setText("");
			}
		});

		// ADD BUTTON XOA
		btXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tbl1.getSelectedRow();
				dm1.removeRow(selectedRow);
			}
		});

//		// NHAN HIEN THONG TIN TABLE
//		tbl1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				// TODO Auto-generated method stub
//				int irow = tbl1.getSelectedRow();
//				String mave = tbl1.getValueAt(irow, 0).toString();
//				String tenkh = tbl1.getValueAt(irow, 1).toString();
//				String biensoxe = tbl1.getValueAt(irow, 2).toString();
//				String sdt = tbl1.getValueAt(irow, 3).toString();
//				String loaixethang = (String) tbl1.getValueAt(irow, 4).toString();
//				String mauxethang = tbl1.getValueAt(irow, 5).toString();
//				String giavethang = tbl1.getValueAt(irow, 6).toString();
//
//				jtMave.setText(mave);
//				jtTenKH.setText(tenkh);
//				jtBSX.setText(biensoxe);
//				jtSdt.setText(sdt);
//				cbloaixe1.setSelectedItem(loaixethang);
//				jtMauxeThang.setText(mauxethang);
//				jtGiaveThang.setText(giavethang);
//			}
//		});

		JScrollPane sc1 = new JScrollPane(tbl1);
		pnTableDangki.add(sc1);
		JPanel jp2 = new JPanel();
		jp2.setLayout(new BorderLayout());
		jp2.add(pnTT, BorderLayout.CENTER);
		jp2.add(pnTableDangki, BorderLayout.SOUTH);
		pnCard3.add(jp2);

		// CARD 4
		final JPanel pnCard4 = new JPanel();
		pnCard4.setLayout(new BorderLayout());
		// PANEL
		JPanel pnThongke = new JPanel();
		pnThongke.setLayout(new BorderLayout());
		JPanel jpTable1 = new JPanel();
		jpTable1.setLayout(new BorderLayout());

		// LINE THONG KE
		Border border4 = BorderFactory.createEtchedBorder(Color.black, Color.black);
		TitledBorder borderTitle4 = BorderFactory.createTitledBorder(border4, "Thống kê");
		pnThongke.setBorder(borderTitle4);

		// Panel thong ke
		JPanel pnThongke1 = new JPanel();
		pnThongke1.setLayout(new FlowLayout());
		JPanel pnThongke2 = new JPanel();
		pnThongke2.setLayout(new BorderLayout());
		JPanel pnThongke3 = new JPanel();
		pnThongke3.setLayout(new GridLayout(2, 2, 15, 8));
		JPanel pnThongke4 = new JPanel();
		pnThongke4.setLayout(new FlowLayout());

		// HOP THONG KE
		JLabel jlloaixe2 = new JLabel("    Loại xe");
		JComboBox<String> cbloaixe2 = new JComboBox<String>();
		cbloaixe2.addItem("Xe ô tô");
		cbloaixe2.addItem("Xe máy");
		cbloaixe2.addItem("Xe điện");
		cbloaixe2.addItem("Xe đạp");
		cbloaixe2.addItem("Tất cả");
		JLabel jlTongxe = new JLabel("                                             Tổng số xe");
		JTextField jtTongxe = new JTextField(20);
		JLabel jlThanhtien = new JLabel("                                             Thành tiền");
		JTextField jtThanhtien = new JTextField(20);
		JButton jbThongke = new JButton("Thống kê");
		jbThongke.setIcon(new ImageIcon(View.class.getResource("/Icon/icons8-circle-chart-20.png")));
		jbThongke.setFont(new java.awt.Font("Arial", Font.BOLD + Font.ITALIC, 14));

		// ADD THONG KE
		pnThongke1.add(jlloaixe2);
		pnThongke1.add(cbloaixe2);
		pnThongke2.add(jpTable1);
		pnThongke3.add(jlTongxe);
		pnThongke3.add(jtTongxe);
		pnThongke3.add(jlThanhtien);
		pnThongke3.add(jtThanhtien);
		pnThongke4.add(jbThongke);

		// PANEL THONG KE
		JPanel pn5 = new JPanel();
		pn5.setLayout(new BorderLayout());
		pn5.add(pnThongke3, BorderLayout.CENTER);
		pn5.add(pnThongke4, BorderLayout.SOUTH);
		// ADD PANEL
		pnThongke.add(pnThongke1, BorderLayout.WEST);
		pnThongke.add(pnThongke2, BorderLayout.CENTER);
		pnThongke.add(pn5, BorderLayout.SOUTH);

		// LINE TABLE
		Border border7 = BorderFactory.createEtchedBorder(Color.black, Color.black);
		TitledBorder borderTitle7 = BorderFactory.createTitledBorder(border7, "Danh sách");
		jpTable1.setBorder(borderTitle7);

		// TABLE
		DefaultTableModel dm2 = new DefaultTableModel();
		dm2.addColumn("Mã thẻ");
		dm2.addColumn("Biển số xe");
		dm2.addColumn("Loại xe");
		dm2.addColumn("Màu xe");
		dm2.addColumn("Giá vé");
		dm2.addColumn("Thời gian vào");
		dm2.addColumn("Thời gian ra");
		
		try {
			String url = "jdbc:sqlserver://DESKTOP-12J6D6C\\SQLEXPRESS;databaseName=Quanlybaigiuxe;"
					+ "portNumber=1433;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
			String username = "sa";
			String password = "123";
			Connection c = DriverManager.getConnection(url, username, password);
			Statement statement = c.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Quanly");

			while (resultSet.next()) {
				Object[] row = new Object[7];
				row[0] = resultSet.getObject(1);
				row[1] = resultSet.getObject(2);
				row[2] = resultSet.getObject(3);
				row[3] = resultSet.getObject(4);
				row[4] = resultSet.getObject(5);
				row[5] = resultSet.getObject(6);
				row[6] = resultSet.getObject(7);

				dm2.addRow(row);
			}

			resultSet.close();
			statement.close();
			c.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		final JTable tbl2 = new JTable(dm2);
		JScrollPane sc2 = new JScrollPane(tbl2);
		jpTable1.add(sc2);
		JPanel jp3 = new JPanel();
		jp3.setLayout(new BorderLayout());
		jp3.add(pnThongke, BorderLayout.CENTER);
		pnCard4.add(jp3);

		// ADD pnCenter

		pnCenter.add(pnCard1, "Trangchu");
		pnCenter.add(pnCard2, "Quanly");
		pnCenter.add(pnCard3, "Dangki");
		pnCenter.add(pnCard4, "Thongke");

		this.setLayout(new BorderLayout());
		this.add(pnCenter);

		// ADD LISTENER

		menuHome.addActionListener(new ActionListener() {
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
		menuThongke.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) pnCenter.getLayout();
				cl.show(pnCenter, "Thongke");
			}
		});

	}

	public static void main(String[] args) {
		new View();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
