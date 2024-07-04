import java.util.Scanner;
public class MainClass1 {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0)
        {
            int n = scan.nextInt();
            int[][] a = new int[n][n];
            int dia=0;
            int[] r = new int[n];
            int[] c = new int[n];
            int row = 0;
            int col = 0;
            int sum = 0;
            int n1 = n;
            while(n1>0){
                sum = sum+n1;
                n1--;
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j] = scan.nextInt();
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j){
                        dia = dia+a[i][j];
                    }
                }
            }
            int m=0;
            while(m<n){
            for(int i=0;i<n;i++)
            {
                r[m] = r[m]+a[m][i];
            }
            if(r[m] != sum){
                row++;
            }
            else{
                int f = 0;
                while(f<n-1){
                    if(a[m][f] == a[m][f+1]){
                        row++;
                        break;
                    }
                    else{
                    f++;}
                }
            }
            m++;
            }
            int m1 = 0;
            while(m1<n){
                for(int i=0;i<n;i++){
                    c[m1] = c[m1] + a[i][m1];
                }
                if(c[m1] !=sum){
                    col++;
                }
                else{
                    int f1 = 0;
                    while(f1<n-1){
                        if(a[f1][m1] == a[f1+1][m1]){
                            col++;
                            break;
                        }
                        else{
                            f1++;
                        }
                    }
                }
                m1++;
            }
            System.out.print(dia + "  " + row + "  " + col);
            t--;
        }
    }
}
