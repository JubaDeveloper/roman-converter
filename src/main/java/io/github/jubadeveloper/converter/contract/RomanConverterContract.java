package io.github.jubadeveloper.converter.contract;

import io.github.jubadeveloper.converter.exceptions.InputException;

public interface RomanConverterContract {
    Double converterIn (String in) throws InputException;
    void validateIn (String in) throws InputException;
}
