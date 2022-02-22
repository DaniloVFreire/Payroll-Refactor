package view.commands;

import data.DataManager;

public interface Command {
    public DataManager execute(DataManager data);
}
