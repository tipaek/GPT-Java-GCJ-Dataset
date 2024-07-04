import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            
            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }
            
            ArrayList<Character> ch = new ArrayList<>();
            ArrayList<Integer> startC = new ArrayList<>();
            ArrayList<Integer> endC = new ArrayList<>();
            ArrayList<Integer> startJ = new ArrayList<>();
            ArrayList<Integer> endJ = new ArrayList<>();
            
            ch.add('C');
            startC.add(start[0]);
            endC.add(end[0]);
            
            if (n > 1) {
                ch.add('J');
                startJ.add(start[1]);
                endJ.add(end[1]);
            }
            
            boolean isPossible = true;
            for (int i = 2; i < n; i++) {
                boolean canBeC = true;
                boolean canBeJ = true;
                
                for (int j = 0; j < startC.size(); j++) {
                    if (start[i] < endC.get(j) && end[i] > startC.get(j)) {
                        canBeC = false;
                        break;
                    }
                }
                
                if (canBeC) {
                    ch.add('C');
                    startC.add(start[i]);
                    endC.add(end[i]);
                } else {
                    for (int j = 0; j < startJ.size(); j++) {
                        if (start[i] < endJ.get(j) && end[i] > startJ.get(j)) {
                            canBeJ = false;
                            break;
                        }
                    }
                    
                    if (canBeJ) {
                        ch.add('J');
                        startJ.add(start[i]);
                        endJ.add(end[i]);
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }
            
            if (isPossible) {
                System.out.print("Case #" + t + ": ");
                for (char c : ch) {
                    System.out.print(c);
                }
                System.out.println();
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
        sc.close();
    }
}