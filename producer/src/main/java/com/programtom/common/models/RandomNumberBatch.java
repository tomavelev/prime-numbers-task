package com.programtom.common.models;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @param numbers - list of numbers
 * @param fileName - base file name that will be used for the in/out csv export
 */
public record RandomNumberBatch(List<Long> numbers, String fileName) implements Serializable {
}
