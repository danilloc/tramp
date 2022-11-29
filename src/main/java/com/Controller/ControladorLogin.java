package com.Controller;

import com.Model.ValidacaoUsuarios;

public class ControladorLogin {

    public ControladorLogin(){

    }

    public void efetuarLogin(){
        ValidacaoUsuarios validacaoUsuarios = new ValidacaoUsuarios();
        boolean podeLogar =  validacaoUsuarios.checar();

        if (podeLogar){
            registraSessao();
        }

    }

    public void registraSessao(){

    }


}
