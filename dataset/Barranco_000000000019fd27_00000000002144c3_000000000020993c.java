import java.util.*;
import java.io.*;

class Solution {

public static void main(String args[]){
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
    int cases = sc.nextInt();
    int cnumber = 1;
    while(cnumber<=cases){
        
        int size = sc.nextInt();
        int repeati = 0;
        int repeatj = 0;
        int diagonal = 0;
        Integer[][]mat = new Integer[size][size];
        
        for(int i=0; i<size; i++){
            Set<Integer> si = new HashSet<>();
            for(int j= 0; j<size; j++){
               int number = sc.nextInt();
                mat[i][j] = number;
                si.add(number);
                if (i==j)diagonal += number;
            }
            if(si.size()!=size)repeati++;
        
        }
        
        for(int j = 0; j<size; j++){
             Set<Integer> sj = new HashSet<>();
            for(int i = 0; i<size; i++){
                int number = mat[i][j];
                sj.add(number);
            }
            if(sj.size()!=size)repeatj++;
        }
        
        
        System.out.println("Case #"+cnumber+": "+ diagonal 
        + " " + repeati + " " + repeatj);
        
        cnumber++;
    }
    sc.close();
    System.exit(0);
}
}
