package com.starbucksproject.starbucksposproject;

import java.util.Objects;

public class ItemPair<T, U> {
	private T key;
	private U value;

	public ItemPair(T key, U value) {
		this.key = key;
		this.value = value;
	}

	public T getKey() {
		return key;
	}

	public U getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ItemPair<?, ?> pair = (ItemPair<?, ?>) o;
		return Objects.equals(key, pair.key) &&
				Objects.equals(value, pair.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(key, value);
	}
}

