import java.util.*;
class MazeMonster implements Thing{
	public PathFinder findingAlgorithm = new RandomPathFinder();
	public int positionX = 0;
	public int positionY = 0;


	
	public void setFindingAlgorithm(PathFinder algorithm) {
		findingAlgorithm = algorithm;
	}
	public void setPositionX(int x) {
		positionX = x;
	}
	public void setPositionY(int y) {
		positionY = y;
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
    	return findingAlgorithm.findPath();
    }

}