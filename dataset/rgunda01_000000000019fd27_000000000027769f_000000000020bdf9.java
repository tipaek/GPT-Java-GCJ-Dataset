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
            HashMap<Integer,Integer>jamie=new HashMap<Integer, Integer>();
            
            String output="";
            for (int j = 0; j <N; j++) {
                int x=sc.nextInt();
                int y=sc.nextInt();
                boolean change=false;
                boolean possible=true;
                Set<Integer>keys=cameron.keySet();
                for(int k:keys)
                {
                    if((x<cameron.get(k)&&x>=k)||(y<=cameron.get(k)&&y>=k))
                    {
                        change=true;
                        break;
                    }
                }
                if(change==true)
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