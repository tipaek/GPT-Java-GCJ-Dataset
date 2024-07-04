import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args)throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.valueOf(br.readLine());

        for(int t=1;t<=T;t++) {
            int N=Integer.valueOf(br.readLine());
            //System.out.println(N);
            int arr[][]=new int [N][N];
            for(int i=0;i<N;i++){
                String val[]=br.readLine().split(" ");
                for(int j=0;j<N;j++) {
                    arr[i][j] = Integer.valueOf(val[j]);
                }
                //System.out.println(Arrays.toString(arr[i]));
            }

            System.out.format("Case #%d: %d %d %d\n",t,getTrace(arr),getEqualRows(arr),getEqualCols(arr));

        }
        br.close();

    }
    public static int getTrace(int[][] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i][i];
        }
        return sum;
    }
    public static int getEqualRows(int [][] arr){

        int rN=0;
        for(int [] k: arr) {
            HashSet<Integer> set = new HashSet<>();
            for(int n:k){
                if(set.contains(n)){
                    rN++;
                    break;
                }else set.add(n);
            }
        }

        return rN;
    }
    public static int getEqualCols(int [][] arr){
        int cN=0;
        for(int col=0;col<arr.length;col++){
            HashSet<Integer> set = new HashSet<>();
            for(int rows=0;rows<arr.length;rows++){
                int val=arr[rows][col];
                if(set.contains(val)) {
                    cN++;
                    break;
                }else
                    set.add(val);

            }
        }
        return cN;
    }

}
