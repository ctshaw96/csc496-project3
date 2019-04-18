package edu.wcupa.csc496.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;
import org.immutables.value.Value.Immutable;

@Immutable
@TenitStyle
@JsonDeserialize(as = LinkToShorten.class)
public interface LinkToShortenIF {
    String getShortLink();
    String getOriginalLink();
    String getKeyword();
}
