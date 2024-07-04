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
        //double[][] skill = new double[row][col];
        int interest = 0;
        int elim = 0;
        boolean end = false;
        double[][] avgSkill = new double[row][col];
        int left;
        int right;
        int up;
        int down;
        //set up dance floor
        for(int r = 0; r < row; r++){
            for(int c = 0; c<col; c++){
                floor[r][c] = in.nextInt();
            }
        }   
        //check for eliminations
        while(end == false){
           elim = 0;
           int neighbors = 0;
    for(int r = 0; r < row; r++){
        for(int c = 0; c<col; c++){
           avgSkill[r][c] = 0.0;
           //add neighbors (left, right, up, down)
           if(floor[r][c] != 0){
           neighbors = 0;
            left = c - 1;
           while(left >= 0){
                 if(floor[r][left]==0){
                     left--;
                 }else{
                    avgSkill[r][c]+= floor[r][left];
                    neighbors++;
                    left = -1;
                 }
           }
            right = c +1;
           while(right < col){
                 if(floor[r][right]==0){
                     right++;
                 }else{
                    avgSkill[r][c]+= floor[r][right];
                    neighbors++;
                    right = col;
                 }
           }
             up = r - 1;
           while(up >= 0){
                 if(floor[up][c]==0){
                     up--;
                 }else{
                    avgSkill[r][c]+= floor[up][c];
                    neighbors++;
                    up = -1;
                 }
           }
            down = r +1;
           while(down < row){
                 if(floor[down][c]==0){
                     down++;
                 }else{
                    avgSkill[r][c]+= floor[down][c];
                    neighbors++;
                    down = row;
                 }
           }
           if(neighbors > 0)
            avgSkill[r][c] = avgSkill[r][c]/neighbors;
        }
        else{
            avgSkill[r][c] = 0.0;
        }
        }
    } 
           //
           for(int r = 0; r < row; r++){
            for(int c = 0; c<col; c++){
                interest+=floor[r][c];
                if(floor[r][c]>0&&(floor[r][c] < avgSkill[r][c])){
                    floor[r][c] = 0;
                    elim++; 
                }
            }
        }
        if(elim ==0){
            end = true;
        }   
        }
        System.out.println("Case #" + i +": " + interest);
    }
  } 
}