import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner((System.in));
        int tc=sc.nextInt();sc.nextLine();
       

        for(int t= 1 ; t <= tc ; t++)
        {
            String inp = sc.nextLine();
           
            String op= "";
            boolean allzeros=false;
            int fnzi =0;  
            if(inp.charAt(0)=='0')
            {
                for(int i = 1 ; i<inp.length(); ) {

                    if(inp.charAt(i)=='0')
                    {
                        if(i==inp.length()-1)
                        {
                            allzeros=true;
                        }
                        i++;
                    }
                    else
                    {
                        fnzi=i;
                        break;
                    }
                }
            }
            else
                fnzi=0;

            if(allzeros)
            {
                op=inp;
            }
            else {
                for (int i = 0; i < fnzi; i++) {
                    op = op + "0";
                }
                int count_end_brac = 0;
                int fi=Integer.parseInt(""+inp.charAt(fnzi));  //first  nonzero integer
                String temp=""+fi;
                for(int i=0;i<fi;i++)
                {
                    temp = "(" + temp + ")";

                }
                op=op+temp;
                count_end_brac=count_end_brac+fi;
                for (int i = fnzi+1; i < inp.length(); i++)      //from second  integer
                {
                    if (inp.charAt(i) == '0') {
                        op = op + "0";
                        count_end_brac=0;
                    }
                    else {
                        if (count_end_brac == 0) {
                            int ci = Integer.parseInt("" + inp.charAt(i));
                            String temp2 = "" + ci;
                            for (int j = 0; j < ci; j++) {
                                temp2 = "(" + temp2 + ")";
                            }
                            op = op + temp2;
                            count_end_brac=count_end_brac+ci;
                        }
                        else{

                        int ci = Integer.parseInt("" + inp.charAt(i));

                        int diff = ci - count_end_brac;

                        if (diff < 0) {
                            String front = op.substring(0, op.length() - ci);
                            String back = op.substring(op.length() - ci);
                            op = front + ci + back;
                            count_end_brac = count_end_brac + diff;
                        }
                        else if(diff==0)
                        {
                            String front = op.substring(0, op.length() - count_end_brac);
                            String back = op.substring(op.length() - count_end_brac);
                            String middle = "" + ci;
                            op = front + middle + back;
                            count_end_brac = ci;
                        }
                        else {
                            String front = op.substring(0, op.length() - count_end_brac);
                            String back = op.substring(op.length() - count_end_brac);
                            String middle = "" + ci;
                            for (int j = 0; j < diff; j++) {
                                middle = "(" + middle + ")";
                            }
                            op = front + middle + back;
                            count_end_brac = ci;
                        }
                    }
                }
                }
            }

            System.out.println("Case #"+t+": "+op);

        }

    }
}