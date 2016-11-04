package com.demiashkevich.parsefile.entity;

import com.demiashkevich.parsefile.section.DivisibleTypeSection;

import java.util.ArrayList;
import java.util.List;

public class CompositeSectionText implements SectionText {

    private DivisibleTypeSection type;
    private List<SectionText> components;

    public CompositeSectionText(DivisibleTypeSection type) {
        this.components = new ArrayList<>();
        this.type = type;
    }

    @Override
    public void addSection(SectionText component) {
        components.add(component);
    }

    @Override
    public void printConsole() {
        components.forEach(SectionText::printConsole);
    }
}
