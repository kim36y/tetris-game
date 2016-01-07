/** Tetris piece type J **/
public class TetrisJ extends TetrisPiece
{
		
	public TetrisJ()
	{
		super();

		boolean[][][] pieceJMatrix = 
		{
			{
				{false, true, false, false},
				{false, true, false, false},
				{true, true, false, false},
				{false, false, false, false},
			},
			{
				{true, false, false, false},
				{true, true, true, false},
				{false, false, false, false},
				{false, false, false, false},
			},
			{	
				{true, true, false, false},
				{true, false, false, false},
				{true, false, false, false},
				{false, false, false, false},
			},
			{
				{true, true, true, false},
				{false, false, true, false},
				{false, false, false, false},
				{false, false, false, false},
			},
			
		};
		
		filledSquares = pieceJMatrix;
		
	}

	
}