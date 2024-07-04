import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Solution {

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        try
        {

            int test = scan.nextInt();
            ArrayList<String> arrayList = new ArrayList<>();
            for(int t=0;t<test;t++)
            {
                int n = scan.nextInt();
                int arr[][] = new int[n][n];
                for(int i=0;i<n;i++) {
                    for(int j=0;j<n;j++) {
                        arr[i][j] = scan.nextInt();
                    }
                }
                printLatin(arr,n,t,arrayList);
            }
            for(String s : arrayList) {
                System.out.println(s);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            System.gc();
        }
    }
    public static void printLatin(int arr[][] , int n , int test,ArrayList<String> strings) {

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
        strings.add("case #"+test+": "+k+" "+r+" "+c);
    }
}