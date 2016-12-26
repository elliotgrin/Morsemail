package com.morsemail.android.morsemail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Describes behavior of morse encoding
 */

public class MorseCode {
    /**
     * Mapping a char from Morse code to text
     */
    Map<ArrayList<Integer>, String> mCode;

    public MorseCode() {
        mCode = new HashMap<>();

        // Letters
        mCode.put(new ArrayList<>(Arrays.asList(0, 1)), "а");
        mCode.put(new ArrayList<>(Arrays.asList(1, 0, 0, 0)), "б");
        mCode.put(new ArrayList<>(Arrays.asList(0, 1, 1)), "в");
        mCode.put(new ArrayList<>(Arrays.asList(1, 1, 0)), "г");
        mCode.put(new ArrayList<>(Arrays.asList(1, 0, 0)), "д");
        mCode.put(new ArrayList<>(Arrays.asList(0)), "е");
        mCode.put(new ArrayList<>(Arrays.asList(0, 0, 0, 1)), "ж");
        mCode.put(new ArrayList<>(Arrays.asList(1, 1, 0, 0)), "з");
        mCode.put(new ArrayList<>(Arrays.asList(0, 0)), "и");
        mCode.put(new ArrayList<>(Arrays.asList(0, 1, 1, 1)), "й");
        mCode.put(new ArrayList<>(Arrays.asList(1, 0, 1)), "к");
        mCode.put(new ArrayList<>(Arrays.asList(0, 1, 0, 0)), "л");
        mCode.put(new ArrayList<>(Arrays.asList(1, 1)), "м");
        mCode.put(new ArrayList<>(Arrays.asList(1, 0)), "н");
        mCode.put(new ArrayList<>(Arrays.asList(1, 1, 1)), "о");
        mCode.put(new ArrayList<>(Arrays.asList(0, 1, 1, 0)), "п");
        mCode.put(new ArrayList<>(Arrays.asList(0, 1, 0)), "р");
        mCode.put(new ArrayList<>(Arrays.asList(0, 0, 0)), "с");
        mCode.put(new ArrayList<>(Arrays.asList(1)), "т");
        mCode.put(new ArrayList<>(Arrays.asList(0, 0, 1)), "у");
        mCode.put(new ArrayList<>(Arrays.asList(0, 0, 1, 0)), "ф");
        mCode.put(new ArrayList<>(Arrays.asList(0, 0, 0, 0)), "х");
        mCode.put(new ArrayList<>(Arrays.asList(1, 0, 1, 0)), "ц");
        mCode.put(new ArrayList<>(Arrays.asList(1, 1, 1, 0)), "ч");
        mCode.put(new ArrayList<>(Arrays.asList(1, 1, 1, 1)), "ш");
        mCode.put(new ArrayList<>(Arrays.asList(1, 1, 0, 1)), "щ");
        mCode.put(new ArrayList<>(Arrays.asList(1, 0, 0, 1)), "ь");
        mCode.put(new ArrayList<>(Arrays.asList(1, 0, 1, 1)), "ы");
        mCode.put(new ArrayList<>(Arrays.asList(0, 0, 1, 0, 0)), "э");
        mCode.put(new ArrayList<>(Arrays.asList(0, 0, 1, 1)), "ю");
        mCode.put(new ArrayList<>(Arrays.asList(0, 1, 0, 1)), "я");

        // Digits
        mCode.put(new ArrayList<>(Arrays.asList(0, 1, 1, 1, 1)), "1");
        mCode.put(new ArrayList<>(Arrays.asList(0, 0, 1, 1, 1)), "2");
        mCode.put(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1)), "3");
        mCode.put(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1)), "4");
        mCode.put(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0)), "5");
        mCode.put(new ArrayList<>(Arrays.asList(1, 0, 0, 0, 0)), "6");
        mCode.put(new ArrayList<>(Arrays.asList(1, 1, 0, 0, 0)), "7");
        mCode.put(new ArrayList<>(Arrays.asList(1, 1, 1, 0, 0)), "8");
        mCode.put(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 0)), "9");
        mCode.put(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)), "0");

        // Punctuation marks
        mCode.put(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0)), ".");
        mCode.put(new ArrayList<>(Arrays.asList(0, 1, 0, 1, 0, 1)), ",");
        mCode.put(new ArrayList<>(Arrays.asList(1, 0, 1, 0, 1, 0)), ";");
        mCode.put(new ArrayList<>(Arrays.asList(1, 1, 1, 0, 0, 0)), ":");
        mCode.put(new ArrayList<>(Arrays.asList(0, 0, 1, 1, 0, 0)), "?");
        mCode.put(new ArrayList<>(Arrays.asList(1, 1, 0, 0, 1, 1)), "!");
        mCode.put(new ArrayList<>(Arrays.asList(1, 0, 0, 0, 0, 1)), "-");
        mCode.put(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1, 0)), "\"");
        mCode.put(new ArrayList<>(Arrays.asList(1, 0, 1, 1, 0, 1)), "|"); // opened or closed bracket
        mCode.put(new ArrayList<>(Arrays.asList(1, 0, 0, 1, 0)), "/");
    }

    String getChar(ArrayList<Integer> charCode) {
        return (mCode.get(charCode) != null) ? mCode.get(charCode) : "";
    }
}
