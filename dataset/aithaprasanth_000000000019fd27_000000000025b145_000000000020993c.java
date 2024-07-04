import java.util.Scanner; 
import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) 
    { 
        int t; 
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        int test = 0;
        while(t!=0){
            Map<String, Set<Integer>> map = new HashMap<String, Set<Integer>>();
            int n = 0, i, j, tr = 0;
            int r,c;
            n = in.nextInt(); 
            int mat[][] = new int[n][n];
            String line = in.nextLine();
            // System.out.println("line "+line);
            for (i = 0; i < n; i++) {
                line = in.nextLine();
                // System.out.println("line "+line);
                char[] arr = line.toCharArray();
                int[] newarr = new int[n];
                for(int k=0,k1=0; k<arr.length; k=k+2,k1++){
                    int num = Integer.parseInt(String.valueOf(arr[k]));
                    newarr[k1] = num;
                    // System.out.print("k "+k+" "+newarr[k1]+" ");
                }
                for (j = 0; j < n; j++) {
                    String row = "i"+i;
                    String col = "j"+j;
                    
                    mat[i][j] = newarr[j];
                    // System.out.print(mat[i][j]+" ");
                    if(i == j){
                        tr = tr + mat[i][j]; 
                    }
                    if(map.containsKey(row)) {
                        Set<Integer> set = map.get(row);
                        set.add(mat[i][j]);
                        map.put(row,set);
                    } else {
                        Set<Integer> set = new HashSet<Integer>();
                        set.add(mat[i][j]);
                        map.put(row,set);
                    }
                    // System.out.println(row +" "+mat[i][j]);
                    
                    if(map.containsKey(col)) {
                        Set<Integer> set = map.get(col);
                        set.add(mat[i][j]);
                        map.put(col,set);
                    } else {
                        Set<Integer> set = new HashSet<Integer>();
                        set.add(mat[i][j]);
                        map.put(col,set);
                    }
                    // System.out.println(col +" "+mat[i][j]);
                }
                // System.out.println();
            }
            
            r = 0;
            for (i = 0; i < n; i++) { 
                String str = "i"+i;
                Set<Integer> set = map.get(str);
                if(set.size() != n)
                    r++;
            }
            
            c = 0;
            for (i = 0; i < n; i++) { 
                String str = "j"+i;
                Set<Integer> set = map.get(str);
                if(set.size() != n)
                    c++;
            }
            System.out.println("Case #"+test+": "+tr+" "+r+" "+c);
            test++;
            t--;
        }
    } 
}
