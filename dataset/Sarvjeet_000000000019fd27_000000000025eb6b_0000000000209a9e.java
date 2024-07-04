import java.util.*;

import static java.lang.System.exit;

public class Solution {



    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int b=sc.nextInt();

        for(int ii=0;ii<t;ii++)
        {
            String first_one="";
            int count=1;
            char this_character='0';
            while(count<=10)
            {
                System.out.println(count);
                System.out.flush();

                this_character=sc.next().charAt(0);
                if(this_character=='N')
                    exit(0);
                first_one+=this_character;

                count++;
            }
            System.out.println("Case #"+(ii+1)+": "+first_one);
            System.out.flush();
            if(this_character=='N') exit(0);

            //   System.out.println("Case #"+(ii+1)+": "+sb.toString());
        }


    }

}
