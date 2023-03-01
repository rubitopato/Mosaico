package Project;

public class Triangle extends Figure{

    // Atributes
    
    public int base;
    public int altura;

    //Static Atributes
    private static final int MAX=100;
    private static final int MIN=0;

    /**
     * Constructor that creates figures of the type rectangle
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @param color The color of the rectangle
     */
    Triangle(int base, int altura, Color color){

    

    if(base>MAX)
    this.base=MAX;
    else if(base<MIN)
    this.base=MIN;
    else this.base=base;

    if(altura>MAX)
    this.altura=MAX;
    else if(altura<MIN)
    this.altura=MIN;
    else this.altura=altura;
    }

    /**
     * Method compares two figure (rectangle) objects 
     * @param figure The figure (rectangle) to be compared
     * @return A boolean that determines whether the two rectangles are equal or not
     */
    public boolean isEqualTo(Figure figure){
        if((this.altura==((Triangle)figure).altura)&&(this.base==((Triangle)figure).base)&&(this.color==figure.color))
        return true;
        else return false;
    }
    /**
     * Method that creates a string with the data of a rectangle
     * @return The string with the data of the rectangle
     */
    public String toString(){
        return "Triangle Height: " + altura + ", Width: " + base +  ", Color: " + color;
    }

    //Getters and Setters
    public int getBase(){
        return this.base;
    }

    public int getAltura(){
        return this.altura;
    }

    /**
     * Method that returns the porcentage of the size of the rectangle
     * @return The porcentage of the size of the rectangle
     */
    public double area(){
        return ((this.base*this.altura)/200);//funciona aunque no lo parezca
    }
    
     public void setBase(int base){
          if(base>MAX)
          this.base=MAX;
          else if(base<MIN)
          this.base=MIN;
          else this.base=base;

    }
     public void setAltura(int altura){
   

    if(altura>MAX)
    this.altura=MAX;
    else if(altura<MIN)
    this.altura=MIN;
    else this.altura=altura;
    
    }
   
}