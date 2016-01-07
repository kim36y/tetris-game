import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.BorderLayout;



public class TetrisGameGUIController extends JPanel implements KeyListener
{
	public static final int DEFAULT_DROP_RATE = 300;
	private TetrisGame game;
	private TetrisBoardGUIView view;
	private JLabel linesLabel;
	private JLabel tetrisesLabel;
	private JLabel score;
	JPanel scoreDisplay = new JPanel();
	
	private Timer gameTimer;
	//private int dropRate;
	
	/**
	 * listens and carries out key events and adds the board and score to the frame
	 */
	public TetrisGameGUIController() 
	{
		super(new BorderLayout());
		linesLabel = new JLabel();
		tetrisesLabel = new JLabel();
		score = new JLabel();
		
		addKeyListener(this);
		setFocusable(true);
		
		game = new TetrisGame();
		this.add( new TetrisBoardGUIView(game.getTetrisBoard()));
		this.createView();
		this.createScore();

		setupTimer();
	}
	
	/**
	 * creates Timer to set at which rate the pieces fall
	 */
	private void setupTimer(){
		// creating an "anonymous" action listener
		gameTimer = new Timer( DEFAULT_DROP_RATE, new ActionListener() 
		{
				public void actionPerformed( ActionEvent e ){
					
					//gameTimer.stop();
					game.attemptMove(2);

					//repaint();
					refreshDisplay();
					
				}
			});
			
		gameTimer.start();
	}
	
	
	/**
	 * adds the board to the center
	 */
	private void createView()
	{
		view = new TetrisBoardGUIView(game.getTetrisBoard());
		add( view, BorderLayout.CENTER );
		repaint();
	}
	
	
	
	/**
	 * update the score
	 */
	public void refreshDisplay()
	{
		
		linesLabel.setText("Lines Cleared: "  + Integer.toString(game.getNumLines()));
		linesLabel.setFont(new Font("Nanum Pen Script", Font.BOLD, 35));
		tetrisesLabel.setText("Tetrises Cleared: " + Integer.toString(game.getNumTetrises()));
		tetrisesLabel.setFont(new Font("Nanum Pen Script", Font.BOLD, 35));
		score.setText("Score:" + Integer.toString(game.getNumLines()*10));
		score.setFont(new Font("Nanum Pen Script", Font.BOLD, 35));
		repaint();
	}
	
	/*
	 * adds scores to the top
	 */
	private JPanel createScore()
	{
		JPanel scoreDisplay = new JPanel();
		scoreDisplay.setLayout(new BoxLayout(scoreDisplay, BoxLayout.Y_AXIS));
		scoreDisplay.add(linesLabel);
		scoreDisplay.add(tetrisesLabel);
		scoreDisplay.add(score);
		add  (scoreDisplay, BorderLayout.EAST);
		refreshDisplay();
		
		return scoreDisplay;
	}

	
	
	
	/**
	 * Handle the key-pressed event.
	 * @param e
	 */
	public void keyPressed(KeyEvent e)
	{
		
		switch (e.getKeyCode())
		{
		case KeyEvent.VK_RIGHT:
	    	game.attemptMove(0);
	    	break;
	    

		case KeyEvent.VK_LEFT:
	    	game.attemptMove(1);
	    	break;
	    

		case KeyEvent.VK_DOWN:
	    	game.attemptMove(2);
	    	break;
	    
	    
		case KeyEvent.VK_X:
	    	game.attemptMove(3);
	    	break;
	    
	    
	    case KeyEvent.VK_Z: 
	    	game.attemptMove(4);
	    	break;
	   
		default: break;
		}
		
		repaint();
	}
	

//	
	/**
	 * Handle the key typed event.
	 * @param e
	 */
	public void keyTyped(KeyEvent e)
	{
		
	}
	
	/**
	 * Handle the key-released event.
	 */
	public void keyReleased(KeyEvent e)
	{

	}

	
}
