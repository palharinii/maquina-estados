package minha.maquina_estados;

public class Main {
    public static void main(String[] args) {
        Fechadura fechadura = new Fechadura("1234");

        fechadura.digitarSenha("123"); // trancado (1x)
        fechadura.digitarSenha("123"); // trancado (2x)
        fechadura.digitarSenha("1234"); // destrancado

        fechadura.fecharPorta(); // trancado

        fechadura.digitarSenha("123"); // trancado (1x)
        fechadura.digitarSenha("123"); // trancado (2x)
        fechadura.digitarSenha("123"); // bloqueado

        fechadura.desbloquear(); // desbloqueado

        fechadura.digitarSenha("123"); // trancado (1x)
        fechadura.digitarSenha("1234"); // destrancado
    }
}