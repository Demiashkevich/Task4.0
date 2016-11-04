package com.demiashkevich.parsefile.parser;

import com.demiashkevich.parsefile.entity.SectionText;

public abstract class Parse {

    protected Parse nextParse;
    public abstract SectionText parse(String text, SectionText currentComposite);

}
