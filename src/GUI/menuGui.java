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

public class menuGui extends JFrame{
    private JPanel contentPane;
    private JTable tableMenu;
    JTextField textpilih = new JTextField();
    int kode;
    
    public menuGui(){
        initComponent();
    }
    
    public void initComponent(){
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
        btnBack.setBounds(664, 363, 120, 40);
        btnBack.setBackground(new Color(51, 102, 204));
        btnBack.setForeground(Color.WHITE);
        contentPane.add(btnBack);

        JButton btnDelete = new JButton("");
        btnDelete.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\iconDelMenu.png"));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setBackground(new Color(51, 102, 204));
        btnDelete.setBounds(664, 298, 120, 40);
        contentPane.add(btnDelete);

        JButton btnEdit = new JButton("");
        btnEdit.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\iconEditMenu.png"));
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setBackground(new Color(51, 102, 204));
        btnEdit.setBounds(664, 229, 120, 40);
        contentPane.add(btnEdit);

        JButton btnAdd = new JButton("");
        btnAdd.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\iconAddMenu.png"));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setBackground(new Color(51, 102, 204));
        btnAdd.setBounds(664, 165, 120, 40);
        contentPane.add(btnAdd);

        JTable tableMenu = new JTable();
        JScrollPane spMenu = new JScrollPane(tableMenu);
        spMenu.setBounds(54, 108, 530, 350);
        tableMenu.setModel(allObjectController.menucon.daftarMenu());
        contentPane.add(spMenu);
        
        tableMenu.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tableMenu.getSelectedRow();
                textpilih.setText(allObjectController.menucon.daftarMenu().getValueAt(i, 0).toString());
            }
        });
        
        btnAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                GuiTambahMenu tambahMenu = new GuiTambahMenu();
                tambahMenu.setVisible(true);
                dispose();
            }
        });
        
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                int kode = Integer.valueOf(textpilih.getText());
                editMenuGui edit = new editMenuGui(kode);
                edit.setVisible(true);
            }
        });
        
        btnDelete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                allObjectController.menucon.deleteBarang(kode);
                tableMenu.setModel(allObjectController.menucon.daftarMenu());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA");
                dispose();
                menuGui menu = new menuGui();
                menu.setVisible(true);
            }
        });
        
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                new adminGui().setVisible(true);
            }
        });
    }
    
    public static void main(String[] args) {
        menuGui menu = new menuGui();
        menu.setVisible(true);
    }
}
