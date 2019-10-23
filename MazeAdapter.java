import java.util.List;
import java.util.ArrayList;

public class MazeAdapter implements RectMaze{
    Square[][] newMaze = new Square[10][10];
    Maze maze;
    
    public MazeAdapter(){
        maze = new Maze(10, 10, newMaze);
        maze.init();
    }

    public List<DirType> getDirections(int x, int y){
        List<DirType> lst = new ArrayList<DirType>();
        Square[][] mazeArray = maze.getMaze();
        
	if (mazeArray[y][x].n == false){
	    lst.add(DirType.North);
	}
	if (mazeArray[y][x].s == false){
	    lst.add(DirType.South);
	}
	if (mazeArray[y][x].w == false){
	    lst.add(DirType.West);
	}
	if (mazeArray[y][x].e == false){
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
