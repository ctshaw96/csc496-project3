package edu.wcupa.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link LinkToShortenIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code LinkToShorten.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code LinkToShorten.of()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class LinkToShorten implements LinkToShortenIF {
  private final String shortLink;
  private final String originalLink;
  private final String keyword;

  private LinkToShorten(String shortLink, String originalLink, String keyword) {
    this.shortLink = Objects.requireNonNull(shortLink, "shortLink");
    this.originalLink = Objects.requireNonNull(originalLink, "originalLink");
    this.keyword = Objects.requireNonNull(keyword, "keyword");
  }

  private LinkToShorten(
      LinkToShorten original,
      String shortLink,
      String originalLink,
      String keyword) {
    this.shortLink = shortLink;
    this.originalLink = originalLink;
    this.keyword = keyword;
  }

  /**
   * @return The value of the {@code shortLink} attribute
   */
  @JsonProperty("shortLink")
  @Override
  public String getShortLink() {
    return shortLink;
  }

  /**
   * @return The value of the {@code originalLink} attribute
   */
  @JsonProperty("originalLink")
  @Override
  public String getOriginalLink() {
    return originalLink;
  }

  /**
   * @return The value of the {@code keyword} attribute
   */
  @JsonProperty("keyword")
  @Override
  public String getKeyword() {
    return keyword;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link LinkToShortenIF#getShortLink() shortLink} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for shortLink
   * @return A modified copy of the {@code this} object
   */
  public final LinkToShorten withShortLink(String value) {
    if (this.shortLink.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "shortLink");
    return new LinkToShorten(this, newValue, this.originalLink, this.keyword);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link LinkToShortenIF#getOriginalLink() originalLink} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for originalLink
   * @return A modified copy of the {@code this} object
   */
  public final LinkToShorten withOriginalLink(String value) {
    if (this.originalLink.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "originalLink");
    return new LinkToShorten(this, this.shortLink, newValue, this.keyword);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link LinkToShortenIF#getKeyword() keyword} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for keyword
   * @return A modified copy of the {@code this} object
   */
  public final LinkToShorten withKeyword(String value) {
    if (this.keyword.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "keyword");
    return new LinkToShorten(this, this.shortLink, this.originalLink, newValue);
  }

  /**
   * This instance is equal to all instances of {@code LinkToShorten} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof LinkToShorten
        && equalTo((LinkToShorten) another);
  }

  private boolean equalTo(LinkToShorten another) {
    return shortLink.equals(another.shortLink)
        && originalLink.equals(another.originalLink)
        && keyword.equals(another.keyword);
  }

  /**
   * Computes a hash code from attributes: {@code shortLink}, {@code originalLink}, {@code keyword}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + shortLink.hashCode();
    h += (h << 5) + originalLink.hashCode();
    h += (h << 5) + keyword.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code LinkToShorten} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("LinkToShorten")
        .omitNullValues()
        .add("shortLink", shortLink)
        .add("originalLink", originalLink)
        .add("keyword", keyword)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements LinkToShortenIF {
    @Nullable String shortLink;
    @Nullable String originalLink;
    @Nullable String keyword;
    @JsonProperty("shortLink")
    public void setShortLink(String shortLink) {
      this.shortLink = shortLink;
    }
    @JsonProperty("originalLink")
    public void setOriginalLink(String originalLink) {
      this.originalLink = originalLink;
    }
    @JsonProperty("keyword")
    public void setKeyword(String keyword) {
      this.keyword = keyword;
    }
    @Override
    public String getShortLink() { throw new UnsupportedOperationException(); }
    @Override
    public String getOriginalLink() { throw new UnsupportedOperationException(); }
    @Override
    public String getKeyword() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static LinkToShorten fromJson(Json json) {
    LinkToShorten.Builder builder = LinkToShorten.builder();
    if (json.shortLink != null) {
      builder.withShortLink(json.shortLink);
    }
    if (json.originalLink != null) {
      builder.withOriginalLink(json.originalLink);
    }
    if (json.keyword != null) {
      builder.withKeyword(json.keyword);
    }
    return builder.build();
  }

  /**
   * Construct a new immutable {@code LinkToShorten} instance.
   * @param shortLink The value for the {@code shortLink} attribute
   * @param originalLink The value for the {@code originalLink} attribute
   * @param keyword The value for the {@code keyword} attribute
   * @return An immutable LinkToShorten instance
   */
  public static LinkToShorten of(String shortLink, String originalLink, String keyword) {
    return new LinkToShorten(shortLink, originalLink, keyword);
  }

  /**
   * Creates an immutable copy of a {@link LinkToShortenIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable LinkToShorten instance
   */
  public static LinkToShorten copyOf(LinkToShortenIF instance) {
    if (instance instanceof LinkToShorten) {
      return (LinkToShorten) instance;
    }
    return LinkToShorten.builder()
        .withShortLink(instance.getShortLink())
        .withOriginalLink(instance.getOriginalLink())
        .withKeyword(instance.getKeyword())
        .build();
  }

  /**
   * Creates a builder for {@link LinkToShorten LinkToShorten}.
   * @return A new LinkToShorten builder
   */
  public static LinkToShorten.Builder builder() {
    return new LinkToShorten.Builder();
  }

  /**
   * Builds instances of type {@link LinkToShorten LinkToShorten}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_SHORT_LINK = 0x1L;
    private static final long INIT_BIT_ORIGINAL_LINK = 0x2L;
    private static final long INIT_BIT_KEYWORD = 0x4L;
    private long initBits = 0x7L;

    private @Nullable String shortLink;
    private @Nullable String originalLink;
    private @Nullable String keyword;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link LinkToShortenIF#getShortLink() shortLink} attribute.
     * @param shortLink The value for shortLink 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("shortLink")
    public final Builder withShortLink(String shortLink) {
      checkNotIsSet(shortLinkIsSet(), "shortLink");
      this.shortLink = Objects.requireNonNull(shortLink, "shortLink");
      initBits &= ~INIT_BIT_SHORT_LINK;
      return this;
    }

    /**
     * Initializes the value for the {@link LinkToShortenIF#getOriginalLink() originalLink} attribute.
     * @param originalLink The value for originalLink 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("originalLink")
    public final Builder withOriginalLink(String originalLink) {
      checkNotIsSet(originalLinkIsSet(), "originalLink");
      this.originalLink = Objects.requireNonNull(originalLink, "originalLink");
      initBits &= ~INIT_BIT_ORIGINAL_LINK;
      return this;
    }

    /**
     * Initializes the value for the {@link LinkToShortenIF#getKeyword() keyword} attribute.
     * @param keyword The value for keyword 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("keyword")
    public final Builder withKeyword(String keyword) {
      checkNotIsSet(keywordIsSet(), "keyword");
      this.keyword = Objects.requireNonNull(keyword, "keyword");
      initBits &= ~INIT_BIT_KEYWORD;
      return this;
    }

    /**
     * Builds a new {@link LinkToShorten LinkToShorten}.
     * @return An immutable instance of LinkToShorten
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public LinkToShorten build() {
      checkRequiredAttributes();
      return new LinkToShorten(null, shortLink, originalLink, keyword);
    }

    private boolean shortLinkIsSet() {
      return (initBits & INIT_BIT_SHORT_LINK) == 0;
    }

    private boolean originalLinkIsSet() {
      return (initBits & INIT_BIT_ORIGINAL_LINK) == 0;
    }

    private boolean keywordIsSet() {
      return (initBits & INIT_BIT_KEYWORD) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of LinkToShorten is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!shortLinkIsSet()) attributes.add("shortLink");
      if (!originalLinkIsSet()) attributes.add("originalLink");
      if (!keywordIsSet()) attributes.add("keyword");
      return "Cannot build LinkToShorten, some of required attributes are not set " + attributes;
    }
  }
}
