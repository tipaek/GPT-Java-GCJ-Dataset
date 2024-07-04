import java.util.*;
public class Solution{

     public static void main(String []args){
         
         Scanner s = new Scanner(System.in);
         int t,count;
         t= s.nextInt();
    s.nextLine();
         int temp = t;
         String str ;
         ArrayList<Character> arr ; 
         while(t-->0)
         {
             count = 0;
             arr = new ArrayList();
             str = s.nextLine();
             for(int i = 0;i<str.length();i++)
             {
                 if(Integer.parseInt(Character.toString(str.charAt(i))) == count)
                    arr.add(str.charAt(i));
                else if(Integer.parseInt(Character.toString(str.charAt(i))) > count)
                {
                    for(int j =0;j<Integer.parseInt(Character.toString(str.charAt(i)));j++)
                    {
                        arr.add('(');
                        count++;
                    }
                    arr.add(str.charAt(i));
                }
                else
                {
                    for(int j =0;j<Integer.parseInt(Character.toString(str.charAt(i)));j++)
                    {
                        arr.add(')');
                        count--;
                    }
                    arr.add(str.charAt(i));
                }
           }
           for(int i =0;i<count;i++)
            arr.add(')');
           String result = "";
           for(int i=0;i<arr.size();i++)
                result+=arr.get(i);
           System.out.println("Case #" + (temp-t) + ": " + result);
        }
     }
}