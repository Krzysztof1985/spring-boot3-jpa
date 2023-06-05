package pl.chris.spring.entity;

import java.io.Serializable;

interface HoldsStringFormattedId extends Serializable {
    String getIdFormattedToString();
}
