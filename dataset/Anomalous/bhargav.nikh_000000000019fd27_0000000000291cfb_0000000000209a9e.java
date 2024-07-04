import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().solveCases();
    }

    public void solveCases() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int nCases = Integer.parseInt(input[0]);
        int nBits = Integer.parseInt(input[1]);
        
        for (int i = 1; i <= nCases; i++) {
            if (!solve(i, nBits, br)) {
                break;
            }
        }
    }

    public boolean solve(int caseNo, int nBits, BufferedReader br) throws Exception {
        boolean resultFound = false;
        String[] result = new String[nBits + 1];
        
        for (int qIdx = 1, bIdx = 1; qIdx <= 150 && bIdx <= nBits; qIdx++) {
            System.out.println(bIdx);
            System.out.flush();
            
            result[bIdx] = br.readLine();
            bIdx++;
            
            if (bIdx == nBits + 1) {
                StringBuilder resultBuilder = new StringBuilder();
                for (int j = 1; j <= nBits; j++) {
                    resultBuilder.append(result[j]);
                }
                
                System.out.println(resultBuilder.toString());
                System.out.flush();
                
                if (br.readLine().equals("Y")) {
                    resultFound = true;
                }
                qIdx++;
            }
            
            if (resultFound) {
                break;
            }
        }
        
        return resultFound;
    }
}