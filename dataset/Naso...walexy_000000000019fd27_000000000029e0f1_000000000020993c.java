
package google2;
import java.util.Scanner;
public class Solution{
static Scanner good = new Scanner(System.in);
static int Case=0;
    public static void main(String[] args) {
        Prompt();
    }
   private static void Prompt(){
       String P ;
        int T = good.nextInt();
       
        for (int counter = 0; counter < T; counter++){
             Case = counter;
            int n = good.nextInt();
            P = good.next();
            Check_length_of_string(n,P);
        }
    }
   private static void Check_length_of_string(int n, String s){
       int check = (2*n) - 2;
       if (s.length() == check){
           Convert_to_char(n,s);
       }
   }
   private static void Convert_to_char(int n, String s){
       char [] c = s.toCharArray();
       int s_count = 0;
       int e_count = 0;
       for(char take : c){
           if (take == 'E'){
               e_count++;
           }
           if (take == 'S'){
               s_count++;
           }
       }
       if ( (s_count == n-1) & (e_count == n-1)){
           Set_new_path(c);
       }
   }
   private static void Set_new_path(char [] c){
       char [] c_inv = new char [c.length];
       for(int counter = 0; counter < c.length; counter++){
           if (c[counter] == 'E'){
               c_inv[counter] = 'S';
           }
           if (c[counter] == 'S'){
               c_inv[counter] = 'E';
           }
       }
       Display_result(c_inv);
   }
   private static void Display_result(char [] c){
       
      StringBuilder buffer = new StringBuilder();
       for (int counter = (c.length-1); counter >= 0; counter--){
           buffer.insert(0, c[counter]);
       }
       System.out.printf("Case #%d: %s\n", (Case+1), buffer.toString());
   }
}
