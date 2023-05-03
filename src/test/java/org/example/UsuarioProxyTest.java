package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioProxyTest {
    @BeforeEach
    void setUp() {
        BD.addUsuario(new Usuario(1, "pedro", "Completa"));
        BD.addUsuario(new Usuario(2, "carlos", "Media"));
    }

    @Test
    void deveRetornarDadosUsuario() {
        UsuarioProxy usuario = new UsuarioProxy(1);

        assertEquals(Arrays.asList("pedro", "Completa"), usuario.obterDados());
    }

    @Test
    void deveRetonarPermissaoUsuario() {
        Administrador administrador = new Administrador("Adm master", true);
        UsuarioProxy usuario = new UsuarioProxy(2);

        assertEquals(Arrays.asList("Media"), usuario.obterPermissao(administrador));
    }

    @Test
    void deveRetonarExcecaoAdministradorNaoAutorizadoConsultarPermissaoUsuario() {
        try {
            Administrador administrador = new Administrador("Adm sem permissao", false);
            UsuarioProxy usuario = new UsuarioProxy(2);

            usuario.obterPermissao(administrador);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Administrador sem permissão para esse usuario", e.getMessage());
        }
    }
}