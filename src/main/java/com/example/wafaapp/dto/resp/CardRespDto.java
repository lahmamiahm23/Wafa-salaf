package com.example.wafaapp.dto.resp;
import java.time.LocalDate;

import com.example.wafaapp.entities.CardNetwork;
import com.example.wafaapp.entities.CardType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardRespDto {

    private long Id;

    private CardNetwork cardNetwork;

    private CardType cardType;

    private int CVV;


    private LocalDate expiryDate;

    private LocalDate creationDate;

//	private long accountNumber;
//
//	private String accountHolderName;

    private double maxTransferAmount;
}
