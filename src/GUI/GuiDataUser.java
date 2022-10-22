package GUI;

import allObject.allObjectController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GuiDataUser extends JFrame{
    private JPanel contentPane;
    private JTable tableMenu;
    JTextField textpilih = new JTextField();
    int kode;
    
    public GuiDataUser(){
        initComponent();
    }
    
    void initComponent(){
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 529);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\Menu.jpg"));
        lblNewLabel.setBounds(0, 0, 784, 490);
        contentPane.add(lblNewLabel);

        JButton btnBack = new JButton("");
        btnBack.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\iconBackMenu.png"));
        btnBack.setBounds(664, 298, 120, 40);
        btnBack.setBackground(new Color(51, 102, 204));
        btnBack.setForeground(Color.WHITE);
        contentPane.add(btnBack);

        JButton btnDelete = new JButton("");
        btnDelete.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\iconDelMenu.png"));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setBackground(new Color(51, 102, 204));
        btnDelete.setBounds(664, 229, 120, 40);
        contentPane.add(btnDelete);

        JTable tableMenu = new JTable();
        JScrollPane spMenu = new JScrollPane(tableMenu);
        spMenu.setBounds(54, 108, 530, 350);
        tableMenu.setModel(allObjectController.pembelicon.dataUser());
        contentPane.add(spMenu);
        
        tableMenu.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tableMenu.getSelectedRow();
                textpilih.setText(allObjectController.pembelicon.dataUser().getValueAt(i, 0).toString());
            }
        });
        
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                new adminGui().setVisible(true);
            }
        });
        
        btnDelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                System.out.print(kode);
                allObjectController.pembelicon.deletePembeli(kode);
                tableMenu.setModel(allObjectController.pembelicon.dataUser());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA");
                dispose();
                GuiDataUser user = new GuiDataUser();
                user.setVisible(true);
            }
        });
    }
    
    public static void main(String[] args) {
        GuiDataUser data = new GuiDataUser();
        data.setVisible(true);
    }
}
