public abstract class MazeGenerator{

  public void generate(Maze m);

  public void genRandMaze(){
    double rand = Math.random();
    boolean[] walls = new boolean[4];
    for(int i=0; i < numRows; i++) {
        for(int j=0; j < numColumns; j++) {
            for(int a = 0; a<4; a++) {
                if(rand < 0.1) {
                    walls[a] = true;
                } else {
                    walls[a] = false;
                }
                rand = Math.random();
            }

            if(i == 0) walls[0] = true;
            if(i == numRows-1) walls[3] = true;
            if(j == 0) walls[2] = true;
            if(j == numColumns-1) walls[1] = true;
            this.maze[i][j] = new Square(walls[0],walls[1],walls[2],walls[3],i,j);
        }
    }
  }

}
