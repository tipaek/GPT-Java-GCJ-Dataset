import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
   static Scanner scn= new Scanner(System.in);
    public static void main(String[] args)
    {
        int t = scn.nextInt();
        for(int count = 0 ; count < t ;count++) {
            
            int n = scn.nextInt();
           
            int[][] a = new int[n][n];
            int r=0,c=0;
            int trace = 0;
            HashMap<Integer,HashSet<Integer>> col= new HashMap<>();
            for(int i = 0 ; i < n ;i++) {
                
                HashSet<Integer> row = new HashSet<>();                
                for(int j = 0 ; j < n ; j++) {
                    
                    a[i][j] = scn.nextInt();
                    if(i==j)
                        trace+=a[i][j];
                    
                    // row
                    if(!row.contains(a[i][j]) )
                        row.add(a[i][j]);
                    else {
                        r++;
                        break;
                    } 
                    
                    // column
                    if(!col.containsKey(j)) {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(a[i][j]);
                        col.put(j,set);
                    }
                    else {
                        HashSet<Integer> set = col.get(j);
                        if(set.contains(a[i][j]))
                            c++;
                            
                        else{
                            set.add(a[i][j]);
                            col.put(j,set);
                    }
                    }
                    
                }
            }
            System.out.println("Case #"+t+": " +trace+" "+r+" "+c);
            
        }
    }
}
