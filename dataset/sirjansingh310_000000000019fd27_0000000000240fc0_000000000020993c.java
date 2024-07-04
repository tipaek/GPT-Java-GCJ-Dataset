import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int caseNumber = 1;
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][n];
            StringTokenizer st;

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            long trace = 0L;

            for(int i = 0; i < n; i++){
                trace += arr[i][i];
            }

            int rowRepeated = 0, colRepeated = 0;
            TreeSet<Integer> set;
            for(int i = 0; i < n; i++){
                set = new TreeSet<>();
                for(int j = 0; j < n; j++){
                    if(set.contains(arr[i][j])) {
                        rowRepeated++;
                        break;
                    }
                    else
                        set.add(arr[i][j]);
                }
            }

            for(int i = 0; i < n; i++){
                set = new TreeSet<>();
                for(int j = 0; j < n; j++){
                    if(set.contains(arr[j][i])) {
                        colRepeated++;
                        break;
                    }
                    else
                        set.add(arr[j][i]);
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeated + " " + colRepeated);
            caseNumber++;
        }
    }

}
