package minha.maquina_estados;

public enum EstadoFechadura implements EventoFechadura {
    TRANCADO {
        @Override
        public void digitarSenha(Fechadura fechadura, String tentativa) {
            if(fechadura.validarSenha(tentativa)) {
                fechadura.zerarContador();
                fechadura.mudarEstado(DESTRANCADO);
                fechadura.notificarAcessoLiberado();
            } else {
                fechadura.incrementarContador();

                if(fechadura.getContador() >= Fechadura.LIMITE) {
                    fechadura.mudarEstado(BLOQUEADO);
                    fechadura.notificarAcessoBloqueado();
                } else {
                    fechadura.notificarAcessoNegado();
                }
            }
        }
    },

    DESTRANCADO {
        @Override
        public void fecharPorta(Fechadura fechadura) {
            fechadura.mudarEstado(TRANCADO);
        }
    },

    BLOQUEADO {
        @Override
        public void desbloquear(Fechadura fechadura) {
            fechadura.zerarContador();
            fechadura.mudarEstado(TRANCADO);
        }
    }
}