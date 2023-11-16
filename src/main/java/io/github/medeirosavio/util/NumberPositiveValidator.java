package io.github.medeirosavio.util;

public class NumberPositiveValidator {

    public static void validateMaiorQueZero(Integer value, String fieldName) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException(fieldName + " deve ser maior que zero.");
        }
    }

    public static void validateMenorIgualZero(Integer value, String fieldName) {
        if (value == null || value > 0) {
            throw new IllegalArgumentException(fieldName + " deve ser maior ou igual a zero.");
        }
    }

    public static void validateMaiorQueOutro(Integer valor, Integer outroValor, String fieldName) {
        if (valor == null || outroValor == null || valor >= outroValor) {
            throw new IllegalArgumentException(fieldName + " deve ser maior que " + outroValor + ".");
        }
    }
}
