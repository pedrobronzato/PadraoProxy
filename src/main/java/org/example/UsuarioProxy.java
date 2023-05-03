package org.example;

import java.util.List;

public class UsuarioProxy implements IUsuario {

    private Usuario usuario;

    private Integer id;

    public UsuarioProxy(Integer id) {
        this.id = id;
    }

    @Override
    public List<String> obterDados() {
        if (this.usuario == null) {
            this.usuario = new Usuario(this.id);
        }
        return this.usuario.obterDados();
    }

    @Override
    public List<String> obterPermissao(Administrador administrador) {
        if (!administrador.isAdministradorMaster()) {
            throw new IllegalArgumentException("Administrador sem permissão para esse usuario");
        }
        if (this.usuario == null) {
            this.usuario = new Usuario(this.id);
        }
        return this.usuario.obterPermissao(administrador);
    }
}
