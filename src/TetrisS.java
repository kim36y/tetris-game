/** Tetris piece type S **/
public class TetrisS extends TetrisPiece
{ 
	
	public TetrisS()
	{
		super();
	
		boolean[][][] pieceSMatrix = 
		{
			{
				{false, true, true, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false}
			},
			{
				{true, false, false, false},
				{true, true, false, false},
				{false, true, false, false},
				{false, false, false, false}
			},
			{
				{false, true, true, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false}
			},
			{
				{true, false, false, false},
				{true, true, false, false},
				{false, true, false, false},
				{false, false, false, false}
			} 
		};
	
		filledSquares = pieceSMatrix;
	}
	

}