import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.awt.*;
import java.util.List;

public class Solution {
    static int mod=(int)1e9+7;
    static ArrayList<ArrayList<Long>> arr;
    static Stack<Point> stack;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        arr=generate(500);
        int t=sc.nextInt();
        int z=1;
        while(t-->0){
            long n=sc.nextLong();
            stack=new Stack<>();
            dfs(n,0,0);
            sb.append("Case #"+z+":\n");
            while(!stack.isEmpty()){
                Point p=stack.pop();
                sb.append((p.x+1)+" "+(p.y+1)+"\n");
            }
            z++;
        }
        System.out.println(sb);
    }
    public static boolean dfs(long n,int rows,int col){
        if(rows>=300)return false;
        if(n==0){
            return true;
        }
        if(n<0)return false;
        boolean z=false;


        if(col+1<arr.get(rows).size()){
            z=dfs(n-arr.get(rows).get(col),rows,col+1);
            if(z){
                stack.push(new Point(rows,col));
                return true;
            }
        }

        if(col-1>=0){
            z=dfs(n-arr.get(rows).get(col),rows,col-1);
            if(z){
                stack.push(new Point(rows,col));
                return true;
            }
        }

        z=dfs(n-arr.get(rows).get(col),rows+1,col+1);
        if(z){
            stack.push(new Point(rows,col));
            return true;
        }

        z=dfs(n-arr.get(rows).get(col),rows+1,col);
        if(z){
            stack.push(new Point(rows,col));
            return true;
        }


        return false;
    }
    public static  ArrayList<ArrayList<Long>> generate(int numRows) {
        ArrayList<ArrayList<Long>> triangle = new ArrayList<ArrayList<Long>>();

        if (numRows == 0) {
            return triangle;
        }

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1L);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            ArrayList<Long> row = new ArrayList<>();
            ArrayList<Long> prevRow = triangle.get(rowNum-1);

            row.add(1L);

            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1L);

            triangle.add(row);
        }
        return triangle;
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}