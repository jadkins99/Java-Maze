import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font;
import javafx.scene.shape.ArcType;

public class MazeDisplayGraphics{
    public static int SIZE = 600;
    public static int MARGIN = 20;
    public static double LINE_WIDE = 4;
    static double BOX_WIDE;
    static double BOX_TALL;
    static int FONT_SIZE;
    static GraphicsContext gc;

    static void display(RectMaze the_maze, Canvas can){
	int max_x = the_maze.getMaxX();
	int max_y = the_maze.getMaxY();
        int max_dim = 0;
	gc = can.getGraphicsContext2D();

	if (max_x > max_y){
	    max_dim = max_x;
	}
	else{
	    max_dim = max_y;
	}

	BOX_WIDE = (SIZE-2*MARGIN)/max_dim;
	BOX_TALL = (SIZE-2*MARGIN)/max_dim;
	gc.setLineWidth(LINE_WIDE);

	gc.clearRect(0,0,SIZE,SIZE);

	for(int i=0;i<max_x; i++){
	    for(int j=0; j<max_y; j++){
		displayLoc(the_maze, i,j, MARGIN+BOX_WIDE*i, MARGIN+BOX_TALL*j);

	    }
	}

    }

    static void displayLoc(RectMaze the_maze, int i, int j, double x, double y){
	List<DirType> dirs = the_maze.getDirections(i,j);

	gc.setFill(Color.WHITE);
	gc.setStroke(Color.BLACK);
	gc.setTextAlign(TextAlignment.LEFT);
	gc.setFont(Font.font("Helvetica", FONT_SIZE));

	if(dirs != null){

	    if(!dirs.contains(DirType.North)){
		gc.strokeLine(x,y,x+BOX_WIDE,y);
	    }

	    if(!dirs.contains(DirType.South)){
		gc.strokeLine(x,y+BOX_TALL,x+BOX_WIDE,y+BOX_TALL);
	    }

	    if(!dirs.contains(DirType.West)){
		gc.strokeLine(x,y,x,y+BOX_TALL);
	    }

	    if(!dirs.contains(DirType.East)){
		gc.strokeLine(x+BOX_WIDE,y,x+BOX_WIDE,y+BOX_TALL);
	    }
	}
    }


}
