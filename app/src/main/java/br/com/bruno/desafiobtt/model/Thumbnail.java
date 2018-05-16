package br.com.bruno.desafiobtt.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Thumbnail implements Serializable {

    @SerializedName("path") public String path;
    @SerializedName("extension") public String extension;

}
