import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int[][] ti =new int[n][2];
            for(int j=0;j<n;j++){
                for(int k=0;k<2;k++){
                    ti[j][k]=in.nextInt();
                }
            }
            int[][] overl = new int[n*n+1][2];
            int c=0;
            for(int j=0;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if((ti[j][1]>ti[k][0]&&ti[j][1]<ti[k][1])||(ti[k][1]>ti[j][0]&&ti[j][0]>ti[k][0])
                            ||(ti[k][1]<=ti[j][1] && ti[k][0]>=ti[j][0])||(ti[k][1]>=ti[j][1]&&ti[k][0]<=ti[j][0])){
                        overl[c][0]=j;
                        overl[c][1]=k;
                        c++;
                    }
                }
            }
            char[] ans = new char[n];
            for(int j=0;j<n;j++)ans[j]='C';
//            int c1 =0;
//            while(c1!=c){
//                System.out.println(overl[c1][0]+" "+overl[c1][1]);
//                c1++;
//            }
            int c1=0;
//            int p2 = nCr(n,2);
            boolean chk=false;
            while(c1!=c){
                int a =overl[c1][0];
                int b =overl[c1][1];
                if(ans[a]==ans[b]){
                    if(ans[a]=='C')ans[b]='J';
                    else {
                        ans[b]='C';
//                        System.out.println('x');
                        chk=true;
                    }
                }
//                else chk=true;
                c1++;
            }
            String ans1="";
            for(int j=0;j<n;j++)ans1+=ans[j];
            if(chk){
                System.out.println("Case"+" "+ "#"+(i+1)+":" + " "+"IMPOSSIBLE");
//                System.out.println();
            }   else
            System.out.println("Case"+" "+ "#"+(i+1)+":" + " "+ans1);
//            System.out.println();
        }
    }
}
