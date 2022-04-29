package com.example.consumidorapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.consumidorapp.R;
import com.example.consumidorapp.adapter.AdapterConsumidor;
import com.example.consumidorapp.databinding.ActivityMainBinding;
import com.example.consumidorapp.model.Produtos;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private TextView textView;
    private List<Produtos> produtosList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        login();
    }

    private void login()
    {
        binding.botaoLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String usuario = binding.usuario.getText().toString();
                String senha   = binding.senha.getText().toString();

                if( usuario.equals("usuario") && senha.equals("123456"))
                {
                    binding.TextoInit.setText("Senha correta!! ");
                    setContentView(R. layout . lista_produtos);
                    lista_recicler();
                    iniciaThread();
                }
                else
                {
                    binding.TextoInit.setText("Usuario ou Senha incorreta!! ");
                }
            }
        });
    }

    private void lista_recicler()
    {
        RecyclerView recylerview_p = findViewById(R.id.recyclerView);
        textView = findViewById(R.id.mostra_thread);

        // Configurar o Adapter
        teste_inflaLista();
        AdapterConsumidor consumidor = new AdapterConsumidor( produtosList );

        //Configurar Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recylerview_p.setLayoutManager(layoutManager);
        recylerview_p.setHasFixedSize(true);
        recylerview_p.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recylerview_p.setAdapter( consumidor ); // Adapter monta avisualização
    }

    private void teste_inflaLista()
    {
        Produtos lista_produtos = new Produtos("Produto 1", "R$ 150,00", "Descrição 1");
        produtosList.add( lista_produtos );

        lista_produtos = new Produtos("Produto 2", "R$ 152,00", "Descrição 2");
        produtosList.add( lista_produtos );

        lista_produtos = new Produtos("Produto 3", "R$ 153,00", "Descrição 3");
        produtosList.add( lista_produtos );
    }

    private void iniciaThread()
    {
        TesteThread thread = new TesteThread();
        thread.start();
    }

    class TesteThread extends Thread{

        @Override
        public void run(){
            for(int i=0; i<=10 ; i++)
            {
                Log.d("Debug", "contador:" + i);
                textView.setText("\n contador:"+ i);
                try {

                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}