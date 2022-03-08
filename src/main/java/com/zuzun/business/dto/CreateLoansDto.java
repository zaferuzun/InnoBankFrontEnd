package com.zuzun.business.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class CreateLoansDto {

    @NotNull(message = "bu alanını boş geçemezsiniz")
    private String name;
    @NotNull(message = "bu alanını boş geçemezsiniz")
    private String surname;
    @NotNull(message = "bu alanını boş geçemezsiniz")
    @Size(min=11,max=11, message = "Geçerli bir TC no giriniz")
    @Pattern(regexp="(^$|[0-9]{11})", message = "Geçerli bir TC no giriniz")
    private String tcNo;
    @NotNull(message = "bu alanını boş geçemezsiniz")
    @Size(min=11,max=11, message = "Geçerli bir telefon numarası giriniz")
    @Pattern(regexp="(^$|[0-9]{11})", message = "Geçerli bir telefon numarası giriniz")
    private String phone;
    @NotEmpty(message = "bu alanını boş geçemezsiniz")
    private String birthday;
    @NotNull(message = "bu alanını boş geçemezsiniz")
    private Long salary;
    @NotNull(message = "bu alanını boş geçemezsiniz")
    private String type;
    @NotNull(message = "bu alanını boş geçemezsiniz")
    private int score;
    private Long mortgage;
    private String approval;



}
