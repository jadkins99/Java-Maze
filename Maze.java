import java.lang.Math; 
public class Maze {
    int numRows;
    int numColumns;
    Square[][] maze;
    
    public Maze(int numRows, int numColumns, Square[][] maze) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.maze = maze;
    }
    
    public int getRows(){
        return this.numRows;
    }
    
    public int getColumns(){
        return this.numColumns;
    }

    public void initStatic(){ 
        boolean[] walls = new boolean[4]; 
        
        for(int i=0; i < numRows; i++) {
            for(int j=0; j < numColumns; j++) {  
                for(int a = 0; a<4; a++) {
                    walls[a] = false;
                }
                
                this.maze[i][j] = new Square(walls[0],walls[1],walls[2],walls[3],i,j);
            }
        }
        
        boolean setTo = true;
        
        this.maze[0][0].setWall('s', setTo);
        this.maze[0][3].setWall('s', setTo);
        
        this.maze[1][0].setWall('n', setTo); this.maze[1][0].setWall('e', setTo);
        this.maze[1][1].setWall('w', setTo); this.maze[1][1].setWall('s', setTo);  this.maze[1][1].setWall('e', setTo);
        this.maze[1][2].setWall('w', setTo); this.maze[1][2].setWall('e', setTo);
        this.maze[1][3].setWall('w', setTo); this.maze[1][3].setWall('n', setTo);
        this.maze[1][6].setWall('s', setTo);
        
        this.maze[2][1].setWall('n', setTo); this.maze[2][1].setWall('s', setTo);
        this.maze[2][6].setWall('s', setTo); this.maze[2][6].setWall('n', setTo);
        
        this.maze[3][1].setWall('n', setTo); this.maze[3][1].setWall('s', setTo);
        this.maze[3][6].setWall('s', setTo); this.maze[3][6].setWall('n', setTo);
        
        this.maze[4][1].setWall('n', setTo); this.maze[4][1].setWall('s', setTo);
        this.maze[4][3].setWall('s', setTo); this.maze[4][3].setWall('e', setTo);
        this.maze[4][6].setWall('n', setTo); this.maze[4][6].setWall('w', setTo); this.maze[4][6].setWall('e', setTo);
        this.maze[4][5].setWall('e', setTo); this.maze[4][5].setWall('w', setTo);
        this.maze[4][4].setWall('w', setTo); this.maze[4][4].setWall('e', setTo);
        this.maze[4][7].setWall('w', setTo); this.maze[4][7].setWall('e', setTo);
        this.maze[4][8].setWall('w', setTo); this.maze[4][8].setWall('s', setTo);
        
        this.maze[5][1].setWall('n', setTo); this.maze[5][1].setWall('s', setTo);
        this.maze[5][3].setWall('n', setTo); this.maze[5][3].setWall('s', setTo);
        this.maze[5][5].setWall('s', setTo);
        this.maze[5][8].setWall('n', setTo); this.maze[5][8].setWall('s', setTo);
        
        this.maze[6][0].setWall('e', setTo); this.maze[6][0].setWall('s', setTo);
        this.maze[6][1].setWall('w', setTo); this.maze[6][1].setWall('n', setTo); this.maze[6][1].setWall('e', setTo);
        this.maze[6][2].setWall('e', setTo); this.maze[6][2].setWall('w', setTo);
        this.maze[6][3].setWall('w', setTo); this.maze[6][3].setWall('n', setTo); this.maze[6][3].setWall('e', setTo);
        this.maze[6][4].setWall('e', setTo); this.maze[6][4].setWall('w', setTo);
        this.maze[6][5].setWall('n', setTo); this.maze[6][5].setWall('e', setTo); this.maze[6][5].setWall('w', setTo);
        this.maze[6][6].setWall('w', setTo);
        this.maze[6][8].setWall('s', setTo); this.maze[6][8].setWall('n', setTo);
        
        this.maze[7][0].setWall('n', setTo); this.maze[7][0].setWall('s', setTo);
        this.maze[7][6].setWall('e', setTo); this.maze[7][6].setWall('s', setTo);
        this.maze[7][7].setWall('e', setTo); this.maze[7][7].setWall('w', setTo);
        this.maze[7][8].setWall('w', setTo); this.maze[7][8].setWall('n', setTo);
        this.maze[7][8].setWall('e', setTo); this.maze[7][8].setWall('s', setTo);
        this.maze[7][9].setWall('s', setTo); this.maze[7][9].setWall('w', setTo);
        
        this.maze[8][0].setWall('e', setTo); this.maze[8][0].setWall('n', setTo);
        this.maze[8][1].setWall('w', setTo); this.maze[8][1].setWall('e', setTo);
        this.maze[8][2].setWall('e', setTo); this.maze[8][2].setWall('w', setTo);
        this.maze[8][3].setWall('w', setTo); this.maze[8][3].setWall('e', setTo);
        this.maze[8][4].setWall('e', setTo); this.maze[8][4].setWall('w', setTo);
        this.maze[8][6].setWall('n', setTo);
        this.maze[8][8].setWall('n', setTo);
        this.maze[8][9].setWall('s', setTo); this.maze[8][9].setWall('n', setTo);
        
        this.maze[9][9].setWall('n', setTo);
    }
    
    public void init() {
        double rand = Math.random(); 
        boolean[] walls = new boolean[4]; 
        for(int i=0; i < numRows; i++) {
            for(int j=0; j < numColumns; j++) {                
                for(int a = 0; a<4; a++) {
                    if(rand < 0.5) {
                        walls[a] = true;
                    } else {
                        walls[a] = false;
                    }
                    rand = Math.random();
                }
                this.maze[i][j] = new Square(walls[0],walls[1],walls[2],walls[3],i,j);
            }
        }
    }
    
    public Square[][] getMaze(){
        return this.maze;
    }
    
    public void display() {

        for(int i=0; i < numRows; i++) {
            for(int j=0; j < numColumns; j++) {
                maze[i][j].display();
            }
            System.out.println();
        }
        
    }
}