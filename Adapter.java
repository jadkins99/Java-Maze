import java.util.List;
import java.util.ArrayList;

public class Adapter implements RectMaze{
  Maze myMaze;
  //List<DirType> directionList;
  int m = 2;
  int n = 2;
  Square[][] maze = new Square[m][n];


  public Adapter(){

    myMaze = new Maze(m,n,maze);
    //directionList = new ArrayList<DirType>();

  }

public List<DirType> getDirections(int x,int y){
  List<DirType> directionList = new ArrayList<DirType>(); ;
  Square s = myMaze.maze[y][x];

  if(s.n) directionList.add(DirType.North);
  if(s.s) directionList.add(DirType.South);
  if(s.e) directionList.add(DirType.East);
  if(s.w) directionList.add(DirType.West);
  return directionList;

}

  public int getMaxX(){
    return myMaze.numColumns;
  }

  public int getMaxY(){
    return myMaze.numRows;
  }

}
