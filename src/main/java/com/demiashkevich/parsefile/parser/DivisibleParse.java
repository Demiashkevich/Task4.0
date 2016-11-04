package com.demiashkevich.parsefile.parser;

import com.demiashkevich.parsefile.entity.CompositeSectionText;
import com.demiashkevich.parsefile.entity.SectionText;
import com.demiashkevich.parsefile.section.DivisibleTypeSection;

import java.util.List;

public abstract class DivisibleParse extends Parse {

    protected DivisibleTypeSection currentTypeSection;
    protected abstract List<String> partitionText(String s);

    @Override
    public SectionText parse(String currentText, SectionText previousComposite) {
        List<String> sections = this.partitionText(currentText);
        for (String section : sections) {
            SectionText currentComposite = new CompositeSectionText(currentTypeSection);
            previousComposite.addSection(currentComposite);
            nextParse.parse(section, previousComposite);
        }
        return previousComposite;
    }
}
