package com.shafaat.apps.ms.booking.domain;


import javax.persistence.*;

import java.io.Serializable;

/**
 * A Config.
 */
@Entity
@Table(name = "config")
public class Config implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "config_code")
    private String configCode;

    @Column(name = "config_value")
    private String configValue;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfigCode() {
        return configCode;
    }

    public Config configCode(String configCode) {
        this.configCode = configCode;
        return this;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }

    public String getConfigValue() {
        return configValue;
    }

    public Config configValue(String configValue) {
        this.configValue = configValue;
        return this;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Config)) {
            return false;
        }
        return id != null && id.equals(((Config) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Config{" +
            "id=" + getId() +
            ", configCode='" + getConfigCode() + "'" +
            ", configValue='" + getConfigValue() + "'" +
            "}";
    }
}
