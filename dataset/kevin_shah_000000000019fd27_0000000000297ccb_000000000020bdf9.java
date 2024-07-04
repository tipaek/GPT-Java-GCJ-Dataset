import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < t ; i++)
        {
            int n = Integer.parseInt(br.readLine()), f = 0;
            String s = "";
            Map<Integer, Integer> m = new LinkedHashMap<>();
            LinkedHashMap<String, TreeMap<Integer, Integer>> m1 = new LinkedHashMap<>();
            for(int j = 0 ; j < n ; j++)
            {
                String line = br.readLine();
                String[] tokens = line.split(" ");
                m.put(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
            }
            for(Map.Entry<Integer, Integer> a : m.entrySet())
            {
                if(a.getKey() == m.keySet().iterator().next())
                {
                    s = s + "C";
                    TreeMap<Integer, Integer> temp = new TreeMap<Integer, Integer>();
                    temp.put(a.getKey(), a.getValue());
                    // m1.put("C", new TreeMap<Integer, Integer>().put(a.getKey(), a.getValue()));
                    m1.put("C", temp);
                } 
                else
                {
                    // for(Map.Entry<String, TreeMap<Integer, Integer>> b : m1.entrySet())
                    // {
                    int flag = 0;
                        // if(b.getKey().equals("C"))
                        // {
                    for(Map.Entry<Integer, Integer> z : m1.get("C").entrySet())
                    {
                        if(z.getValue() > a.getKey() && a.getValue() > z.getKey())
                        {
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 0)
                    {
                        s = s + "C";
                        m1.get("C").put(a.getKey(), a.getValue());
                        continue;
                        // break;
                    }
                        // }
                    if(flag == 1)
                    {
                        if(m1.size() == 1)
                        {
                            s = s + "J";
                            TreeMap<Integer, Integer> temp = new TreeMap<Integer, Integer>();
                            temp.put(a.getKey(), a.getValue());
                            m1.put("J", temp);
                            // m1.put("J", new TreeMap<Integer, Integer>.put(a.getKey(), a.getValue()));
                            continue;
                            // break;
                        }
                        else
                        {
                            flag = 0;
                            for(Map.Entry<Integer, Integer> z : m1.get("J").entrySet())
                            {
                                if(z.getValue() > a.getKey() && a.getValue() > z.getKey())
                                {
                                    flag = 1;
                                    break;
                                }
                            }
                            if(flag == 0)
                            {
                                s = s + "J";
                                m1.get("J").put(a.getKey(), a.getValue());
                                // break;
                                continue;
                            }
                            else
                            {
                                f = 1;
                                break;
                            }   
                        }
                    }
                    // if(m1.get("C")[1] <= c)
                    // {
                    //     s = s + "C";
                    //     m1.put("C", new int[]{a.getKey(), a.getValue()});
                    // }
                    // else if(m1.get("C")[0] >= a.getValue())
                    // {
                    //     s = s + "C";
                    //     m1.put("C", new int[]{a.getKey(), a.getValue()});
                    // }
                    // else if(m1.get("J") <= c)
                    // {
                    //     s = s + "J";
                    //     b = a.getValue();
                    //     m1.put("J", b);
                    // }
                    // else
                    // {
                    //     f = 1;
                    //     break;
                    // }
                }
            }
            if(f == 1)
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            else
                System.out.println("Case #" + (i + 1) + ": " + s);
        }
    }
}