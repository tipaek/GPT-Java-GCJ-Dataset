import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t,u,mi, qi;
        t=Integer.parseInt(in.readLine());
        for(int a=1;a<=t;a++){
            u=Integer.parseInt(in.readLine());
            ArrayList<Element> key=new ArrayList<>();
            ArrayList<Character> test=new ArrayList<>();
            String inp[]=new String[10000];
            int num[]=new int[10000];
            HashMap<Character, Integer> location=new HashMap<>();
            boolean isThird=true;
            for(int b=0;b<10000;b++){
                String str[]=in.readLine().split(" ");
                int len=str[1].length();
                inp[b]=str[1];
                num[b]=Integer.parseInt(str[0]);
                if(!str[0].equals("-1"))
                    isThird=false;
                int pos=0;
                for(int c=0;c<len;c++){
                    char ch=str[1].charAt(c);
                    if(!test.contains(ch)) {
                        test.add(ch);
                        key.add(new Element(ch));
                        location.put(ch, pos++);
                    }
                }
            }
            String ans="";
            if(isThird) {
                for (Element element : key) {
                    ans += element.val;
                }
            }
            else{
                for(int b=0;b<10000;b++){
                    int pos=location.get(inp[b].charAt(0));
                    key.get(pos).setLowerLimit(1);
                    if(num[b]==-1)
                        continue;
                    int dig=0;
                    int copy=num[b];
                    while(copy>0){
                        dig++;
                        copy/=10;
                    }
                    if(dig>inp[b].length())
                        continue;
                    String tmp=Integer.toString(num[b]);
                    tmp=tmp.substring(1);
                    try {
                        copy = Integer.parseInt(tmp);
                    }catch (Exception e){
                        copy=-1;
                    }
                    if(copy==0){
                        key.get(pos).setUpperLimit(Integer.parseInt(Integer.toString(num[b]).charAt(0)+"")-1);
                    }
                    else{
                        key.get(pos).setUpperLimit(Integer.parseInt(Integer.toString(num[b]).charAt(0)+""));
                    }
                }
                char arr[]=new char[10];
                Collections.sort(key);
                for (Element element: key){
                    //System.out.println(element.range);
                    for(int temp=element.low; temp<=element.high;temp++){
                        if((int)arr[temp]<65){
                            arr[temp]=element.val;
                            break;
                        }
                    }

                }
                ans=new String(arr);
            }


            out.println("Case #"+a+": "+ans);
        }
        out.close();
    }
}
class Element implements Comparable<Element>{
    int low, high, range;
    char val;
    Element(char val){
        low=0;
        high=9;
        range=10;
        this.val=val;
    }
    void setLowerLimit(int limit){
        if(limit>=low && limit<=high){
            low=limit;
            range=(high-low)+1;
        }
    }
    void  setUpperLimit(int limit){
        if(limit<high && limit>=low){
            high=limit;
            range=(high-low)+1;
        }
    }

    @Override
    public int compareTo(Element o) {
        return this.range-o.range;
    }
}
