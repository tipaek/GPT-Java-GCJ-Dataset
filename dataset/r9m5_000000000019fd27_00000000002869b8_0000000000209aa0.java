import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static Scanner src = new Scanner(System.in);

    public static void main(String args[]) {


        int t = src.nextInt();
        src.nextLine();
        int caseNum = 1;
        while (t-- > 0) {
            int n = src.nextInt();
            int k = src.nextInt();

            int m[][] = new int [n][n];
            if(k%n!=0 &&
                    k!=((n*(n+1))/2)){
                print(caseNum,"IMPOSSIBLE");
            }else{
                int middle = 0;
                if(k%n==0  && (k/n) <=n){
                    middle = k/n;
                    for(int i=0;i<n;i++){
                        m[i][i] = middle;
                    }
                }else if(k==((n*(n+1))/2)){
                    for(int i=0;i<n;i++){
                        m[i][i] = i+1;
                    }
                }else{
                    print(caseNum,"IMPOSSIBLE");
                }

                for(int i=0;i<n;i++){
                    for(int j=i+1;j<n;j++){
                        m[j][i] = (m[j-1][i]+1)%n;
                        if(m[j][i]==0)
                            m[j][i] = n;
                    }
                }

                for(int i=0;i<n;i++){
                    for(int j=0;j<n ;j++){
                        if(m[i][j]==0 && i!=j) {
                            int indexRow = i == 0 ? n - 1 : i - 1;
                            int indexCol = j;
                            m[i][j] = (m[indexRow][indexCol] + 1) % n;
                            if (m[i][j] == 0)
                                m[i][j] = n;
                        }
                    }
                }

                if(wrongCol(m)==0 && wrongRow(m)==0) {
                    print(caseNum, "POSSIBLE");
                    printMatrix(m);
                }else{
                    print(caseNum,"IMPOSSIBLE");
                }
            }

            //print(caseNum,ans);
            caseNum++;
        }
    }

    private static void printMatrix(int[][] m) {

        for(int i=0;i<m.length;i++){
            for(int j=0;j<m.length;j++){

                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static String solve(String str) {
        int count = 0;
        StringBuilder ans = new StringBuilder("");
        for(int i=0;i<str.length();i++){
            int ele = Integer.parseInt(str.charAt(i)+"");

            if(count==ele){
                ans.append(ele);
            }else if(count>ele){

                while(count!=ele){
                    ans.append(")");
                    count--;
                }
                ans.append(ele);
            }else{
                while(count!=ele){
                    ans.append("(");
                    count++;
                }
                ans.append(ele);
            }
        }

        while(count>0){
            ans.append(")");
            count--;
        }
        return ans.toString();
    }

    public static void print(int caseNum, String output){

        System.out.println("Case #"+caseNum+": "+output);
    }

    private static int wrongRow(int[][] a) {

        int wrong = 0;
        for(int i=0;i<a.length;i++){
            Set<Integer> set = new HashSet<Integer>();
            for(int j=0;j<a.length;j++){
                if(set.contains(a[i][j])){
                    wrong++;
                    break;
                }
                set.add(a[i][j]);
            }

        }

        return wrong;

    }

    private static int wrongCol(int[][] a) {

        int wrong = 0;
        for(int i=0;i<a.length;i++){
            Set<Integer> set = new HashSet<Integer>();
            for(int j=0;j<a.length;j++){
                if(set.contains(a[j][i])){
                    wrong++;
                    break;
                }
                set.add(a[j][i]);
            }

        }

        return wrong;
    }

}
