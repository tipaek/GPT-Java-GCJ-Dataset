import java.util.Scanner;
import java.io.*;
import java.util.*;
public class Solution{
    static Scanner in = new Scanner(System.in);
        public static void readMatrixByUser(int[][] first,int N) 
    { 
        int i, j; 
        try {  
            for (i = 0; i < N; i++){ 
                for (j = 0; j < N; j++){ 
                    if(first[i][j]>=1 ||first[i][j]<=N){
                    first[i][j] = in.nextInt();    
                    }
                } 
            }
        } 
        catch (Exception e) { 
        } 
        finally { 
        
        } 
    }
    public static int trace(int[][] first,int N){
            int i, j, sum=0; 
            for (i = 0; i < N; i++) { 
                for (j = 0; j < N; j++) {
                    if (i==j){
                        sum+=first[i][j];
                    }
                } 
            } 
            return sum;
    }
    public static int repeatedRows(int[][] first,int N){
        int count=0;            
            for (int i = 0; i < N; i++) { 
                for (int j = 0; j <N; j++) {                
                    for(int k = j+1; k < N; k++){
                        if (first[i][j]==first[i][k] && i<N){
                        count++;
                        if(i!=N-1){
                        i++;
                        j=0;
                        k=1;
                        }
                        else{
                            j=1000;
                            k=1000;
                            i=1000;
                            break;
                        }
                                         
                        }
                        
                    }
                } 
            } 
            
            return count;
    }
    public static int repeatedColumns(int[][] first,int N){
        int count=0;

            
            for (int j = 0; j < N; j++) { 
                for (int i = 0; i <N; i++) {                
                    for(int k = i+1; k < N; k++){
                        if (first[i][j]==first[k][j] && j<N){
                        count++;
                        if(j!=N-1){
                        j++;
                        i=0;
                        k=1;
                        }
                        else{
                            i=1000;
                            k=1000;
                            j=1000;
                            break;
                        }
                                         
                        }
                        
                    }
                } 
            } 
            
            return count;
    }

    public static void main(String[] args){
        int TestCases, N, k, r ,c;
        TestCases = in.nextInt();
        if(TestCases<=100 || TestCases >= 1){
            
        
        for(int i=0; i<TestCases; i++){
            N = in.nextInt();
            if(N>=2 || N<=100){
            int second[][] = new int [N][N];
            readMatrixByUser(second,N);
            k= trace(second,N);
            r= repeatedRows(second,N);
            c= repeatedColumns(second,N);
            System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
            }
        }
        }
    }
}