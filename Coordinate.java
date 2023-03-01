package Project;
/**
 * Class that models a new type of object: Coordinates
 */
public class Coordinate implements Comparable<Coordinate>{

private int row;
private int column;
/**
 * Constructor that creates new coordinate objects
 * @param row The row of the coordinate in the mosaic
 * @param column The column of the coordinate in the mosaic
 */
Coordinate(int row,int column){
    this.row=row;
    this.column=column;
}

public int getRow(){
    return this.row;
}
public int getColumn(){
    return this.column;
}
public void setRow(int row){
    this.row=row;
}
public void setColumn(int column){
    this.column=column;
}
/**
 * Method that creates a string with the data of a coordinate
 * @return A string with the data of a coordinate
 */
public String toString(){
    return "(" + this.row + "," + this.column + ")";
}
/**
 * Method that compares two coordinates ussing the comparable interface
 * @return An int that determines the order of the two coordinates compared
 * @param cor The coordinate to be compared
 */
@Override
public int compareTo(Coordinate cor) {
    if(this.row<cor.row){
        return -1;
    }
    else if((this.row==cor.row) && (this.column<cor.column)){
        return -1;
    }
    else if((this.row==cor.row) && (this.column==cor.column)){
        return 0;
    }
    else if((this.row==cor.row) && (this.column>cor.column)){
        return 1;
    }
    else {
        return 1;
    }
        
    
}
/**
 * Method that compares two coordinates to know if they are equal or not
 * @param c The coordinate to be compared
 * @return A boolean that shows whether the two coordinates compared are equal or not
 */
public boolean isEqualTo(Coordinate c){
    if((this.row == c.row)&&(this.column == c.column)){
        return true;
    }
    else{
        return false;
    }
}


}//end of class