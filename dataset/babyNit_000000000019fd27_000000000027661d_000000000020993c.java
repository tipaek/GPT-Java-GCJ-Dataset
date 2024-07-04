import java.util.HashSet;
import java.util.Scanner;

class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int mat[][]=new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    mat[i][j]=sc.nextInt();
            find(mat);

        }
    }
    static void find(int[][] mat){
        int ans[]=new int[3];
        int sum=0;
        for(int i=0;i<mat.length;i++)
            sum+=mat[i][i];
        Set<Integer> set=new HashSet<Integer>();
        //check rows
        int count=0;
        for(int i[]:mat){
            int t=0;
            for(int j:i)
                if(!set.add(j))
                    t++;
            if(t>0)
                count++;
            set=new HashSet<Integer>();
        }
        ans[0]=sum;
        ans[1]=count;
        count=0;
        //check columns
        for(int i=0;i<mat.length;i++){
            int t=0;
            for(int j=0;j<mat.length;j++)
                if(!set.add(mat[j][i]))
                    t++;
            if(t>0)
                count++;
            set=new HashSet<Integer>();
        }
        ans[2]=count;
        System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
    }
}