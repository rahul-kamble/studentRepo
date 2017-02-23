package com.synerzip;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame extends Frame implements WindowListener {

	TextField txtValRollNumber, txtValName, txtValAddress, marks, previousId, nextId, searchText, hiddenId;
	Label rollNumberLable, nameLable, addressLable, marksLable, ageLable, genderLable, searchTextLable;
	TextArea address;
	TextField age;
	CheckboxGroup cbg;
	Checkbox male, female;
	Button pre, next, first, last, save, update, search, delete;

	public MyFrame(String title) {
		this.setBounds(100, 100, 800, 800);
		setVisible(true);
		setBackground(Color.white);
		setTitle(title);
		setLayout(null);

		// search Field
		searchText = new TextField();
		searchTextLable = new Label("search : ");
		searchTextLable.setBounds(50, 50, 50, 20);
		add(searchTextLable);
		searchText.setBounds(300, 50, 200, 30);
		add(searchText);

		// roll number
		txtValRollNumber = new TextField();
		rollNumberLable = new Label("Roll No : ");
		rollNumberLable.setBounds(50, 100,  50, 20);
		add(rollNumberLable);
		txtValRollNumber.setBounds(300, 100, 200, 30);
		add(rollNumberLable);
		add(txtValRollNumber);

		// Name
		nameLable = new Label("Name:");
		nameLable.setBounds(50, 150, 50, 20);
		add(nameLable);
		txtValName = new TextField();
		txtValName.setBounds(300, 150, 200, 30);
		add(txtValName);

		// Address
		addressLable = new Label("Address:");
		addressLable.setBounds(50, 200, 50, 20);
		add(addressLable);
		address = new TextArea();
		address.setBounds(300, 200, 200, 75);
		add(address);

		// Marks
		marksLable = new Label("Marks:");
		marksLable.setBounds(50, 300, 50, 20);
		add(marksLable);

		marks = new TextField();
		marks.setBounds(300, 300, 200, 30);
		add(marks);

		ageLable = new Label("Age:");
		ageLable.setBounds(50, 350, 50, 20);
		add(ageLable);
		age = new TextField();

		age.setBounds(300, 350, 50, 30);
		add(age);

		genderLable = new Label("Gender:");
		genderLable.setBounds(50, 400, 50, 20);
		add(genderLable);

		cbg = new CheckboxGroup();
		male = new Checkbox("Male", cbg, false);
		male.setBounds(300, 400, 70, 20);
		female = new Checkbox(" Female", cbg, false);
		female.setBounds(380, 400, 70, 20);
		add(male);
		add(female);

		save = new Button("Save");
		save.setBounds(100, 450, 70, 30);

		update = new Button("Update");
		update.setBounds(200, 450, 70, 30);

		delete = new Button("Delete");
		delete.setBounds(300, 450, 70, 30);

		search = new Button("Search");
		search.setBounds(400, 450, 70, 30);

		add(save);
		add(update);
		add(delete);
		add(search);

		first = new Button("First");
		first.setBounds(100, 500, 70, 30);

		pre = new Button("Pre");
		pre.setBounds(200, 500, 70, 30);

		next = new Button("Next");
		next.setBounds(300, 500, 70, 30);

		last = new Button("Last");
		last.setBounds(400, 500, 70, 30);
		// hidden field
		previousId = new TextField();
		previousId.setBounds(500, 500, 50, 50);

		add(previousId);
		previousId.setVisible(false);

		add(first);
		add(pre);
		add(next);
		add(last);

		save.addActionListener(new HandlerEvent(this, "Save"));
		update.addActionListener(new HandlerEvent(this, "Update"));
		first.addActionListener(new HandlerEvent(this, "First"));
		last.addActionListener(new HandlerEvent(this, "Last"));
		pre.addActionListener(new HandlerEvent(this, "Pre"));
		next.addActionListener(new HandlerEvent(this, "Next"));
		delete.addActionListener(new HandlerEvent(this, "Delete"));
		search.addActionListener(new HandlerEvent(this, "Search"));

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		MyFrame mf = (MyFrame) e.getSource();
		mf.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
