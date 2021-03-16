package com.shafaat.apps.ms.booking.domain;


import javax.persistence.*;

import java.io.Serializable;

/**
 * A Mosque.
 */
@Entity
@Table(name = "mosque")
public class Mosque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mosque_id")
    private Integer mosqueId;

    @Column(name = "mosque_name")
    private String mosqueName;

    @Column(name = "preferred")
    private Boolean preferred;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMosqueId() {
        return mosqueId;
    }

    public Mosque mosqueId(Integer mosqueId) {
        this.mosqueId = mosqueId;
        return this;
    }

    public void setMosqueId(Integer mosqueId) {
        this.mosqueId = mosqueId;
    }

    public String getMosqueName() {
        return mosqueName;
    }

    public Mosque mosqueName(String mosqueName) {
        this.mosqueName = mosqueName;
        return this;
    }

    public void setMosqueName(String mosqueName) {
        this.mosqueName = mosqueName;
    }

    public Boolean isPreferred() {
        return preferred;
    }

    public Mosque preferred(Boolean preferred) {
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
        if (!(o instanceof Mosque)) {
            return false;
        }
        return id != null && id.equals(((Mosque) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Mosque{" +
            "id=" + getId() +
            ", mosqueId=" + getMosqueId() +
            ", mosqueName='" + getMosqueName() + "'" +
            ", preferred='" + isPreferred() + "'" +
            "}";
    }
}
