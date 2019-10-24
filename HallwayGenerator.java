import java.util.*;

public class HulkSmashGenerator implements MazeGenerator{
  public void generate(Maze m){
    int x = 0;
    int y = 0;

    m.genRandMaze();
    Random r = new Random();
    while (x != m.getRows()-1 && y != m.getColumns()-1) {
      int direction = r.nextInt(4);
      if (direction == 0) {
        m[y][x].n = false;
        y--;
        m[y][x].s = false;
      }
      if (direction == 1) {
        m[y][x].s = false;
        y++;
        m[y][x].n = false;
      }
      if (direction == 2) {
        m[y][x].w = false;
        x--;
        m[y][x].e = false;
      }
      if (direction == 3) {
        m[y][x].e = false;
        x++;
        m[y][x].w = false;
      }
    }
  }


}
