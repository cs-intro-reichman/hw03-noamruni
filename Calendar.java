/**
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {
    // Starting the calendar on 1/1/1900
    static int dayOfMonth = 1;
    static int month = 1;
    static int year = 1900;
    static int dayOfWeek = 2;     // 1.1.1900 was a Monday
    static int nDaysInMonth = 31; // Number of days in January

    /**
     * Prints the calendars of all the years in the 20th century. Also prints the
     * number of Sundays that occured on the first day of the month during this period.
     */
    public static void main(String args[]) {
        // Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
        // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
        // The following variable, used for debugging purposes, counts how many days were advanced so far.
        int debugDaysCounter = 0;

        // Parse the command line
        int givenYear = Integer.parseInt(args[0]);

        // Make sure the given year is greater than 1900
        if (givenYear < 1900) {
            System.out.printf("%d is an invalid year\n", givenYear);
            System.exit(1);
        }
        //// Write the necessary initialization code, and replace the condition
        //// of the while loop with the necessary condition
        while (year <= givenYear) {
            if (year == givenYear) {
                if (dayOfWeek == 1) {
                    System.out.printf("%d/%d/%d Sunday\n", dayOfMonth, month, year);
                } else {
                    System.out.printf("%d/%d/%d\n", dayOfMonth, month, year);
                }
            }
            advance();
            debugDaysCounter++;
            //// If you want to stop the loop after n days, replace the condition of the
            //// if statement with the condition (debugDaysCounter == n)
            //            if (debugDaysCounter == n) {
            //                break;
            //            }
        }
    }

    // Advances the date (day, month, year) and the day-of-the-week.
    // If the month changes, sets the number of days in this month.
    // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
    private static void advance() {
        // Advances day in the week
        if (++dayOfWeek > 7) {
            dayOfWeek = 1;
        }
        // Advances day in month, month and year
        if (++dayOfMonth > nDaysInMonth(month, year)) {
            dayOfMonth = 1;
            if (++month > 12) {
                month = 1;
                year++;
            }
        }
    }

    // Returns true if the given year is a leap year, false otherwise.
    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0) || year % 400 == 0);
    }

    // Returns the number of days in the given month and year.
    // April, June, September, and November have 30 days each.
    // February has 28 days in a common year, and 29 days in a leap year.
    // All the other months have 31 days.
    private static int nDaysInMonth(int month, int year) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                return 31;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            case 4, 6, 9, 11:
                return 30;
            default:
                return -1;
        }
    }
}