import java.util.*;
class MazeMonster implements Thing{
	public PathFinder findingAlgorithm = new RandomPathFinder();
	public int positionX = 0;
	public int positionY = 0;
	public Maze maze;

	public void setMaze(Maze maze) {
		this.maze = maze;
	}
	public void setFindingAlgorithm(PathFinder algorithm) {
		findingAlgorithm = algorithm;
	}
	public void setPositionX(int x) {
		positionX = x;
	}
	public void setPositionY(int y) {
		positionY = y;
	}

	public void move(DirType direction) {

	  Square[][] mazeArray = maze.getMaze();
	  mazeArray[positionY][positionX].removeThing();
      if(direction == DirType.East) {
        positionX++;
      }
      if(direction == DirType.West) {
        positionX--;
      }
      if(direction == DirType.North) {
        positionY--;
      }
      if(direction == DirType.South) {
        positionY++;
      }
      mazeArray[positionY][positionX].setThing(this);    

  	}

	public void display() {

	}

	public MazeMonster(int x, int y){
		this.positionY = y;
		this.positionX = x;
	}

    public String getType() {
    	return "MazeMonster";
    }

    public LinkedList<DirType> getMove() {
    	return findingAlgorithm.findPath(maze);
    }

}