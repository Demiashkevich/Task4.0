package com.demiashkevich.parsefile.parser;

import com.demiashkevich.parsefile.entity.CompositeSectionText;
import com.demiashkevich.parsefile.entity.LeafSectionText;
import com.demiashkevich.parsefile.entity.SectionText;
import com.demiashkevich.parsefile.section.DivisibleTypeSection;
import com.demiashkevich.parsefile.section.IndivisibleTypeSection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DivisibleParse extends Parse {

    protected DivisibleTypeSection currentTypeSection;
    protected abstract List<String> partitionText(String s);

    protected String valueSignSectionBefore;
    protected String valueSignSectionAfter;

    @Override
    public SectionText parse(String currentText, SectionText previousComposite) {
        List<String> sections = this.partitionText(currentText);
        sections.stream().filter(section -> !section.isEmpty()).forEach(section -> {
            if (!valueSignSectionBefore.isEmpty()) {
                SectionText signSectionBefore = new LeafSectionText(IndivisibleTypeSection.SIGN, valueSignSectionBefore);
                previousComposite.addSection(signSectionBefore);
            }
            SectionText currentComposite = new CompositeSectionText(currentTypeSection);
            previousComposite.addSection(currentComposite);
            if (!valueSignSectionAfter.isEmpty()) {
                SectionText signSectionAfter = new LeafSectionText(IndivisibleTypeSection.SIGN, valueSignSectionAfter);
                previousComposite.addSection(signSectionAfter);
            }
            nextParse.parse(section, currentComposite);
        });
        return previousComposite;
    }

    private List<String> get(String sectionText){
        List<String> lexemes = new ArrayList<>();
        lexemes.addAll(Arrays.asList(sectionText.split(currentTypeSection.getRegex())));
        return lexemes;
    }
}
