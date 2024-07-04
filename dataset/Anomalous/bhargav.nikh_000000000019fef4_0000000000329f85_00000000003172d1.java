import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws Exception {
        new Solution().solveCases();
    }

    public void solveCases() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nCases = Integer.parseInt(br.readLine());
        for (int idx = 1; idx <= nCases; idx++) {
            solve(idx, br);
        }
    }

    public void solve(int caseNo, BufferedReader br) throws Exception {
        // Take input
        String[] strArr = br.readLine().split(" ");
        int nCount = Integer.parseInt(strArr[0]);
        int d = Integer.parseInt(strArr[1]);
        Map<Double, Node> nodeMap = new HashMap<>();

        // For Map
        strArr = br.readLine().split(" ");
        for (int idx = 0; idx < nCount; idx++) {
            double angle = Double.parseDouble(strArr[idx]);
            nodeMap.putIfAbsent(angle, new Node(0, 0));
            nodeMap.get(angle).count++;
        }

        // Print answer
        printAns(caseNo, nCount, d, nodeMap);
    }

    public void printAns(int caseNo, int nCount, int d, Map<Double, Node> nodeMap) {
        int minCut = Integer.MAX_VALUE;

        for (double angle : nodeMap.keySet()) {
            for (int cutCount = 0; cutCount <= d - 1; cutCount++) {
                if (cutCount == 0) {
                    if (nodeMap.get(angle).count == d) {
                        minCut = Math.min(minCut, nodeMap.get(angle).cut);
                    }
                    continue;
                }

                double newAngle = angle / cutCount;
                int newCount = cutCount + 1;

                // Additional logic can be implemented here if needed

                // Example condition
                if (nodeMap.get(angle).count == d) {
                    // Implement additional logic if needed
                }
            }
        }

        printDis(caseNo, minCut);
    }

    public void printDis(int caseNo, int cut) {
        System.out.println("Case #" + caseNo + ": " + cut);
    }

    class Node {
        int count;
        int cut;

        public Node(int count, int cut) {
            this.count = count;
            this.cut = cut;
        }
    }
}