package itesm.mx.primer_parcial;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static itesm.mx.primer_parcial.DetailActivity.arrayListLibro2;

public class LibroAdapter2 extends ArrayAdapter<Libro>{

    public LibroAdapter2(Context context, ArrayList<Libro> libros){

        super(context,0,libros);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        Libro libro = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        }

        TextView tvTitulo = (TextView)convertView.findViewById(R.id.text_titulo);
        TextView tvIsbn = (TextView)convertView.findViewById(R.id.text_isbn);
        TextView tvFecha_publicacion = (TextView)convertView.findViewById(R.id.text_fechaPublicacion);
        TextView tvPrecio = (TextView)convertView.findViewById(R.id.text_precio);
        ImageView ivLibro = (ImageView)convertView.findViewById(R.id.image_libro);


        tvTitulo.setText(libro.getTitulo());
        tvIsbn.setText(libro.getIsbn());
        tvFecha_publicacion.setText(libro.getFechaPublicacion());
        tvPrecio.setText("$" + String.valueOf(libro.getPrice()));
        ivLibro.setImageResource(libro.getIdImagen());

        return convertView;
    }

    public Libro getItem(int position){
        return arrayListLibro2.get(position);
    }

}
