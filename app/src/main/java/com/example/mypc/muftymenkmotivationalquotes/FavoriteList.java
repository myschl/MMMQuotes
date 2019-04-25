package com.example.mypc.muftymenkmotivationalquotes;

import java.util.ArrayList;

public class FavoriteList {
    public static ArrayList<FavoriteModel> favorite = new ArrayList<>();

    public FavoriteList() {
    }

    public static ArrayList<FavoriteModel> getFavorite() {
        return favorite;
    }

    public static void setFavorite(ArrayList<FavoriteModel> favorite) {
        FavoriteList.favorite = favorite;
    }
}
