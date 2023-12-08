package io.github.jubadeveloper.converter;

import io.github.jubadeveloper.converter.contract.RomanConverterContract;
import io.github.jubadeveloper.converter.exceptions.InputException;

import java.util.*;

public class RomanConverter implements RomanConverterContract {
    private static final Map<String, Long> romanValueMap = new HashMap<>();
    static {
        romanValueMap.putAll(Map.of(
                "I", 1L,
                "V", 5L,
                "X", 10L,
                "L", 50L,
                "C", 100L,
                "D", 500L,
                "M", 100L)
        );
    }
    @Override
    public Double converterIn(String in) throws InputException {
        this.validateIn(in);
        List<String> roman = Arrays.asList(in.split(""));
        double result = 0;
        for (int i = 0; i < roman.size(); i++) {
          double current = romanValueMap.get(roman.get(i));
          double next = i + 1 >= roman.size() ? 0 : romanValueMap.get(roman.get(i + 1));
          if (current < next) {
              result -= current;
          } else {
              result += current;
          }
        }
        return result;
    }

    @Override
    public void validateIn(String in) throws InputException {
        if (in.equals("")) throw new InputException("Input cant be empty");
        if (!in
                .toLowerCase(Locale.ROOT)
                .matches("^[ivxlcdm]+$")) throw new InputException("Invalid input format");
    }
}
