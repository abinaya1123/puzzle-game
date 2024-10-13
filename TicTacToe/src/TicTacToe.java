import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener 
{
	Random random = new Random();
	JFrame frame = new JFrame("TIC-TAC-TOE");
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	
	boolean player1_turn;
	
	TicTacToe() //constructor
	{
		//creating frame
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,700);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		//adding textField
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free ",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		//creating panel
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		//adding buttons to the panel
		for(int i=0;i<9;i++)
		{
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		

		//adding all the components to the frame
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
	}
	
	//
	
	public void actionPerformed(ActionEvent e) 
	{
		//playing logic
		
		for(int i=0;i<9;i++)
		{
			if(e.getSource()==buttons[i])
			{
				if(player1_turn)  //if True x turn will execute
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn=false; // Assigning next turn to O to be execute
						textfield.setText("O Turn");
						check();
					}
				}
				else // if false O turn will execute
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn=true; // Assigning next turn to X to be execute
						textfield.setText("X Turn");
						check();
					}
				}
			}
		}
		
	}
	
	public void firstTurn()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) //randomly assign first turn
		{
			player1_turn=true; //  Assigning true for player x
			textfield.setText("X Turn");
		}
		else
		{
			player1_turn=false;  // Assigning true for player O
			textfield.setText("O Turn");
		}
		
	}
	
	
	public void check()  	// for checking winners
	{
		//to check X win conditions
		
		if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X"))
		{
			xWins(0,1,2);
		}
		if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X"))
		{
			xWins(3,4,5);
		}
		if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X"))
		{
			xWins(6,7,8);
		}
		if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X"))
		{
			xWins(0,3,6);
		}
		if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X"))
		{
			xWins(1,4,7);
		}
		if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X"))
		{
			xWins(2,5,8);
		}
		if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X"))
		{
			xWins(0,4,8);
		}
		if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X"))
		{
			xWins(2,4,6);
		}
		
	//to check O win condition
	
			if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O"))
			{
				oWins(0,1,2);
			}
			if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O"))
			{
				oWins(3,4,5);
			}
			if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O"))
			{
				oWins(6,7,8);
			}
			if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O"))
			{
				oWins(0,3,6);
			}
			if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O"))
			{
				oWins(1,4,7);
			}
			if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O"))
			{
				oWins(2,5,8);
			}
			if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O"))
			{
				oWins(0,4,8);
			}
			if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O"))
			{
				oWins(2,4,6);
			}
			
			// to check match draw
			
			if((buttons[0].getText()!="") && (buttons[1].getText()!="") && (buttons[2].getText()!="") && (buttons[3].getText()!="") && (buttons[4].getText()!="") && (buttons[5].getText()!="") && (buttons[6].getText()!="") && (buttons[7].getText()!="") && (buttons[8].getText()!=""))
			{
				draw();
			}
			
		
		}
	
	//to display X wins
	
	public void xWins(int a,int b,int c)
	{
		
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++)
		{
			buttons[i].setEnabled(false);
		}
		textfield.setText("X Wins");
	}
	
	//to display O wins
	public void oWins(int a,int b,int c)
	{
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++)
		{
			buttons[i].setEnabled(false);
		}
		textfield.setText("O Wins");
	
	}
	
	//to display Match Draw
	public void draw()
	{
		
		for(int i=0;i<9;i++)
		{
			buttons[i].setBackground(Color.orange);
		}
		textfield.setText("Tie!");
	}

public static void main(String[] args) 
{
	TicTacToe tictactoe = new TicTacToe(); //method calling

}

}

