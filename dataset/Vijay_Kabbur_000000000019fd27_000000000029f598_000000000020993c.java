import java.util.Scanner;
class Solution{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i, j, k, z, r, rr, cr, e, sum, n;
        int[][] m = new int[100][100];
        for(i=1;i<=t;i++){
            n = sc.nextInt();
            sum = 0;
            for(j=0;j<n;j++)
                for(k=0;k<n;k++)
                    m[j][k] = sc.nextInt();
            for(j=0;j<n;j++)
                sum += m[j][j];
            rr = 0;
            cr = 0;
            for(j=0;j<n;j++){
                r = 0;
                for(k=0;k<n;k++){
                    if(r>0)
                        break;
                    e = m[j][k];
                    for(z=0;z<n;z++)
                        if(z!=k && e==m[j][z]){
                            rr++;
                            r = 1;
                            break;
                        }
                }
            }
            for(j=0;j<n;j++){
                r = 0;
                for(k=0;k<n;k++){
                    if(r>0)
                        break;
                    e = m[k][j];
                    for(z=0;z<n;z++)
                        if(z!=k && e==m[z][j]){
                            cr++;
                            r = 1;
                            break;
                        }
                }
            }
            System.out.println("Case #"+i+": "+sum+" "+rr+" "+cr);
        }
    }
}