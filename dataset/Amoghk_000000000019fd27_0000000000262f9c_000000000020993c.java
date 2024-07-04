import java.util.*;
class Vestigium{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++){
            int n = s.nextInt();
            int a[][] = new int[n][n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    a[j][k] = s.nextInt();
                }
            }
            int sumdia = 0;
            for(int j=0;j<n;j++){
                sumdia += a[j][j];
            }
            int row = 0, col = 0;

            for(int j=0;j<n;j++){
                ArrayList<Integer> forrow = new ArrayList<Integer>();
                for(int k=0;k<n;k++){
                    if(forrow.contains(a[j][k])){
                        row++;
                        break;
                    }
                    forrow.add(a[j][k]);
                }
                ArrayList<Integer> forcol = new ArrayList<Integer>();
                for(int k=0;k<n;k++){
                    if(forcol.contains(a[k][j])){
                        col++;
                        break;
                    }
                    forcol.add(a[k][j]);
                }
            }
            System.out.println(sumdia+" "+row+" "+col);
        }
    }
}
