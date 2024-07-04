import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int nb = sc.nextInt() , w=0;
        int[] res= new int[3*nb];
        while(w<(nb*3)){

            int  n= sc.nextInt();
            res[w]=0;
            res[w+1]=0;
            res[w+2]=0;
            int[][] tab = new int[n][n];

            for(int i=0 ; i<n ; i++) {
                String s = sc2.nextLine();
                String[] s2 = s.split(" ");
                for (int j = 0; j < n; j++) {
                    tab[i][j] = Integer.parseInt(s2[j]);
                }
                res[w] = res[w] + tab[i][i];

                boolean b = false;
                int j=0 , x , z;

                while (b == false && j< n) {
                    x=tab[i][j];
                    z=0;
                    while(b==false && z<n ){
                        if (tab[i][z]==x && z!=j){
                            b=true;
                        }
                        z++;
                    }
                    j++;
                }
                if(b==true){
                    res[w+1]++;
                }
            }

            for(int i=0 ; i<n ;i++ ){
                boolean b = false;
                int j=0 , x , z;
                while (b == false && j< n) {
                    x=tab[j][i];
                    z=0;
                    while(b==false && z<n ){
                        if (tab[z][i]==x && z!=j){
                            b=true;
                        }
                        z++;
                    }
                    j++;
                }
                if(b==true){
                    res[w+2]++;
                }
            }
            w=w+3;
        }
        while(w<(nb*3)){
            System.out.println("Case #"+w+": "+res[w]+" "+res[w+1]+" "+res[w+2]);
            w=w+3;
        }
    }
}