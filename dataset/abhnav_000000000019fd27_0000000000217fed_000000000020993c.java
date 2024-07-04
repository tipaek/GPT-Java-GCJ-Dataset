import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
   static Scanner scn= new Scanner(System.in);
    public static void main(String[] args)
    {  int t = scn.nextInt();
        for(int count = 0 ; count < t ;count++) {
            
            int n = scn.nextInt();
           
            final int[][] a = new int[n][n];
            int r=0,c=0;
            int trace = 0;
            HashSet<Integer> flags = new HashSet<>();
            HashMap<Integer,HashSet<Integer>> col= new HashMap<>();
            for(int i = 0 ; i < n ;i++) {
                boolean flag = false;
                HashSet<Integer> row = new HashSet<>();                
                for(int j = 0 ; j < n ; j++) {
                    
                    
                    a[i][j] = scn.nextInt();
                    if(i==j) {
                    	trace+=a[i][j];
                    }
                    
                    // row
                    if(!row.contains(a[i][j]) )
                        row.add(a[i][j]);
                    else {
                    	if(flag==false)
                        r++;
                        flag=true;
                    } 
                    
                    // column
                    if(!col.containsKey(j)) {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(a[i][j]);
                        col.put(j,set);
//                        if(i==2 && j==0)
//                        	System.out.println("hi");
                    }
                    
                    else {
//                    	if(i==2 && j==0)
//                        	System.out.println("hi");
                        HashSet<Integer> set = col.get(j);
                        if(set.contains(a[i][j])&& !flags.contains(j))
                        {   flags.add(j);
                        	c++;
                        }
                        else{
                            set.add(a[i][j]);
                            col.put(j,set);
                    }
                    }
                    
                }
            }
            System.out.println("Case #"+(count+1)+": " +trace+" "+r+" "+c);
            
        }
    }
}
