package mx.itesm.kikelonches.util;

public class HtmlEncoder {
    public static String encode(final String input) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c > 127 || c == '"' || c == '<' || c == '>' || c == '&') {
                output.append("&#");
                output.append((int) c);
                output.append(';');
            } else {
                output.append(c);
            }
        }

        return output.toString();
    }
}
