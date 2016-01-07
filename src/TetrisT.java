/** Tetris piece type T **/
public class TetrisT extends TetrisPiece
{
	
	public TetrisT()
	{
		super();
		
		boolean[][][] pieceTMatrix = 
		{
		
			{
				{false, true, false, false},
				{true, true, true, false},
				{false, false, false, false},
				{false, false, false, false}
			},
			{
				{false, true, false, false},
				{false, true, true, false},
				{false, true, false, false},
				{false, false, false, false}
			},
			{
				{false, false, false, false},
				{true, true, true, false},
				{false, true, false, false},
				{false, false, false, false}
			},
			{
				{false, true, false, false},
				{true, true, false, false},
				{false, true, false, false},
				{false, false, false, false}
			}
		}; 
		
		filledSquares = pieceTMatrix;
		
		}
	}
