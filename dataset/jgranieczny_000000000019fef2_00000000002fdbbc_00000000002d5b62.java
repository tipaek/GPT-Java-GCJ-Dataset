
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int[] arr = createArr(20);
        int n = arr.length;

        subsetSums(arr, 0, n - 1, 0,0,"");
        int T = scanner.nextInt();//test cases
        for (int i = 0; i < T; i++) {
            int X = scanner.nextInt();//test cases
            int Y = scanner.nextInt();//test cases
            System.out.print("Case #"+(i+1)+": ");

            print(X,Y);




        }
    }

    private static void print(int x, int y) {
        String result="";
          solve(x,y,1,0,0,result);

    }

    private static void solve(int x, int y,int iter, int currX,int currY,String result) {

        String resultStr =  possibilites.get(x+","+y);
        if(resultStr!=null)
            System.out.println(resultStr);
        else
            System.out.println("IMPOSSIBLE");

    }

    private static int[] createArr(int iter) {
        int[] result=new int[iter];
        for(int i=0;i<iter;i++){
            if(i==0)
                result[i]=1;
            else
                result[i]=result[i-1]*2;
        }
        return result;
    }
    static HashMap<String,String> possibilites=new HashMap<>();
    static void subsetSums(int []arr, int l,
                           int r, int sum,int sum2,String sign )
    {
        String current = possibilites.get(sum+","+sum2);
        if(current==null || current.length()>sign.length())
            possibilites.put(sum+","+sum2,sign);
        // Print current subset
        if (l > r)
        {
            return;
        }

        // Subset including arr[l]
        subsetSums(arr, l + 1, r,
                sum + arr[l],sum2,sign+"E");
        subsetSums(arr, l + 1, r,
                sum - arr[l],sum2,sign+"W");
        subsetSums(arr, l + 1, r,
                sum,sum2+arr[l],sign+"N");
        subsetSums(arr, l + 1, r,
                sum,sum2-arr[l],sign+"S");


    }



}