package edu.wcupa.csc496.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tenitx.Immutables.TenitStyle;
import org.immutables.value.Value;
import org.immutables.value.Value.Immutable;

@Immutable
@TenitStyle
@JsonDeserialize(as = LinkToShortenIF.class)
public interface LinkToShortenIF {
}
