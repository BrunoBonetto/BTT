package br.com.bruno.desafiobtt.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;

import br.com.bruno.desafiobtt.model.Items;

public class ItemHeroesDetailViewModel extends BaseObservable {

    private Items items;
    private Context context;

    public ItemHeroesDetailViewModel(Items items, Context context) {
        this.items = items;
        this.context = context;
    }

    public String getName(){return items.name;}

    public void setItems(Items items) {
        this.items = items;
        notifyChange();
    }
}
