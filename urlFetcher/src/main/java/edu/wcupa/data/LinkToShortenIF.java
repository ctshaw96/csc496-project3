package edu.wcupa.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.wcupa.tools.TenitStyle;
import org.immutables.value.Value.Immutable;

@Immutable
@TenitStyle
@JsonDeserialize(as = LinkToShorten.class)
public interface LinkToShortenIF {
    String getShortLink();
    String getOriginalLink();
    String getKeyword();
}
