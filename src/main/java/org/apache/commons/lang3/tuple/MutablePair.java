/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang3.tuple;

import java.util.Map;
import java.util.Objects;

/**
 * A mutable pair consisting of two {@link Object} elements.
 *
 * <p>Not #ThreadSafe#</p>
 *
 * @param <L> the left element type.
 * @param <R> the right element type.
 * @since 3.0
 */
public class MutablePair<L, R> extends Pair<L, R> {

    /**
     * An empty array.
     * <p>
     * Consider using {@link #emptyArray()} to avoid generics warnings.
     * </p>
     *
     * @since 3.10
     */
    public static final MutablePair<?, ?>[] EMPTY_ARRAY = {};

    /** Serialization version */
    private static final long serialVersionUID = 4954918890077093841L;

    /**
     * Returns the empty array singleton that can be assigned without compiler warning.
     *
     * @param <L> the left element type.
     * @param <R> the right element type.
     * @return the empty array singleton that can be assigned without compiler warning.
     * @since 3.10
     */
    @SuppressWarnings("unchecked")
    public static <L, R> MutablePair<L, R>[] emptyArray() {
        return (MutablePair<L, R>[]) EMPTY_ARRAY;
    }

    /**
     * Creates a mutable pair of two objects inferring the generic types.
     *
     * <p>This factory allows the pair to be created using inference to
     * obtain the generic types.</p>
     *
     * @param <L> the left element type.
     * @param <R> the right element type.
     * @param left  the left element, may be null.
     * @param right  the right element, may be null.
     * @return a pair formed from the two parameters, not null.
     */
    public static <L, R> MutablePair<L, R> of(final L left, final R right) {
        return new MutablePair<>(left, right);
    }

    /**
     * Creates a mutable pair from a map entry.
     *
     * <p>This factory allows the pair to be created using inference to
     * obtain the generic types.</p>
     *
     * @param <L> the left element type.
     * @param <R> the right element type.
     * @param pair the existing map entry.
     * @return a pair formed from the map entry.
     */
    public static <L, R> MutablePair<L, R> of(final Map.Entry<L, R> pair) {
        final L left;
        final R right;
        if (pair != null) {
            left = pair.getKey();
            right = pair.getValue();
        } else {
            left = null;
            right = null;
        }
        return new MutablePair<>(left, right);
    }

    /**
     * Creates a mutable pair of two non-null objects inferring the generic types.
     *
     * <p>This factory allows the pair to be created using inference to
     * obtain the generic types.</p>
     *
     * @param <L> the left element type.
     * @param <R> the right element type.
     * @param left  the left element, may not be null.
     * @param right  the right element, may not be null.
     * @return a pair formed from the two parameters, not null.
     * @throws NullPointerException if any input is null.
     * @since 3.13.0
     */
    public static <L, R> MutablePair<L, R> ofNonNull(final L left, final R right) {
        return of(Objects.requireNonNull(left, "left"), Objects.requireNonNull(right, "right"));
    }

    /** Left object. */
    public L left;

    /** Right object. */
    public R right;

    /**
     * Create a new pair instance of two nulls.
     */
    public MutablePair() {
    }

    /**
     * Create a new pair instance.
     *
     * @param left  the left value, may be null.
     * @param right  the right value, may be null.
     */
    public MutablePair(final L left, final R right) {
        this.left = left;
        this.right = right;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L getLeft() {
        return left;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public R getRight() {
        return right;
    }

    /**
     * Sets the left element of the pair.
     *
     * @param left  the new value of the left element, may be null.
     */
    public void setLeft(final L left) {
        this.left = left;
    }

    /**
     * Sets the right element of the pair.
     *
     * @param right  the new value of the right element, may be null.
     */
    public void setRight(final R right) {
        this.right = right;
    }

    /**
     * Sets the {@code Map.Entry} value.
     * This sets the right element of the pair.
     *
     * @param value  the right value to set, not null.
     * @return the old value for the right element.
     */
    @Override
    public R setValue(final R value) {
        final R result = getRight();
        setRight(value);
        return result;
    }

}
