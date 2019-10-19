import java.util.List;
import java.util.ArrayList;

public class MazeAdapter implements RectMaze{
    Square[][] newMaze = new Square[10][10];
    Maze maze;
    
    public MazeAdapter(){
        maze = new Maze(10, 10, newMaze);
        maze.initStatic();
    }

    public List<DirType> getDirections(int x, int y){
        List<DirType> lst = new ArrayList<DirType>();
        Square[][] mazeArray = maze.getMaze();
        
	if (mazeArray[y][x].n == true){
	    lst.add(DirType.North);
	}
	if (mazeArray[y][x].s == true){
	    lst.add(DirType.South);
	}
	if (mazeArray[y][x].w == true){
	    lst.add(DirType.West);
	}
	if (mazeArray[y][x].e == true){
	    lst.add(DirType.East);
	}
	
	return lst;
    }
    
    public int getMaxX(){
        return maze.getRows();
    }
    
    public int getMaxY(){
        return maze.getColumns();
    }
}
