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
class prog_1_Vestigium {
    public static void main(String []ar)throws Exception{
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(reader.nextLine());
        int i = 0; 
        while(i < t){
            int n = Integer.parseInt(reader.nextLine());
            int num[][] = new int[n][n];
            int d=0,r=0,c=0;
            Set<Integer> rows[] = new HashSet[n];
            Set<Integer> cols[] = new HashSet[n];
            for (int p = 0; p < rows.length; p++) {
                rows[p] = new HashSet<>();
                cols[p] = new HashSet<>();
            }
            for(int j=0; j<n; j++){
                String temp[] = reader.nextLine().split(" ");
                for(int k=0; k<n; k++){
                    num[j][k] = Integer.parseInt(temp[k]);
                    if(k == j){
                        d = d + num[j][k];
                    }
                    ((HashSet<Integer>)cols[k]).add(num[j][k]);
                    ((HashSet<Integer>)rows[j]).add(num[j][k]);
                }
            }
            
            for(int j=0; j<n; j++){
                if(rows[j].size() != n){
                    r=r+1;
                }
                if(cols[j].size() != n){
                    c=c+1;
                }
            }
            System.out.println("Case #" + i+1 + ": " + d +" " + r + " " + c);
            i++;
        }
    }
    
}
