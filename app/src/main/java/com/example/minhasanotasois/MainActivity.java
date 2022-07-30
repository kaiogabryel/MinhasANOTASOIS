package com.example.minhasanotasois;

import android.os.Bundle;

import com.example.minhasanotasois.databinding.ContentMainBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Layout;
import android.view.View;

import com.example.minhasanotasois.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias preferencias;
    private ActivityMainBinding binding;
    private EditText editanotasao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        preferencias = new AnotacaoPreferencias(getApplicationContext());


        /*binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferencias = new AnotacaoPreferencias(getApplicationContext());
        editanotasao = binding.editeTexto.editanotasao;*/

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoRecuperado = editanotasao.getText().toString();
                if (textoRecuperado.equals("")) {
                    Snackbar.make(view, "preenja a anotasao", Snackbar.LENGTH_LONG).show();
                } else {
                    preferencias.salvaranotasao(textoRecuperado);
                    Snackbar.make(view, "anotasao salva", Snackbar.LENGTH_LONG).show();
                }
            }
        });
        String rEcuperaanotasao = preferencias.REcuperaanotasao();
        if ( !rEcuperaanotasao.equals("")){
            editanotasao.setText(rEcuperaanotasao);
        }

    }
}