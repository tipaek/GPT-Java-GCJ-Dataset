import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String args[]){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int N=0,T=0;
            T = sc.nextInt();
            int M[][][] = new int[T][][]; 
            for(int k=0;k<T;k++){
                N = sc.nextInt();
                M[k] =new int[N][N];
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                     M[k][i][j] = sc.nextInt();
                    }
                }
            }
            int[][] result = new int[T][3];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int k=0;k<T;k++){
        int rowCount=0,columnCount=0,trace=0;
        for(int i=0;i<M[k].length;i++){
            trace+=M[k][i][i];
            for(int j=0;j<M[k][i].length;j++){
                if(map.containsKey(M[k][i][j])){
                    rowCount++;
                    break;
                }
                else{
                    map.put(M[k][i][j],0);
                }
            }
            map.clear();
        }
        map.clear();
        for(int i=0;i<M[k].length;i++){
            for(int j=0;j<M[k][i].length;j++){
                if(map.containsKey(M[k][j][i])){
                    columnCount++;
                    break;
                }
                else{
                    map.put(M[k][j][i],0);
                }
            }
            map.clear();
        }
        result[k][0] = trace;
        result[k][1] = rowCount;
        result[k][2] = columnCount;
        map.clear();
        }
    for(int i=0;i<T;i++){
             System.out.println("case #"+ (i+1) +": "+result[i][0]+" "+result[i][1]+" "+result[i][2]);
    }
    }
}