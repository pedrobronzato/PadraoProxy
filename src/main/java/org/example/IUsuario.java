package org.example;

import java.util.List;

public interface IUsuario {
    List<String> obterDados();

    List<String> obterPermissao(Administrador administrador);
}
