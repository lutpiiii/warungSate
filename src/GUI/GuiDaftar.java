package GUI;

import allObject.allObjectController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GuiDaftar extends JFrame{
    private JPanel contentPane;
    private JTextField txtNama;
    private JTextField txtPassword;
    private JTextField txtNomorHp;
    private JTextField txtAlamat;
    private JButton btnLogin;
    
    public GuiDaftar(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("Daftar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\daftar.jpg"));
        lblNewLabel.setBounds(0, 0, 334, 511);
        contentPane.add(lblNewLabel);

        JButton btnDaftar = new JButton("");
        btnDaftar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnDaftar.setForeground(Color.WHITE);
        btnDaftar.setBackground(new Color(45, 105, 225));
        btnDaftar.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\icondaftar.png"));
        btnDaftar.setBounds(72, 436, 60, 20);
        contentPane.add(btnDaftar);

        txtNama = new JTextField();
        txtNama.setHorizontalAlignment(SwingConstants.CENTER);
        txtNama.setText("Nama");
        txtNama.setBounds(82, 243, 189, 20);
        txtNama.setBackground(new Color(51, 102, 204));
        txtNama.setForeground(new Color(255, 255, 240));
        contentPane.add(txtNama);
        txtNama.setColumns(10);

        txtPassword = new JTextField();
        txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
        txtPassword.setText("Password");
        txtPassword.setColumns(10);
        txtPassword.setBounds(82, 293, 189, 20);
        txtPassword.setBackground(new Color(51, 102, 204));
        txtPassword.setForeground(new Color(255, 255, 240));
        contentPane.add(txtPassword);

        txtNomorHp = new JTextField();
        txtNomorHp.setHorizontalAlignment(SwingConstants.CENTER);
        txtNomorHp.setText("Nomor Hp");
        txtNomorHp.setColumns(10);
        txtNomorHp.setBounds(82, 344, 189, 20);
        txtNomorHp.setBackground(new Color(51, 102, 204));
        txtNomorHp.setForeground(new Color(255, 255, 240));
        contentPane.add(txtNomorHp);

        txtAlamat = new JTextField();
        txtAlamat.setHorizontalAlignment(SwingConstants.CENTER);
        txtAlamat.setText("Alamat");
        txtAlamat.setColumns(10);
        txtAlamat.setBounds(82, 394, 189, 20);
        txtAlamat.setBackground(new Color(51, 102, 204));
        txtAlamat.setForeground(new Color(255, 255, 240));
        contentPane.add(txtAlamat);

        btnLogin = new JButton("");
        btnLogin.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\iconlogin1.png"));
        btnLogin.setBounds(186, 436, 95, 20);
        btnLogin.setBackground(new Color(51, 102, 204));
        contentPane.add(btnLogin);
        
        btnDaftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dispose();
                    allObjectController.pembelicon.insertPembeli(0, txtNama.getText(), txtPassword.getText(), txtNomorHp.getText(), txtAlamat.getText());
                    JOptionPane.showMessageDialog(null, "Sukses Tambah Data !!");
                    new GuiLogin().setVisible(true);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Gagal Tambah Data !!");
                }
            }
        });
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GuiLogin().setVisible(true);
            }
        });
    }
    
    public static void main(String[] args) {
       GuiDaftar daftar = new GuiDaftar();
       daftar.setVisible(true);
    }
}
