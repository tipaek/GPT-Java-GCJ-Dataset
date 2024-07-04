
import java.util.HashMap;
import java.util.Scanner;
public class Solution{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        long t=scan.nextLong();
        for(long T=1;T<=t;T++){
            char alpha;
            long j=0;
            HashMap<Character, Integer> servserValues=new HashMap();
            HashMap<Character,Integer> valueZero=new HashMap<>();
            long U=scan.nextLong();
            long Q=0;
            String value="";
            for(long i=0;i<10000;i++){
                Q=scan.nextLong();
                if(Q==-1)
                    Q= (long) (Math.pow(10,U)-1);
                value=scan.next();
                alpha=value.charAt(0);

                for(int z=0;z<value.length();z++){
                    if(!servserValues.containsKey(value.charAt(z))){
                        servserValues.put(value.charAt(z), (int) 9);
                        valueZero.put(value.charAt(z), (int) 0);
                    }
                }
                valueZero.put(alpha, (int) -1);
                servserValues.put(alpha,servserValues.get(alpha)>(Q/Math.pow(10,value.length()-1))?(int)(Q / Math.pow(10, value.length() - 1)):servserValues.get(alpha));
            }
            valueZero.forEach((x,y)->{
                if(y==0){
                    servserValues.put(x,y);
                }
            });
            char[] result=new char[10];
            servserValues.forEach((x,y)->{
                result[Math.toIntExact(y)]=x;
            });
            System.out.println("Case #"+T+": "+new String(result));
        }
    }
}