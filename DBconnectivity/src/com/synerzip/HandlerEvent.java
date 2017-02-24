package com.synerzip;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import com.modelclass.StudentModel;
import com.serviceImpl.StudentServiceImpl;

public class HandlerEvent implements ActionListener {

	StudentServiceImpl studentimpl = new StudentServiceImpl();
	int rollNumber, marks, gender;
	int txtFiled2;
	int txtFiled3;
	String name, address, age;

	private MyFrame myFrame;
	private String fromButton;

	public HandlerEvent(MyFrame myFrame, String fromButton) {
		this.myFrame = myFrame;
		this.fromButton = fromButton;
	}

	public void actionPerformed(ActionEvent e) {
		switch (fromButton) {
		case "Save":
			rollNumber = Integer.parseInt(myFrame.txtValRollNumber.getText());
			name = myFrame.txtValName.getText();
			address = myFrame.address.getText();
			marks = Integer.parseInt(myFrame.marks.getText());
			age = myFrame.age.getText();
			gender = myFrame.cbg.getSelectedCheckbox().getLabel().equals("Male") ? 1 : 0;
			System.out.println("id = " + myFrame.previousId.getText());
			StudentModel student = new StudentModel(rollNumber, name, address, marks, age, gender);
			try {
				studentimpl.saveStudent(student);
				System.out.println("Student Data save SuccessFully !!");
			} catch (Exception e2) {
				System.out.println("Not Able to save !!" + e2);
			}
			break;
		case "Update":

			rollNumber = Integer.parseInt(myFrame.txtValRollNumber.getText());
			name = myFrame.txtValName.getText();
			address = myFrame.address.getText();
			marks = Integer.parseInt(myFrame.marks.getText());
			age = myFrame.age.getText();
			gender = myFrame.cbg.getSelectedCheckbox().getLabel().equals("Male") ? 1 : 0;
			StudentModel studentUpdate = new StudentModel(rollNumber, name, address, marks, age, gender);
			try {
				studentimpl.updateStudent(studentUpdate);
				System.out.println("Student Data Update SuccessFully !!");
			} catch (Exception e2) {
				System.out.println("Not Able to save !!" + e2);
			}
			break;
		case "First":
			try {
				ResultSet res = studentimpl.getFirstStudent();
				while (res.next()) {
					String roll_number = res.getString("rollno");
					String name = res.getString("name");
					String address = res.getString("address");
					String marks = res.getString("marks");
					String age = res.getString("age");
					int gender = res.getInt("gender");
					System.out.println(gender);
					myFrame.txtValRollNumber.setText(roll_number);
					myFrame.txtValName.setText(name);
					myFrame.address.setText(address);
					myFrame.marks.setText(marks);

					myFrame.age.setText(age);
					if (gender == 1)
						myFrame.cbg.setSelectedCheckbox(myFrame.male);
					else
						myFrame.cbg.setSelectedCheckbox(myFrame.female);
				}
				System.out.println("show data first");
			} catch (Exception e2) {
				System.out.println("Not Able to save !!" + e2);
			}
			break;
		case "Last":
			try {
				ResultSet res = studentimpl.getLastStudent();
				while (res.next()) {
					String roll_number = res.getString("rollno");
					String name = res.getString("name");
					String address = res.getString("address");
					String marks = res.getString("marks");
					String age = res.getString("age");
					int gender = res.getInt("gender");
					myFrame.txtValRollNumber.setText(roll_number);
					myFrame.txtValName.setText(name);
					myFrame.address.setText(address);
					myFrame.marks.setText(marks);
					myFrame.age.setText(age);

					if (gender == 1)
						myFrame.cbg.setSelectedCheckbox(myFrame.male);
					else
						myFrame.cbg.setSelectedCheckbox(myFrame.female);
				}
				System.out.println("Last Data !!");
			} catch (Exception e2) {
				System.out.println("Not Able to save !!" + e2);
			}
			break;
		case "Pre":
			try {
				int rollNumber = Integer.parseInt(myFrame.txtValRollNumber.getText());
				int id = studentimpl.getIdFromRollNumber(rollNumber);
				StudentModel studentModel = studentimpl.getPreviousRecord(id);
				System.out.println(studentModel);
				if (studentModel != null) {
					System.out.println("jgjgjgjgj" + studentModel.getName());
					myFrame.txtValName.setText(studentModel.getName());
					myFrame.address.setText(studentModel.getAddress());
					myFrame.age.setText("" + studentModel.getAge());
					myFrame.marks.setText("" + studentModel.getMarks());
					myFrame.txtValRollNumber.setText("" + studentModel.getRollNo());
					if (studentModel.getGender() == 1)
						myFrame.cbg.setSelectedCheckbox(myFrame.male);
					else
						myFrame.cbg.setSelectedCheckbox(myFrame.female);
				}
				System.out.println("Student Data Update SuccessFully !!");
			} catch (Exception e2) {
				System.out.println("Not Able to save !!" + e2);
			}
			break;
		case "Next":
			try {
				int rollNumber = Integer.parseInt(myFrame.txtValRollNumber.getText());
				int id = studentimpl.getIdFromRollNumber(rollNumber);
				StudentModel studentModel = studentimpl.getNextRecord(id);
				System.out.println(studentModel);
				if (studentModel != null) {
					System.out.println("jgjgjgjgj" + studentModel.getName());
					myFrame.txtValName.setText(studentModel.getName());
					myFrame.address.setText(studentModel.getAddress());
					myFrame.age.setText("" + studentModel.getAge());
					myFrame.marks.setText("" + studentModel.getMarks());
					myFrame.txtValRollNumber.setText("" + studentModel.getRollNo());
					if (studentModel.getGender() == 1)
						myFrame.cbg.setSelectedCheckbox(myFrame.male);
					else
						myFrame.cbg.setSelectedCheckbox(myFrame.female);
				}
				System.out.println("Student Data Update SuccessFully !!");
			} catch (Exception e2) {
				System.out.println("Not Able to save !!" + e2);
			}
			break;
		case "Delete":
			try {
				int id = Integer.parseInt(myFrame.txtValRollNumber.getText());
				studentimpl.deleteStudent(id);
				System.out.println("Student Data Deleted SuccessFully !!");
			} catch (Exception e2) {
				System.out.println("Not Able to Deleted !!" + e2);
			}
			break;
		case "Search":
			try {
				myFrame.searchText.setVisible(true);
				myFrame.searchTextLable.setVisible(true);
				System.out.println("Search!!");
				int rollNumber = Integer.parseInt(myFrame.searchText.getText());
				System.out.println(rollNumber);
				ResultSet res = studentimpl.searchStudent(myFrame.searchText.getText());
				while (res.next()) {
					String roll_number = res.getString("rollno");
					String name = res.getString("name");
					String address = res.getString("address");
					String marks = res.getString("marks");
					String age = res.getString("age");
					int gender = res.getInt("gender");

					if (roll_number != null) {
						myFrame.update.setEnabled(true);
						myFrame.delete.setEnabled(true);
					} else {
						myFrame.update.setEnabled(false);
						myFrame.delete.setEnabled(false);
					}

					myFrame.txtValRollNumber.setText(roll_number);
					myFrame.txtValName.setText(name);
					myFrame.address.setText(address);
					myFrame.marks.setText(marks);
					myFrame.age.setName(age);
					if (gender == 1)
						myFrame.cbg.setSelectedCheckbox(myFrame.male);
					else
						myFrame.cbg.setSelectedCheckbox(myFrame.female);
				}
				System.out.println("Search Data !!");
			} catch (Exception e2) {
				System.out.println("Not Able to Search !!" + e2);
			}
			break;
		default:
			break;
		}
	}
}
