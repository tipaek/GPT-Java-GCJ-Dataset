import java.util.*;
import java.util.regex.Pattern;

class Solution implements Comparator<String>
{
public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 0;
        while(i < t)
        {
            i++;
            int tok = 0;
            int n = sc.nextInt();
            ArrayList<String> strings = new ArrayList<>();
            
            
            for(int j = 0; j < n; j++)
            {   if(sc.hasNext())
                strings.add(sc.next().toString());
            }
            Solution solution = new Solution();
            Collections.sort(strings, solution);
            StringBuilder s2 = new StringBuilder();
            s2.append(strings.get(0).substring(1));
            s2.reverse();
            s2.append(".*");
            String p = s2.toString();
            
            for(int j = 1; j < n; j++)
            {   if(strings.get(j).length() > 1)
                {
                    StringBuilder b = new StringBuilder();
                    b.append(strings.get(j).substring(1));
                    String s = b.reverse().toString();
                if(!Pattern.matches(p , s))
                {   
                    System.out.println("Case #"+i+": *");
                    tok = 1;
                    break;
                }
                }
            }
            if(tok == 0)
            {
                System.out.println("Case #"+i+": "+strings.get(n-1).substring(1));
            }
            
        }
        sc.close();
    
    }


    @Override
    public int compare(String o1, String o2) {
	// TODO Auto-generated method stub
    return o1.length() - o2.length();  
    }
 
}