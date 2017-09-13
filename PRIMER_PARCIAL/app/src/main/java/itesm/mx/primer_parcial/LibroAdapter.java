package itesm.mx.primer_parcial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class LibroAdapter extends BaseAdapter {

    private final Context mContext;
    private final Libro[] books;

    // 1
    public LibroAdapter(Context context, Libro[] books) {
        this.mContext = context;
        this.books = books;
    }

    // 2
    @Override
    public int getCount() {
        return books.length;
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1
        final Libro book = books[position];

        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.cell, null);
        }

        // 3
        final ImageView ivImagen = (ImageView)convertView.findViewById(R.id.image_libro);
        final TextView tvTitulo = (TextView)convertView.findViewById(R.id.text_titulo);
        //final TextView tvFecha = (TextView)convertView.findViewById(R.id.text_fecha);
        //final TextView tvIsbn = (TextView)convertView.findViewById(R.id.text_isbn);


        // 4
        ivImagen.setImageResource(book.getIdImagen());
        tvTitulo.setText(book.getTitulo());

        return convertView;
    }
}
