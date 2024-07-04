import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N=sc.nextInt();
            HashMap<Integer,Integer>cameron=new HashMap<Integer, Integer>();
            int c1=sc.nextInt();
            int c2=sc.nextInt();
            HashMap<Integer,Integer>jamie=new HashMap<Integer, Integer>();
            cameron.put(c1,c2);
            String output="C";
            for (int j = 0; j <N-1 ; j++) {
                int x=sc.nextInt();
                int y=sc.nextInt();
                boolean a=false;
                boolean possible=true;
                Set<Integer>keys=cameron.keySet();
                for(int k:keys)
                {
                    if((x<cameron.get(k)&&x>=k)||(y<=cameron.get(k)&&y>=k))
                    {
                        a=true;
                        break;
                    }
                }
                if(a==true)
                {

                    Set<Integer>key=jamie.keySet();
                    for(int k:key) {
                        if((x<jamie.get(k)&&x>=k)||(y<=jamie.get(k)&&y>=k))
                        {
                            possible=false;
                            break;
                        }
                    }
                    if(possible==false)
                    {
                        output="IMPOSSIBLE";
                        break;
                    }
                    output+="J";
                    jamie.put(x,y);
                }
                else {
                    output += "C";
                    cameron.put(x,y);
                }
            }   
            System.out.println("Case #"+(i+1)+": "+output);
        }
    }
}