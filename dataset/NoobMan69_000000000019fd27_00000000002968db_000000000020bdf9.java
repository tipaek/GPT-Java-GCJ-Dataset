import java.util.*;
class Tuple
{
    int a,b,c;
    Tuple()
    {
        int a=0;
        int b=0;
        int c=0;
    }
    Tuple(int x,int y,int z)
    {
        this.a=x;
        this.b=y;
        this.c=z;
    }
}
public class Solution
{

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            int x,y=0;
            int n=sc.nextInt();
            TreeMap <Integer,String>map =new TreeMap<>();
            Tuple arr[]=new Tuple[n];
            for(int i=0;i<n;i++)
            {
                x=sc.nextInt();
                y=sc.nextInt();
                arr[i]=new Tuple(x,y,i);
            }
        

        Arrays.sort(arr, new Comparator<Tuple>(){
            @Override public int compare(Tuple t1,Tuple t2)
            {
                return t1.a-t2.a;
            }
        });

        int curr_j=arr[0].b,curr_c=0;
        char curr='J';
        map.put(arr[0].c,"J");
        boolean flag=true;
        for(int i=1;i<n;i++)
        {
            if(arr[i].a<arr[i-1].b)
            {
                if(curr=='J')
                {
                    if(arr[i].a>=curr_c)
                    {
                        curr_c=arr[i].b;
                        curr='C';
                        map.put(arr[i].c,"C");
                    }
                    else
                        {
                            flag=false;
                            break;
                        } 
                }
                else{
                    if(arr[i].a>=curr_j)
                    {
                        curr_j=arr[i].b;
                        curr='J';
                        map.put(arr[i].c,"J");
                    }
                    else{
                        flag=false;
                        break;
                    }
                }
            }
            else{
                if(curr=='J')
                {
                    curr_j=arr[i].b;
                    map.put(arr[i].c,"J");
                }
                else
                {
                    curr_c=arr[i].b;
                    map.put(arr[i].c,"C");
                }
            }
        }
            if(flag)
            {
                String st2="";
                for(Map.Entry<Integer,String> entry:map.entrySet())
                    st2+=entry.getValue();
                System.out.println("Case #"+k+": "+st2);
            }
            else
            {
                System.out.println("Case #"+k+": IMPOSSIBLE");
            }
        }
        // for(int i=0;i<n;i++)
        // System.out.println(arr[i].a+" "+arr[i].b+" "+arr[i].c);
        }
    }

