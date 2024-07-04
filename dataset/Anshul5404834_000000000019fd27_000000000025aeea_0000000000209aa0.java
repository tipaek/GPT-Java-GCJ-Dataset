import java.lang.*;
import java.util.*;
public class Solution{
    public static int[][] ans;
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int testcase=sc.nextInt();
        for(int i=0;i<testcase;i++){
            System.out.print("Case #"+Integer.toString(i+1)+": ");
            sol(sc.nextInt(),sc.nextInt());
        }
    }
    public static void sol(int n, int k){
        if(k<n||k>n*n){
            System.out.println("IMPOSSIBLE");
        }
        List<List<Integer>> possible=new ArrayList<>();
        dfs(n,k,1,0,new ArrayList<Integer>(),possible);
        int temp=0;
        for(int i=0;i<possible.size();i++){
           if(sol(possible.get(possible.size()-i-1),n)){
               temp=0;
               System.out.print("POSSIBLE");
               break;
           }else{
               temp=1;
           }
        }
        if(temp==1){
            System.out.println("IMPOSSIBLE");
        }
        if(temp==0){
            for(int i=0;i<ans.length;i++){
                System.out.println("");
                for(int j=0;j<ans.length;j++){
                    System.out.print(ans[i][j]);
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        
        
    }
    public static void dfs(int n, int k, int start , int sum, List<Integer> list,List<List<Integer>>possible){
        if(sum==k &&list.size()==n){
            possible.add(new ArrayList<>(list));
        }else if(sum<k&&list.size()<n){
            for(int i=start;i<=n;i++){
                list.add(i);
                dfs(n,k,i,sum+i,list,possible);
                list.remove(list.size()-1);
            }
        }
    }
    public static boolean sol(List<Integer> list, int n){
        ans=new int[n][n];
        List<Integer>content=new ArrayList<>();
        for(int i=0;i<n;i++){
            ans[i][i]=list.get(i);
            content.add(i+1);
        }
        return back(ans,content,0,0);
    }
    public static boolean back(  int[][] canbe , List<Integer> content,  int i , int j){
        if(i==canbe.length){
            return true;
        }
        if(j==canbe.length){
           return back(canbe,content,i+1,0);
        }
        if((i>=0&&j>=0)&&(i<canbe.length&&j<canbe.length)){
                if(canbe[i][j]!=0){
                    return back(canbe,content,i,j+1);
                }
                List<Integer>not=new ArrayList<>(content);
                for(int x=0;x<canbe.length;x++){
                    if(canbe[i][x]!=0){
                        not.remove(new Integer(canbe[i][x]));
                    }
                    if(canbe[x][j]!=0&&not.contains(canbe[x][j])){
                        not.remove(new Integer(canbe[x][j]));
                    }
                }
                
                if(not.size()==0){
                    return false;
                }else{
                    for(int nt=0;nt<not.size();nt++){
                        canbe[i][j]=not.get(nt);
                        if(back(canbe,content,i,j+1)){
                            return true;
                        }
                    }
                }
        }
        return false;
    }
}