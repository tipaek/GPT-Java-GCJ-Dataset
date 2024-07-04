import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int k=0;
        while(t-->0){
        k++;
            int n=sc.nextInt();
            ArrayList<Set<Integer>> row=new ArrayList<Set<Integer>>();
            ArrayList<Set<Integer>> col = new ArrayList<Set<Integer>>();
            int mat[][]=new int[n][n];
            int sum=0;
            for(int i=0;i<n;i++){
                row.add(new HashSet<Integer>());
                col.add(new HashSet<Integer>());
            }
            for(int i=0;i<n;i++){
                
                for(int j=0;j<n;j++){
                    int val=sc.nextInt();
                    mat[i][j]=val;
                    row.get(i).add(val);
                    col.get(j).add(val);
                    if(i==j) sum+=val;
                }
            }
            int rowsum=0,colsum=0;
            for(int i=0;i<row.size();i++){
                if(row.get(i).size()!=n){
                    rowsum++;
                }
                if(col.get(i).size()!=n){
                    colsum++;
                }
            }
            
            System.out.println("Case #"+k+": "+sum+" "+rowsum+" "+colsum);
            
        }
    }
}