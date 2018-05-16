package br.com.bruno.desafiobtt.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import br.com.bruno.desafiobtt.R;
import br.com.bruno.desafiobtt.databinding.ItemHeroesBinding;
import br.com.bruno.desafiobtt.model.Results;
import br.com.bruno.desafiobtt.viewmodel.ItemHeroesViewModel;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.HeroesAdapterViewHolder>{

    private List<Results> list;

    public HeroesAdapter() {this.list = Collections.emptyList();}

    @Override
    public HeroesAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemHeroesBinding itemHeroesBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_heroes ,parent, false);
        return new HeroesAdapterViewHolder(itemHeroesBinding);
    }

    @Override
    public void onBindViewHolder(HeroesAdapterViewHolder holder, int position) {
        holder.bindHeroes(list.get(position));
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public void setList(List<Results> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public static class HeroesAdapterViewHolder extends RecyclerView.ViewHolder {

        ItemHeroesBinding mitemHeroesBinding;

        public HeroesAdapterViewHolder(ItemHeroesBinding itemHeroesBinding) {
            super(itemHeroesBinding.itemHeroes);
            this.mitemHeroesBinding = itemHeroesBinding;
        }

        void bindHeroes(Results results){
            if(mitemHeroesBinding.getHeroesViewModel() == null){
                mitemHeroesBinding.setHeroesViewModel(new ItemHeroesViewModel(results, itemView.getContext()));
            }else {
                mitemHeroesBinding.getHeroesViewModel().setResults(results);
            }
        }
    }

}
