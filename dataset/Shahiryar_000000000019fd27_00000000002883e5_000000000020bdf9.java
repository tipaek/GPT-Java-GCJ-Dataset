
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Solution {
public static String S = "";
public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int cases = in.nextInt();
    int acts;
    Person J = new Person("J");
    Person C = new Person("C");
    ArrayList<Interval> as = new ArrayList<>();
    for(int c = 1; c <= cases; c++)
    {
        S = "";
        as.clear();
        acts = in.nextInt();
        for(int a = 0; a<acts; a++)
        {
            as.add(new Interval(in.nextInt(), in.nextInt()));
        }
        for (Interval act : as)
        {
            if(!(J.addAct(act) || C.addAct(act))){S = "IMPOSSIBLE"; break;}
        }
        System.out.println("Case #" + c + ": " + S);
        J.sch.clear();
        C.sch.clear();
        
    }

    
}

    public static boolean inInterval(int i, Interval interval) {
    int minValueInclusive = interval.s;
    int maxValueInclusive = interval.e;
    Boolean result = (i > minValueInclusive && i < maxValueInclusive);
    return result;
}
}
class Person{

    String name;
    ArrayList<Interval> sch;

    Person(String name) {
        this.name = name;
        sch = new ArrayList<>();
    }

    public Boolean addAct(Interval i) {
        if (isFreeAt(i)) {
            sch.add(i);
            Solution.S = Solution.S + this.name;
            return true;
        }
        return false;
    }

    public Boolean isFreeAt(Interval i) {

        for (Interval in : sch) {
            if (Solution.inInterval(i.s, in) || Solution.inInterval(i.e, in)) {
                return false;
            }
        }
        return true;
    }

}

class Interval {
    int s, e;
    Interval(int s, int e)
    {
        this.s = s;
        this.e = e;
    }
    
}


