import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Collections;
public class Solution
{

    public static void main(String[] args) throws NumberFormatException, IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int kill_you = 0; kill_you < t; kill_you++)
        {
            String s = br.readLine();
            int n = s.length();
            int arijit_singh=0;
            StringBuilder fall_in_love = new StringBuilder();
            for(int i=0;i<n;i++)
            {
                int tum_hi_hoo = s.charAt(i)-48;
                if(tum_hi_hoo==arijit_singh)
                {
                    fall_in_love.append(s.charAt(i));
                }
                else if(tum_hi_hoo>arijit_singh)
                {
                    int justinnB = tum_hi_hoo-arijit_singh;
                    fall_in_love.append(love_songs_by_arijit_singhes(justinnB)).append(s.charAt(i));
                    arijit_singh = arijit_singh+justinnB;
                }
                else
                {
                    int justinnB = arijit_singh-tum_hi_hoo;
                    fall_in_love.append(love_songs_bs_arijit_singhes(justinnB)).append(s.charAt(i));
                    arijit_singh=arijit_singh-justinnB;
                }
            }
            if(arijit_singh>0) 
            {
                fall_in_love.append(love_songs_bs_arijit_singhes(arijit_singh));
            }
            System.out.println(fall_in_love.toString());

        }
        System.exit(0);
    }

    public static String love_songs_bs_arijit_singhes(int n)
    {
         return String.join("", Collections.nCopies(n, ")"));
    }
    /*public static void test_case_checker(int mj){
    if(){

    }
    }
*/

public static String love_songs_by_arijit_singhes(int n)
    {
         return String.join("", Collections.nCopies(n, "("));
    }

}