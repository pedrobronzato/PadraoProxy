package org.example;

import java.util.Arrays;
import java.util.List;

public class Usuario implements IUsuario {

    private Integer id;
    private String usuario;
    private String permissao;

    public Usuario(int id) {
        this.id = id;
        Usuario objeto = BD.getUsuario(id);
        this.usuario = objeto.usuario;
        this.permissao = objeto.permissao;
    }

    public Usuario(Integer id, String usuario, String permissao) {
        this.id = id;
        this.usuario = usuario;
        this.permissao = permissao;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public List<String> obterDados() {
        return Arrays.asList(this.usuario, this.permissao);
    }

    @Override
    public List<String> obterPermissao(Administrador administrador) {
        return Arrays.asList(this.permissao);
    }
}
