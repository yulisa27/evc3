package pe.idat.yulizaev3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    public ImageView animalImagen;
    public TextView nombreAnimal;
    public TextView razaAnimal;

    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        animalImagen = itemView.findViewById(R.id.animal_imagen);
        nombreAnimal = itemView.findViewById(R.id.nombre_animal);
        razaAnimal = itemView.findViewById(R.id.animal_raza);
    }
}
