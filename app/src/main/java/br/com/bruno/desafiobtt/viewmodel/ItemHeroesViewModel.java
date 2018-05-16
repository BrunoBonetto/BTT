package br.com.bruno.desafiobtt.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import br.com.bruno.desafiobtt.model.Results;
import br.com.bruno.desafiobtt.view.activity.HeroesDetailActivity;

public class ItemHeroesViewModel extends BaseObservable {

    private Results results;
    private Context context;

    public ItemHeroesViewModel(Results results, Context context){
        this.results = results;
        this.context = context;
    }

    public String getName() {
        return  results.name;
    }

    public void onItemClick(View v){
        context.startActivity(HeroesDetailActivity.fillDetail(v.getContext(), results));
    }

    public void setResults(Results results) {
        this.results = results;
        notifyChange();
    }

}
