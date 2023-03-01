package Project;

/**
 * Class that models figures of the type rectangle
 * @author Carlos and Ruben
 */
public class Rectangle extends Figure{

    // Atributes
    
    public int width;
    public int height;

    //Static Atributes
    private static final int MAX=100;
    private static final int MIN=0;

    /**
     * Constructor that creates figures of the type rectangle
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @param color The color of the rectangle
     */
    Rectangle(int width, int height, Color color){

    

    if(width>MAX)
    this.width=MAX;
    else if(width<MIN)
    this.width=MIN;
    else this.width=width;

    if(height>MAX)
    this.height=MAX;
    else if(height<MIN)
    this.height=MIN;
    else this.height=height;
    }

    /**
     * Method compares two figure (rectangle) objects 
     * @param figure The figure (rectangle) to be compared
     * @return A boolean that determines whether the two rectangles are equal or not
     */
    public boolean isEqualTo(Figure figure){
        if((this.height==((Rectangle)figure).height)&&(this.width==((Rectangle)figure).width)&&(this.color==figure.color))
        return true;
        else return false;
    }
    /**
     * Method that creates a string with the data of a rectangle
     * @return The string with the data of the rectangle
     */
    public String toString(){
        return " Height: " + height + ", Width: " + width +  ", Color: " + color;
    }

    //Getters and Setters
    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    /**
     * Method that returns the porcentage of the size of the rectangle
     * @return The porcentage of the size of the rectangle
     */
    public double area(){
        return ((this.width*this.height)/100);//funciona aunque no lo parezca
    }
    
     public void setWidth(int width){
          if(width>MAX)
          this.width=MAX;
          else if(width<MIN)
          this.width=MIN;
          else this.width=width;

    }
     public void setHeight(int height){
   

    if(height>MAX)
    this.height=MAX;
    else if(height<MIN)
    this.height=MIN;
    else this.height=height;
    
    }
   
}