import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.*;
import javafx.event.*;

import java.util.concurrent.TimeUnit;

public class MazeApplication extends Application{
    RectMaze the_maze;
    Canvas maze_canvas;
    int creatorAlg = 0;
    int finderAlg = 0;
    int click = 0;

    //The start function just sets up the main window for the application
    //We will discuss JavaFx later in the term
    public void start(Stage primaryStage){
        primaryStage.setTitle("A Maze");
        Group root = new Group();
        maze_canvas = new Canvas(900, 600);

        root.getChildren().add(maze_canvas);
        Scene mazeScene = new Scene(root, 900, 600, Color.WHITE);
        primaryStage.setScene(mazeScene);
        primaryStage.show();
        mazeScene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                animateSolution();
            }
        });
        MazeDisplayGraphics.displayStep(the_maze, maze_canvas,"Please click on the screen.",50);
    }
    void animateSolution() {
        MazeGenerator generator = new BFSGenerator();
        PathFinder finder = new RandomPathFinder();

        if(click == 0 ) {
            MazeDisplayGraphics.displayStep(the_maze, maze_canvas,"1. = HallwayGenerator starting",100);
            generator = new HallwayGenerator();
            finder = new RandomPathFinder();
            the_maze = new MazeAdapter(generator, finder);
            MazeDisplayGraphics.display(the_maze, maze_canvas);
            MazeDisplayGraphics.displayStep(the_maze, maze_canvas,"2. = HallwayGenerator finished",120);
        }
        if(click == 1 ) {
            MazeDisplayGraphics.displayStep(the_maze, maze_canvas,"3. = RandomPathFinder starting.", 140);
            DirType dir;
            int x = 0, y = 0;
            Thing crazyMonster = the_maze.getThing(0,0);

            LinkedList<DirType> path = new LinkedList<DirType>();
            path = crazyMonster.getMove();

            ListIterator<DirType> iterator = path.listIterator();
            while( iterator.hasNext() ) {
                crazyMonster.move(iterator.next());
            }        
            MazeDisplayGraphics.display(the_maze, maze_canvas);
            MazeDisplayGraphics.displayPath(the_maze, maze_canvas, path);
            MazeDisplayGraphics.displayStep(the_maze, maze_canvas,"4. = RandomPathFinder finished.", 160);
            MazeDisplayGraphics.displayStep(the_maze, maze_canvas,"Step 4 took " + path.size() + "steps ", 180);
        }
        if( click == 2 ) {
            MazeDisplayGraphics.displayStep(the_maze, maze_canvas,"5. = BFSGenerator starting", 200);
            generator = new BFSGenerator();
            finder = new StayRightPathFinder();
            the_maze = new MazeAdapter(generator, finder);
            MazeDisplayGraphics.display(the_maze, maze_canvas);
            MazeDisplayGraphics.displayStep(the_maze, maze_canvas,"6. = BFSGenerator finished.", 220);

        }
        if (click == 3 ) {
            MazeDisplayGraphics.displayStep(the_maze, maze_canvas,"7. = StayRightPathFinder starting.", 240);
            DirType dir;
            int x = 0, y = 0;
            Thing crazyMonster = the_maze.getThing(0,0);

            LinkedList<DirType> path = new LinkedList<DirType>();
            path = crazyMonster.getMove();

            ListIterator<DirType> iterator = path.listIterator();
            while( iterator.hasNext() ) {
                crazyMonster.move(iterator.next());
            }        
            MazeDisplayGraphics.display(the_maze, maze_canvas);
            MazeDisplayGraphics.displayPath(the_maze, maze_canvas, path);
            MazeDisplayGraphics.displayStep(the_maze, maze_canvas,"8. = StayRightPathFinder finished.", 260);
            if( path.size() == 0) {
            MazeDisplayGraphics.displayStep(the_maze, maze_canvas,"Step 8 couldn't find a solution. ", 280);
            } else {
            MazeDisplayGraphics.displayStep(the_maze, maze_canvas,"8. = " + path.size() + "steps ", 280);
            }
            MazeDisplayGraphics.displayStep(the_maze, maze_canvas,"THANK YOU!", 300);

        }


        click ++;
    }
    void animateSolution2() {
        System.out.println("Solution starts");
        MazeGenerator generator = new BFSGenerator();
        PathFinder finder = new RandomPathFinder();
        if( creatorAlg == 0 ) {
            generator = new BFSGenerator();
            finder = new RandomPathFinder();
            creatorAlg++;
        } else if(creatorAlg == 1 ) {
            generator = new HallwayGenerator();
            finder = new RandomPathFinder();
            creatorAlg++;
        } if(creatorAlg == 2) {
            creatorAlg = 0;
            animateSolution();
        }

        the_maze = new MazeAdapter(generator, finder);
        MazeDisplayGraphics.display(the_maze, maze_canvas);

        

        DirType dir;
        int x = 0, y = 0;
        Thing crazyMonster = the_maze.getThing(0,0);

        LinkedList<DirType> path = new LinkedList<DirType>();
        path = crazyMonster.getMove();

        ListIterator<DirType> iterator = path.listIterator();
        while( iterator.hasNext() ) {
            crazyMonster.move(iterator.next());
        }        
        MazeDisplayGraphics.display(the_maze, maze_canvas);
        MazeDisplayGraphics.displayPath(the_maze, maze_canvas, path);
    }

}
