package com.Controller;

import com.Model.CadastroUsuarios;

public class ControladorAdicionarUsuario {
   public ControladorAdicionarUsuario(){

   }

   public void adicionarUsuario(){
      new CadastroUsuarios().adicionarUsuarios();
   }

}
