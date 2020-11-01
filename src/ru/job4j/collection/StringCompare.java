package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int maxLength = Integer.max(left.length(), right.length());
        List<Character> listLeft = StringCompare.convertStringToCharList(left, maxLength);
        List<Character> listRight = StringCompare.convertStringToCharList(right, maxLength);

        for (int i = 0; i < maxLength; i++) {
            int res = Character.compare(listLeft.get(i), listRight.get(i));
            if (res != 0) {
                return res;
            }
        }
        return 0;
    }

    public static List<Character> convertStringToCharList(String str, int maxLength) {
        List<Character> chars = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            chars.add(ch);
        }
        for (int i = chars.size(); i < maxLength; i++) {
            chars.add(Character.MIN_VALUE);
        }
        return chars;
    }

    public static void main(String[] args) {
        StringCompare stringCompare = new StringCompare();
        int res = stringCompare.compare("Ivanov", "Ivanova");
        System.out.println(res);
    }
}