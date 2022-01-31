package controller;

import data.DataManager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;
import java.util.Stack;

public class StateController {
    public static DataManager undo(DataManager data, Stack<String> undo, Stack<String> redo){
        if(!undo.isEmpty()){
            redo.push(storeState(data));
            data = restoreState(undo.pop());
            return data;
        }
        else{
            return null;
        }
    }

    public static DataManager redo(DataManager data, Stack<String> undo, Stack<String> redo){
        if(!redo.isEmpty()){
            undo.push(storeState(data));
            data = restoreState(redo.pop());
            return data;
        }
        else{
            return null;
        }
    }

    public static String storeState(DataManager data) {
        try {
            ByteArrayOutputStream bass = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bass);
            oos.writeObject(data);
            oos.close();
            return Base64.getEncoder().encodeToString(bass.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return "Error!";
        }
    }

    public static DataManager restoreState(String state) {
        try {
            byte[] data = Base64.getDecoder().decode(state);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            return (DataManager) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
