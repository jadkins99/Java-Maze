import java.util.*;

class RandomPathFinder implements PathFinder {

	public LinkedList<DirType> findPath(Maze maze){

		LinkedList<DirType> solutionList = new LinkedList<DirType>();
		int x = 0,y = 0,i = 0;
		int maxX = maze.getRows();
		int maxY = maze.getColumns();
		double rand;
		Square[][] mazeArray = maze.getMaze();
		boolean finish = false;
		while(!finish) {

			 rand = Math.random();

			if(rand < 0.3 && mazeArray[y][x].e == false) {
				solutionList.add(DirType.East);
				x++;
			} else if(rand >= 0.3 && rand < 0.6 && mazeArray[y][x].s == false) {
				solutionList.add(DirType.South);
				y++;
			} else if(rand >= 0.6 && rand <= 0.8 && mazeArray[y][x].w == false) {
				solutionList.add(DirType.West);
				x--;
			} else if(rand > 0.8 && mazeArray[y][x].n == false) {
				solutionList.add(DirType.North);
				y--;
			}

			if(x == maxX-1 && y == maxY-1) {
				finish = true;
			}
			i++;
			if(i > 500) {
				break;
			}
		}

		if(finish == true) {
			return solutionList;
		} else {
			return false;
		}


	}

}