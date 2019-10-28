import java.util.*;

public class HallwayGenerator implements MazeGenerator{
  public void generate(Maze m){
    int x = 0;
    int y = 0;

    m.genRandMaze();
    Random r = new Random();
    while (x != m.getRows()-1 || y != m.getColumns()-1) {
      int direction = r.nextInt(2);
      if (direction == 0 && x < m.getColumns()) {
        if( x != m.getColumns() -1 ) {
        m.maze[y][x].e = false;
        
          m.maze[y][x+1].w = false;
          x++;
        }
        
      }
      if (direction == 1 && y < m.getRows()) {
        if ( y != m.getRows() -1) {
        m.maze[y][x].s = false;        
        m.maze[y+1][x].n = false;
        y++;
        }
        
      }
    }
  }


}
