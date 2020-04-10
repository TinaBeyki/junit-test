public class ActivityCalculator {

    private static final int WORKOUT_DURATION_MIN = 45;

    public static String rateActivityLevel(int weeklyCardioMin, int weeklyWorkoutSession) {

        int totalMinutes = weeklyCardioMin + weeklyWorkoutSession * WORKOUT_DURATION_MIN;
        double avgDailyActivityMins = totalMinutes / 7.0;
        if (avgDailyActivityMins < 20) {
            return "bad";
        }

        if (avgDailyActivityMins <= 40 && avgDailyActivityMins >= 20) {
            return "average";
        }

        if(weeklyCardioMin == 0 || weeklyWorkoutSession == 0) {
            throw new RuntimeException("input below 0");
        }
        return "good";
    }
}
