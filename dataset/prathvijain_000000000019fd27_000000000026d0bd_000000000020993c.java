import java.util.*;

class Solution{
    public static void main(String a[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int n=sc.nextInt();
        int cr=0;
        int cc=0;
        int l=0;
        int s=0;
        int[][] m=new int[n][n];
        for(int i=0;i<t;i++){
            for (int r = 0; r < n; r++) {
			    for (int c = 0; c < n; c++) {
				m[r][c] = sc.nextInt();
			    }
		    }
		     for (int r = 0; r < n; r++) {
			    for (int c = 0; c < n; c++) {
				        if(m[r][l]==m[r][c]){
                  cr++;
                  break;
                }
                if(c==n-1){
                  l++;
                  c=l;
                }
			    }
		    }
        l=0;
        for (int r = 0; r < n; r++) {
         for (int c = 0; c < n; c++) {
               if(m[l][r]==m[c][r]){
                 cc++;
                 break;
               }
               if(c==n-1){
                 l++;
                 c=l;
               }
         }
       }
       for(int r=0;r<n;r++){
         s+=m[r][r];
       }
       for(int i=1;i<=t;i++){
         System.out.println("Case #"+i+": "+s+" "+cr+" "+cc);
       }
        }
      
    }
}
