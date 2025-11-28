package application;

import domain.SystemExceptionsDomain;
import domain.SystemInfosDomain;
import domain.SystemMethodsDomain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.text.Format;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SystemApplicationTest {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        SystemInfosDomain systemInfos = new SystemInfosDomain();
        boolean isVerificationUser = false;
        boolean isUserVerifier;
        SystemMethodsDomain systemMethods = new SystemMethodsDomain(systemInfos);

        do {
            System.out.println("Digite o nome do usuário: ");
            systemInfos.setUserName(entrada.nextLine());
            systemInfos.setCriacaoUser(LocalDateTime.now());
            try {
                isVerificationUser = SystemExceptionsDomain.verificarNome(systemInfos.getUserName());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        } while (!isVerificationUser);

        //C:\Users\tsilv\IdeaProjects\ControladorDeArquivos\src\application\VerificarLista.txt
        //C:\Users\tsilv\Desktop\pastaRelatorio

        System.out.println("Digite o path do arquivo que deseja ver as informações: ");
        String pathArquivo = entrada.nextLine();
        Path pathArquivoNormalizado = Path.of(pathArquivo).normalize();
        systemInfos.setPathArquivoString(pathArquivoNormalizado.toString());
        systemInfos.setPathArquivo(Path.of(systemInfos.getPathArquivoString()));
        systemInfos.setUltimaModificacaoArquivo(SystemMethodsDomain.ultimaModificacaoArquivo(systemInfos.getPathArquivo()));
        SystemMethodsDomain.contaQtdPalavrasLetrasArquivo(systemInfos.getPathArquivoString());
        SystemMethodsDomain.contadorQtdCaracteresGerais(systemInfos.getPathArquivoString());
        SystemMethodsDomain.encontrarEmailsArquivo(systemInfos.getPathArquivoString());
        SystemMethodsDomain.contarQtdNumerosTelefonicos(systemInfos.getPathArquivoString());

        do {
            System.out.println("Deseja criar um relatório .txt? (S/N)");
            systemInfos.setRespUser(entrada.nextLine());
            isUserVerifier = SystemExceptionsDomain.verificarRespUser(systemInfos.getRespUser());
        } while (!isUserVerifier);
        if(systemInfos.getRespUser().equalsIgnoreCase("n")) {
            return;
        }

        System.out.println("Digite o nome do arquivo do relatório: ");
        systemInfos.setNomeArquivoRelatorio(entrada.nextLine());
        System.out.println("Digite o path para o relatório: ");
        String pathRelatorio = entrada.nextLine();
        Path pathRelatorioNormalizado = Path.of(pathRelatorio).normalize();
        systemInfos.setPathRelatorioString(pathRelatorioNormalizado.toString());

        Boolean isRelatorioCreated = SystemMethodsDomain.criarRelatorio(systemInfos.getPathRelatorioString());
        boolean isRelatorioModified = SystemMethodsDomain.escrevendoInfosRelatorio(systemInfos.getPathRelatorioFinal());
        SystemMethodsDomain.limpaTela();
        System.out.println("Relatório foi criado: " + isRelatorioCreated);
        System.out.println("Relatório foi modificado: " + isRelatorioModified);
    }
}
