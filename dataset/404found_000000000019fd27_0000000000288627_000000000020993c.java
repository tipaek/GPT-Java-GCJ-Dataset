import java.util.*;
public class Main{
    static Scanner s= new Scanner(System.in);

    public static void main(String[] ar){
    //    Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        for(int i=1;i<=n;i++){
            int m=s.nextInt();
            matrix(i,m);
        }
    }
    public static void matrix(int x,int m){
        int[][] mat=new int[m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
              mat[i][j]=s.nextInt();
            }
        }
        int sum=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<=i;j++){
                if(j==i){
                    sum=sum+a[i][j];
                }
            }
        }
        int r=1,c=1;
       
            for(int j=1;j<m;j++){
                if(mat[0][j-1]==mat[0][j]){
                    r=r+1;
                }
            }
        for(int i=1;i<m;i++){
            if(mat[i-1][0]==mat[i][0]){
                c=c+1;
            }
        }
        if(r==1){
            r=0;
        }
        if(c==1){
            c=0;
        }
        System.out.println("Case #"+x+": "+sum+" "+r+" "+c);
        
    }
}