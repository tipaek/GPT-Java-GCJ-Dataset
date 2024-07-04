
import java.util.Scanner;

public class Solution
{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int tc = sc.nextInt();sc.nextLine();
        //int tc =1;

        for (int t = 1; t <= tc; t++) {

            int N = sc.nextInt();
            //int N=5;

            int acti[][] = new int[N][2];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 2; j++) {
                    acti[i][j] = sc.nextInt();
                }
            }



          /* acti[0][0]= 99;
            acti[0][1]= 150;
            acti[1][0]= 1;
            acti[1][1]=100 ;
            acti[2][0]=100 ;
            acti[2][1]= 301;
            acti[3][0]= 2;
            acti[3][1]= 5;
            acti[4][0]= 150;
            acti[4][1]= 250;

*/
          //  boolean possibility = true;
            int minutesofC[]=new int[24*60+1];
            int minutesofJ[]=new int[24*60+1];
            for(int i = 0 ; i < minutesofC.length ; i++)
            {
                minutesofC[i]=0;
                minutesofJ[i]=0;
            }

            int fs=acti[0][0];
            int fe = acti[0][1];
            String ans = "";
            for(int j = fs ; j<fe;j++)
            {
                minutesofC[j]='C';                     //first kama C ku diahela
            }
            ans=ans+"C";

            for (int i = 1; i < N; i++)
            {

                    int S=acti[i][0];
                    int E=acti[i][1];

                   // boolean c_khaliachi ;
                    //boolean j_khaliachi;
                    int sum_in_c = 0;
                    int sum_in_j = 0;
                    for(int j = S ; j<E;j++)
                    {
                       sum_in_c=sum_in_c+minutesofC[j];
                    }
                    for(int j = S ; j<E;j++)
                    {
                       sum_in_j=sum_in_j+minutesofJ[j];
                    }

                    if(sum_in_c==0)
                    {
                        for(int j = S ; j<E;j++)
                        {
                            minutesofC[j]='C';
                        }
                        ans=ans+"C";
                    }
                    else if(sum_in_j==0)
                    {
                        for(int j = S ; j<E;j++)
                        {
                            minutesofJ[j]='J';
                        }
                        ans=ans+"J";
                    }
                    else
                    {
                        ans="IMPOSSIBLE";
                        break;
                    }

            }

            System.out.println("Case #"+t+": "+ans);

        }

    }
}