package com.example.movietool.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class RequestAPIModel {
    @JsonProperty("results")
    private List<Result> AllResults;
}
