package Project;

/**
 * Class that models tiles
 */
public class Tile implements Luminosity{

//Atributes

public Figure figure;
public Color color;
public int state;
public String position;
public int luminosityChange=0;

//Static Atributes

private static final int MAX=100;
private static final int MIN=0;

public static String right="R";
public static String up="U";
public static String down="D";
public static String center="C";
public static String left="L";


public static int wTile;
public static int hTile;

//Methods

//Constructor just Color

/**
 * Constructor that creates tiles without figure
 * @param color The color of the tile
 * @param state The state of the tile that can be 0,1 and 2
 */
Tile(Color color, int state){
    this.color=color;
    this.state = state;
}
/**
 * Constructor that creates tiles with figure
 * @param color The color of the tile
 * @param state The state of the tile that can be 0,1 and 2
 * @param figure The figure inside of the tile
 * @param position The position of the figure inside the tile
 */
Tile(Color color, Figure figure, String position, int state){
    this.color = color;
    this.position = position;
    this.state = state;
    this.figure = figure;
}




//Getters and Setters

    //Get Width y Get Height ya existen en clase rectangle. Conflicto?

    // las wTile y la hTile son ctes.

/**
 * Method that changes the size of all the tiles at the same time
 * @param w The new width of all the tiles
 * @param h The new height of all the tiles
 */
public static void setSize(int w, int h){
   if((w>100)&&(h>0)&&(h<100)){  
    Tile.wTile=100;
    Tile.hTile=h;
    }
    else if((w<0)&&(h>0)&&(h<100)){
    Tile.wTile=0;
    Tile.hTile=h;
    }
    else if((h>100)&&(w>0)&&(w<100)){
    Tile.hTile=100;
    Tile.wTile=w;
    }
    else if((h<0)&&(w>0)&&(w<100)){
    Tile.hTile=0;
    Tile.wTile=w;
    }
    else if((h<0)&&(w<0)){//
    Tile.hTile=0;
    Tile.wTile=0;
    }
      else if((h>100)&&(w>100)){
    Tile.hTile=100;
    Tile.wTile=100;
    }
      else if((h<0)&&(w>100)){
    Tile.hTile=0;
    Tile.wTile=100;
    }
      else if((w<0)&&(h>100)){
    Tile.hTile=100;
    Tile.wTile=0;
    }
    else{
        Tile.wTile=w;
        Tile.hTile=h;
    }
}

//String tostring (para printear)  // un metodo siempre tiene que tener un return

/**
 * Method that creates a string with the data of a tile depending on if they has figure or not and on the type of figure it has
 * @return A string with the data of a tile
 */
public String toString(){
   
    if(this.figure instanceof Circle){
    return "Color: " + color + " Circle: " + figure + " Position: " + position + " State: " + state;
    }
    else if(this.figure instanceof Rectangle){
    return "Color: " + color + " Rectangle " + figure + " Position: " + position + " State: " + state;
    }
    else if(this.figure instanceof Triangle){
    return "Color: " + color + " Triangle " + figure + " Position: " + position + " State: " + state;
    }  
    else 
    return "Color: " + color + " State: " + state;
}



//Boolean para saber si la tile tiene figura. solo puede retornar 2 cosas o true o false

/**
 * Method that checks whether a tile has figure or not
 * @return A boolean that determines whether a tile has figure or not
 */
public boolean hasFigure(){
    if(this.figure == null){
    return false;
    }
    else{ 
    return true;
    }
}

//Boolean is equal para saber si hay 2 tiles iguales

/**
 * Method that compares two tiles
 * @param tile A tile to be compared
 * @return A boolean that determines whether the two tiles are equal or not
 */
public boolean isEqualTo(Tile tile){               
      if((this.hasFigure()==false)&&(tile.hasFigure()==false)){
        if((this.color.isEqualTo(tile.color))){
            return true;
        }
        else 
        return false;
    }  

     else{



    if(this.color.isEqualTo(tile.color)){
        if((this.figure instanceof Circle) && (tile.figure instanceof Circle)){
            if( ((Circle)this.figure).isEqualTo(((Circle)tile.figure))){//
                return true;
            }
            else{
                return false;
            }
        }
                                                                                                 
        else if((this.figure instanceof Rectangle) && (tile.figure instanceof Rectangle)){
            if( ((Rectangle)this.figure).isEqualTo(((Rectangle)tile.figure))){
               return true; 
            }
            else{
               return false; 
            }
        }

        else if((this.figure instanceof Triangle) && (tile.figure instanceof Triangle)){
            if( ((Triangle)this.figure).isEqualTo(((Triangle)tile.figure))){
               return true; 
            }
            else{
               return false; 
            }
        }
        
        else{
            return false;
        }
    }
    
    else{
        return false;
    } 

    }  
}//cierra funcion                   
                    
                
  /**
   * Method that changes the luminosityChange attribute of the tile
   * @param value The new value of the luminosityChange attribute of the tile
   */          
  public void changeLuminosity(int value){
   this.luminosityChange=this.luminosityChange+value;

  } 

  public void changeStateT(int value){
   this.state=value;

  }             
                  
public int getluminosityChange(){
    return this.luminosityChange;
}             



public static int getWidth(){
    return Tile.wTile;
}

public static int getHeight(){
    return Tile.hTile;
}

}//class




