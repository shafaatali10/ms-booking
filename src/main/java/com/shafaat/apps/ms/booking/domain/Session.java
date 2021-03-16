package com.shafaat.apps.ms.booking.domain;


import javax.persistence.*;

import java.io.Serializable;

/**
 * A Session.
 */
@Entity
@Table(name = "session")
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "session_code")
    private String sessionCode;

    @Column(name = "session_value")
    private Integer sessionValue;

    @Column(name = "display_value")
    private String displayValue;

    @Column(name = "preferred")
    private Boolean preferred;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSessionCode() {
        return sessionCode;
    }

    public Session sessionCode(String sessionCode) {
        this.sessionCode = sessionCode;
        return this;
    }

    public void setSessionCode(String sessionCode) {
        this.sessionCode = sessionCode;
    }

    public Integer getSessionValue() {
        return sessionValue;
    }

    public Session sessionValue(Integer sessionValue) {
        this.sessionValue = sessionValue;
        return this;
    }

    public void setSessionValue(Integer sessionValue) {
        this.sessionValue = sessionValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public Session displayValue(String displayValue) {
        this.displayValue = displayValue;
        return this;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public Boolean isPreferred() {
        return preferred;
    }

    public Session preferred(Boolean preferred) {
        this.preferred = preferred;
        return this;
    }

    public void setPreferred(Boolean preferred) {
        this.preferred = preferred;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Session)) {
            return false;
        }
        return id != null && id.equals(((Session) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Session{" +
            "id=" + getId() +
            ", sessionCode='" + getSessionCode() + "'" +
            ", sessionValue=" + getSessionValue() +
            ", displayValue='" + getDisplayValue() + "'" +
            ", preferred='" + isPreferred() + "'" +
            "}";
    }
}
