        ////////////////////////////////////////////////////
        //                                                //
        //  For her who keeps the fire kindling in me...  //
        //                                                //
        ////////////////////////////////////////////////////


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
// import java.util.Scanner;
// import java.util.Arrays;
// import java.util.ArrayList;
// import java.util.Collections; 
// import java.util.StringTokenizer;
import java.util.*;
import java.lang.Math;
import java.awt.Point;                            

import java.awt.geom.*;

public class Solution{

    static class Pair{
        int x;
        int y;
        int index;

        public Pair(int x, int y, int index){
            this.x = x;
            this.y = y;
            this.index = index;
        }

    }




    static class DisjointUnionSets { 
        int[] rank, parent, ele_count; 
        int n; 
        
        // Constructor 
        public DisjointUnionSets(int n) 
        { 
            rank = new int[n]; 
            parent = new int[n];
            ele_count = new int[n];
            this.n = n; 
            makeSet(); 
        } 
        
        // Creates n sets with single item in each 
        void makeSet() 
        { 
            for (int i = 0; i < n; i++) { 
                // Initially, all elements are in 
                // their own set. 
                parent[i] = i; 
                ele_count[i] = 1;
            } 
        } 
        
        // Returns representative of x's set 
        int find(int x) 
        { 
            // Finds the representative of the set 
            // that x is an element of 
            if (parent[x] != x) { 
                // if x is not the parent of itself 
                // Then x is not the representative of 
                // his set,

                parent[x] = find(parent[x]); 
                
                // so we recursively call Find on its parent 
                // and move i's node directly under the 
                // representative of this set 
            } 
        
            return parent[x]; 
        }



        int setSize(int x){
            int par = find(x);
            return ele_count[par];
        }
        


        // Unites the set that includes x and the set 
        // that includes x 
        void union(int x, int y) 
        { 
            // Find representatives of two sets 
            int xRoot = find(x), yRoot = find(y); 
        
            // Elements are in the same set, no need 
            // to unite anything. 
            if (xRoot == yRoot) 
                return; 
        
            // If x's rank is less than y's rank 
            if (rank[xRoot] < rank[yRoot]){ 
        
                // Then move x under y  so that depth 
                // of tree remains less 
                parent[xRoot] = yRoot;
            
                ele_count[yRoot] = ele_count[yRoot] + ele_count[xRoot];
        
            // Else if y's rank is less than x's rank 
            }else if (rank[yRoot] < rank[xRoot]) {
        
                // Then move y under x so that depth of 
                // tree remains less 
                parent[yRoot] = xRoot; 
                ele_count[xRoot] = ele_count[yRoot] + ele_count[xRoot];
            
            } else // if ranks are the same 
            { 
                // Then move y under x (doesn't matter 
                // which one goes where) 
                parent[yRoot] = xRoot; 
        
                ele_count[xRoot] = ele_count[yRoot] + ele_count[xRoot];

                // And increment the result tree's 
                // rank by 1 
                rank[xRoot] = rank[xRoot] + 1; 
            } 
        } 
    } 


    static long power(long x, long y, long p) 
    { 
        // Initialize result 
        long res = 1l;      
        
        // Update x if it is more   
        // than or equal to p 
        x = x % p;  
    
        while (y > 0) 
        { 
            // If y is odd, multiply x 
            // with result 
            if((y & 1)==1) 
                res = (res * x) % p; 
    
            // y must be even now 
            // y = y / 2 
            y = y >> 1;  
            x = (x * x) % p;  
        } 
        return res; 
    } 



static int countGreater(int arr[], int n, int k) 
{ 
int l = 0; 
int r = n - 1; 

// Stores the index of the left most element 
// from the array which is greater than k 
int leftGreater = n; 

// Finds number of elements greater than k 
while (l <= r) { 
    int m = l + (r - l) / 2; 

    // If mid element is greater than 
    // k update leftGreater and r 
    if (arr[m] > k) { 
        leftGreater = m; 
        r = m - 1; 
    } 

    // If mid element is less than 
    // or equal to k update l 
    else
        l = m + 1; 
} 

// Return the count of elements greater than k 
return (n - leftGreater); 
} 



static int countLessEqual(int arr[], int n, int k) 
{ 
int l = 0; 
int r = n - 1; 

// Stores the index of the left most element 
// from the array which is greater than k 
int leftGreater = n; 

// Finds number of elements greater than k 
while (l <= r) { 
    int m = l + (r - l) / 2; 

    // If mid element is greater than 
    // k update leftGreater and r 
    if (arr[m] > k) { 
        leftGreater = m; 
        r = m - 1; 
    } 

    // If mid element is less than 
    // or equal to k update l 
    else
        l = m + 1; 
} 

// Return the count of elements greater than k 
return (leftGreater); 
} 


static class CompClass implements Comparator<Pair> { 
  
    @Override
    public int compare(Pair p1, Pair p2) { 
        
        if(p1.y > p2.y)
            return 1;
        if(p1.y < p2.y)
            return -1;
        return 0;

    } 
} 


    public static void main(String args[]){
        try{
            FastReader s = new FastReader();
            BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
            int i, q, j, k, x, y, t, n, ind, count, diff, key, l, r, b, size, rowc, colc, cf, jf, prev, max, sec_max, minglob, minloc, beg, end, begl, endr, ld, up, down, maxele, minele, case_count;
            long ans, sqrt, sum, maxup, maxdown, m, X, Y, Q, MOD;//, sum2;
            boolean flag, flag2;

            char arr[];

            t = s.nextInt();

            case_count = 0;

            for(; t>0; t--){

                n = s.nextInt();

                ArrayList<Pair> lst = new ArrayList<Pair>();

                for(i=0; i<n; i++){
                    x = s.nextInt();
                    y = s.nextInt();
                    lst.add(new Pair(x, y, i));
                }

                Collections.sort(lst, new CompClass());


                arr = new char[n];
                cf = 0;     jf = 0;


                flag = false;
                for(i=0; i<n; i++){
                   
                    x = lst.get(i).x;
                    y = lst.get(i).y;

                    if(x >= cf){
                        arr[lst.get(i).index] = 'C';
                        cf = y;
                    }else if(x >= jf){
                        arr[lst.get(i).index] = 'J';
                        jf = y;
                    }else{
                        flag = true;
                        break;
                    }
                }



           
                w.write("Case #" + (++case_count)+": ");

                if(flag == true)
                    w.write("IMPOSSIBLE");
                else
                    w.write(new String(arr));

                w.write("\n");
             
            }
            w.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
                
                
//========================================### FAST IO ###=========================================//
class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() 
    { 
        br = new BufferedReader(new
                    InputStreamReader(System.in)); 
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    Double nextDouble() 
    { 
        return Double.parseDouble(next());
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str;
    } 
}
    //====================================================================================================//
