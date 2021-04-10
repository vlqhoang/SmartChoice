package vlqhoang.project.smartchoice.rdPartyMockService.utils;

public class NumberUtils {

    /**
     * @param min - The minimum.
     * @param max - The maximum.
     * @return A random double between these numbers (inclusive the minimum and maximum).
     */
    public static double getRandom(double min, double max) {
        return roundOff((Math.random() * (max + 1 - min)) + min);
    }

    public static double roundOff(double number) {
        return (double) Math.round(number * 100) / 100;
    }
}
