class Solution {
    public static String camelCase(String input) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            Character letter = input.charAt(i);

            if (letter.isUpperCase(letter)) {
                stringBuilder.append(" ");
                stringBuilder.append(letter);
            } else {
                stringBuilder.append(letter);
            }
        }

        return stringBuilder.toString();
    }
}