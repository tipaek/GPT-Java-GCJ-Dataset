import java.util.*;
import java.io.*;

class Solution {
    
    public static void main (String[] args) throws Exception {
        new Solution().solveCases();
    }
    
    Map<Character, Node> dirMap;
    class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public void solveCases() throws Exception {
        BufferedReader br =  
                   new BufferedReader(new InputStreamReader(System.in)); 
        int nCases = Integer.valueOf(br.readLine());
        createDirMap();
        for (int idx = 1 ; idx <= nCases ; idx++) {
            solve (idx, br);
        }
        
    }
    
    public void solve(int caseNo, BufferedReader br) throws Exception {
        // Take input
        String[] strArr = br.readLine().split(" ");
        int x = Integer.valueOf(strArr[0]);
        int y = Integer.valueOf(strArr[1]);
        String path = strArr[2];
        // print solution
        printSolution(caseNo, x, y, path);
    }   
    
    public void createDirMap() {
        dirMap = new HashMap();
        dirMap.put('N', new Node(0, 1));
        dirMap.put('S', new Node(0, -1));
        dirMap.put('E', new Node(1, 0));
        dirMap.put('W', new Node(-1, 0));
    }
    
    public void printSolution(int caseNo, int x, int y, String path) {
        int dis = -1;
        if (x == 0 && y == 0) {
            printDis(caseNo, 0);
            return;
        }
        int curX = x, curY = y;
        for (int idx = 0 ; idx < path.length() ; idx++) {
            int fanSteps = idx + 1;
            // Update Dir
            Node dirNode = dirMap.get(path.charAt(idx));
            curX = curX + dirNode.x;
            curY = curY + dirNode.y;
            
            int curDis = Math.abs(curX) + 
                            Math.abs(curY);
            if (curDis <= fanSteps) {
                dis = fanSteps;
                break;
            }
        }
        printDis(caseNo, dis);
        return;
    }
    
    public void printDis(int caseNo, int dis) {
        if (dis != -1) {
            System.out.println("Case #"+caseNo+": "+dis);        
            return;
        }
        System.out.println("Case #"+caseNo+": IMPOSSIBLE");        
    }
}
