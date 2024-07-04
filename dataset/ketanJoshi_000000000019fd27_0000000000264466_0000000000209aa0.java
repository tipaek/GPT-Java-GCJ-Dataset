import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Solution {
    public static void main(String[] args) {
        FastReader fd = new FastReader();
        int t = fd.nextInt();
        for(int test = 1; test <= t; test++){
            int n = fd.nextInt();
            int k = fd.nextInt();
            if(k == n+1){
                System.out.println("Case #"+test+": IMPOSSIBLE");
            }
            else{
                int[][] data = new int[n][n];
                fillDiag(data,k);
                int temp = data[0][0];
                data[0][0] = data[n-1][n-1];
                data[n-1][n-1] = temp;
                generateArray(data, n);
                int[] masterCol = new int[n];

                processArray(data,masterCol);
                if(search(data,n,n,0)){
                    System.out.println("Case #"+test+": IMPOSSIBLE");
                }
                else{
                    System.out.println("Case #"+test+": POSSIBLE");
                    printArray(data);
                }
            }
        }
    }
    static void processArray(int[][] data,int[] masterCol){
        int r = 2;
        int intr = 2;
        for(int col = 1; col < masterCol.length; col++){
            int lim = masterCol.length - (col+1);
            for(int i = 0; i < lim; i++){
                data[r][col] = getValidValue(data,r,col,masterCol.length);
                r++;
            }
            intr++;
            r=intr;
        }

        r = 0;
        intr = 0;
        int lim = 1;
        for(int col = 1; col < masterCol.length; col++){
            for(int i = 0; i < lim; i++){
                data[i][col] = getValidValue(data,i,col,masterCol.length);
            }
            lim++;
        }

    }
    static boolean search(int mat[][], int m,
                          int n, int x) {

        int i = m - 1, j = 0;
        while (i >= 0 && j < n)
        {
            if (mat[i][j] == x)
                return true;
            if (mat[i][j] > x)
                i--;
            else
                j++;
        }

        return false;
    }
    static void fillDiag(int a[][],int k)
    {
        for(int i=0;i<a.length;i++)
        {
            a[i][i]=a.length;
        }

        int sum = a.length*a.length;

        for(int i = a.length-1;i>=0;i--)
        {
            if(sum==k)
                break;
            int x = sum-k;
            x = Math.min(a[i][i]-1,x);
            a[i][i]-=x;
            sum-=x;
        }
    }
    static void generateArray(int[][] data,int n){
        for(int i = 0; i < n; i++){
                    int val = getValidValue(data,i,0,n);
                    if(val != -1){
                        data[i][0] = val;
                    }
        }

    }

    private static int getValidValue(int[][] data,int i, int j, int n) {
        if(i == j){return -1;}
        HashMap<Integer,Boolean> check = new HashMap<>();
        for(int p = 1; p <= n; p++){
            check.put(p,false);
        }
        for(int c = 0; c < n; c++){

            if(check.containsKey(data[c][j]) && ! check.get(data[c][j])){
                check.replace(data[c][j],true);
            }
        }

        for(int r = 0; r < n; r++){
            if(check.containsKey(data[i][r]) && ! check.get(data[i][r])){
                check.replace(data[i][r],true);
            }
        }

        Set<Integer> keys = getKeysByValue(check,false);
        if(keys.size() > 0)
            return  (int) keys.toArray()[0];
        return 0;
    }

    public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
        Set<T> keys = new HashSet<T>();
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }
    static class FastReader
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
                catch (IOException e)
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
    static void printArray(int[][] data){
        for(int i = 0; i < data[0].length; i++){
          for(int j = 0; j < data[0].length; j++){
              System.out.print(data[i][j]+" ");
          }
          System.out.println();
        }
    }
}
