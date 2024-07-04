

import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));    
    int t = in.nextInt(); //number of tests
    for (int i = 1; i <= t; ++i) {
        int xCor = in.nextInt(); 
        int yCor = in.nextInt(); 
        if((xCor + yCor) % 2 == 0){
            System.out.println("Case #" + i +": IMPOSSIBLE");
        }
        else{
            int x=xCor;
            int y=yCor;
            boolean xReflect = false;
            boolean yReflect = false;
            if(xCor < 0){
                x = -1* xCor;
                yReflect = true;
            }
            if(yCor < 0){
                y = -1* yCor;
                xReflect = true;
            }
            int jumps=0;
            while((x+y) >= Math.pow(2,jumps)){
                jumps++;
            }
            String path = "";
            String vert = "N";
            String hor = "E";
            for(int j = jumps; j >0; j--){
                if(y > x){ //last jump was in n
                    y = y - (int) Math.pow(2, j-1);
                    path = vert+path;
                    if(y < 0){
                       y = -1*y;
                       vert = "S";
                    }else{
                        vert = "N";
                    }
                }
                else{
                     x = x - (int)Math.pow(2, j-1);
                    path = hor+path;
                    if(x < 0){
                       x = -1*x;
                       hor = "W";
                    }else{
                        hor = "E";
                    }
                }
            }
            if(yReflect){
                //change E and W
                for(int ind = 0; ind< path.length()-1; ind++){
                    if(path.charAt(ind) == 'E'){
                        path = path.substring(0,ind) + "W"+ path.substring(ind+1);
                    } else if(path.charAt(ind) == 'W'){
                        path = path.substring(0,ind) + "E"+ path.substring(ind+1);
                    }
                }
                //change last letter
                if(path.charAt(path.length()-1) == 'E'){
                    path = path.substring(0,path.length()-1) + "W";
                } else if(path.charAt(path.length()-1) == 'W'){
                    path = path.substring(0,path.length()-1) + "E";
                }
            }
            if(xReflect){
                //change N and S
                for(int ind = 0; ind< path.length()-1; ind++){
                    if(path.charAt(ind) == 'N'){
                        path = path.substring(0,ind) + "S"+ path.substring(ind+1);
                    } else if(path.charAt(ind) == 'S'){
                        path = path.substring(0,ind) + "N"+ path.substring(ind+1);
                    }
                }
                //change last letter
                if(path.charAt(path.length()-1) == 'N'){
                    path = path.substring(0,path.length()-1) + "S";
                } else if(path.charAt(path.length()-1) == 'S'){
                    path = path.substring(0,path.length()-1) + "N";
                }
            }
            
            //System.out.println("x " + x +"y " + y);
            System.out.println("Case #" + i +": " + path);
        }
    }
  } 
}

