package dblp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class query_2 extends JFrame{

	private JPanel contentPane;
	JPanel panel,panel_1,panel_2; 
	JComboBox comboBox;
	JLabel l1;
	private JTextField textField;

	
	public query_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout l = new GridBagLayout();
		contentPane.setLayout(l);
		
		panel = new JPanel();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth=2;
		c.weighty=0.15;
		contentPane.add(panel, c);
		
		l1 = new JLabel("DBLP Query Engine");
		l1.setFont (l1.getFont ().deriveFont (60.0f));
		panel.add(l1);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints c_1 = new GridBagConstraints();
		c_1.fill = GridBagConstraints.BOTH;
		c_1.gridx = 0;
		c_1.gridy = 1;
		c_1.weighty=0.85;
		c_1.weightx=0.20;
		contentPane.add(panel_1, c_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_3 = new JPanel();
		String[] message = {"Query2"};
		JComboBox comboBox = new JComboBox(message);
		panel_3.add(comboBox);
		panel_1.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("No. of Publications\n");
		panel_4.add(lblNewLabel);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		JButton btn1 = new JButton("Search");
		btn1.setBackground(Color.BLACK);
	    panel_5.add(btn1);
		
	    JButton btn2 = new JButton("Reset");
	    btn2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		main_frame x=new main_frame();
	    		setVisible(false);
	    		//x.setSize(600,600);
	    		x.setSize(900,700);
	    		x.setVisible(true);
	    			
	    	}
	    });
		btn2.setBackground(Color.RED);
		
		panel_5.add(btn2);
		
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints c_2 = new GridBagConstraints();
		c_2.fill = GridBagConstraints.BOTH;
		c_2.gridx = 1;
		c_2.gridy = 1;
		c_2.weightx=0.80;
		c_2.weighty=0.85;
		contentPane.add(panel_2, c_2);
		
		JLabel l2 = new JLabel("Hello Sup!!");
		panel_2.add(l2);
	}

	

		
	
}
