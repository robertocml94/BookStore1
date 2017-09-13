package itesm.mx.primer_parcial;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.ActionBarActivity;
import java.lang.reflect.Array;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;
import static itesm.mx.primer_parcial.DetailActivity.arrayListLibro2;

public class MainActivity extends AppCompatActivity {


    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar9);
        if (toolbar != null) {
            toolbar.setTitle(R.string.app_name);
            setSupportActionBar(toolbar);
        }


        Libro libro1 = new Libro("Android Programming for Beginners", "9781785889035", "10/12/2015", R.drawable.beginners, 50.00f);
        Libro libro2 = new Libro("Android Applicaiton Development Cookbook", "1785886193", "10/12/2015", R.drawable.cookbook, 30.00f);
        Libro libro3 = new Libro("Learn Java for Android Development", "1430264543", "10/12/2015", R.drawable.java3, 60.99f);
        Libro libro4 = new Libro("Introduction to Android Development: Android Essentials", "013438945X", "10/12/2015", R.drawable.essentials, 30.99f);
        Libro libro5 = new Libro("Android: App Development & Programming Guide: Learn In A Day", "9781329747517", "10/12/2015", R.drawable.guide, 35.99f);
        Libro libro6 = new Libro("Android Programming for Beginners", "9781785889035", "10/12/2015", R.drawable.beginners, 50.00f);
        Libro libro7 = new Libro("Android Applicaiton Development Cookbook", "1785886193", "10/12/2015", R.drawable.cookbook, 30.00f);
        Libro libro8 = new Libro("Learn Java for Android Development", "1430264543", "10/12/2015", R.drawable.java3, 60.99f);
        Libro libro9 = new Libro("Introduction to Android Development: Android Essentials", "013438945X", "10/12/2015", R.drawable.essentials, 30.99f);
        Libro libro10 = new Libro("Android: App Development & Programming Guide: Learn In A Day", "9781329747517", "10/12/2015", R.drawable.guide, 35.99f);

        final Libro books[] = {libro1, libro2, libro3, libro4, libro5, libro6, libro7, libro8, libro9, libro10};

        GridView gridView = (GridView) findViewById(R.id.gridview);
        LibroAdapter libroadapter = new LibroAdapter(this, books);
        gridView.setAdapter(libroadapter);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation_move);
        GridLayoutAnimationController controller = new GridLayoutAnimationController(animation, .2f, .2f);
        gridView.setLayoutAnimation(controller);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Libro libro = (Libro) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Item Clicked: " + ((TextView) view.findViewById(R.id.text_titulo)).getText(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Libro", books[position]);
                startActivity(intent);
            }

        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
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
