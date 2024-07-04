import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            int a[][]=new int[n][2];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<2;k++)
                {
                    a[j][k]=sc.nextInt();
                }
            }

            Integer ll[]={65,12,44,23,78,43,22,18,90,6,45,0,11,33,24,56,32,10,55,39,11,188};
            int sum=0;
            for(int h=0;h<ll.length;h++)
            {
                sum=sum+ll[h];
            }
            int min=ll[0];
            for(int e=0;e<ll.length;e++)
            {
                if(min>ll[e])
                {
                    min=ll[e];
                }
            }
            //System.out.println(min);
            //System.out.println(sum);
            ArrayList<activities> l=new ArrayList<activities>();
            for(int j=0;j<n;j++)
            {
                l.add(new activities(a[j][0],a[j][1],j));
            }

            Comparator<activities> comparator=new Comparator<activities>() {
                @Override
                public int compare(activities o1, activities o2) {
                    if(o1.start-o2.start==0){
                        if(o1.end-o2.end==0){
                            return o1.index-o2.index;
                        }
                        else
                            return o1.end-o2.end;
                    }
                    else
                        return o1.start-o2.start;
                }
            };

            Collections.sort(l,comparator);

            int c=0,j=0;
            int flag=0;
            String[] res=new String[n];
            for(int z=0;z<l.size();z++){
                if(l.get(z).start<c && l.get(z).start<j){
                    flag=1;
                    break;
                }
                else if(l.get(z).start>=c){
                    res[l.get(z).index]="C";
                    c=l.get(z).end;
                }
                else{
                    res[l.get(z).index]="J";
                    j=l.get(z).end;
                }
            }
            System.out.print("Case #"+(i+1)+": ");
            if(flag==1)
            {
                System.out.println("IMPOSSIBLE");
            }
            else{
                for(int z=0;z<n;z++){
                    System.out.print(res[z]);
                }
                System.out.println();
            }

        }

    }
}
class activities{
    int start,end,index;
    activities(int start,int end,int index){
        this.start=start;
        this.end=end;
        this.index=index;
    }
}
