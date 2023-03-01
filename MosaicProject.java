package Project;

import java.util.*;
import java.lang.*;
import java.io.*; //con esto incluyes todo lo que hay en io


public class MosaicProject {

        public static void main(String[] args){
         
        




          Mosaic mosaic = null;
          Scanner input= null;
          String modo;
        
     try{

       input = new Scanner( new FileInputStream ("Project/" + args[0]));
       
     }
      catch(FileNotFoundException e){
       System.out.println("File does not exist");
       System.exit(-1);
     }
          
     String line = null;
   
     while (input.hasNextLine()){
     line=input.nextLine();
     modo=line.substring(0,line.indexOf(" "));
     
     switch(modo){

          case ("ReadMosaic"): //faltan exceptions
           
            String file=null;
            file=line.substring(line.indexOf(" ") + 1, line.length());//en la substring el primer elemento lo coge y el segundo no
            try{
              mosaic= new Mosaic("Project/" + file);//poner?
            }
            catch(TileOutOfBoundsException m){
             System.out.println("Coordinate of tile out of bounder");
             try{
             PrintWriter error3 = null;
             error3 = new PrintWriter (new FileOutputStream("Project/error.txt"));
             error3 = new PrintWriter (new FileOutputStream("Project/error.txt",true));
             error3.println(m.getMessage());
             error3.close();
             System.exit(-1);
             }
             catch(FileNotFoundException l){
              System.out.println("Error file could not be opened");
              System.exit(-1);
             }
            }
            System.out.println(mosaic.listFigureClasses());
            System.out.println(mosaic.totalNumberFiguresClass("Circle"));
            System.out.println(mosaic.totalNumberFiguresClass("Rectangle"));
            System.out.println(mosaic.totalNumberFiguresClass("Triangle"));
            break;


          case ("CreateRegion"):
            String name;
            int originR;
            int originC;
            int wi;
            int he;
            String temp;
            String array [] = new String[4];
            
            name=line.substring(line.indexOf(" ") + 1, line.indexOf(","));
            temp=line.substring(line.indexOf(",") + 1,line.length());
            array=temp.split(",");//dividimos la string de los datos temp por cada coma es una string, se guarda por orden automaticamente
            originR=Integer.parseInt(array[0]);
            originC=Integer.parseInt(array[1]);
            he=Integer.parseInt(array[2]);
            wi=Integer.parseInt(array[3]);
            
            mosaic.addRegion(mosaic.new RectangularRegion(mosaic,name,originR,originC,he,wi));//mosaic.new porque rectangularregion es inner class de mosaic
            break;


          case ("SortRegionsByArea"):
            String file2=null;
            file2=line.substring(line.indexOf(" ") + 1, line.length());
            PrintWriter output = null;
    
            try{
             output = new PrintWriter (new FileOutputStream("Project/" + file2));
             output = new PrintWriter (new FileOutputStream("Project/" + file2,true));
             mosaic.sortRegionsByAreaAsc();
             output.println(mosaic.toStringRegions());//revisar /n
             output.println("\n");
             //mosaic.sortRegionsByAreaDes();
             output.println(mosaic.toStringRegions());
             output.close();
        
          }
             catch(FileNotFoundException e){
             System.out.println("File open error");

             try{//para printear el error

             PrintWriter error = null;
             error = new PrintWriter (new FileOutputStream("Project/error.txt"));
             error = new PrintWriter (new FileOutputStream("Project/error.txt",true));
             error.println("FileNotFoundException");
             error.close();
             System.exit(-1);
             }

             catch(FileNotFoundException q){

              System.out.println("Error file could not be opened");
              System.exit(-1);
             }
             
             
          }
             
             break;

          case ("ChangeLuminosityMosaic"):
            String temp2;
            int lum;
            temp2=line.substring(line.indexOf(" ") + 1, line.length());
            lum=Integer.parseInt(temp2);
            mosaic.changeLuminosity(lum);
            break;
          

          case ("ChangeLuminosityRegion"):
            String temp3;
            int lum2;
            temp3=line.substring(line.indexOf(" ") + 1, line.indexOf(","));
            lum2=Integer.parseInt(temp3);
            temp3=line.substring(line.indexOf(",") + 1,line.length());
            mosaic.getRegion(temp3).changeLuminosity(lum2);
            break;


          case ("ChangeLuminosityTile"):
            String temp4;
            String array2 [] = new String[3];
            int lum3,a,b;
            temp4=line.substring(line.indexOf(" ") + 1, line.length());
            array2=temp4.split(",");
            lum3=Integer.parseInt(array2[0]);
            a=Integer.parseInt(array2[1]);
            b=Integer.parseInt(array2[2]);
            mosaic.getTile(new Coordinate(a,b)).changeLuminosity(lum3);
            break;


          case ("ChangeStatusMosaic"):
            String temp5;
            int st;
            temp5=line.substring(line.indexOf(" ") + 1, line.length());
            st=Integer.parseInt(temp5);
            mosaic.changeStateM(st);
            break;


          case ("ChangeStatusRegion"):
            String temp6;
            int st2;
            temp6=line.substring(line.indexOf(" ") + 1, line.indexOf(","));
            st2=Integer.parseInt(temp6);
            temp6=line.substring(line.indexOf(",") + 1,line.length());
            mosaic.getRegion(temp6).changeStateR(st2);


          break;



          case ("ChangeStatusTile"):
            String temp7;
            String array3 [] = new String[3];
            int st3,c,d;
            temp7=line.substring(line.indexOf(" ") + 1, line.length());
            array3=temp7.split(",");
            st3=Integer.parseInt(array3[0]);
            c=Integer.parseInt(array3[1]);
            d=Integer.parseInt(array3[2]);
            mosaic.getTile(new Coordinate(c,d)).changeStateT(st3);
            break;


          case ("SaveMosaic"):
          
          String file3=null;
          file3=line.substring(line.indexOf(" ") + 1, line.length());
          mosaic.saveToFile("Project/" + file3);
          
          
          break;



        }//switch    
     




     }//esto es el while
        }
  }

        

