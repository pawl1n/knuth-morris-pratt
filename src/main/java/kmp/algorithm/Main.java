package kmp.algorithm;

public class Main {
    public static void main(String[] args) {
        String text = "abcabcdabcabdabcabca";
        String word = "abcabca";

        // when
        int index = Main.kmpSearch(text, word);
        System.out.println(index);
    }

    public static int kmpSearch(String text, String word) {
        char[] textChars = text.toCharArray();
        char[] wordChars = word.toCharArray();

        int[] prefixArr = findPrefix(word);

        int j = 0;
        int i = 0;
        while (i < textChars.length) {
            if (textChars[i] == wordChars[j]) {
                i++;
                j++;
                if (j == wordChars.length) {
                    return i - j;
                }
            } else if (j > 0) {
                j = prefixArr[j - 1];
            }
        }

        return -1;
    }

    public static int[] findPrefix(String word) {
        int[] prefixArr = new int[word.length()];
        char[] letters = word.toCharArray();
        int index = 0;

        int i = 1;
        while (i < prefixArr.length) {
            if (letters[i] == letters[index]) {
                prefixArr[i] = ++index;
                i++;
            } else if (index > 0) {
                index = prefixArr[index-1];
            } else {
                prefixArr[i] = 0;
                i++;
            }
        }

        return prefixArr;
    }
}