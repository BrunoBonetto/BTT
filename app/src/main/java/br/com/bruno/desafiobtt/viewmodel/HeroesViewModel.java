package br.com.bruno.desafiobtt.viewmodel;

import android.content.Context;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import br.com.bruno.desafiobtt.app.AppController;
import br.com.bruno.desafiobtt.connections.Service;
import br.com.bruno.desafiobtt.model.Heroes;
import br.com.bruno.desafiobtt.model.Results;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import static br.com.bruno.desafiobtt.utils.Constant.BASE_URL;

public class HeroesViewModel extends Observable {

    public ObservableInt heroesRecycler;

    private List<Results> resultsList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public HeroesViewModel(@NonNull Context context) {
        this.context = context;
        this.resultsList = new ArrayList<>();
        heroesRecycler = new ObservableInt();
        getHeroesList();
    }

    private void getHeroesList() {

        AppController appController = AppController.create(context);
        Service service = appController.getService();

        Disposable disposable = service.getHeroesList(BASE_URL + "v1/public/characters?ts=1&apikey=8b7b0e4117bf4168d9da4e5a61a9f928&hash=671d15ab391200f82c62c985abd0864a")
                .subscribeOn(appController.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Heroes>() {
                    @Override public void accept(Heroes heroes) throws Exception {
                        updateHeroesDataList(heroes.getData().getResults());
                    }
                }, new Consumer<Throwable>() {
                    @Override public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(context,"Error", Toast.LENGTH_SHORT);
                    }
                });

        compositeDisposable.add(disposable);
    }

    private void updateHeroesDataList(List<Results> results) {
        resultsList.addAll(results);
        setChanged();
        notifyObservers();
    }

    public List<Results> getResultsList() {
        return resultsList;
    }

    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void reset() {
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }

}
