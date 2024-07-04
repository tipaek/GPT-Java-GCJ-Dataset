import java.util.HashSet;
import java.util.Scanner;
class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++){
            int n=sc.nextInt();
            int grid[][]=new int[n][n];
            int sum=0;
            int rows=0;
            HashSet<Integer> set=new HashSet<>();
            for(int i=0;i<n;i++){
                boolean flag=false;
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                    if(set.size()==0 || !set.contains(grid[i][j])){
                        set.add(grid[i][j]);
                    }
                    else{
                        if(!flag){
                            rows++;
                            flag=true;
                        }
                    }
                    if(i==j){
                        sum+=grid[i][j];
                    }
                }
                set.clear();
            }
            System.out.print("Case #"+k+":"+" "+sum+" "+rows+" ");
            System.out.println(countCol(grid,a));
        }
    }
    static int countCol(int a[][],HashSet<Integer> set){
        int cols=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                if(set.contains(a[j][i])){
                    cols++;
                    break;
                }
                else{
                    set.add(a[j][i]);
                }
            }
            set.clear();
        }
        return cols;
    }
}