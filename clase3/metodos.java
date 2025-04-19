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


}
