import java.util.*;

class StayRightPathFinder implements PathFinder {

    public LinkedList<DirType> findPath(Maze maze){

        LinkedList<DirType> solutionList = new LinkedList<DirType>();
        int x = 0, y = 0, i = 0;
        int maxX = maze.getRows();
        int maxY = maze.getColumns();
        Square[][] mazeArray = maze.getMaze();
        boolean finish = false;
        int facing = 0;
        
        while(!finish) {
            if (facing == 0){
                //System.out.println("Facing == 0");
                if (mazeArray[x][y].e == false){
                    solutionList.add(DirType.East);
                    facing = 1;
                    y++;
                    System.out.println("Right");
                }
                else if (mazeArray[x][y].n == false){
                    solutionList.add(DirType.North);
                    facing = 0;
                    x--;
                    System.out.println("Forward");
                }
                else if (mazeArray[x][y].s == false){
                    solutionList.add(DirType.South);
                    facing = 2;
                    x++;
                    System.out.println("Backward");
                }
                else if (mazeArray[x][y].w == false){
                    solutionList.add(DirType.West);
                    facing = 3;
                    y--;
                    System.out.println("Left");
                }
            }
            else if (facing == 1){
                //System.out.println("Facing == 1");
                if (mazeArray[x][y].s == false){
                    solutionList.add(DirType.South);
                    facing = 2;
                    x++;
                    System.out.println("Right");
                }
                else if (mazeArray[x][y].e == false){
                    solutionList.add(DirType.East);
                    facing = 1;
                    y++;
                    System.out.println("Forward");
                }
                else if (mazeArray[x][y].w == false){
                    solutionList.add(DirType.West);
                    facing = 3;
                    y--;
                    System.out.println("Backward");
                }
                else if (mazeArray[x][y].n == false){
                    solutionList.add(DirType.North);
                    facing = 0;
                    x--;
                    System.out.println("Left");
                }
            }
            else if (facing == 2){
                //System.out.println("Facing == 2");
                if (mazeArray[x][y].w == false){
                    solutionList.add(DirType.West);
                    facing = 3;
                    y--;
                    System.out.println("Right");
                }
                else if (mazeArray[x][y].s == false){
                    solutionList.add(DirType.South);
                    facing = 2;
                    x++;
                    System.out.println("Forward");
                }
                else if (mazeArray[x][y].e == false){
                    solutionList.add(DirType.East);
                    facing = 1;
                    y++;
                    System.out.println("Left");
                }
                else if (mazeArray[x][y].n == false){
                    solutionList.add(DirType.North);
                    facing = 0;
                    x--;
                    System.out.println("Backward");
                }/*
                else{
                    System.out.println("problem");
                    System.out.println(mazeArray[x][y].n == false);
                    System.out.println(mazeArray[x][y].e == false);
                    System.out.println(mazeArray[x][y].s == false);
                    System.out.println(mazeArray[x][y].w == false);
                }*/
            }
            else if (facing == 3){
                //System.out.println("Facing == 3");
                if (mazeArray[x][y].n == false){
                    solutionList.add(DirType.North);
                    facing = 0;
                    x--;
                    System.out.println("Right");
                }
                else if (mazeArray[x][y].w == false){
                    solutionList.add(DirType.West);
                    facing = 3;
                    y--;
                    System.out.println("Forward");
                }
                else if (mazeArray[x][y].s == false){
                    solutionList.add(DirType.South);
                    facing = 2;
                    x++;
                    System.out.println("Left");
                }
                else if (mazeArray[x][y].e == false){
                    solutionList.add(DirType.East);
                    facing = 1;
                    y++;
                    System.out.println("Backward");
                }
            }
            else {
                //System.out.println("Breaking (Facing): " + facing);
                break;
            }
            
            if(x == maxX-1 && y == maxY-1) {
                //System.out.println("Breaking (x, y): " + x + ", " + y + " | " + (maxX - 1) + ", " + (maxX - 1));
                finish = true;
            }
            
            //System.out.println("Facing, i: " + facing + ", " + i);
            
            i++;
            if(i > 5000) {
                //System.out.println("Breaking (i): " + i);
                break;
            }
        }

        if(finish == true) {
            System.out.println("SOLUTION FOUND");
            return solutionList;
        } else {
            System.out.println("NO SOLUTION FOUND");
            return new LinkedList<DirType>();
        }

        


    }

}