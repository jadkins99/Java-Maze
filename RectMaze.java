import java.util.List;

public interface RectMaze{
    List<DirType> getDirections(int x, int y);
    Thing getThing(int x, int y);
    int getMaxX();
    int getMaxY();
}