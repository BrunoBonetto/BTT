package br.com.bruno.desafiobtt.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import br.com.bruno.desafiobtt.R;
import br.com.bruno.desafiobtt.databinding.ItemHeroesDetailBinding;
import br.com.bruno.desafiobtt.model.Items;
import br.com.bruno.desafiobtt.viewmodel.ItemHeroesDetailViewModel;

public class HeroesDetailAdapter extends RecyclerView.Adapter<HeroesDetailAdapter.HeroesDetailAdapterViewHolder> {

    private List<Items> list;

    public HeroesDetailAdapter() {this.list = Collections.emptyList();}

    @Override
    public HeroesDetailAdapter.HeroesDetailAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemHeroesDetailBinding itemHeroesDetailBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_heroes_detail ,parent, false);
        return new HeroesDetailAdapter.HeroesDetailAdapterViewHolder(itemHeroesDetailBinding);
    }

    @Override
    public void onBindViewHolder(HeroesDetailAdapter.HeroesDetailAdapterViewHolder holder, int position) {
        holder.bindHeroes(list.get(position));
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public void setList(List<Items> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public static class HeroesDetailAdapterViewHolder extends RecyclerView.ViewHolder {

        ItemHeroesDetailBinding mitemHeroesDetailBinding;

        public HeroesDetailAdapterViewHolder(ItemHeroesDetailBinding itemHeroesDetailBinding) {
            super(itemHeroesDetailBinding.itemHeroesDetail);
            this.mitemHeroesDetailBinding = itemHeroesDetailBinding;
        }

        void bindHeroes(Items items){
            if(mitemHeroesDetailBinding.getHeroesDetailViewModel() == null){
                mitemHeroesDetailBinding.setHeroesDetailViewModel(new ItemHeroesDetailViewModel(items, itemView.getContext()));
            }else {
                mitemHeroesDetailBinding.getHeroesDetailViewModel().setItems(items);
            }
        }
    }
    
}
