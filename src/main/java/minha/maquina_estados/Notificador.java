package minha.maquina_estados;

public class Notificador implements Notificavel {
    @Override
    public void acessoLiberado() {
        System.out.println("acesso liberado!");
    }

    @Override
    public void acessoNegado() {
        System.out.println("acesso negado!");
    }

    @Override
    public void acessoBloqueado() {
        System.out.println("acesso bloqueado!");
    }
}