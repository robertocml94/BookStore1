package itesm.mx.primer_parcial;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static itesm.mx.primer_parcial.DetailActivity.arrayListLibro2;

public class CartActivity extends AppCompatActivity {

    int i=0;
    float total= 0f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar9);
        if (toolbar != null) {
            toolbar.setTitle(R.string.app_name);
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
            setSupportActionBar(toolbar);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

        final ListView listView = (ListView) findViewById(R.id.listView);


        ArrayList<Libro> arrayListLibro = new ArrayList<Libro>();

        arrayListLibro = this.getIntent().getParcelableArrayListExtra("Libro_test");


         final LibroAdapter2 adapterLibros = new LibroAdapter2(this,arrayListLibro);
        listView.setAdapter(adapterLibros);


        int j = 0;

        for(j=0; j<arrayListLibro.size(); j++)
        {
            total += arrayListLibro.get(j).getPrice();
        }


        TextView tvTest = (TextView) findViewById(R.id.text_test);
        tvTest.setText("$"+String.valueOf(total));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                AlertDialog.Builder adb=new AlertDialog.Builder(CartActivity.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete " + position);
                final int positionToRemove = position;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        arrayListLibro2.remove(positionToRemove);
                        //adapterLibros.notifyDataSetChanged();

                    }});
                adb.show();
            }

        });


    }


}
