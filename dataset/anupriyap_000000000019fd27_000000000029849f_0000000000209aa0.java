import java.util.Arrays;
import java.util.Scanner;

public class Solution {

        public static void findIndicium(int index, int n, int k){

            int[][] arr = new int[n][n];
            int temp;
            int count = 0;

            for(int i = 0; i < n; i++)
            {
                temp = n - i;
                for(int j = 0; j < n; j++)
                {
                   // if(i<n && j<n&& arr[i][j] != arr[i+1][j] && arr[i][j]!=arr[i][j+1]) {
                    if(temp <= 0)
                    {
                        temp = n;
                        arr[i][j] = temp;
                        temp -= 1;
                    }
                    else
                    {
                        arr[i][j] = temp;
                        temp -= 1;
                    }

                    if(i == j)
                    {
                        count += arr[i][j];
                    }
                }
            }

            int tempIndex = index + 1;
            if(count == k)
            {
                System.out.println("Case #" + tempIndex + ": " +"POSSIBLE");
                for (int i = 0; i < n; i++)
                {
                    for (int j = 0; j < n; j++)
                    {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            else System.out.println("Case #" + tempIndex + ": " +"IMPOSSIBLE");
            //return arr;
        }

        public static void main(String []args)
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            for(int i=0;i<t;i++)
            {
                int n,k;
                n = sc.nextInt();
                k = sc.nextInt();
                findIndicium(i, n, k);
            }
        }
    }
