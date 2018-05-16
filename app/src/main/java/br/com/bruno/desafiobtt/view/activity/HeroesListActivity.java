package br.com.bruno.desafiobtt.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Observable;
import java.util.Observer;

import br.com.bruno.desafiobtt.R;
import br.com.bruno.desafiobtt.databinding.ActivityHeroesListBinding;
import br.com.bruno.desafiobtt.view.adapter.HeroesAdapter;
import br.com.bruno.desafiobtt.viewmodel.HeroesViewModel;

public class HeroesListActivity extends AppCompatActivity implements Observer {

    private ActivityHeroesListBinding activityHeroesListBinding;
    private HeroesViewModel heroesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setListofHeroes(activityHeroesListBinding.listHeroes);
        setUpObserver(heroesViewModel);
        setTitle(" ");
    }

    private void initDataBinding() {
        activityHeroesListBinding = DataBindingUtil.setContentView(this, R.layout.activity_heroes_list);
        heroesViewModel = new HeroesViewModel(this);
        activityHeroesListBinding.setHeroesViewModel(heroesViewModel);
    }

    private void setListofHeroes(RecyclerView listHeroes) {
        HeroesAdapter heroesAdapter = new HeroesAdapter();
        listHeroes.setAdapter(heroesAdapter);
        listHeroes.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setUpObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof  HeroesViewModel) {
            HeroesAdapter heroesAdapter = (HeroesAdapter) activityHeroesListBinding.listHeroes.getAdapter();
            HeroesViewModel heroesViewModel = (HeroesViewModel) o;
            heroesAdapter.setList(heroesViewModel.getResultsList());
        }
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        heroesViewModel.reset();
    }

}
