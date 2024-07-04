import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        int temp;
        int num;
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int trace = 0;
            int r=0;
            int c=0;
            int[][]arr = new int [n][n];
            int[][]arr2= new int [n][n];
            for (int row =0; row<n; row++)
            {

                for (int col=0; col<n; col++)
                {
                    temp = in.nextInt();
                    if(col-row==0)
                    {
                        trace+=temp;
                    }
arr[row][col]=temp;
                    arr2[col][row]=temp;

                }
            }
            boolean go = true;
            for (int row = 0; row<n; row++)
            {
                go = true;
                for (int x =1; x<=n; x++)
                {
                    Arrays.sort(arr[row]);
                    num = Arrays.binarySearch(arr[row], x);
                    if(num>=0)
                    {
                        arr[row][num]=-1;
                        Arrays.sort(arr[row]);
                        num = Arrays.binarySearch(arr[row], x);
                        if(num>=0 && go)
                        {
                            r++;
                            go = false;
                        }
                    }
                }
            }
            for (int row = 0; row<n; row++)
            {
                go = true;
                for (int x =1; x<=n; x++)
                {
                    Arrays.sort(arr2[row]);
                    num = Arrays.binarySearch(arr2[row], x);
                    if(num>=0)
                    {
                        arr2[row][num]=-1;
                        Arrays.sort(arr2[row]);
                        num = Arrays.binarySearch(arr2[row], x);
                        if(go && num>=0)
                        {
                            c++;
                            go =false; 
                        }
                    }
                }
            }


            System.out.println("Case #" + i + ": " +trace+" "+ (r ) + " " + (c ));
            }

        }
    }
