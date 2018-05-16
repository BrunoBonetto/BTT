package br.com.bruno.desafiobtt.viewmodel;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Observable;

import br.com.bruno.desafiobtt.model.Items;
import br.com.bruno.desafiobtt.model.Results;

public class HeroesDetailViewModel extends Observable {

    private Results results;

    public HeroesDetailViewModel(Results results) {this.results = results;}

    public String getName(){return results.name;}

    public String getDescription() { return results.description; }

    public String getThumb() { return results.thumbnail.path + "/portrait_large." + results.thumbnail.extension; }

    public List<Items> getItems() {return results.comics.Items;};

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl){
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }

}
