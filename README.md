# Java-Maze
## Object Oriented Design - Fall 2019

A maze program in Java. Created by Atalay Kutlay, Timon Braun, Tyrell Daniels, and Jacob Adkinds. It includes two approaches to create a maze and
two approaches to solve a maze. 

![Screenshot](assets/javamaze.gif)

Creating approaches :
- BFSGenerator (Jacob Adkinds)
- HallwayGenerator (Timon Braun)


Solving approaches :
- RandomPathFinder (Atalay Kutlay)
- StayRightPathFinder (Tyrell Daniels)
	
You can find details about the approaches in the documentation below.

# Documentation

## BFSGenerator

BFSGenerator is a maze generator class for our program. The class implements the MazeGenerator interface. 

Methods :

- generate(Maze m) : This method takes a maze and generates a solveble maze. It creates a random maze first, and then tests if the maze is solveable
using a Breadth-first search to find the finishing point from the starting point.

## MazeGenerator

MazeGenerator is an interface for the maze generator approaches.

Methods : 

- generate(Maze m)

## PathFinder

PathFinder is an interface for the maze navigation(path finder) approaches.

Methods : 

- findPath(Maze maze)




## StayRightPathFinder

StayRightPathFinder is class, which implements the PathFinder class, that solves the maze by following the right wall from the start of the
maze until the end of the maze.

Methods : 

- findPath(Maze maze): The algorithm used for solving the maze using the "Stick to the right wall" approach. Turn Priority: Right, Forward, Left, Backward.




## RandomPathFinder

RandomPathFinder is an class, which implements the PathFinder class, that solves the maze by picking a random direction for the monster
to go that has no wall blocking it's movement, from the start of the maze until the end of the maze.

Methods :

- findPath(Maze maze): The algorithm used for picking a random un-obstructed direction for the monster to turn. Turn Priority: None.




## Square

Square is the class that allows you to create the squares that make up the maze grid.

Methods :

- Square(boolean n, boolean e, boolean w, boolean s, int locationX, int locationY): The constructor method for a square, specifying which walls the square
has and the coordinates of the square.

- Contains(): This returns the type of the "thing" if one exists in the square, otherwise it returns a null.

- getThing(): This returns the "thing" that exists within the square.

- setThing(Thing t): This sets the "thing" that exists within the square equal to the input(t) of the method.

- removeThing(): This sets the "thing", that may or may not exist, within the square equal to null.

- setWall(char wallToSet, boolean wallOrNoWall): This sets the specified wall(wallToSet) of the square to either exist or not exist(wallOrNoWall).

No longer in use:
	- display(): This method is intended to draw all the walls of the square that exist.
	



## Thing

Thing is an interface for all future objects that you might want to put inside of the maze.

Methods :

- setMaze(Maze maze)

- setFindingAlgorithm(PathFinder algorithm)

- setPositionX(int x)

- setPositionY(int y)

- display()

- move(DirType direction)

- getType()

- getMove()




## Maze

Maze is the class that handles the initialization of the maze, the creation of the objects that go in the maze and the path finder class used to solve the maze.

Methods :

- Maze(int numRows, int numColumns, Square[][] maze): This is the constructor for the maze, which specifies the size of the maze and creates the array
that will contain the squares that make up the maze.

- getRows(): This returns the amount of rows in the maze as an integer.

- getColumns(): This returns the amount of columns in the maze as an integer.

- initStatic(): This intitializes the creation of a hand-made maze that will never change, seperate of any maze generation code that exists, that is intended
to be used a testing maze for path-finding algorithms in other, path-finder, classes. This also creates a MazeMonster "thing" and calls it's
setFindingAlgorithm(PathFinder algorithm) method and sets algorithm equal to a specified path-finding class and it's setMaze(Maze maze) method
and sets maze equal to the newly created maze. This also calls the first square's(maze[0][0]) setThing(Thing t) method and sets t equal to the
newly created monster.

- init(): This will initialize the creation of a randomly-generated maze using a specified algorithmic maze-generation class. This also creates
a MazeMonster "thing" and calls it's setFindingAlgorithm(PathFinder algorithm) method and sets algorithm equal to a specified path-finding class
and it's setMaze(Maze maze) method and sets maze equal to the newly created maze. This also calls the first square's(maze[0][0]) setThing(Thing t)
method and sets t equal to the newly created monster.

- genRandMaze(): Generates a totally random maze. No guarantee to be solvable. 

- getMaze(): This will return an array containing all the squares that make up the maze.

- display(): Displays the maze. Not used since Adapter class takes care of displaying.




## MazeAdapter

MazeAdqapter is the class that transoforms the output of the Maze class into an input that the MazeDisplayGraphics class can understand.

Methods :

- MazeAdapter(): The constructor for a mazeadapter. This creates a new maze with a specified size and calls the new mazes init(), or initStatic(), method.

- getThing(int x, int y): Calls the getThing() method for the square at the specified index (x, y) in the maze array.

- getMaze(): Returns the maze.

- getDirections(int x, int y): Returns a list of direction where a wall exist.

- getMaxX(): Calls the maze's getRows() method.

- getMaxY(): Calls the maze's getColumns() method.




## RectMaze

RectMaze is an interface for the Adapter.

Methods :

- getDirections(int x, int y)
- getThing(int x, int y)
- getMaxX()
- getMaxY()


## HallwayGenerator

HallwayGenerator is a Maze generator. It creates a totally random maze first. Then, it basically assigns an "imaginary" monster that can brake walls. It makes this "imaginary" monster to go from the starting point to the ending point. Thanks to our "imaginary" monster we ensure that we created a solvable maze.


## MazeMonster

MazeMonster implements the thing interface and creates a monster to solve the maze.

Methods :

- setMaze(Maze maze): This sets the maze that the mazemonster will be solving.

- setFindingAlgorithm(PathFinder algorithm): This sets the path-finder class that the mazemonster will be using.

- setPositionX(int x): This the sets the value of the mazemonster's x coordinate in the maze.

- setPositionY(int y): This the sets the value of the mazemonster's y coordinate in the maze.

- move(DirType direction): This finds out which direction the square the maze monster should move to is, in the maze, from the set path-finding class
and changes the value of the mazemonster's x or y coordinate in the maze accordingly.

- display()

- MazeMonster(int x, int y): The constructor for the mazemonster, it sets the x and y of the mazemonster in the maze.

- getType(): This return the type of "thing" the mazemonster is.

- getMove(): It returns a list of moves that is the solution to the maze.




## MazeDisplayGraphics


Methods :

- displayPath(RectMaze the_maze, Canvas can, LinkedList<DirType> path): Displays a given path on the screen.

- display(RectMaze the_maze, Canvas can): Displays the all maze using displayLoc function.

- displayLoc(RectMaze the_maze, int i, int j, double x, double y): Displays a single Square.




## MazeApplication

MazeApplication is the main class. It uses MazeAdapter to control Maze class ( which is our main class )

Methods :

- start(Stage primaryStage): JavaFX's start method. Initializes the stage and a scene. Writes "Please click on the screen." to the screen.

- animateSolution(): When the mouse handler catches a mouse click, this function is called.