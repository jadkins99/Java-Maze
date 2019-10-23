import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MazeApplication extends Application{
    RectMaze the_maze;
    Canvas maze_canvas;
    
    //The start function just sets up the main window for the application
    //We will discuss JavaFx later in the term
    public void start(Stage primaryStage){
        primaryStage.setTitle("A Maze");
        Group root = new Group();
        maze_canvas = new Canvas(1200, 800);
 
        root.getChildren().add(maze_canvas);
        primaryStage.setScene(new Scene(root, 1200, 800, Color.WHITE));
        primaryStage.show();

	    displayTheMaze();
    }

    //Here is where the maze is created
    //... Replace TestMaze with a class you have created!
    void displayTheMaze() {
    	the_maze = new MazeAdapter();
    	MazeDisplayGraphics.display(the_maze, maze_canvas);
        DirType dir;
        int x = 0, y = 0;
        Thing crazyMonster = the_maze.getThing(0,0);

        LinkedList<DirType> path = new LinkedList<DirType>();
        path = crazyMonster.getMove();

        ListIterator<DirType> iterator = path.listIterator();
        long mls = System.currentTimeMillis();
        while( iterator.hasNext() ) {
            if(System.currentTimeMillis() - mls > 1000) { 
            crazyMonster.move(iterator.next());
            System.out.println("moved");
            MazeDisplayGraphics.display(the_maze, maze_canvas);
            mls = System.currentTimeMillis();
            }
        }

        
    }

}
	