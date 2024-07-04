import java.util.*;
class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int tc = sc.nextInt();sc.nextLine();
        

        for (int t = 1; t <= tc; t++) {

            int N = sc.nextInt();
            

            int acti[][] = new int[N][2];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 2; j++) {
                    acti[i][j] = sc.nextInt();
                }
            }



         
            int minutesofC[]=new int[24*60];
            int minutesofJ[]=new int[24*60];
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
                minutesofC[j]='C';
            }
            ans=ans+"C";

            for (int i = 1; i < N; i++)
            {


                    int S=acti[i][0];
                    int E=acti[i][1];

                   
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