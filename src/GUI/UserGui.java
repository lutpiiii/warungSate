package GUI;

import allObject.allObjectController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class UserGui extends JFrame{
    JLabel tes = new JLabel();
    JTextField textpilih = new JTextField();
    JTable tableMenu = new JTable();
    JScrollPane spMenu = new JScrollPane(tableMenu);
    JTable tableMenu2 = new JTable();
    JScrollPane spMenu2 = new JScrollPane(tableMenu2);
    int kode;
    
    public UserGui(int cek) {
        initComponent(cek);
    }
    
    
    public void initComponent(final int cek){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 529);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorderPainted(false);
        menuBar.setBackground(new Color(51, 102, 204));
        menuBar.setMargin(new Insets(0, 0, 0, 0));
        setJMenuBar(menuBar);
        
        JMenu mnNewMenu = new JMenu("");
        mnNewMenu.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\iconprofil.png"));
        menuBar.add(mnNewMenu);
        
        JMenuItem item1 = new JMenuItem("Ubah Profil");
        item1.setForeground(Color.BLACK);
        item1.setBackground(Color.WHITE);
        mnNewMenu.add(item1);
        
        JMenuItem item2 = new JMenuItem("Log out");
        item2.setForeground(Color.BLACK);
        item2.setBackground(Color.WHITE);
        mnNewMenu.add(item2);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(51, 102, 204));
        menuBar.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\logouser.png"));
        lblNewLabel.setBounds(442, 0, 265, 59);
        panel.add(lblNewLabel);
        
        String nama = allObjectController.pembelicon.getNama(cek);
        
        JLabel label = new JLabel();
        label.setText(nama);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Courier New", Font.BOLD, 30));
        label.setBounds(10, 0, 65, 59);
        panel.add(label);
        getContentPane().setLayout(null);
        
        spMenu.setBounds(295, 0, 500, 200);
        tableMenu.setModel(allObjectController.menucon.daftarMenu());
        this.add(spMenu);
        
        spMenu2.setBounds(295, 230, 500, 200);
        tableMenu2.setModel(allObjectController.transaksicon.dataTransaksi());
        this.add(spMenu2);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\menuUser.jpg"));
        lblNewLabel_2.setBounds(0, -11, 784, 440);
        getContentPane().add(lblNewLabel_2);
        
        JTextField Nama = new JTextField();
        Nama.setBounds(10, 99, 254, 31);
        getContentPane().add(Nama);
        Nama.setColumns(10);
        
        JTextField harga = new JTextField();
        harga.setColumns(10);
        harga.setBounds(10, 141, 254, 31);
        getContentPane().add(harga);
        
        JTextField banyak = new JTextField();
        banyak.setColumns(10);
        banyak.setBounds(10, 183, 254, 31);
        getContentPane().add(banyak);
        
        JTextField total = new JTextField();
        total.setColumns(10);
        total.setBounds(10, 225, 254, 31);
        getContentPane().add(total);
        
        JButton btnPesan = new JButton("");
        btnPesan.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\iconPesanUser.png"));
        btnPesan.setBounds(52, 277, 60, 20);
        getContentPane().add(btnPesan);
        
        btnPesan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int total_harga = Integer.parseInt(total.getText());
              int lastId = allObjectController.transaksicon.transaksi(cek, total_harga);
              allObjectController.transaksicon.detail_transaksi(lastId, 6);
              JOptionPane.showMessageDialog(null, "Transaksi Berhasil");
              tableMenu2.setModel(allObjectController.transaksicon.dataTransaksi());
            }
        });
        
        JButton btnTambah = new JButton("");
        btnTambah.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\iconTambahUser.png"));
        btnTambah.setBounds(164, 277, 60, 20);
        getContentPane().add(btnTambah);
        
        btnTambah.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                    int jum = Integer.parseInt(banyak.getText());
                    int hrg = Integer.parseInt(harga.getText());
                    
                    int ttl = jum*hrg;
                    total.setText(String.valueOf(ttl));
                
            }
        });
        
        tableMenu.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tableMenu.getSelectedRow();
                textpilih.setText(allObjectController.menucon.daftarMenu().getValueAt(i, 0).toString());
            }
        });
        
        item1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                editUserGui edit = new editUserGui(cek);
                edit.setVisible(true);
                dispose();
            }
        });
        
        item2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                GuiLogin login = new GuiLogin();
                login.setVisible(true);
                dispose();
            }
        });
        
        tableMenu.addMouseListener(new MouseAdapter()
		{
                    @Override
			public void mouseClicked(MouseEvent me)
			{
				int pilih = tableMenu.getSelectedRow();
				if(pilih == -1)
				{
					return;
				}
                                tableMenu.getValueAt(pilih, 0);
                                
				String nama = (String) tableMenu.getValueAt(pilih, 1);
                                Nama.setText(nama);
                                
				int hrgbrg = (int) tableMenu.getValueAt(pilih, 2);
                                String hrg = String.valueOf(hrgbrg);
                                harga.setText(hrg);
                        }
		});
    }
}

