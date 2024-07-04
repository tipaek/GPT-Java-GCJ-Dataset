import java.util.*;
public class Solution{
    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k=t;
        while(t-->0){
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    arr[i][j] = sc.nextInt();
            }
            int trace = 0;
            for(int i=0;i<n;i++){
                trace = trace + arr[i][i];
            }

            int r=0, c=0;
            for(int i=0;i<n;i++){
                HashSet<Integer> hs = new HashSet<>();
                for(int j=0;j<n;j++){
                    if(hs.contains(arr[i][j])){
                        r++;
                        break;
                    }
                    hs.add(arr[i][j]);
                }
            }
            for(int i=0;i<n;i++){
                HashSet<Integer> hs = new HashSet<>();
                for(int j=0;j<n;j++){
                    if(hs.contains(arr[j][i])){
                        c++;
                        break;
                    }
                    hs.add(arr[j][i]);
                }
            }
            System.out.println("Case #"+(k-t)+": "+trace+" "+r+" "+c);
        }
    }
}

