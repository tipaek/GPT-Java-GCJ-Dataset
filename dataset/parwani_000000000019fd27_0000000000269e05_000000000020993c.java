import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String args[]) {

        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int test = Integer.parseInt(br.readLine());
            for(int t=0;t<test;t++)
            {
                int n = Integer.parseInt(br.readLine());
                int arr[][] = new int[n][n];
                for(int i=0;i<n;i++) {
                    String line[] = br.readLine().trim().split("\\s+");

                    for(int j=0;j<n;j++) {
                        arr[i][j] = Integer.parseInt(line[j]);
                    }
                }
                printLatin(arr,n,t);
                System.out.println();

            }
        }
        catch(Exception e)
        {

        }
    }
    public static void printLatin(int arr[][] , int n , int test) {

        boolean check[] = new boolean[n];
        int r=0;
        int c=0;
        int k=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {

                if(check[arr[i][j]-1]==true) {
                    r++;
                    break;
                }
                else {
                    check[arr[i][j]-1] = true;
                }
            }
            Arrays.fill(check,false);
        }
        Arrays.fill(check,false);
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {

                if(check[arr[j][i]-1]==true) {
                    c++;
                    break;
                }
                else {
                    check[arr[j][i]-1] = true;
                }
            }
            Arrays.fill(check,false);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    k+=arr[i][j];
            }
        }
        System.out.println("case #"+test+": "+k+" "+r+" "+c);
    }
}