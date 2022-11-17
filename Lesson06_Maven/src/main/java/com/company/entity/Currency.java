package com.company.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
public class Currency {
    transient private Integer id;

    @SerializedName("Code")
    private String code;

    @SerializedName("Ccy")
    private String ccy;

    @SerializedName("Rate")
    private String Rate;
}
