/**
* keeps track of scores, when the game would end, whether the player won or lost 
**/
public class TetrisGame
{

	public static int CCW = 4;
	public static int CW = 3;
	public static int DOWN = 2;
	public static int LEFT = 1;
	public static int RIGHT = 0;
	private int numLines = 0;
	private int numTetrises = 0;
	private TetrisBoard tetrisBoard;
	
	
	public TetrisGame()
	{
		tetrisBoard = new TetrisBoard(); 
	}
	
	//Try to move the current piece with RIGHT, LEFT, DOWN, CW, CCW
	public void attemptMove(int moveType) 
	{
		if (moveType == RIGHT)
			tetrisBoard.moveRight();
		
		else if (moveType == LEFT)
			tetrisBoard.moveLeft();
		
		else if (moveType == DOWN)
		{
			if (!tetrisBoard.moveDown())
			endRound();
		}
		
		else if (moveType == CW)
			tetrisBoard.rotateCW();
		
		else if (moveType == CCW)
			tetrisBoard.rotateCCW();

	}
	
	//Performed when a piece cannot move down anymore. Ends the round by checking for newly formed lines and adding a new piece.
	private void endRound() 
	{
			numLines = tetrisBoard.numberOfFormedLines();
			numTetrises = tetrisBoard.numberOfFormedTetrises();
			tetrisBoard.addNewPiece();
	}
	
	public boolean atLeastOneBlockInRow(int row)
	{
		for (int n = 0; n < tetrisBoard.getNumCols(); n++)
		{
				if (tetrisBoard.blockMatrix[row][n] )
					return true;
			
		}
			return false;
	}
	
	
	public boolean gameLost()
	{
			for (int r = 0; r < tetrisBoard.getNumRows(); r++)
			{
				if (!atLeastOneBlockInRow(r))
					return false;
			}
			
			System.out.println("You Lost!");
			return true;
					
	}
	
	//@return the numLines
	public int getNumLines()
	{
		return numLines;
	}
	
	//@return the numTetrises
	public int getNumTetrises()
	{
		return numTetrises;
	}
	
	//@return the tetrisBoard
	public TetrisBoard getTetrisBoard()
	{
		return tetrisBoard;
	}
	

}
