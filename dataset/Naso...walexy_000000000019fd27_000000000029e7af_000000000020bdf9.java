
import java.util.Scanner;
import java.io.*;

public class Solution {
     static Scanner good = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      static int [] start;
       static boolean [] check;
      static int c_start, c_finish, j_start, j_finish;
    public static void main(String[] args) {
        int test = Integer.parseInt(good.nextLine());
        int test_send = test;
        while(test > 0){
        
        int task = Integer.parseInt(good.nextLine());
        check = new boolean[task];
        start = new int [task];
        int [] finish = new int [task];
        String [] combination = new String [task];
         
        for(int counter =0; counter< task; counter++){
             String time_input = good.nextLine();
             String [] token = time_input.split(" ");
             start[counter] = Integer.parseInt(token[0]);
             finish[counter] = Integer.parseInt(token[1]);
         }
        c_start = 0; c_finish = 0;
        j_start = 0; j_finish = 0;
        
        int index = Find_smallest();
        c_start = start[index];
         c_finish = finish[index];
         combination[index] = "C";
         
         while(index != -1){
             index = Find_smallest();
             if (index != -1){
             int next_start = start[index];
             int next_finish = finish[index];
             
             if(next_start >= c_finish){
                 c_start = next_start;
                 c_finish = next_finish;
                 combination[index] = "C";
                 
             }else if(next_start < c_finish){
                 if(next_start >= j_finish){
                 j_start = next_start;
                 j_finish = next_finish;
                 combination[index] = "J";
   
                 }else if(next_start < j_finish){
                    System.out.println("Case #"+ (test_send - test + 1) +": " + "IMPOSSIBLE");
                     break;
                 }
             }
         }
             if(index == -1){
             String output = "";
            for (String combination1 : combination) {
                output = output.concat(combination1);
            }
            System.out.println("Case #"+ (test_send - test + 1) +": " + output);
         }
         }
         test--;
    }
    }
    
    
    static int Find_smallest(){
        int smallest = Integer.MAX_VALUE;
        int index = -1;
        for(int count = 0; count < check.length; count++){
            if(!check[count] && smallest > start[count]){
                smallest = start[count];
                     index = count;
                }
            }
        if(index != -1){
        check[index] = true;
        }
        return index;
    }
}
