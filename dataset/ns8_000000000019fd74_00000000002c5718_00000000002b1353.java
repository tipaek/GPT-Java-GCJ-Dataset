import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    static boolean foundFlag = false;
    static class pair{
        int x;
        int y;
        public pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x+" "+y;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int sum = in.nextInt();
            if(sum == 1){
                System.out.println("Case #" + i + ": " + "1 1");
                continue;
            }
            List<pair> result ;
            int arr[][] = storePascal(10);
            boolean visited[][] = new boolean[10][10];
            result = getPath(arr,visited,sum,10,0,0);
            System.out.println("Case #" + i + ": " );
            for(int k=0;k<result.size();k++){
                System.out.println(result.get(k).toString());
            }

        }
    }
    private static int[][] storePascal(int n)
    {
        int arr[][] = new int[n][n];
        // Iterate through every line
        // and print entries in it
        for (int line = 0; line < n; line++)
        {
            for (int i = 0; i <= line; i++)
                arr[line][i] = binomialCoeff(line, i);
        }
        return arr;
    }

    static int binomialCoeff(int n, int k)
    {
        int res = 1;

        if (k > n - k)
            k = n - k;

        for (int i = 0; i < k; ++i)
        {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    private static List<pair> getPath(int arr[][], boolean visited[][],int sum,int n, int i, int j){
        List<pair> result = new ArrayList<>();
        if(i<0 || i>=n || j<0 || j>=n || sum <= 0 || visited[i][j] || arr[i][j]==0 || sum<arr[i][j]){
            return new ArrayList<>();
        }
//        if(sum == 0 && !visited[i][j]){
//            visited[i][j] = true;
//            result.add(new pair(i+1,j+1));
//            return result;
//        }
        result.add(new pair(i+1,j+1));
        sum -= arr[i][j];
        visited[i][j] = true;
        if(sum == 0){
            return result;
        }
        result.addAll(getPath(arr,visited,sum,n,i-1,j-1));
        result.addAll(getPath(arr,visited,sum,n,i-1,j));
        result.addAll(getPath(arr,visited,sum,n,i,j-1));
        result.addAll(getPath(arr,visited,sum,n,i,j+1));
        result.addAll(getPath(arr,visited,sum,n,i+1,j));
        result.addAll(getPath(arr,visited,sum,n,i+1,j+1));
        return result;
    }

}

