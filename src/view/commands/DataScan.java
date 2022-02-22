package view.commands;

import data.DataManager;

import java.util.Scanner;

public abstract class DataScan implements Command{
    DataManager data;
    Scanner scanner;
    public DataScan(DataManager _data, Scanner _scanner){
        this.data = _data;
        this.scanner = _scanner;
    }
    public abstract void execute();
}
