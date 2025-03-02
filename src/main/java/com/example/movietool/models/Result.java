package com.example.movietool.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Result {

    @JsonProperty("original_title")
    private String Movietitle;
}
