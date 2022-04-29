package com.example.consumidorapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.consumidorapp.R;
import com.example.consumidorapp.model.Produtos;

import java.util.List;

public class AdapterConsumidor extends RecyclerView.Adapter< AdapterConsumidor.MyViewHolder > {

    private List<Produtos> produtosList;
    public AdapterConsumidor( List<Produtos> lista ) {
        this.produtosList = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View produtoLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(produtoLista);
    }// CRIA A LISTA

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Produtos produto = produtosList.get( position );
        holder.NomeProduto.setText(produto.getNomeProduto());
        holder.ValorProduto.setText(produto.getValorProduto());
        holder.DescricaoProduto.setText(produto.getDescicaoProduto());
    }// INSERE OS ITENS NA LISTA

    @Override
    public int getItemCount()
    {
        return produtosList.size();
    }// CONTA QUANTOS ITENS TEM NA LISTA E RETORNA

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView NomeProduto;
        TextView ValorProduto;
        TextView DescricaoProduto;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            NomeProduto  = itemView.findViewById(R.id.NomeProduto);
            ValorProduto = itemView.findViewById(R.id.ValorProduto);
            DescricaoProduto = itemView.findViewById(R.id.DescricaoProduto);

        }
    }

}
