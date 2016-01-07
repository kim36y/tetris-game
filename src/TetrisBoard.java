/** 
*creates the board for Tetris 
**/
public class TetrisBoard
{

	//position of current (falling) piece currentPieceGridPosition[0] stores the current row currentPieceGridPosition[1] stores the current column
	private int[] currentPieceGridPosition  = new int[2];
	public boolean[][] blockMatrix;
	public static final int NUM_ROWS = 22;
	public static final int NUM_COLS = 13;
	private int numCols = 4;
	private int numRows = 4;
	public int numRemovedLines = 0;
	public int numRemovedTetrises = 0;
	private TetrisPiece currentPiece;

	public TetrisBoard()
	{
		blockMatrix = new boolean[NUM_ROWS][NUM_COLS];
		initBoard();
		addNewPiece();
		
	}
	
	//Initialize an int array of length two to keep track of the grid position of the current piece (row, col)
	private void initCurrentGP()
	{
		//stores the current row of current falling piece
		currentPieceGridPosition[0] = 0;
		//stores the current col of current falling piece
		currentPieceGridPosition[1] = 3;
	}
	
	//Initialize the 2D board array to have all false values
	private void initBoard()
	{
		for (int i = 0; i < NUM_ROWS; i++)
			for (int j = 0; j < NUM_COLS; j++)
				blockMatrix[i][j] = false;
	}
	
	//Update the board array to reflect the newly landed piece's filled squares using the currentGridPosition values and the currentPiece's rotation value.
	public void landPiece()
	{
		
		for (int r = 0; r < numRows; r++)
			for (int c = 0; c < numCols; c++)
				if (currentPiece.isFilled(currentPiece.getPieceRotation(), r, c))
				{
					blockMatrix[currentPieceGridPosition[0] + r][currentPieceGridPosition[1] + c] = true;
				}		  
	}

	
	
	/**
	*Check if moving left is valid. If so, move the current piece left.
	*@return true if valid move was performed
	*/
	public boolean moveLeft()
	{
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0], currentPieceGridPosition[1]-1))
		{
			currentPieceGridPosition[1]--;
			//currentPiece.filledSquares = new boolean[currentPiece.getPieceRotation()][currentPieceGridPosition[0]][currentPieceGridPosition[1]];
					
			return true;	
		}
		else
			return false;	
	}
	
	/**
	*Check if moving right is valid. If so, move the current piece right.
	*@return true if valid move was performed
	*/
	public boolean moveRight()
	{
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0], currentPieceGridPosition[1]+1))
		{
			currentPieceGridPosition[1]++;
			
			return true;	
		}
		else
			return false;
	}
	
	/**
	*Check if moving down is valid. If so, move the current piece down.
	*@return true if valid move was performed
	*/
	public boolean moveDown()
	{
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0]+1, currentPieceGridPosition[1]))
		{
			currentPieceGridPosition[0]++;
			return true;	
		}
			landPiece();
			return false;
	}
	
	/**
	*Check if rotating clockwise is valid. If so, rotate the current piece clockwise by 90 degrees.
	*@return true if valid move was performed
	*/
	public boolean rotateCW()
	{
		int newRotation;
		if (currentPiece.getPieceRotation() < 3)
			newRotation = currentPiece.getPieceRotation() + 1;
		else 
			newRotation = 0;
		if (validMove(currentPiece, newRotation, currentPieceGridPosition[0], currentPieceGridPosition[1]))
		{
			currentPiece.rotateCW();
			return true;
		}
		else
			return false;
	}
	
	/**
	*Check if rotating clockwise is valid. If so, rotate the current piece clockwise by 90 degrees.
	*@return true if valid move was performed
	*/
	public boolean rotateCCW() {
		
		int newRotation;
		if (currentPiece.getPieceRotation() == 0)
			newRotation = currentPiece.getPieceRotation() + 3;
		else 
			newRotation = currentPiece.getPieceRotation() -1;
		
		if (validMove(currentPiece, newRotation, currentPieceGridPosition[0], currentPieceGridPosition[1]))
		{
			currentPiece.rotateCCW();
			return true;
		}
		else
			return false;
	}
	
	
	//Add a new random Tetris piece to the board at grid position (0, 3).
	public void addNewPiece()
	{
		int num = (int)(Math.random()*7);
		if (num == 0)
			currentPiece = new TetrisI();
		else if (num == 1)
			currentPiece = new TetrisJ();
		else if (num == 2)
			currentPiece = new TetrisL();
		else if (num == 3)
			currentPiece = new TetrisO();
		else if (num == 4)
			currentPiece = new TetrisS();
		else if (num == 5)
			currentPiece = new TetrisT();
		else 
			currentPiece = new TetrisZ();
			
		initCurrentGP();
	
	}
	
	
	/**
	*Checks if placing the piece at grid position (row, col) with the rotation rot (values can be 0, 90, 180, 270) would cause a collision 
	*(i.e., if there would be a block on an already-filled grid square)
	*@return true if there would be a collision
	*/
	private boolean detectCollision(TetrisPiece piece, int rot, int gridRow, int gridCol)
	{
		for (int i = 0; i < numRows; i++)
		{
			for (int j = 0; j < numCols; j++)
			{
				if ((piece.isFilled(rot, i, j)) )
					if( hasBlock(i + gridRow, j + gridCol)) 
					return true;
			}
		}
		
		return false;
	}
	
	/**
	*Checks if placing the piece at grid position (row, col) with the rotation rot (values can be 0, 90, 180, 270) would cause an out of bounds condition 
	*i.e., if there would be a block falling off the board
	*/
	private boolean detectOutOfBounds(TetrisPiece piece, int rot, int gridRow, int gridCol)
	{
		for (int i = 0; i < numRows; i++)
		{
			for (int j = 0; j < numCols; j++)
			{
				if ( piece.isFilled(rot, i, j) && (((i + gridRow) >= NUM_ROWS) || (j + gridCol < 0) || ((j + gridCol) >= NUM_COLS)) )
					
					return true;
			}
		}
		return false;
	}
	
	/**
	*Checks if placing the piece at grid position (row, col) with the rotation rot (values can be 0, 90, 180, 270) is a valid move.
	*@return true if no collision or bounding error
	*/
	public boolean validMove(TetrisPiece piece, int rot, int gridRow, int gridCol)
	{
		if ((!detectOutOfBounds(piece, rot, gridRow, gridCol)) && (!detectCollision(piece, rot, gridRow, gridCol)))
			return true;
		else
			return false;
	}
	
	/**
	*Check if there is a block in the row and column.
	*@return true if there is a block
	*/
	public boolean hasBlock(int row, int col)
	{
		if (blockMatrix[row][col])
			return true;
		else 
			return false;
	}
	
	/**
	*Detect and remove any lines formed.
	*@return the total number found.
	*/
	public int numberOfFormedLines()
	{
		for (int n = 0; n < NUM_ROWS; n++)
			if (fullLine(n))
			{
				removeLine(n);
				numRemovedLines++;
			}
		return numRemovedLines;
	}

	/**
	*Detect and remove any lines formed.
	*@return the total number found.
	*/
	public int numberOfFormedTetrises()
	{
		for (int n = 0; n < NUM_ROWS-3; n++)
			if (fullTetris(n))
			{
				numRemovedTetrises++;
			}
		return numRemovedTetrises;
	}
	
	/**
	*Check if there is a full line at the row.
	*@return true if full
	**/
	private boolean fullLine(int row)
	{
		for (int n = 0; n < NUM_COLS; n++)
		{
			if (blockMatrix[row][n] == false)
				return false;
		}
			return true;
	}
	
	/**
	 * Check if there are four lines that are filled at once
	 * @return true if 4 consecutive lines are full
	 */
	private boolean fullTetris(int row)
	{
		if (fullLine(row) && fullLine(row+1) && fullLine(row+2) && fullLine(row+3))
        {
			return true;
        }
			return false;
		
	}
	
	/**
	*Remove the line at row in the model. 
	*Shift all values for rows at a lower index to be at one row higher. Make row 0 full of false values.
	*/
	private void removeLine(int row)
	{
		if (fullLine(row))
		{
			for (int r = row; r > 0; r--)
			{
				for (int c = 0; c < NUM_COLS; c++)
				{
					blockMatrix[r][c] = blockMatrix[r-1][c];
				}
			}
			
			for (int c = 0; c < NUM_COLS;c++)
			{
				blockMatrix[0][c] = false;
			}
		}
	}
	
	//@return the block matrix (the grid of blocks)
	public boolean[][] getBlockMatrix() 
	{
		return blockMatrix;
	}
	
	//@return the currentPiece
	public TetrisPiece getCurrentPiece()
	{
		return currentPiece;
	}
	
	//@return the currentPieceGridPosition
	public int[] getCurrentPieceGridPosition()
	{
		return currentPieceGridPosition;
	}
	
	//@return the numCols in the block matrix
	public int getNumCols()
	{
		return NUM_COLS;
	}
	
	//@return the numRows in the block matrix
	public int getNumRows()
	{
		return NUM_ROWS;
	}
	
}
