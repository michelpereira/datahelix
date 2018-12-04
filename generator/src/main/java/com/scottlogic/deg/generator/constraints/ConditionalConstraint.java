package com.scottlogic.deg.generator.constraints;

import com.scottlogic.deg.generator.Field;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConditionalConstraint implements LogicalConstraint
{
    public final LogicalConstraint condition;
    public final LogicalConstraint whenConditionIsTrue;
    public final LogicalConstraint whenConditionIsFalse;

    public ConditionalConstraint(
        LogicalConstraint condition,
        LogicalConstraint whenConditionIsTrue) {
        this(condition, whenConditionIsTrue, null);
    }

    public ConditionalConstraint(
        LogicalConstraint condition,
        LogicalConstraint whenConditionIsTrue,
        LogicalConstraint whenConditionIsFalse) {
        this.condition = condition;
        this.whenConditionIsTrue = whenConditionIsTrue;
        this.whenConditionIsFalse = whenConditionIsFalse;
    }

    @Override
    public String toDotLabel() {
        throw new UnsupportedOperationException("IF constraints should be consumed during conversion to decision trees");
    }

    @Override
    public Collection<Field> getFields() {
        return Stream.of(condition, whenConditionIsTrue, whenConditionIsFalse)
            .flatMap(constraint -> constraint.getFields().stream())
            .collect(Collectors.toList());
    }
}
