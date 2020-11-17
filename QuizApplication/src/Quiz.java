import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Quiz extends JFrame implements ActionListener{
	
	String[] questions = {
			                "Which company created Java?",
			                "Which year was Java created?",
			                "What was Java originally called?",
			                "Who is creaditaed with creating Java?"
	                     };
	
	String[][] options = {
			               {"Sun Microsystems","Google","Microsoft","IBM"},
			               {"1989","1996","1972","1960"},
			               {"Apple","Latte","Oak","Koffing"},
			               {"Steve Jobs","Bill Gates","James Gosling","Mark Zuckerburg"},
	                     };
	
	char[] answers = {
						'A',
						'B',
						'C',
						'C'
					 };
	
	char guess;
	char answer;
	int index;
	int correct_guesses = 0;
	int total_questions = questions.length;
	int result;
	int seconds=10;
	
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JLabel time_label = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	
	Timer timer = new Timer(2000,new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
		}
		
	});

	
	public Quiz() {
		frame.getContentPane().setForeground(new Color(255, 0, 0));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
		frame.getContentPane().setBackground(new Color(255, 255, 0));
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		textfield.setForeground(new Color(255, 0, 0));
		
		textfield.setBounds(0, 0, 650, 50);
		textfield.setBackground(new Color(25,25,25));
		textfield.setBackground(new Color(25,255,0));
		textfield.setFont(new Font("Tahoma", Font.BOLD, 30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		textarea.setForeground(new Color(255, 0, 0));
		
		textarea.setBounds(0, 50, 650, 50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setBackground(new Color(25,255,0));
		textarea.setFont(new Font("Tahoma", Font.BOLD, 25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		buttonA.setForeground(Color.RED);
		buttonA.setBackground(new Color(0, 0, 255));
		
		buttonA.setBounds(0,100,100,100);
		buttonA.setFont(new Font("Tahoma", Font.BOLD, 25));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		buttonB.setForeground(Color.RED);
		buttonB.setBackground(new Color(0, 0, 255));
		
		buttonB.setBounds(0,200,100,100);
		buttonB.setFont(new Font("Tahoma", Font.BOLD, 25));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		buttonC.setBackground(new Color(0, 0, 255));
		buttonC.setForeground(Color.RED);
		
		buttonC.setBounds(0,300,100,100);
		buttonC.setFont(new Font("Tahoma", Font.BOLD, 25));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		buttonD.setBackground(new Color(0, 0, 255));
		buttonD.setForeground(Color.RED);
		
		buttonD.setBounds(0,400,100,100);
		buttonD.setFont(new Font("Tahoma", Font.BOLD, 25));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		answer_labelA.setBounds(125, 100, 500, 100);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(0, 128, 0));
		answer_labelA.setFont(new Font("Tahoma", Font.PLAIN, 35));
		
		answer_labelB.setBounds(125, 200, 500, 100);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(0, 128, 0));
		answer_labelB.setFont(new Font("Tahoma", Font.PLAIN, 35));
		
		answer_labelC.setBounds(125, 300, 500, 100);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(0, 128, 0));
		answer_labelC.setFont(new Font("Tahoma", Font.PLAIN, 35));
		
		answer_labelD.setBounds(125, 400, 500, 100);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(0, 128, 0));
		answer_labelD.setFont(new Font("Tahoma", Font.PLAIN, 35));
		
		seconds_left.setBounds(535, 510,100,100);
		seconds_left.setBackground(new Color(25,25,25));
		seconds_left.setForeground(new Color(255, 0, 0));
		seconds_left.setFont(new Font("Tahoma", Font.BOLD, 60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		time_label.setBounds(535, 475, 100, 25);
		time_label.setBackground(new Color(50, 50, 50));
		time_label.setForeground(new Color(255, 255, 0));
		time_label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText("timer >:D");
		
		number_right.setBounds(225, 225, 200, 100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setFont(new Font("Tahoma",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(225, 325, 200, 100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(255,0,0));
		percentage.setFont(new Font("Tahoma",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		
		frame.getContentPane().add(time_label);
		frame.getContentPane().add(seconds_left);
		frame.getContentPane().add(answer_labelA);
		frame.getContentPane().add(answer_labelB);
		frame.getContentPane().add(answer_labelC);
		frame.getContentPane().add(answer_labelD);
		frame.getContentPane().add(buttonA);
		frame.getContentPane().add(buttonB);
		frame.getContentPane().add(buttonC);
		frame.getContentPane().add(buttonD);
		frame.getContentPane().add(textarea);
		frame.getContentPane().add(textfield);
		frame.setVisible(true);
		
		nextQuestion();
	}
	
	public void nextQuestion() {
		
		if(index>=total_questions) {
			results();
		}
		else {
			textfield.setText("Question "+(index+1));
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			timer.start();
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(e.getSource()==buttonA) {
			answer='A';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		
		if(e.getSource()==buttonB) {
			answer='B';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		
		if(e.getSource()==buttonC) {
			answer='C';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		
		if(e.getSource()==buttonD) {
			answer='D';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		displayAnswer();
	}
	
	public void displayAnswer() {
		
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(answers[index] !='A')
			answer_labelA.setForeground(new Color(255,0,0));
		if(answers[index] !='B')
			answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index] !='C')
			answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index] !='D')
			answer_labelD.setForeground(new Color(255,0,0));
		
		Timer pause = new Timer(2000,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer_labelA.setForeground(new Color(25,255,0));
				answer_labelB.setForeground(new Color(25,255,0));
				answer_labelC.setForeground(new Color(25,255,0));
				answer_labelD.setForeground(new Color(25,255,0));
				
				answer = ' ';
				seconds=10;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;
				nextQuestion();
			}
			
		});
		pause.setRepeats(false);
		pause.start();
	}
	
	public void results() {
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		result = (int)((correct_guesses/(double)total_questions)*100);
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("("+correct_guesses+"/"+total_questions+")");
		percentage.setText(result+"%");
		
		frame.getContentPane().add(percentage);
		frame.getContentPane().add(number_right);
		
	}
	
	public static void main(String[] args) {
		Quiz q=new Quiz();
	}
}
