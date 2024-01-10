/**
 * String processing exercise 1.
 */
public class LowerCase {
    public static void main(String[] args) {
        String str = args[0];
        System.out.println(lowerCase(str));
    }

    /**
     * Returns a string which is identical to the original string,
     * except that all the upper-case letters are converted to lower-case letters.
     * Non-letter characters are left as is.
     */
    public static String lowerCase(String s) {

        // Create an empty string
        String lowerCaseWord = "";

        // Iterate through all the letters in the string and switch the upper case and lower case letters
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 'A') && (ch <= 'Z')) {
                lowerCaseWord += (char) (ch + 32);
            } else {
                lowerCaseWord += ch;
            }
        }
        return lowerCaseWord;
    }
}