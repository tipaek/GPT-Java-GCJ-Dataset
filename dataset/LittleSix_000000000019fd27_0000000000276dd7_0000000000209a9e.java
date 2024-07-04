import java.util.*;
import java.io.*;
import java.lang.*;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        int B = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= T; i++) {
            int markSame = -1;
            int markSameValue = -1;
            int markDiff = -1;
            int markDiffValue = -1;
            int next = 1;
            int[] bits = new int[B + 1];
            int[] comRound = new int[16];
            int[] revRound = new int[16];
            int unknown = B;
            
            for (int j = 1; j <= 15; j++) {
                comRound[j] = 0;
                revRound[j] = 0;
            }
            
            for (int round = 1; round <= 15; round++) {
                int currentMarkSameValue = -1;
                int currentMarkDiffValue = -1;
                
                if (markSame != -1) {
                    System.out.println(markSame);
                    currentMarkSameValue = in.nextInt();
                    in.nextLine();
                } else {
                    System.out.println("1");
                    in.nextLine();
                }
                
                if (markDiff != -1) {
                    System.out.println(markDiff);
                    currentMarkDiffValue = in.nextInt();
                    in.nextLine();
                } else {
                    System.out.println("1");
                    in.nextLine();
                }
                
                if (markSame != -1 && currentMarkSameValue != markSameValue) {
                    for (int j = 1; j <= round - 1; j++) {
                        comRound[j] = 1 - comRound[j];
                    }
                }
                
                if (markDiff != -1) {
                    if (markSame == -1 
                            || (currentMarkSameValue != markSameValue 
                                    && currentMarkDiffValue == markSameValue)
                            || (currentMarkSameValue == markSameValue 
                                    && currentMarkDiffValue != markSameValue)) {
                        for (int j = 1; j <= round - 1; j++) {
                            revRound[j] = 1 - revRound[j];
                        }
                    }
                }
                
                if (markSame != -1) {
                    markSameValue = currentMarkSameValue;
                }
                if (markDiff != -1) {
                    markDiffValue = currentMarkDiffValue;
                }
                
                for (int k = 0; k < 4; k++) {
                    System.out.println(next);
                    int left = in.nextInt();
                    in.nextLine();
                    bits[next] = left;
                    unknown--;
                    
                    System.out.println(B + 1 - next);
                    int right = in.nextInt();
                    in.nextLine();
                    bits[B + 1 - next] = right;
                    unknown--;
                    
                    if (unknown <= 0) {
                        break;
                    }
                    
                    if (left == right && markSame == -1) {
                        markSame = next;
                    } else if (left != right && markDiff == -1) {
                        markDiff = next;
                    }
                    
                    next++;
                }
                
                if (unknown <= 0) {
                    break;
                } 
            }
            
            StringBuilder result = new StringBuilder();
            int middle = (B + 1) / 2;
            
            for (int j = 1; j <= middle; j++) {
                int round = (j + 3) / 4;
                int value = revRound[round] == 1 ? bits[B + 1 - j] : bits[j];
                result.append(comRound[round] == 1 ? 1- value : value);
            }
            
            for (int j = middle + 1; j <= B; j++) {
                int round = (B - j + 4) / 4;
                int value = revRound[round] == 1 ? bits[B + 1 - j] : bits[j];
                result.append(comRound[round] == 1 ? 1- value : value);
            }
            
            System.out.println(result.toString());
            in.nextLine();
        }
    }
}