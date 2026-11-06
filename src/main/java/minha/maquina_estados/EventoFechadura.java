package minha.maquina_estados;

public interface EventoFechadura {
    default void digitarSenha(Fechadura fechadura, String tentativa) {}
    default void fecharPorta(Fechadura fechadura) {}
    default void desbloquear(Fechadura fechadura) {}
}