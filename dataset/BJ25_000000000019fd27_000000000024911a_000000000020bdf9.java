import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        int caseNum = 1;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int lineCount = in.nextInt();

            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < lineCount; j++) {
                Activity act = new Activity();
                for (int k = 0; k < 2; k++) {
                    int time = in.nextInt();
                    if (k == 0) {
                        act.setStartTime(time);
                    } else {
                        act.setEndTime(time);
                    }
                }
                act.setIndex(j);
                activities.add(act);
            }

            Collections.sort(activities);
            try {
                activities = solveProblem(activities);
                String result = "";
                int count = 0;
                List<String> results = activities.stream().sorted(new Comparator<Activity>() {

					@Override
					public int compare(Activity o1, Activity o2) {
						if(o1.getIndex() > o2.getIndex()) {
                            return 1;
                        } else {
                            return -1;
                        }
					}
                    
                }).map(x -> x.getPerson()).collect(Collectors.toList());
                for(String r : results) {
                    result = result+r;
                }
                stringBuilder.append(printResult(caseNum, result));
            } catch (Exception e) {
                stringBuilder.append(printResult(caseNum, "IMPOSSIBLE"));
            }
            caseNum++;
        }
        
        in.close();
        
        printAnswer(stringBuilder.toString());
    }

    private static List<Activity> solveProblem(List<Activity> activities) throws Exception {
        int startTime = 0;
        int endTime = 0;
        boolean isJ = false;
        Activity lastJAct = null;
        Activity lastCAct = null;

        for(int i = 0; i < activities.size(); i++) {
            Activity a = activities.get(i);
            if(i ==0) {
                a.setPerson("J");
                lastJAct = a;
                isJ = true;
            } else {
                startTime = a.getStartTime();
                if(startTime > endTime) {
                    if(isJ) {
                        a.setPerson("C");
                        lastCAct = a;
                        isJ = false;
                    } else {
                        a.setPerson("J");
                        lastJAct = a;
                        isJ = true;
                    }
                } else if(startTime == endTime) {
                    if(isJ) {
                        if(lastJAct != null) {
                            int lastEndtime = lastJAct.getEndTime();
                            if(lastEndtime > a.getStartTime()) {
                                throw new Exception("Impossible");
                            }
                        }
                        a.setPerson("J");
                        lastJAct = a;
                        isJ = true;
                    } else {
                        if(lastCAct != null) {
                            int lastEndtime = lastCAct.getEndTime();
                            if(lastEndtime > a.getStartTime()) {
                                throw new Exception("Impossible");
                            }
                        }
                        a.setPerson("C");
                        lastCAct = a;
                        isJ = false;
                    }
                } else {
                    if(isJ) {
                        //C
                        if(lastCAct != null) {
                            int lastEndtime = lastCAct.getEndTime();
                            if(lastEndtime > a.getStartTime()) {
                                throw new Exception("Impossible");
                            }
                        }
                        a.setPerson("C");
                        lastCAct = a;
                        isJ = false;
                    } else {
                        //J
                        if(lastJAct != null) {
                            int lastEndtime = lastJAct.getEndTime();
                            if(lastEndtime > a.getStartTime()) {
                                throw new Exception("Impossible");
                            }
                        }
                        a.setPerson("J");
                        lastJAct = a;
                        isJ = true;
                    }
                }
                
                startTime = a.getStartTime();
                endTime = a.getEndTime();
            }
        }
        return activities;
    }

    public static String printResult(int caseNum, String result1) {
        return "Case #" + caseNum + ": " + result1 + "\n";
    }

    public static void printAnswer(String answer) {
        System.out.print(answer);
    }

    static class Activity implements Comparable<Activity> {
        int startTime;
        int endTime;
        int index;
        String person;

        public Activity() {
            this.startTime = 0;
            this.endTime = 0;
            this.index = -1;
            this.person = "";
        }

        public Activity(int s, int e) {
            this.startTime = s;
            this.endTime = e;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public int getIndex() {
            return index;
        }

        public void setStartTime(int s) {
            this.startTime = s;
        }

        public void setEndTime(int e) {
            this.endTime = e;
        }

        public void setIndex(int i) {
            this.index = i;
        }

        public String getPerson() {
            return this.person;
        }

        public void setPerson(String p) {
            this.person = p;
        }

        @Override
        public int compareTo(Activity o) {
            if(o.getStartTime() == this.startTime) {
                return 0;
            } else if(o.getStartTime() > this.startTime) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}