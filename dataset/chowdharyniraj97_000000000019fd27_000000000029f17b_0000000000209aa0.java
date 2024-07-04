import java.util.*;
class Solution{
    static boolean found=false;
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int k=0;
        while(t-->0){
          k++;
          found=false;
          int n=sc.nextInt();
          int trace=sc.nextInt();
          generate(n,trace,k);
          
          
          if(!found)
           System.out.println("Case #"+k+": IMPOSSIBLE");
            
            
          
        }
}

    
    static void generate(int n, int k,int itr){
        int ans[][]=new int[n][n];
        
        ArrayList<HashSet<Integer>> col = new ArrayList<HashSet<Integer>>();
        HashSet<Integer>row =new HashSet<>();
        for(int i=0;i<n;i++){
            HashSet<Integer> set=new HashSet<>();
            col.add(set);
        }
        
        
        fill(ans,0,0,-1,row,col,k,itr,0);
    }
    
    static void fill(int ans[][],int i,int j,int val,HashSet<Integer> row,ArrayList<HashSet<Integer>> col,int k,int itr,int ss){
        if(j>=ans.length)
        {
            i++;
            j=0;
            row.clear();
        }
        
        if(i>=ans.length){
            if(findtrace(ans,k))
            {
                found=true;
                 System.out.println("Case #"+itr+": POSSIBLE");
                for(int l=0;l<ans.length;l++){
                    for(int p=0;p<ans.length;p++){
                        System.out.print(ans[l][p]+" ");
                    }
                    System.out.println();
                }
                return;
            }
            return;
        }
            for(int z=1;z<=ans.length;z++){
                    if(!col.get(j).contains(z)){
                        if(!row.contains(z)){
                            ans[i][j]=z;
                            if(i==j){
                            ss+=ans[i][j];
                            if(ss>k)
                                return;
            
                            }
                            row.add(z);
                            col.get(j).add(z);
                            fill(ans,i,j+1,-1,row,col,k,itr,ss);
                            if(found)
                                return;
                            
                            row.remove(z);
                            col.get(j).remove(z);
                        }
                        
                    }
                    
                }
    }

    static boolean findtrace(int ans[][],int k){
        int sum=0;
        for(int i=0;i<ans.length;i++){
                sum+=ans[i][i];
            }
            return sum==k;
        }
        
 }