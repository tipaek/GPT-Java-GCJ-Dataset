import java.io.*;
import java.util.*;
import java.lang.*;

public class CodeJam1A{

    public static List<List<Long>> arrList;
    public static List<List<Integer>> ans;

    public static void printPascal(int n) 
    { 
        for(int line = 1; line <= n; line++) 
        { 
            
        long C=1;// used to represent C(line, i) 
        List<Long> list = new ArrayList<>();
        for(int i = 1; i <= line; i++) 
        {  
            // The first value in a line is always 1 
            list.add(C);
            C = C * (line - i) / i;  
        } 
        arrList.add(list);
        } 
    }

    public static boolean traverse(long N, long sum, int moves, int r, int k, boolean[][] arr){
        if(r<0) return false;
        if(k>r) return false;
        arr[r][k] = true;
        sum += arrList.get(r).get(k);
        if(sum>N) return true;
        if(sum==N){
            List<Integer> e = new ArrayList<>();
            e.add(r+1);
            e.add(k+1);
            ans.add(e);
            return true;
        }
        if(moves+1>500 && sum!=N) return false;
        boolean a1, a2, a3, a4, a5, a6;
        a1 = a2 = a3 = a4 = a5 = a6 = false;
        if(r-1>=0 && k-1<=r-1 && k-1>=0){
            if(arr[r-1][k-1]!=true) a1 = traverse(N, sum, moves+1, r-1, k-1, arr);
        }
        if(r-1>=0 && k<=r-1 && k>=0){
            if(arr[r-1][k]!=true) a2 = traverse(N, sum, moves+1, r-1, k, arr);
        }
        if(r>=0 && k-1<=r && k-1>=0){
            if(arr[r][k-1]!=true) a2 = traverse(N, sum, moves+1, r, k-1, arr);
        }
        if(r>=0 && k+1<=r && k+1>=0){
            if(arr[r][k+1]!=true) a2 = traverse(N, sum, moves+1, r, k+1, arr);
        }
        if(r+1>=0 && k<=r+1 && k>=0){
            if(arr[r+1][k]!=true) a2 = traverse(N, sum, moves+1, r+1, k, arr);
        }
        if(r+1>=0 && k+1<=r+1 && k+1>=0){
            if(arr[r+1][k+1]!=true) a2 = traverse(N, sum, moves+1, r+1, k+1, arr);
        }
        if(!a1 && !a2 && !a3 && !a4 && !a5 && !a6) return false;
        List<Integer> e = new ArrayList<>();
        e.add(r+1);
        e.add(k+1);
        ans.add(e);
        return true;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        arrList = new ArrayList<>();
        int max = 1000;
        printPascal(max);
        StringBuilder res = new StringBuilder("");
        for(int w=0; w<t; w++){
             long N = sc.nextLong();
             ans = new ArrayList<>();
             boolean[][] arr = new boolean[max][max];
             long sum = 0;
             traverse(N, sum, 0, 0, 0, arr);
             res.append("Case #"+(w+1)+"\n");
             for(int i=ans.size()-1; i>=0; i--){
                res.append(ans.get(i).get(0)+" "+ans.get(i).get(1)+"\n");
             }
             System.out.println(res);
        }
    }
}