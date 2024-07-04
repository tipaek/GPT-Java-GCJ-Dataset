import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner; 
import java.util.Arrays;
 class Solution{
public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
     int times = scan.nextInt();
     int x = 1;
     while (times>0){
         int size =  scan.nextInt();
         int matrix[][] = new int[size][size];
         for(int i = 0; i<size;i++){
            for(int j = 0; j<size; j++){
                matrix[i][j] = scan.nextInt();
            }
         }
         int diagnal = 0;
         for(int i = 0; i <size; i++){
             diagnal = matrix[i][i]+diagnal;
         }
         int rowcount = 0;
         for(int i = 0; i <size; i++){
             Set<integer> set1 = new HashSet<>(Arrays.asList(matrix[i]));
             if(set1.size()!= size){
                rowcount++;
             }
         }
         int columncount = 0;
         for(int i = 0; i <size; i++){
             int [] column = new int[size];
             for(int j = 0; j <size; j++){
                 column[j]= matrix[j][i];
                
             }
             Set<integer> set2 = new HashSet<>(Arrays.asList(column));
             if (set2.size()!= size){
                columncount++;
             }
         }
         System.out.println("Case #"+x+": "+diagnal+" "+rowcount+" "+columncount);
         x++;
         times--;
     }
     return;
}
}