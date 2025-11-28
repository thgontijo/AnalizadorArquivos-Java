package domain;

import java.nio.file.Path;
import java.time.LocalDateTime;

public class SystemInfosDomain {
    private String userName;
    private LocalDateTime criacaoUser;
    private String pathArquivoString;
    private String ultimaModificacaoArquivo;
    private Path pathArquivo;
    private String respUser;
    private String pathRelatorioString;
    private String nomeArquivoRelatorio;
    private int qtdLetrasPalavras;
    private int qtdPalavrasArquivo;
    private int qtdEmailsEncontrados;
    private int qtdTelefonesEncontrados;
    private String pathRelatorioFinal;

    public String getPathRelatorioFinal() {
        return pathRelatorioFinal;
    }

    public void setPathRelatorioFinal(String pathRelatorioFinal) {
        this.pathRelatorioFinal = pathRelatorioFinal;
    }

    public int getQtdTelefonesEncontrados() {
        return qtdTelefonesEncontrados;
    }

    public void setQtdTelefonesEncontrados(int qtdTelefonesEncontrados) {
        this.qtdTelefonesEncontrados = qtdTelefonesEncontrados;
    }

    public int getQtdEmailsEncontrados() {
        return qtdEmailsEncontrados;
    }

    public void setQtdEmailsEncontrados(int qtdEmailsEncontrados) {
        this.qtdEmailsEncontrados = qtdEmailsEncontrados;
    }

    public int getQtdLetrasPalavras() {
        return qtdLetrasPalavras;
    }

    public void setQtdLetrasPalavras(int qtdLetrasPalavras) {
        this.qtdLetrasPalavras = qtdLetrasPalavras;
    }

    public int getQtdPalavrasArquivo() {
        return qtdPalavrasArquivo;
    }

    public void setQtdPalavrasArquivo(int qtdPalavrasArquivo) {
        this.qtdPalavrasArquivo = qtdPalavrasArquivo;
    }

    public String getNomeArquivoRelatorio() {
        return nomeArquivoRelatorio;
    }

    public void setNomeArquivoRelatorio(String nomeArquivoRelatorio) {
        this.nomeArquivoRelatorio = nomeArquivoRelatorio;
    }

    public String getPathRelatorioString() {
        return pathRelatorioString;
    }

    public void setPathRelatorioString(String pathRelatorioString) {
        this.pathRelatorioString = pathRelatorioString;
    }

    public String getRespUser() {
        return respUser;
    }

    public void setRespUser(String respUser) {
        this.respUser = respUser;
    }

    public String getUltimaModificacaoArquivo() {
        return ultimaModificacaoArquivo;
    }

    public void setUltimaModificacaoArquivo(String ultimaModificacaoArquivo) {
        this.ultimaModificacaoArquivo = ultimaModificacaoArquivo;
    }

    public Path getPathArquivo() {
        return pathArquivo;
    }

    public void setPathArquivo(Path pathArquivo) {
        this.pathArquivo = pathArquivo;
    }

    public String getPathArquivoString() {
        return pathArquivoString;
    }

    public void setPathArquivoString(String pathArquivoString) {
        this.pathArquivoString = pathArquivoString;
    }

    public LocalDateTime getCriacaoUser() {
        return criacaoUser;
    }

    public void setCriacaoUser(LocalDateTime criacaoUser) {
        this.criacaoUser = criacaoUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
