import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i,j,b=0;
        int t=in.nextInt();
        while(b!=t){
            int r=0, c=0,sum=0;
            int n=in.nextInt();
            int[][] arr=new int[n][n];
            for(i=0; i<n; i++){
                for(j=0; j<n; j++){
                    arr[i][j]=in.nextInt();
                if(i==j)
                sum+=arr[i][j];
                }
            }
            
            int[] chk=new int[n];
            for(i=0; i<n; i++){
                chk[i]=i+1;
            }
            for(i=0; i<n; i++){
                int[] rowarr=new int[n];
                for(j=0; j<n; j++){
                    rowarr[j]=arr[i][j];
                }
                Arrays.sort(rowarr);
                if(!Arrays.equals(chk,rowarr))
                    r++;
            }
            for(i=0; i<n; i++){
                int[] colarr=new int[n];
                for(j=0; j<n; j++){
                    colarr[j]=arr[j][i];
                }
                Arrays.sort(colarr);
                if(!Arrays.equals(chk,colarr))
                    c++;
            }

            System.out.println("Case #"+(b++)+": "+sum+" "+r+" "+c);
        }
    }
}