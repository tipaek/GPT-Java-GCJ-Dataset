import java.util.*;

public class Solution{

    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int b = in.nextInt();

        for (int i=1;i<=t;i++ ){
            int[] bits=new int[b];
            for(int j=1;j<=b;j++) {
                System.out.println(j);
                bits[j-1]=in.nextInt();
            }
            String ans="";
            for (int j=0;j<b;j++){
                ans=ans+bits[j];
            }
            System.out.println(ans );
            String resp =in.next();
            if(resp=="N"){
                break;
            }
        }
    }
}