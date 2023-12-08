package io.github.jubadeveloper;

import io.github.jubadeveloper.converter.RomanConverter;

public class Main {
    public static void main(String[] args) throws Exception {
        RomanConverter romanConverter = new RomanConverter();
        String roman = args[0];
        System.out.println(romanConverter.converterIn(roman));
    }
}