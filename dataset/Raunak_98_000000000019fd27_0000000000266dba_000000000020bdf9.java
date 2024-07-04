import java.util.*;
class Activity
{
    public int index;
    public int x;
    public int y;
    public char ch;
    public Activity(int a,int b,int c){
        this.index = a;
        this.x = b;
        this.y = c;
        this.ch = 'A';
    }
    
    public void setCh(char ch){
        this.ch = ch;
    }
}
public class Solution
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int tc = 1;
        StringBuffer sb = new StringBuffer();
        while(t-->0)
        {
            int n = sc.nextInt();
            ArrayList<Activity> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
            {
                int b = sc.nextInt();
                int c = sc.nextInt();
                arr.add(new Activity(i,b,c));
            }
            Collections.sort(arr, new Comparator<Activity>() {  //ascending
                public int compare(Activity ob, Activity ob1) {
                    return ob.x-ob1.x;
                }
            });
            
            int z = arr.get(0).y;
            arr.get(0).setCh('J');
            for(Activity i:arr){
                if(i.x>=z){
                    z = i.y;
                    i.setCh('J');
                }
                //System.out.println(x.getCh());
            }
            char c;
            int j = 0;
            do{
                c = arr.get(j).ch;
                j++;
            }while(c!='A' && j<arr.size());
            boolean flag=true;
            if(j==arr.size() && c=='J') flag=false;
            if(flag){
                arr.get(j-1).setCh('C');
                z = arr.get(j-1).y;
                for(int k = j;k<arr.size();k++){
                    Activity ac = arr.get(k);
                    if(ac.ch=='A' && ac.x>=z){
                        z = ac.y;
                        ac.setCh('C');
                    }
                }
            }
            StringBuffer temp = new StringBuffer();
            if(check(arr))
            {
                Collections.sort(arr, new Comparator<Activity>() {  //ascending
                public int compare(Activity x, Activity y) {
                    return x.index-y.index;
                }
            });
                for(Activity ac:arr) temp.append(ac.ch);
            }
            else
            {
                temp.append("IMPOSSIBLE");
            }
            //System.out.println(temp);
            sb.append("Case #"+tc+": "+temp+"\n");
            tc++;
        }
        System.out.println(sb);
    }

    public static boolean check(ArrayList<Activity> arr){
        for(Activity x:arr){
            if(x.ch=='A') return false;
        }
        return true;
    }
}