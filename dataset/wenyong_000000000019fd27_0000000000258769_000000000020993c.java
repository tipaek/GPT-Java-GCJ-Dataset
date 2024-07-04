import java.util.*;
import java.io.*;

public class Solution{
    public static int r;
    public static int c;

    public static void main(String[] args){
        FastIO fio = new FastIO();
        int numberofcases = fio.nextInt();
        for(int i=1; i<=numberofcases;i++){
            int k = 0;
            int r = 0;
            int c = 0;

            int matrixsize = fio.nextInt();
            int[][] mat = new int[matrixsize][matrixsize];

            
            for(int j=0; j< matrixsize; j++){
                for(int l=0; l<matrixsize; l++){
                    int key = fio.nextInt();
                    mat[j][l] = key;
                    if(j==l){
                        k+= key;
                    }
                }
            }

            r= findrows(mat, matrixsize);
            c= findrows(transposeMatrix(mat), matrixsize);

            fio.println("Case #"+i+": "+k+" "+r+" "+c);
        }
        
        fio.close();

    }

    public static int findrows(int[][] matrix, int size){
        int r = 0;
        
    
        for(int i=0; i<size; i++){
            
            boolean hasadd = false;
            HashSet<Integer> row = new HashSet<>();
    
            for(int j=0; j<size; j++){
                int input = matrix[i][j];
    
                if(row.contains(input)){
                    if(hasadd == false){
                        r++;
                        hasadd = true;
                    }
                }
                else                                    
                    row.add(input);
            }
        }
        return r;
    }

    public static int[][] transposeMatrix(int [][] m){
        int[][] temp = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }
}



class FastIO extends PrintWriter 
{ 
    BufferedReader br; 
    StringTokenizer st;

    public FastIO() 
    { 
        super(new BufferedOutputStream(System.out)); 
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

    double nextDouble() 
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

