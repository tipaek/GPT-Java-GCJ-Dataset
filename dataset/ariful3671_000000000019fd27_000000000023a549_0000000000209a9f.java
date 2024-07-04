import java.util.Scanner;

class Solution {

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        scanner.nextLine();
        int caseNo=1;
        while (t>0)
        {
            String s=scanner.nextLine();
            StringBuilder result=new StringBuilder();
            for(int i=0;i<s.length();i++)
            {
                int n1= (int) s.charAt(i)-48;
                if(i==0)
                {
                    for(int j=0;j<n1;j++)
                    {
                        result.append("(");
                    }
                }
                result.append(s.charAt(i));
                if(i+1!=s.length())
                {
                    int n2= (int) s.charAt(i+1)-48;
                    if(n1<n2)
                    {
                        for(int j=0;j<n2-n1;j++)
                        {
                            result.append("(");
                        }
                    }
                    if(n1>n2)
                    {
                        for(int j=0;j<n1-n2;j++)
                        {
                            result.append(")");
                        }
                    }
                }
                else{
                    for(int j=0;j<n1;j++)
                    {
                        result.append(")");
                    }
                }
            }
            System.out.println("Case #"+caseNo+": "+result.toString());
            caseNo++;
            t--;
        }
    }

}
