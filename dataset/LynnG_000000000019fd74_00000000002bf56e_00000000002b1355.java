

import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));    
    int t = in.nextInt(); //number of tests
    for (int i = 1; i <= t; ++i) {
        int row = in.nextInt(); //number of rows
        int col = in.nextInt(); //number of rows
        int[][] floor = new int[row][col];
        double[][] skill = new double[row][col];
        int interest = 0;
        int elim = 0;
        boolean end = false;
        //set up dance floor
        for(int r = 0; r < row; r++){
            for(int c = 0; c<col; c++){
                floor[r][c] = in.nextInt();
            }
        }   
        //check for eliminations
        while(!end){
           elim = 0;
           skill = avgSkill(floor);
           /*for(int r = 0; r < row; r++){
            for(int c = 0; c<col; c++){
                System.out.print(skill[r][c] + " ");
            }
            System.out.println();
           }*/
           for(int r = 0; r < row; r++){
            for(int c = 0; c<col; c++){
                interest+=floor[r][c];
                if(floor[r][c]>0&&(floor[r][c] < skill[r][c])){
                    floor[r][c] = 0;
                    elim++; 
                }
            }
        }
        if(elim ==0){
            end = true;
        }   
        }
        System.out.println("Case #" + i + ": " + interest);
    }
  } 

public static double[][] avgSkill(int[][] dancers){
    double[][] avgSkill = new double[dancers.length][dancers[0].length];
    int neighbors = 0;
    for(int r = 0; r < dancers.length; r++){
        for(int c = 0; c<dancers[0].length; c++){
           //add neighbors (left, right, up, down)
           neighbors = 0;
           int left = c - 1;
           while(left >= 0){
                 if(dancers[r][left]==0){
                     left--;
                 }else{
                    avgSkill[r][c]+= dancers[r][left];
                    neighbors++;
                    left = -1;
                 }
           }
           int right = c +1;
           while(right < dancers[0].length){
                 if(dancers[r][right]==0){
                     right++;
                 }else{
                    avgSkill[r][c]+= dancers[r][right];
                    neighbors++;
                    right = dancers[0].length;
                 }
           }
            int up = r - 1;
           while(up >= 0){
                 if(dancers[up][c]==0){
                     up--;
                 }else{
                    avgSkill[r][c]+= dancers[up][c];
                    neighbors++;
                    up = -1;
                 }
           }
           int down = r +1;
           while(down < dancers.length){
                 if(dancers[down][c]==0){
                     down++;
                 }else{
                    avgSkill[r][c]+= dancers[down][c];
                    neighbors++;
                    down = dancers.length;
                 }
           }
           if(neighbors > 0)
            avgSkill[r][c] = avgSkill[r][c]/neighbors;
        }
    } 
    return avgSkill;
}
}




