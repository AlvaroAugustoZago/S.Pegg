package br.com.spegg;

public class Cronometro {
    long tempoInicio = 0;
    String msgExecucao;

    public void iniciar() {
        this.tempoInicio = System.currentTimeMillis();
    }

    public void setMsgExecucao(String msgExecucao) {
        this.msgExecucao += msgExecucao + " Tempo:" + (System.currentTimeMillis() - this.tempoInicio);
        System.out.println(getMsgExecucao());
    }

    public long encerrar() {
        return (System.currentTimeMillis() - this.tempoInicio);
    }

    public String getMsgExecucao() {
        return this.msgExecucao;
    }

}
