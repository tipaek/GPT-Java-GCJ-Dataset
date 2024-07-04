import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        int caseNo=1;
        while(t>0)
        {
            int n=scanner.nextInt();
            int[] s=new int[n];
            int[] e=new int[n];
            for(int i=0;i<n;i++)
            {
                s[i]=scanner.nextInt();
                e[i]=scanner.nextInt();
            }

            int[] ss=Arrays.copyOf(s,s.length);
            int[] se=Arrays.copyOf(e,e.length);


            for(int i=0;i<ss.length;i++)
            {
                for(int j=i+1;j<se.length;j++)
                {
                    if(ss[i]>ss[j])
                    {
                        int temp=ss[i];
                        ss[i]=ss[j];
                        ss[j]=temp;

                        temp=se[i];
                        se[i]=se[j];
                        se[j]=temp;

                    }
                }
            }

            StringBuilder result=new StringBuilder();
            int[] et=new int[2];
            if(se[0]>ss[1])
            {
                result.append("CJ");
                et[0]=se[0];
                et[1]=se[1];
            }
            else{
                result.append("CC");
                et[0]=se[1];
            }

            for(int i=2;i<n;i++)
            {
                if(ss[i]>=et[0])
                {
                    et[0]=se[i];
                    result.append("C");
                }
                else if(ss[i]>=et[1])
                {
                    et[1]=se[i];
                    result.append("J");
                }
                else{
                    result.delete(0, result.length());
                    result.append("IMPOSSIBLE");
                    break;
                }
            }
            if(result.charAt(0)!='I')
            {
                StringBuilder output=new StringBuilder();
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        if(s[i]==ss[j])
                        {
                            output.append(result.charAt(j));
                            break;
                        }
                    }
                }
                System.out.println("Case #"+caseNo+": "+output);
            }
            else{
                System.out.println("Case #"+caseNo+": "+result);
            }
            caseNo++;
            t--;

        }
    }

}
