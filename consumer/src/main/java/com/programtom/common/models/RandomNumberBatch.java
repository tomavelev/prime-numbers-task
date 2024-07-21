package com.programtom.common.models;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.io.Serializable;
import java.util.List;

@SuppressFBWarnings
public record RandomNumberBatch(List<Long> numbers, String fileName) implements Serializable {
}
