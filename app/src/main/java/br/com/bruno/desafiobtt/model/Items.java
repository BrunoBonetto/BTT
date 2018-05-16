package br.com.bruno.desafiobtt.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Items implements Serializable {
    @SerializedName("name") public String name;
}
