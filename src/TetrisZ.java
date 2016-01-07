/** Tetris piece type Z **/
public class TetrisZ extends TetrisPiece
{ 
	
	public TetrisZ()
	{
		super();

		boolean[][][] pieceZMatrix = 
		{
			{
				{true, true, false, false},
				{false, true, true, false},
				{false, false, false, false},
				{false, false, false, false},
			},
			{
				{false, true, false, false},
				{true, true, false, false},
				{true, false, false, false},
				{false, false, false, false},
			},
			{
				{true, true, false, false},
				{false, true, true, false},
				{false, false, false, false},
				{false, false, false, false},
			},
			{
				{false, true, false, false},
				{true, true, false, false},
				{true, false, false, false},
				{false, false, false, false},
			},
		};
		
		filledSquares = pieceZMatrix;
	}

	
}