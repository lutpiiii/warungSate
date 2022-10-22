package GUI;

import Helper.Db;
import allObject.allObjectController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GuiTambahMenu extends JFrame{
    Db koneksi = new Db();
    JComboBox comboBox = new JComboBox();
    private JPanel contentPane;
    private JTextField namaMakanan;
    private JTextField hargaMakanan;
    private JTextField idMakanan;
    private JButton btnBack;
    
    public GuiTambahMenu(){
        initComponent();
        tampil_combo();
    }
    
    void initComponent(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 360, 540);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\tambahmenu.jpg"));
        lblNewLabel.setBounds(0, 0, 350, 500);
        contentPane.add(lblNewLabel);

        idMakanan = new JTextField();
        idMakanan.setText("Id Makanan");
        idMakanan.setHorizontalAlignment(SwingConstants.CENTER);
        idMakanan.setColumns(10);
        idMakanan.setBackground(new Color(51, 102, 204));
        idMakanan.setForeground(Color.WHITE);
        idMakanan.setBounds(81, 238, 189, 20);
        contentPane.add(idMakanan);

        namaMakanan = new JTextField();
        namaMakanan.setText("Nama Makanan");
        namaMakanan.setHorizontalAlignment(SwingConstants.CENTER);
        namaMakanan.setColumns(10);
        namaMakanan.setBackground(new Color(51, 102, 204));
        namaMakanan.setForeground(Color.WHITE);
        namaMakanan.setBounds(81, 339, 189, 20);
        contentPane.add(namaMakanan);

        hargaMakanan = new JTextField();
        hargaMakanan.setText("Harga Makanan");
        hargaMakanan.setHorizontalAlignment(SwingConstants.CENTER);
        hargaMakanan.setColumns(10);
        hargaMakanan.setBackground(new Color(51, 102, 204));
        hargaMakanan.setForeground(Color.WHITE);
        hargaMakanan.setBounds(81, 390, 189, 20);
        contentPane.add(hargaMakanan);
        
        comboBox.setBounds(81, 287, 189, 22);
        comboBox.setBackground(new Color(45, 105, 225));
        comboBox.setForeground(Color.WHITE);
        contentPane.add(comboBox);

        JButton btnTambah = new JButton("");
        btnTambah.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\icontambahmenu.png"));
        btnTambah.setBounds(70, 436, 60, 20);
        btnTambah.setBackground(new Color(45, 105, 225));
        contentPane.add(btnTambah);

        btnBack = new JButton("");
        btnBack.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\iconkembali.png"));
        btnBack.setBounds(220, 436, 60, 20);
        btnBack.setBackground(new Color(45, 105, 225));
        contentPane.add(btnBack);
        
        btnTambah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.valueOf(idMakanan.getText());
                int idjns;
                int temp = Integer.parseInt(String.valueOf(comboBox.getSelectedIndex()));
                if(temp == 0){
                    idjns = 1;
                }else{
                    idjns = 2;
                }
                String nama = namaMakanan.getText();
                int harga = Integer.valueOf(hargaMakanan.getText());
                allObjectController.menucon.insertBarang(id, idjns, nama, harga);
                
                dispose();
                GuiTambahMenu guitambah = new GuiTambahMenu();
                guitambah.setVisible(true);
            }
        });
        
        btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                menuGui menu = new menuGui();
                menu.setVisible(true);
                dispose();
            }
        });
    }
    
    public void tampil_combo(){
        try {
            Connection con = koneksi.getconection();
            Statement stt = con.createStatement();
            String sql = "SELECT nama_jnsbrg from jnsbrg order by id_jnsbrg asc";      
            ResultSet rs = stt.executeQuery(sql);                               

            while(rs.next()){
                    comboBox.addItem(rs.getString("nama_jnsbrg"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
       GuiTambahMenu tm = new GuiTambahMenu();
       tm.setVisible(true);
    }
}
