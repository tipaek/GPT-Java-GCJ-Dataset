import java.util.Scanner;

public class Codejam {
    static int [][]m;
    static boolean rep(int i,int l,int n){
        if(l==0){
            for (int j = 0; j <(n-1) ; j++) {
                for (int k = j; k <n ; k++) {
                    if (m[i][k] == m[i][j]) return true;
                }
            }
        }else{
            for (int j = 0; j <(n-1) ; j++) {
                for (int k = j; k <n ; k++) {
                    if (m[k][i] == m[j][i]) return true;
                }
            }
        }
        return false;
    }

    static int sm,cpt,cpt2;

    static void Matt(int n){
        sm=0;
        cpt=0;
        cpt2=0;
        for (int i = 0; i <n ; i++) {
            if(rep(i,0,n)){
                cpt++;
            }
            if(!rep(i,5,n)){
                cpt2++;
            }
            sm=sm+m[i][i];

        }

    }


    public static void main(String[] args) {
        int t;
        int n;
        Scanner sc = new Scanner(System.in);
        t=sc.nextInt();
        for (int i = 0; i <t ; i++) {
            n=sc.nextInt();
            m = new int [n][n];
            for (int k = 0; k <n ; k++) {
                for (int j = 0; j <n ; j++) {
                    m[k][j]=sc.nextInt();
                }
            }
        //    System.out.println(Arrays.deepToString(m));

            Matt(n);
            System.out.println("Case #"+(i+1)+": "+sm+" "+cpt+" "+cpt2);

        }

    }
}
