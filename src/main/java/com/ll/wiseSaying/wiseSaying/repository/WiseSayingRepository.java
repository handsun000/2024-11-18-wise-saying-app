package com.ll.wiseSaying.wiseSaying.repository;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface WiseSayingRepository {
    abstract JSONArray selectData() throws IOException, ParseException;

    abstract int selectLastId() throws IOException;

    abstract void insertData(JSONObject obj) throws IOException;


    abstract void insertLastId(int id) throws IOException;


    abstract void deleteData(int id);


    abstract void updateData(JSONObject obj) throws IOException;


    abstract void build(JSONArray arr) throws IOException;
}
