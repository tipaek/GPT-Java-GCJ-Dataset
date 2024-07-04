import java.util.*;
public class Solution{
    public static ArrayList<String> list;
    public static int triangle[][];
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        triangle=new int[501][501];
        
        for(int i=0;i<501;i++){
            for(int j=0;j<=i;j++){
                triangle[i][j]=biCoeff(i,j);
            }
        }
        int test=sc.nextInt();
        for(int t=1;t<=test;t++){
            list=new ArrayList<>();
            int rem=sc.nextInt();
            boolean ans=printAns(rem,0,0);
            System.out.println("Case #"+t+": ");
            for(String s:list)
            System.out.println(s);
        }
    }
    public static int biCoeff(int n,int k){
        int  ans=1;
        if(k>n-k)
        k=n-k;
        for(int i=0;i<k;i++){
            ans*=(n-i);
            ans/=(i+1);
        }
        return ans;
    }
    public static boolean printAns(int rem,int r,int c){
        if(rem==0){
           return true;
        }
        if(r>=0&&r<501&&c>=0&&c<501&&triangle[r][c]!=0){
            int dr={1,1,0,0,-1,-1};
            int dc={0,1,-1,1,0,-1};
            for(int i=0;i<6;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nr<501&&nc>=0&&nc<501&&triangle[nr][nc]!=0&&triangle[nr][nc]<=rem){
                    if(printAns(rem-triangle[nr][nc],nr,nc)){
                        list.add(Integer.toString(nr)+" "+Integer.toString(nc));
                        return true;
                    }
                }
            }
            return false;
            
        }else{
            return false;
        }
    }
}