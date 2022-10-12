package com.mandarinrobotics.externalorderserver.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class OriginOrderMenuDto {
    @NotBlank
    private String menuCtgrNv;

    @NotBlank
    private String menuMainNm;

    @NotNull
    private String menuOptNm;

    @NotNull
    @Min(1)
    @Max(99)
    private int itemCnt;

    @NotNull
    @Min(0)
    @Max(1)
    private int isService;

    @NotNull
    @Min(0)
    @Max(1)
    private int isPackage;

    @NotBlank
    private String orderDate;
}