import java.util.*;
import java.io.*;
public class Solution{
public static void main (String[]args){
    Scanner scan = new Scanner(System.in); 
    int tests=Integer.parseInt(scan.nextLine());
    for(int i=0;i<tests;i++){
        int size=Integer.parseInt(scan.nextLine());
        int [][] matrix=new int[size][size];
        int repeatrows=0;
        int trace=0;
        int repeatcols=0;
        for(int j=0;j<size;j++){
            for(int k=0;k<size;k++){
                matrix[j][k]=Integer.parseInt(scan.next());
            }
            scan.nextLine();
        }
        for(int j=0;j<size;j++){
            trace+=matrix[j][j];
        }
        
        for(int j=0;j<size;j++){
            HashSet<Integer> map=new HashSet<Integer>();
            for(int k=0;k<size;k++){
                if(map.contains(matrix[j][k])){
                    repeatrows++;
                    break;
                }
                map.add(matrix[j][k]);
            }
        }
         for(int j=0;j<size;j++){
            HashSet<Integer> map=new HashSet<Integer>();
            for(int k=0;k<size;k++){
                if(map.contains(matrix[k][j])){
                    repeatcols++;
                    break;
                }
                map.add(matrix[k][j]);
            }
        }
        int curcase=i+1;
        System.out.println("Case #"+curcase+": "+trace+" "+repeatrows+" "+repeatcols);
    }
}
}
