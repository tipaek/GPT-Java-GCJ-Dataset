import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution1{
    public static void main(String[] args){
        int t,n;
        String str;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        while(t!=0){
            n=in.nextInt();
            int trace=0;
            int r=0,c=0;
            int[][] m = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    m[i][j]=in.nextInt();

            }
            for(int i=0;i<n;i++){
                trace+=m[i][i];
            }
            Set<Integer> s;
            for(int i=0;i<n;i++){
                s = new HashSet<>();
                for(int j=0;j<n;j++){
                    if(s.contains(m[i][j])){
                        r++;
                        break;
                    }
                    else s.add(m[i][j]);
                }
            }
            for(int i=0;i<n;i++){
                s = new HashSet<>();
                for(int j=0;j<n;j++){
                    if(s.contains(m[j][i])){
                        c++;
                        break;
                    }
                    else s.add(m[j][i]);
                }
            }
            System.out.println(trace + " " + r + " " + c);
            t--;
        }
    }

}