import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i=0;i<T;i++){
            int N = scanner.nextInt();
            int[][] arr = new int[N][3];
            for(int j=0;j<N;j++){
                arr[j][0]=scanner.nextInt();
                arr[j][1]=scanner.nextInt();
                arr[j][2]=j;
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            boolean[] mem = new boolean[2];
            int[] end = new int[2];
            String result="";
            boolean flag = false;
            for(int j=0;j<N;j++){
                if(arr[j][0]>=end[0]){
                    mem[0]=false;
                }
                if(arr[j][0]>=end[1]){
                    mem[1]=false;
                }
                if(mem[0]&&mem[1]){//FF
                    System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                    flag=true;
                    break;
                }
                if(!mem[0]){//F
                    end[0]=arr[j][1];
                    result+="C";
                    mem[0]=true;
                    continue;
                }
                
                if(!mem[1]){//TF
                    end[1]=arr[j][1];
                    result+="J";
                    mem[1]=true;
                    continue;
                }
            }
            if(!flag){
                System.out.print("Case #"+(i+1)+": ");
                for(int n=0;n<N;n++){
                    System.out.print(result.charAt(arr[n][2]));
                }
                System.out.println();
            }
        }
    }
}
