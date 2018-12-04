package com.scottlogic.deg.generator.decisiontree.test_utils;

import com.scottlogic.deg.generator.constraints.AtomicConstraint;
import com.scottlogic.deg.generator.constraints.AtomicNotConstraint;

public class NotConstraintDto implements ConstraintDto {
    public ConstraintDto negatedConstraint;

    @Override
    public AtomicConstraint map() {
        return new AtomicNotConstraint(negatedConstraint.map());
    }
}
