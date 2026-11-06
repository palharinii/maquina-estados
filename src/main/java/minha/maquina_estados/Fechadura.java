package minha.maquina_estados;

import lombok.Getter;

@Getter
public class Fechadura {
    public static final int LIMITE = 3;

    private final String pin;
    private EstadoFechadura estadoAtual;
    private final Notificador notificador;
    private int contador;

    public Fechadura(String pin) {
        this.pin = pin;
        this.estadoAtual = EstadoFechadura.TRANCADO;
        this.notificador = new Notificador();
    }

    public void mudarEstado(EstadoFechadura estadoNovo) {
        this.estadoAtual = estadoNovo;
    }

    public void digitarSenha(String tentativa) {
        this.estadoAtual.digitarSenha(this, tentativa);
    }

    public void fecharPorta() {
        this.estadoAtual.fecharPorta(this);
    }

    public void desbloquear() {
        this.estadoAtual.desbloquear(this);
    }

    public boolean validarSenha(String tentativa) {
        return pin.equals(tentativa);
    }

    public void incrementarContador() {
        this.contador++;
    }

    public void zerarContador() {
        this.contador = 0;
    }

    public void notificarAcessoLiberado() {
        notificador.acessoLiberado();
    }

    public void notificarAcessoNegado() {
        notificador.acessoNegado();
    }

    public void notificarAcessoBloqueado() {
        notificador.acessoBloqueado();
    }
}