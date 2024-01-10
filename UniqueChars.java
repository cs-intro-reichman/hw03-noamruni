/**
 * String processing exercise 2.
 */
public class UniqueChars {
    public static void main(String[] args) {
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string,
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        String uniqueWord = "";

        // Iterate through all the letters in the string and add the unique ones to the empty string
        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            if (uniqueWord.indexOf(currentCharacter) == -1 || currentCharacter == ' ') {
                uniqueWord += currentCharacter;

            }
        }
        return uniqueWord;
    }
}