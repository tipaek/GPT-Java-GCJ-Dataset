import java.util.*;

public class Solution 
{
	public static String chars(char all[]) {
        String s="";
        for(int i=0; i<all.length; i++)
        {
            s+=all[i];
        }
        return s;
    }

	public static void Sort(int strt[], int end[], int index[]){
        for (int i = 1; i < strt.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(strt[j] < strt[j-1]){
                    int temp = strt[j];
                    strt[j] = strt[j-1];
                    strt[j-1] = temp;
                    temp = end[j];
                    end[j] = end[j-1];
                    end[j-1] = temp;
                    temp = index[j];
                    index[j] = index[j-1];
                    index[j-1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k=1; k<=t; k++)
        {
            int n = sc.nextInt();
            int strt[] = new int[n];
            int end[] = new int[n];
            int index[] = new int[n];
            char ch[] = new char[n];
            for(int i=0; i<n; i++)
            {
                strt[i] = sc.nextInt();
                end[i] = sc.nextInt();
                index[i] = i;
            }
            Sort(strt, end, index);
            int jns=0;
            int cns=0;
            int jam[] = new int[2];
            int cam[] = new int[2];
            for(int i=0; i<n; i++)
            {
                int st = strt[i];
                int en = end[i];
                if(jns == 0)
                {
                    jam[1] = en;
                    jam[0] = st;
                    ch[index[i]]='J';
                    jns++;
                    continue;
                }
                if(st>=jam[1])
                {
                    jam[1] = en;
                    jam[0] = st;
                    ch[index[i]]='J';
                    continue;
                }
                if(cns==0)
                {
                    cam[1] = en;
                    cam[0] = st;
                    ch[index[i]]='C';
                    cns++;
                    continue;
                }
                if(st>=cam[1])
                {
                    cam[1] = en;
                    cam[0] = st;
                    ch[index[i]]='C';
                    continue;
                }
                jns=0;
                System.out.println("Case #"+k+": IMPOSSIBLE");
                break;
            }
            if(jns!=0)
            {
                System.out.println("Case #"+k+": " + chars(ch));
            }
        }
    }
}
    