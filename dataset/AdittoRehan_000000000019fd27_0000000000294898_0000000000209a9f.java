import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static ArrayList<Character> chars = new ArrayList<>();


    public static void appendFP(int x){
        for(int i=1;i<=x;i++)
        {
            chars.add('(');
        }

    }

    public static void appendLP(int x){
        for(int i=1;i<=x;i++)
        {
            chars.add(')');
        }

    }

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        int testCase = input.nextInt();


        for(int i=1;i<=testCase;i++)
        {

            String s = input.next();
            int digitLength = s.length();
            boolean fs= true;


            for(int j=0;j<digitLength;j++)
            {
                if(s.charAt(j)=='0'){
                    chars.add(s.charAt(j));
                    fs=true;
                }

                else {

                    int prev = s.charAt(j);
                    prev-=48;
                    int next=0;

                    if(j<digitLength-1){ // to remove outofindex error
                        next= s.charAt(j+1);
                        next-=48;}

                    //first time starts
                    if(fs==true)
                    {

                        appendFP(prev);
                        fs=false;

                    }
                    //first time ends

                    //similar starts
                    chars.add(s.charAt(j));
                    if(next>prev){

                        appendFP(next-prev);
                    }

                    else if(next<prev) {
                        appendLP(prev-next);
                    }
                    else {
                        System.out.print(s.charAt(j)+" ");
                        chars.add(s.charAt(j));
                        j++;

                        prev = s.charAt(j);
                        prev-=48;
                        next=0;

                        if(j<digitLength-1){ // to remove outofindex error
                            next= s.charAt(j+1);
                            next-=48;}
                        if(next>prev){

                            appendFP(next-prev);
                        }

                        else {
                            appendLP(prev-next);
                        }



                    }


                    //similar ends

                }


            }
            System.out.print("Case #"+i+": ");
            for(Character c:chars)
            {
                System.out.print(c);
            }
            System.out.println();
            chars.removeAll(chars);
        }




    }
}


