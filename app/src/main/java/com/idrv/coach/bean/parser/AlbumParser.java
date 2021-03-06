package com.idrv.coach.bean.parser;

import com.google.gson.Gson;
import com.idrv.coach.bean.Album;
import com.zjb.volley.bean.parser.BaseParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * time:2016/3/23
 * description:照片墙接口解析器
 *
 * @author sunjianfei
 */
public class AlbumParser extends BaseParser<List<Album>> {
    @Override
    public List<Album> parser(String json) {
        ArrayList<Album> lists = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                String jsonString = jsonObject.toString();
                Gson gson = new Gson();
                Album album = gson.fromJson(jsonString, Album.class);
                lists.add(album);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lists;
    }
}
