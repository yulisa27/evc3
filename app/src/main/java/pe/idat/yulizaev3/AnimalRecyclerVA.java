package pe.idat.yulizaev3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalRecyclerVA extends RecyclerView.Adapter<AnimalViewHolder> {
    private List<Animal> animalList;
    private ImageRequester imageRequester;

    AnimalRecyclerVA(List<Animal> animalList) {
        this.animalList = animalList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType ){
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascotacardview, parent, false);
        return new AnimalViewHolder(layoutView);
    }

    @Override
    public  void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        if(animalList != null & position < animalList.size()) {
            Animal animal = animalList.get(position);
            holder.nombreAnimal.setText(animal.nombreAnimal);
            holder.razaAnimal.setText(animal.razaAnimal);
            imageRequester.setImageFromUrl(holder.animalImagen, animal.url);
        }
    }
    @Override
    public  int getItemCount() {
        return animalList.size();
    }
}
