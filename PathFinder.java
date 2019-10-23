import java.util.*;
// Interface for the "PathFinders" that are used for finding path in a given maze.
// Each "Thing" may have a PathFinder or not.
public interface PathFinder{

    public LinkedList<DirType> findPath(Maze maze);
    
}
