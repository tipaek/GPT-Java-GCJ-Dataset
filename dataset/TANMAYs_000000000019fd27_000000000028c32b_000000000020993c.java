import java.util.*;

public class Solution{
    
    public static String fun(int a[][],int n, int x){
    	//System.out.println("x="+x);
        long k=0, r=0, c=0;
        HashSet<Integer> hs[] = new HashSet[n];
        for (int j=0; j<n; j++){
            hs[j]=new HashSet();
        }
        //long b[] = new long[n];
        boolean flag[] = new boolean[n];
        for (int i=0; i<n; i++){
        	//System.out.println("i");
            boolean f = false;
            HashSet<Integer> hs1 = new HashSet();
            //long b1=0;
            k=k+((long)a[i][i]);
            for (int j=0; j<n; j++){
                //System.out.println("i="+i+", j="+j);
                if (!f){
                	//System.out.println(".........");
                    if (hs1.contains(a[i][j])){
                        f=true;
                        r++;
                    }
                    else{
                        hs1.add(a[i][j]);
                    }
                }
                if (!flag[j]){
                	//System.out.println("**********");
                    if (hs[j].contains(a[i][j])){
                        flag[j]=true;
                        c++;
                    }
                    else{
                        hs[j].add(a[i][j]);
                    }
                }
            }
        }
        return "Case #"+x+": "+k+" "+r+" "+c;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t=1; t<=test; t++){
            if (t!=0)
                System.out.println();
            
            int n = sc.nextInt();
            int a[][] = new int[n][n];
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++)
                    a[i][j] = sc.nextInt();
            }
            System.out.print(fun(a, n, t));
        }
        
    }
}