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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GuiLogin extends JFrame {
    private JPanel contentPane;
    private JTextField txtUsername;
    private JTextField txtPassword;
    
    public GuiLogin(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 592, 379);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\login2.jpg"));
        lblNewLabel.setBounds(0, 0, 584, 340);
        contentPane.add(lblNewLabel);

        txtUsername = new JTextField();
        txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
        txtUsername.setForeground(new Color(255, 255, 240));
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 11));
        txtUsername.setBackground(new Color(51, 102, 204));
        txtUsername.setText("Username");
        txtUsername.setBounds(200, 186, 224, 20);
        contentPane.add(txtUsername);
        txtUsername.setColumns(10);

        txtPassword = new JPasswordField();
        txtPassword.setText("Password");
        txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
        txtPassword.setForeground(new Color(255, 255, 240));
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 11));
        txtPassword.setColumns(10);
        txtPassword.setBackground(new Color(51, 102, 204));
        txtPassword.setBounds(200, 228, 224, 20);
        contentPane.add(txtPassword);

        JButton btnLogin = new JButton("");
        btnLogin.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\iconlogin.png"));
        btnLogin.setFont(new Font("Arial", Font.PLAIN, 11));
        btnLogin.setBackground(new Color(0, 102, 204));
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setBounds(170, 259, 66, 20);
        contentPane.add(btnLogin);

        JButton btnDaftar = new JButton("");
        btnDaftar.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\icondaftar1.png"));
        btnDaftar.setToolTipText("");
        btnDaftar.setHorizontalAlignment(SwingConstants.LEFT);
        btnDaftar.setForeground(Color.WHITE);
        btnDaftar.setFont(new Font("Arial", Font.PLAIN, 11));
        btnDaftar.setBackground(new Color(45, 105, 225));
        btnDaftar.setBounds(249, 259, 105, 20);
        contentPane.add(btnDaftar);
        
        btnDaftar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GuiDaftar().setVisible(true);
            }
        });
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String nama = txtUsername.getText();
            String password = txtPassword.getText();
            int cek2 = allObjectController.pembelicon.checkPembeli(nama, password);
            
            int cek = allObjectController.admincon.checkAdmin(nama, password);
            if (cek > 0){
                dispose();
                new adminGui().setVisible(true);
            }else{
                    if(cek2 > 0) {
                        dispose();
                        UserGui user = new UserGui(cek2);
                        user.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    }
                }
            }
        });
    }
    
    
    public static void main(String[] args) {
       GuiLogin login = new GuiLogin();
       login.setVisible(true);
    }
}
