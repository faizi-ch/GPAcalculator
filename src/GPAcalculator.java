import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

public class GPAcalculator extends JFrame
{

	JLabel gradeJLabel;
	JTextField gradeJTextField;

	JLabel clickstartJLabel;

	JButton enterJButton;
	JButton clearJButton;
	JButton calculateJButton;

	String testscores;
	int numberOfScores;
	double priceValues;
	int grade;
	int counter;
	int gradeAccumulator;
	String s="";

	public GPAcalculator()
	{
		createUserInterface();
	}

	public final void createUserInterface()
	{
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);

		gradeJLabel = new JLabel();
		gradeJLabel.setBounds(50, 50, 150, 20);
		gradeJLabel.setFont(new Font("Default", Font.PLAIN, 12));
		gradeJLabel.setText("Grade:");
		gradeJLabel.setForeground(Color.BLACK);
		gradeJLabel.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(gradeJLabel);

		gradeJTextField = new JTextField(12);
		gradeJTextField.setBounds(200, 50, 50, 30);
		gradeJTextField.setFont(new Font("Default", Font.PLAIN, 12));
		gradeJTextField.setHorizontalAlignment(JTextField.CENTER);
		gradeJTextField.setForeground(Color.BLACK);
		gradeJTextField.setBackground(Color.WHITE);
		gradeJTextField.setEditable(false);
		contentPane.add(gradeJTextField);

		clickstartJLabel = new JLabel();
		clickstartJLabel.setBounds(100, 200, 150, 20);
		clickstartJLabel.setFont(new Font("Default", Font.PLAIN, 12));
		clickstartJLabel.setText("Click Start to Begin!");
		clickstartJLabel.setForeground(Color.BLACK);
		clickstartJLabel.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(clickstartJLabel);

		enterJButton = new JButton();
		enterJButton.setBounds(20, 300, 100, 20);
		enterJButton.setFont(new Font("Default", Font.PLAIN, 12));
		enterJButton.setText("Enter");
		enterJButton.setForeground(Color.BLACK);
		enterJButton.setBackground(Color.WHITE);
		contentPane.add(enterJButton);
		enterJButton.addActionListener(

				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{

						getnumberoftests();
					}
				}
		);

		clearJButton = new JButton();
		clearJButton.setBounds(260, 300, 100, 20);
		clearJButton.setFont(new Font("Default", Font.PLAIN, 12));
		clearJButton.setText("Clear");
		clearJButton.setForeground(Color.BLACK);
		clearJButton.setBackground(Color.WHITE);
		contentPane.add(clearJButton);
		clearJButton.addActionListener(

				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						clearJButtonActionPerformed(event);
					}
				}
		);

		calculateJButton = new JButton();
		calculateJButton.setBounds(140, 300, 100, 20);
		calculateJButton.setFont(new Font("Default", Font.PLAIN, 12));
		calculateJButton.setText("Calculate Grade");
		calculateJButton.setForeground(Color.BLACK);
		calculateJButton.setBackground(Color.WHITE);
		contentPane.add(calculateJButton);
		calculateJButton.addActionListener(

				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						gradeJTextField.setText(s);
					}
				}
		);


		setTitle("Grade Calculator");
		setSize(400, 400);
		setVisible(true);
	}

	/* main method */
	public static void main(String[] args)
	{
		GPAcalculator application = new GPAcalculator();
		application.checkgrade();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void getnumberoftests()
	{
		testscores = JOptionPane.showInputDialog("Enter Number of Grades");
		numberOfScores = Integer.parseInt(testscores);
		gettestscores();
	}

	public void gettestscores()
	{
		for(counter = 0; counter < numberOfScores; counter++)
		{
			testscores = JOptionPane.showInputDialog("Enter Scores");
			priceValues = Integer.parseInt(testscores);
			gradeAccumulator += priceValues;
		}

		calculateAverage();
	}

	public void calculateAverage()
	{
		grade = gradeAccumulator / numberOfScores;
		checkgrade();
	}


	public void checkgrade()
	{

		if(grade < 64)
		{
			s="F";
		}
		else if(grade < 69)
		{
			s="D";
		}
		else if(grade < 79)

		{
			s="C";
		}
		else if(grade < 89)

		{
			s="B";
		}

		else {

			s="A";
		}

	}

	public void clearJButtonActionPerformed(ActionEvent event)
	{
		gradeJTextField.setText("");
	}

}