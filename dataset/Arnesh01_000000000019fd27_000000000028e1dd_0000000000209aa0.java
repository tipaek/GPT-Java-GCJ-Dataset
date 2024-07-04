import java.io.*;
import java.lang.*;
import java.util.*;
public class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        for(int t=1;t<=T;t++){
            String str[]=br.readLine().split(" ");
            int N=Integer.parseInt(str[0]);
            int K=Integer.parseInt(str[1]);
            StringBuffer ans=new StringBuffer();
            if(N==2){
                if(K==2) ans.append("POSSIBLE\n1 2\n2 1\n");
                else if(K==3) ans.append("IMPOSSIBLE\n");
                else ans.append("POSSIBLE\n2 1\n1 2\n");
            }
            else if(N==3){
                if(K==3) ans.append("POSSIBLE\n1 2 3\n3 1 2\n2 3 1\n");
                else if(K==4) ans.append("IMPOSSIBLE\n");
                else if(K==5) ans.append("IMPOSSIBLE\n");
                else if(K==6) ans.append("POSSIBLE\n3 1 2\n1 2 3\n2 3 1\n");
                else if(K==7) ans.append("IMPOSSIBLE\n");
                else if(K==8) ans.append("IMPOSSIBLE\n");
                else ans.append("POSSIBLE\n3 1 2\n2 3 1\n1 2 3\n");
            }
            else if(N==4){
                if(K==4) ans.append("POSSIBLE\n1 2 3 4\n4 1 2 3\n3 4 1 2\n2 3 4 1\n");
                else if(K==5) ans.append("IMPOSSIBLE\n");
                else if(K==6) ans.append("POSSIBLE\n1 2 3 4\n2 1 4 3\n3 4 2 1\n4 3 1 2\n");
                else if(K==7) ans.append("POSSIBLE\n1 2 3 4\n3 1 4 2\n4 3 2 1\n2 4 1 3\n");
                else if(K==8) ans.append("POSSIBLE\n2 3 4 1\n1 2 3 4\n4 1 2 3\n3 4 1 2\n");
                else if(K==9) ans.append("POSSIBLE\n1 4 2 3\n3 1 4 2\n4 2 3 1\n2 3 1 4\n");
                else if(K==10) ans.append("POSSIBLE\n1 4 2 3\n4 1 3 2\n2 3 4 1\n3 2 1 4\n");
                else if(K==11) ans.append("POSSIBLE\n4 1 3 2\n2 4 1 3\n1 3 2 4\n3 2 4 1\n");
                else if(K==12) ans.append("POSSIBLE\n3 4 1 2\n2 3 4 1\n1 2 3 4\n4 1 2 3\n");
                else if(K==13) ans.append("POSSIBLE\n4 3 1 2\n2 4 3 1\n3 1 2 4\n1 2 4 3\n");
                else if(K==14) ans.append("POSSIBLE\n3 4 1 2\n4 3 2 1\n1 2 4 3\n2 1 3 4\n");
                else if(K==15) ans.append("IMPOSSIBLE\n");
                else ans.append("POSSIBLE\n4 1 2 3\n3 4 1 2\n2 3 4 1\n1 2 3 4\n");
            }
            else if(N==5){
                if(K==5) ans.append("POSSIBLE\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n");
                else if(K==10) ans.append("POSSIBLE\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n");
                else if(K==15) ans.append("POSSIBLE\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n");
                else if(K==20) ans.append("POSSIBLE\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n");
                else if(K==25) ans.append("POSSIBLE\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n");
                else if(K==6||K==24) ans.append("IMPOSSIBLE\n");
                else if(K==7) ans.append("POSSIBLE\n1 2 3 4 5\n5 1 2 3 4\n2 4 1 5 3\n3 5 4 2 1\n4 3 5 1 2\n");
                else if(K==23) ans.append("POSSIBLE\n5 4 3 2 1\n1 5 4 3 2\n4 2 5 1 3\n3 1 2 4 5\n2 3 1 5 4\n");
                else if(K==8) ans.append("POSSIBLE\n2 1 3 4 5\n5 2 1 3 4\n1 4 2 5 3\n3 5 4 1 2\n4 3 5 2 1\n");
                else if(K==22) ans.append("POSSIBLE\n4 5 3 2 1\n1 4 5 3 2\n5 2 4 1 3\n3 1 2 5 4\n2 3 1 4 5\n");
                else if(K==9) ans.append("POSSIBLE\n1 3 2 4 5\n5 1 3 2 4\n3 4 1 5 2\n2 5 4 3 1\n4 2 5 1 3\n");
                else if(K==21) ans.append("POSSIBLE\n5 3 4 2 1\n1 5 3 4 2\n3 2 5 1 4\n4 1 2 3 5\n2 4 1 5 3\n");
                else if(K==11) ans.append("POSSIBLE\n1 4 3 2 5\n5 1 4 3 2\n4 2 1 5 3\n3 5 2 4 1\n2 3 5 1 4\n");
                else if(K==19) ans.append("POSSIBLE\n5 2 3 4 1\n1 5 2 3 4\n2 4 5 1 3\n3 1 4 2 5\n4 3 1 5 2\n");
                else if(K==13) ans.append("POSSIBLE\n1 5 3 4 2\n2 1 5 3 4\n5 4 1 2 3\n3 2 4 5 1\n4 3 2 1 5\n");
                else if(K==17) ans.append("POSSIBLE\n5 1 3 2 4\n4 5 1 3 2\n1 2 5 4 3\n3 4 2 1 5\n2 3 4 5 1\n");
                else if(K==12) ans.append("POSSIBLE\n2 3 1 4 5\n5 2 3 1 4\n3 4 2 5 1\n1 5 4 3 2\n4 1 5 2 3\n");
                else if(K==18) ans.append("POSSIBLE\n4 3 5 2 1\n1 4 3 5 2\n3 2 4 1 5\n5 1 2 3 4\n2 5 1 4 3\n");
                else if(K==14) ans.append("POSSIBLE\n2 4 3 1 5\n5 2 4 3 1\n4 1 2 5 3\n3 5 1 4 2\n1 3 5 2 4\n");
                else ans.append("POSSIBLE\n4 2 3 5 1\n1 4 2 3 5\n2 5 4 1 3\n3 1 5 2 4\n5 3 1 4 2\n");
            }
            else{
                int[][] arr=new int[N][N];
                int[][] visitedRow=new int[N][N];
                int[][] visitedCol=new int[N][N];
                boolean a=check(arr,N,0,0,K,visitedRow,visitedCol);
                if(a) ans.append("POSSIBLE\n");
                else ans.append("IMPOSSIBLE\n");
                if(a){
                    for(int i=0;i<N;i++){
                        for(int j=0;j<N;j++){
                            ans.append(arr[i][j]+" ");
                        }
                        ans.append("\n");
                    }
                }
            }
            sb.append("Case #"+t+": "+ans);
        }
        System.out.println(sb);
    }
    public static boolean check(int[][] arr,int n,int row,int col,int k,int[][] visitedRow,int[][] visitedCol){
        if(col==0 && row>=n){
            int trace=0;
            for(int i=0,j=0;i<n && j<n;i++,j++){
                trace+=arr[i][j];
            }

            if(trace==k){
                return true;
            }
            else{
                return false;
            }
        }
        if(col>=n){
            boolean x=check(arr,n,row+1,0,k,visitedRow,visitedCol);
            if(x==true){
                return true;
            }
            else{
                return false;
            }
        }
        for(int i=1;i<=n;i++){
            if(visitedRow[row][i-1]==0 && visitedCol[col][i-1]==0){
                visitedRow[row][i-1]=1;
                visitedCol[col][i-1]=1;
                arr[row][col]=i;
                boolean x=check(arr,n,row,col+1,k,visitedRow,visitedCol);
                if(x==true){
                    return true;
                }
                arr[row][col]=0;
                visitedRow[row][i-1]=0;
                visitedCol[col][i-1]=0;
            }
        }
        return false;
    }
}