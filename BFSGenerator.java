public class BFSGenerator implements MazeGenerator{

  public void generate(Maze m){

    m.genRandMaze();
    Square start = m.maze[0][0];
    Square end = m.maze[m.getRows()-1][m.getColumns()-1];
  }



}
