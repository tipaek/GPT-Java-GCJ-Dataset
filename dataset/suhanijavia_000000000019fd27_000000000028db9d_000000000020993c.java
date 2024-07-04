

import java.util.Scanner;

public class Codejam1 {

public static void main(String[] args) {
    
    Scanner sc1 = new Scanner(System.in);
        
    int t = sc1.nextInt();
    int in = 0;
    
    for (int it= 0 ;it<t;it++){

        int n = sc1.nextInt();
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[n][n];
        int flagr =0,flagc=0;

        int i,j,rowsum=0,tot,colsum;
        int sum = 0,row=0,col=0;

        for( in =0;in<n;in++){
            String  lines = sc.nextLine();    
            String[] strs = lines.trim().split("\\s+");
            for (int k = 0; k < strs.length; k++) {
                a[in][k] = Integer.parseInt(strs[k]);
            }              
        }
        
        for (i=0;i<n;i++){
            sum=sum+a[i][i];
        }
        tot = ((n)*(n+1))/2;

        for(i=0;i<n;i++){
            flagr=0;
            flagc=0;

            for(j=0;j<n-1;j++){

                for (int k =j+1 ;k<n;k++){
                    if(a[i][k]==a[i][j]){
                        row = row + 1 ;
                        flagr=1;
                    }
                    if(flagr==1){
                        break;
                    }
                }

                for (int k =j+1 ;k<n;k++){
                    if(a[k][i]==a[j][i]){
                        col = col + 1 ;
                        flagc=1;
                    }
                    if(flagc==1){
                        break;
                    }
                }
                if(flagr==1 && flagc==1){
                    break;
                }
            }
        }
        
            System.out.println("Case #"+(it+1)+": "+sum+" "+row+" "+col);
       }

    }
    
}
