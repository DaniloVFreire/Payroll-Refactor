package view.commands;

import data.DataManager;

import java.util.Stack;

import static controller.StateController.redo;

public class Redo extends UndoRedo{
    public Redo(DataManager _data, Stack<String> _undo, Stack<String> _redo){
        super(_data, _undo, _redo);
    }
    @Override
    public void execute() {
        DataManager sample = redo(data, undo, redo);
        if (sample == null) {
            System.out.println("Stack is clear, you cant undo");
        } else {
            data = sample;
            System.out.println("Redo successfully applied");
        }
    }
}
