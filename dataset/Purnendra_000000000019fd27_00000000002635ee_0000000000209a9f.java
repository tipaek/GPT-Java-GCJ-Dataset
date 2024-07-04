import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
	// write your code here
        //System.out.println(2+3);

        Scanner s=new Scanner(System.in);
        int tc=s.nextInt();
        List<String> list=new ArrayList<>();

        for(int i=0;i<=tc;i++)
        {
            String st=s.nextLine();
            list.add(st);
        }

        //s.next();

        int pc=1;

        //System.out.println("now i am printing");
        for (String st:list) {
            if (!st.isEmpty())
            {

                Stack<Character> stack=new Stack<>();
                StringBuilder sb=new StringBuilder();
                int last=0;
                for (int i=0;i<st.length();i++)
                {
                    int num=Character.getNumericValue(st.charAt(i));
                    //System.out.println(num);
                    if(num>last)
                    {
                        for(int j=0;j<(num-last);j++)
                        {
                            sb.append("(");
                            stack.add('(');
                        }
                        sb.append(st.charAt(i));
                        last=num;
                        continue;
                    }
                    else if (num==last)
                    {
                        sb.append(st.charAt(i));
                        continue;
                    }
                    else if (num<last)
                    {
                        for(int j=0;j<(last-num);j++)
                        {
                            sb.append(")");
                            stack.pop();
                        }
                        sb.append(st.charAt(i));
                        last=num;
                        continue;
                    }

                }

                while (!stack.isEmpty())
                {
                    stack.pop();
                    sb.append(")");
                }
                System.out.println("Case #"+pc+": "+sb.toString());
                pc++;

            }
        }
    }
}