import java.util.*;



public class Solution {



    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int b=sc.nextInt();
        String this_character="";
        for(int ii=0;ii<t;ii++)
        {
            String first_one="";

            int count=1;
            if(this_character.length()>1)
            {
                System.out.println(count);

                if(this_character.charAt(0)=='N') System.exit(0);

                first_one+=this_character.charAt(0);
                this_character=this_character.substring(1);
                count++;
            }



            while(count<=10)
            {
                System.out.println(count);
                System.out.flush();

                this_character=sc.next();

                if(this_character.charAt(0)=='N')
                    System.exit(0);

                if(this_character.length()==1)
                {
                    first_one+=this_character;

                    count++;
                }
                else
                {
                    first_one+=this_character.charAt(0);
                    count++;
                    System.out.println(count);

                    if(this_character.charAt(1)=='N') System.exit(0);

                      first_one+=this_character.charAt(1);


                    count+=1;
                }
            }
            System.out.println(first_one);
            System.out.flush();
            this_character=sc.next();
            if(this_character.charAt(0)=='N') System.exit(0);

            //   System.out.println("Case #"+(ii+1)+": "+sb.toString());
        }


    }

}
