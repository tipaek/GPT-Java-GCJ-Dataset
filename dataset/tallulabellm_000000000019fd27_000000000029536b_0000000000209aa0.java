import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

class Solution{
    public static void allPos(int ind, int n, int sum, int k, ArrayList<int[]> all, int[] ret){
        if(sum>k) return;
        if(ind == n){
            if(sum == k){
                int[] newOne = ret.clone();
                all.add(newOne);
            }
            return;
        }
        for(int i=1;i<=n;i++){
            ret[ind] = i;
            allPos(ind+1,n,sum+i,k, all, ret);
        }
        return;
    }
    public static boolean isLatin(int[][] matrix, int n){
        for(int i=0;i<n;i++){
            boolean[] seen = new boolean[n];
            for(int j=0;j<n;j++){
                if(seen[matrix[i][j]-1]) return false;
                seen[matrix[i][j]-1] = true;
            }
        }
        for(int j=0;j<n;j++){
            boolean[] seen = new boolean[n];
            for(int i=0;i<n;i++){
                if(seen[matrix[i][j]-1]) return false;
                seen[matrix[i][j]-1] = true;
            }
        }
        return true;
    }
    public static boolean isPossible(int ind, int[][] matrix, int n){
        if(ind == n*n){
            return true;
        }
        boolean ans = false;
        int row = ind/n;
        int col = ind%n;
        if(row==col) ans |= isPossible(ind+1,matrix,n);
        else{
            for(int i=1;i<=n;i++){
                boolean canUse = true;
                for(int inRow : matrix[row]){
                    if(inRow == i){
                        canUse = false;
                        break;
                    }
                }
                for(int[] rows : matrix){
                    if(rows[col] == i){
                        canUse = false;
                        break;
                    }
                }
                if(canUse) {
                    matrix[row][col] = i;
                    ans |= isPossible(ind + 1, matrix, n);
                    if (ans) return true;
                    matrix[row][col] = 0;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
//        Reader inputString = new StringReader("2\n" +
//                "3 6\n" +
//                "2 3");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader in = new BufferedReader(inputString);
        String line = "";
        try {
            while ((line = in.readLine())!=null){
                int numc = Integer.parseInt(line);
                for(int c=0;c<numc;c++){
                    String[] lol = in.readLine().split(" ");
                    int n = Integer.parseInt(lol[0]);
                    int k = Integer.parseInt(lol[1]);
                    int[] arr = new int[n];
                    ArrayList<int[]> all = new ArrayList<>();
                    allPos(0,n,0,k,all,arr);
                    boolean pos = false;
                    int[][] sol = new int[n][n];

                    for(int[] z : all){
                        int ind = 0;
                        for(int i=0;i<n;i++){
                            for(int j=0;j<n;j++){
                                sol[i][j] = 0;
                                if(i==j){
                                    sol[i][j] = z[ind++];
                                }
                            }
                        }
                        pos |= isPossible(0,sol,n);
                        if(pos) break;
                    }
                    if(pos){
                        System.out.println("Case #"+(c+1)+":"+" " + "POSSIBLE");
                        for(int[] lok : sol){
                            StringJoiner stringJoiner = new StringJoiner(" ");
                            for(int num : lok){
                                stringJoiner.add(num+"");
                            }
                            System.out.println(stringJoiner.toString());
                        }
                    }
                    else{
                        System.out.println("Case #"+(c+1)+":"+" " + "IMPOSSIBLE");

                    }
                }

            }
        }
        catch (IOException e){}

    }
}


