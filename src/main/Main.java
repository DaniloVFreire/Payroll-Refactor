package main;

import data.DataManager;
import view.TextInterface;


public class Main {

    public static void main(String[] args) {
        DataManager data = new DataManager();
        TextInterface.logicMenu(data);
    }
}
