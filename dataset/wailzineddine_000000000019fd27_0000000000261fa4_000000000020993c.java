import java.util.Scanner;
class Mat{
    static int t=1;
    Mat(int n){
        int sm=0;
        Scanner sc =new Scanner(System.in);
        int cpt=0,cpt2=0;
        int[][] m = new int [n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                m[i][j]=sc.nextInt();
            }
        }
        for (int i = 0; i <n ; i++) {
            if(rep(m,i,0,n)){
                cpt++;
            }
            if(!rep(m,i,1,n)){
                cpt2++;
            }
            sm=sm+m[i][i];

        }
        System.out.println("Case #" +t+": "+sm+" "+cpt+" "+cpt2);
        t++;
    }
    boolean rep(int[][] m,int i,int l,int n){
        if(l==0){
            for (int j = 0; j <(n-1) ; j++) {
                for (int k = 0; k <j+1 ; k++) {
                    if (m[i][k] == m[i][j]) return true;
                }
            }
        }else{
            for (int j = 0; j <(n-1) ; j++) {
                for (int k = 0; k <j+1 ; k++) {
                    if (m[k][i] == m[j][i]) return true;
                }
            }
        }
        return false;
    }
}
public class Codejam {
    public static void main(String[] args) {
        int t;
        int n;
        Scanner sc = new Scanner(System.in);
        t=sc.nextInt();
        n=sc.nextInt();
        for (int i = 0; i <t ; i++) {
            Mat mat=new Mat(n);
        }

    }
}