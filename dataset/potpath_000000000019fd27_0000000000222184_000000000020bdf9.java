import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int x = 1; x <= T; ++x)
        {
            int N = scan.nextInt();

            List<List<Integer>> graph = new ArrayList<>(N);
            List<String> ans = new ArrayList<>(N);
            for (int i = 0; i < N; ++i)
            {
                graph.add(new ArrayList<>());
                ans.add("");
            }

            List<Integer> ss = new ArrayList<>(N);
            List<Integer> ee = new ArrayList<>(N);

            for (int i = 0; i < N; ++i)
            {
                int s = scan.nextInt();
                int e = scan.nextInt();
                for (int j = 0; j < i; ++j)
                {
                    if (ss.get(j) < e && s < ee.get(j))
                    {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
                ss.add(s);
                ee.add(e);
            }

            boolean ok = true;
            out:
            for (int i = 0; i < N; ++i)
            {
                if (ans.get(i) != "") continue;

                ans.set(i, "C");
                LinkedList<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty())
                {
                    int u = q.getFirst();
                    q.pop();
                    String ucol = ans.get(u);
                    String nextcol = ucol == "C" ? "J" : "C";
                    for (int v : graph.get(u))
                    {
                        String vcol = ans.get(v);
                        if (vcol == "")
                        {
                            q.add(v);
                            ans.set(v, nextcol);
                        }
                        else if (vcol != nextcol)
                        {
                            ok = false;
                            break out;
                        }
                    }
                }
            }

            String y = "IMPOSSIBLE";
            if (ok) y = String.join("", ans);
            System.out.println(MessageFormat.format("Case #{0}: {1}", x, y));
        }

    }
}
