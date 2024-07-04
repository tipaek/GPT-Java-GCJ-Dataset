import java.util.ArrayList;
import java.util.Scanner;

class TimeSlot {
    int start;
    int end;

    TimeSlot(int s, int e) {
        start = s;
        end = e;
    }
}

class Solution {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            long T = input.nextLong();
            input.nextLine();

            for (long i = 0; i < T; i++) {
                int n = input.nextInt();
                input.nextLine();
                ArrayList<TimeSlot> activities = new ArrayList<>();
                ArrayList<TimeSlot> Cameron = new ArrayList<>();
                ArrayList<TimeSlot> Jamie = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    activities.add(new TimeSlot(input.nextInt(), input.nextInt()));
                    if (j != n - 1) {
                        input.nextLine();
                    }
                }

                String answer = "Case #" + (i + 1) + ": C";
                Cameron.add(activities.get(0));

                for (int j = 1; j < n; j++) {
                    int stime = activities.get(j).start;
                    int etime = activities.get(j).end;


                    for (int k = 0; k < j; k++) {
                        if ((Cameron.get(k).start < stime && stime < Cameron.get(k).end) || (Cameron.get(k).start < etime && etime < Cameron.get(k).end)) {
                            for (int l = 0; l < j; l++) {
                                if (Jamie.size() == 0) {
                                    Jamie.add(activities.get(j));
                                    answer = answer + "J";
                                    break;
                                } else if ((Jamie.get(k).start < stime && stime < Jamie.get(k).end) || (Jamie.get(k).start < etime && etime < Jamie.get(k).end)) {
                                    answer = "Case #" + (i + 1) + ": IMPOSSIBLE";
                                    break;
                                } else if (k == Jamie.size() - 1) {
                                    Jamie.add(activities.get(j));
                                    answer = answer + "J";
                                    break;
                                }
                            }
                            break;
                        } else if (k == Cameron.size() - 1) {
                            Cameron.add(activities.get(j));
                            answer = answer + "C";
                            break;
                        }
                    }
                    if (answer.contains("IMPOSSIBLE")) {
                        break;
                    }
                }

                System.out.println(answer);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
