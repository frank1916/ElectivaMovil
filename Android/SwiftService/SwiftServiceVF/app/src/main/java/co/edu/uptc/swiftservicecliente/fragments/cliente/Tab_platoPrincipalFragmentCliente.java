package co.edu.uptc.swiftservicecliente.fragments.cliente;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import co.edu.uptc.swiftservicecliente.R;
import co.edu.uptc.swiftservicecliente.adaptaer.PlatilloImagenAdapterCliente;
import co.edu.uptc.swiftservicecliente.entidades.Platillo;

@SuppressLint("ValidFragment")
public class Tab_platoPrincipalFragmentCliente extends Fragment{

    RecyclerView recyclerPlatillos;
    ArrayList<Platillo> listaPlatillosPrincipales;
    ArrayList<Platillo> listaOrden;

    public Tab_platoPrincipalFragmentCliente(ArrayList<Platillo> Orden, ArrayList<Platillo> listaPlatillos ){
        this.listaPlatillosPrincipales = listaPlatillos;
        this.listaOrden = Orden;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_recicler_view_cliente, container, false);

        this.recyclerPlatillos = (RecyclerView) v.findViewById(R.id.idRecyclerViewCliente);
        this.recyclerPlatillos.setLayoutManager(new LinearLayoutManager(this.getContext()));
        this.recyclerPlatillos.setHasFixedSize(true);

        PlatilloImagenAdapterCliente platilloAdapter = new PlatilloImagenAdapterCliente(listaPlatillosPrincipales);

        platilloAdapter.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Platillo p = listaPlatillosPrincipales.get(recyclerPlatillos.getChildAdapterPosition(v));
                Toast.makeText(getContext(),p.getNombre() + "añadido a orden", Toast.LENGTH_SHORT).show();
                listaOrden.add(p);
            }
        });

        recyclerPlatillos.setAdapter(platilloAdapter);

        return v;
    }


}
