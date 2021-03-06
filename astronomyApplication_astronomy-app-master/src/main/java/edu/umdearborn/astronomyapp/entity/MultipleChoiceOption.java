package edu.umdearborn.astronomyapp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import edu.umdearborn.astronomyapp.util.json.View;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "multipleChoiceOptionId"))
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"humanReadableText", "optionQuestionId"}),
    indexes = @Index(columnList = "optionQuestionId"))
public class MultipleChoiceOption extends AbstractOption {

  private static final long serialVersionUID = -5311013272908483434L;

  @JsonView(View.Student.class)
  @NotNull
  @Size(min = 1)
  private String humanReadableText;

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  public String getHumanReadableText() {
    return humanReadableText;
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  public void setHumanReadableText(String humanReadableText) {
    this.humanReadableText = humanReadableText;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
