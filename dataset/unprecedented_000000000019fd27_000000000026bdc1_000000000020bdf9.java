import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        int x = 0;
        while (x++ < T){
            int n = scanner.nextInt();
            int[][] arr = new int[n][2];
            StringBuilder result = new StringBuilder();
            for (int i=0; i<n; i++){
                arr[i][0] = scanner.nextInt();
                arr[i][1] = scanner.nextInt();
            }
            //Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            boolean flag = true;
            for (int i=0; i<n; i++){
                int start = arr[i][0], end = arr[i][1];
                int mid = start + (end-start)/2;
                if (!set1.contains(start) && !set1.contains(end) && !set1.contains(mid)){
                    for(int j= start+1; j<end; j++)
                        set1.add(j);
                    result.append('C');
                }
                else if (!set2.contains(start) && !set2.contains(end) && !set2.contains(mid)){
                    for(int j= start+1; j<end; j++)
                        set2.add(j);
                    result.append('J');
                }
                else{
                    flag = false;
                    break;
                }
                //System.out.println("Set1: "+set1);
                //System.out.println("Set2: "+set2);
            }
            if (flag)
                System.out.println("Case #"+ x +": "+ result.toString());
            else
                System.out.println("Case #"+ x +": "+ "IMPOSSIBLE");
        }
    }

}
/*
4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440
 */