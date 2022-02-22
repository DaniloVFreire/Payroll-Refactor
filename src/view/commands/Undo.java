package view.commands;

import data.DataManager;

import java.util.Scanner;
import java.util.Stack;

import static controller.StateController.undo;

public class Undo extends UndoRedo{
    public Undo(DataManager _data, Stack<String> _undo, Stack<String> _redo){
        super(_data, _undo, _redo);
    }
    @Override
    public void execute() {
        DataManager Sample = undo(data, undo, redo);
        if (Sample == null) {
            System.out.println("Stack is clear, you cant undo");
        } else {
            data = Sample;
            System.out.println("Redo successfully applied");
        }
    }
}
