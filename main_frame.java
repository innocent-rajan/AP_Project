
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

class main_frame extends JFrame {

	private JPanel contentPane;
	JPanel panel,panel_1,panel_2; 
	JComboBox comboBox;
	JLabel l1;
	query_1 y;
	query_2 z;
	boolean proceed=false;
	
	public main_frame() {
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
		
		String[] message = {"Select a Query","Query1" ,"Query2" , "Query3"};
		JComboBox comboBox = new JComboBox(message);
		comboBox.addActionListener(new combo());
		panel_1.add(comboBox);
		
		
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

	
	private class combo implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		
			JComboBox c = (JComboBox)e.getSource();
			String msg = (String)c.getSelectedItem();
			if(msg.compareTo("Query1")==0)
			{
				setVisible(false);
				query_1 y=new query_1();
				y.setSize(900,700);
				y.setVisible(true);
//				proceed=y.is_proceed();
//				while(!proceed)
//				{
//					proceed=y.is_proceed();
//				}
//				
			}
			else if(msg.compareTo("Query2")==0)
			{
				setVisible(false);
				query_2 z=new query_2();
				z.setSize(900,700);
				z.setVisible(true);
				
			}
			else if(msg.compareTo("Query3")==0)
			{
				//setVisible(false);
			}
		}
		
	}

}
