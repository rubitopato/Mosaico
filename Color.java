package Project;

/**
 * Class that models colors
 */
public class Color {

    // Attributes
    private int r;
    private int g;
    private int b;


    /**
     * A final attribute that determines the maximum value that each parameter of the color can take
     */
    private static final int MAX = 255;


    /**
     * Constructor that creates colors
     * @param r The red parameter of the color
     * @param g The green parameter of the color
     * @param b The blue parameter of the color
    */
    Color(int r, int g, int b) {
            this.r= r;
            this.g= g;
            this.b= b;
        if (r > MAX){
            this.r=MAX;
        }
        if (b > MAX){
            this.b=MAX;
        }
        if (g > MAX){
            this.g=MAX;
        }
       
    }


    /**
     * Method that creates white colors
     * @return A white color
     */
    public static final Color WHITE() {
        return new Color(255,255,255);
    }

    /**
     * Method that creates black colors
     * @return A black color
     */
    public static final Color BLACK() {
        return new Color(0,0,0);
    }
    /**
     * Method that creates red colors
     * @return A red color
     */
    public static final Color RED() {
        return new Color(255,0,0);
    }
    /**
     * Method that creates green colors
     * @return A green color
     */
    public static final Color GREEN() {
        return new Color(0,255,0);
    }
    /**
     * Method that creates blue colors
     * @return A blue color
     */
    public static final Color BLUE() {
        return new Color(0,0,255);
    }
    /**
     * Method that creates yellow colors
     * @return A yellow color
     */
    public static final Color YELLOW() {
        return new Color(255,255,0);
    }
    /**
     * Method that creates magenta colors
     * @return A magenta color
     */
    public static final Color MAGENTA() {
        return new Color(229,9,127);
    }
    /**
     * Method that creates cyan colors
     * @return A cyan color
     */
    public static final Color CYAN() {
        return new Color(0,255,255);
    }


    /**
     * Method that compares two colors
     * @param color One of the colors to be compared
     * @return A boolean that determines whether the colors are equal or not
     */
    public boolean isEqualTo(Color color) {
        

        if (color.r==this.r && color.g==this.g && color.b==this.b){
            
            return true;
        }else{
            return false;
        }
       
    }
    /**
     * Method that creates a string with the data of a circle
     * @return A string with the data of a circle
     */
    public String toString() {
        return "R"+r+"G"+g+"B"+b;
    }

    // Getters And Setters
    public int getR() {
        return this.r;
    }

    public int getG() {
        return this.g;
    }

    public int getB() {
        return this.b;
    }
    public void setR(int r) {
        this.r=r;
        return;
    }

    public void setG(int g) {
        this.g=g;
        return;
    }
    public void setB(int b) {
        this.b=b;
        return;
    }
}
