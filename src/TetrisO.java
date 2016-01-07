/** Tetris piece type O **/
public class TetrisO extends TetrisPiece
{
	
	public TetrisO()
	{
		super();

		boolean[][][] pieceOMatrix = 
		{
			{
				{true, true, false, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false},
			},
			{
				{true, true, false, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false},
			},
			{
				{true, true, false, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false},
			},
			{
				{true, true, false, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false},
			},
		};
		
		filledSquares = pieceOMatrix;
	}

	
}