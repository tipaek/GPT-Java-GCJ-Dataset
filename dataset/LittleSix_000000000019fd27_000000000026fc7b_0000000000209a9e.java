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
            int[] bits = new int[B+1];
            int unknown = B;
            
            for (int j = 1; j <= B; j++) {
                bits[j] = -1;
            }
            
            for (int j = 1; j <= 15; j++) {
                int attempt = 10;
                int currentMarkSameValue = -1;
                int currentMarkDiffValue = -1;
                if (markSame != -1) {
                    System.out.println(markSame);
                    currentMarkSameValue = in.nextInt();
                    in.nextLine();
                    attempt--;
                }
                if (markDiff != -1) {
                    System.out.println(markDiff);
                    currentMarkDiffValue = in.nextInt();
                    in.nextLine();
                    attempt--;
                }
                
                if (markSame != -1 && currentMarkSameValue != markSameValue) {
                    for (int k = 1; k <= B; k++) {
                        if (bits[k] != -1) {
                            bits[k] = 1 - bits[k];
                        }
                    }
                }
                if (markDiff != -1) {
                    if (markSame == -1 
                            || (currentMarkSameValue != markSameValue 
                                    && currentMarkDiffValue == markSameValue)
                            || (currentMarkSameValue == markSameValue 
                                    && currentMarkDiffValue != markSameValue)) {
                        int end = (B + 1) / 2;
                        for (int k = 1; k <= end; k++) {
                            if (bits[k] != -1) {
                                int swap = bits[k];
                                bits[k] = bits[B + 1 - k];
                                bits[B + 1 - k] = swap;
                            }
                        }
                    }
                }
                
                if (markSame != -1) {
                    markSameValue = currentMarkSameValue;
                }
                if (markDiff != -1) {
                    markDiffValue = currentMarkDiffValue;
                }
                
                while (attempt > 1) {
                    System.out.println(next);
                    int left = in.nextInt();
                    in.nextLine();
                    bits[next] = left;
                    unknown--;
                    attempt--;
                    
                    System.out.println(B + 1 - next);
                    int right = in.nextInt();
                    in.nextLine();
                    bits[B + 1 - next] = right;
                    unknown--;
                    attempt--;
                    
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
                
                if (attempt == 1) {
                    System.out.println("1");
                    in.nextLine();
                }
            }
            
            StringBuilder result = new StringBuilder();
            for (int j = 1; j <= B; j++) {
                result.append(bits[j]);
            }
            System.out.println(result.toString());
            in.nextLine();
        }
    }
}