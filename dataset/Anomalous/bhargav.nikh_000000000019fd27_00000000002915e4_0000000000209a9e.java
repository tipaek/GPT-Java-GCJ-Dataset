import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().solveCases();
    }
    
    public void solveCases() throws IOException {
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
    
    public boolean solve(int caseNo, int nBits, BufferedReader br) throws IOException {
        String[] result = new String[nBits + 1];
        boolean resultFound = false;
        
        for (int qIdx = 1, bIdx = 1; qIdx <= 150 && bIdx <= nBits; qIdx++) {
            if (qIdx % 10 == 2) {
                System.out.println(bIdx);
                System.out.flush();
                result[bIdx] = br.readLine();
                bIdx++;
                qIdx++;
            }
            System.out.println(bIdx);
            System.out.flush();
            result[bIdx] = br.readLine();
            bIdx++;
            
            if (bIdx == nBits + 1) {
                bIdx = 1;
                StringBuilder resultBuilder = new StringBuilder();
                for (int idx = 1; idx <= nBits; idx++) {
                    resultBuilder.append(result[idx]);
                }
                System.out.println(resultBuilder.toString());
                System.out.flush();
                
                if (br.readLine().equals("Y")) {
                    resultFound = true;
                }
            }
            if (resultFound) {
                break;
            }
        }
        return resultFound;
    }
}