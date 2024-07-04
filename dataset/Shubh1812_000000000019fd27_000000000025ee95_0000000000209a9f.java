import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution{
    private static Scanner sc;
    static int t=1;
    
    public static void main(String []args)
    {
        sc=new Scanner (System.in);
        int test=sc.nextInt();
        sc.nextLine();
        while(test-- >0)
        {
            nesting();
        }
    }

    private static void nesting()
    {
        String str=sc.nextLine();
        StringBuilder strb=new StringBuilder();
        char [] ch=str.toCharArray();

        int num=0;
        int brc=0;
        int fst=Character.getNumericValue(ch[0]);
        num=fst;
        brc=fst;
        //int i;
        for(int i=0;i<fst;i++){
          strb.append('(');
      }
      strb.append(fst);          
         for(int i=1;i<ch.length;i++)
         {
            int dd =Character.getNumericValue(ch[i]);
            if(dd==num)
            {
                strb.append(dd);
            }else if(dd>num){
                int di=dd-num;
                for(int j=0;j<di;j++)
                {
                    strb.append('(');
                    brc++;
                }
                strb.append(dd);
            }
            else
            {
                int di=num-dd;
                for(int j=0;j<di;j++)
                {
                    strb.append(')');
                    brc--;
                }
                //strb.append(')');
                strb.append(dd);
               // brc-=(num-dd);
            }
            num=Character.getNumericValue(ch[i]);
        }

        while(brc-- >0)
        {
            strb.append(')');
        }
    System.out.println("Case #"+(t++)+": "+strb.toString());
}
}
//22847









