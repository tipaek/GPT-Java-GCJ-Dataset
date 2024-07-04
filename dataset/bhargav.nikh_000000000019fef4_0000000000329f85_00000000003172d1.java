import java.util.*;
import java.io.*;

class Solution {
    
    public static void main (String[] args) throws Exception {
        
        new Solution().solveCases();
    }
    
    public void solveCases() throws Exception {
        BufferedReader br =  
                   new BufferedReader(new InputStreamReader(System.in)); 
        int nCases = Integer.valueOf(br.readLine());
        for (int idx = 1 ; idx <= nCases ; idx++) {
            solve (idx, br);
        }
        
    }
    
    public void solve(int caseNo, BufferedReader br) throws Exception {
        // Take input
        String[] strArr = br.readLine().split(" ");
        int nCount = Integer.valueOf(strArr[0]);
        int d = Integer.valueOf(strArr[1]);
        Map<Double, Node> nodeMap = new HashMap();
        // For Map
        strArr = br.readLine().split(" ");
        for (int idx = 0 ; idx < nCount ; idx++) {
            int angle = Double.valueOf(strArr[idx]);
            if (nodeMap.containsKey(angle)) {
                Node node = nodeMap.get(angle);
                node.count++;
            } else {
                nodeMap.put(angle, new Node(1, 0));
            }
        }
        // print ans
        printAns(caseNo, nCount, d, nodeMap);
    }
    
    public void printAns(int caseNo, int nCount, int d, 
            Map<Double, Integer> nodeMap) {
        
        int minCut = Integer.MAX_VALUE;
        
        for (double angle : nodeMap.keySet()) {
            for (int cutCount = 0 ; cutCount <= d - 1 ; cutCount++) {
                if (cutCount == 0) {
                    if (nodeMap.get(angle).count == d) {
                        if (minCut > nodeMap.get(angle).cut) {
                            minCut = nodeMap.get(angle).cut;
                        }
                    }
                    continue;
                }
                int newAngle = angle / cutCount;
                int newCount = cutCount + 1;
                
                // if () {
                    
                // }
                // if (nodeMap.get(angle).count == d) {
                    
                // }
                
                // nodeMap.
            }
        }
        
        printDis(caseNo, cut);
    }
    
    public void printDis(int caseNo, int cut) {
        System.out.println("Case #"+caseNo+": "+dis);        
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