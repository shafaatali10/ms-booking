package com.shafaat.apps.ms.booking.domain;


import javax.persistence.*;

import java.io.Serializable;

/**
 * A Zone.
 */
@Entity
@Table(name = "zone")
public class Zone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zone_code")
    private String zoneCode;

    @Column(name = "zone_value")
    private Integer zoneValue;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "preferred")
    private Boolean preferred;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public Zone zoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
        return this;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public Integer getZoneValue() {
        return zoneValue;
    }

    public Zone zoneValue(Integer zoneValue) {
        this.zoneValue = zoneValue;
        return this;
    }

    public void setZoneValue(Integer zoneValue) {
        this.zoneValue = zoneValue;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Zone displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Boolean isPreferred() {
        return preferred;
    }

    public Zone preferred(Boolean preferred) {
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
        if (!(o instanceof Zone)) {
            return false;
        }
        return id != null && id.equals(((Zone) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Zone{" +
            "id=" + getId() +
            ", zoneCode='" + getZoneCode() + "'" +
            ", zoneValue=" + getZoneValue() +
            ", displayName='" + getDisplayName() + "'" +
            ", preferred='" + isPreferred() + "'" +
            "}";
    }
}
