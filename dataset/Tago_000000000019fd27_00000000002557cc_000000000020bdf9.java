import java.util.*;
import java.io.*;
public class Solution
{
	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++)
        {
            List<int[]> cList = new ArrayList<int[]>();
            List<int[]> jList = new ArrayList<int[]>();
            boolean imp = false;
            int n = sc.nextInt();
            int[][] ActList = new int[n][4];
            for(int j=0;j<n;j++)
            {
                ActList[j][0] = j+1;
                ActList[j][1] = sc.nextInt();
                ActList[j][2] = sc.nextInt();
            }
            java.util.Arrays.sort(ActList, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[1], b[1]);
                }
            });
            for(int j=0;j<n;j++)
            {
                if(!imp)
                {
                    if(cList.isEmpty())
                    {
                        cList.add(new int[] { ActList[j][1],ActList[j][2] });
                        ActList[j][3] = 1;
                        continue;
                    }
                    else
                    {
                        boolean flag = true;
                        for(int a=0;a<cList.size();a++)
                        {
                            if((ActList[j][1] > cList.get(a)[0] && ActList[j][1] < cList.get(a)[1]) || (ActList[j][2] > cList.get(a)[0] && ActList[j][2] < cList.get(a)[1]))
                            {
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                        {
                            cList.add(new int[] { ActList[j][1],ActList[j][2] });
                            ActList[j][3] = 1;
                            continue;
                        }
                    }
                    if(jList.isEmpty())
                    {
                        jList.add(new int[] { ActList[j][1],ActList[j][2] });
                        ActList[j][3] = 2;
                        continue;
                    }
                    else
                    {
                        boolean flag = true;
                        for(int a=0;a<jList.size();a++)
                        {
                            if((ActList[j][1] > jList.get(a)[0] && ActList[j][1] < jList.get(a)[1]) || (ActList[j][2] > jList.get(a)[0] && ActList[j][2] < jList.get(a)[1]))
                            {
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                        {
                            jList.add(new int[] { ActList[j][1],ActList[j][2] });
                            ActList[j][3] = 2;
                            continue;
                        }
                    }
                    imp = true; 
                }
            } 
            java.util.Arrays.sort(ActList, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[0], b[0]);
                }
            });
            StringBuilder res = new StringBuilder();
            if(imp)
            {
                res.append("IMPOSSIBLE");
            }
            else
            {
                for(int j=0;j<n;j++)
                {
                    res.append(ActList[j][3] == 1?"C":"J");
                }
            }
            System.out.println("CASE #"+(i+1)+": "+ res);
        }
	}
}
