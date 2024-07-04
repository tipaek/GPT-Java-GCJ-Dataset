import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
    public static void main(String arg[])
    {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = scan.nextInt();




        for (int t=1; t<=testCase;t++)
        {
            int N =scan.nextInt();
            int matrics[][] =new int[N][2];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<2;j++)
                {
                    matrics[i][j]= scan.nextInt();
                }
            }

            StringBuilder sb = new StringBuilder();
            int brk=0;
            for(int i =0 ;i<N;i++)
            {
                if(matrics[i][0]>matrics[i][1])
                {
                    sb = new StringBuilder("IMPOSSIBLE");
                    break;
                }
                if(sb.length()==0)
                {
                    sb.append('C');
                    continue;
                }
                int ca=0,ja=0;
                int num1 = matrics[i][0];
                int num2 = matrics[i][1];

                char c ='C';
                for(int j=0;j<i;j++)
                {

                    if(num1>=matrics[j][0] && num1<matrics[j][1])
                    {
                        brk++;
                        if(sb.charAt(j)=='C') {
                            c = 'J';
                            ca++;
                        }else {
                            c = 'C';
                            ja++;
                        }
                    }

                    else if(matrics[j][0]>=num1 && matrics[j][0]<num2)

                    {
                        brk++;
                        if(sb.charAt(j)=='C') {
                            c = 'J';
                            ca++;
                        }
                        else {
                            c = 'C';
                            ja++;
                        }
                    }
                }
                if((brk>1)&&(ca>0 && ja>0))
                {
                    sb = new StringBuilder("IMPOSSIBLE");
                    break;
                }
                sb.append(c);
                brk=0;


            }

            System.out.println("Case #"+t+": "+sb);

        }
    }
}