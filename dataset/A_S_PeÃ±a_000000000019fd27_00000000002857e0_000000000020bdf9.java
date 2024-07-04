import java.util.*;


public class Solution {
    
    static Scanner SCNR = new Scanner(System.in);
    
    static String method1(int N, int [][] arr) {
        
        StringBuilder res = new StringBuilder();
        
        int j = 0;
        int c = 0;
        int i;
        int temp;
        PriorityQueue <Integer> pq = new PriorityQueue<Integer>((a, b) -> arr[a][1] - arr[b][1]);
        
        for (i = 0; i < N; ++i) {
            pq.add(i);
        }
        
        char [] cArr = new char [N];
        
        for (i = 0; i < N; ++i) {
            
            temp = pq.poll();
            
            if (j > c) {
                if (arr[temp][0] < c) {
                    return "IMPOSSIBLE";
                }
                if (arr[temp][0] < j) {
                    cArr[temp] = 'C';
                    c = arr[temp][1];
                    continue;
                }
                cArr[temp] = 'J';
                j = arr[temp][1];
            }
            else {
                if (arr[temp][0] < j) {
                    return "IMPOSSIBLE";
                }
                if (arr[temp][0] < c) {
                    cArr[temp] = 'J';
                    j = arr[temp][1];
                    continue;
                } 
                cArr[temp] = 'C';
                c = arr[temp][1];
            }
            
        }
        
        for (i = 0; i < N; ++i) {
            res.append(cArr[i]);
        }
        
        
        
        return res.toString();
    }
    
    
    public static void main (String [] args) {
        
        
        int T = SCNR.nextInt();
        int N;
        int [][] arr;
        int i;
        String num;
        int r, c;
        
        for (i = 1; i <= T; ++i) {
            N = SCNR.nextInt();
            arr = new int [N][2];
            for (r = 0; r < N; ++r) {
                arr [r][0] = SCNR.nextInt();
                arr [r][1] = SCNR.nextInt();
            }
            num = method1(N, arr);
            System.out.printf("Case #%d: %s\n", i, num);
        }
        
        SCNR.close();
    }
}