package br.com.bruno.desafiobtt.app;

import android.app.Application;
import android.content.Context;

import br.com.bruno.desafiobtt.connections.ApiFactory;
import br.com.bruno.desafiobtt.connections.Service;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class AppController extends Application {

    private Service service;
    private Scheduler scheduler;

    private static AppController get(Context context) {
        return (AppController) context.getApplicationContext();
    }

    public static AppController create(Context context) {
        return AppController.get(context);
    }

    public Service getService() {
        if (service == null) {
            service = ApiFactory.create();
        }

        return service;
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }

        return scheduler;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }


}
