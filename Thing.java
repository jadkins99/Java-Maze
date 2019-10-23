import java.util.*;

// Interface for the "Things" that can occupy space on a square in the maze
public interface Thing {
	public int positionX = 0;
	public int positionY = 0;
	public void setMaze(Maze maze);
	public void setFindingAlgorithm(PathFinder algorithm);
	public void setPositionX(int x);
	public void setPositionY(int y);
    public void display();
    public void move(DirType direction);
    public String getType();
    public LinkedList<DirType> getMove();
    
}
