import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.jar.JarOutputStream;

public class Solution {

    public static long factorial(int no) {
        if (no == 1 || no == 0) {
            return 1;
        } else {
            return no * factorial(no - 1);
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static int bsearch(int[] arr, int low, int high, int ele) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == ele) {
                return mid;
            } else if (arr[mid] < ele) {
                return bsearch(arr, mid + 1, high, ele);
            } else {
                return bsearch(arr, low, mid - 1, ele);
            }
        }
        return -1;
    }

    public static int isPrime(int n){
        if(n==1){
            return 0;
        }
        int flag=0;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                flag+=1;
            }
        }
        if(flag==0){
            return 1;
        }
        else{
            return 0;
        }
    }




    public static void main(String[] args) throws IOException {

        Reader.init(System.in);
        int cases = Reader.nextInt();
        for(int i=0;i<cases;i++){
            int n = Reader.nextInt();
            int[][] arr = new int[n][n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    arr[j][k] = Reader.nextInt();
                }
            }
            int sum = 0;
            int rows = 0;
            int cols = 0;
            for(int j=0;j<n;j++){
                sum += arr[j][j];
                HashSet<Integer> set1 = new HashSet<>();
                HashSet<Integer> set2 = new HashSet<>();
                for(int k=0;k<n;k++){
                    set1.add(arr[j][k]);
                }
                for(int k=0;k<n;k++){
                    set2.add(arr[k][j]);
                }
                if(set1.size()<n){
                    rows += 1;
                }
                if(set2.size()<n){
                    cols += 1;
                }
            }
            System.out.println(sum + " "+ rows + " " + cols);
        }

        }

        }






class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String nextLine() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( nextLine() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong(nextLine());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( nextLine() );
    }

    static float nextFloat() throws IOException {
        return Float.parseFloat( nextLine() );
    }
    static int[] nextIntArray(int length) throws IOException {
        int[] arr = new int[length];
        //System.out.println(length);
        for (int i=0; i<length; i++) {
            arr[i] = Integer.parseInt( nextLine() );
            //System.out.println(arr[i]);
        }
        //System.out.println(arr);
        return arr;
    }
    static long[] nextLongArray(int length) throws IOException {
        long[] arr = new long[length];
        for (int i=0; i<length; i++) {
            arr[i] = Long.parseLong( nextLine() );
        }
        return arr;
    }

}

