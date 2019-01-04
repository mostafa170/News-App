package com.example.android.newsapp;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by mostafa on 15/07/2017.
 */

public class NewsAppLoader extends AsyncTaskLoader<List<NewsApp>> {

    public NewsAppLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<NewsApp> loadInBackground() {
        List<NewsApp> listOfNews = null;
        try {
            URL url = APIQuery.createUrl();
            String jsonResponse = APIQuery.makeHttpRequest(url);
            listOfNews = APIQuery.parseJson(jsonResponse);
        } catch (IOException e) {
            Log.e("Queryutils", "Error Loader LoadInBackground: ", e);
        }
        return listOfNews;
    }
}


