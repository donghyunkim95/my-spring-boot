package com.kitri.springbasicboot.lesson.valid.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class SignUpFormDto {

    @NotNull
    String name;
    @NotEmpty(message = "이메일 입력은 필수 입니다.")
    // 정규식, 검색해서 찾아 사용하자
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
    String email;

    @NotEmpty(message = "비밀번호 입력은 필수 입니다.")
    @Size(min = 5, message = "비밀번호는 최소 5자 이상이어야 합니다.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    String password;
    @Past
    LocalDate date;
    @NotEmpty
    String gender;

}
