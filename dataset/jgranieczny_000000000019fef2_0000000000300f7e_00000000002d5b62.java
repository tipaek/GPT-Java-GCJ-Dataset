
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    static int[] Xs;
    static int[] Ys;
    static int[] arr;
    static HashSet<Integer> XsSet;
    static HashSet<Integer> YsSet;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        XsSet=new HashSet<>();
        YsSet=new HashSet<>();
        int T = scanner.nextInt();//test cases
         Xs = new int[T];
         Ys = new int[T];

        for (int i = 0; i < T; i++) {
             Xs[i] = scanner.nextInt();//test cases
             Ys[i] = scanner.nextInt();//test cases
            XsSet.add(Xs[i]);
            YsSet.add(Ys[i]);



        }
        arr = createArr(13);
        int n = arr.length;

        subsetSums( 0, n - 1, 0,0,"");
        System.out.println("sums");
        for (int i = 0; i < T; i++) {
            System.out.print("Case #"+(i+1)+": ");

            print(Xs[i], Ys[i]);
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
    static void subsetSums( int l,
                           int r, int sum,int sum2,String sign )
    {
        String current = possibilites.get(sum+","+sum2);
        if((current!=null||XsSet.contains(sum)&&YsSet.contains(sum2))&&(current==null || current.length()>sign.length()))
            possibilites.put(sum+","+sum2,sign);
        // Print current subset
        if (l > r)
        {
            return;
        }

        // Subset including arr[l]
        subsetSums( l + 1, r,
                sum + arr[l],sum2,sign+"E");
        subsetSums( l + 1, r,
                sum - arr[l],sum2,sign+"W");
        subsetSums( l + 1, r,
                sum,sum2+arr[l],sign+"N");
        subsetSums( l + 1, r,
                sum,sum2-arr[l],sign+"S");


    }



}