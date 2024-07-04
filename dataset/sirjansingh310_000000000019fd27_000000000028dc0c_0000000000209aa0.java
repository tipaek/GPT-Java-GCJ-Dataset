import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int caseNumber = 1;
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int arr[][] = new int[n][n];
            int startAt = 0;
            int count;
            for(int i = 0; i < n; i++){
                count = 1;
                int j =  startAt;
                while (count <= n) {
                    arr[i][j % n] = count;
                    count++;
                    j++;
                }
                startAt++;
            }
            boolean isPossible = false;
            int startWith = 1;
            if(k % n == 0){
                isPossible = true;
                startWith = k / n;
            }
            for(int i = 0; i < n; i++){
                if(arr[i][0] == startWith){
                    startAt = i;
                }
            }

            count = 0;
            if(isPossible) {
                System.out.println("Case #" + caseNumber + ": " + "POSSIBLE");
                while (count < n) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(arr[startAt % n][j] + " ");
                    }
                    System.out.println();
                    startAt++;
                    count++;
                }
            }
            else
                System.out.println("Case #" + caseNumber + ": " + "IMPOSSIBLE");
            caseNumber++;
        }
    }
}
