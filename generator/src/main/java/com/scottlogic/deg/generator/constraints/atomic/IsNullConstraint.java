package com.scottlogic.deg.generator.constraints.atomic;

import com.scottlogic.deg.generator.Field;
import com.scottlogic.deg.generator.inputs.RuleInformation;
import com.scottlogic.deg.generator.restrictions.NullRestrictions;

import java.util.Objects;
import java.util.Set;

public class IsNullConstraint implements AtomicConstraint
{
    public final Field field;
    private final Set<RuleInformation> rules;

    public IsNullConstraint(Field field, Set<RuleInformation> rules) {
        this.field = field;
        this.rules = rules;
    }

    @Override
    public String toDotLabel() {
        return String.format("%s is null", field.name);
    }

    public String toString(){
        return String.format(
                "`%s`: %s",
                NullRestrictions.Nullness.MUST_BE_NULL,
                field.toString());
    }

    @Override
    public Field getField() {
        return field;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o instanceof ViolatedAtomicConstraint) {
            return o.equals(this);
        }
        if (o == null || getClass() != o.getClass()) return false;
        IsNullConstraint constraint = (IsNullConstraint) o;
        return Objects.equals(field, constraint.field);
    }

    @Override
    public int hashCode(){
        return Objects.hash(field);
    }

    @Override
    public Set<RuleInformation> getRules() {
        return rules;
    }
}
