import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int t = in.nextInt();
        int test = 1;
        while(t--!=0){
            int n = in.nextInt();
            int [][]mat = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j]  = in.nextInt();
                }
            }
            int trace = 0;
            for(int i=0;i<n;i++){
                trace+=mat[i][i];
            }
            int rowcount = 0;
            for(int i = 0;i<n;++i){
                HashSet<Integer> set = new HashSet<>();
                boolean flag = false;
                for(int j=0;j<n;j++){
                    if(set.contains(mat[i][j])){
                        flag = true;
                        break;
                    }
                    set.add(mat[i][j]);
                }
                if(flag)rowcount++;
            }

            int colcount = 0;
            for(int i = 0;i<n;++i){
                HashSet<Integer> set = new HashSet<>();
                boolean flag = false;
                for(int j=0;j<n;j++){
                    if(set.contains(mat[j][i])){
                        flag = true;
                        break;
                    }
                    set.add(mat[j][i]);
                }
                if(flag)colcount++;
            }
            System.out.println("Case #"+test+": "+trace+" "+rowcount+" "+colcount);
            test++;
        }
    }
}
