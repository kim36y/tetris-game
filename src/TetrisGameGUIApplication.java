import javax.swing.JFrame;

/**
 * Main application for starting up the Tetris GUI
 *
 */
public class TetrisGameGUIApplication 
{
	/** 
	 * Main application to show frame for TetrisGame 
	 **/
	public TetrisGameGUIApplication() 
	{
		JFrame guiFrame;
		
		// create a new JFrame to hold Tetris Game
		guiFrame = new JFrame( "Tetris");
		
		// set size
		guiFrame.setSize( 690, 860 );

		guiFrame.add( new TetrisGameGUIController());

		// exit normally on closing the window
		guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	
		// show frame
		guiFrame.setVisible( true );
	}
	
	/**
	 * Start the Game!
	 */
	public static void main( String[] args )
	{
		new TetrisGameGUIApplication();
	}
	
	
}
