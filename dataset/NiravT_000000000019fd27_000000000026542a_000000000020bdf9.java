import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total_test_case = Integer.parseInt(br.readLine());
        for(int t = 1; t <= total_test_case; t++){
            int n = Integer.parseInt(br.readLine());
            int timestamp[] = new int[24*60+2];

            int arr[][] = new int[n][3];

            for (int i = 0; i < n ; i++) {
                String []str = br.readLine().split(" ");
                arr[i][0] = Integer.parseInt(str[0]);
                arr[i][1] = Integer.parseInt(str[1]);
                timestamp[arr[i][0]]++;
                timestamp[arr[i][1]]--;
                arr[i][2] = i;
            }



            boolean flag = true;
            for(int i = 1; i<timestamp.length; i++){
                timestamp[i] += timestamp[i - 1];
                if(timestamp[i]>2){
                    System.out.println("Case $" + t + ": IMPOSSIBLE");
                    flag = false;
                    break;
                }
            }

            if(flag){
                Arrays.sort(arr, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if(o1[0]==o2[0])return o1[1] - o2[1];
                        return o1[0] - o2[0];
                    }
                });

                int s[] = new int [n];
                int c_end = 0;
                int j_end = 0;
                for(int i = 0; i < n; i++){
                    if(c_end <= arr[i][0]){
                        s[arr[i][2]] = 1;
                        c_end = arr[i][1];
                    }else if(j_end <= arr[i][0]){
                        s[arr[i][2]] = 2;
                        j_end = arr[i][1];
                    }
                }
                StringBuilder answer  = new StringBuilder("");
                for(int i = 0; i < n; i++){
                    if(s[i]==1){
                        answer.append('C');
                    }else if(s[i]==2){
                        answer.append('J');
                    }else{
                        flag = false;
                        throw new RuntimeException("new");
                    }
                }
                if(flag)
                    System.out.println("Case $" + t + ": "+ answer.toString());
                if(!flag)
                    System.out.println("Case $" + t + ": IMPOSSIBLE");

            }

        }

    }
}
