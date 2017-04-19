
package com.franciscokrieser.api.ai.stocksbot.controller.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "flightNumber.original",
    "destination",
    "destination.original",
    "flightNumber"
})
public class Parameters_ {

    @JsonProperty("flightNumber.original")
    private String flightNumberOriginal;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("destination.original")
    private String destinationOriginal;
    @JsonProperty("flightNumber")
    private String flightNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("flightNumber.original")
    public String getFlightNumberOriginal() {
        return flightNumberOriginal;
    }

    @JsonProperty("flightNumber.original")
    public void setFlightNumberOriginal(String flightNumberOriginal) {
        this.flightNumberOriginal = flightNumberOriginal;
    }

    @JsonProperty("destination")
    public String getDestination() {
        return destination;
    }

    @JsonProperty("destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @JsonProperty("destination.original")
    public String getDestinationOriginal() {
        return destinationOriginal;
    }

    @JsonProperty("destination.original")
    public void setDestinationOriginal(String destinationOriginal) {
        this.destinationOriginal = destinationOriginal;
    }

    @JsonProperty("flightNumber")
    public String getFlightNumber() {
        return flightNumber;
    }

    @JsonProperty("flightNumber")
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
