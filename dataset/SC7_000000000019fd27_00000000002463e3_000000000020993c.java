import java.util.*;
class Solution{
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int t1=t;
        System.out.println(t);
        while(t1!=0){
            int n=sc.nextInt();
        int[][] mat=new int[n][n];
        int i,j;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                mat[i][j]=sc.nextInt();
            }
        }
        int trace=0;
        
        for(i=0;i<n;i++){
            trace+=mat[i][i];
        }
        System.out.println(trace);
        int x=0,c=0;
        for(i=0;i<n;i++){
            int[] mask=new int[n+1];
            for(j=0;j<n;j++)
                mask[j]=0;
            for(j=0;j<n;j++){
                if(mask[mat[i][j]]!=0){
                    x++;
                    break;
                }
                mask[mat[i][j]]++;
            }
        }
        for(i=0;i<n;i++){
            int[] mask=new int[n+1];
            for(j=0;j<n;j++)
                mask[j]=0;
            for(j=0;j<n;j++){
                if(mask[mat[j][i]]!=0){
                    c++;
                    break;
                }
                mask[mat[j][i]]++;
            }
        }
        System.out.println("Case #"+(t-t1+1)+": "+trace+" "+x+" "+c);
        t1--;
        }
    }
}