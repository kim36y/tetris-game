/** Tetris piece type L **/
public class TetrisL extends TetrisPiece
{
	
	public TetrisL()
	{
		super();
		
		boolean[][][] pieceLMatrix = 
		{
			{
				{true, false, false, false},
				{true, false, false, false},
				{true, true, false, false},
				{false, false, false, false},
			},
			{
				{true, true, true, false},
				{true, false, false, false},
				{false, false, false, false},
				{false, false, false, false},
			},
			{
				{true, true, false, false},
				{false, true, false, false},
				{false, true, false, false},
				{false, false, false, false},
			},
			{
				{false, false, true, false},
				{true, true, true, false},
				{false, false, false, false},
				{false, false, false, false},
			},
		};
	
		filledSquares = pieceLMatrix;
	}
	
}