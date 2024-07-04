
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author HASAN
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        for(int i=0; i<t; i++){
            char[] data = sc.next().trim().toCharArray();
            System.out.println("Case #"+(i+1)+": "+processOutput(data));
        }
    }
    
    public static String processOutput(char[] data){
        String s = "";
        for(int i = 0; i<data.length; i++)
        {
            s += getP(data[i]);
        }
        return formatString(s);
    }
    
    public static String getP(char c){
    String s = "";
    int num = Integer.parseInt(String.valueOf(c));
    for(int i=0;i<=num*2;i++){
        if(i<num)
            s += "(";
        else if (i==num)
            s += String.valueOf(num);
        else if (i>num)
            s += ")";
    }
    return s;    
    }
    
    public static String formatString(String s){
    String st = "";
    List<Character> c = new ArrayList<>();
    for(char ch: s.toCharArray())
    {
        c.add(ch);
    }
    for(int i=0; i<c.size();i++){
        if(i+1==c.size())
            break;
        if(c.get(i)==')')
        {
            if (c.get(i+1)=='(') 
            {
                c.remove(i);
                c.remove(i);
                i = 0;
            }
        }
    }
    for(int i=0; i<c.size();i++){
        st += String.valueOf(c.get(i));
    }
    return st;
    }
}
