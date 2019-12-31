package com.vladsch.flexmark.util.sequence.builder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A Builder for non based strings. Just a string builder wrapped in a sequence builder interface
 */
public final class StringSequenceBuilder implements ISequenceBuilder<StringSequenceBuilder, CharSequence> {
    private final StringBuilder segments;

    public StringSequenceBuilder() {
        this.segments = new StringBuilder();
    }

    public StringSequenceBuilder(int initialCapacity) {
        this.segments = new StringBuilder(initialCapacity);
    }

    @NotNull
    public StringSequenceBuilder getBuilder() {
        return new StringSequenceBuilder();
    }

    @NotNull
    @Override
    public StringSequenceBuilder append(@Nullable CharSequence chars, int startIndex, int endIndex) {
        if (chars != null && chars.length() > 0 && startIndex < endIndex) {
            segments.append(chars, startIndex, endIndex);
        }
        return this;
    }

    @NotNull
    @Override
    public StringSequenceBuilder append(char c) {
        segments.append(c);
        return this;
    }

    @NotNull
    @Override
    public StringSequenceBuilder append(char c, int count) {
        while (count-- > 0) segments.append(c);
        return this;
    }

    @NotNull
    @Override
    public CharSequence getSingleBasedSequence() {
        return toSequence();
    }

    @NotNull
    @Override
    public CharSequence toSequence() {
        return segments;
    }

    @Override
    public int length() {
        return segments.length();
    }

    @Override
    public String toString() {
        return segments.toString();
    }
}