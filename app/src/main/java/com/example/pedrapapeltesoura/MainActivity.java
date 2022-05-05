package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imagemResultado = findViewById(R.id.imagemResultado);
        TextView textoResultado = findViewById(R.id.textoResultado);

        int numero = new Random().nextInt(3); // 0 1 2
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {
            case "Pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if ( //App ganhador
                (escolhaApp == "Tesoura" && escolhaUsuario == "Papel") ||
                        (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ||
                        (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura")
        ) {
            textoResultado.setText("Você perdeu :(");
        } else if ( //Usuario ganhador
                (escolhaUsuario == "Tesoura" && escolhaApp == "Papel") ||
                        (escolhaUsuario == "Papel" && escolhaApp == "Pedra") ||
                        (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura")
        ) {
            textoResultado.setText("Você ganhou! :D");
        } else { //Empate
            textoResultado.setText("EMPATAMOS!");
        }
    }
}