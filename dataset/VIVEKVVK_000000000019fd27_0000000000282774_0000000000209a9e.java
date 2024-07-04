import java.util.*;

public class Solution{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int j=0;j<t;j++){
            int b = in.nextInt();
            int query=1;
            char response;
            int index=1;
            String result;
            char characters[]=new char[b];
            while(query<=150)
            {
                
                if(query%10!=1)
                {
                    System.out.println(index);
                    response = (in.next()).charAt(0);
                    characters[index-1]=response;
                    index++;
                }
                else
                {
                    System.out.println(index);
                    response = (in.next()).charAt(0);
                }
                if(index==b)
                    break;
                query++;
            }
        result = new String(characters);
        System.out.println(result);
        response = (in.next()).charAt(0);
        if (response=='Y')
            continue;
        else if (response=='N')
            break;
        }
        in.close();
    }
}