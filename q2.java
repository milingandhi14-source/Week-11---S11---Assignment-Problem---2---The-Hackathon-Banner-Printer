
import java.util.Stack;

public class q2 {

    public static String expandBanner(String code) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int count = 0;

        for (int i = 0; i < code.length(); i++) {

            char ch = code.charAt(i);

            // Read the repeat number
            if (Character.isDigit(ch)) {

                count = count * 10 + (ch - '0');
            }

            // Opening bracket
            else if (ch == '[') {

                countStack.push(count);
                stringStack.push(current);

                current = new StringBuilder();
                count = 0;
            }

            // Closing bracket
            else if (ch == ']') {

                int repeat = countStack.pop();
                StringBuilder previous = stringStack.pop();

                for (int j = 0; j < repeat; j++) {
                    previous.append(current);
                }

                current = previous;
            }

            // Normal character
            else {

                current.append(ch);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {

        String code1 = "3[ab]2[c]";
        String code2 = "2[x3[y]]z";

        System.out.println("Input: " + code1);
        System.out.println("Output: " + expandBanner(code1));

        System.out.println();

        System.out.println("Input: " + code2);
        System.out.println("Output: " + expandBanner(code2));
    }
}
