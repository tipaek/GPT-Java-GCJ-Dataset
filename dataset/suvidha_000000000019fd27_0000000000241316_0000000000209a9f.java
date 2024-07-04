import java.util.Scanner;

class Solution {

    public static void main(String args[])
    {
        int T,i,j,k;
        Scanner sc=new Scanner(System.in);
        String s[];
        boolean isMatched = false;

        do {
            T=sc.nextInt();
        }while (T<1 || T>100);

        s=new String[T];


        for (i=0;i<T;i++)
        {
            do {
                s[i]=sc.next();
                isMatched = s[i].matches("[0-1]+");
            }while (s[i].length()<1 || s[i].length()>100 || !isMatched);

            for (j=0;j<s[i].length();j++)
            {
                if (s[i].charAt(j)!='0')
                {
                    s[i]=addChar(s[i],'(',j);
                    for (k=j+1;k<s[i].length();k++)
                    {
                        if (s[i].charAt(k)!='1')
                        {
                            s[i]=addChar(s[i],')',k);

                            j=k+1;
                            break;
                        }
                        if(k==(s[i].length()-1))
                        {
                            if(s[i].charAt(k)=='1')
                            {
                                s[i]=addChar(s[i],')',k+1);
                                j=k+1;
                                break;
                            }
                        }
                    }
                }

            }
        }

        for (i=0;i<T;i++)
        {
            System.out.println("Case #"+(i+1)+": "+s[i]);
        }
        System.exit(0);
    }
    public static String addChar(String str, char ch, int position) {
        return str.substring(0, position) + ch + str.substring(position);
    }
}
