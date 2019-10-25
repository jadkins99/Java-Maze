import java.util.ArrayDeque;

public class BFSGenerator implements MazeGenerator{

  public void generate(Maze m){

  	ArrayDeque<Square> bfsQueue = new ArrayDeque<Square>();

    System.out.println("NEW TRY!");

    // generate new random maze
    m.genRandMaze();

    // boolean for knowing if the maze is solvable
    boolean solvable = false;

    // start and end squares
    Square start = m.maze[0][0];
    Square end = m.maze[m.getRows()-1][m.getColumns()-1];

    // add start to the queue
    bfsQueue.addFirst(start);


    while(bfsQueue.size() > 0){

      System.out.println(bfsQueue.size());

    // variable for the next square to examine
    Square currentSquare = bfsQueue.peekFirst();



    int k = 0;
    // add the neighbors of the square in the head of the queue that don't have walls and the square hasnt been visited
    if(!currentSquare.n && currentSquare.locationY-1 >= 0 && m.maze[currentSquare.locationY-1][currentSquare.locationX].squareVisited){
       k++;
        bfsQueue.addLast(m.maze[currentSquare.locationY-1][currentSquare.locationX]);
        m.maze[currentSquare.locationY-1][currentSquare.locationX].squareVisited = true;
}


    if(!currentSquare.e && currentSquare.locationX+1 <= m.getColumns()-1 && !m.maze[currentSquare.locationY][currentSquare.locationX+1].squareVisited){
      k++;
      m.maze[currentSquare.locationY][currentSquare.locationX+1].squareVisited = true;
      bfsQueue.addLast(m.maze[currentSquare.locationY][currentSquare.locationX+1]);
    }

    if(!currentSquare.w && currentSquare.locationX-1 >= 0 && !m.maze[currentSquare.locationY][currentSquare.locationX-1].squareVisited){
      k++;
      m.maze[currentSquare.locationY][currentSquare.locationX-1].squareVisited = true;
      bfsQueue.addLast(m.maze[currentSquare.locationY][currentSquare.locationX-1]);
}
	  if(!currentSquare.s && currentSquare.locationY+1 <= m.getRows()-1 && !m.maze[currentSquare.locationY+1][currentSquare.locationX].squareVisited){
      k++;
      m.maze[currentSquare.locationY+1][currentSquare.locationX].squareVisited = true;
      bfsQueue.addLast(m.maze[currentSquare.locationY+1][currentSquare.locationX]);
}

	if(currentSquare == end){
	solvable = true; // maze has a solution

	break;
}


	// remove the current square
	bfsQueue.pollFirst();


  //System.out.println(k);

}



// if not solvable, recursively call generate
if(!solvable) generate(m);





  }
}
