import java.util.*;

class Solution
{
    public static void main(String... args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int i = 1; i <= T; i++)
        {
            int N = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();;

            for(int j = 0; j < N; j++)
            {
                activities.add(new Activity(0, 0));
                activities.get(j).start = scanner.nextInt();
                activities.get(j).end = scanner.nextInt();
            }

            System.out.printf("Case #%d: %s\n", i, solve(activities));
        }
    }

    static boolean isImpossible(List<Activity> activities)
    {
        List<Integer> limits = new ArrayList<>();;
        for(Activity a: activities)
        {
            limits.add(a.start);
            limits.add(a.end);
        }
        Collections.sort(limits);

        Map<Activity, Integer> count = new HashMap<>();

        for(int i = 0; i < limits.size() - 1; i++)
        {
            Activity partial = new Activity(limits.get(i), limits.get(i + 1));

            for(Activity a: activities)
            {
                if(overlap(a, partial))
                {
                    Integer overlapCount = count.get(partial);
                    if(overlapCount == null)
                    {
                        count.put(partial, 1);
                    }
                    else
                    {
                        count.put(partial, overlapCount + 1);
                        if(overlapCount + 1 == 3)
                        {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    static String solve(List<Activity> activities)
    {
        if(isImpossible(activities))
        {
            return "IMPOSSIBLE";
        }
        String result = "";
        for(Activity a: activities)
        {
            if(a.owner != '?')
            {
                continue;
            }
            List<Activity> overlaping = findOverlaping(a, activities);
            if(overlaping.size() == 1)
            {
                overlaping.get(0).owner = 'J';
            }
            a.owner = 'C';
        }
        for(Activity a: activities)
        {
            result += a.owner;
        }
        return result;
    }

    static List<Activity> findOverlaping(Activity a, List<Activity> activities)
    {
        List<Activity> overlaping = new ArrayList<>();;
        for(Activity b: activities)
        {
            if(a != b && overlap(a, b))
            {
                overlaping.add(b);
            }
        }
        return overlaping;
    }


    static boolean overlap(Activity a, Activity b)
    {
        if(a == b)
        {
            return false;
        }
        return a.overlapsWith(b) || b.overlapsWith(a);
    }

}

class Activity
{
    int start;
    int end;
    char owner = '?';

    Activity(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

    boolean overlapsWith(Activity other)
    {
        if(other == this)
        {
            return false;
        }
        if(other.start < start && start < other.end)
        {
            return true;
        }
        if(other.start < end && end < other.end)
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        return String.format("[%d, %d]", start, end);
    }
}
