package domain;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SystemMethodsDomain {
    private static SystemInfosDomain systemInfos2;

    public SystemMethodsDomain(SystemInfosDomain systemInfos) {
        SystemMethodsDomain.systemInfos2 = systemInfos;
    }

    public static void contaQtdPalavrasLetrasArquivo(String pathFile) {
        int countLengthFile = 0;
        int countLengthWords = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile))) {
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String regex = "\\p{L}+";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(linha);
                while (matcher.find()) {
                    countLengthFile++;
                    String palavraEncontrada = matcher.group();
                    countLengthWords += palavraEncontrada.length();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Quantidade de palavras no arquivo: " + countLengthFile);
        systemInfos2.setQtdPalavrasArquivo(countLengthFile);
        System.out.println();
        System.out.println("Quantidade de caracteres em palavras: " + countLengthWords);
        systemInfos2.setQtdLetrasPalavras(countLengthWords);
    }

    public static int contadorQtdCaracteresGerais(String pathFile) {
        int contadorCaracteresGerais = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile))) {
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                contadorCaracteresGerais += linha.length();
            }
        } catch (FileNotFoundException e) {
            System.out.println();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Quantidade caracteres gerais: " + contadorCaracteresGerais);
        return contadorCaracteresGerais;
    }

    public static String[] encontrarEmailsArquivo(String pathFile) {
        int contadorQtdEmails = 0;
        String regex = "[A-Za-z0-9._%+-]+@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,}";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        String linha;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile))) {
            System.out.println();
            System.out.println("Emails encontrados: ");
            while ((linha = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(linha);
                while (matcher.find()) {
                    System.out.println(" [" + matcher.group() + "] ");
                    contadorQtdEmails++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("Quantidade de emails encontados: " + contadorQtdEmails);
        systemInfos2.setQtdEmailsEncontrados(contadorQtdEmails);
        System.out.println();

        String[] emails = new String[contadorQtdEmails];

        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            while ((linha = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(linha);
                while (matcher.find()) {
                    emails[index++] = matcher.group();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emails;
    }


    public static String[] contarQtdNumerosTelefonicos(String pathFile) {
        String regex = "(\\+?\\d{1,3}\\s?)?(?:\\(\\d{2}\\)|\\d{2})[\\s-]?\\d{4,5}-?\\d{4}";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        String linha;
        int contadorQtdTelefones = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile))) {
            System.out.println("Numeros de telefone encontrados: ");
            while ((linha = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(linha);
                while (matcher.find()) {
                    System.out.println(" [" + matcher.group() + "] ");
                    contadorQtdTelefones++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Quantidade de numeros encontrados: " + contadorQtdTelefones);
        systemInfos2.setQtdTelefonesEncontrados(contadorQtdTelefones);
        System.out.println();

        String[] telefones = new String[contadorQtdTelefones];
        int index = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile))) {
            while ((linha = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(linha);
                while (matcher.find()) {
                    telefones[index++] = matcher.group();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return telefones;
    }

    public static String ultimaModificacaoArquivo(Path pathfile) {
        String formatado = null;
        try {
            FileTime fileTimeUltimaModificacao = Files.getLastModifiedTime(pathfile);
            Instant instantUltimaModificacao = fileTimeUltimaModificacao.toInstant();
            LocalDateTime localDateTimeUltimaModificacao = LocalDateTime.ofInstant(instantUltimaModificacao, ZoneId.systemDefault());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            formatado = localDateTimeUltimaModificacao.format(dateTimeFormatter);
            System.out.println();
            System.out.println("Ultima modificação: " + formatado);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return formatado;
    }

    public static Boolean criarRelatorio(String pathRelatorio) {
        try {
            Path dir = Path.of(pathRelatorio);
            Files.createDirectories(dir);
            Path arquivo = dir.resolve(systemInfos2.getNomeArquivoRelatorio() + ".txt");
            systemInfos2.setPathRelatorioFinal(String.valueOf(arquivo));
            if (Files.exists(arquivo)) {
                return false;
            }
            Files.createFile(arquivo);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean escrevendoInfosRelatorio(String pathRelatorio) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathRelatorio))) {
            bufferedWriter.write("- Ultima modificação do arquivo: " + SystemMethodsDomain.ultimaModificacaoArquivo(systemInfos2.getPathArquivo()));
            bufferedWriter.newLine();
            bufferedWriter.write("- Quantidade de palavras no arquivo: " + systemInfos2.getQtdPalavrasArquivo());
            bufferedWriter.newLine();
            bufferedWriter.write("- Quantidade de caracteres em palavras: " + systemInfos2.getQtdLetrasPalavras());
            bufferedWriter.newLine();
            bufferedWriter.write("- Quantidade de caracteres gerais: " + SystemMethodsDomain.contadorQtdCaracteresGerais(systemInfos2.getPathArquivoString()));
            bufferedWriter.newLine();
            bufferedWriter.write("- Emails encontrados: ");
            String[] encontrarEmailsArquivo = SystemMethodsDomain.encontrarEmailsArquivo(systemInfos2.getPathArquivoString());
            for (String string : encontrarEmailsArquivo) {
                bufferedWriter.write(" [ " + string + " ] ");
            }
            bufferedWriter.newLine();
            bufferedWriter.write("- Quantidade de emails encontrados: " + systemInfos2.getQtdEmailsEncontrados());
            bufferedWriter.newLine();
            bufferedWriter.write("- Numeros de telefones encontrados: ");
            String[] contarQtdNumerosTelefonicos = SystemMethodsDomain.contarQtdNumerosTelefonicos(systemInfos2.getPathArquivoString());
            for (String string : contarQtdNumerosTelefonicos) {
                bufferedWriter.write(" [ " + string + " ] ");
            }
            bufferedWriter.newLine();
            bufferedWriter.write("- Quantidade de telefones encontrados: " + systemInfos2.getQtdTelefonesEncontrados());
            bufferedWriter.newLine();
            bufferedWriter.write("- Arquivo criado pelo usuário: " + systemInfos2.getUserName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static void limpaTela(){
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }
}
