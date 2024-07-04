
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by ayush1 on 04-04-2020.
 */
class activity implements Comparable<activity>
{
    int st,end,index,alloc;

    public activity(int st, int end, int index, int alloc) {
        this.st = st;
        this.end = end;
        this.index = index;
        this.alloc = alloc;
    }

    @Override
    public int compareTo(activity activity) {
        if(st==activity.st)
            return end-activity.end;
        else
            return st-activity.st;
    }
}
class Solution {

    static char check_slot(int st_c[],int end_c[],int st_j[],int end_j[],int st
    ,int end)
    {
        boolean pos = true;
        int index=0;
        for (int i = 0; st_c[i]!=-1 ; i++) {
            if(check_overlap(st_c[i],end_c[i],st,end)) {
                pos = false;
                break;
            }
            else
                index++;
        }
        if(pos) {
            st_c[index] = st;
            end_c[index] = end;
            return 'C';
        }
        pos = true;
        index=0;
        for (int i = 0; st_j[i]!=-1 ; i++) {
            if(check_overlap(st_j[i],end_j[i],st,end)) {
                pos = false;
                break;
            }
            else
                index++;
        }
        if(pos) {
            st_j[index] = st;
            end_j[index] = end;
            return 'J';
        }
        else
            return '\0';
    }
    static boolean check_overlap(int st1,int end1,int st2,int end2)
    {
        return (st2>=st1&&st2<end1)||(end2>=st1&&end2<=end1);
    }
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        int n,st_c[],end_c[],st_j[],end_j[],st,end;
        st_c = new int[1000];
        end_c = new int[1000];
        st_j = new int[1000];
        end_j = new int[1000];
        boolean ans;
        char c,ans1[];
        //StringBuilder st = new StringBuilder();
        activity obj[];
        String s[];
        for (int i = 1; i <=test ; i++) {
            Arrays.fill(st_c,-1);
            Arrays.fill(end_c,-1);
            Arrays.fill(st_j,-1);
            Arrays.fill(end_j,-1);
            n = Integer.parseInt(br.readLine());
            obj = new activity[n];
            ans1 = new char[n];
            for (int j = 0; j < n; j++) {
                s = br.readLine().split(" ");
                st = Integer.parseInt(s[0]);
                end = Integer.parseInt(s[1]);
                obj[j] = new activity(st,end,j,-1);
            }
            Arrays.sort(obj);
            ans=true;
            for (int j = 0; j < n; j++) {
                c = check_slot(st_c,end_c,st_j,end_j,obj[j].st,obj[j].end);
                if(c=='\0')
                {
                    ans=false;
                    break;
                }
                else
                    ans1[obj[j].index] = c;
            }
            if(ans)
                System.out.printf("Case #%d: %s\n",i,new String(ans1));
            else
                System.out.printf("Case #%d: %s\n",i,"IMPOSSIBLE");
        }
    }
}
