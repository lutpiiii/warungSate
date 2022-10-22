package GUI;

import allObject.allObjectController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class adminGui extends JFrame{
    private JPanel contentPane;
    JTable tableMenu2 = new JTable();
    JScrollPane spMenu2 = new JScrollPane(tableMenu2);
    int kode;
    JTextField textpilih = new JTextField();
    
    public adminGui() {
        initComponent();
    }
    
    public void initComponent(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 529);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\menuAdmin.jpg"));
        lblNewLabel.setBounds(0, 0, 800, 529);
        contentPane.add(lblNewLabel);
        
        JButton btnBack = new JButton("");
        btnBack.setBackground(new Color(198, 212, 242));
        btnBack.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\iconbacklogin.png"));
        btnBack.setBounds(29, 344, 80, 80);
        contentPane.add(btnBack);
        
        JButton btnUser = new JButton("");
        btnUser.setBackground(new Color(198, 212, 242));
        btnUser.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\icondaftarUser.png"));
        btnUser.setBounds(29, 127, 88, 83);
        contentPane.add(btnUser);
        
        JButton btnMenu = new JButton("");
        btnMenu.setBackground(new Color(198, 212, 242));
        btnMenu.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\icondaftarMenu.png"));
        btnMenu.setBounds(37, 241, 60, 70);
        contentPane.add(btnMenu);
        
        JButton confirm = new JButton("CONFIRM");
        confirm.setBounds(512, 374, 89, 23);
        getContentPane().add(confirm);
        
        spMenu2.setBounds(160, 78, 650, 600);
        tableMenu2.setModel(allObjectController.transaksicon.dataTransaksi());
        this.add(spMenu2);
        
        tableMenu2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tableMenu2.getSelectedRow();
                textpilih.setText(allObjectController.transaksicon.dataTransaksi().getValueAt(i, 0).toString());
            }
        });
        
        confirm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                allObjectController.transaksicon.sBayar(kode);
                tableMenu2.setModel(allObjectController.transaksicon.dataTransaksi());
            }
        });
        
        btnUser.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                new GuiDataUser().setVisible(true);
            }
        });
        
        btnMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                new menuGui().setVisible(true);
            }
        });
        
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                new GuiLogin().setVisible(true);
            }
        });
    }
    
    public static void main(String[] args) {
        adminGui admin = new adminGui();
        admin.setVisible(true);
    }
}
