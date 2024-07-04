import java.util.*;
class CJ20201A{
    static int[] calculate(int[][] mat,int N){
        int[] cr=new int[N];
        int[] cc=new int[N];
        int row=0;
        int col=0;
        boolean [] r=new boolean[N];
        boolean [] c=new boolean[N];
        for(int p=0;p<N;p++){
        	r[p]=true;
        	c[p]=true;
        }
        int tr=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                cr[j]=0;
                cc[j]=0;
            }
            for(int j=0;j<N;j++){
                cr[mat[i][j]-1]++;
                cc[mat[j][i]-1]++;
                if(cr[mat[i][j]-1]>1 && r[i]){
                    row++;
                    r[i]=false;
                }
                if(cc[mat[j][i]-1]>1 && c[i]){
                    col++;
                    c[i]=false;
                }
                if(i==j){
                    tr+=mat[i][j];
                }
            }
        }
        int[] ret={tr,row,col};
        return ret;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int t=Integer.parseInt(in.nextLine());
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(in.nextLine());
            int[][] m=new int[n][n];
            for(int p=0;p<n;p++){
                StringTokenizer s=new StringTokenizer(in.nextLine());
                for(int q=0;q<n;q++){
                    m[p][q]=Integer.parseInt(s.nextToken());
                }
            }
            int[] tao=calculate(m,n);
            System.out.println("Case #"+(i+1)+": "+tao[0]+" "+tao[1]+" "+tao[2]);
        }
}
}