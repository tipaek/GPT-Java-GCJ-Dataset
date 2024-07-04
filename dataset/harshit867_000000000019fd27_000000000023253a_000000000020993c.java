import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc= new Scanner(System.in);

        int t=1;

        t= Integer.parseInt(br.readLine());
        int caseNo=1;

        while(caseNo<=t){
            int n=Integer.parseInt(br.readLine());
            int[][] mat = new int[n][n];

            for(int i=0;i<n;i++){
                String[] strArr= br.readLine().split(" ");
                for(int j=0;j<n;j++){
                    int val=Integer.parseInt(strArr[j]);
                    mat[i][j]=val;
                }
            }

            System.out.println(findSolution(mat,n,caseNo));
            caseNo++;
        }

    }

    static String findSolution(int[][] mat, int n,int caseNo){
        String res="Case #"+caseNo+": ";

        int k=0;
        int r=0;
        int c=0;

        for(int i=0;i<n;i++){
            Set<Integer> setRow= new HashSet<>();
            Set<Integer> setColumn= new HashSet<>();

            for(int j=0;j<n;j++){
                if(i==j){
                    k+=mat[i][j];
                }
                setRow.add(mat[i][j]);
                setColumn.add(mat[j][i]);
            }
            if(setRow.size()<n){
                r++;
            }
            if(setColumn.size()<n){
                c++;
            }
        }

        res+=(k+" "+r+" "+c);

        return res;

    }



}

