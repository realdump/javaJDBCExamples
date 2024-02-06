package com.abmn.jdbc;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudentSearchFrame extends Frame implements ActionListener {
	
	Label l1;
	TextField tf1;
	Button b1;
	StudentTo sto;
	public StudentSearchFrame() {
		this.setVisible(true);
		this.setSize(500, 500);
		this.setTitle("Student Search Frame");
		this.setLayout(new FlowLayout());
		this.setBackground(Color.green);
		this.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we){
		System.exit(0);
		}
		});
		l1=new Label("Student Id");
		tf1=new TextField(20);
		b1=new Button("Search");
		b1.addActionListener(this);
		Font f=new Font("arial",Font.BOLD,20);
		l1.setFont(f);
		tf1.setFont(f);
		b1.setFont(f);
		this.add(l1);
		this.add(tf1);
		this.add(b1);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String sid=tf1.getText();
		StudentService ss=new StudentService();
		sto=ss.search(sid);
		repaint();
	}
	public void paint(Graphics g){
		Font f=new Font("arial",Font.BOLD,30);
		g.setFont(f);
		if(sto==null){
		g.drawString("Student Not Existed", 50, 300);
		}else{
		g.drawString("Student Id :"+sto.getSid(), 50, 250);
		g.drawString("Student Name :"+sto.getSname(), 50, 300);
		g.drawString("Student Address :"+sto.getSaddr(), 50, 350);
		}
	}
}

