import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(),x=1;
      outer:  while(t-->0)
        {
            int n = sc.nextInt(),i;
            Map<Character,String> hm = new HashMap<>();
            int q[][]=new int[n][2];
            String ans = "";
            for(i=0;i<n;i++)
            {
                int s=sc.nextInt(),e=sc.nextInt();
                q[i][0] = s; q[i][1] = e;
            }
            for(i=0;i<n;i++)
            {
                int s = q[i][0] , e = q[i][1];
                boolean f = true;
                if(hm.get('C')==null) {
                    hm.put('C', s + " " + e);
                    ans += "C";
                }
                else
                {
                    String y[] = hm.get('C').split(" ");
                    int y0 = Integer.parseInt(y[0]),y1 = Integer.parseInt(y[1]);
                    //System.out.println("for C "+y0+" "+y1);
                    if((s>=y0 && s<y1) || (e>y0 && e<=y1) || (s<=y0 && e>=y1)) //overlap
                    {
                        f = false;
                    }
                    else {
                        ans += "C";
                        hm.put('C', Math.min(s, y0) + " " + Math.max(e, y1));
                    }
                }
                if(!f)
                {
                    f = true;
                    if(hm.get('J')==null) {
                        hm.put('J', s + " " + e);
                        ans += "J";
                    }
                    else
                    {
                        String y[] = hm.get('J').split(" ");
                        int y0 = Integer.parseInt(y[0]),y1 = Integer.parseInt(y[1]);
                       // System.out.println("for J "+y0+" "+y1);
                        if((s>=y0 && s<y1) || (e>y0 && e<=y1) || (s<=y0 && e>=y1)) //overlap
                        {
                            f = false;
                        }
                        else {
                            ans += "J";
                            hm.put('J', Math.min(s, y0) + " " + Math.max(e, y1));
                        }
                    }
                }
                if(!f)
                {
                    System.out.println("Case #"+x+": IMPOSSIBLE");
                    x++;
                    continue outer;
                }
            }
            System.out.println("Case #"+x+": "+ans);
            x++;
        }
    }
}