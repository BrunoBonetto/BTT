package br.com.bruno.desafiobtt.connections;

import br.com.bruno.desafiobtt.model.Heroes;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Service {

    @GET
    Observable<Heroes> getHeroesList (@Url String url);
}
