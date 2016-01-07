/** Tetris piece type I **/
public class TetrisI extends TetrisPiece
{
	
	public TetrisI()
	{
		super();

		boolean[][][] pieceIMatrix = 
		{
			{
				{true, false, false, false},
				{true, false, false, false},
				{true, false, false, false},
				{true, false, false, false},
			},
			{
				{true, true, true, true},
				{false, false, false, false},
				{false, false, false, false},
				{false, false, false, false},
			},
			{
				{true, false, false, false},
				{true, false, false, false},
				{true, false, false, false},
				{true, false, false, false},
			},
			{
				{true, true, true, true},
				{false, false, false, false},
				{false, false, false, false},
				{false, false, false, false},
			},
		};
		
		filledSquares = pieceIMatrix;
	}

	
}