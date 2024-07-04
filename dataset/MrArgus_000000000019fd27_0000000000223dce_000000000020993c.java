import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]){
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=0;t<T;t++){
            int n = in.nextInt();
            int a[][] = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j] = in.nextInt();    
                }
            }
                System.out.println("Case #" + (t+1) + ": " + diagSum(a,n) + " " + rowRep(a,n) + " " + colRep(a,n));
        
        }
    }
    
    public static int diagSum(int a[][], int n){
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=a[i][i];
        }
        return sum;
    }
    
    public static int rowRep(int a[][], int n){
        int countRep = 0;
        for(int row=0;row<n;row++){
            Set<Integer> tSet = new TreeSet<Integer>();
            for(int i=0;i<n;i++){
                tSet.add(a[row][i]);
            }
            if(tSet.size() != n){
                countRep++;
            }
            tSet.clear();
        }
        return countRep;
    }
    
    public static int colRep(int a[][], int n){
        int countRep = 0;
        for(int col=0;col<n;col++){
            Set<Integer> tSet = new TreeSet<Integer>();
            for(int i=0;i<n;i++){
                tSet.add(a[i][col]);
            }
            if(tSet.size() != n){
                countRep++;
            }
            tSet.clear();
        }
        return countRep;
    }
}
