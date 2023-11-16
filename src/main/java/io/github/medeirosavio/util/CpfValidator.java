package io.github.medeirosavio.util;

public class CpfValidator {

    private static final String CPF_PATTERN = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})$";

    public static boolean isValid(String cpf) {
        if (cpf == null || !cpf.matches(CPF_PATTERN)) {
            return false;
        }

        cpf = cpf.replaceAll("[^\\d]", ""); // Remove caracteres não numéricos

        // Verifica se todos os dígitos são iguais, o que tornaria o CPF inválido
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int d1 = calcularDigito(cpf.substring(0, 9), 10);
        // Calcula o segundo dígito verificador
        int d2 = calcularDigito(cpf.substring(0, 9) + d1, 11);

        // Verifica se os dígitos calculados são iguais aos fornecidos
        return cpf.equals(cpf.substring(0, 9) + String.valueOf(d1) + String.valueOf(d2));
    }

    private static int calcularDigito(String str, int peso) {
        int soma = 0;
        for (int i = 0; i < str.length(); i++) {
            soma += Integer.parseInt(str.substring(i, i + 1)) * (peso - i);
        }
        int resto = soma % 11;
        return resto < 2 ? 0 : 11 - resto;
    }

    public static void main(String[] args) {
        // Exemplo de uso
        String cpf1 = "123.456.789-09";
        String cpf2 = "111.222.333-44";

        System.out.println(cpf1 + " é válido? " + isValid(cpf1));
        System.out.println(cpf2 + " é válido? " + isValid(cpf2));
    }

}
