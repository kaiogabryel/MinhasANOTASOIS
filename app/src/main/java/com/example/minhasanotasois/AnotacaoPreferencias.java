package com.example.minhasanotasois;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;

public class AnotacaoPreferencias {
   private Context context;
   private final String NOME_ARQUIVO = "ANOTASA.preferensia" ;
   private SharedPreferences preferences;
   private SharedPreferences.Editor editor;
   private final String CHAVE_NOME = "nome";

   public AnotacaoPreferencias(Context C) {
      this.context = C;
      preferences = context.getSharedPreferences(NOME_ARQUIVO,0);
   }

   public void salvaranotasao(String anotacao){
      editor = preferences.edit();
      editor.putString(NOME_ARQUIVO,anotacao);
      editor.commit();

   }

   public String REcuperaanotasao (){

      return preferences.getString(NOME_ARQUIVO,"");
   }

}
