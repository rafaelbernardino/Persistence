package com.bernardino.persistence;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkConnection();
    }

    public void logar(View view) {
        String usuario = ((EditText) findViewById(R.id.etUsuarioId)).getText().toString();
        String senha = ((EditText) findViewById(R.id.etSenhaId)).getText().toString();
        CheckBox chManterConectado = (CheckBox) findViewById(R.id.cbConectadoId);
        if (usuario.equals("admin") && senha.equals("123")) {
            savePreferences(usuario, chManterConectado.isChecked());
            abriTela();
        } else {
            Toast.makeText(this, "Usuário ou senha inválido", Toast.LENGTH_LONG).show();
        }
    }

    private void checkConnection() {
        SharedPreferences sp = getSharedPreferences("PREFERENCES", MODE_PRIVATE);

        if (sp.getBoolean("manterConectado", false)) {
            abriTela();
        }
    }

    private void abriTela() {
        startActivity(new Intent(this, BookActivity.class));
    }

    private void savePreferences(String usuario, boolean isConectado) {
        SharedPreferences sp = getSharedPreferences("PREFERENCES", MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        e.putString("username", usuario);
        e.putBoolean("manterConectado", isConectado);
        e.commit();
    }
}
