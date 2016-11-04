package com.demiashkevich.parsefile.entity;

import com.demiashkevich.parsefile.section.IndivisibleTypeSection;

public class LeafSectionText implements SectionText {

    private String text;
    private IndivisibleTypeSection type;

    public LeafSectionText(IndivisibleTypeSection type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public void addSection(SectionText component) { }

    @Override
    public void printConsole() {
        System.out.print(text);
    }

}
