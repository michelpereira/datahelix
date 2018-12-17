package com.scottlogic.deg.generator.constraints.atomic;

import com.scottlogic.deg.generator.Field;
import com.scottlogic.deg.generator.inputs.RuleInformation;
import com.scottlogic.deg.generator.generation.StringGenerator;

import java.util.Objects;
import java.util.Set;

public class MatchesStandardConstraint implements AtomicConstraint {
    public final Field field;
    public final StringGenerator standard; // TODO: Change this to an enum member; string generators shouldn't exist on this level
    private final Set<RuleInformation> rules;

    public MatchesStandardConstraint(Field field, StringGenerator standard, Set<RuleInformation> rules) {
        this.field = field;
        this.standard = standard;
        this.rules = rules;
    }

    @Override
    public String toDotLabel(){
        return String.format("%s is a %s", field.name, standard.getClass().getName());
    }

    @Override
    public Field getField() {
        return field;
    }

    @Override
    public Set<RuleInformation> getRules() {
        return rules;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o instanceof ViolatedAtomicConstraint) {
            return o.equals(this);
        }
        if (o == null || getClass() != o.getClass()) return false;
        MatchesStandardConstraint constraint = (MatchesStandardConstraint) o;
        return Objects.equals(field, constraint.field) && Objects.equals(standard, constraint.standard);
    }

    @Override
    public int hashCode(){
        return Objects.hash(field, standard);
    }
}
