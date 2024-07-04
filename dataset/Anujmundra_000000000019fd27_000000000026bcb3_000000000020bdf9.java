import java.util.*;
public class Solution {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int i=1;i<=test;i++)
        {
            int val=sc.nextInt();
            int arr[]=new int[val*2];
            for(int j=0;j<val*2;j++)
            {
                arr[j]=sc.nextInt();
            }
            HashMap<Integer,Integer>hm=new HashMap<>();
            for(int j=0;j<val*2;j=j+2)
            {
                hm.put(arr[j],arr[j+1]);
            }
            TreeMap<Integer,Integer>tm=new TreeMap<>(hm);
            Set s1=tm.entrySet();
            ArrayList<Integer>al1=new ArrayList<>();
            ArrayList<Integer>al2=new ArrayList<>();
            Iterator it =s1.iterator();
            HashMap<Integer,Character>hm1=new HashMap<>();
            StringBuffer sb=new StringBuffer();
            while(it.hasNext())
            {
                Map.Entry me = (Map.Entry)it.next();
                al1.add((int)me.getKey());
                al2.add((int)me.getValue());
            }
            int count=0;
            for(int j=0;j<val;j++)
            {
                if(j==0){
                    sb.append("C");
                count++;}
                else if(j==1){
                    sb.append("J");
                count++;}
                else
                {
                    if(al1.get(j)<al2.get(0))
                    {
                        if(al1.get(j)>al2.get(1))
                        {
                            al2.remove(1);
                            count++;
                            sb.append("J");
                        }
                    }
                    else
                    {
                        al2.remove(0);
                        count++;
                        sb.append("C");
                    }
                }
            }
            if(count==val)
                System.out.println("Case #"+i+""+": "+sb);
            else
                System.out.println("Case #"+i+""+": "+"IMPOSSIBLE");
                
            
        }
    }
    
}