package minha.maquina_estados;

public interface Notificavel {
    void acessoLiberado();
    void acessoNegado();
    void acessoBloqueado();
}