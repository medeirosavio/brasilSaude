package io.github.medeirosavio.util;

public class IdValidator {

    public static boolean isIdValid(Long id) {
        // Verifique se o ID é maior que zero (um valor válido para um ID)
        // ou adicione outras verificações específicas do seu domínio

        return id != null && id > 0;
    }
}
