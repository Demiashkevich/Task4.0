package com.demiashkevich.parsefile.runner;

import com.demiashkevich.parsefile.action.ParseAction;
import com.demiashkevich.parsefile.entity.SectionText;
import com.demiashkevich.parsefile.reader.ReadFile;

public class Main {
    public static void main(String[] args) {
        ReadFile read = new ReadFile();
        String text = read.readFile();
        System.out.println(text);
        ParseAction parseAction = new ParseAction();
        SectionText composite = parseAction.parseFile(text);
        composite.printConsole();
    }
}
