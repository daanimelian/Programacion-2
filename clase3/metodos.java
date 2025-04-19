package clase3;
public class metodos {


    public static LinkedStack<Character> stringToStack(String str) {
        LinkedStack<Character> string = new LinkedStack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            string.push(c);
        }
        return string;
    }

    public static Boolean esCapicua(String input) {
        LinkedStack<Character> stack = stringToStack(input);

        for (int i = 0; i < input.length(); i++) {
            char adelante = input.charAt(i);
            char atras   = stack.pop();
            if (adelante != atras) {
                return false;
            }
        }
        return true;

    }

    public static boolean isBalanced(String input) {
        LinkedStack<Character> stack = new LinkedStack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


}
