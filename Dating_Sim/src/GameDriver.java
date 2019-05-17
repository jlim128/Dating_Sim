import java.util.*;
import java.util.List;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class GameDriver {
	private String charTextFiles[] = new String[] {"aristotle.txt", "hume.txt", 
		       "kant.txt", "schopenhauer.txt", "singer.txt"};
	private ArrayList<Character> characters = new ArrayList<Character> ();
	private Scanner input = new Scanner(System.in);
	private Character currentChar;
	//Swing stuff
	JFrame frame = new JFrame("I have the 'HOTS' for you <3");
	JButton op1 = new JButton("1");
	JButton op2 = new JButton("2");
	JButton op3 = new JButton("3");
	JButton op4 = new JButton("4");
	JButton next = new JButton("NEXT -->");
	JButton result = new JButton("How we deemed your interation.");
	JTextArea text = new JTextArea("After a long week of school, you stayed up thinking about your short life and its many complexities.\nWhen you arise, "
			+ "you feel motivated to go out and meet new people.");
	JPasswordField password;
	JTextField field = new JTextField(20);
	JTextArea area;
	JButton[] JBut = new JButton[] { op1, op2, op3, op4};
	
	/**
	 * 
	 */
	public void runGame() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUpWindow(frame.getContentPane());
		frame.pack();
		frame.setSize(1200,1000);
		frame.setVisible(true);
		inputChars();
		//currentChar = characters.get(0);
		runOpening();
		/*
		do {
			runOpening();
		} while (scenario() && characters.size() > 0);
		*/
		//summary();
	}
	
	public void setUpWindow(Container pane) {
		pane.setLayout(new GridBagLayout());
		pane.setBackground(Color.cyan);
		//text.setPreferredSize(text.getPreferredSize());
		text.setPreferredSize(new Dimension(600, 150));
		Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
		text.setFont(new Font("Serif", Font.BOLD, 14));

		text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setOpaque(false);
        text.setEditable(false);
		
		GridBagConstraints c = new GridBagConstraints();
		
		/*
		this is for the picture
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 0;
		 */
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 1;
		c.ipady = 40;
		c.gridwidth = 4;
		
		border = BorderFactory.createLineBorder(Color.BLUE, 1);
		text.setBorder(border);
		pane.add(text,c);
		text.setVisible(false);
		
		
		c.insets = new Insets(20,0,0,0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 2;
		c.gridx = 0;
		c.ipady = 0;
		c.gridwidth = 1;
		//c.gridheight = 2;
		pane.add(op1, c);
		op1.setVisible(false);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 2;
		c.gridx = 1;
		pane.add(op2, c);
		op2.setVisible(false);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 2;
		c.gridx = 2;
		pane.add(op3, c);
		op3.setVisible(false);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 2;
		c.gridx = 3;
		pane.add(op4, c);
		op4.setVisible(false);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridx = 2;
		pane.add(next, c);
		next.setVisible(false);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridx = 2;
		pane.add(result, c);
		result.setVisible(false);
		/*
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 2;
		c.gridwidth = 4;
		c.gridx = 0;
		pane.add(password, c);
		password.setVisible(false);
		*/
		
		c.fill = GridBagConstraints.HORIZONTAL;
		//field.setBounds(1200, 200, 200, 30);
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridx = 0;
		field.setVisible(false);
		frame.add(field, c);
		field.setVisible(false);
		
	}
	
	
	public void addToText(String txt) {
		/*
		while(txt.indexOf("\n") != -1) {
			txt = txt.substring(0,txt.indexOf("\n")) + "<br>" + txt.substring(txt.indexOf("\n") + 1, txt.length());
		}
		*/
		//txt = txt.replace("\n", "<br>");

		text.setText(text.getText() + txt);
	}
	
	public void presentTxt() {
		//text.setText("<html>" + text.getText() + "</html>");
		//text.setPreferredSize(text.getPreferredSize());
		text.setVisible(true);
	}
	public void resetTxt() {
		text.setText("");
		text.setVisible(false);
	}
	public void setNext(int resp) {
		next.setVisible(true);
		op1.setVisible(false);
		op2.setVisible(false);
		op3.setVisible(false);
		op4.setVisible(false);
		
		resetTxt();
		addToText( "\n" + d.getChoice(resp) + "\n " + d.getResponse(resp));
		presentTxt();

		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storyCount++;
				
				if(storyCount>= currentChar.getStoryLength()) {
					next.setVisible(false);
					result.setVisible(true);
					result.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							resetTxt();
							summary();
						}
					});
					
					
					
					//summary();
					characters.remove(currentChar);
				}else {
				if (currentChar.checkLose()) {
						characters.remove(currentChar);
					}else {
							
						scenario();
					}

				}
			}
		});
		
	}
	
	public void set4Options() {
		next.setVisible(false);
		op1.setVisible(true);
		op2.setVisible(true);
		op3.setVisible(true);
		op4.setVisible(true);
	}
	
	/**
	 * Method that takes all string files from CharTextFiles, and creates Character objects for Characters List
	 */
	public void inputChars() {
		for(int x = 0;x < charTextFiles.length;x++){
			characters.add(new Character(charTextFiles[x]));
		}
	}
	
	public void runOpening() {
		
		addToText("\n\n============PICK A LOCATION NUMBER============");
		for(int x =0; x < characters.size(); x++){
			addToText("\n " + (x +1) + ") " + characters.get(x).getLocation());
		}
		addToText("\n Choose location number: ");
		//text.setPreferredSize(text.getPreferredSize());
		presentTxt();
		System.out.println(text.getText());
		field.setVisible(true);
		field.revalidate();
		field.repaint();
		field.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String in = e.getActionCommand();
				int newI = changeStr(in);
				if(newI >0 && newI<characters.size()) {
					currentChar = characters.get(newI -1);
					storyCount =0;
					field.setVisible(false);
					scenario();
					//System.out.println(currentChar.getLocation());
				} else {
					JOptionPane.showMessageDialog(frame,
	                        "Get it right or pay the price, bozo!",
	                        "Error Message",
	                        JOptionPane.ERROR_MESSAGE);
	                
	                        
	                }
			}
		});
		
		//location = reply(characters.size());
		//currentChar = characters.get(location);
		
	}
	
	public int changeStr(String in) {
		for(int i =0;i<5;i++) {
			if (in.equals(i + "")) {
				return i;
			}
		}
		return 0;
	}
	//Integer.parseInt(input.nextLine());
	/**
	 * Method that insures that the user will reply
	 * @return user's int response
	 */
	public void reply() {
		
		op1.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNext(0);
				currentChar.addLovePoints(d.getLP(0));
			}
		});
		op2.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNext(1);
				currentChar.addLovePoints(d.getLP(1));
			}
		});
		op3.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNext(2);
				currentChar.addLovePoints(d.getLP(2));
			}
		});
		op4.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNext(3);
				currentChar.addLovePoints(d.getLP(3));
			}
		});
		
	}
	private int storyCount =0;
	private Dialogue d;
	/**
	 * Method that will play each character's scenario
	 */
	public void scenario() {

		resetTxt();
		
		d = currentChar.getDialogue(storyCount);
		addToText(d.getDialogueBefore() + "\n Enter your choice: ");
		presentTxt();
		d.getChoices(JBut);
		set4Options();
		reply();
		}
		/*
		if (currentChar.checkLose()) {
			if (storyCount == 0) {
				characters.remove(currentChar);
			}
			return storyCount == 0;
		}
	*/
		
	

	/**
	* Method that will get a summary of your results
	*/
	public void summary() {
		resetTxt();
		try {
		if (characters.size() > 0) {
			addToText(currentChar.getEnding());
			result.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					result.setVisible(false);
					resetTxt();
					
				}
			});
		}
		else {
			addToText("\n " +"You missed out on everyone.");
		}
		presentTxt();
		}catch(Exception e){
			System.out.println("fml");
		}
	}

}
