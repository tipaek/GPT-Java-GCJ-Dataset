import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            ArrayList<Character> ch = new ArrayList<>();
            ArrayList<Integer> startC = new ArrayList<>();
            ArrayList<Integer> endC = new ArrayList<>();
            ArrayList<Integer> startJ = new ArrayList<>();
            ArrayList<Integer> endJ = new ArrayList<>();
            
            int[] start = new int[n];
            int[] end = new int[n];
            
            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }
            
            ch.add('C');
            startC.add(start[0]);
            endC.add(end[0]);
            
            if (n > 1) {
                ch.add('J');
                startJ.add(start[1]);
                endJ.add(end[1]);
            }
            
            boolean isImpossible = false;
            
            for (int i = 2; i < n; i++) {
                boolean canAssignToC = true;
                for (int j = 0; j < startC.size(); j++) {
                    if ((start[i] >= startC.get(j) && end[i] <= endC.get(j)) ||
                        (start[i] < startC.get(j) && end[i] > startC.get(j)) ||
                        (start[i] < endC.get(j) && end[i] > endC.get(j))) {
                        canAssignToC = false;
                        break;
                    }
                }
                
                if (canAssignToC) {
                    ch.add('C');
                    startC.add(start[i]);
                    endC.add(end[i]);
                } else {
                    boolean canAssignToJ = true;
                    for (int j = 0; j < startJ.size(); j++) {
                        if ((start[i] >= startJ.get(j) && end[i] <= endJ.get(j)) ||
                            (start[i] < startJ.get(j) && end[i] > startJ.get(j)) ||
                            (start[i] < endJ.get(j) && end[i] > endJ.get(j))) {
                            canAssignToJ = false;
                            break;
                        }
                    }
                    
                    if (canAssignToJ) {
                        ch.add('J');
                        startJ.add(start[i]);
                        endJ.add(end[i]);
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + t + ": ");
                for (char c : ch) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
        
        sc.close();
    }
}