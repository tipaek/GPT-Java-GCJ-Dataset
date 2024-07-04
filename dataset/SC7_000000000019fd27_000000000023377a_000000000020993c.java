import java.util.*;
class Demo{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int t1=t;
        while(t1!=0){
            int n=sc.nextInt();
        int[][] mat=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j]=sc.nextInt();
            }
        }
        int trace=0;
        
        for(int i=0;i<n;i++){
            trace+=mat[i][i];
        }
        int x=0,c=0;
        for(int i=0;i<n;i++){
            int[] mask=new int[n+1];
            for(int j=0;j<n;j++)
                mask[j]=0;
            for(int j=0;j<n;j++){
                if(mask[mat[i][j]]!=0){
                    x++;
                    break;
                }
                mask[mat[i][j]]++;
            }
        }
        for(int i=0;i<n;i++){
            int[] mask=new int[n+1];
            for(int j=0;j<n;j++)
                mask[j]=0;
            for(int j=0;j<n;j++){
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