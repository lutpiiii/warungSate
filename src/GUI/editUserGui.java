/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import allObject.allObjectController;
import entity.pembeliEntity;
import java.awt.Color;
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

/**
 *
 * @author Administrator
 */
public class editUserGui extends JFrame{
    private JPanel contentPane;
    private JTextField editnotelp;
    private JTextField alamatedit;
    private JTextField namaedit;
    private JButton btnBack;
    private JTextField passedit;
    private String nama, pass, notelp, alamat;
    
    public editUserGui(int id){
        initComponent(id);
    }
    
    void initComponent(final int id){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 360, 540);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        for(pembeliEntity p : allObjectController.pembelicon.getDataById(id)){
            this.nama = p.getNama();
            this.pass = p.getPass();
            this.notelp = p.getNotelp();
            this.alamat = p.getAlamat();
        }
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\editprofil.jpg"));
        lblNewLabel.setBounds(0, 0, 350, 500);
        contentPane.add(lblNewLabel);

        namaedit = new JTextField();
        namaedit.setHorizontalAlignment(SwingConstants.CENTER);
        namaedit.setColumns(10);
        namaedit.setBackground(new Color(51, 102, 204));
        namaedit.setForeground(Color.WHITE);
        namaedit.setBounds(81, 238, 189, 20);
        contentPane.add(namaedit);
        namaedit.setText(this.nama);

        passedit = new JTextField();
        passedit.setText(pass);
        passedit.setHorizontalAlignment(SwingConstants.CENTER);
        passedit.setForeground(Color.WHITE);
        passedit.setColumns(10);
        passedit.setBackground(new Color(51, 102, 204));
        passedit.setBounds(81, 289, 189, 20);
        contentPane.add(passedit);
                
        editnotelp = new JTextField();
        editnotelp.setText(notelp);
        editnotelp.setHorizontalAlignment(SwingConstants.CENTER);
        editnotelp.setColumns(10);
        editnotelp.setBackground(new Color(51, 102, 204));
        editnotelp.setForeground(Color.WHITE);
        editnotelp.setBounds(81, 339, 189, 20);
        contentPane.add(editnotelp);

        alamatedit = new JTextField();
        alamatedit.setText(alamat);
        alamatedit.setHorizontalAlignment(SwingConstants.CENTER);
        alamatedit.setColumns(10);
        alamatedit.setBackground(new Color(51, 102, 204));
        alamatedit.setForeground(Color.WHITE);
        alamatedit.setBounds(81, 390, 189, 20);
        contentPane.add(alamatedit);
    
        JButton btnUbah = new JButton("");
        btnUbah.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\iconedit.png"));
        btnUbah.setBounds(70, 436, 60, 20);
        btnUbah.setBackground(new Color(45, 105, 225));
        contentPane.add(btnUbah);

        btnBack = new JButton("");
        btnBack.setIcon(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WarungSate\\src\\gambar\\iconkembali.png"));
        btnBack.setBounds(220, 436, 60, 20);
        btnBack.setBackground(new Color(45, 105, 225));
        contentPane.add(btnBack);
    
        btnUbah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = namaedit.getText();
                String pass = passedit.getText();
                String notelp = editnotelp.getText();
                String alamat = alamatedit.getText();
                if(nama.length() != 0 && pass.length() != 0 && notelp.length() != 0 && alamat.length() != 0){
                    allObjectController.pembelicon.updatePembeli(id, nama, pass, notelp, alamat);
                    dispose();
                    UserGui user = new UserGui(id);
                    user.setVisible(true);
                }else{
                   JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
                }
            }
        });
        
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                new UserGui(id).setVisible(true);
            }
        });
    }
}
