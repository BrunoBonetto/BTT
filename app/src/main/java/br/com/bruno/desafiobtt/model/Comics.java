package br.com.bruno.desafiobtt.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Comics implements Serializable {
    @SerializedName("items") public List<Items> Items;
}
