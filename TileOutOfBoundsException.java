package Project;
/**
 * Class that models a exception that happens when a tile is outside the given mosaic
 * @author Carlos and Ruben
 */
public class TileOutOfBoundsException extends Exception {
    /**
     * Constructor that creates a new TileOutOfBoundException
     */
    public TileOutOfBoundsException() {
        super ("TileOutOfBoundsException");
    }
}