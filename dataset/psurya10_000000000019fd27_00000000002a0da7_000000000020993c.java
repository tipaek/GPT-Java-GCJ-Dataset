import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int q=0;q<t;q++) {
            int n=sc.nextInt();
            int k=0,r=0,c=0;
            int[][] a=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++) {
                	a[i][j]=sc.nextInt();
                }
            }
            for(int i=0;i<n;i++){
            	Set<Integer> set = new HashSet<Integer>();
                for(int j=0;j<n;j++) {
                	set.add(a[i][j]);
                	if(i==j) {
                		k+=a[i][j];
                	}
                }
                if(set.size()!=n) {
                	r++;
                }
            }
            for(int i=0;i<n;i++){
            	Set<Integer> set = new HashSet<Integer>();
                for(int j=0;j<n;j++) {
                	set.add(a[j][i]);
                }
                if(set.size()!=n) {
                	c++;
                }
            }
            System.out.println("Case #"+q+":"+" "+k+" "+r+" "+c);
        }
    }
}