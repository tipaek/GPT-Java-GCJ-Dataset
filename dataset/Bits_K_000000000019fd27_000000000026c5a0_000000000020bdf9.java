import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(),x=1;
      outer:  while(t-->0)
        {
            int n = sc.nextInt(),i;
            Map<Character,String> hm = new HashMap<>();
            Map<String,ArrayList<Integer>> r = new HashMap<>(); //ranges
            int q[][]=new int[n][2];
            char num[]=new char[n];
            String ans = "";
            for(i=0;i<n;i++)
            {
                int s=sc.nextInt(),e=sc.nextInt();
                q[i][0] = s; q[i][1] = e;

                if(r.get(s+" "+e)==null) {
                    ArrayList<Integer> al  = new ArrayList<>();
                    al.add(i);
                    r.put(s + " " + e, al);
                }
                else {
                    ArrayList<Integer> al  = r.get(s+" "+e);
                    al.add(i);
                    r.put(s + " " + e, al);
                }
            }
            ArrayList<String> al = new ArrayList<>(r.keySet());
            Collections.sort(al, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int s1 = Integer.parseInt(o1.split(" ")[0]);
                    int s2 = Integer.parseInt(o2.split(" ")[0]);
                    //System.out.println("s1 : "+s1+" s2 : "+s2);
                    if(s1>s2)return 1;
                    else if(s1 == s2) return 0;
                    return -1;
                }
            });
            for(String S : al) {
                ArrayList<Integer> list = r.get(S);
                String range[]=S.split(" ");
                int s = Integer.parseInt(range[0]);
                int e = Integer.parseInt(range[1]);
               // System.out.println("s : "+s+"e : "+e);
                for (i = 0; i < list.size(); i++) {

                    boolean f = true;
                    if (hm.get('C') == null) {
                        hm.put('C', s + " " + e);
                        //ans += "C";
                        num[list.get(i)] = 'C';
                    } else {
                        String y[] = hm.get('C').split(" ");
                        int y0 = Integer.parseInt(y[0]), y1 = Integer.parseInt(y[1]);
                        //System.out.println("for C "+y0+" "+y1);
                        if ((s >= y0 && s < y1) || (e > y0 && e <= y1) || (s <= y0 && e >= y1)) //overlap
                        {
                            f = false;
                        } else {
                            //ans += "C";
                            num[list.get(i)] = 'C';
                            hm.put('C', Math.min(s, y0) + " " + Math.max(e, y1));
                        }
                    }
                    if (!f) {
                        f = true;
                        if (hm.get('J') == null) {
                            hm.put('J', s + " " + e);
                            //ans += "J";
                            num[list.get(i)] = 'J';
                        } else {
                            String y[] = hm.get('J').split(" ");
                            int y0 = Integer.parseInt(y[0]), y1 = Integer.parseInt(y[1]);
                            // System.out.println("for J "+y0+" "+y1);
                            if ((s >= y0 && s < y1) || (e > y0 && e <= y1) || (s <= y0 && e >= y1)) //overlap
                            {
                                f = false;
                            } else {
                                //ans += "J";
                                num[list.get(i)] = 'J';
                                hm.put('J', Math.min(s, y0) + " " + Math.max(e, y1));
                            }
                        }
                    }
                    if (!f) {
                       // System.out.println("S : " + S);
                        System.out.println("Case #" + x + ": IMPOSSIBLE");
                        x++;
                        continue outer;
                    }
                }
            }
            for(i=0;i<n;i++)
                ans+=num[i];
            System.out.println("Case #"+x+": "+ans);
            x++;
        }
    }
}