import java.util.*;

 class App
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        String [] arr=new String[t];
        int i=0;
        while(i<t)
        {
            int n=s.nextInt();
            HashMap<Integer,Integer> href=new HashMap<>();
            TreeMap<Integer,Integer> tref=new TreeMap<>();
            String snew="";
            for(int j=0;j<n;j++)
            {
                int s1=s.nextInt();
                int t1=s.nextInt();
                href.put(s1,t1);
            }
            tref.putAll(href);
            Set<Integer> sref=tref.keySet();
            List<Integer> lref=new LinkedList<>(sref);
            for(int element:lref)
            {
                System.out.println(element);
            }
            int [] ca=new int[1000];
            int [] ja=new int[1000];
            int c=1,j=0;
            snew=snew+"C";
            ca[0]=tref.get(lref.get(0));
            for(int k=1;k<lref.size();k++)
            {
                if(lref.get(k)>=tref.get(lref.get(k-1)))
                {
                    snew =snew+"C";
                    ca[c]=tref.get(lref.get(k));
                    c++;
                }
                else
                {
                    if(j==0)
                    {
                        snew=snew+"J";
                        ja[j]=tref.get(lref.get(k));
                        j++;
                    }
                    else
                    {
                        if(ja[ja.length-1]>lref.get(k))
                        {
                            snew ="IMPOSSIBLE";
                            System.out.println("here");
                            break;
                        }
                        else
                        {
                            snew=snew+"J";
                            ja[j]=tref.get(lref.get(k));
                            j++;
                        }
                    }
                }

            }
        arr[i]= "Case #"+String.valueOf(i+1)+": "+snew;
            i=i+1;
        }
for(String ele:arr)
{
    System.out.println(ele);
}

    }
}
 
