import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCases; i++){
            int n = Integer.parseInt(br.readLine());
            int m[][] = new int[n][n];
            int cameron = -1;
            int james = -1; 
            String solution = "Case #" + (i+1) + ": ";
            for(int j = 0; j < n; j++){
                String s[] = br.readLine().split(" ");
                m[j][0] = Integer.parseInt(s[0]);
                m[j][1] = Integer.parseInt(s[1]);
            }
            Arrays.sort(m, (a, b) -> Double.compare(a[0], b[0]));
            for(int j = 0; j < n; j++){
                if(cameron == -1 || cameron <= m[j][0]){
                    solution+='C';
                    cameron = m[j][1];
                }else if(james == -1 || james <= m[j][0]){
                    solution+='J';
                    james = m[j][1];
                }else{
                    solution = "Case #" + (i+1) + ": IMPOSSIBLE";
                    break;
                }
            }
            System.out.println(solution);
        }
    }
}