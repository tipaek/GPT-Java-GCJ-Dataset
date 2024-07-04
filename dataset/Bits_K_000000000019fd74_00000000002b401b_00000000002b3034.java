import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(),tt = 1;
    outer:    while(t-->0)
        {
            int n=sc.nextInt(),i;
            ArrayList<String> al = new ArrayList<>();
            for(i=0;i<n;i++)
            {
                al.add(sc.next());
            }

            Collections.sort(al, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length()>o2.length()) return 1;
                    else if(o1.length() == o2.length())return 0;
                    return -1;
                }
            });

            for(i=1;i<n;i++)
            {
                int x = al.get(i-1).length()-1;
                String s = al.get(i-1);
                String s1 = al.get(i);
                for(int j=al.get(i).length()-1;x>0;x--,j--)
                {
                    if(s1.charAt(j)!=s.charAt(x))
                    {
                        System.out.println("Case #"+tt+": *");
                        tt++;
                        continue outer;
                    }
                }
            }
            System.out.println("Case #"+tt+": "+al.get(n-1).substring(1));
            tt++;
        }
    }
}
