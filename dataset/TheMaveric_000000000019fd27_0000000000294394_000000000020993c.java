import java.util.*;
public class Solution {

    public static void main(String[] args) {
        int x=0,r=0, c=0,i,j,s;
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(x!=t)
        {
            s=in.nextInt();
            int[][] a=new int[s][s];
            int[] chk=new int[s];
            int sum=0;
            for(i=0; i<s; i++){
                for(j=0; j<s; j++){
                    a[i][j]=in.nextInt();
                if(i==j)
                    sum+=a[i][j];
                }
            }
            for(i=0; i<s; i++){
                chk[i]=i+1;
            }
            for(i=0; i<s; i++){
                int[] carr=new int[s];
                for(j=0; j<s; j++)
                    carr[j]=a[j][i];
                Arrays.sort(carr);
                if(Arrays.equals(chk,carr)==false)
                    c++;
            }
            for(i=0; i<s; i++){
                int[] rarr=new int[s];
                for(j=0; j<s; j++)
                    rarr[j]=a[i][j];
                Arrays.sort(rarr);
                if(Arrays.equals(chk,rarr)==false)
                    r++;
            }
            System.out.println("Case #"+(++x)+": "+sum+" "+r+" "+c);
        }
    }
}