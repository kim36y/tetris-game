/** 
* contains all the seven pieces for tetris and the methods for movements and rotations 
*/
public abstract class TetrisPiece
{
	/**
	*3 dimensional array maintaining which squares are filled first dimension is rotation 
	*index 0: 0 degrees, index 1: 90 degrees, index 2: 180 degrees, index 3: 270 degrees 
	*second and third dimensions create 4x4 grid with true values indicating filled squares
	*/
	protected boolean[][][] filledSquares;
	
	//Maintains the current rotation.
	protected int pieceRotation = 0;
		
	//Get the rotation of this piece.
	public int getPieceRotation()
	{
		return pieceRotation;
	}
	
	//Checks if there is a TetrisBlock at the (row, col) position for the rotation rot
	public boolean isFilled(int rot, int row, int col)
	{
		if (filledSquares[rot][row][col])
			return true;
		else 
			return false;
	}
	
	//Rotate the piece counter-clockwise by 90 degrees.
	public void rotateCCW()
	{
		if (pieceRotation == 0)
			pieceRotation = pieceRotation + 3;
		else 
			pieceRotation = pieceRotation -1;
	}
	
	//Rotate the piece clockwise by 90 degrees.
	public void rotateCW()
	{
		if (pieceRotation < 3)
			pieceRotation = pieceRotation + 1;
		else 
			pieceRotation = 0;
	}


}