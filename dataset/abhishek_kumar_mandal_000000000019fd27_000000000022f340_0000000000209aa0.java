import java.util.*;

public class Solution{
    
public static void main(String []args){
    Scanner sc = new Scanner(System.in);
    int t=sc.nextInt();
    for(int t1=1;t1<=t;t1++){
        int n=Integer.parseInt(sc.next());
        int k=Integer.parseInt(sc.next());
        int []arr = new int[n];
        int [][]mat = new int[n][n];
        HashMap<Integer,ArrayList<Integer>> row = new HashMap();
        HashMap<Integer,ArrayList<Integer>> col = new HashMap();
        int d = (int)(k/3);
        int r = (int)(k%3);
        
        for(int i=0;i<n;i++){
            int u = d;
            if(r>0){
                u++;
                r--;
            }
            arr[i] = u;
            if(row.containsKey(i)){
                ArrayList<Integer> ar = row.get(i);
                ar.add(u);
                row.put(i,ar);
            }
            else{
                ArrayList<Integer> ar3 = new ArrayList();
                ar3.add(u);
                row.put(i,ar3);
            }
            if(col.containsKey(i)){
                ArrayList<Integer> ar1 = col.get(i);
                ar1.add(u);
                col.put(i,ar1);
            }
            else{
                ArrayList<Integer> ar2 = new ArrayList();
                ar2.add(u);
                col.put(i,ar2);
            }
            mat[i][i] = arr[i];
            
        }
        
        int h=0;
        int h1=0;
        int h2=0;
        String ans="";
        int flag = 0;
        for(int i=0; i<n; i++){
            if(flag==1)
            break;
            h=0;
            for(int j=0; j<n; j++){
                TreeSet<Integer> tr = new TreeSet();
                ArrayList<Integer> a1 = col.get(j);
                ArrayList<Integer> a2 = row.get(i);
                for(int b1 : a1){
                    tr.add(b1);
                }
                for(int b2 : a2){
                    tr.add(b2);
                }
                
                h1 = tr.first();
                h2 = tr.last();
                
                
                
                
                
                h=0;
                
                
                if(h1>1){
                    h = (h1-1);
                }
                else{
                     if(h2<n){
                    h = (h2+1);
                }
                }
                
                if(h==0){
                 flag = 1; 
                 break;
                }
                
                if(mat[i][j]==0){
                    mat[i][j] = h;
                }
                
                ArrayList<Integer> ar = row.get(i);
                ar.add(mat[i][j]);
                row.put(i,ar);
                
                ArrayList<Integer> ar1 = col.get(j);
                ar1.add(mat[i][j]);
                col.put(j,ar1);
            
                
                
            }
        }
        
        if(flag==1){
            ans = "IMPOSSIBLE";
        }
        else
        ans = "POSSIBLE";
        
        
        
        
        
        System.out.println("Case #"+t1+": "+ans);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}

}