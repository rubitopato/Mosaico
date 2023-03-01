package Project;
/**
 * Class that models figures(Circles and rectangles)
 */
abstract public class Figure{

public Color color;
/**
 * An empty constructor
 */
Figure(){
       this.color = color;
}
/**
 * Method that changes the color of a figure
 * @param color The new value of the color of the figure
 */
public void setColor(Color color){
        this.color = color;
    }
/**
 * Getter method to retrieve the color of a figure
 * @return The color of a figure
*/
public Color getColor(){
        return this.color;
    }
/**
 * Abstract method defined for all the figures that will create a string with the data of a figure
 * @return A string with the data of a figure
 */
public abstract String toString();
/**
 * Abstract method defined for all the figures that will get the porcentage of tile that a figure occupies
 * @return The porcentage of tile that a figure occupies
 */
public abstract double area();
/**
 * Abstract method defined for all the figures that will compare two figures two know if they are identical
 * @param figure The figure to be compared
 * @return A boolean that determines whether the two figures compared are equal or not
 */
public abstract boolean isEqualTo(Figure figure);








}