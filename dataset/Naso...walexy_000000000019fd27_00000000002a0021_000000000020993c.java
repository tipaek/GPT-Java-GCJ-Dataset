
import java.util.Scanner;
import java.io.*;

public class Solution{
    static boolean check_boo = false;
    static int cycle = 0;
    static int row_dup = 0; 
     static int col_dup = 0; 
      static int total = 0; 
     static String next_line = new String(" ");
    static Scanner good = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
     public static void main(String[] args) {
         int test = Integer.parseInt(good.nextLine());
         int test_send = test;
         
         while(test > 0){
          cycle = Integer.parseInt(good.nextLine());
          int [][] block = new int [cycle][cycle];
        int [] check_row = new int [cycle + 1];
        int [] check_col = new int [cycle+1];
          
         //Get_array
         int cycle2 = 0;
         for(int count = 0; count < cycle; count++){
              next_line = good.nextLine();
              String [] tokens = next_line.split(" ");
                for(int counter = 0; counter < tokens.length; counter++){
                    block[cycle2][counter] = Integer.parseInt(tokens[counter]);
                }
                cycle2= cycle2 + 1;
         }
       //  good.close();
        //Prompt
         
       // Get_array(block);
        Circulate(block,check_row, check_col);
        
        Result(test_send - test + 1);
        test--;
         }
    }
     
     static void Circulate(int [][] block, int [] check_row, int [] check_col){
             /////Checking each row
             for(int row = 0; row < cycle; row++){
                  for(int col = 0; col < cycle; col++){
                     int num = block[row][col];
                     if(num >0 && num <= cycle){
                         check_row[num]++;
                     }
                     if(row == col){
                         total = total + num;
                     }
                     if(col == cycle-1){
                         for (int counter = 1; counter< check_row.length; counter++){
                             if(check_row[counter] > 1){
                                 check_boo = true;
                             }
                         }}
                 }
                 if (check_boo){
                     check_boo = false;
                     row_dup++;
                 }
                 check_row = new int [cycle + 1];
             }
             
             
            //////Checking each column
               for(int col = 0; col < cycle; col++){
                  for(int row = 0; row < cycle; row++){
                     int num = block[row][col];
                     if(num >0 && num <= cycle){
                         check_col[num]++;
                     }
                     if(row == cycle-1)
                         for (int counter = 1; counter<check_col.length; counter++){
                             if(check_col[counter] > 1){
                                 check_boo = true;
                             }
                         }
                 }
                 if (check_boo){
                     check_boo = false;
                     col_dup++;
                 }
                  check_col = new int [cycle + 1];
             }  
              
     }
    
     static void Result(int test){
         
         System.out.println("Case #"+ test+": " +total + " "+ row_dup + " " + col_dup); 
          row_dup = 0; col_dup = 0; total = 0;
     }
}
