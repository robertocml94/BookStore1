package itesm.mx.primer_parcial;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;


public class Libro implements Parcelable {

    private String titulo;
    private String isbn;
    private String fechaPublicacion;
    private int idImagen;
    private float price;

    //constructor de la clase
    public Libro(String titulo, String isbn, String fechaPublicacion, int idImagen, float price ){

        this.titulo = titulo;
        this.isbn = isbn;
        this.fechaPublicacion = fechaPublicacion;
        this.idImagen = idImagen;
        this.price = price;
    }

    protected Libro(Parcel in) {
        titulo = in.readString();
        isbn = in.readString();
        fechaPublicacion = in.readString();
        idImagen = in.readInt();
        price = in.readFloat();
    }


    public String getTitulo() {

        return titulo;
    }
    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }

    public String getFechaPublicacion() {

        return fechaPublicacion;
    }
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getIsbn() {

        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getIdImagen() {

        return idImagen;
    }
    public void setIdImagen(int idImagen) {

        this.idImagen = idImagen;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(isbn);
        dest.writeString(fechaPublicacion);
        dest.writeInt(idImagen);
        dest.writeFloat(price);
    }
    public void readFromParcel (Parcel in){

        titulo = in.readString();
        isbn = in.readString();
        fechaPublicacion = in.readString();
        idImagen = in.readInt();
        price = in.readFloat();

    }


    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Libro> CREATOR = new Parcelable.Creator<Libro>() {
        @Override
        public Libro createFromParcel(Parcel in) {
            return new Libro(in);
        }

        @Override
        public Libro[] newArray(int size) {
            return new Libro[size];
        }
    };

}
