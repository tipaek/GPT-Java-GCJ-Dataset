import java.util.*;

public class Solution
{
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        long cases = kb.nextLong();
        for(long i = 1; i <= cases; i++)
        {
            int numAct; numAct = kb.nextInt();
            String ans = "";
            int start;
            int end;
            int tempS;
            int tempE;
            char currentAct;
            boolean impossible = false;

            kb.nextLine();
            String times = kb.nextLine();


                start = Integer.parseInt(times.substring(0, times.indexOf(' ')));
                System.out.println("start: " + start);
                end = Integer.parseInt(times.substring(times.indexOf(' ') + 1, times.length()));
                System.out.println("end: " + end);
                ans += 'J';
                currentAct = 'J';

                for (int j = 1; j < numAct; j++) {

                    times = kb.nextLine();

                    tempS = Integer.parseInt(times.substring(0, times.indexOf(' ')));
                    
                    tempE = Integer.parseInt(times.substring(times.indexOf(' ') + 1, times.length()));
                    

                    if (tempS >= start)
                    {
                        if(tempS >= end) {
                            if (currentAct == 'C') {
                                ans += 'C';
                                currentAct = 'C';

                            } else {
                                ans += 'J';
                                currentAct = 'J';
                            }
                        }
                        else
                        {
                            if (currentAct == 'C') {
                                ans += 'C';
                                currentAct = 'C';

                            } else {
                                ans += 'J';
                                currentAct = 'J';
                            }
                        }

                    } else if (tempS <= start)
                    {
                        if(tempE >= start) {
                            if (currentAct == 'J') {
                                ans += 'C';
                                currentAct = 'C';

                            } else {
                                ans += 'J';
                                currentAct = 'J';
                            }
                        }
                        else
                        {
                            if (currentAct == 'J') {
                                ans += 'C';
                                currentAct = 'C';

                            } else {
                                ans += 'J';
                                currentAct = 'J';
                            }
                        }

                    } else
                        {

                            impossible = true;

                        }



                }


                if(!impossible)
                {
                    System.out.println("Case #" + (i+1) + ':' + ans);
                }
                else
                {
                    System.out.println("Case #" + (i+1) + ':' + "IMPOSSIBLE");
                }




        }

    }
}
