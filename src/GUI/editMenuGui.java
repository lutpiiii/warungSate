package GUI;

import Helper.Db;
import allObject.allObjectController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Administrator
 */
public class editMenuGui extends JFrame{
    Db koneksi = new Db();
    JComboBox comboBox = new JComboBox();
    private JPanel contentPane;
    private JTextField namaMakanan;
    private JTextField hargaMakanan;
    private JTextField idMakanan;
    private JButton btnBack;
    
    public editMenuGui(int id){
        initComponent(id);
        tampil_combo();
    }
    
    void initComponent(final int id){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 360, 540);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\editmenu.jpg"));
        lblNewLabel.setBounds(0, 0, 350, 500);
        contentPane.add(lblNewLabel);
        try{
            Connection conn = Db.getconection();
            Statement stat = conn.createStatement();
            String sql = "SELECT * FROM barang WHERE id_barang = "+id;
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()){
                idMakanan = new JTextField();
                idMakanan.setText(rs.getString("id_barang"));
                idMakanan.setHorizontalAlignment(SwingConstants.CENTER);
                idMakanan.setColumns(10);
                idMakanan.setBackground(new Color(51, 102, 204));
                idMakanan.setForeground(Color.WHITE);
                idMakanan.setBounds(81, 238, 189, 20);
                contentPane.add(idMakanan);

                namaMakanan = new JTextField();
                namaMakanan.setText(rs.getString("nama_barang"));
                namaMakanan.setHorizontalAlignment(SwingConstants.CENTER);
                namaMakanan.setColumns(10);
                namaMakanan.setBackground(new Color(51, 102, 204));
                namaMakanan.setForeground(Color.WHITE);
                namaMakanan.setBounds(81, 339, 189, 20);
                contentPane.add(namaMakanan);

                hargaMakanan = new JTextField();
                hargaMakanan.setText(rs.getString("harga_barang"));
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
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        JButton btnedit = new JButton("");
        btnedit.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\iconEdit.png"));
        btnedit.setBounds(70, 436, 60, 20);
        btnedit.setBackground(new Color(45, 105, 225));
        contentPane.add(btnedit);

        btnBack = new JButton("");
        btnBack.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\iconkembali.png"));
        btnBack.setBounds(220, 436, 60, 20);
        btnBack.setBackground(new Color(45, 105, 225));
        contentPane.add(btnBack);
        
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                new menuGui().setVisible(true);
            }
        });
        
        btnedit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String nama_brg = namaMakanan.getText();
                int harga_brg = Integer.valueOf(hargaMakanan.getText());
                int temp = Integer.parseInt(String.valueOf(comboBox.getSelectedIndex()));
                int jenisBrg;
                if(nama_brg.length()!=0){
                    if(temp == 0){
                        jenisBrg = 1;
                    }else{
                        jenisBrg = 2;
                    }
                    allObjectController.menucon.updateBarang(id, jenisBrg, nama_brg, harga_brg);
                    
                    dispose();
                    menuGui menu = new menuGui();
                    menu.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
                }
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
 
}
