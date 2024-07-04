import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[][] mat=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j]=sc.nextInt();
                }
            }
            int row=0,col=0,dig=0;
            HashMap<Integer,Integer> hsc=new HashMap<Integer,Integer>();
            HashMap<Integer,Integer> hsr=new HashMap<Integer,Integer>();
            for(int i=0;i<n;i++){
                int r=0,c=0;
                
                for(int j=0;j<n;j++){
                    if(i==j) dig=dig+mat[i][j];
                    if((hsc.get(mat[j][i]))==null) hsc.put(mat[j][i],0);
                    else c++;
                    if((hsr.get(mat[i][j]))==null) hsr.put(mat[i][j],0);
                    else r++;
                }
                if(r!=0) row++;
                if(c!=0) col++;
                hsr.clear();
                hsc.clear();
            }
            System.out.print(dig+" "+row+" "+col+"\n");
            
        }
    }
}