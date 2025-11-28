package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SystemExceptionsDomain {

    public static boolean verificarNome(String nome) throws IllegalArgumentException {
        String regex = "^[\\p{L} ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nome);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Valor contém caracteres inválidos.");
        }
        return true;
    }

    public static boolean verificarRespUser(String respUser) {
        if (respUser == null) {
            return false;
        }
        return respUser.equalsIgnoreCase("s") || respUser.equalsIgnoreCase("n");
    }
}
