package itesm.mx.primer_parcial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {


    public static ArrayList<Libro> arrayListLibro2 = new ArrayList<Libro>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar9);
        if (toolbar != null) {
            toolbar.setTitle(R.string.app_name);
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
            setSupportActionBar(toolbar);
        }

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });


        final TextView tvTitulo = (TextView) findViewById(R.id.text_titulo);
        TextView tvIsbn = (TextView) findViewById(R.id.text_isbn);
        TextView tvFecha = (TextView) findViewById(R.id.text_fechaPublicacion);
        TextView tvPrecio = (TextView) findViewById(R.id.text_precio);
        Button btnAgregar = (Button) findViewById(R.id.button_ok);
        //Button btnCarrito = (Button) findViewById(R.id.button_carrito);
        ImageView ivImagen = (ImageView) findViewById(R.id.imagen_libro);
        //initToolBar();


        Intent intent = getIntent();
        final Libro libro = intent.getParcelableExtra("Libro");


        tvTitulo.setText(libro.getTitulo());
        tvIsbn.setText("ISBN: " + libro.getIsbn());
        tvFecha.setText(libro.getFechaPublicacion());
        tvPrecio.setText("Precio: " + libro.getPrice());
        ivImagen.setImageResource(libro.getIdImagen());


        final Libro libro1 = new Libro("Android Programming for Beginners", "9781785889035", "10/12/2015", R.drawable.beginners, 50.00f);


        btnAgregar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                /*Intent intent2 = new Intent(view.getContext(),CartActivity.class);
                intent2.putExtra("Libro",libro);
                startActivity(intent2);*/

                arrayListLibro2.add(libro);
                Toast.makeText(getApplicationContext(), libro.getTitulo() + " se ha añadido al carrito", Toast.LENGTH_SHORT).show();


            }
        });

        /*btnCarrito.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent2 = new Intent(view.getContext(),CartActivity.class);
                intent2.putParcelableArrayListExtra("Libro_test",arrayListLibro2);
                startActivity(intent2);

            }
        });*/

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab);
        fab2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent2 = new Intent(view.getContext(), CartActivity.class);
                                        intent2.putParcelableArrayListExtra("Libro_test", arrayListLibro2);
                                        startActivity(intent2);

                                    }
                                }
        );

    }
}
