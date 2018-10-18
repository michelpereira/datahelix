package com.scottlogic.deg.generator.restrictions;

public class NullRestrictions {
    public Nullness nullness;

    public enum Nullness {
        MustBeNull,
        MustNotBeNull
    }

    public String toString() {
        return nullness.toString();
    }
}