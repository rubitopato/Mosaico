package Project;

import java.io.*; //con esto incluyes todo lo que hay en io
import java.util.*;
import java.lang.*;

/**
 * Class to model mosaics, a set of tiles.
 * @author Carlos and Ruben
 */
public class Mosaic implements Luminosity{

   
 

  



    // Attributes 

    public Map<Coordinate,Tile> mapTiles;
    public int rowsMosaic;//
    public int columnsMosaic;//
    public LinkedList<RectangularRegion> regions;
     
    


    
    /**
     * Constructor that creates a mosaic given by a file
     * @author Carlos and Ruben
     * @param file The file where the mosaic is given
     * @throws TileOutOfBoundsException It is an exception that happens when a tile of the mosaic is outside the limits of the mosaic
     */
    Mosaic(String file) throws TileOutOfBoundsException{
	
   //usar el scanner 
     this.mapTiles = new TreeMap<Coordinate,Tile>();
     regions=new LinkedList<RectangularRegion>();
     String sizeTile;
     int widthTile;
     int heightTile;
     String sizeMosaic;//

     boolean firstLine;
     String tilePlace;
     int tileFila;
     int tileColumna;
     int activated;
     int tileRed;
     int tileGreen;
     int tileBlue;
   
     String figure;
     String figureColor;
     int figureRed;
     int figureGreen;
     int figureBlue;
     String location;
     int circleRadius;
     int recW;
     int recH;
     String details;
    
     String figureDetails;
     String circleSize;
     String rectangleSize;
     String rectangleFinal;
     ///////////////////////////
     String triangleSize;
     String triangleFinal;
     int triW;
     int triH;
     ////////////////////
     String CIR = "CIR";
     String REC = "REC";
     String TRI = "TRI";
    // Con esto leemos las lineas de Mosaic.txt
   Scanner input= null;
   
   try{

       input = new Scanner( new FileInputStream (file));
   }
   catch(FileNotFoundException e){
       System.out.println("File open error");
             try{//esto es pa printear el error en le file
             PrintWriter error4 = null;
             error4 = new PrintWriter (new FileOutputStream("Project/error.txt"));
             error4 = new PrintWriter (new FileOutputStream("Project/error.txt",true));
             error4.println("FileNotFoundException");
             error4.close();
             System.exit(-1);
             }
             catch(FileNotFoundException q){
              System.out.println("Error file could not be opened");
              System.exit(-1);
             }
       
   }

   String line = null;
   
   
   firstLine=false;
   while (input.hasNextLine()){
       line=input.nextLine();
       line=line.toUpperCase();
       line=line.trim();

       if(line.indexOf("*")==0){
       
           continue;
        }
       else if(firstLine==false){
       sizeMosaic=line.substring(0,line.indexOf(","));
       
       sizeTile=line.substring(line.indexOf(",") + 1,line.length());
      
       rowsMosaic=Integer.parseInt(sizeMosaic.substring(0,sizeMosaic.indexOf("X")));
       columnsMosaic=Integer.parseInt(sizeMosaic.substring(sizeMosaic.indexOf("X")+1,sizeMosaic.length()));
       
       
      
       

       heightTile=Integer.parseInt(sizeTile.substring(0,sizeTile.indexOf("X")));
       widthTile=Integer.parseInt(sizeTile.substring(sizeTile.indexOf("X")+1,sizeTile.length()));

       Tile.setSize(widthTile,heightTile);
       
       firstLine=true;
       continue;//lo q sea
       }

       else{
        

        if(line.length() < 23){//solo color
            tilePlace=line.substring(0,line.indexOf(":"));
            
            
            tileFila=Integer.parseInt(tilePlace.substring(1,tilePlace.indexOf(",")));
            tileColumna=Integer.parseInt(tilePlace.substring(tilePlace.indexOf(",")+1, tilePlace.indexOf(")")));
         
            if(tileFila > rowsMosaic){
            throw new TileOutOfBoundsException();
            }

            if(tileColumna > columnsMosaic){
            throw new TileOutOfBoundsException();  
            }

            if(tileFila < 1){
            throw new TileOutOfBoundsException();
            }

            if(tileColumna < 1){
            throw new TileOutOfBoundsException();
            }
            
            //hasta aqui la posicion
            activated=Integer.parseInt(line.substring(line.indexOf(":")+1,line.indexOf("{")));
             
            //hasta el activated 
            tileRed=Integer.parseInt(line.substring(line.indexOf("R")+1,line.indexOf("G")));
            
            tileGreen=Integer.parseInt(line.substring(line.indexOf("G")+1,line.indexOf("B")));
            
            tileBlue=Integer.parseInt(line.substring(line.indexOf("B")+1,line.indexOf("}")));
            
            //hasta aqui el color
            //tile[tileFila-1][tileColumna-1] = new Tile (new Color(tileRed,tileGreen,tileBlue), activated);
            
            this.mapTiles.put(new Coordinate(tileFila,tileColumna), new Tile (new Color(tileRed,tileGreen,tileBlue), activated));
            
            
            //por si acaso escribir
            continue;
        } 
        
        else{
            //tile con figura
            
            tilePlace=line.substring(0,line.indexOf(")"));
            tileFila=Integer.parseInt(tilePlace.substring(1,tilePlace.indexOf(",")));
            tileColumna=Integer.parseInt(tilePlace.substring(tilePlace.indexOf(",")+1, tilePlace.length()));

            if(tileFila > rowsMosaic){
            throw new TileOutOfBoundsException();
            }

            if(tileColumna > columnsMosaic){
            throw new TileOutOfBoundsException();  
            }

            if(tileFila < 1){
            throw new TileOutOfBoundsException();
            }

            if(tileColumna < 1){
            throw new TileOutOfBoundsException();
            }


            //hasta aqui exception
            //hasta aqui la posicion

            activated=Integer.parseInt(line.substring(line.indexOf(":")+1,line.indexOf("{")));
            //hasta el activated 

            tileRed=Integer.parseInt(line.substring(line.indexOf("R")+1,line.indexOf("G")));
            tileGreen=Integer.parseInt(line.substring(line.indexOf("G")+1,line.indexOf("B")));
            tileBlue=Integer.parseInt(line.substring(line.indexOf("B")+1,line.indexOf(",",line.indexOf("R"))));

            details=line.substring(line.indexOf("{")+1,line.length());

            figure=details.substring(details.indexOf(",")+1,details.indexOf(":"));//aqui la figura
            figureDetails=details.substring(details.indexOf(":")+1,details.length());//corchete de la figura hasta el final

            if(figure.equals(CIR)){
                //circulo
            figureRed=Integer.parseInt(figureDetails.substring(figureDetails.indexOf("R")+1,figureDetails.indexOf("G")));//aqui el color rojo del circulo
            figureGreen=Integer.parseInt(figureDetails.substring(figureDetails.indexOf("G")+1,figureDetails.indexOf("B")));//aqui el color verde del circulo
            figureBlue=Integer.parseInt(figureDetails.substring(figureDetails.indexOf("B")+1,figureDetails.indexOf(",")));//aqui el color azul del circulo

            circleSize=figureDetails.substring(figureDetails.indexOf(",")+1,figureDetails.length());
            location=circleSize.substring(0,circleSize.indexOf(","));//position

            circleRadius=Integer.parseInt(circleSize.substring(circleSize.indexOf(",")+1,circleSize.indexOf("}")));

            //tile[tileFila-1][tileColumna-1] = new Tile (new Color(tileRed,tileGreen,tileBlue),new Circle(circleRadius, new Color (figureRed,figureGreen,figureBlue)),location,activated);
            
            this.mapTiles.put(new Coordinate(tileFila,tileColumna), new Tile (new Color(tileRed,tileGreen,tileBlue),new Circle(circleRadius, new Color (figureRed,figureGreen,figureBlue)),location,activated));
            
            
            continue;
            }
            else if(figure.equals(REC)){
                  //rectangulo  
            figureRed=Integer.parseInt(figureDetails.substring(figureDetails.indexOf("R")+1,figureDetails.indexOf("G")));//aqui el color rojo del circulo
            figureGreen=Integer.parseInt(figureDetails.substring(figureDetails.indexOf("G")+1,figureDetails.indexOf("B")));//aqui el color verde del circulo
            figureBlue=Integer.parseInt(figureDetails.substring(figureDetails.indexOf("B")+1,figureDetails.indexOf(",")));//aqui el color azul del circulo

            rectangleSize=figureDetails.substring(figureDetails.indexOf(",")+1,figureDetails.length());

            location=rectangleSize.substring(0,rectangleSize.indexOf(","));//position   
            
            rectangleFinal=rectangleSize.substring(rectangleSize.indexOf(",")+1,rectangleSize.length());
            
            recH=Integer.parseInt(rectangleFinal.substring(0,rectangleFinal.indexOf(",")));
            recW=Integer.parseInt(rectangleFinal.substring(rectangleFinal.indexOf(",")+1,rectangleFinal.indexOf("}")));//altura y width
            
            //tile[tileFila-1][tileColumna-1]=new Tile(new Color(tileRed,tileGreen,tileBlue),new Rectangle(recW,recH,new Color(figureRed,figureGreen,figureBlue)),location,activated);
            
            this.mapTiles.put(new Coordinate(tileFila,tileColumna),new Tile(new Color(tileRed,tileGreen,tileBlue),new Rectangle(recW,recH,new Color(figureRed,figureGreen,figureBlue)),location,activated));
            
            
            continue;
            }
            //triangulo
            else{
                  //rectangulo  
            figureRed=Integer.parseInt(figureDetails.substring(figureDetails.indexOf("R")+1,figureDetails.indexOf("G")));//aqui el color rojo del circulo
            figureGreen=Integer.parseInt(figureDetails.substring(figureDetails.indexOf("G")+1,figureDetails.indexOf("B")));//aqui el color verde del circulo
            figureBlue=Integer.parseInt(figureDetails.substring(figureDetails.indexOf("B")+1,figureDetails.indexOf(",")));//aqui el color azul del circulo

            triangleSize=figureDetails.substring(figureDetails.indexOf(",")+1,figureDetails.length());

            location=triangleSize.substring(0,triangleSize.indexOf(","));//position   
            
            triangleFinal=triangleSize.substring(triangleSize.indexOf(",")+1,triangleSize.length());
            
            triH=Integer.parseInt(triangleFinal.substring(0,triangleFinal.indexOf(",")));
            triW=Integer.parseInt(triangleFinal.substring(triangleFinal.indexOf(",")+1,triangleFinal.indexOf("}")));//altura y width
            
            //tile[tileFila-1][tileColumna-1]=new Tile(new Color(tileRed,tileGreen,tileBlue),new Rectangle(recW,recH,new Color(figureRed,figureGreen,figureBlue)),location,activated);
            
            this.mapTiles.put(new Coordinate(tileFila,tileColumna),new Tile(new Color(tileRed,tileGreen,tileBlue),new Triangle(triW,triH,new Color(figureRed,figureGreen,figureBlue)),location,activated));
            
            
            continue;
            }
        
        
        
        
        
        }//tile con figura


       }//no es la primera linea



     }//while
     input.close();


     initialize();

    
    }//constructor
    /**
     * Method to set the non-specified tiles to a white tile without figure
     */
    public void initialize(){
    Map<Coordinate,Tile> temporal = new LinkedHashMap<Coordinate,Tile>();//creo un mapa copia para no sobresaturar el set
    temporal.putAll(mapTiles);
    Set<Coordinate> keys=temporal.keySet();
    for(int i=1;i <= rowsMosaic;i++){
       for(int j=1;j <= columnsMosaic;j++){
           Coordinate cor = new Coordinate(i,j);//estas coordenadas van a ir por orden
          
              if(mapTiles.containsKey(cor) == false){//si k y la coordenada cor no son iguales y en mapTiles no hay valor para cor, mete una llave cor y una tile en blaco en esa llave
              
               mapTiles.put(cor,new Tile(new Color(255,255,255),1));//aqui la mete
               
               continue;
               
           }
           else {
               
               continue;
           }
        }
        }   
       
    
    return; 
    }//initialize



    /**
     * Method to create a string of all the tiles in the mosaic to display
     * @return A string with the data of all the tiles in the mosaic
     */
    public String toString(){

     String s1;
     String s2 = "\n";
     String s3;  
     String s4 = "";
    s4=rowsMosaic + "x" + columnsMosaic + "," + Tile.getHeight() + "x" + Tile.getWidth();
    Set<Coordinate> keys=mapTiles.keySet();
    
        for(Coordinate k:keys){
        
        
            
            
            mapTiles.get(k).color.setR((mapTiles.get(k).color.getR() + mapTiles.get(k).luminosityChange)%256);
            mapTiles.get(k).color.setG((mapTiles.get(k).color.getG() + mapTiles.get(k).luminosityChange)%256);
            mapTiles.get(k).color.setB((mapTiles.get(k).color.getB() + mapTiles.get(k).luminosityChange)%256);
            //
            if(mapTiles.get(k).figure != null){
            mapTiles.get(k).figure.color.setR((mapTiles.get(k).figure.color.getR() + mapTiles.get(k).luminosityChange)%256);
            mapTiles.get(k).figure.color.setG((mapTiles.get(k).figure.color.getG() + mapTiles.get(k).luminosityChange)%256);
            mapTiles.get(k).figure.color.setB((mapTiles.get(k).figure.color.getB() + mapTiles.get(k).luminosityChange)%256);
            }
            

            if(mapTiles.get(k).color.getR() < 0) 
            mapTiles.get(k).color.setR(mapTiles.get(k).color.getR() + 256);

            if(mapTiles.get(k).color.getG() < 0) 
            mapTiles.get(k).color.setG(mapTiles.get(k).color.getG() + 256);

            if(mapTiles.get(k).color.getB() < 0) 
            mapTiles.get(k).color.setB(mapTiles.get(k).color.getB() + 256);


        if(mapTiles.get(k).figure != null){
            if(mapTiles.get(k).figure.color.getR() < 0)
            mapTiles.get(k).figure.color.setR(mapTiles.get(k).figure.color.getR() + 256);

            if(mapTiles.get(k).figure.color.getG() < 0)
            mapTiles.get(k).figure.color.setG(mapTiles.get(k).figure.color.getG() + 256);

            if(mapTiles.get(k).figure.color.getB() < 0)
            mapTiles.get(k).figure.color.setB(mapTiles.get(k).figure.color.getB() + 256);
        }
        
            
        if(mapTiles.get(k).state == 1){

            if(mapTiles.get(k).figure instanceof Circle){
            Circle tempCircle= ((Circle) mapTiles.get(k).figure);
             s1 = "(" + k.getRow() + "," + k.getColumn() + "):" + mapTiles.get(k).state + "{" + mapTiles.get(k).color + ",CIR:{" + tempCircle.color + "," + mapTiles.get(k).position + "," + tempCircle.radius + "}}";
             s3 = s2.concat(s1);
             s4=s4.concat(s3);
                       
            continue;
            //con circulo
        }
        else if((this.mapTiles.get(k).figure instanceof Rectangle)){
            Rectangle temprect= ((Rectangle) mapTiles.get(k).figure);
            s1="(" + k.getRow() + "," + k.getColumn() + "):" + mapTiles.get(k).state + "{" + mapTiles.get(k).color + ",REC:{" + temprect.color + "," + mapTiles.get(k).position + "," + temprect.height + "," + temprect.width + "}}";
            s3 = s2.concat(s1);
            s4=s4.concat(s3);
            continue;
            
            //con rectangulo
            
        }
        else if((this.mapTiles.get(k).figure instanceof Triangle)){
            Triangle temptri= ((Triangle) mapTiles.get(k).figure);
            s1="(" + k.getRow() + "," + k.getColumn() + "):" + mapTiles.get(k).state + "{" + mapTiles.get(k).color + ",TRI:{" + temptri.color + "," + mapTiles.get(k).position + "," + temptri.altura + "," + temptri.base + "}}";
            s3 = s2.concat(s1);
            s4=s4.concat(s3);
            continue;
            
            //con rectangulo
            
        }
        else{
            s1="(" + k.getRow() + "," + k.getColumn() + "):" + mapTiles.get(k).state + "{" + mapTiles.get(k).color + "}";
            s3 = s2.concat(s1);
            s4=s4.concat(s3);
            continue;
            //sin nada
        }
        
        
        }//if state 1

        else if(mapTiles.get(k).state == 2){//state 2

            

        if(mapTiles.get(k).figure instanceof Circle){
            mapTiles.get(k).figure.color.setR(0);
            mapTiles.get(k).figure.color.setG(0);
            mapTiles.get(k).figure.color.setB(0);
            

            Circle tempCircle= ((Circle) mapTiles.get(k).figure);
             s1 = "(" + k.getRow() + "," + k.getColumn() + "):" + mapTiles.get(k).state + "{" + mapTiles.get(k).color + ",CIR:{" + tempCircle.color + "," + mapTiles.get(k).position + "," + tempCircle.radius + "}}";
             s3 = s2.concat(s1);
             s4=s4.concat(s3);
                       
            continue;
            //con circulo
        }
        else if((this.mapTiles.get(k).figure instanceof Rectangle)){
            mapTiles.get(k).figure.color.setR(0);
            mapTiles.get(k).figure.color.setG(0);
            mapTiles.get(k).figure.color.setB(0);
            
            
            Rectangle temprect= ((Rectangle) mapTiles.get(k).figure);
            s1="(" + k.getRow() + "," + k.getColumn() + "):" + mapTiles.get(k).state + "{" + mapTiles.get(k).color + ",REC:{" + temprect.color + "," + mapTiles.get(k).position + "," + temprect.height + "," + temprect.width + "}}";
            s3 = s2.concat(s1);
            s4=s4.concat(s3);
            continue;
            
            //con rectangulo
            
        }
        else if((this.mapTiles.get(k).figure instanceof Triangle)){
            mapTiles.get(k).figure.color.setR(0);
            mapTiles.get(k).figure.color.setG(0);
            mapTiles.get(k).figure.color.setB(0);
            
            
            Triangle temptri= ((Triangle) mapTiles.get(k).figure);
            s1="(" + k.getRow() + "," + k.getColumn() + "):" + mapTiles.get(k).state + "{" + mapTiles.get(k).color + ",TRI:{" + temptri.color + "," + mapTiles.get(k).position + "," + temptri.altura + "," + temptri.base + "}}";
            s3 = s2.concat(s1);
            s4=s4.concat(s3);
            continue;
            //con rectangulo
            
        }
        else{
            
            s1="(" + k.getRow() + "," + k.getColumn() + "):" + mapTiles.get(k).state + "{" + mapTiles.get(k).color + "}";
            s3 = s2.concat(s1);
            s4=s4.concat(s3);
            continue;
            //sin nada
        }

        }//state 2


        else {//state 0

            mapTiles.get(k).color.setR(0);
            mapTiles.get(k).color.setG(0);
            mapTiles.get(k).color.setB(0);
            

            

        if(mapTiles.get(k).figure instanceof Circle){
            mapTiles.get(k).figure.color.setR(0);
            mapTiles.get(k).figure.color.setG(0);
            mapTiles.get(k).figure.color.setB(0);
            

            Circle tempCircle= ((Circle) mapTiles.get(k).figure);
             s1 = "(" + k.getRow() + "," + k.getColumn() + "):" + mapTiles.get(k).state + "{" + mapTiles.get(k).color + ",CIR:{" + tempCircle.color + "," + mapTiles.get(k).position + "," + tempCircle.radius + "}}";
             s3 = s2.concat(s1);
             s4=s4.concat(s3);
                       
            continue;
            //con circulo
        }
        else if((this.mapTiles.get(k).figure instanceof Rectangle)){
            mapTiles.get(k).figure.color.setR(0);
            mapTiles.get(k).figure.color.setG(0);
            mapTiles.get(k).figure.color.setB(0);
            

            Rectangle temprect= ((Rectangle) mapTiles.get(k).figure);
            s1="(" + k.getRow() + "," + k.getColumn() + "):" + mapTiles.get(k).state + "{" + mapTiles.get(k).color + ",REC:{" + temprect.color + "," + mapTiles.get(k).position + "," + temprect.height + "," + temprect.width + "}}";
            s3 = s2.concat(s1);
            s4=s4.concat(s3);
            continue;
            
            //con rectangulo
            
        }
        else if((this.mapTiles.get(k).figure instanceof Triangle)){
            mapTiles.get(k).figure.color.setR(0);
            mapTiles.get(k).figure.color.setG(0);
            mapTiles.get(k).figure.color.setB(0);
            

            Triangle temptri= ((Triangle) mapTiles.get(k).figure);
            s1="(" + k.getRow() + "," + k.getColumn() + "):" + mapTiles.get(k).state + "{" + mapTiles.get(k).color + ",TRI:{" + temptri.color + "," + mapTiles.get(k).position + "," + temptri.altura + "," + temptri.base + "}}";
            s3 = s2.concat(s1);
            s4=s4.concat(s3);
            continue;
            
            //con rectangulo
            
        }
        else{
            
            s1="(" + k.getRow() + "," + k.getColumn() + "):" + mapTiles.get(k).state + "{" + mapTiles.get(k).color + "}";
            s3 = s2.concat(s1);
            s4=s4.concat(s3);
            continue;
            //sin nada
        }



        }//state 0

       }//for
      
    
    
    return s4;
    }//toString
    
    /**
     * Method to save the content of the mosaic to a given file
     * @param file The file where the content of the mosaic should be stored
     */
    public void saveToFile(String file){

    PrintWriter output = null;
    
    try{

        
        output = new PrintWriter (new FileOutputStream(file));
        output = new PrintWriter (new FileOutputStream(file,true));
        output.println(this.toString());
        output.close();
        
    }
    catch(FileNotFoundException r){
            System.out.println("File could not be opened");

            try{//pa printear el error

             PrintWriter error2 = null;
             error2 = new PrintWriter (new FileOutputStream("Project/error.txt"));
             error2 = new PrintWriter (new FileOutputStream("Project/error.txt",true));
             error2.println("FileNotFoundException");
             error2.close();
             System.exit(-1);
            }

            catch(FileNotFoundException p){

            System.out.println("Error file could not be opened");
            System.exit(-1);
            }
             
          }
       
       return;
       }

    //Getters

    
    /**
     * Method to add to the regions linkedlist a new Rectangular region
     * @param r The region to add to the regions attribute
     */
    public void addRegion(RectangularRegion r){
        regions.add(r);
        
    }  
    
    /**
     * Getter method to retrieve a specified Rectangular region
     * @param name The name of the wanted region
     * @return The wanted region
     */
    public RectangularRegion getRegion(String name){
        Iterator<RectangularRegion> it = regions.iterator();
        RectangularRegion a = null;
        while((it.hasNext()==true)&&(a==null)){
            a=it.next();
            if(a.name.compareTo(name)==0){
                a=a;
                
            }
            else{
                a=null;
            }
        }
       return a;

    }

    /**
     * Method used to sort the regions attribute according to their size and then to their name
     */
    public void sortRegionsByAreaAsc(){
        Collections.sort(regions,new NameComparator());
        
    }
    /*public void sortRegionsByAreaDes(){
        Collections.sort(regions,new ComparatorPrueba());
        
    }*/
    /**
     * Method used to create a string with the data of all the Rectangular regions stored in the regions attribute
     * @return The string with the data of all the Rectangular regions in the regions attribute
     */
   public String toStringRegions(){
       Iterator<RectangularRegion> it = regions.iterator();
       RectangularRegion a;
       String c;
       String d="";
       while(it.hasNext()==true){
       a=it.next();
       c=(a.toString() + "\n");//aqui dejaria una linea extra al final de printearlo
       d=d.concat(c);
       }
       
       return d;
       
   }
    /**
     * Method to retrieve the data of an specified tile in the mosaic
     * @param c The key coordinate associated with the wanted tile
     * @return The wanted tile
     */
    public Tile getTile(Coordinate c){
    
    Set<Coordinate> keys=mapTiles.keySet();
    
        for(Coordinate k:keys){
        
        if(k.isEqualTo(c) == true){
            return mapTiles.get(k);
        }
        else{
           continue;
         }
        }
      
    
      return null;
    }
   /**
    * Method used to determine the number of tiles with the specified figure type
    * @param figureClass The name of the type of figure
    * @return The number of tiles with the type of figure specified
    */
   public int totalNumberFiguresClass(String figureClass){
       int p=0;
       Set<Coordinate> keys=mapTiles.keySet();
        for(Coordinate k:keys){
            
          if(mapTiles.get(k).figure == null){
              continue;
          }
          else if(figureClass.equals(mapTiles.get(k).figure.getClass().getSimpleName()) == true){
              p=p+1;
          }
         
          else{
              p=p;
          }
        }
        return p;
   }

    /**
     * Method used to know the types of the figures in the tiles of the mosaic
     * @return The names of the figures in the tiles of the mosaic
     */
    public LinkedList<String> listFigureClasses(){
        LinkedList<String> pepe = new LinkedList<String>();
        Set<Coordinate> keys=mapTiles.keySet();
        for(Coordinate k:keys){
             
          if(mapTiles.get(k).figure == null){
              continue;
          }
          else if(pepe.contains(mapTiles.get(k).figure.getClass().getSimpleName()) == false){
              pepe.add(mapTiles.get(k).figure.getClass().getSimpleName());
              continue;
          }
          else{
              continue;
          }

        }
        return pepe;
    }
    /**
     * Method used to change the luminosity of all the tiles in the mosaic
     * @param value The new value of the luminosity attribute of the tiles in the mosaic
     */
    public void changeLuminosity(int value){
        Set<Coordinate> keys = mapTiles.keySet();
        for(Coordinate k: keys){
            mapTiles.get(k).changeLuminosity(value);
        }
    }

    public void changeStateM(int value){
        Set<Coordinate> keys = mapTiles.keySet();
        for(Coordinate k: keys){
            mapTiles.get(k).changeStateT(value);
        }
    }
    
   
/**
 * Inner class of the mosaic to create Rectangular regions of tiles inside of the mosaic
 * @author Carlos and Ruben
 */
public class RectangularRegion implements Luminosity{//inner class

public String name;
public Coordinate origin;
private int h;
private int w;
public ArrayList<Coordinate> coordinates;

/**
 * Contructor that creates a new Rectangular region
 * @param m The mosaic where the region belongs to
 * @param name The name of the region
 * @param r0 The row of the origin tile
 * @param c0 The column of the origin tile
 * @param h The height of the region
 * @param w The width of the region
 */
RectangularRegion(Mosaic m, String name, int r0, int c0, int h, int w){


if(name.length() > 30){
    this.name=name.substring(0,30);
}
else{
    this.name=name;
}

//ver como hacer si nos dan puntos fuera del mosaico

origin = new Coordinate(r0,c0);

if((m.rowsMosaic - r0 + 1) >= h){
this.h=h;
}
else{
this.h=(m.rowsMosaic - r0 + 1);
}
if((m.columnsMosaic - c0 + 1) >= w){
this.w=w;
}
else{
this.w=(m.columnsMosaic - c0 + 1);
}

coordinates = new ArrayList<Coordinate>(this.h*this.w);
for(int i = r0; i <= (r0+(this.h-1)); i++){
    for(int j = c0; j <= (c0+(this.w-1)); j++){
        coordinates.add(new Coordinate(i,j));
    }
}

}//end of constructor

/**
 * Method used to change the luminosity of all the tiles in a region
 * @param value The new value of the luminosity attribute of the tiles in the region
 */
public void changeLuminosity(int value){
    Set<Coordinate> keys = mapTiles.keySet();
    for(int i = origin.getRow(); i<=(this.h + origin.getRow() - 1); i++){
     for(int j = origin.getColumn(); j<=(this.w + origin.getColumn() - 1); j++){
        for(Coordinate k: keys){
            if(k.isEqualTo(new Coordinate(i,j))){
                mapTiles.get(k).changeLuminosity(value);
            }
        }
     }
    }
    
}

public void changeStateR(int value){
    Set<Coordinate> keys = mapTiles.keySet();
    for(int i = origin.getRow(); i<=(this.h + origin.getRow() - 1); i++){
     for(int j = origin.getColumn(); j<=(this.w + origin.getColumn() - 1); j++){
        for(Coordinate k: keys){
            if(k.isEqualTo(new Coordinate(i,j))){
                mapTiles.get(k).changeStateT(value);
            }
        }
     }
    }
    
}

/**
 * Method that returns the number of tiles in the region
 * @return The number of tiles in the region
 */
public int getArea(){
    return (h*w);
}

/**
 * Method that returns a list with the coordinates of the tiles inside the region
 * @return A list with the coordinates of the region
 */
public Collection<Coordinate> getCoordinates(){
    return coordinates;
}
/**
 * Method used to create a string with the data of the region 
 * @return The string with the region's data
 */
public String toString(){
    String a;
    a= name + ":(" + this.origin.getRow() + "," + this.origin.getColumn() + ")," + this.h + "-" + this.w + ":" + this.coordinates;
    return a;
}
/**
 * Method to shuffle the coordinates of the region
 */
public void shuffle(){
    Collections.shuffle(this.coordinates);
    return;
}
/**
 * Method to sort the coordinates of the region
 */
public void sortByCoordinateAsc(){
    Collections.sort(this.coordinates);
    return;
}

}//end of class rectangular region

 /**
 * Inner class of the mosaic that defines the way in which the Rectangular regions are sorted
  */
 class NameComparator implements Comparator<RectangularRegion>{//inner class


  @Override 
   /**
   * Method that creates a way to order regions from the ones of smaller area to the ones with bigger area and, in case of a draw, depending on their names
   * @param o1 One of the regions to be compared
   * @param o2 One of the regions to be compared
   * @return A number that determines the order of the two regions passed as parameters
   */
    public int compare(RectangularRegion o1, RectangularRegion o2){
    if(o1.getArea()<o2.getArea()){
        return -1;
    }
    
    else if(o1.getArea()>o2.getArea()){
        return 1;
    }

    else{
        return o1.name.compareTo(o2.name);
    }
  }
}//namecomparator

  /*class ComparatorPrueba implements Comparator<RectangularRegion>{

      @Override
      public int compare(RectangularRegion o1, RectangularRegion o2){
        if(o1.getArea()<o2.getArea()){
        return 1;
    }
    
    else if(o1.getArea()>o2.getArea()){
        return -1;
    }

    else{
        return o1.name.compareTo(o2.name);
    }
      }
  }*/


 }//class

