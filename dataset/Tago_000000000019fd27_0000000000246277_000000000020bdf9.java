import java.util.*;
import java.io.*;
public class Solution
{
	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int curAct[][] = new int[1][2];
        for(int i=0;i<t;i++)
        {
            List<int[]> cList = new ArrayList<int[]>();
            List<int[]> jList = new ArrayList<int[]>();
            int n = sc.nextInt();
            StringBuilder res = new StringBuilder();
            boolean imp = false;
            for(int j=0;j<n;j++)
            {
                curAct[0][0] = sc.nextInt();
                curAct[0][1] = sc.nextInt();
                if(!imp)
                {
                    if(cList.isEmpty())
                    {
                        cList.add(new int[] { curAct[0][0],curAct[0][1] });
                        res.append("C");
                        continue;
                    }
                    else
                    {
                        boolean flag = true;
                        for(int a=0;a<cList.size();a++)
                        {
                            if((curAct[0][0] > cList.get(a)[0] && curAct[0][0] < cList.get(a)[1]) || (curAct[0][1] > cList.get(a)[0] && curAct[0][1] < cList.get(a)[1]))
                            {
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                        {
                            cList.add(new int[] { curAct[0][0],curAct[0][1] });
                            res.append("C");
                            continue;
                        }
                    }
                    if(jList.isEmpty())
                    {
                        jList.add(new int[] { curAct[0][0],curAct[0][1] });
                        res.append("J");
                        continue;
                    }
                    else
                    {
                        boolean flag = true;
                        for(int a=0;a<jList.size();a++)
                        {
                            if((curAct[0][0] > jList.get(a)[0] && curAct[0][0] < jList.get(a)[1]) || (curAct[0][1] > jList.get(a)[0] && curAct[0][1] < jList.get(a)[1]))
                            {
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                        {
                            jList.add(new int[] { curAct[0][0],curAct[0][1] });
                            res.append("J");
                            continue;
                        }
                    }
                    imp = true; 
                }
            }
            System.out.println("CASE #"+(i+1)+": "+ (imp?"IMPOSSIBLE":res));
        }    
	}
}
