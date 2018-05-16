package br.com.bruno.desafiobtt.view.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import br.com.bruno.desafiobtt.R;
import br.com.bruno.desafiobtt.databinding.ActivityHeroesDetailBinding;
import br.com.bruno.desafiobtt.model.Results;
import br.com.bruno.desafiobtt.view.adapter.HeroesDetailAdapter;
import br.com.bruno.desafiobtt.viewmodel.HeroesDetailViewModel;

public class HeroesDetailActivity extends AppCompatActivity {

    private static final String EXTRA = "EXTRA";

    private ActivityHeroesDetailBinding activityHeroesDetailBinding;
    private HeroesDetailViewModel heroesDetailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHeroesDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_heroes_detail);
        displayHomeAsUpEnabled();
        getExtrasFromIntent();
        setListofHeroes(activityHeroesDetailBinding.listHeroesDetail);
    }

    private void displayHomeAsUpEnabled() {

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void getExtrasFromIntent(){
        Results results = (Results) getIntent().getSerializableExtra(EXTRA);
        heroesDetailViewModel = new HeroesDetailViewModel(results);
        activityHeroesDetailBinding.setHeroesDetailViewModel(heroesDetailViewModel);
        setTitle("Informações");
    }

    public static Intent fillDetail(Context context, Results results) {
        Intent intent = new Intent(context, HeroesDetailActivity.class);
        intent.putExtra(EXTRA, results);
        return intent;
    }

    private void setListofHeroes(RecyclerView listHeroes) {
        HeroesDetailAdapter heroesDetailAdapter = new HeroesDetailAdapter();
        heroesDetailAdapter.setList(heroesDetailViewModel.getItems());
        listHeroes.setAdapter(heroesDetailAdapter);
        listHeroes.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
