import java.util.*;

public class Solution {

    public static void main(String[] args) {
	// write your code here
        int T, N, i, j, S, E, num, maxV = 1441, index;
        PriorityQueue<Integer> sortQ = new PriorityQueue<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        Stack<Integer> endStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        boolean isC, isJ, impossible;

        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(i = 1; i <= T; i++) {
            N = sc.nextInt();
            indexMap.clear();
            endStack.clear();
            indexStack.clear();
            sortQ.clear();
            isC = false;
            isJ = false;
            impossible = false;
            char[] tasks = new char[N];
            for(j = 0; j < N; j++) {
                S = sc.nextInt();
                E = sc.nextInt();
                num = S * maxV + E;
                sortQ.add(num);
                indexMap.put(num, j);
            }

            while (!sortQ.isEmpty()) {
                num = sortQ.poll();
                S = num / maxV;
                E = num % maxV;
                j = indexMap.get(num);

                if(endStack.size() > 2)  {
                    impossible = true; break;
                }

                while (!impossible && !endStack.empty() && endStack.peek() <= S) {
                    endStack.pop();
                    index = indexStack.pop();

                    if(tasks[index] == 'C') isC = false;
                    else if(tasks[index] == 'J') isJ = false;
                    else
                        impossible = true;
                }

                if(isC && isJ)
                    impossible = true;

                if(impossible) break;

                else if(isC) { tasks[j] = 'J'; isJ = true; }
                else  { tasks[j] = 'C'; isC = true; }

                if(!endStack.empty() && E > endStack.peek()) {
                    int topE = endStack.pop();
                    endStack.push(E);
                    endStack.push(topE);
                    int topIndex = indexStack.pop();
                    indexStack.push(j);
                    indexStack.push(topIndex);
                } else {
                    endStack.push(E);
                    indexStack.push(j);
                }
            }

            if(impossible)
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            else
                System.out.println("Case #" + i + ": " + new String(tasks));
        }
    }
}
