package br.com.bruno.desafiobtt.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Results implements Serializable {

    @SerializedName("id") public String id;
    @SerializedName("name") public String name;
    @SerializedName("description") public String description;
    @SerializedName("thumbnail") public Thumbnail thumbnail;
    @SerializedName("comics") public Comics comics;

}
