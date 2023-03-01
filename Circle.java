package Project;

/**
 * Class that models figures of the type circle
 */
public class Circle extends Figure{

    // Attributes 
    
    public int radius;   // percentage value of the radius
            
    
    
    private static final double PI = 3.1416;
    private static final int MAX=50;
    private static final int MIN=0;
    
    /**
     * Constructor to create circle type figures
     * @param radius The radius of the circle
     * @param color The color of the circle
     */
    Circle(int radius, Color color) {
        
        
        if(radius>MAX)
        this.radius=50;
        else if(radius<MIN)
        this.radius=0;
        else this.radius=radius;

        
    }

    
    /**
     * Method that gets the porcentage of the tile that the circle occupies
     * @return The area of the circle 
     */
    public double area() {
        return PI*(this.radius*this.radius)/100;
   
    }
    /**
     * An overrided method from the Figure class used to compare two circles  
     * @param figure The figure(circle) that we want to compare 
     * @return A boolean that shows whether a circle is equal to another  
     */
    public boolean isEqualTo(Figure figure) {	
        if((this.radius == ((Circle)figure).radius) && (this.color == figure.color))
        return true;
        else
        return false;	


    }
    /**
     * Method used to create a string with the data of the circle 
     * @return A string with all the info of a circle
     */
    public String toString() {
                
        return " Radius: " + radius + ", Color: " + color;
                
    }	
    

    
    /**
     * Getter method that gets the radius of the circle
     * @return The radius of the specified circle
     */
    public int getRadius(){
        return this.radius;
    }
    
    /**
     * Setter that changes the value of the radius of a circle
     * @param i The new value of the radius
     */
    public void setRadius(int i){
        if(i>MAX)
        this.radius=50;
        else if(i<MIN)
        this.radius=0;
        else
        this.radius = i;
    }
    
    

 }
