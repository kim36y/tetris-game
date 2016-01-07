import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;


public class TetrisBoardGUIView extends JComponent
{
	private TetrisBoard board;

	
	
	public TetrisBoardGUIView(TetrisBoard b)
	{
		super();
		board = b;
	}
	
	/**
	 * Paint the game.
	 */
	public void paint(Graphics g)
	{
		paintBackground(g);
		paintBoardOutline(g, computeBlockSize());
		paintBlock(g, board.getCurrentPieceGridPosition()[0], board.getCurrentPieceGridPosition()[1], computeBlockSize());
	}
	
	public void paintBackground(Graphics g)
	{
	      g.setColor(new Color(224, 224, 224));
	      g.fillRect(0, 0, getWidth(), getHeight());  
	}
	
	/*
	 * Paint the Outline of the Board
	 */
	private void paintBoardOutline(Graphics g,int blockSize)
	{
		g.setColor(new Color(204, 255, 255));
		g.fillRect(0, 10, blockSize*board.getNumCols(), blockSize*board.getNumRows());
		g.setColor(Color.BLACK);
		g.drawRect(0, 10, blockSize*board.getNumCols(), blockSize*board.getNumRows());
	}
	
	
	/*
	 * Paint the block at grid row, grid col.
	 */
	private void paintBlock(Graphics g, int row, int col, int blockSize)
	{
		for (int i = 0; i < board.getNumRows(); i++)
		{
			for (int j = 0; j < board.getNumCols(); j++)
			{
				if ( (board.hasBlock(i, j)) || (((i - row) >= 0) && ((i - row) < 4) &&
						((j - col) >= 0) && ((j - col) < 4) &&
						(board.getCurrentPiece().isFilled((board.getCurrentPiece().getPieceRotation()), (i - row), (j - col)))) ) 
						{
						int x = j*blockSize;
						int y = 10 + i*blockSize;
						g.setColor(Color.BLACK);
						g.draw3DRect(x, y, blockSize, blockSize, true);
						g.setColor(new Color(153, 153, 255));
						g.fill3DRect(x, y, blockSize, blockSize, true);
						
					}

				}
			}
	}
	
	
	/**
	 * Compute the best block size for the current width and height.
	 * @return size (for a square block) in pixels
	 */
	private int computeBlockSize()
	{
		return (getHeight()/board.getNumRows());
	}
}
