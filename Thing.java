// Interface for the "Things" that can occupy space on a square in the maze
public interface Thing<T extends Thing>{

    public void display();
    public Thing getType();
    
}
