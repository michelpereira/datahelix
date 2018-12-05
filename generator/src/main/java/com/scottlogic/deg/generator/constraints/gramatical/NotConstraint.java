package com.scottlogic.deg.generator.constraints.gramatical;

import com.scottlogic.deg.generator.constraints.Constraint;

import java.util.Objects;

public class NotConstraint implements GramaticalConstraint {
    public final Constraint negatedConstraint;

    protected NotConstraint(Constraint negatedConstraint) {
        this.negatedConstraint = negatedConstraint;
    }

    @Override
    public Constraint negate() {
        return this.negatedConstraint;
    }

    private Constraint getBaseConstraint(){
        return negatedConstraint;
    }

    public String toString(){
        return String.format(
                "NOT(%s)",
                negatedConstraint);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotConstraint otherConstraint = (NotConstraint) o;
        return Objects.equals(getBaseConstraint(), otherConstraint.getBaseConstraint());
    }

    @Override
    public int hashCode(){
        return Objects.hash("NOT", negatedConstraint.hashCode());
    }
}
