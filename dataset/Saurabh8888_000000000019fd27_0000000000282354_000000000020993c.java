
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Saurabh
 */
public class prog_1_Vestigium {
    public static void main(String []ar)throws Exception{
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(reader.nextLine());
        int i = 0; 
        while(i < t){
            int n = Integer.parseInt(reader.nextLine());
            int num[][] = new int[n][n];
            int d=0,r=0,c=0;
            
            for(int j=0; j<n; j++){
                String temp[] = reader.nextLine().split(" ");
                for(int k=0; k<n; k++){
                    num[j][k] = Integer.parseInt(temp[k]);
                    if(k == j){
                        d = d + num[j][k];
                    }
                }
            }
            
            Set<Integer> temp = new HashSet<Integer>();
            
            for(int j = 0; j<n; j++){
                for(int k = 0; k<n; k++){
                    temp.add(num[j][k]);
                }
                if(temp.size() != n){
                    r++;
                }
                temp.clear();
                int []temparr = getcol(num,j);
                for(int k=0; k<n; k++){
                    temp.add(temparr[k]);
                }
                if(temp.size() != n){
                    c++;
                }
                temp.clear();
            }
            
            
            System.out.println("Case #" + i+1 + ": " + d +" " + r + " " + c);
            i++;
        }
    }
    
    public static int[] getcol(int[][] array, int index){
        int[] column = new int[array[0].length]; 
        for(int i=0; i<column.length; i++){
            column[i] = array[i][index];
        }
        return column;
    }
    
}
