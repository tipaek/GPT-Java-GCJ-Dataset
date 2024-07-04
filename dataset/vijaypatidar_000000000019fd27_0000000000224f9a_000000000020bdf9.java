import java.util.Scanner;

public class Solution {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String res = "";
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] arr= new int[N][2];

            for (int i=0;i<N;i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            for(int i=0;i<N;i++){
                for (int j=i+1;j<N;j++){
                    if(arr[i][0]>arr[j][0]){
                        int[] tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }

            int endC=0,endJ=0;
            String result ="";
            for (int[] ar:arr){
                if (endC<=ar[0]){
                    result+="C";
                    endC=ar[1];
                }else if (endJ<=ar[0]){
                    result+="J";
                    endJ=ar[1];
                }else {
                    result = "IMPOSSIBLE";
                }
            }

            res += "Case #" + t + ": " + result;
            if (t != T) res += "\n";
        }
        System.out.print(res);
    }
}